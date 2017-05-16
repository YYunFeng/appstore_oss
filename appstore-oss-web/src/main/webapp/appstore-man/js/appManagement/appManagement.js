/**
 * 左侧已有应用-移动游戏，移动软件按钮的列表查询
 */
function findAppMobileBrowse(num) {
    /*追加markCategoryl2标记*/
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery("[name=markCategoryl2]").attr("value", num);
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findMobileBrowsePage.action',
        data: {
            "page": 1,
            "appPageInput.categoryidl2": num
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}
/**
 * 左侧已有应用-网页应用按钮的列表查询
 */
function findAppWebBrowse(num) {
    /*追加markCategoryl2标记*/
    jQuery("[name=markCategoryl2]").attr("value", num);
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findWebBrowsePage.action',
        data: {
            "page": 1,
            "appPageInput.categoryidl2": num
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 已有应用-移动软件，移动游戏的有条件查询,页数置一
 */
function findAppMobileBrowseTree() {
    var price = jQuery("[name=appPageInput.price]").val();
    var p;
    var n;
    /*代表全部*/
    if (-1 == price) {
        /*sql查询条件nullPrice*/
        n = 0;
        /*代表免费*/
    } else if (0 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 0
        /*代表收费*/
    } else if (1 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 1;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findMobileBrowsePage.action',
        data: {
            "page": 1,
            "appPageInput.categoryidl2": jQuery.trim(jQuery("[name=markCategoryl2]").val()),
            "appPageInput.cpName": jQuery.trim(jQuery("[name=appPageInput.cpName]").val()),
            "appPageInput.appName": jQuery.trim(jQuery("[name=appPageInput.appName]").val()),
            "appPageInput.packageName": jQuery.trim(jQuery("[name=appPageInput.packageName]").val()),
            "appPageInput.category3": jQuery.trim(jQuery("[name=appPageInput.category3]").val()),
            "appPageInput.price": p,
            "appPageInput.nullPrice": n
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 已有应用-WEB的有条件查询，页数置一
 */
function findAppWebBrowseTree() {
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findWebBrowsePage.action',
        data: {
            "page": 1,
            "appPageInput.categoryidl2": jQuery.trim(jQuery("[name=markCategoryl2]").val()),
            "appPageInput.cpName": jQuery.trim(jQuery("[name=appPageInput.cpName]").val()),
            "appPageInput.appName": jQuery.trim(jQuery("[name=appPageInput.appName]").val()),
            "appPageInput.appType": jQuery.trim(jQuery("[name=appPageInput.appType]").val()),
            "appPageInput.category3": jQuery.trim(jQuery("[name=appPageInput.category3]").val())
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 已有应用-移动软件，移动游戏的有条件查询,页数保留，用于其他操作
 */
function findAppMobileBrowseTreeEvent() {
    var price = jQuery("[name=appPageInput.price]").val();
    var p;
    var n;
    /*代表全部*/
    if (-1 == price) {
        /*sql查询条件nullPrice*/
        n = 0;
        /*代表免费*/
    } else if (0 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 0
        /*代表收费*/
    } else if (1 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 1;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findMobileBrowsePage.action',
        data: {
            "appPageInput.categoryidl2": jQuery.trim(jQuery("[name=markCategoryl2]").val()),
            "appPageInput.cpName": jQuery.trim(jQuery("[name=appPageInput.cpName]").val()),
            "appPageInput.appName": jQuery.trim(jQuery("[name=appPageInput.appName]").val()),
            "appPageInput.packageName": jQuery.trim(jQuery("[name=appPageInput.packageName]").val()),
            "appPageInput.category3": jQuery.trim(jQuery("[name=appPageInput.category3]").val()),
            "appPageInput.price": p,
            "appPageInput.nullPrice": n
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 已有应用WEB的有条件查询，页数保留，用于其他操作
 */
function findAppWebBrowseTreeEvent() {
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findWebBrowsePage.action',
        data: {
            "appPageInput.categoryidl2": jQuery.trim(jQuery("[name=markCategoryl2]").val()),
            "appPageInput.cpName": jQuery.trim(jQuery("[name=appPageInput.cpName]").val()),
            "appPageInput.appName": jQuery.trim(jQuery("[name=appPageInput.appName]").val()),
            "appPageInput.appType": jQuery.trim(jQuery("[name=appPageInput.appType]").val()),
            "appPageInput.category3": jQuery.trim(jQuery("[name=appPageInput.category3]").val())
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 左侧审核应用-移动应用操作
 */
function appMobileManagement() {
    /*代表0：android-phone；1：android-PAD；2：android-ALL；*/
    var type = "0,1,2";
    jQuery("[name=markType]").attr("value", type);
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/findMobileDetailsPage.action',
        data: {
            "appPageInput.type": type.toString(),
            "page": 1
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 左侧审核应用-网页应用操作
 */
function appWebManagement() {
    /*代表3：web-flash；4：web-iframe*/
    var type = "3,4";
    jQuery("[name=markType]").attr("value", type);
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/findWebDetailsPage.action',
        data: {
            "appPageInput.type": type.toString(),
            "page": 1
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 审核-移动应用查询操作,页数置一
 */
function findMobileDetailsTree() {
    var type = "0,1,2";
    jQuery("[name=markType]").attr("value", type);
    var price = jQuery("[name=appPageInput.price]").val();
    var p;
    var n;
    /*代表全部*/
    if (-1 == price) {
        /*sql查询条件nullPrice*/
        n = 0;
        /*代表免费*/
    } else if (0 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 0
        /*代表收费*/
    } else if (1 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 1;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/findMobileDetailsPage.action',
        data: {
            "page": 1,
            "appPageInput.type": type.toString(),
            "appPageInput.cpName": jQuery.trim(jQuery("[name=appPageInput.cpName]").val()),
            "appPageInput.appName": jQuery.trim(jQuery("[name=appPageInput.appName]").val()),
            "appPageInput.packageName": jQuery.trim(jQuery("[name=appPageInput.packageName]").val()),
            "appPageInput.updateStatus": jQuery.trim(jQuery("[name=appPageInput.updateStatus]").val()),
            "appPageInput.price": p,
            "appPageInput.nullPrice": n
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 审核-移动应用查询操作,页数保留用于其它操作
 */
function findMobileDetailsTreeEvent() {
    var type = "0,1,2";
    jQuery("[name=markType]").attr("value", type);
    var price = jQuery("[name=appPageInput.price]").val();
    var p;
    var n;
    /*代表全部*/
    if (-1 == price) {
        /*sql查询条件nullPrice*/
        n = 0;
        /*代表免费*/
    } else if (0 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 0
        /*代表收费*/
    } else if (1 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 1;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/findMobileDetailsPage.action',
        data: {
            "appPageInput.type": type.toString(),
            "appPageInput.cpName": jQuery.trim(jQuery("[name=appPageInput.cpName]").val()),
            "appPageInput.appName": jQuery.trim(jQuery("[name=appPageInput.appName]").val()),
            "appPageInput.packageName": jQuery.trim(jQuery("[name=appPageInput.packageName]").val()),
            "appPageInput.updateStatus": jQuery.trim(jQuery("[name=appPageInput.updateStatus]").val()),
            "appPageInput.price": p,
            "appPageInput.nullPrice": n
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 审核-WEB应用查询操作,页数置一
 */
function findWebDetailsTree() {
    var type = "3,4";
    jQuery("[name=markType]").attr("value", type);
    var price = jQuery("[name=appPageInput.price]").val();
    var p;
    var n;
    /*代表全部*/
    if (-1 == price) {
        /*sql查询条件nullPrice*/
        n = 0;
        /*代表免费*/
    } else if (0 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 0
        /*代表收费*/
    } else if (1 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 1;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/findWebDetailsPage.action',
        data: {
            "page": 1,
            "appPageInput.type": type.toString(),
            "appPageInput.cpName": jQuery.trim(jQuery("[name=appPageInput.cpName]").val()),
            "appPageInput.appName": jQuery.trim(jQuery("[name=appPageInput.appName]").val()),
            "appPageInput.appType": jQuery.trim(jQuery("[name=appPageInput.appType]").val()),
            "appPageInput.updateStatus": jQuery.trim(jQuery("[name=appPageInput.updateStatus]").val()),
            "appPageInput.price": p,
            "appPageInput.nullPrice": n
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 审核-WEB应用查询操作,页数保留,用于其它操作
 */
function findWebDetailsTreeEvent() {
    var type = "3,4";
    jQuery("[name=markType]").attr("value", type);
    var price = jQuery("[name=appPageInput.price]").val();
    var p;
    var n;
    /*代表全部*/
    if (-1 == price) {
        /*sql查询条件nullPrice*/
        n = 0;
        /*代表免费*/
    } else if (0 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 0
        /*代表收费*/
    } else if (1 == price) {
        /*sql查询条件nullPrice*/
        n = 1;
        /*sql查询条件price*/
        p = 1;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/findWebDetailsPage.action',
        data: {
            "appPageInput.type": type.toString(),
            "appPageInput.cpName": jQuery.trim(jQuery("[name=appPageInput.cpName]").val()),
            "appPageInput.appName": jQuery.trim(jQuery("[name=appPageInput.appName]").val()),
            "appPageInput.appType": jQuery.trim(jQuery("[name=appPageInput.appType]").val()),
            "appPageInput.updateStatus": jQuery.trim(jQuery("[name=appPageInput.updateStatus]").val()),
            "appPageInput.price": p,
            "appPageInput.nullPrice": n
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}
/**
 * 移动应用审核按钮的单条查询
 */
function selAppMobileDetailsTree(id, appid, accountid) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        async: false,
        url: '/appManagement/findAppMobileDetails.action',
        data: {
            "appPageInput.did": id,
            "appPageInput.appid": appid,
            "appPageInput.accountid": accountid
        },
        dataType: "html",
        success: function (msg) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#EjectTable').html(msg);
        }
    });
}
/**
 * 网页应用审核按钮的单条查询
 */
function selAppWebDetailsTree(id, appid, accountid) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        async: false,
        url: '/appManagement/findAppWebDetails.action',
        data: {
            "appPageInput.did": id,
            "appPageInput.appid": appid,
            "appPageInput.accountid": accountid
        },
        dataType: "html",
        success: function (msg) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#EjectTable').html(msg);
        }
    });
}
/**
 * 移动审核不通过操作
 */
function updateStatusMobileOff(aid, did) {
    if (3 == jQuery("[name=AppPageInput.updateStatus]").val()) {
        alert("审核中,请稍等");
        return false;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/updateStatusMobileOff.action',
        data: {
            "appPageInput.aid": aid,
            "appPageInput.did": did,
            "appPageInput.comment": jQuery.trim(jQuery("[name=AppPageInput.comment]").val()),
            "appPageInput.baseCheckStatus": jQuery.trim(jQuery("[name=AppPageInput.baseCheckStatus]").val())
        },
        dataType: "json",
        success: function (msg) {
            jQuery('#closeDiv').click();
            findMobileDetailsTreeEvent();
        }
    });
}
/**
 * WEB审核不通过操作
 */
function updateStatusWebOff(aid, did) {
    if (3 == jQuery("[name=AppPageInput.updateStatus]").val()) {
        alert("审核中,请稍等");
        return false;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/updateStatusWebOff.action',
        data: {
            "appPageInput.aid": aid,
            "appPageInput.did": did,
            "appPageInput.comment": jQuery.trim(jQuery("[name=AppPageInput.comment]").val()),
            "appPageInput.baseCheckStatus": jQuery.trim(jQuery("[name=AppPageInput.baseCheckStatus]").val())
        },
        dataType: "json",
        success: function (msg) {
            jQuery('#closeDiv').click();
            findWebDetailsTreeEvent();
        }
    });
}
/**
 * 移动审核通过操作
 */
function updateStatusMobileOn(aid, did) {
    if (3 == jQuery("[name=AppPageInput.updateStatus]").val()) {
        alert("审核中,请稍等");
        return false;
    } else if ("" == jQuery.trim(jQuery("[name=AppPageInput.categoryid1]").val())) {
        alert("三级类目为空，不能审核通过");
        return false;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/updateStatusMobileOn.action',
        data: {
            "appPageInput.aid": aid,
            "appPageInput.did": did,
            "appPageInput.logoUrl": jQuery.trim(jQuery("[name=AppPageInput.logoUrl]").val()),
            "appPageInput.adText": jQuery.trim(jQuery("[name=AppPageInput.adText]").val()),
            "appPageInput.appType": jQuery.trim(jQuery("[name=AppPageInput.appType]").val()),
            "appPageInput.appid": jQuery.trim(jQuery("[name=AppPageInput.appid]").val()),
            "appPageInput.osVersionId": jQuery.trim(jQuery("[name=AppPageInput.osVersionId]").val()),
            "appPageInput.pkgSize": jQuery.trim(jQuery("[name=AppPageInput.pkgSize]").val()),
            "appPageInput.appVersionCode": jQuery.trim(jQuery("[name=AppPageInput.appVersionCode]").val()),
            "appPageInput.versionName": jQuery.trim(jQuery("[name=AppPageInput.versionName]").val()),
            "appPageInput.accountid": jQuery.trim(jQuery("[name=AppPageInput.accountid]").val()),
            "appPageInput.appTag": jQuery.trim(jQuery("[name=AppPageInput.appTag]").val()),
            "appPageInput.categoryid1": jQuery.trim(jQuery("[name=AppPageInput.categoryid1]").val()),
            "appPageInput.categoryidl2": jQuery.trim(jQuery("[name=AppPageInput.categoryidl2]").val()),
            "appPageInput.categoryid2": jQuery.trim(jQuery("[name=AppPageInput.categoryid2]").val()),
            "appPageInput.feeMode": jQuery.trim(jQuery("[name=AppPageInput.feeMode]").val()),
            "appPageInput.percent": jQuery.trim(jQuery("[name=AppPageInput.percent]").val()),
            "appPageInput.period1Begin": jQuery.trim(jQuery("[name=AppPageInput.period1Begin]").val()),
            "appPageInput.period1End": jQuery.trim(jQuery("[name=AppPageInput.period1End]").val()),
            "appPageInput.percent2": jQuery.trim(jQuery("[name=AppPageInput.percent2]").val()),
            "appPageInput.period2Begin": jQuery.trim(jQuery("[name=AppPageInput.period2Begin]").val()),
            "appPageInput.period2End": jQuery.trim(jQuery("[name=AppPageInput.period2End]").val()),
            "appPageInput.percent3": jQuery.trim(jQuery("[name=AppPageInput.percent3]").val()),
            "appPageInput.period3Begin": jQuery.trim(jQuery("[name=AppPageInput.period3Begin]").val()),
            "appPageInput.period3End": jQuery.trim(jQuery("[name=AppPageInput.period3End]").val()),
            "appPageInput.prepay": jQuery.trim(jQuery("[name=AppPageInput.prepay]").val()),
            "appPageInput.buyout": jQuery.trim(jQuery("[name=AppPageInput.buyout]").val()),
            "appPageInput.buyoutBegin": jQuery.trim(jQuery("[name=AppPageInput.buyoutBegin]").val()),
            "appPageInput.buyoutEnd": jQuery.trim(jQuery("[name=AppPageInput.buyoutEnd]").val()),
            "appPageInput.comment": jQuery.trim(jQuery("[name=AppPageInput.comment]").val()),
            "appPageInput.baseCheckStatus": jQuery.trim(jQuery("[name=AppPageInput.baseCheckStatus]").val()),
            "appPageInput.appIntroduce": jQuery.trim(jQuery("[name=AppPageInput.appIntroduce]").val()),
            "appPageInput.price": jQuery.trim(jQuery("[name=AppPageInput.price]").val()),
            "appPageInput.apkCode": jQuery.trim(jQuery("[name=AppPageInput.apkcode]").val())
        },
        dataType: "json",
        success: function (msg) {
            jQuery('#closeDiv').click();
            findMobileDetailsTreeEvent();
        }
    });
}
/**
 * WEB审核通过操作
 */
function updateStatusWebOn(aid, did) {
    if (3 == jQuery("[name=AppPageInput.updateStatus]").val()) {
        alert("审核中,请稍等");
        return false;
    } else if ("" == jQuery.trim(jQuery("[name=AppPageInput.categoryid1]").val())) {
        alert("三级类目为空，不能审核通过");
        return false;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/updateStatusWebOn.action',
        data: {
            "appPageInput.aid": aid,
            "appPageInput.did": did,
            "appPageInput.logoUrl": jQuery.trim(jQuery("[name=AppPageInput.logoUrl]").val()),
            "appPageInput.adText": jQuery.trim(jQuery("[name=AppPageInput.adText]").val()),
            "appPageInput.appType": jQuery.trim(jQuery("[name=AppPageInput.appType]").val()),
            "appPageInput.versionName": jQuery.trim(jQuery("[name=AppPageInput.versionName]").val()),
            "appPageInput.appid": jQuery.trim(jQuery("[name=AppPageInput.appid]").val()),
            "appPageInput.accountid": jQuery.trim(jQuery("[name=AppPageInput.accountid]").val()),
            "appPageInput.appTag": jQuery.trim(jQuery("[name=AppPageInput.appTag]").val()),
            "appPageInput.categoryid1": jQuery.trim(jQuery("[name=AppPageInput.categoryid1]").val()),
            "appPageInput.categoryidl2": jQuery.trim(jQuery("[name=AppPageInput.categoryidl2]").val()),
            "appPageInput.categoryid2": jQuery.trim(jQuery("[name=AppPageInput.categoryid2]").val()),
            "appPageInput.comment": jQuery.trim(jQuery("[name=AppPageInput.comment]").val()),
            "appPageInput.baseCheckStatus": jQuery.trim(jQuery("[name=AppPageInput.baseCheckStatus]").val()),
            "appPageInput.appIntroduce": jQuery.trim(jQuery("[name=AppPageInput.appIntroduce]").val())
        },
        dataType: "json",
        success: function (msg) {
            jQuery('#closeDiv').click();
            findWebDetailsTreeEvent();
        }
    });
}
/**
 * 关闭弹出层
 */
function closeDiv() {
    jQuery('#closeDiv').click();
}
/**
 * 批量更新移动游戏，应用上下架状态
 */
function upAppOnline(num) {
    /*处理多选,提出被选的appid*/
    var imgs = document.getElementsByName('chkUpdatePrompt');
    var ims = new Array();
    for (var i = 0; i < imgs.length; i++) {
        if (eval("img[" + imgs[i].id + "]") == true) {
            ims.push(imgs[i].id);
        }
    }
    if (null == ims[0]) {
        alert("请选择要操作的应用");
        return false;
    }
    var msg = "确认要进行此操作吗？";
    if (num == 2) {
        msg = "下线的应用会从推荐列表和排行榜中\n移除，确认要进行此操作吗？";
    }
    if (confirm(msg)) {
        jQuery.ajax({
            type: "POST",
            url: '/appBrowse/upMobileOnline.action',
            data: {
                "appPageInput.online": num,
                "idList": ims.toString()
            },
            dataType: "json",
            success: function (msg) {
                if (1 == msg) {
                    alert("存在正在审核的应用,无法变更状态");
                    findAppMobileBrowseTreeEvent();
                } else if (2 == msg) {
                    alert("存在正在审核的应用,无法变更状态");
                    findAppMobileBrowseTreeEvent();
                } else if (0 == msg) {
                    findAppMobileBrowseTreeEvent();
                } else if (3 == msg) {
                    alert("上下架状态已经变更！");
                    findAppMobileBrowseTreeEvent();
                }
            }
        });
    }
}
/**
 * 批量更新网页应用上下架状态
 */
function upAppWebOnline(num) {
    /*处理多选,提出被选的appid*/
    var imgs = document.getElementsByName('chkUpdatePrompt');
    var ims = new Array();
    for (var i = 0; i < imgs.length; i++) {
        if (eval("img[" + imgs[i].id + "]") == true) {
            ims.push(imgs[i].id);
        }
    }
    if (null == ims[0]) {
        alert("请选择要操作的应用");
        return false;
    }

    var msg = "确认要进行此操作吗？";
    if (num == 2) {
        msg = "下线的应用会从推荐列表和排行榜中\n移除，确认要进行此操作吗？";
    }
    if (confirm(msg)) {
        jQuery.ajax({
            type: "POST",
            url: '/appBrowse/upWebOnline.action',
            data: {
                "appPageInput.online": num,
                "idList": ims.toString()
            },
            dataType: "json",
            success: function (msg) {
                if (1 == msg) {
                    alert("存在正在审核的应用,无法变更状态");
                    findAppWebBrowseTreeEvent();
                } else if (2 == msg) {
                    alert("存在正在审核的应用,无法变更状态");
                    findAppWebBrowseTreeEvent();
                } else if (0 == msg) {
                    findAppWebBrowseTreeEvent();
                } else if (3 == msg) {
                    alert("上下架状态已经变更！");
                    findAppWebBrowseTreeEvent();
                }
            }
        });
    }
}
/**
 * 应用浏览的移动游戏，移动软件的单个上下线操作
 */
function upAppOnlineById(appid, online) {
    var msg = "确认要进行此操作吗？";
    if (online == 1) {
        msg = "下线的应用会从推荐列表和排行榜中\n移除，确认要进行此操作吗？";
    }
    if (confirm(msg)) {
        /*如果是上线就做下线，是下线就做上线*/
        if (1 == online) {
            online = 2;
        } else if (2 == online) {
            online = 1;
        }
        jQuery.ajax({
            type: "POST",
            url: '/appBrowse/upMobileOnlineById.action',
            data: {
                "appPageInput.online": online,
                "appPageInput.appid": appid
            },
            dataType: "json",
            success: function (msg) {
                if (1 == msg) {
                    alert("后台正在同步应用基本信息,");
                } else if (2 == msg) {
                    alert("后台正在同步上下架状态，请耐心等待");
                } else if (0 == msg) {
                    findAppMobileBrowseTreeEvent();
                } else if (3 == msg) {
                    alert("上下架状态已经变更！");
                    findAppMobileBrowseTreeEvent();
                }
            }
        });
    }
}
/**
 * 应用浏览的网页应用的单个上下线操作
 */
function upAppWebOnlineById(appid, online) {
    var msg = "确认要进行此操作吗？";
    if (online == 1) {
        msg = "下线的应用会从推荐列表和排行榜中\n移除，确认要进行此操作吗？";
    }
    if (confirm(msg)) {
        /*如果是上线就做下线，是下线就做上线*/
        if (1 == online) {
            online = 2;
        } else if (2 == online) {
            online = 1;
        }
        jQuery.ajax({
            type: "POST",
            url: '/appBrowse/upWebOnlineById.action',
            data: {
                "appPageInput.online": online,
                "appPageInput.appid": appid
            },
            dataType: "json",
            success: function (msg) {
                if (1 == msg) {
                    alert("后台正在同步应用基本信息,");
                } else if (2 == msg) {
                    alert("后台正在同步上下架状态，请耐心等待");
                } else if (0 == msg) {
                    findAppWebBrowseTreeEvent();
                } else if (3 == msg) {
                    alert("上下架状态已经变更！");
                    findAppWebBrowseTreeEvent();
                }
            }
        });
    }
}
/**
 * 移动游戏，移动软件的默认应用详情查询
 */
function findMobileExpatiation(appid, accountid) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findMobileExpatiation.action',
        async: false,
        data: {
            "appPageInput.appid": appid,
            "appPageInput.accountid": accountid
        },
        dataType: "html",
        success: function (msg) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#EjectTable').html(msg);
        }
    });
}
/**
 * WEB应用的默认应用详情查询
 */
function findWebExpatiation(appid, accountid) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findWebExpatiation.action',
        async: false,
        data: {
            "appPageInput.appid": appid,
            "appPageInput.accountid": accountid
        },
        dataType: "html",
        success: function (msg) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#EjectTable').html(msg);
        }
    });
}
/**
 * 免费应用一对多的详情查询
 */
function findMobileExpatiationByCp(appid, accountid) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findMobileExpatiation.action',
        async: false,
        data: {
            "appPageInput.appid": appid,
            "appPageInput.accountid": accountid
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#EjectTable').html(msg);
        }
    });
}
/**
 * 应用浏览的详情上下架状态修改操作
 */
function upAppDetailsOnline(did, aOnline, dOnline, cpSize) {
    if (1 == dOnline) {
        dOnline = 2;
    } else if (2 == dOnline) {
        dOnline = 1;
    }
    if (2 == aOnline && 1 == dOnline) {
        alert("应用未上架,请先上架应用");
        return false;
    } else if (1 == cpSize && 2 == dOnline) {
        alert("只剩下一个详情,不能下架");
        return false;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/upAppDetailsOnline.action',
        data: {
            "appPageInput.did": did,
            "appPageInput.online": dOnline
        },
        dataType: "json",
        success: function (msg) {
            var appid = jQuery("[name=AppPageInput.appid]").val();
            var accountid = jQuery("[name=AppPageInput.accountid]").val();
            var cpNameSel = jQuery("[name=AppPageInput.cpNameSel]").val()
            findMobileExpatiationByCp(appid, accountid, cpNameSel);
        }
    });
}
/**
 * 通过2级类目查3级类目
 */
function category3() {
    var categoryidl2 = jQuery("[name=AppPageInput.categoryidl2]").val();
    document.getElementById("categoryid31").innerHTML = "";
    document.getElementById("categoryid32").innerHTML = "";
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/findCategory.action',
        data: {
            "appPageInput.categoryidl2": categoryidl2
        },
        dataType: "json",
        success: function (data) {
            /*追加3类目select*/
            var selectCategory1 = document.getElementById("categoryid31");
            for (var i = 0; i < data.map.categorys.length; i++) {
                var category = new Option(data.map.categorys[i].categoryName, data.map.categorys[i].categoryId + "");
                selectCategory1.add(category);
            }
            var selectCategory2 = document.getElementById("categoryid32");
            selectCategory2.add(new Option("请选择", ""));
            for (var i = 0; i < data.map.categorys.length; i++) {
                var category = new Option(data.map.categorys[i].categoryName, data.map.categorys[i].categoryId + "");
                selectCategory2.add(category);
            }
        }
    });
}
/**
 * 移动游戏，软件
 * 应用编辑查询默认详情
 */
function findMobileExpatiationEdit(appid, accountid) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        async: false,
        url: '/appBrowse/findMobileExpatiationEdit.action',
        data: {
            "appPageInput.appid": appid,
            "appPageInput.accountid": accountid
        },
        dataType: "html",
        success: function (msg) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#EjectTable').html(msg);
        }
    });
}
/**
 * 移动游戏，软件
 * 一对多应用编辑查询详情ByName
 */
