/**
 * 页面提前加载项
 */
(function() {
    var object = document.getElementById("nav-cp");
    if (object)object.className += " curr";//当前导航
    selCpAllTree();
})();
/**
 * 左侧CP帐号管理按钮
 */
function selCpAllTree() {
    jQuery.ajax({
                type:"POST",
                url:'/cpQualityManagement/findCpPage.action',
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
 * 左侧收费资质审核按钮
 */
function selChargeAllTree() {
    jQuery.ajax({
                type:"POST",
                url:'/cpChargeQualification/findCpChargePage.action',
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
 * CP帐号查询，页数置一
 */
function selCpTree() {
    jQuery.ajax({
                type:"POST",
                url:'/cpQualityManagement/findCpPage.action',
                data:{
                    "page":1,
                    "selCpPageInPut.account":jQuery.trim(jQuery("[name=selCpPageInPut.account]").val()),
                    "selCpPageInPut.cpName":jQuery.trim(jQuery("[name=selCpPageInPut.cpName]").val()),
                    "selCpPageInPut.contacter":jQuery.trim(jQuery("[name=selCpPageInPut.contacter]").val()),
                    "selCpPageInPut.mobile":jQuery.trim(jQuery("[name=selCpPageInPut.mobile]").val()),
                    "selCpPageInPut.cpProperty":jQuery.trim(jQuery("[name=selCpPageInPut.cpProperty]").val()),
                    "selCpPageInPut.accountStatus":jQuery.trim(jQuery("[name=selCpPageInPut.accountStatus]").val())
                },
                dataType:"html",
                success:function(msg) {
                    jQuery('#cpTable').html(msg);
                }
            });
}
/**
 * CP帐号查询,页数保留,用于其它操作调用
 */
function selCpTreeEvent() {
    jQuery.ajax({
                type:"POST",
                url:'/cpQualityManagement/findCpPage.action',
                data:{
                    "selCpPageInPut.account":jQuery.trim(jQuery("[name=selCpPageInPut.account]").val()),
                    "selCpPageInPut.cpName":jQuery.trim(jQuery("[name=selCpPageInPut.cpName]").val()),
                    "selCpPageInPut.contacter":jQuery.trim(jQuery("[name=selCpPageInPut.contacter]").val()),
                    "selCpPageInPut.mobile":jQuery.trim(jQuery("[name=selCpPageInPut.mobile]").val()),
                    "selCpPageInPut.cpProperty":jQuery.trim(jQuery("[name=selCpPageInPut.cpProperty]").val()),
                    "selCpPageInPut.accountStatus":jQuery.trim(jQuery("[name=selCpPageInPut.accountStatus]").val())
                },
                dataType:"html",
                success:function(msg) {
                    jQuery('#cpTable').html(msg);
                }
            });
}
/**
 * 收费资质审核查询，页数置一
 */
function selCpChargeTree() {
    jQuery.ajax({
                type:"POST",
                url:'/cpChargeQualification/findCpChargePage.action',
                data:{
                    "page":1,
                    "selCpPageInPut.account":jQuery.trim(jQuery("[name=selCpPageInPut.account]").val()),
                    "selCpPageInPut.cpName":jQuery.trim(jQuery("[name=selCpPageInPut.cpName]").val()),
                    "selCpPageInPut.contractNumber":jQuery.trim(jQuery("[name=selCpPageInPut.contractNumber]").val()),
                    "selCpPageInPut.cpProperty":jQuery.trim(jQuery("[name=selCpPageInPut.cpProperty]").val()),
                    "selCpPageInPut.feeStatus":jQuery.trim(jQuery("[name=selCpPageInPut.feeStatus]").val())
                },
                dataType:"html",
                success:function(msg) {
                    jQuery('#cpTable').html(msg);
                }
            });
}
/**
 * 收费资质审核查询,页数保留,用于其它操作调用
 */
function selCpChargeTreeEvent() {
    jQuery.ajax({
                type:"POST",
                url:'/cpChargeQualification/findCpChargePage.action',
                data:{
                    "selCpPageInPut.account":jQuery.trim(jQuery("[name=selCpPageInPut.account]").val()),
                    "selCpPageInPut.cpName":jQuery.trim(jQuery("[name=selCpPageInPut.cpName]").val()),
                    "selCpPageInPut.contractNumber":jQuery.trim(jQuery("[name=selCpPageInPut.contractNumber]").val()),
                    "selCpPageInPut.cpProperty":jQuery.trim(jQuery("[name=selCpPageInPut.cpProperty]").val()),
                    "selCpPageInPut.feeStatus":jQuery.trim(jQuery("[name=selCpPageInPut.feeStatus]").val())
                },
                dataType:"html",
                success:function(msg) {
                    jQuery('#cpTable').html(msg);
                }
            });
}
/**
 * CP帐号的启用停用操作
 */
function upCpAccountStatus(num) {
    /*处理多选,提出被选的CPid*/
    var imgs = document.getElementsByName('chkUpdatePrompt');
    var ims = new Array();
    for (var i = 0; i < imgs.length; i++) {
        if (eval("img[" + imgs[i].id + "]") == true) {
            ims.push(imgs[i].id);
        }
    }
    if (null == ims[0]) {
        alert("请选择要操作的账号");
        return false;
    }
    var prompt;
    if (1 == num) {
        prompt = "确定要将所选账号置为“启用”状态吗？";
    } else if (2 == num) {
        prompt = "确定要将所选账号置为“停用”状态吗？";
    }
    if (confirm(prompt)) {
        jQuery.ajax({
                    type:"POST",
                    url:'/cpQualityManagement/upAccountStatus.action',
                    data:{
                        "selCpPageInPut.upAccountStatus":num,
                        "selCpPageInPut.idList":ims.toString()
                    },
                    dataType:"json",
                    success:function(msg) {
                        selCpTreeEvent();
                    }
                });
    }
}
/**
 * 收费资质审核待审核操作
 */
function upCpFeeStatus(num) {
    /*处理多选,提出被选的CPid*/
    var imgs = document.getElementsByName('chkUpdatePrompt');
    var ims = new Array();
    for (var i = 0; i < imgs.length; i++) {
        if (eval("img[" + imgs[i].id + "]") == true) {
            ims.push(imgs[i].id);
        }
    }
    if (null == ims[0]) {
        alert("请选择要操作的账号");
        return false;
    }
    if (confirm("确定要将所选账号置为“待审核”状态吗？？")) {
        jQuery.ajax({
                    type:"POST",
                    url:'/cpChargeQualification/upCpFeeStatus.action',
                    data:{
                        "selCpPageInPut.upFeeStatus":num,
                        "selCpPageInPut.idList":ims.toString(),
                        "selCpPageInPut.comment":"批量待审核操作"
                    },
                    dataType:"json",
                    success:function(msg) {
                        selCpChargeTreeEvent();
                    }
                });
    }
}
/**
 * CP帐号的删除
 */
function delCp() {
    /*处理多选,提出被选的CPid*/
    var imgs = document.getElementsByName('chkUpdatePrompt');
    var ims = new Array();
    for (var i = 0; i < imgs.length; i++) {
        if (eval("img[" + imgs[i].id + "]") == true) {
            ims.push(imgs[i].id);
        }
    }
    if (null == ims[0]) {
        alert("请选择要操作的账号");
        return false;
    }
    if (confirm('确定要删除所选账号吗？')) {
        jQuery.ajax({
                    type:"POST",
                    url:'/cpQualityManagement/delCp.action',
                    data:{
                        "selCpPageInPut.idList":ims.toString()
                    },
                    dataType:"json",
                    success:function(msg) {
                        if (1 == msg) {
                            alert("CP存在发布的应用,无法删除");
                            selCpTreeEvent();
                        } else if (2 == msg) {
                            alert("个别CP存在发布的应用,无法删除");
                            selCpTreeEvent();
                        } else if (0 == msg) {
                            selCpTreeEvent();
                        }
                    }
                });
    }
}
/**
 * CP帐号管理查看详情操作
 */
function selCpExpatiation(id) {
    jQuery("#EjectTable").css("width", "423px");
    jQuery("#EjectTable").css("height", "500px");
    /*等待图片*/
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
                type:"POST",
                async:false,
                url:'/cpQualityManagement/findCpExpatiation.action',
                data:{
                    "id":id
                },
                dataType:"html",
                success:function(msg) {
                    document.getElementById("Loading").style.display = "none";
                    document.getElementById("Loading2").style.display = "none";
                    jQuery('#EjectTable').html(msg);
                }
            });
}
/**
 * 关闭弹出框操作
 */
function closeDiv() {
    jQuery('#closeDiv').click();
}
/**
 * 收费资质审核,审核信息查询
 */
function findCpChargeExpatiation(id, feeStatus) {
    if (3 == feeStatus) {
        alert("账号已审核通过,不能再次审核");
        return false;
    } else {
        document.getElementById("Loading").style.display = "block";
        document.getElementById("Loading2").style.display = "block";
        jQuery.ajax({
                    type:"POST",
                    async:false,
                    url:'/cpChargeQualification/findCpChargeExpatiation.action',
                    data:{
                        "id":id
                    },
                    dataType:"html",
                    success:function(msg) {
                        document.getElementById("Loading").style.display = "none";
                        document.getElementById("Loading2").style.display = "none";
                        jQuery('#EjectTable').html(msg);
                    }
                });
    }
}
/**
 * 收费资质审核,审核不通过操作
 */
function upFeeStatusOff() {
    var num = 4;
    /*不通过代码*/
    jQuery.ajax({
                type:"POST",
                async:false,
                url:'/cpChargeQualification/upCpFeeStatus.action',
                data:{
                    "selCpPageInPut.upFeeStatus":num.toString(),
                    "selCpPageInPut.idList":jQuery.trim(jQuery("[name=selCpPageInPut.upId]").val()),
                    "selCpPageInPut.comment":jQuery.trim(jQuery("[name=selCpPageInPut.comment]").val())
                },
                dataType:"json",
                success:function(msg) {
                    jQuery('#closeDiv').click();
                    selCpChargeTreeEvent();
                }
            });
}
/**
 * 收费资质审核,审核通过操作
 */
function upFeeStatusOn() {
    /*检查默认分成比例*/
    checkDefaultPercent();
    if ("true" == jQuery("[name=defaultPercentMark]").val()) {
        var num = 3;
        /*通过代码*/
        jQuery.ajax({
                    type:"POST",
                    async:false,
                    url:'/cpChargeQualification/upCpChargeFeeStatusByOne.action',
                    data:{
                        "selCpPageInPut.upFeeStatus":num.toString(),
                        "selCpPageInPut.upId":jQuery.trim(jQuery("[name=selCpPageInPut.upId]").val()),
                        "selCpPageInPut.upSupplierNo":jQuery.trim(document.getElementById("selCpPageInPut.upSupplierNo").value),
                        "selCpPageInPut.upSupplierName":jQuery.trim(jQuery("[name=selCpPageInPut.upSupplierName]").val()),
                        "selCpPageInPut.upContractNumber":jQuery.trim(jQuery("[name=selCpPageInPut.upContractNumber]").val()),
                        "selCpPageInPut.upDefaultFeeMode":jQuery.trim(jQuery("[name=selCpPageInPut.upDefaultFeeMode]").val()),
                        "selCpPageInPut.upDefaultPercent":jQuery.trim(jQuery("[name=selCpPageInPut.upDefaultPercent]").val()),
                        "selCpPageInPut.upValidPeriodBegin":jQuery.trim(jQuery("[name=selCpPageInPut.upValidPeriodBegin]").val()),
                        "selCpPageInPut.upValidPeriodEnd":jQuery.trim(jQuery("[name=selCpPageInPut.upValidPeriodEnd]").val()),
                        "selCpPageInPut.comment":jQuery.trim(jQuery("[name=selCpPageInPut.comment]").val())
                    },
                    dataType:"json",
                    success:function(msg) {
                        jQuery('#closeDiv').click();
                        selCpChargeTreeEvent();
                    }
                });
    }
}
/**
 * 验证默认分成比列
 */
function checkDefaultPercent() {
    var defaultPercent = jQuery.trim(jQuery("[name=selCpPageInPut.upDefaultPercent]").val());
    if ("" == defaultPercent) {
        document.getElementById("defaultPercentInt").style.display = "none";
        document.getElementById("defaultPercentNull").style.display = "block";
        jQuery("[name=defaultPercentMark]").attr("value", "false");
        jQuery("[name=selCpPageInPut.upDefaultPercent]").val("");
        /*整数0-1000*/
    } else if (!/^([1-9]\d{0,1}|100|0)$/.test(defaultPercent)) {
        document.getElementById("defaultPercentNull").style.display = "none";
        document.getElementById("defaultPercentInt").style.display = "block";
        jQuery("[name=defaultPercentMark]").attr("value", "false");
    } else {
        jQuery("[name=defaultPercentMark]").attr("value", "true");
    }
}
/**
 *  渠道维护
 */
function getPadChannel() {
    jQuery.ajax({
                type:"POST",
                url:'/cpQualityManagement/findPadChannel.action',
                data:{
                    "page":1
                },
                dataType:"html",
                success:function(msg) {
                    jQuery('#cpTable').html(msg);
                }
            });
}

function addPadChannel() {
    jQuery("#EjectTable").css("width", "450px");
    jQuery("#EjectTable").css("height", "446px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
                type:"post",
                async:false,
                url:"/cpQualityManagement/addPadChannel.action",
                dataType:"html",
                success:function(data) {
                    document.getElementById("Loading").style.display = "none";
                    document.getElementById("Loading2").style.display = "none";
                    jQuery('#EjectTable').html(data);
                }
            });
}


function modifyPadChannel(id) {
    jQuery("#EjectTable").css("width", "450px");
    jQuery("#EjectTable").css("height", "446px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
                type:"post",
                async:false,
                url:"/cpQualityManagement/modifyChannel.action",
                data:{"id":id},
                dataType:"html",
                success:function(data) {
                    document.getElementById("Loading").style.display = "none";
                    document.getElementById("Loading2").style.display = "none";
                    jQuery('#EjectTable').html(data);
                }
            });
}

function savePadChannel() {
    var padChannelName = $("#PadChannelName").val();
    var padChannelIntro = $("#PadChannelIntro").val();
    var padChannelGw = $("#PadChannelGw").val();
    jQuery.ajax({
                type:"post",
                url:"/cpQualityManagement/savePadChannel.action",
                async:false,
                data:{"padChannel.cname":padChannelName,"padChannel.intro":padChannelIntro,"padChannel.gw":padChannelGw},
                dataType:"html",
                success:function(data) {
                    jQuery('#cpTable').html(data);
                    jQuery('#closeDiv').click();
                }
            });
}

function deletePadChannel(id, ccId) {
    if (confirm('确认删除?')) {
        jQuery.ajax({
                    type:"post",
                    url:"/cpQualityManagement/deletePadChannel.action",
                    data:{"id":id,"ccId":ccId},
                    dataType:"html",
                    success:function(data) {
                        jQuery('#cpTable').html(data);
                    }
                });
        return true;
    } else {
        return false;
    }
}

function updatePadChannel(id) {
    var padChannelName = $("#PadChannelName").val();
    var padChannelIntro = $("#PadChannelIntro").val();
    var padChannelGw = $("#PadChannelGw").val();
    jQuery.ajax({
                type:"post",
                url:"/cpQualityManagement/updatePadChannel.action",
                data:{"padChannel.id":id,"padChannel.cname":padChannelName,"padChannel.intro":padChannelIntro,"padChannel.gw":padChannelGw},
                dataType:"html",
                success:function(data) {
                    jQuery('#cpTable').html(data);
                    jQuery('#closeDiv').click();
                }
            });
}
function relevanceCp(id) {
    jQuery("#EjectTable").css("width", "450px");
    jQuery("#EjectTable").css("height", "400px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
                type:"post",
                async:false,
                url:"/cpQualityManagement/relevanceCp.action",
                data:{"id":id},
                dataType:"html",
                success:function(data) {
                    document.getElementById("Loading").style.display = "none";
                    document.getElementById("Loading2").style.display = "none";
                    jQuery('#EjectTable').html(data);
                }
            });
}
function saveRelevanceCp(flag, id) {
    var cpId = null;
    var cpResult = document.getElementsByName('cpResult');
    for (var i = 0; i < cpResult.length; i++) {
        if (cpResult[i].checked) {
            cpId = cpResult[i].value;
            break;
        }
    }
    jQuery.ajax({
                type:"POST",
                url:"/cpQualityManagement/createRelevanceCp.action",
                data:{
                    "padChannel.flag":flag,
                    "padChannel.id":id,
                    "padChannel.cpId":cpId
                },
                dataType:"html",
                success:function(data) {
                    jQuery('#cpTable').html(data);
                    jQuery('#closeDiv').click();
                }
            });
}