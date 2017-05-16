package com.jd.cms.domain.foraccount;

import java.util.List;

/**
 * Package:com.jd.ebook.admin.domain.view
 * User: yingkuohao
 * Date: 11-10-18
 * Time: ����1:50
 * CopyRight:360buy
 * Descrption:  ebookquery����ҳ����
 */
public class ProductPager {
    //==========��ѯ����========
    //ÿҳ��ʾ���� Ĭ��ҳ���С20
    private int pageSize = 40;
    //��ǰҳ�� Ĭ���ǵ�һҳ
    private int currentPage = 1;
    //����ʽ  Ĭ�ϰ���ƷID��������
    private int orderBy = 1;//����ֵ:0:orderid asc,1:cretedtime asc,3:createdtime desc,4:modified_asc,5:modified_desc
    //==========���========
    //��ҳ��
    private int totalPage;
    //�����б�
    private List<ProductInfoAccount> lst_eqinfo;

    private int totalItem;

    public ProductPager() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ProductInfoAccount> getLst_eqinfo() {
        return lst_eqinfo;
    }

    public void setLst_eqinfo(List<ProductInfoAccount> lst_eqinfo) {
        this.lst_eqinfo = lst_eqinfo;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }
}