function findMobileExpatiationEditByCp(accountid) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/findMobileExpatiationEdit.action',
        async: false,
        data: {
            "appPageInput.appid": jQuery.trim(jQuery("[name=AppPageInput.appid]").val()),
            "appPageInput.accountid": accountid,
            "appPageInput.cpName": jQuery.trim(jQuery("[name=AppPageInput.cpNameSel]").val())
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#EjectTable').html(msg);
        }
    });
}
/**
 * 应用软件
 * 应用编辑查询默认详情
 */
function findWebExpatiationEdit(appid, accountid) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        async: false,
        url: '/appBrowse/findWebExpatiationEdit.action',
        data: {
            "appPageInput.appid": appid,
            "appPageInput.accountid": accountid
        },
        dataType: "html",
        success: function (msg) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#EjectTable').html(msg);
        }
    });
}
/**
 * 更新为默认详情
 */
function upAppDefaultDetaild(appid, did, accountStatus, accountid) {
    var cpName = document.getElementById("AppPageInput.cpNameSel").value;
    if (2 == accountStatus) {
        alert("所选CP已停用不能设为默认详情");
        return false;
    } else if (0 == accountStatus) {
        alert("所选CP未启用不能设为默认详情");
        return false;
    }
    if (confirm("确认要修改默认详情吗？")) {
        jQuery.ajax({
            type: "POST",
            url: '/appBrowse/upAppDefaultDetaild.action',
            data: {
                "appPageInput.appid": appid,
                "appPageInput.defaultDetailId": did
            },
            dataType: "json",
            success: function (msg) {
                if (1 == msg) {
                    alert("设置默认详情成功！");
                    findMobileExpatiationByCp(appid, accountid, cpName);
                } else {
                    alert("设置默认详情失败！");
                }

            }
        });
    }
}
/**
 * 应用浏览-编辑
 * 改变详情检查是否有修改
 * 有提示保存没有进行查询
 */
