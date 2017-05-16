package com.jd.cms.dao.appManagement;

import com.jd.cms.domain.appManagement.AppCountParameter;
import com.jd.cms.domain.appManagement.AppCountResult;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-17.
 */
public interface AppCountsDao {

    /**
     * 按CP名称获取应用安装数量
     *
     * @param appCountParameter
     * @return
     */
    List<AppCountResult> getInstallAppsByCp(AppCountParameter appCountParameter);

    /**
     * 按CP获取应用的到达量
     *
     * @param appCountParameter
     * @return
     */
    List<AppCountResult> getCountAppsByCp(AppCountParameter appCountParameter);


    Integer getCountAppsByCpCounts(AppCountParameter appCountParameter);

    /**
     * 某个CP的应用安装量
     *
     * @param appCountParameter
     * @return
     */
    List<AppCountResult> getInstallAppByApp(AppCountParameter appCountParameter);

    /**
     * 某个CP的应用到达量
     *
     * @param appCountParameter
     * @return
     */
    List<AppCountResult> getCountAppsByApp(AppCountParameter appCountParameter);


    Integer getCountAppByAppCounts(AppCountParameter appCountParameter);





    List<AppCountResult> appsCountPhoneImei(AppCountParameter appCountParameter);

    Integer appsCountPhoneImeiCounts(AppCountParameter appCountParameter);
}
