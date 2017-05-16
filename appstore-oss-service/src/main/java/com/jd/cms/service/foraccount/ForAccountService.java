package com.jd.cms.service.foraccount;

import com.jd.cms.domain.foraccount.ProductInfoAccount;
import com.jd.cms.domain.foraccount.ProductPager;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

/**
 * Package:com.jd.ebook.admin.service.view
 * User: yingkuohao
 * Date: 11-10-20
 * Time: ����5:30
 * CopyRight:360buy
 * Descrption:   Ϊ�����ṩ��webservice
 */
@WebService
public interface ForAccountService {
    /**
     * ͨ����Ʒid�õ���Ʒ��Ϣ
     *
     * @param productId
     * @return
     */
    public ProductInfoAccount getProductInfoById(int productId);

    /**
     * ͨ����Ʒid�����õ���Ʒ��Ϣ����෵��500��
     *
     * @param productIds
     * @return
     */
    public List<ProductInfoAccount> getProductInfoByIds(int[] productIds);


    /* *
     * ��ҳ��ȡ���е���Ʒ��Ϣ  ,
     *
     * @param pageIndex ��ǰҳ
     * @param pageSize  ��ҳ��С
     * @param pageSize  ��Ӧ�̼���
     * @return
       **/
    public ProductPager getAllResultByPages(int pageIndex, int pageSize, String venderCode);


      /**
       * ͨ����Ӧ�̼���Ϳ�ʼʱ���ȡ��������
       * @param pageIndex
       * @param pageSize
       * @param venderCode
       * @param startTime   ��ʼʱ�䣺��Ӧ�Ϲ�ʼʱ��
       * @return
       */
      public ProductPager getAllIncrementResultByPages(int pageIndex, int pageSize, String venderCode, Date startTime);


  }
