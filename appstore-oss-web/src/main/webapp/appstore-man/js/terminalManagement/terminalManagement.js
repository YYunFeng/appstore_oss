/**
  * 页面提前加载项
  */
        (function(){
            var object=document.getElementById("nav-terminal");
            if(object)object.className+=" curr";//当前导航
            selOsAllTreePageOne();//加载右侧页
        })();
/**
  * 左侧平台管理按钮操作
  */
    function selOsAllTreePageOne(){
        jQuery.ajax({
                type:"POST",
                url:'/os/findOsPage.action',
                data:{
                   "page":1
                },
                dataType:"html",
                success:function(msg) {
                    jQuery('#cpTable').html(msg);
                    }
                });
    }
/**
  * 系统列表查询,页数保留,用于其它操作
  */
    function selOsAllTree(){
        jQuery.ajax({
                type:"POST",
                url:'/os/findOsPage.action',
                dataType:"html",
                success:function(msg) {
                    jQuery('#cpTable').html(msg);
                    }
                });
    }
/**
  * 左侧屏幕管理按钮操作
  */
    function selChargeAllTreePageOne(){
        jQuery.ajax({
                type:"POST",
                url:'/screen/findScreenPage.action',
                data:{
                   "page":1
                },
                dataType:"html",
                success:function(msg) {
                    jQuery('#cpTable').html(msg);
                    }
                });
    }
/**
  * 屏幕列表查询,页数保留,用于其它操作
  */
    function selChargeAllTree(){
        jQuery.ajax({
                type:"POST",
                url:'/screen/findScreenPage.action',
                dataType:"html",
                success:function(msg) {
                    jQuery('#cpTable').html(msg);
                    }
                });
    }
/**
  * 更新系统上下架状态操作
  */
    function upOsOnline(num,online){
        if (confirm("确定要更改状态吗？")){
        /*现在状态为上线*/
        if(online == 1){
            /*要做下线操作*/
            online = 2;
            /*现在状态为下线*/
        }else{
            /*要做上线操作*/
            online = 1;
        }
        jQuery.ajax({
               type:"POST",
               url:'/os/upOsOnline.action',
               data:{
                   "id":num,
                   "terminalpageInput.online":online
               },
               dataType:"json",
               success:function(msg) {
                   selOsAllTree();
                    }
               });
        }
    }
/**
  * 更新屏幕上下架状态操作
  */
    function upScreenOnline(num,online){
        if (confirm("确定要更改状态吗？")){
        /*现在状态为上线*/
        if(online == 1){
            /*要做下线操作*/
            online = 2;
            /*现在状态为下线*/
        }else{
            /*要做上线操作*/
            online = 1;
        }
        jQuery.ajax({
               type:"POST",
               url:'/screen/upScreenOnline.action',
               data:{
                   "id":num,
                   "terminalpageInput.online":online
               },
               dataType:"json",
               success:function(msg) {
                    selChargeAllTree();
                    }
               });
        }
    }
/**
  * 删除系统操作
  */
    function delOs(num){
        if (confirm("确定要删除吗?"))  {
        jQuery.ajax({
               type:"POST",
               url:'/os/delOs.action',
               data:{
                   "id":num
               },
               dataType:"json",
               success:function(msg) {
                   selOsAllTree();
                    }
               });
        }
    }
/**
  * 删除屏幕操作
  */
    function delScreen(num){
        if (confirm("确定要删除吗?"))  {
        jQuery.ajax({
               type:"POST",
               url:'/screen/delScreen.action',
               data:{
                   "id":num
               },
               dataType:"json",
               success:function(msg) {
                    selChargeAllTree();
                    }
               });
        }
    }
