package com.jd.cms.dao.forAccount;

import com.jd.cms.domain.foraccount.ProductInfoAccount;

import java.util.Date;
import java.util.List;

/**
 * 结算dao
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-9
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */
public interface ForAccountDao {

    /**
     * 获取结算内容
     * @param id sku
     * @return
     */
    ProductInfoAccount getAccoutInfoById(int id);

    /**
     * 分页获取商品信息
     *
     * @param start
     * @param end
     * @param venderCode
     * @return
     */
    public List<ProductInfoAccount> queryByVenderId(int start, int end, String venderCode);


    /**
     * 根据供应商获取数量
     *
     * @param venderCode
     * @return
     */
    public int queryByVenderCount(String venderCode);

    /**
     * 得到增量数据
     *
     * @param start
     * @param end
     * @param venderCode
     * @param beginTime
     * @return
     */
    public List<ProductInfoAccount> queryIncreamentInfo(int start, int end, String venderCode, Date beginTime);

    /**
     * 得到增量数据
     *
     * @param venderCode
     * @param beginTime
     * @return
     */
    public int getIncrementCount(String venderCode, Date beginTime);
}