function checkCpNameSel(appid, did, accountid) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    var upAdText = jQuery.trim(jQuery("[name=AppPageInput.adText]").val());
    var upCategoryidl2 = jQuery("[name=AppPageInput.categoryidl2]").val();
    var upCategoryid1 = jQuery("[name=AppPageInput.categoryid1]").val();
    var upCategoryid2 = jQuery("[name=AppPageInput.categoryid2]").val();
    var upAppType = jQuery("[name=AppPageInput.appType]").val();
    var upAppTag = jQuery.trim(jQuery("[name=AppPageInput.appTag]").val());
    var upAppName = jQuery.trim(jQuery("[name=AppPageInput.appName]").val());
    var upAppIntroduce = jQuery.trim(jQuery("[name=AppPageInput.appIntroduce]").val());
    var originalAppName = jQuery("[name=originalAppName]").val();
    var originalCategoryidl2 = jQuery("[name=originalCategoryidl2]").val();
    var originalCategoryid1 = jQuery("[name=originalCategoryid1]").val();
    var originalCategoryid2 = jQuery("[name=originalCategoryid2]").val();
    var originalAdText = jQuery.trim(jQuery("[name=originalAdText]").val());
    var originalAppType = jQuery("[name=originalAppType]").val();
    var originalAppTag = jQuery.trim(jQuery("[name=originalAppTag]").val());
    var originalAppIntroduce = jQuery.trim(jQuery("[name=originalAppIntroduce]").val());
    var baseCheckStatus = 1;
    /*做对比，如果没有改动直接查询*/
    if (upAdText == originalAdText && upCategoryidl2 == originalCategoryidl2 && upCategoryid1 == originalCategoryid1
        && upCategoryid2 == originalCategoryid2 && upAppType == originalAppType
        && upAppTag == originalAppTag && upAppIntroduce == originalAppIntroduce
        && upAppName == originalAppName) {
        findMobileExpatiationEditByCp(accountid);
        /*做对比，如果有改动提示保存*/
    } else {
        if (confirm("有修改是否保存？")) {
            /*如果类目有修改，把baseCheckStatus赋值2，到后台判断是否走erp*/
            if (upCategoryidl2 != originalCategoryidl2 || upCategoryid1 != originalCategoryid1 ||
                upCategoryid2 != originalCategoryid2 || upAppName != originalAppName) {
                baseCheckStatus = 2;
            }
            jQuery.ajax({
                type: "POST",
                url: '/appBrowse/saveMobileAppAndDetailInformation.action',
                async: false,
                data: {
                    "appPageInput.appid": appid,
                    "appPageInput.did": did,
                    "appPageInput.baseCheckStatus": baseCheckStatus,
                    "appPageInput.appName": jQuery.trim(jQuery("[name=AppPageInput.appName]").val()),
                    "appPageInput.percent": jQuery.trim(jQuery("[name=AppPageInput.percent]").val()),
                    "appPageInput.period1Begin": jQuery.trim(jQuery("[name=AppPageInput.period1Begin]").val()),
                    "appPageInput.period1End": jQuery.trim(jQuery("[name=AppPageInput.period1End]").val()),
                    "appPageInput.percent2": jQuery.trim(jQuery("[name=AppPageInput.percent2]").val()),
                    "appPageInput.period2Begin": jQuery.trim(jQuery("[name=AppPageInput.period2Begin]").val()),
                    "appPageInput.period2End": jQuery.trim(jQuery("[name=AppPageInput.period2End]").val()),
                    "appPageInput.percent3": jQuery.trim(jQuery("[name=AppPageInput.percent3]").val()),
                    "appPageInput.period3Begin": jQuery.trim(jQuery("[name=AppPageInput.period3Begin]").val()),
                    "appPageInput.period3End": jQuery.trim(jQuery("[name=AppPageInput.period3End]").val()),
                    "appPageInput.prepay": jQuery.trim(jQuery("[name=AppPageInput.prepay]").val()),
                    "appPageInput.buyout": jQuery.trim(jQuery("[name=AppPageInput.buyout]").val()),
                    "appPageInput.buyoutBegin": jQuery.trim(jQuery("[name=AppPageInput.buyoutBegin]").val()),
                    "appPageInput.buyoutEnd": jQuery.trim(jQuery("[name=AppPageInput.buyoutEnd]").val()),
                    "appPageInput.adText": jQuery.trim(jQuery("[name=AppPageInput.adText]").val()),
                    "appPageInput.appIntroduce": jQuery.trim(jQuery("[name=AppPageInput.appIntroduce]").val()),
                    "appPageInput.appTag": jQuery.trim(jQuery("[name=AppPageInput.appTag]").val()),
                    "appPageInput.appType": jQuery.trim(jQuery("[name=AppPageInput.appType]").val()),
                    "appPageInput.categoryid1": jQuery.trim(jQuery("[name=AppPageInput.categoryid1]").val()),
                    "appPageInput.categoryidl2": jQuery.trim(jQuery("[name=AppPageInput.categoryidl2]").val()),
                    "appPageInput.categoryid2": jQuery.trim(jQuery("[name=AppPageInput.categoryid2]").val())
                },
                dataType: "json",
                success: function (msg) {
                    if (1 == msg) {
                        alert("后台正在同步应用基本信息,请耐心等待");
                    } else if (2 == msg) {
                        alert("后台正在同步上下架状态，请耐心等待");
                    } else if (0 == msg) {
                        findMobileExpatiationEditByCp(accountid);
                    }
                }
            });
        }
    }
}
/**
 * 应用浏览-编辑
 * 网页应用-保存操作
 */
