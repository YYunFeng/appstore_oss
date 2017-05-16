package com.jd.cms.service.appManagement.impl;

import com.jd.appstore.domain.CpBaseInfo;
import com.jd.appstore.domain.PicResolutionEnum;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.ChangeCpInput;
import com.jd.cms.domain.appManagement.StatusJSON;
import com.jd.cms.manager.appManagement.AppBrowseManager;
import com.jd.cms.service.appManagement.AppBrowseService;
import com.jd.common.util.StringEscapeUtils;
import com.jd.common.web.result.Result;
import com.jd.digital.common.rpc.manager.comment.CommentManager;
import com.jd.digital.common.rpc.manager.jss.JssAppManager;
import com.sun.mail.imap.protocol.Status;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 应用浏览serviceImpl
 */
public class AppBrowseServiceImpl implements AppBrowseService {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(AppBrowseServiceImpl.class);
    /**
     * managerCached注入
     */
    private AppBrowseManager appBrowseManagerCached;
    /**
     * 评论接口
     */
    private CommentManager commentManager;
    /**
     * jss云存储接口
     */
    private JssAppManager jssAppManager;
    /**
     * 手机软件id
     */
    private String mobileSoftId;
    /**
     * 手机游戏id
     */
    private String mobileGameId;
    /**
     * WEB应用id
     */
    private String webAppId;

