package com.jd.cms.service.foraccount.impl;

import com.jd.appstore.domain.enumtype.DivideTypeForAccountEnum;
import com.jd.appstore.domain.enumtype.FeeModeEnumType;
import com.jd.cms.dao.category.CategoryQueryDao;
import com.jd.cms.dao.forAccount.ForAccountDao;
import com.jd.cms.domain.foraccount.ProductInfoAccount;
import com.jd.cms.domain.foraccount.ProductPager;
import com.jd.cms.service.foraccount.ForAccountService;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Package:com.jd.Product.admin.service.view.impl
 * User: yingkuohao
 * Date: 11-10-20
 * Time: ����5:30
 * CopyRight:360buy
 * Descrption:
 */
public class ForAccountServiceImpl implements ForAccountService {

    /**
     * ð�ŷָ��
     */
    public static String SEPARATOR_COLON = ":";

    /**
     * ��󷵻���*
     */
    private static final int MAX_LENGTH = 500;
    private final static Logger log = Logger.getLogger(ForAccountServiceImpl.class);

    private ForAccountDao forAccountDao;
    private CategoryQueryDao categoryQueryDao;


    public ProductInfoAccount getProductInfoById(int ProductId) {
        ProductInfoAccount ProductInforAccount = forAccountDao.getAccoutInfoById(ProductId);

        if (null != ProductInforAccount) {
            return nameMange(ProductId, ProductInforAccount);
        }
        return new ProductInfoAccount();
    }

    /**
     * ����������Ƶ�ixnxi
     *
     * @param productId
     * @param productInforAccount
     * @return
     */
    private ProductInfoAccount nameMange(int productId, ProductInfoAccount productInforAccount) {

        if (productInforAccount != null) {
            //�����һ���������
            if (null != productInforAccount.getFirstCatid()) {
                String fstCatName = categoryQueryDao.getCategoryName(productInforAccount.getFirstCatid());
                productInforAccount.setFirstCatName(fstCatName);
            }

            //����ڶ����������
            if (null != productInforAccount.getSndCatid()) {
                String sndCatName = categoryQueryDao.getCategoryName(productInforAccount.getSndCatid());
                productInforAccount.setSecondCatName(sndCatName);
            }

            //����ֳɱ���
            if (null != productInforAccount.getPercent()) {
                String rate = productInforAccount.getPercent() + SEPARATOR_COLON + (100 - productInforAccount.getPercent());
                productInforAccount.setDivide(rate);
            }
            divideMange(productInforAccount);
        }
        return productInforAccount;
    }

    /**
     * ����ֳ�ģʽ����Ϊ�������޸���Ʒ��Ϣ��ʱ��û�жԷֳ�ģʽ���п��ƣ�����ѡ��һ�ֳַ�ģʽ������ĳЩ�ֶκ�
     * �ٴ��޸ģ�������һЩ �ֶΣ���һ��������ֶ�����û����ա������һ�����ˣ�����ȫ�����أ���������Ǳ߾�����
     *
     * @param productInforAccount
     */

    private void divideMange(ProductInfoAccount productInforAccount) {
        //����ֳ�ģʽ
        if (null != productInforAccount) {
            if (productInforAccount.getDivideType() == FeeModeEnumType.BUYOUT.getCode()) {
                //���ģʽ���趨������Ԥ����Ϊ��
                productInforAccount.setPrepayments(0);
                productInforAccount.setDivide("");
                productInforAccount.setDivideType(DivideTypeForAccountEnum.BUYOUT.getCode());
            } else if (productInforAccount.getDivideType() == FeeModeEnumType.DIVIDE_NO_PREPAY.getCode() ||
                    productInforAccount.getDivideType() == FeeModeEnumType.DIVIDE_PREPAY.getCode()) {
                // �ֳ�ģʽ
                productInforAccount.setBuyoutPrice(0);
                productInforAccount.setDivideType(DivideTypeForAccountEnum.DIVIDE.getCode());
            } else {

                // ���ģʽ
                productInforAccount.setBuyoutPrice(0);
                productInforAccount.setPrepayments(0);
                productInforAccount.setDivide("");
                productInforAccount.setDivideType(0);
            }
        }
    }

