var img = new Array();
for (i = 1; i < 6; i++) {
    img[i] = false;
}

function img_chk(sb) {
    if (eval("img[" + sb + "]") == false) {
        document.getElementById(sb).src = "images/checkbox_hover.png";
        eval("img[" + sb + "]=true");
    } else {
        document.getElementById(sb).src = "images/checkbox.png";
        eval("img[" + sb + "]=false");
    }
}

function findCategoryList(parentId) {
    jQuery.ajax({
        type: "post",
        url: "/categoryMaintenance/categoryList.action",
        data: {"page": 1,
            "parentId": parentId},
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
        }
    });
}

function findErpTaskList() {
    jQuery.ajax({
        type: "post",
        url: "/taskManager/erpList.action",
        data: {"page": 1,
            "taskInfoQuery.appName": jQuery.trim(jQuery('input[name="taskInfoQuery.appName"]').val()),
            "taskInfoQuery.status": jQuery("#status").val()},
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
        }
    });
}

function findLoopTaskList() {
    jQuery.ajax({
        type: "post",
        url: "/taskManager/loopList.action",
        data: {"page": 1},
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
        }
    });
}

function resetErpTask(id) {
    var status = jQuery("#status").val();
    jQuery.ajax({
        type: "post",
        url: "/taskManager/resetErpTask.action",
        data: {"page": 1,
            "taskInfoQuery.appName": jQuery.trim(jQuery('input[name="taskInfoQuery.appName"]').val()),
            "taskInfoQuery.status": status,
            "taskInfoQuery.id": id},
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
        }
    });
}

function immediatelyExec(taskTypeId) {
    if (confirm("确定要立即执行该任务？")) {
        jQuery.ajax({
            type: "post",
            url: "/taskManager/immediatelyExec.action",
            data: {"taskInfoQuery.taskTypeId": taskTypeId},
            dataType: "html",
            success: function (data) {
                jQuery('#content').html(data);
            }
        });
    }
}

function enable(id) {
    jQuery.ajax({
        type: "post",
        url: "/taskManager/enable.action",
        data: {"taskInfoQuery.id": id},
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
        }
    });
}

function disable(id) {
    jQuery.ajax({
        type: "post",
        url: "/taskManager/disable.action",
        data: {"taskInfoQuery.id": id},
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
        }
    });
}

function addCategory() {
    jQuery("#confirmPop").css("width", "450px");
    jQuery("#confirmPop").css("height", "400px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        async: false,
        url: "/categoryMaintenance/addCategory.action",
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}
function saveCategory() {
    var categoryName = jQuery("#categoryName").val();
    var categoryIntro = jQuery("#categoryIntro").val();
    var parentId = jQuery('#parentId').val();
    if (categoryName == "") {
        alert("类目名称不能为空");
    } else if (categoryIntro == "") {
        alert("类目简介不能为空");
    } else {
        jQuery.ajax({
            type: "post",
            async: false,
            url: "/categoryMaintenance/saveCategory.action",
            data: {"category.categoryName": categoryName,
                "category.intro": jQuery.trim(categoryIntro),
                "category.parentId": parentId},
            dataType: "html",
            success: function (data) {
                jQuery('#content').html(data);
                jQuery('#closeDiv').click();
            }
        });
    }
}

function openCategoryIntro(categoryId) {
    jQuery("#confirmPop").css("width", "450px");
    jQuery("#confirmPop").css("height", "400px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        async: false,
        url: "/categoryMaintenance/updateCategoryIntro.action",
        data: {"categoryId": categoryId},
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}
function doUpdateCategoryIntro() {
    var categoryId = jQuery('#categoryId').val();
    var categoryName = jQuery("#categoryName").val();
    var categoryIntro = jQuery("#categoryIntro").val();
    var parentId = jQuery('#parentId').val();
    jQuery.ajax({
        type: "post",
        async: false,
        url: "/categoryMaintenance/doUpdateCategoryIntro.action",
        data: {"category.categoryId": categoryId,
            "category.categoryName": categoryName,
            "category.intro": jQuery.trim(categoryIntro),
            "category.parentId": parentId},
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
            jQuery('#closeDiv').click();
        }
    });
}

function deleteCategory(categoryId) {
    var parentId = jQuery('#parentId').val();
    if (confirm('确认删除?')) {
        jQuery.ajax({
            type: "post",
            async: false,
            url: "/categoryMaintenance/deleteCategory.action",
            data: {"categoryId": categoryId,
                "parentId": parentId},
            dataType: "html",
            success: function (data) {
                jQuery('#content').html(data);
                jQuery('#closeDiv').click();
            }
        });
        return true;
    } else {
        return false;
    }
}

// pad管理
function padManager() {
    jQuery.ajax({
        type: "post",
        url: "/padImeiManager/padImeiList.action",
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
        }
    });
}

