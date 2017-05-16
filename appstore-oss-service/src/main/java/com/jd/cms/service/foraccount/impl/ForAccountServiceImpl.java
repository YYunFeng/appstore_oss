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
 * Time: 下午5:30
 * CopyRight:360buy
 * Descrption:
 */
public class ForAccountServiceImpl implements ForAccountService {

    /**
     * 冒号分割符
     */
    public static String SEPARATOR_COLON = ":";

    /**
     * 最大返回量*
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
     * 处理分类名称等ixnxi
     *
     * @param productId
     * @param productInforAccount
     * @return
     */
    private ProductInfoAccount nameMange(int productId, ProductInfoAccount productInforAccount) {

        if (productInforAccount != null) {
            //处理第一分类的名称
            if (null != productInforAccount.getFirstCatid()) {
                String fstCatName = categoryQueryDao.getCategoryName(productInforAccount.getFirstCatid());
                productInforAccount.setFirstCatName(fstCatName);
            }

            //处理第二分类的名称
            if (null != productInforAccount.getSndCatid()) {
                String sndCatName = categoryQueryDao.getCategoryName(productInforAccount.getSndCatid());
                productInforAccount.setSecondCatName(sndCatName);
            }

            //处理分成比例
            if (null != productInforAccount.getPercent()) {
                String rate = productInforAccount.getPercent() + SEPARATOR_COLON + (100 - productInforAccount.getPercent());
                productInforAccount.setDivide(rate);
            }
            divideMange(productInforAccount);
        }
        return productInforAccount;
    }

    /**
     * 处理分成模式：因为赵明在修改商品信息的时候没有对分成模式进行控制，导致选择一种分成模式，输入某些字段后，
     * 再次修改，输入另一些 字段，第一次输入的字段内容没有清空。这里加一个过滤，不能全部返回，否则结算那边就乱了
     *
     * @param productInforAccount
     */

    private void divideMange(ProductInfoAccount productInforAccount) {
        //处理分成模式
        if (null != productInforAccount) {
            if (productInforAccount.getDivideType() == FeeModeEnumType.BUYOUT.getCode()) {
                //买断模式，设定比例，预付款为空
                productInforAccount.setPrepayments(0);
                productInforAccount.setDivide("");
                productInforAccount.setDivideType(DivideTypeForAccountEnum.BUYOUT.getCode());
            } else if (productInforAccount.getDivideType() == FeeModeEnumType.DIVIDE_NO_PREPAY.getCode() ||
                    productInforAccount.getDivideType() == FeeModeEnumType.DIVIDE_PREPAY.getCode()) {
                // 分成模式
                productInforAccount.setBuyoutPrice(0);
                productInforAccount.setDivideType(DivideTypeForAccountEnum.DIVIDE.getCode());
            } else {

                // 免费模式
                productInforAccount.setBuyoutPrice(0);
                productInforAccount.setPrepayments(0);
                productInforAccount.setDivide("");
                productInforAccount.setDivideType(0);
            }
        }
    }

    public List<ProductInfoAccount> getProductInfoByIds(int[] ProductIds) {

        //加了一个限制：如果数据量超过500，只取500
        if (ProductIds.length > MAX_LENGTH) {
            ProductIds = ArrayUtils.subarray(ProductIds, 0, MAX_LENGTH);
            log.error("查询数据量过大，这里只返回500条数据");
        }

        //循环遍历
        List<ProductInfoAccount> lst = new ArrayList<ProductInfoAccount>();
        for (int cur_id : ProductIds) {
            ProductInfoAccount ProductInforAccount = getProductInfoById(cur_id);
            if (null == ProductInforAccount) {
                log.error("id为" + cur_id + "的记录不存在");
            } else {
                lst.add(ProductInforAccount);
            }
        }
        return lst;
    }

    public ProductPager getAllResultByPages(int pageIndex, int pageSize, String venderCode) {
        int totalItem = forAccountDao.queryByVenderCount(venderCode); //得到总的记录数量

        PaginatedList<HashMap<String, String>> examples = new PaginatedArrayList<HashMap<String, String>>(pageIndex, pageSize); //构造返回对象，主要是用在页面上显示
        int start = examples.getStartRow();
        int end = start + pageSize;
        List<ProductInfoAccount> lst_result = forAccountDao.queryByVenderId(start, end, venderCode);
        dividMmangeLst(lst_result);

        return getResult(pageIndex, pageSize, totalItem, lst_result);


    }

    /**
     * 分成列表处理
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
        //封装返回结果
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

        int totalItem = forAccountDao.getIncrementCount(venderCode, startTime); //得到总的记录数量
        PaginatedList<HashMap<String, String>> examples = new PaginatedArrayList<HashMap<String, String>>(pageIndex, pageSize); //构造返回对象，主要是用在页面上显示
        examples.setTotalItem(totalItem);
        int start = examples.getStartRow() == 0 ? 0 : examples.getStartRow() - 1;
        int end = pageSize;

        List<ProductInfoAccount> lst_result = forAccountDao.queryIncreamentInfo(start, end, venderCode, startTime);
        dividMmangeLst(lst_result);
        //封装返回结果
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
