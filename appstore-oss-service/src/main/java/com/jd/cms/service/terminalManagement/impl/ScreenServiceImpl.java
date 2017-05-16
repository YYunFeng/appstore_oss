package com.jd.cms.service.terminalManagement.impl;

import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.manager.terminalManagement.ScreenManager;
import com.jd.cms.service.terminalManagement.ScreenService;
import com.jd.common.web.result.Result;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 屏幕管理serviceImpl
 */
public class ScreenServiceImpl implements ScreenService {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(ScreenServiceImpl.class);
    /**
     * managerCached注入
     */
    private ScreenManager screenManagerCached;
    /**
     * 取得屏幕参数集合
     * @param pageIndex,pageSize
     * @return Result
     */
    public Result findScreenPage(int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("TerminalpageOutputs", screenManagerCached.findScreenPage(pageIndex, pageSize));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("取得屏幕参数集合 pageIndex="+pageIndex+" pageSize="+pageSize+" error!", e);
        }
        return result;
    }
    /**
     * 创建屏幕信息
     * @param terminalInsertInput
     * @return Result
     */
    public Result createScreen(TerminalInsertInput terminalInsertInput) {
        Result result = new Result();
        try {
            screenManagerCached.createScreen(terminalInsertInput);
            result.addDefaultModel("terminalInsertInput", terminalInsertInput);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("创建屏幕信息 terminalInsertInput="+terminalInsertInput+" error!", e);
            result.setResultCode("createScreen.error");
        }
        return result;
    }
    /**
     * 更新屏幕上下架状态
     * @param terminalpageInput
     * @return Result
     */
    public Result upScreenOnline(TerminalpageInput terminalpageInput) {
        Result result = new Result();
        try{
          int  isSuccess=screenManagerCached.upScreenOnline(terminalpageInput);
          if(0!=isSuccess){
            result.addDefaultModel("info", "更新屏幕上下架状态成功");
          }else{
            result.addDefaultModel("info", "更新屏幕上下架状态失败");
          }
            result.setSuccess(true);
        }catch(Exception e){
            log.error("更新屏幕上下架状态 terminalpageInput="+terminalpageInput+" error!",e);
        }
        return result;
    }
    /**
     * 删除屏幕信息
     * @param terminalpageInput
     * @return Result
     */
    public Result delScreen(TerminalpageInput terminalpageInput) {
        Result result = new Result();
        try{
          int  isSuccess=screenManagerCached.delScreen(terminalpageInput);
          if(0!=isSuccess){
            result.addDefaultModel("info", "删除屏幕信息成功");
          }else{
            result.addDefaultModel("info", "删除屏幕信息失败");
          }
            result.setSuccess(true);
        }catch(Exception e){
            log.error("删除屏幕信息 terminalpageInput="+terminalpageInput+"error!",e);
        }
        return result;
    }
    /**
     * 根据ID查询单条屏幕信息
     * @param id
     * @return Result
     */
    public Result findScreenById(int id) {
        Result result = new Result();
        try {
            result.addDefaultModel("TerminalpageOutput",screenManagerCached.findScreenById(id));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("根据ID查询单条屏幕信息 id="+id+" error!", e);
        }
        return result;
    }
    /**
     * 更新屏幕信息
     * @param terminalpageInput
     * @return Result
     */
    public Result upScreen(TerminalpageInput terminalpageInput) {
        Result result = new Result();
        int  isSuccess = 0;
        try{
          String Checkname = screenManagerCached.checkScreenName(terminalpageInput.getScreenSizeName());
          if(null == Checkname || terminalpageInput.getScreenSizeName().equalsIgnoreCase(terminalpageInput.getOriginalName())){
            isSuccess=screenManagerCached.upScreen(terminalpageInput);
          }
          if(0!=isSuccess){
            result.addDefaultModel("info", "更新屏幕信息成功");
          }else{
            result.addDefaultModel("info", "更新屏幕信息失败");
          }
            result.setSuccess(true);
        }catch(Exception e){
            log.error("更新屏幕信息 terminalpageInput="+terminalpageInput+" error!",e);
        }
        return result;
    }
    /**
     * 检查屏幕版本名
     * @param name
     * @return String
     */
    public String checkScreenName(String name) {
        /*创建检查是否存在标记*/
        String check = null;
        try{
          String Checkname = screenManagerCached.checkScreenName(name);
          if(null == Checkname){
          /*数据库不存在，可以创建*/
            check = "yes";
          }else{
          /*数据库不存在，可以创建*/
            check = "no";
          }
        }catch(Exception e){
            log.error("检查屏幕版本名 name="+name+" error!",e);
        }
        return check;
    }

    public ScreenManager getScreenManagerCached() {
        return screenManagerCached;
    }

    public void setScreenManagerCached(ScreenManager screenManagerCached) {
        this.screenManagerCached = screenManagerCached;
    }
}