function saveStatusWebOn(appid, did) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    var originalAppName = jQuery("[name=originalAppName]").val();
    var originalCategoryidl2 = jQuery("[name=originalCategoryidl2]").val();
    var originalCategoryid1 = jQuery("[name=originalCategoryid1]").val();
    var originalCategoryid2 = jQuery("[name=originalCategoryid2]").val();
    var upAppName = jQuery.trim(jQuery("[name=AppPageInput.appName]").val());
    var upCategoryidl2 = jQuery("[name=AppPageInput.categoryidl2]").val();
    var upCategoryid1 = jQuery("[name=AppPageInput.categoryid1]").val();
    var upCategoryid2 = jQuery("[name=AppPageInput.categoryid2]").val();
    var baseCheckStatus = 1;
    /*如果类目有修改，把baseCheckStatus赋值2，到后台判断是否走erp*/
    if (upCategoryidl2 != originalCategoryidl2 || upCategoryid1 != originalCategoryid1
        || upCategoryid2 != originalCategoryid2 || upAppName != originalAppName) {
        baseCheckStatus = 2;
    }
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/saveWebAppAndDetailInformation.action',
        data: {
            "appPageInput.appid": appid,
            "appPageInput.did": did,
            "appPageInput.baseCheckStatus": baseCheckStatus,
            "appPageInput.appName": jQuery.trim(jQuery("[name=AppPageInput.appName]").val()),
            "appPageInput.versionName": jQuery.trim(jQuery("[name=AppPageInput.versionName]").val()),
            "appPageInput.adText": jQuery.trim(jQuery("[name=AppPageInput.adText]").val()),
            "appPageInput.appIntroduce": jQuery.trim(jQuery("[name=AppPageInput.appIntroduce]").val()),
            "appPageInput.appTag": jQuery.trim(jQuery("[name=AppPageInput.appTag]").val()),
            "appPageInput.appType": jQuery.trim(jQuery("[name=AppPageInput.appType]").val()),
            "appPageInput.categoryid1": jQuery.trim(jQuery("[name=AppPageInput.categoryid1]").val()),
            "appPageInput.categoryidl2": jQuery.trim(jQuery("[name=AppPageInput.categoryidl2]").val()),
            "appPageInput.categoryid2": jQuery.trim(jQuery("[name=AppPageInput.categoryid2]").val())
        },
        dataType: "json",
        success: function (msg) {
            if (1 == msg) {
                alert("后台正在同步应用基本信息,请耐心等待");
                jQuery('#closeDiv').click();
            } else if (2 == msg) {
                alert("后台正在同步上下架状态，请耐心等待");
                jQuery('#closeDiv').click();
            } else if (0 == msg) {
                jQuery('#closeDiv').click();
                findAppWebBrowseTreeEvent(jQuery("[name=markCategoryl2]").val());
            }
        }
    });
}
/**
 * 应用浏览-编辑
 * 移动游戏，应用-保存操作
 */