/**
  * 根据ID查询,用于更新系统前的查询
  */
    function upSelOsByid(id){
        /*等待图片*/
        document.getElementById("Loading").style.display="block";
        document.getElementById("Loading2").style.display="block";
        /*设置弹出层宽高比*/
        jQuery("#EjectTable").css("width","400px");
        jQuery("#EjectTable").css("height","410px");
        jQuery.ajax({
                type:"POST",
                async:false,
                url:'/os/findOsById.action',
                data:{
                    "id":id
                    },
                dataType:"html",
                success:function(msg) {
                    document.getElementById("Loading").style.display="none";
                    document.getElementById("Loading2").style.display="none";
                    jQuery('#EjectTable').html(msg);
                    }
                });
    }
/**
  * 根据ID查询,用于更新屏幕前的操作
  */
    function upSelScreenByid(id){
        /*等待图片*/
        document.getElementById("Loading").style.display="block";
        document.getElementById("Loading2").style.display="block";
        /*设置弹出层宽高比*/
        jQuery("#EjectTable").css("width","400px");
        jQuery("#EjectTable").css("height","360px");
        jQuery.ajax({
                type:"POST",
                async:false,
                url:'/screen/findScreenById.action',
                data:{
                    "id":id
                    },
                dataType:"html",
                success:function(msg) {
                    document.getElementById("Loading").style.display="none";
                    document.getElementById("Loading2").style.display="none";
                    jQuery('#EjectTable').html(msg);
                    }
                });
    }
/**
  * 增加系统按钮操作
  */
    function addOsButton(){
        /*等待图片*/
        document.getElementById("Loading").style.display="block";
        document.getElementById("Loading2").style.display="block";
        /*设置弹出层宽高比*/
        jQuery("#EjectTable").css("width","400px");
        jQuery("#EjectTable").css("height","460px");
        jQuery.ajax({
                type:"POST",
                async:false,
                url:'/os/addOsButton.action',
                dataType:"html",
                success:function(msg){
                    document.getElementById("Loading").style.display="none";
                    document.getElementById("Loading2").style.display="none";
                    jQuery('#EjectTable').html(msg);
                    }
                });
    }
/**
  * 增加屏幕按钮操作
  */
    function addScreenButton(){
        /*等待图片*/
        document.getElementById("Loading").style.display="block";
        document.getElementById("Loading2").style.display="block";
        /*设置弹出层宽高比*/
        jQuery("#EjectTable").css("width","400px");
        jQuery("#EjectTable").css("height","380px");
        jQuery.ajax({
                type:"POST",
                async:false,
                url:'/screen/addScreenButton.action',
                dataType:"html",
                success:function(msg){
                    document.getElementById("Loading").style.display="none";
                    document.getElementById("Loading2").style.display="none";
                    jQuery('#EjectTable').html(msg);
                    }
                });
    }
/**
  * 更新的检查系统名
  */
    function checkOsName(){
        /*输入的系统版本名*/
        var name = jQuery.trim(jQuery("[name=terminalpageInput.osVersionName]").val());
        /*数据库中的系统版本名*/
        var originalName = jQuery("[name=originalName]").val();
        if("" == name){
            document.getElementById("osNameMsg").style.display="none";
            document.getElementById("osNameNull").style.display="block";
            jQuery("[name=markUpName]").attr("value","false");
            jQuery("[name=terminalpageInput.osVersionName]").val("");
        }else if(originalName == name){
            document.getElementById("osNameMsg").style.display="none";
            document.getElementById("osNameNull").style.display="none";
            jQuery("[name=markUpName]").attr("value","true");
        }else{
            jQuery.ajax({
                type:"POST",
                async:false,
                url:'/os/checkOsName.action',
                data:{
                    "terminalpageInput.osVersionName":name
                    },
                dataType:"json",
                success:function(msg) {
                        /*数据库中已存在*/
                        if("no" == msg){
                            document.getElementById("osNameNull").style.display="none";
                            document.getElementById("osNameMsg").style.display="block";
                            jQuery("[name=markUpName]").attr("value","false");
                        }else{
                            document.getElementById("osNameNull").style.display="none";
                            document.getElementById("osNameMsg").style.display="none";
                            jQuery("[name=markUpName]").attr("value","true");
                        }
                    }
                });
        }
    }
