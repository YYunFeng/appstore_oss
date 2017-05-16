package com.jd.cms.service.terminalManagement.impl;

import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.manager.terminalManagement.OsManager;
import com.jd.cms.service.terminalManagement.OsService;
import com.jd.common.web.result.Result;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 平台管理serviceImpl
 */
public class OsServiceImpl implements OsService {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(OsServiceImpl.class);
    /**
     * managerCached注入
     */
    private OsManager osManagerCached;
    /**
     * 取得平台信息集合
     * @param pageIndex,pageSize
     * @return Result
     */
    public Result findOsPage(int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("TerminalpageOutputs", osManagerCached.findOsPage(pageIndex, pageSize));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("取得平台信息集合 pageIndex="+pageIndex+" pageSize="+pageSize+" error!", e);
        }
        return result;
    }
    /**
     * 创建平台信息
     * @param terminalInsertInput
     * @return Result
     */
    public Result createOs(TerminalInsertInput terminalInsertInput) {
        Result result = new Result();
        try {
            osManagerCached.createOs(terminalInsertInput);
            result.addDefaultModel("terminalInsertInput", terminalInsertInput);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("创建平台信息 terminalInsertInput="+terminalInsertInput+"error!", e);
            result.setResultCode("createOs.error");
        }
        return result;
    }
    /**
     * 更新平台上下架状态
     * @param terminalpageInput
     * @return Result
     */
    public Result upOsOnline(TerminalpageInput terminalpageInput) {
        Result result = new Result();
        try{
          int  isSuccess=osManagerCached.upOsOnline(terminalpageInput);
          if(0!=isSuccess){
            result.addDefaultModel("info", "更新平台上下架状态成功");
          }else{
            result.addDefaultModel("info", "更新平台上下架状态失败");
          }
            result.setSuccess(true);
        }catch(Exception e){
            log.error("更新平台上下架状态 terminalpageInput="+terminalpageInput+" error!",e);
        }
        return result;
    }
    /**
     * 删除平台信息
     * @param terminalpageInput
     * @return Result
     */
    public Result delOs(TerminalpageInput terminalpageInput) {
        Result result = new Result();
        try{
          int  isSuccess=osManagerCached.delOs(terminalpageInput);
          if(0!=isSuccess){
            result.addDefaultModel("info", "删除平台信息成功");
          }else{
            result.addDefaultModel("info", "删除平台信息失败");
          }
            result.setSuccess(true);
        }catch(Exception e){
            log.error("删除平台信息 terminalpageInput="+terminalpageInput+" error!",e);
        }
        return result;
    }
    /**
     * 根据ID查询单条平台信息
     * @param id
     * @return Result
     */
    public Result findOsById(int id) {
        Result result = new Result();
        try {
            result.addDefaultModel("TerminalpageOutput",osManagerCached.findOsById(id));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("根据ID查询单条平台信息 id="+id+" error!", e);
        }
        return result;
    }
    /**
     * 更新平台信息
     * @param terminalpageInput
     * @return Result
     */
    public Result upOs(TerminalpageInput terminalpageInput) {
        Result result = new Result();
        int  isSuccess = 0;
        try{
          String Checkname = osManagerCached.checkOsName(terminalpageInput.getOsVersionName());
          if(null == Checkname || terminalpageInput.getOsVersionName().equalsIgnoreCase(terminalpageInput.getOriginalName())){
            isSuccess=osManagerCached.upOs(terminalpageInput);
          }
          if(0!=isSuccess){
            result.addDefaultModel("info", "更新平台信息成功");
          }else{
            result.addDefaultModel("info", "更新平台信息失败");
          }
            result.setSuccess(true);
        }catch(Exception e){
            log.error("更新平台信息 terminalpageInput="+terminalpageInput+" error!",e);
        }
        return result;
    }
    /**
     * 检查平台版本名
     * @param name
     * @return String
     */
    public String checkOsName(String name) {
        /*创建检查是否存在标记*/
        String check = null;
        try{
          String Checkname = osManagerCached.checkOsName(name);
          if(null == Checkname){
          /*数据库不存在，可以创建*/
            check = "yes";
          }else{
          /*数据库不存在，不可以创建*/
            check = "no";
          }
        }catch(Exception e){
            log.error("检查平台版本名 name="+name+" error!",e);
        }
        return check;
    }
    /**
     * 检查平台版本码
     * @param code
     * @return String
     */
    public String checkOsCode(int code) {
        /*创建检查是否存在标记*/
        String check = null;
        try{
          Integer CheckCode = osManagerCached.checkOsCode(code);
          if(null == CheckCode){
          /*数据库不存在，可以创建*/
            check = "yes";
          }else{
          /*数据库不存在，不可以创建*/
            check = "no";
          }
        }catch(Exception e){
            log.error("检查平台版本码 code="+code+" error!",e);
        }
        return check;
    }

    public OsManager getOsManagerCached() {
        return osManagerCached;
    }

    public void setOsManagerCached(OsManager osManagerCached) {
        this.osManagerCached = osManagerCached;
    }
}