function saveStatusMobile(appid, did) {
    jQuery("#EjectTable").css("width", "705px");
    jQuery("#EjectTable").css("height", "500px");
    var originalAppName = jQuery("[name=originalAppName]").val();
    var originalCategoryidl2 = jQuery("[name=originalCategoryidl2]").val();
    var originalCategoryid1 = jQuery("[name=originalCategoryid1]").val();
    var originalCategoryid2 = jQuery("[name=originalCategoryid2]").val();
    var upAppName = jQuery.trim(jQuery("[name=AppPageInput.appName]").val());
    var upCategoryidl2 = jQuery("[name=AppPageInput.categoryidl2]").val();
    var upCategoryid1 = jQuery("[name=AppPageInput.categoryid1]").val();
    var upCategoryid2 = jQuery("[name=AppPageInput.categoryid2]").val();
    var baseCheckStatus = 1;
    /*如果类目有修改，把baseCheckStatus赋值2，到后台判断是否走erp*/
    if (upCategoryidl2 != originalCategoryidl2 || upCategoryid1 != originalCategoryid1
        || upCategoryid2 != originalCategoryid2 || upAppName != originalAppName) {
        baseCheckStatus = 2;
    }
    var packageName = $("#packageName").val();
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/saveMobileAppAndDetailInformation.action',
        data: {
            "appPageInput.appid": appid,
            "appPageInput.did": did,
            "appPageInput.baseCheckStatus": baseCheckStatus,
            "appPageInput.appName": jQuery.trim(jQuery("[name=AppPageInput.appName]").val()),
            "appPageInput.versionName": jQuery.trim(jQuery("[name=AppPageInput.versionName]").val()),
            "appPageInput.percent": jQuery.trim(jQuery("[name=AppPageInput.percent]").val()),
            "appPageInput.period1Begin": jQuery.trim(jQuery("[name=AppPageInput.period1Begin]").val()),
            "appPageInput.period1End": jQuery.trim(jQuery("[name=AppPageInput.period1End]").val()),
            "appPageInput.percent2": jQuery.trim(jQuery("[name=AppPageInput.percent2]").val()),
            "appPageInput.period2Begin": jQuery.trim(jQuery("[name=AppPageInput.period2Begin]").val()),
            "appPageInput.period2End": jQuery.trim(jQuery("[name=AppPageInput.period2End]").val()),
            "appPageInput.percent3": jQuery.trim(jQuery("[name=AppPageInput.percent3]").val()),
            "appPageInput.period3Begin": jQuery.trim(jQuery("[name=AppPageInput.period3Begin]").val()),
            "appPageInput.period3End": jQuery.trim(jQuery("[name=AppPageInput.period3End]").val()),
            "appPageInput.prepay": jQuery.trim(jQuery("[name=AppPageInput.prepay]").val()),
            "appPageInput.buyout": jQuery.trim(jQuery("[name=AppPageInput.buyout]").val()),
            "appPageInput.buyoutBegin": jQuery.trim(jQuery("[name=AppPageInput.buyoutBegin]").val()),
            "appPageInput.buyoutEnd": jQuery.trim(jQuery("[name=AppPageInput.buyoutEnd]").val()),
            "appPageInput.adText": jQuery.trim(jQuery("[name=AppPageInput.adText]").val()),
            "appPageInput.appIntroduce": jQuery.trim(jQuery("[name=AppPageInput.appIntroduce]").val()),
            "appPageInput.appTag": jQuery.trim(jQuery("[name=AppPageInput.appTag]").val()),
            "appPageInput.appType": jQuery.trim(jQuery("[name=AppPageInput.appType]").val()),
            "appPageInput.categoryid1": jQuery.trim(jQuery("[name=AppPageInput.categoryid1]").val()),
            "appPageInput.categoryidl2": jQuery.trim(jQuery("[name=AppPageInput.categoryidl2]").val()),
            "appPageInput.categoryid2": jQuery.trim(jQuery("[name=AppPageInput.categoryid2]").val()),
            "appPageInput.packageName": packageName
        },
        dataType: "json",
        success: function (msg) {
            if (1 == msg) {
                alert("后台正在同步应用基本信息,请耐心等待");
                jQuery('#closeDiv').click();
            } else if (2 == msg) {
                alert("后台正在同步上下架状态，请耐心等待");
                jQuery('#closeDiv').click();
            } else if (0 == msg) {
                jQuery('#closeDiv').click();
                findAppMobileBrowseTreeEvent(jQuery("[name=markCategoryl2]").val());
            }
        }
    });
}


function showCpList(f) {
    if (f == 0) {
        $("#cpList").show();
    } else if (f == 1) {
        $("#cpList").hide();
    }
}

