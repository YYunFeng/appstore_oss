package com.jd.cms.service.schedule;


import java.io.IOException;

/**
 * 生成每日报表
 * User: YUNFENG
 * Date: 13-9-27
 * Time: 上午10:12
 * To change this template use File | Settings | File Templates.
 */
public interface DailyReportService {

    void CreateDailyReport() throws IOException;
}
