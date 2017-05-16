package com.jd.cms.dao.forAccount;

import com.jd.cms.domain.foraccount.ProductInfoAccount;

import java.util.Date;
import java.util.List;

/**
 * ����dao
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-9
 * Time: ����4:52
 * To change this template use File | Settings | File Templates.
 */
public interface ForAccountDao {

    /**
     * ��ȡ��������
     * @param id sku
     * @return
     */
    ProductInfoAccount getAccoutInfoById(int id);

    /**
     * ��ҳ��ȡ��Ʒ��Ϣ
     *
     * @param start
     * @param end
     * @param venderCode
     * @return
     */
    public List<ProductInfoAccount> queryByVenderId(int start, int end, String venderCode);


    /**
     * ���ݹ�Ӧ�̻�ȡ����
     *
     * @param venderCode
     * @return
     */
    public int queryByVenderCount(String venderCode);

    /**
     * �õ���������
     *
     * @param start
     * @param end
     * @param venderCode
     * @param beginTime
     * @return
     */
    public List<ProductInfoAccount> queryIncreamentInfo(int start, int end, String venderCode, Date beginTime);

    /**
     * �õ���������
     *
     * @param venderCode
     * @param beginTime
     * @return
     */
    public int getIncrementCount(String venderCode, Date beginTime);
}