function changeCp(cpId, appid) {
    if (confirm("确定要修改CP?")) {
        var newCpId = $("#newCpId").val();
        jQuery.ajax({
            type: "POST",
            url: '/appBrowse/changeCp.action',
            data: {
                "changeCpInput.currCpId": cpId,
                "changeCpInput.newCpId": newCpId,
                "changeCpInput.appid": appid
            },
            dataType: "json",
            success: function (msg) {
                if (msg.status == 0) {
                    alert("修改成功!")
                } else {
                    alert(msg.mess)
                }
            }
        });
    }
}
/**
 * 浏览应用下载获取token
 */
function downloadApp1() {
    var url = jQuery("[name=DownUrl]").val();
    jQuery.ajax({
        type: "POST",
        url: '/appBrowse/getToken.action',
        data: {
            "appPageInput.resUrl": url
        },
        dataType: "json",
        success: function (msg) {
            window.location.href = msg;
        }
    });
}
/**
 * 审核应用下载获取token
 */
function downloadApp2(url) {
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/getToken.action',
        data: {
            "appPageInput.resUrl": url
        },
        dataType: "json",
        success: function (msg) {
//                    window.location.href = msg;
            window.open(msg);
        }
    });
}
/**
 * 审核应用下载获取token，当前页打开
 */
function downloadApp3(url) {
    jQuery.ajax({
        type: "POST",
        url: '/appManagement/getToken.action',
        data: {
            "appPageInput.resUrl": url
        },
        dataType: "json",
        success: function (msg) {
            window.location.href = msg;
        }
    });
}

/**
 * 计费模式选择
 */
function isFeeMode(value) {
    /*隐藏预付金额,买断信息*/
    if (1 == value) {
        document.getElementById("prepayTr").style.display = "none";
        document.getElementById("buyoutTr").style.display = "none";
        /*隐藏买断信息*/
    } else if (2 == value) {
        document.getElementById("prepayTr").style.display = "";
        document.getElementById("buyoutTr").style.display = "none";
        /*隐藏预付金额*/
    } else if (3 == value) {
        document.getElementById("prepayTr").style.display = "none";
        document.getElementById("buyoutTr").style.display = "";
    }
}

function appStatistics() {
    jQuery.ajax({
        type: "POST",
        url: '/appStatistics/appStatistics.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}


/**
 * 营销日志统计安装次数
 */
function marketStatistics(flag) {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";

    myDate = new Date(year, month, 0);
    var endTime = year + "-" + month + "-" + myDate.getDate();

    jQuery.ajax({
        type: "POST",
        url: "/marketStatistics/marketStatistics.action",
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            getMarketStat(flag);
        }
    });
}
/**
 * 统计应用的总安装量
 */
function getMarketStat(flag) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/marketStatistics/getMarketStat.action',
        data: {"startTime": startTime, "endTime": endTime, "flag": flag},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(0);
            jQuery("#marketStatic").html(msg);
            jQuery("#marketFlag").val(flag);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}
/**
 *   按应用查看
 */
function statByApp() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#marketFlag").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "GET",
        url: '/marketStatistics/statByApp.action',
        data: {"startTime": startTime, "endTime": endTime, "flag": flag},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(1);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}
/**
 * 某个应用按渠道统计安装次数
 * @param appId
 */
function appGetMarketStatByChannel(appId) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#marketFlag").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "GET",
        url: '/marketStatistics/appGetMarketStatByChannel.action',
        data: {"startTime": startTime, "endTime": endTime, "appId": appId, "flag": flag},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(2);
            jQuery("#appId").val(appId);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}
/**
 * 应用每个渠道下按促销员查看
 * @param appId
 * @param cId
 */
function appStatsChannelBySaler(appId, cId) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#marketFlag").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "GET",
        url: '/marketStatistics/appStatsChannelBySaler.action',
        data: {"startTime": startTime, "endTime": endTime, "appId": appId, "channelId": cId, "flag": flag},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(3);
            jQuery("#appId").val(appId);
            jQuery("#cId").val(cId);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}
/**
 * 按渠道查看
 */
function statByChannel() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#marketFlag").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "GET",
        url: '/marketStatistics/statByChannel.action',
        data: {"startTime": startTime, "endTime": endTime, "flag": flag},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(4);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

/**
 * 渠道下按应用查看
 * @param cId
 */
function statChannelByApps(cId) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#marketFlag").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "GET",
        url: '/marketStatistics/statChannelByApps.action',
        data: {"startTime": startTime, "endTime": endTime, "channelId": cId, "flag": flag},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(5);
            jQuery("#cId").val(cId);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}
/**
 * 渠道下按促销员查看安装次数
 * @param cId
 */
function channlStatBySaler(cId) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#marketFlag").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "GET",
        url: '/marketStatistics/channlStatBySaler.action',
        data: {"startTime": startTime, "endTime": endTime, "channelId": cId, "flag": flag},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(7);
            jQuery("#cId").val(cId);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}
/**
 * 促销员按应用查看安装次数
 * @param saler
 * @param cId
 */
function salerStatsByApps(saler, cId) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#marketFlag").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "GET",
        url: '/marketStatistics/salerStatsByApps.action',
        data: {"startTime": startTime, "endTime": endTime, "channelId": cId, "saler": saler, "flag": flag},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(8);
            jQuery("#cId").val(cId);
            jQuery("#saler").val(saler);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function getMarketStatByChoose() {
    // 标示在线还是离线应用查询
    var flag = $("#marketFlag").val();
    // 标示查询方法
    var methodFlag = $("#bookMethod").val();
    var appId = jQuery("#appId").val();
    var cId = jQuery("#cId").val();
    var saler = jQuery("#saler").val();
    if (methodFlag != '') {
        // 统计应用的总安装量
        if (methodFlag == 0) {
            /*  alert('统计应用的总安装量');*/
            getMarketStat(flag);
        }
        // 按应用查看
        if (methodFlag == 1) {
            /*  alert('按应用查看');*/
            statByApp();
        }
        // 按应用查看 --> 按渠道查看
        if (methodFlag == 2) {
            /* alert('按应用查看 --> 按渠道查看');*/
            appGetMarketStatByChannel(appId);
        }
        // 按应用查看 --> 按渠道查看 -->按促销员查看
        if (methodFlag == 3) {
//            alert('按应用查看 --> 按渠道查看 -->按促销员查看');
            appStatsChannelBySaler(appId, cId);
        }
        // 按渠道查看
        if (methodFlag == 4) {
//            alert('按渠道查看');
            statByChannel();
        }
        // 按渠道查看 -->按应用查看
        if (methodFlag == 5) {
//            alert('按渠道查看 -->按应用查看');
            statChannelByApps(cId);
        }
        // 按渠道查看 -->按应用查看-->按促销员查看
        if (methodFlag == 6) {
            //    alert('按渠道查看 -->按应用查看-->按促销员查看');
            appStatsChannelBySaler(appId, cId);
        }
        // 按渠道查看 -->按促销员查看
        if (methodFlag == 7) {
            //    alert('按渠道查看 -->按促销员查看');
            channlStatBySaler(cId);
        }
        // 按渠道查看 -->按促销员查看-->按应用查看
        if (methodFlag == 8) {
            //    alert('按渠道查看 -->按促销员查看-->按应用查看');
            salerStatsByApps(saler, cId);
        }
    }
}
// 判断是离线还在线应用  用于面包屑返回
function installTotal() {
    var flag = $("#marketFlag").val();
    getMarketStat(flag);
}
// 某应用按渠道查看 用于面包屑返回
function appGetMarketStatByChannelByButton() {
    var appId = $("#appId").val();
    appGetMarketStatByChannel(appId);
}
//  渠道下按促销员查看  用于面包屑返回
function channlStatBySalerByBuuton() {
    var cId = $("#cId").val();
    channlStatBySaler(cId);
}
function exportExcel() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#marketFlag").val();
    var methodFlag = $("#bookMethod").val();
    var cId = jQuery("#cId").val();
    var saler = jQuery("#saler").val();
    var appId = jQuery("#appId").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "GET",
        url: '/marketStatistics/exportExcel.action',
        data: {"startTime": startTime, "endTime": endTime, "channelId": cId, "saler": saler, "flag": flag, "methodFlag": methodFlag, "appId": appId},
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                window.open(data.excelDownAddress);
            } else {
                alert("系统错误：" + data.mess);
            }
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function salerRankingManager() {
    jQuery.ajax({
        type: "POST",
        url: '/salesStatistics/salerRankingManager.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
        }
    });
}

function salerRanking() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var averageInstallTimes = $("#averageInstallTimes").val();
    jQuery.ajax({
        type: "POST",
        url: '/salesStatistics/salerRanking.action',
        data: {"salerRankingParameter.startTime": startTime,
            "salerRankingParameter.endTime": endTime,
            "salerRankingParameter.averageInstallTimes": averageInstallTimes
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
        }
    });
}