    public List<ProductInfoAccount> getProductInfoByIds(int[] ProductIds) {

        //����һ�����ƣ��������������500��ֻȡ500
        if (ProductIds.length > MAX_LENGTH) {
            ProductIds = ArrayUtils.subarray(ProductIds, 0, MAX_LENGTH);
            log.error("��ѯ��������������ֻ����500������");
        }

        //ѭ������
        List<ProductInfoAccount> lst = new ArrayList<ProductInfoAccount>();
        for (int cur_id : ProductIds) {
            ProductInfoAccount ProductInforAccount = getProductInfoById(cur_id);
            if (null == ProductInforAccount) {
                log.error("idΪ" + cur_id + "�ļ�¼������");
            } else {
                lst.add(ProductInforAccount);
            }
        }
        return lst;
    }

    public ProductPager getAllResultByPages(int pageIndex, int pageSize, String venderCode) {
        int totalItem = forAccountDao.queryByVenderCount(venderCode); //�õ��ܵļ�¼����

        PaginatedList<HashMap<String, String>> examples = new PaginatedArrayList<HashMap<String, String>>(pageIndex, pageSize); //���췵�ض�����Ҫ������ҳ������ʾ
        int start = examples.getStartRow();
        int end = start + pageSize;
        List<ProductInfoAccount> lst_result = forAccountDao.queryByVenderId(start, end, venderCode);
        dividMmangeLst(lst_result);

        return getResult(pageIndex, pageSize, totalItem, lst_result);


    }

    /**
     * �ֳ��б���
     *
     * @param lst_result
     */
    private void dividMmangeLst(List<ProductInfoAccount> lst_result) {
        for (ProductInfoAccount ProductInforAccount_cur : lst_result) {
            if (null != ProductInforAccount_cur && ProductInforAccount_cur.getId() != null) {
                nameMange(Integer.valueOf(ProductInforAccount_cur.getId()), ProductInforAccount_cur);
            }
        }
    }

    private ProductPager getResult(int pageIndex, int pageSize, int totalItem, List<ProductInfoAccount> lst_result) {
        //��װ���ؽ��
        ProductPager ProductPager = new ProductPager();
        ProductPager.setPageSize(pageSize);
        int totalPage = (int) Math.ceil(totalItem * 1.0 / pageSize);
        ProductPager.setTotalPage(totalPage);
        ProductPager.setCurrentPage(pageIndex > totalPage ? totalPage : pageIndex <= 0 ? 1 : pageIndex);
        ProductPager.setLst_eqinfo(lst_result);
        ProductPager.setTotalItem(totalItem);
        return ProductPager;
    }

    public ProductPager getAllIncrementResultByPages(int pageIndex, int pageSize, String venderCode, Date startTime) {

        int totalItem = forAccountDao.getIncrementCount(venderCode, startTime); //�õ��ܵļ�¼����
        PaginatedList<HashMap<String, String>> examples = new PaginatedArrayList<HashMap<String, String>>(pageIndex, pageSize); //���췵�ض�����Ҫ������ҳ������ʾ
        examples.setTotalItem(totalItem);
        int start = examples.getStartRow() == 0 ? 0 : examples.getStartRow() - 1;
        int end = pageSize;

        List<ProductInfoAccount> lst_result = forAccountDao.queryIncreamentInfo(start, end, venderCode, startTime);
        dividMmangeLst(lst_result);
        //��װ���ؽ��
        return getResult(pageIndex, pageSize, totalItem, lst_result);

    }


    public ForAccountDao getForAccountDao() {
        return forAccountDao;
    }

    public void setForAccountDao(ForAccountDao forAccountDao) {
        this.forAccountDao = forAccountDao;
    }

    public CategoryQueryDao getCategoryQueryDao() {
        return categoryQueryDao;
    }

    public void setCategoryQueryDao(CategoryQueryDao categoryQueryDao) {
        this.categoryQueryDao = categoryQueryDao;
    }

    
}