function addPadImei() {
    jQuery("#confirmPop").css("width", "450px");
    jQuery("#confirmPop").css("height", "200px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        url: "/padImeiManager/addPadImei.action",
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function savePadImei() {
    var imeiNumber = $("#imeiNumber").val();
    if (imeiNumber == '') {
        alert("IMEI号不能为空");
    } else {
        jQuery.ajax({
            type: "post",
            data: {"padImeiNumber.imeiNumber": imeiNumber},
            url: "/padImeiManager/savePadImei.action",
            dataType: "json",
            success: function (data) {
                if (data.status != 1) {
                    alert(data.mess)
                } else {
                    padManager();
                    jQuery('#closeDiv').click();
                }
            }
        });
    }
}


function deletePadImei(id) {
    if (confirm("确定要删除该IMEI号")) {
        jQuery.ajax({
            type: "post",
            data: {"id": id},
            url: "/padImeiManager/deletePadImei.action",
            dataType: "json",
            success: function (data) {
                if (data.status != 1) {
                    alert(data.mess)
                } else {
                    padManager();
                }
            }
        });
    }
}
function modifyPadImei(padImeiNumber) {
    jQuery("#confirmPop").css("width", "450px");
    jQuery("#confirmPop").css("height", "200px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        url: "/padImeiManager/modifyPadImei.action",
        data: {"imeiNumber": padImeiNumber},
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}
function saveModifyPadImei(id) {
    var imeiNumber = $("#imeiNumber").val();
    if (imeiNumber == '') {
        alert("IMEI号不能为空");
    } else {
        jQuery.ajax({
            type: "post",
            data: {"padImeiNumber.imeiNumber": imeiNumber,
                "padImeiNumber.id": id
            },
            url: "/padImeiManager/saveModifyPadImei.action",
            dataType: "json",
            success: function (data) {
                if (data.status != 1) {
                    alert(data.mess)
                } else {
                    padManager();
                    jQuery('#closeDiv').click();
                }
            }
        });
    }
}

// 应用价格设置
function appPrice() {
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    var chargeArea = $("#chargeAreaHidden").val();
    var chargeModel = $("#chargeModelHidden").val();
    var appName = $("#appNameHidden").val();
    var topicId = $("#topicIdHidden").val();
    jQuery.ajax({
        type: "post",
        url: "/appPrice/appPrice.action",
        dataType: "html",
        data: {
            "appPriceParameter.chargeArea": chargeArea,
            "appPriceParameter.chargeModel": chargeModel,
            "appPriceParameter.appName": appName,
            "appPriceParameter.topicId": topicId
        },
        success: function (data) {
            jQuery('#content').html(data);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}

function createAppPrice() {
    jQuery("#confirmPop").css("width", "450px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        url: "/appPrice/createAppPrice.action",
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function saveAppPrice() {
    var appPriceList = document.getElementsByName("appPrice");
    var appid = '';
    for (var i = 0; i < appPriceList.length; i++) {
        if (appPriceList[i].checked) {
            appid = appPriceList[i].value.toString();
            break;
        }
    }
    var chargeArea = $("#chargeArea").val();
    var chargeModel = $("#chargeModel").val();
    var price = $("#price").val();
    var chargeCompany = $("#chargeCompany").val();
    if (appid == '') {
        alert("请选择应用!");
    } else if (chargeArea == '') {
        alert("请选择计费区域!");
    } else if (chargeModel == '') {
        alert("请选择计费模式！");
    } else if (price == '') {
        alert("请设置价格！");
    } else {
        jQuery.ajax({

            type: "post",
            data: {
                "appPrice.chargeModel": chargeModel,
                "appPrice.chargeArea": chargeArea,
                "appPrice.appid": appid,
                "appPrice.price": price,
                "appPrice.chargeCompany": chargeCompany
            },
            url: "/appPrice/saveAppPrice.action",
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    appPrice();
                    jQuery('#close').click();
                } else {
                    alert(data.mess)
                }
            }
        });
    }
}

function changeCompany(val) {
    if (val != null && val != '') {
        if (val == 0) { // 如果计费地区是按总公司的话，需要按应用区分计费所属的公司
            $("#company").show();
        } else if (val == 1) {
            $("#company").hide();
        }

    }
}


function modifyAppPrice(id) {
    jQuery("#confirmPop").css("width", "450px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        url: "/appPrice/modifyAppPrice.action",
        dataType: "html",
        data: {"id": id},
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function updateAppPrice(id) {
    var appid = $("#appId").val();
    var chargeArea = $("#chargeArea").val();
    var chargeModel = $("#chargeModel").val();
    var price = $("#price").val();
    var chargeCompany = $("#chargeCompany").val();
    jQuery.ajax({
        type: "post",
        data: {
            "appPrice.chargeModel": chargeModel,
            "appPrice.chargeArea": chargeArea,
            "appPrice.appid": appid,
            "appPrice.price": price,
            "appPrice.id": id,
            "appPrice.chargeCompany": chargeCompany
        },
        url: "/appPrice/updateAppPrice.action",
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                appPrice();
                jQuery('#close').click();
            } else {
                alert(data.mess)
            }
        }
    });
}

function deleteAppPrice(id) {
    if (confirm("您确定要删除？")) {
        jQuery.ajax({
            type: "post",
            data: {
                "id": id
            },
            url: "/appPrice/deleteAppPrice.action",
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    appPrice();
                    jQuery('#close').click();
                } else {
                    alert(data.mess)
                }
            }
        });
    }
}


function exceptionLogContent() {
    var padImei = $("#padImei").val();
    var saler = $("#saler").val();
    var exceptionType = $("#exceptionType").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: '/exceptionLog/exceptionLogContent.action',
        data: {
            "exceptionLogInput.padImei": padImei,
            "exceptionLogInput.saler": saler,
            "exceptionLogInput.exceptionType": exceptionType,
            "page": 1
        },
        dataType: "html",
        success: function (msg) {
            jQuery('#content').html(msg);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}