function phoneInstallMess() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";

    myDate = new Date(year, month, 0);
    var endTime = year + "-" + month + "-" + myDate.getDate();
    jQuery.ajax({
        type: "POST",
        url: '/salesStatistics/phoneInstallMess.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            phoneInstallMessContent();
        }
    });
}
function phoneInstallMessContent() {
    var phoneImei = $("#phoneImei").val();
    var province = $("#province").val();
    var appName = $("#appName").val();
    var saleName = $("#saleName").val();
    var phoneModelName = $("#phoneModelName").val();
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/salesStatistics/phoneInstallMessContent.action',
        data: {
            "phoneIntallMessParameter.phoneImei": phoneImei,
            "phoneIntallMessParameter.cid": province,
            "phoneIntallMessParameter.appName": appName,
            "phoneIntallMessParameter.saleName": saleName,
            "phoneIntallMessParameter.phoneModelName": phoneModelName,
            "phoneIntallMessParameter.startTime": startTime,
            "phoneIntallMessParameter.endTime": endTime
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#phoneIntallMess').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function installMess() {
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/salesStatistics/dayInstallMess.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function provinceMonthly() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";
//    myDate = new Date(year, month, 0);
    var day = myDate.getDate();
    if (day < 10) {
        day = "0" + day
    }
    var endTime = year + "-" + month + "-" + day;

    jQuery.ajax({
        type: "POST",
        url: '/salesStatistics/provinceMonthly.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            provinceMonthlyContent();
        }
    });
}


function provinceMonthlyContent() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/salesStatistics/provinceMonthlyContent.action',
        data: {"provinceStatisParameter.startTime": startTime,
            "provinceStatisParameter.endTime": endTime},
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function statisticsExcel(flag) {
    var phoneImei = $("#phoneImei").val();
    var province = $("#province").val();
    var appName = $("#appName").val();
    var saleName = $("#saleName").val();
    var phoneModelName = $("#phoneModelName").val();
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/salesStatistics/statisticsExcel.action',
        data: {
            "phoneIntallMessParameter.phoneImei": phoneImei,
            "phoneIntallMessParameter.province": province,
            "phoneIntallMessParameter.appName": appName,
            "phoneIntallMessParameter.saleName": saleName,
            "phoneIntallMessParameter.phoneModelName": phoneModelName,
            "phoneIntallMessParameter.startTime": startTime,
            "phoneIntallMessParameter.endTime": endTime,
            "phoneIntallMessParameter.flag": flag,
            "flag": flag,
            "salerRankingParameter.startTime": startTime,
            "salerRankingParameter.endTime": endTime,
            "provinceStatisParameter.startTime": startTime,
            "provinceStatisParameter.endTime": endTime
        },
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                window.open(data.excelDownAddress);
                document.getElementById("Loading").style.display = "none";
                document.getElementById("Loading2").style.display = "none";
            } else {
                alert("系统错误：" + data.mess);
            }
        }
    });
}


function validMachineChoose() {
    var flag = $("#flag").val();
    var cid = $("#channelId").val();
    if (flag == 0) {
        validMachinesContent();
    } else if (flag == 1) {
        getChannelMachines();
    } else if (flag == 2) {
        validMachinesBySaler(cid);
    } else if (flag == 3) {
        validMachinesByTime(cid)
    }
}

function validMachines() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";

    myDate = new Date(year, month, 0);
    var endTime = year + "-" + month + "-" + myDate.getDate();

    jQuery.ajax({
        type: "POST",
        url: '/validmachines/validMachines.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            validMachinesContent();
        }
    });
}

function validMachinesContent() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    $("#flag").val(0);
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime},
        url: '/validmachines/validMachinesContent.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function getChannelMachines() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#flag").val(1);
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime
        },
        url: '/validmachines/getChannelMachines.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function validMachinesBySaler(cid) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#flag").val(2);
    $("#channelId").val(cid);
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime,
            "incomeParameter.cid": cid
        },
        url: '/validmachines/validMachinesBySaler.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function validMachinesByTime(cid) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#channelId").val(cid);
    $("#flag").val(3);
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime,
            "incomeParameter.cid": cid
        },
        url: '/validmachines/validMachinesByTime.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function validMachineExcel(excelFlag) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#flag").val();
    var cid = $("#channelId").val(cid);
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/validmachines/validMachineExcel.action',
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime,
            "incomeParameter.cid": cid,
            "incomeParameter.excelFlag": excelFlag,
            "flag": flag
        },
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                window.open(data.fileName);
            } else {
                alert("系统错误：" + data.mess);
            }
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function appCountChoose() {
    var flag = $("#flag").val();
    var accountId = $("#accountId").val();
    if (flag == 0) {
        getCountAppsByCp();
    } else if (flag == 1) {
        getCountAppsByApp(accountId);
    } else if (flag == 2) {

    }
}

function appCount() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";

    myDate = new Date(year, month, 0);
    var endTime = year + "-" + month + "-" + myDate.getDate();
    jQuery.ajax({
        type: "POST",
        url: '/appCounts/appCount.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            getCountAppsByCp();
        }
    });
}


function getCountAppsByCp() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#flag").val(0);
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"appCountParameter.startTime": startTime,
            "appCountParameter.endTime": endTime},
        url: '/appCounts/getCountAppsByCp.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function getCountAppsByApp(accountId) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#accountId").val(accountId);
    $("#flag").val(1);
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"appCountParameter.startTime": startTime,
            "appCountParameter.endTime": endTime,
            "appCountParameter.accountId": accountId
        },
        url: '/appCounts/getCountAppsByApp.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function provinceStatis() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";

    myDate = new Date(year, month, 0);
    var endTime = year + "-" + month + "-" + myDate.getDate();

    jQuery.ajax({
        type: "POST",
        url: '/validmachines/provinceStatis.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            provinceStatisContent();
        }
    });
}


function provinceStatisChoose() {
    var flag = $("#flag").val();
    var cid = $("#channelId").val();
    if (flag == 1) {
        provinceStatisContent();
    } else if (flag == 2) {
        provinceStatisBySaler(cid);
    } else if (flag == 3) {
        provinceStatisByTime(cid)
    }
}

function provinceStatisContent() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    $("#flag").val(1);
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime},
        url: '/validmachines/provinceStatisContent.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function provinceStatisByTime(cid) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#channelId").val(cid);
    $("#flag").val(3);
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime,
            "incomeParameter.cid": cid
        },
        url: '/validmachines/provinceStatisByTime.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function provinceStatisBySaler(cid) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#flag").val(2);
    $("#channelId").val(cid);
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime,
            "incomeParameter.cid": cid
        },
        url: '/validmachines/provinceStatisBySaler.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function instaisticNorm(cid) {
    var incomeTarget = $("#target" + cid).val();
    var deployPeople = $("#deployPeople" + cid).val();
    var everyPerphonesTarget = $("#everyPerphonesTarget" + cid).val();
    var time = $("#d5221").val();
    jQuery.ajax({
        Type: "POST",
        url: '/salesStatistics/incomeTarget.action',
        data: {
            "instaisticNorm.cid": cid,
            "instaisticNorm.incomeTarget": incomeTarget,
            "instaisticNorm.deployPeople": deployPeople,
            "instaisticNorm.everyPerphonesTarget": everyPerphonesTarget,
            "instaisticNorm.time": time
        },
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                provinceMonthlyContent();
            }
        }
    });
}


function salerActive() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";
    var day = myDate.getDate();
    if (day < 10) {
        day = "0" + day
    }
    var endTime = year + "-" + month + "-" + day;
    jQuery.ajax({
        type: "POST",
        url: '/salerActive/salerActive.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            salerActiveContent();
        }
    });
}

function salerActiveContent() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"startTime": startTime,
            "endTime": endTime},
        url: '/salerActive/salerActiveContent.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function provinceArrStatis() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";
    var day = myDate.getDate();
    if (day < 10) {
        day = "0" + day
    }
    var endTime = year + "-" + month + "-" + day;
    jQuery.ajax({
        type: "POST",
        url: '/provinceArrStatis/provinceArrStatis.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            provinceArrStatisTotal();
        }
    });
}