    /**
     * 取得移动游戏,软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return Result
     */
    public Result findAppBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            /*取得移动游戏,软件的信息集合*/
            result.addDefaultModel("AppPageOutputs", appBrowseManagerCached.findAppBrowsePage(appPageInput, pageIndex, pageSize));
            /*取得应用级别为3的类目集合*/
            result.addDefaultModel("Category3", appBrowseManagerCached.findCategory(appPageInput.getCategoryidl2()));
            /*主图图片路径*/
            result.addDefaultModel("COVER_N4", PicResolutionEnum.COVER_N4.getPrefix());
            /*截图图片路径*/
            result.addDefaultModel("IMG_N4", PicResolutionEnum.IMG_N4.getPrefix());
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("取得移动游戏,软件的信息集合 appPageInput=" + appPageInput + " pageIndex=" + pageIndex + " pageSize=" + pageSize + " error!", e);
        }
        return result;
    }

    /**
     * 取得网页软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return Result
     */
    public Result findAppWebBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            /*取得网页软件的信息集合*/
            result.addDefaultModel("AppPageOutputs", appBrowseManagerCached.findAppWebBrowsePage(appPageInput, pageIndex, pageSize));
            /*取得应用级别为3的类目集合*/
            result.addDefaultModel("Category3", appBrowseManagerCached.findCategory(appPageInput.getCategoryidl2()));
            /*图片路径*/
            result.addDefaultModel("COVER_N4", PicResolutionEnum.COVER_N4.getPrefix());
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("取得网页软件的信息集合 appPageInput=" + appPageInput + " pageIndex=" + pageIndex + " pageSize=" + pageSize + " error!", e);
        }
        return result;
    }

    /**
     * 批量上下架操作
     *
     * @param appPageInput
     * @return int
     */
    public int upAppOnline(AppPageInput appPageInput) {
        int isSuccess = -1;
        try {
            isSuccess = appBrowseManagerCached.upAppOnline(appPageInput);
        } catch (Exception e) {
            log.error("保存应用和详情 appPageInput=" + appPageInput + " error!", e);
        }
        return isSuccess;
    }

    /**
     * 单个上下架操作
     *
     * @param appPageInput
     * @return int
     */
    public int upAppOnlineById(AppPageInput appPageInput) {
        int isSuccess = -1;
        try {
            isSuccess = appBrowseManagerCached.upAppOnlineById(appPageInput);
        } catch (Exception e) {
            log.error("保存应用和详情 appPageInput=" + appPageInput + " error!", e);
        }
        return isSuccess;
    }

    /**
     * 详情上下架修改
     *
     * @param appPageInput
     * @return Result
     */
    public Result upAppDetailsOnline(AppPageInput appPageInput) {
        Result result = new Result();
        try {
            int isSuccess = appBrowseManagerCached.upAppDetailsOnline(appPageInput);
            if (0 != isSuccess) {
                result.addDefaultModel("info", "详情上下架修改成功");
            } else {
                result.addDefaultModel("info", "详情上下架修改失败");
            }
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("详情上下架修改 appPageInput=" + appPageInput + " error!", e);
        }
        return result;
    }

    /**
     * 更改默认详情
     *
     * @param appPageInput
     * @return int
     */
    public int upAppDefaultDetaild(AppPageInput appPageInput) {
        int mark = 0;
        try {
            int isSuccess = appBrowseManagerCached.upAppDefaultDetaild(appPageInput);
            if (0 != isSuccess) {
                mark = 1;
            }
        } catch (Exception e) {
            log.error("更改默认详情 appPageInput=" + appPageInput + " error!", e);
        }
        return mark;
    }

    /**
     * 保存应用和详情
     *
     * @param appPageInput
     * @return int
     */
    public int saveAppAndDetailInformation(AppPageInput appPageInput) {
        int isSuccess = -1;
        try {
            String intro = appPageInput.getAppIntroduce();
            if (intro != null) {
                intro = intro.replaceAll("<br>", "\n");
            }
            intro = StringEscapeUtils.escapeHtml(intro);
            appPageInput.setAppIntroduce(intro);
            isSuccess = appBrowseManagerCached.saveAppAndDetailInformation(appPageInput);
        } catch (Exception e) {
            log.error("保存应用和详情 appPageInput=" + appPageInput + " error!", e);
        }
        return isSuccess;
    }

    /**
     * 取得tonken
     *
     * @param url
     * @return String
     */
    public String getToken(String url) {
        String newResUrl = null;
        try {
            /*取得token*/
            String str = jssAppManager.getToken();
            /*下载地址+token*/
            newResUrl = url + "?token=" + str;
        } catch (Exception e) {
            log.error("取得tonken url=" + url + " error!", e);
        }
        return newResUrl;
    }

    public StatusJSON chageCp(ChangeCpInput changeCpInput) {
        StatusJSON statusJSON = new StatusJSON();
        try {
            appBrowseManagerCached.chageCp(changeCpInput);
            statusJSON.setStatus(0);
            statusJSON.setMess("成功");
        } catch (Exception e) {
            e.printStackTrace();
            statusJSON.setStatus(1);
            statusJSON.setMess("系统异常，请重试");
        }
        return statusJSON;
    }

    /**
     * 浏览-默认详情浏览
     *
     * @param appPageInput
     * @return Result
     */
    public Result findAppDetailsFormal(AppPageInput appPageInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("mobileSoftId", mobileSoftId);
            result.addDefaultModel("mobileGameId", mobileGameId);
            result.addDefaultModel("webAppId", webAppId);
            /*主图图片路径*/
            result.addDefaultModel("COVER_N1", PicResolutionEnum.COVER_N1.getPrefix());
            /*截图图片路径*/
            result.addDefaultModel("IMG_N1", PicResolutionEnum.IMG_N1.getPrefix());
            /*默认详情*/
            AppPageOutput appPageOutput = appBrowseManagerCached.findAppDetailsFormal(appPageInput);
            String intro = appPageOutput.getAppIntroduce();
            if (intro != null) {
                intro = intro.replaceAll("\n", "<br>");
            }

            appPageOutput.setAppIntroduce(intro);
            /*处理软件包大小*/
            if (null != appPageOutput.getPkgSize()) {
                    /*得到应用大小的字节数*/
                int pkgSize = appPageOutput.getPkgSize();
                    /*如果小于1MB显示为KB*/
                if (pkgSize / 1024 < 1024) {
                    appPageOutput.setPkgSizeB(pkgSize / 1024 + "KB");
                } else {
                        /*格式化结果，保留2位小数*/
                    String Fstr = String.format("%.2f", pkgSize / 1024.00 / 1024.00);
                    appPageOutput.setPkgSizeB(Fstr + "MB");
                }
            }
            result.addDefaultModel("AppPageOutput", appPageOutput);
            /*取得应用级别为3的类目集合*/
            result.addDefaultModel("Category3", appBrowseManagerCached.findCategory(appPageOutput.getCategoryidl2()));
            /*CP应用对应的截图集合*/
            result.addDefaultModel("Pictures", appBrowseManagerCached.findPicture(appPageInput));
            /*取得一对多详情的CpName集合*/
            result.addDefaultModel("CpNames", appBrowseManagerCached.getCpNameCount(appPageInput));
         /*   *//*取得评论信息*//*
            result.addDefaultModel("CommentSummaryBo",commentManager.queryProductSummary(String.valueOf(appPageInput.getAppid())));*/
            /*查找对应的平台名*/
            if (appPageOutput.getAppType() == 0 || appPageOutput.getAppType() == 1 || appPageOutput.getAppType() == 2) {
                result.addDefaultModel("AndroidAppOsversion", appBrowseManagerCached.findOsVersion(appPageOutput.getOsVersionId()));
            }
            /*取得下载次数*/
            Integer num = appBrowseManagerCached.findAppDownloadCount(appPageInput.getAppid());
            /*为空下载次数为0*/
            if (null == num) {
                num = 0;
            }
            result.addDefaultModel("DownloadCount", num);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("浏览-默认详情浏览 appPageInput=" + appPageInput + " error!", e);
        }
        return result;
    }

    /**
     * 浏览-通过CpName查找详情
     *
     * @param appPageInput
     * @return Result
     */
    public Result findAppDetailsFormalByCp(AppPageInput appPageInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("mobileSoftId", mobileSoftId);
            result.addDefaultModel("mobileGameId", mobileGameId);
            result.addDefaultModel("webAppId", webAppId);
            /*主图图片路径*/
            result.addDefaultModel("COVER_N1", PicResolutionEnum.COVER_N1.getPrefix());
            /*截图图片路径*/
            result.addDefaultModel("IMG_N1", PicResolutionEnum.IMG_N1.getPrefix());
            /*默认详情*/
            AppPageOutput appPageOutput = appBrowseManagerCached.findAppDetailsFormalByCp(appPageInput);
            String intro = appPageOutput.getAppIntroduce();
            if (intro != null)
                intro = intro.replaceAll("\n", "<br>");
            appPageOutput.setAppIntroduce(intro);
            /*处理软件包大小*/
            if (null != appPageOutput.getPkgSize()) {
                    /*得到应用大小的字节数*/
                int pkgSize = appPageOutput.getPkgSize();
                    /*如果小于1MB显示为KB*/
                if (pkgSize / 1024 < 1024) {
                    appPageOutput.setPkgSizeB(pkgSize / 1024 + "KB");
                } else {
                        /*格式化结果，保留2位小数*/
                    String Fstr = String.format("%.2f", pkgSize / 1024.00 / 1024.00);
                    appPageOutput.setPkgSizeB(Fstr + "MB");
                }
            }
            result.addDefaultModel("AppPageOutput", appPageOutput);
            /*取得应用级别为3的类目集合*/
            result.addDefaultModel("Category3", appBrowseManagerCached.findCategory(appPageOutput.getCategoryidl2()));
            appPageInput.setAccountid(appPageOutput.getAccountid());
            /*CP应用对应的截图集合*/
            result.addDefaultModel("Pictures", appBrowseManagerCached.findPicture(appPageInput));
            /*取得一对多详情的CpName集合*/
            result.addDefaultModel("CpNames", appBrowseManagerCached.getCpNameCount(appPageInput));
     /*       *//*取得评论信息*//*
            result.addDefaultModel("CommentSummaryBo",commentManager.queryProductSummary(String.valueOf(appPageInput.getAppid())));*/
            /*查找对应的平台名*/
            if (appPageOutput.getAppType() == 0 || appPageOutput.getAppType() == 1 || appPageOutput.getAppType() == 2) {
                result.addDefaultModel("AndroidAppOsversion", appBrowseManagerCached.findOsVersion(appPageOutput.getOsVersionId()));
            }
            /*取得下载次数*/
            Integer num = appBrowseManagerCached.findAppDownloadCount(appPageInput.getAppid());
            if (null == num) {
                num = 0;
            }
            result.addDefaultModel("DownloadCount", num);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("浏览-通过CpName查找详情 appPageInput=" + appPageInput + " error!", e);
        }
        return result;
    }

    /**
     * 编辑-默认详情浏览
     *
     * @param appPageInput
     * @return Result
     */
    public Result findAppDetailsFormalEdit(AppPageInput appPageInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("mobileSoftId", mobileSoftId);
            result.addDefaultModel("mobileGameId", mobileGameId);
            result.addDefaultModel("webAppId", webAppId);
                /*主图图片路径*/
            result.addDefaultModel("COVER_N4", PicResolutionEnum.COVER_N4.getPrefix());
                /*截图图片路径*/
            result.addDefaultModel("IMG_N1", PicResolutionEnum.IMG_N1.getPrefix());
            result.addDefaultModel("IMG_N4", PicResolutionEnum.IMG_N4.getPrefix());
                /*CP应用对应的截图集合*/
            result.addDefaultModel("Pictures", appBrowseManagerCached.findPicture(appPageInput));
                /*默认详情浏览*/
            AppPageOutput appPageOutput = appBrowseManagerCached.findAppDetailsFormalEdit(appPageInput);
                /*处理软件包大小*/
            if (null != appPageOutput.getPkgSize()) {
                    /*得到应用大小的字节数*/
                int pkgSize = appPageOutput.getPkgSize();
                    /*如果小于1MB显示为KB*/
                if (pkgSize / 1024 < 1024) {
                    appPageOutput.setPkgSizeB(pkgSize / 1024 + "KB");
                } else {
                        /*格式化结果，保留2位小数*/
                    String Fstr = String.format("%.2f", pkgSize / 1024.00 / 1024.00);
                    appPageOutput.setPkgSizeB(Fstr + "MB");
                }
            }
            result.addDefaultModel("AppPageOutput", appPageOutput);
                /*取得一对多详情的CpName集合*/
            result.addDefaultModel("CpNames", appBrowseManagerCached.getCpNameCount(appPageInput));
                /*取得应用级别为3的类目集合*/
            result.addDefaultModel("Category3", appBrowseManagerCached.findCategory(appPageOutput.getCategoryidl2()));
                /*查找对应的平台名*/
            if (appPageOutput.getAppType() == 0 || appPageOutput.getAppType() == 1 || appPageOutput.getAppType() == 2) {
                result.addDefaultModel("AndroidAppOsversion", appBrowseManagerCached.findOsVersion(appPageOutput.getOsVersionId()));
            }
            result.addDefaultModel("cpList", appBrowseManagerCached.getCpList());
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("编辑-默认详情浏览 appPageInput=" + appPageInput + " error!", e);
        }
        return result;
    }

    /**
     * 编辑-通过CpName查找详情
     *
     * @param appPageInput
     * @return Result
     */
    public Result findAppDetailsFormalEditByCp(AppPageInput appPageInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("mobileSoftId", mobileSoftId);
            result.addDefaultModel("mobileGameId", mobileGameId);
            result.addDefaultModel("webAppId", webAppId);
                /*主图图片路径*/
            result.addDefaultModel("COVER_N4", PicResolutionEnum.COVER_N4.getPrefix());
                /*截图图片路径*/
            result.addDefaultModel("IMG_N1", PicResolutionEnum.IMG_N1.getPrefix());
            result.addDefaultModel("IMG_N4", PicResolutionEnum.IMG_N4.getPrefix());
                /*通过CpName查找详情*/
            AppPageOutput appPageOutput = appBrowseManagerCached.findAppDetailsFormalEditByCp(appPageInput);
                /*处理软件包大小*/
            if (null != appPageOutput.getPkgSize()) {
                    /*得到应用大小的字节数*/
                int pkgSize = appPageOutput.getPkgSize();
                    /*如果小于1MB显示为KB*/
                if (pkgSize / 1024 < 1024) {
                    appPageOutput.setPkgSizeB(pkgSize / 1024 + "KB");
                } else {
                        /*格式化结果，保留2位小数*/
                    String Fstr = String.format("%.2f", pkgSize / 1024.00 / 1024.00);
                    appPageOutput.setPkgSizeB(Fstr + "MB");
                }
            }
            result.addDefaultModel("AppPageOutput", appPageOutput);
            appPageInput.setAccountid(appPageOutput.getAccountid());
                /*CP应用对应的截图集合*/
            result.addDefaultModel("Pictures", appBrowseManagerCached.findPicture(appPageInput));
                /*取得一对多详情的CpName集合*/
            result.addDefaultModel("CpNames", appBrowseManagerCached.getCpNameCount(appPageInput));
                /*取得应用级别为3的类目集合*/
            result.addDefaultModel("Category3", appBrowseManagerCached.findCategory(appPageOutput.getCategoryidl2()));
                /*查找对应的平台名*/
            if (appPageOutput.getAppType() == 0 || appPageOutput.getAppType() == 1 || appPageOutput.getAppType() == 2) {
                result.addDefaultModel("AndroidAppOsversion", appBrowseManagerCached.findOsVersion(appPageOutput.getOsVersionId()));
            }
            result.addDefaultModel("cpList", appBrowseManagerCached.getCpList());
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("编辑-通过CpName查找详情 appPageInput=" + appPageInput + " error!", e);
        }
        return result;
    }

    public JssAppManager getJssAppManager() {
        return jssAppManager;
    }

    public void setJssAppManager(JssAppManager jssAppManager) {
        this.jssAppManager = jssAppManager;
    }

    public CommentManager getCommentManager() {
        return commentManager;
    }

    public void setCommentManager(CommentManager commentManager) {
        this.commentManager = commentManager;
    }

    public AppBrowseManager getAppBrowseManagerCached() {
        return appBrowseManagerCached;
    }

    public void setAppBrowseManagerCached(AppBrowseManager appBrowseManagerCached) {
        this.appBrowseManagerCached = appBrowseManagerCached;
    }

    public void setMobileSoftId(String mobileSoftId) {
        this.mobileSoftId = mobileSoftId;
    }

    public void setMobileGameId(String mobileGameId) {
        this.mobileGameId = mobileGameId;
    }

    public void setWebAppId(String webAppId) {
        this.webAppId = webAppId;
    }
}