/**
  * 更新的检查屏幕名
  */
    function checkScreenName(){
        /*输入的系统版本名*/
        var name = jQuery.trim(jQuery("[name=terminalpageInput.screenSizeName]").val());
        /*数据库中的系统版本名*/
        var originalName = jQuery("[name=originalName]").val();
        if("" == name){
            document.getElementById("screenNameMsg").style.display="none";
            document.getElementById("screenNameNull").style.display="block";
            jQuery("[name=markScreenName]").attr("value","false");
            jQuery("[name=terminalpageInput.screenSizeName]").val("");
        }else if(originalName == name){
            document.getElementById("screenNameMsg").style.display="none";
            document.getElementById("screenNameNull").style.display="none";
            jQuery("[name=markScreenName]").attr("value","true");
        }else{
            jQuery.ajax({
                type:"POST",
                async:false,
                url:'/screen/checkScreenName.action',
                data:{
                    "terminalpageInput.screenSizeName":name
                    },
                dataType:"json",
                success:function(msg){
                        /*数据库中已存在*/
                        if("no" == msg){
                            document.getElementById("screenNameNull").style.display="none";
                            document.getElementById("screenNameMsg").style.display="block";
                            jQuery("[name=markScreenName]").attr("value","false");
                        }else{
                            document.getElementById("screenNameNull").style.display="none";
                            document.getElementById("screenNameMsg").style.display="none";
                            jQuery("[name=markScreenName]").attr("value","true");
                        }
                    }
                });
        }
    }
/**
  * 插入的检查系统名
  */
    function checkInOsName(){
        /*输入的系统版本名*/
        var name = jQuery.trim(jQuery("[name=terminalInsertInput.osVersionName]").val());
        if("" == name){
            document.getElementById("osNameMsg").style.display="none";
            document.getElementById("osNameNull").style.display="block";
            jQuery("[name=markUpName]").attr("value","false");
            jQuery("[name=terminalpageInput.osVersionName]").val("");
        }else{
            jQuery.ajax({
                type:"POST",
                async:false,
                url:'/os/checkOsName.action',
                data:{
                    "terminalpageInput.osVersionName":name
                    },
                dataType:"json",
                success:function(msg){
                        /*数据库中已存在*/
                        if("no" == msg){
                            document.getElementById("osNameNull").style.display="none";
                            document.getElementById("osNameMsg").style.display="block";
                            jQuery("[name=markUpName]").attr("value","false");
                        }else{
                            document.getElementById("osNameNull").style.display="none";
                            document.getElementById("osNameMsg").style.display="none";
                            jQuery("[name=markUpName]").attr("value","true");
                        }
                    }
                });
        }
    }
/**
  * 插入的检查屏幕名
  */
    function checkInScreenName(){
        /*输入的系统版本名*/
        var name = jQuery.trim(jQuery("[name=terminalInsertInput.screenSizeName]").val());
        if("" == name){
            document.getElementById("screenNameMsg").style.display="none";
            document.getElementById("screenNameNull").style.display="block";
            jQuery("[name=markScreenName]").attr("value","false");
            jQuery("[name=terminalpageInput.screenSizeName]").val("");
        }else{
            jQuery.ajax({
                type:"POST",
                async:false,
                url:'/screen/checkScreenName.action',
                data:{
                    "terminalpageInput.screenSizeName":name
                    },
                dataType:"json",
                success:function(msg){
                        /*数据库中已存在*/
                        if("no" == msg){
                            document.getElementById("screenNameNull").style.display="none";
                            document.getElementById("screenNameMsg").style.display="block";
                            jQuery("[name=markScreenName]").attr("value","false");
                        }else{
                            document.getElementById("screenNameNull").style.display="none";
                            document.getElementById("screenNameMsg").style.display="none";
                            jQuery("[name=markScreenName]").attr("value","true");
                        }
                    }
                });
        }
    }
