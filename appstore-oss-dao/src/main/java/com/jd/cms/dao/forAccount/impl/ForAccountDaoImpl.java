package com.jd.cms.dao.forAccount.impl;

import com.jd.cms.dao.forAccount.ForAccountDao;
import com.jd.cms.domain.foraccount.ProductInfoAccount;
import com.jd.common.dao.BaseDao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 结算接口实现
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-9
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
public class ForAccountDaoImpl extends BaseDao implements ForAccountDao {

    
    public ProductInfoAccount getAccoutInfoById(int id) {
        List<Object> list = queryForList("forAccountQuery.getproductInfoById", id);
        if (list.size() > 0) {
            return (ProductInfoAccount) list.get(0);
        } else {
            return null;
        }
    }


    /**
     * 分页获取商品信息
     *
     * @param start
     * @param end
     * @param venderCode
     * @return
     */
    public List<ProductInfoAccount> queryByVenderId(int start, int end, String venderCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        map.put("end", end);
        map.put("venderCode", venderCode);
        return queryForList("forAccountQuery.queryByVenderId", map);
    }

    public int queryByVenderCount(String venderCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("venderCode", venderCode);
        return (Integer) queryForObject("forAccountQuery.queryByVenderCount", map);
    }


    public List<ProductInfoAccount> queryIncreamentInfo(int start, int end, String venderCode, Date beginTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        map.put("end", end);
        map.put("venderCode", venderCode);
        map.put("beginTime", beginTime);
        return queryForList("forAccountQuery.queryIncreamentInfo", map);
    }

    public int getIncrementCount(String venderCode, Date beginTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("venderCode", venderCode);
        map.put("beginTime", beginTime);
        return (Integer) queryForObject("forAccountQuery.getIncrementCount", map);
    }
}