function provinceArrStatisTotal() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#methodFlag").val(0);
    $("#exportProvinceExcel").hide();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"provinceArrStatisParameter.startTime": startTime,
            "provinceArrStatisParameter.endTime": endTime},
        url: '/provinceArrStatis/provinceArrStatisTotal.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function provinceArrStatisByCid() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#methodFlag").val(1);
    $("#exportProvinceExcel").hide();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"provinceArrStatisParameter.startTime": startTime,
            "provinceArrStatisParameter.endTime": endTime},
        url: '/provinceArrStatis/provinceArrStatisByCid.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function provinceArrStatisBySaler(cid) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    $("#exportProvinceExcel").show();
    $("#methodFlag").val(2);
    $("#channelId").val(cid);
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        data: {"provinceArrStatisParameter.startTime": startTime,
            "provinceArrStatisParameter.endTime": endTime,
            "provinceArrStatisParameter.cid": cid
        },
        url: '/provinceArrStatis/provinceArrStatisBySaler.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function provinceArrStatisChoose() {
    var methodFlag = $("#methodFlag").val();
    var cid = $("#channelId").val();
    if (methodFlag == 0) {
        provinceArrStatisTotal();
    } else if (methodFlag == 1) {
        provinceArrStatisByCid()
    } else if (methodFlag == 2) {
        provinceArrStatisBySaler(cid)
    }
}

function exportProvinceArrExcel() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var cid = $("#channelId").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/provinceArrStatis/exportProvinceArrExcel.action',
        data: {"provinceArrStatisParameter.startTime": startTime,
            "provinceArrStatisParameter.endTime": endTime,
            "provinceArrStatisParameter.cid": cid,
            "metohFlag": 0
        },
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                window.open(data.excelDownAddress);
            } else {
                alert("系统错误：" + data.mess);
            }
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

/**  新版统计 **/

function newStatistic() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";
    myDate = new Date(year, month, 0);
    var endTime = year + "-" + month + "-" + myDate.getDate();
    jQuery.ajax({
        type: "POST",
        url: "/newStat/newStatistic.action",
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            var userCid = $("#userCid").val();
            if (userCid != 138) {
                channelType(userCid);
            } else {
                appInstallTotal();
            }
        }
    });
}

/**
 * 安装总量查询
 */
function appInstallTotal() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/newStat/appInstallTotal.action',
        data: {"marketStatInput.startTime": startTime, "marketStatInput.endTime": endTime},
        dataType: "html",
        success: function (msg) {
            jQuery("#marketStatic").html(msg);
            jQuery("#bookMethod").val(0);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function totalByChannel() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/newStat/totalByChannel.action',
        data: {"marketStatInput.startTime": startTime, "marketStatInput.endTime": endTime},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(1);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function channelType(cid) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var userCid = $("#userCid").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/newStat/channelType.action',
        data: {
            "marketStatInput.startTime": startTime,
            "marketStatInput.endTime": endTime,
            "marketStatInput.cid": cid,
            "marketStatInput.userCid": userCid
        },
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(6);
            jQuery("#marketStatic").html(msg);
            jQuery("#cId").val(cid);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function channelBySaler(cid, channelType) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var userCid = $("#userCid").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/newStat/channelBySaler.action',
        data: {
            "marketStatInput.startTime": startTime,
            "marketStatInput.endTime": endTime,
            "marketStatInput.cid": cid,
            "marketStatInput.channelType": channelType,
            "marketStatInput.userCid": userCid
        },
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(2);
            jQuery("#marketStatic").html(msg);
            jQuery("#cId").val(cid);
            jQuery("#channelType").val(channelType);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function channelBySalerDetails(saler) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var cid = $("#cId").val();
    var userCid = $("#userCid").val();
    var channelType = $("#channelType").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/newStat/channelBySalerDetails.action',
        data: {
            "marketStatInput.startTime": startTime,
            "marketStatInput.endTime": endTime,
            "marketStatInput.saler": saler,
            "marketStatInput.cid": cid,
            "marketStatInput.channelType": channelType,
            "marketStatInput.userCid": userCid
        },
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(3);
            jQuery("#saler").val(saler);
            jQuery("#parentId").val(saler);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function totalByApp() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#marketFlag").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/newStat/totalByApp.action',
        data: {"marketStatInput.startTime": startTime, "marketStatInput.endTime": endTime},
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(4);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function appBySalerNo(saler) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var parentId = $("#parentId").val();
    var cid = $("#cId").val();
    var userCid = $("#userCid").val();
    var channelType = $("#channelType").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/newStat/appBySalerNo.action',
        data: {
            "marketStatInput.startTime": startTime,
            "marketStatInput.endTime": endTime,
            "marketStatInput.saler": saler,
            "marketStatInput.parentId": parentId,
            "marketStatInput.cid": cid,
            "marketStatInput.channelType": channelType,
            "marketStatInput.userCid": userCid
        },
        dataType: "html",
        success: function (msg) {
            jQuery("#bookMethod").val(5);
            jQuery("#saler").val(saler);
            jQuery("#marketStatic").html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function staticticMethod() {
    var methodFlag = $("#bookMethod").val();
    var appId = jQuery("#appId").val();
    var cId = jQuery("#cId").val();
    var saler = jQuery("#saler").val();
    var channeltype = jQuery("#channelType").val();
    if (methodFlag != '') {
        if (methodFlag == 0) {
            appInstallTotal();
        } else if (methodFlag == 1) {
            totalByChannel();
        } else if (methodFlag == 2) {
            channelBySaler(cId, channeltype);
        } else if (methodFlag == 3) {
            channelBySalerDetails(saler);
        } else if (methodFlag == 4) {
            totalByApp();
        } else if (methodFlag == 5) {
            appBySalerNo(saler);
        } else if (methodFlag == 6) {
            channelType(cId);
        }
    }
}

function incomeStatistic() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var startTime = year + "-" + month + "-01";
    myDate = new Date(year, month, 0);
    var endTime = year + "-" + month + "-" + myDate.getDate();

    jQuery.ajax({
        type: "POST",
        url: '/incomeStatistic/incomeStatistic.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#appTable').html(msg);
            jQuery("#d5221").val(startTime);
            jQuery("#d5222").val(endTime);
            incomeStatisticContent();
        }
    });
}


function incomeStatisticContent() {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    $("#flag").val(1);
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime},
        url: '/incomeStatistic/incomeStatisticContent.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function incomeStatisticChannelType(cid) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    $("#flag").val(2);
    $("#channelId").val(cid);
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime,
            "incomeParameter.cid": cid,
        },
        url: '/incomeStatistic/incomeStatisticChannelType.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function incomeBySaler(channelType) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    $("#flag").val(3);
    var cid = $("#channelId").val();
    $("#channelType").val(channelType);
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime,
            "incomeParameter.cid": cid,
            "incomeParameter.channelType": channelType
        },
        url: '/incomeStatistic/incomeStatisticSaler.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function incomeStatisticBySalerDetails(salerNo) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    $("#flag").val(4);
    var cid = $("#channelId").val();
    var channelType = $("#channelType").val();
    $("#salerNo").val(salerNo);
    jQuery.ajax({
        type: "POST",
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime,
            "incomeParameter.salerNo": salerNo,
            "incomeParameter.cid": cid,
            "incomeParameter.channelType": channelType
        },
        url: '/incomeStatistic/incomeStatisticBySalerDetails.action',
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}
function incomeStatisChoose() {
    var method = $("#flag").val();
    var channelId = $("#channelId").val();
    var channelType = $("#channelType").val();
    var salerNo = $("#salerNo").val();
    if (method == 1) {
        incomeStatisticContent();
    } else if (method == 2) {
        incomeStatisticChannelType(channelId);
    } else if (method == 3) {
        incomeBySaler(channelType);
    } else if (method == 4) {
        incomeStatisticBySalerDetails(salerNo);
    }
}


function incomeStatisExcel(excelFlag) {
    var startTime = $("#d5221").val();
    var endTime = $("#d5222").val();
    var flag = $("#flag").val();
    var cid = $("#channelId").val();
    var salerNo = $("#salerNo").val();
    var channelType = $("#channelType").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/incomeStatistic/incomeStatisExcel.action',
        data: {"incomeParameter.startTime": startTime,
            "incomeParameter.endTime": endTime,
            "incomeParameter.cid": cid,
            "incomeParameter.channelType": channelType,
            "incomeParameter.excelFlag": excelFlag,
            "incomeParameter.salerNo": salerNo,
            "flag": flag
        },
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                window.open(data.fileName);
            } else {
                alert("系统错误：" + data.mess);
            }
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}