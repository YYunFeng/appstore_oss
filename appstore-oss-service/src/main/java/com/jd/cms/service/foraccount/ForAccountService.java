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
 * Time: 下午5:30
 * CopyRight:360buy
 * Descrption:   为结算提供的webservice
 */
@WebService
public interface ForAccountService {
    /**
     * 通过商品id得到商品信息
     *
     * @param productId
     * @return
     */
    public ProductInfoAccount getProductInfoById(int productId);

    /**
     * 通过商品id批量得到商品信息，最多返回500条
     *
     * @param productIds
     * @return
     */
    public List<ProductInfoAccount> getProductInfoByIds(int[] productIds);


    /* *
     * 分页获取所有的商品信息  ,
     *
     * @param pageIndex 当前页
     * @param pageSize  分页大小
     * @param pageSize  供应商简码
     * @return
       **/
    public ProductPager getAllResultByPages(int pageIndex, int pageSize, String venderCode);


      /**
       * 通过供应商简码和开始时间获取增量数据
       * @param pageIndex
       * @param pageSize
       * @param venderCode
       * @param startTime   开始时间：对应上柜开始时间
       * @return
       */
      public ProductPager getAllIncrementResultByPages(int pageIndex, int pageSize, String venderCode, Date startTime);


  }