/**
  * 屏幕更新操作
  */
    function upScreen(){
        /*检查屏幕名*/
        checkScreenName();
        /*检查通过*/
        if("true" == jQuery("[name=markScreenName]").val()){
                jQuery.ajax({
                type:"POST",
                url:'/screen/upScreen.action',
                data:{
                    "terminalpageInput.originalName":jQuery.trim(jQuery("[name=originalName]").val()),
                    "terminalpageInput.screenSizeId":jQuery.trim(jQuery("[name=terminalpageInput.screenSizeId]").val()),
                    "terminalpageInput.screenSizeName":jQuery.trim(jQuery("[name=terminalpageInput.screenSizeName]").val()),
                    "terminalpageInput.intro":jQuery.trim(jQuery("[name=terminalpageInput.intro]").val())
                    },
                dataType:"json",
                success:function(msg) {
                    jQuery('#closeDiv').click();
                    selChargeAllTree();
                    }
                });
        }
    }
/**
  * 关闭弹出框
  */
    function closeDiv(){
        jQuery('#closeDiv').click();
    }
/**
  * 增加新屏幕
  */
    function createScreen(){
        /*检查屏幕名*/
        checkInScreenName();
        /*检查通过*/
        if("true" == jQuery("[name=markScreenName]").val()){
        jQuery.ajax({
                type:"POST",
                url:'/screen/createScreen.action',
                data:{
                    "terminalInsertInput.screenSizeName":jQuery.trim(jQuery("[name=terminalInsertInput.screenSizeName]").val()),
                    "terminalInsertInput.online":jQuery.trim(jQuery("[name=terminalInsertInput.online]").val()),
                    "terminalInsertInput.intro":jQuery.trim(jQuery("[name=terminalInsertInput.intro]").val())
                    },
                dataType:"json",
                success:function(msg) {
                    jQuery('#closeDiv').click();
                    selChargeAllTree();
                    }
                });
        }
    }
/**
  * 更新平台时版本码校验
  */
    function checkOsCode(){
        /*输入的系统版本码*/
        var code = jQuery.trim(jQuery("[name=terminalpageInput.osVersionCode]").val());
        /*数据库中的系统版本码*/
        var originalCode = jQuery("[name=originalCode]").val();
        if("" == code){
            document.getElementById("osCodeMsg").style.display="none";
            document.getElementById("osCodeOut").style.display="none";
            document.getElementById("osCodeNull").style.display="block";
            jQuery("[name=markUpCode]").attr("value","false");
            jQuery("[name=terminalpageInput.osVersionCode]").val("");
        }else if(!/^([1-9]\d{0,2})$/.test(code)){
            document.getElementById("osCodeMsg").style.display="none";
            document.getElementById("osCodeNull").style.display="none";
            document.getElementById("osCodeOut").style.display="block";
            jQuery("[name=markUpCode]").attr("value","false");
        }else if(originalCode == code){
            document.getElementById("osCodeMsg").style.display="none";
            document.getElementById("osCodeNull").style.display="none";
            document.getElementById("osCodeOut").style.display="none";
            jQuery("[name=markUpCode]").attr("value","true");
        }else{
            jQuery.ajax({
                type:"POST",
                async:false,
                url:'/os/checkOsCode.action',
                data:{
                    "terminalpageInput.osVersionCode":code
                    },
                dataType:"json",
                success:function(msg){
                        /*数据库已存在*/
                        if("no" == msg){
                            document.getElementById("osCodeNull").style.display="none";
                            document.getElementById("osCodeOut").style.display="none";
                            document.getElementById("osCodeMsg").style.display="block";
                            jQuery("[name=markUpCode]").attr("value","false");
                        }else{
                            document.getElementById("osCodeNull").style.display="none";
                            document.getElementById("osCodeMsg").style.display="none";
                            document.getElementById("osCodeOut").style.display="none";
                            jQuery("[name=markUpCode]").attr("value","true");
                        }
                    }
                });
        }
    }
