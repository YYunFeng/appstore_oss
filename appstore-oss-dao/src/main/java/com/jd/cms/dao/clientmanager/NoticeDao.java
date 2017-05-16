package com.jd.cms.dao.clientmanager;

import com.jd.appstore.domain.WebsiteNotice;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-25
 * Time: 下午8:45
 * To change this template use File | Settings | File Templates.
 */
public interface NoticeDao {
    /**
     * 查询资讯内容
     * @param query
     * @return
     */
    List<WebsiteNotice> findNotice(Query query);

    /**
     * 根据发布状态检索资讯内容
     */
    List<WebsiteNotice> findNoticeByPub(Query query);

    /*
     * 根据Id查询资讯
     */
    List<WebsiteNotice> findNoticeById(WebsiteNotice notice);

    /**
     * 计算数据库中的资讯条数
     * @return
     */
    int getNoticeCount();

    /**
     * 查询此发布状态下的资讯数
     */
    int getNoticeCountByPub(Query query);

    /**
     * 更新资讯的上下线状态
     * @param notice
     */
    void updateNoticePubedStatus(WebsiteNotice notice);

    /**
     * 查询此排位上是否存在资讯内容
     * @param notice
     * @return
     */
    int findNoticeBySeq(WebsiteNotice notice);

    /**
     * 删除某条资讯
     * @param notice
     */
    void deleteNotice(WebsiteNotice notice);

    /**
     * 更新资讯的排序位置
     * @param notice
     */
    void updateNoticeSeq(WebsiteNotice notice);

    /**
     * 添加资讯时更新其他资讯的排序
     * @param notice
     */
    void updateAddNoticeSeq(WebsiteNotice notice);

    /**
     * 删除资讯时更新其他资讯的排序值
     * @param notice
     */
    void updateDelNoticeSeq(WebsiteNotice notice);

    /*
     * 创建一条资讯
     */
    void createNotice(WebsiteNotice notice);

    /*
     * 更新资讯信息
     */
    void updateNotice(WebsiteNotice notice);
}