/**
  * 增加平台时代版本码校验
  */
    function checkInOsCode(){
        /*输入的系统版本码*/
        var code = jQuery.trim(jQuery("[name=terminalInsertInput.osVersionCode]").val());
        if("" == code){
            document.getElementById("osCodeMsg").style.display="none";
            document.getElementById("osCodeOut").style.display="none";
            document.getElementById("osCodeNull").style.display="block";
            jQuery("[name=markUpCode]").attr("value","false");
            jQuery("[name=terminalInsertInput.osVersionCode]").val("");
        }else if(!/^([1-9]\d{0,2})$/.test(code)){
            document.getElementById("osCodeMsg").style.display="none";
            document.getElementById("osCodeNull").style.display="none";
            document.getElementById("osCodeOut").style.display="block";
            jQuery("[name=markUpCode]").attr("value","false");
        }else{
            jQuery.ajax({
                type:"POST",
                async:false,
                url:'/os/checkOsCode.action',
                data:{
                    "terminalpageInput.osVersionCode":code
                    },
                dataType:"json",
                success:function(msg){
                        /*数据库已存在*/
                        if("no" == msg){
                            document.getElementById("osCodeNull").style.display="none";
                            document.getElementById("osCodeOut").style.display="none";
                            document.getElementById("osCodeMsg").style.display="block";
                            jQuery("[name=markUpCode]").attr("value","false");
                        }else{
                            document.getElementById("osCodeNull").style.display="none";
                            document.getElementById("osCodeMsg").style.display="none";
                            document.getElementById("osCodeOut").style.display="none";
                            jQuery("[name=markUpCode]").attr("value","true");
                        }
                    }
                });
        }
    }
/**
  * 增加新系统
  */
    function createOs(){
        /*检查系统版本名*/
        checkInOsName();
        /*检查系统版本码*/
        checkInOsCode();
        /*都通过*/
        if("true" == jQuery("[name=markUpName]").val() && "true" == jQuery("[name=markUpCode]").val()){
                jQuery.ajax({
                    type:"POST",
                    url:'/os/createOs.action',
                    data:{
                        "terminalInsertInput.osVersionName":jQuery.trim(jQuery("[name=terminalInsertInput.osVersionName]").val()),
                        "terminalInsertInput.osVersionCode":jQuery.trim(jQuery("[name=terminalInsertInput.osVersionCode]").val()),
                        "terminalInsertInput.online":jQuery.trim(jQuery("[name=terminalInsertInput.online]").val()),
                        "terminalInsertInput.intro":jQuery.trim(jQuery("[name=terminalInsertInput.intro]").val())
                        },
                    dataType:"json",
                    success:function(msg) {
                        jQuery('#closeDiv').click();
                        selOsAllTree();
                        }
                });
        }
    }
/**
  * 系统更新操作
  */
    function upOs(){
        /*检查系统版本名*/
        checkOsName();
        /*检查系统版本码*/
        checkOsCode();
        /*都通过*/
        if("true" == jQuery("[name=markUpName]").val() && "true" == jQuery("[name=markUpCode]").val()){
            jQuery.ajax({
                type:"POST",
                url:'/os/upOs.action',
                data:{
                    "terminalpageInput.originalName":jQuery.trim(jQuery("[name=originalName]").val()),
                    "terminalpageInput.osVersionId":jQuery.trim(jQuery("[name=terminalpageInput.osVersionId]").val()),
                    "terminalpageInput.osVersionName":jQuery.trim(jQuery("[name=terminalpageInput.osVersionName]").val()),
                    "terminalpageInput.osVersionCode":jQuery.trim(jQuery("[name=terminalpageInput.osVersionCode]").val()),
                    "terminalpageInput.intro":jQuery.trim(jQuery("[name=terminalpageInput.intro]").val())
                    },
                dataType:"json",
                success:function(msg) {
                    jQuery('#closeDiv').click();
                    selOsAllTree();
                    }
                });
        }
    }