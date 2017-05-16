(function () {
    var object = document.getElementById("nav-user");
    if (object)object.className += " curr";//当前导航
    findAccountsList();
})();
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

function findAccountsList() {
    jQuery.ajax({
        type: "post",
        url: "/accountManager/list.action",
        data: {"page": 1},
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
        }
    });
}

function findRolesList() {
    jQuery.ajax({
        type: "post",
        url: "/roleManager/list.action",
        data: {"page": 1},
        dataType: "html",
        success: function (data) {
            jQuery('#content').html(data);
        }
    });
}


function doAdd() {
    if (jQuery.trim(jQuery('input[name="supportUsers.account"]').val()) == "") {
        alert("请输入用户名！");
    } else if (jQuery.trim(jQuery('input[name="supportUsers.password"]').val()) == "") {
        alert("请输入密码！");
    } else if (jQuery.trim(jQuery('input[name="supportUsers.password"]').val()).length < 6) {
        alert("密码长度不正确，请输入6～16位密码");
    } else if (jQuery.trim(jQuery("[name=supportUsers.password]").val()) != jQuery.trim(jQuery("[name=pwd]").val())) {
        alert("两次输入的密码不一致，请重新输入！");
    } else {
        var index = 0;
        for (var i = 0; i < jQuery('input[name="supportUsers.roleId"]').length; i++) {
            if (jQuery('input[name="supportUsers.roleId"]').get(i).checked) {
                index++;
                break;
            }

        }

        if (index == 0) {
            alert("请选择角色！");
        } else {
            var msg = jQuery('#msg').html();
            var roleId = 0;
            for (var i = 0; i < jQuery("[name=supportUsers.roleId]").length; i++) {
                if (jQuery("[name=supportUsers.roleId]").get(i).checked) {
                    roleId = jQuery("[name=supportUsers.roleId]").get(i).value;
                    break;
                }

            }

            if ("" == msg) {
                jQuery.ajax({
                    type: "post",
                    url: "/accountManager/doAdd.action",
                    data: {"supportUsers.account": jQuery.trim(jQuery('input[name="supportUsers.account"]').val()),
                        "supportUsers.password": jQuery.trim(jQuery('input[name="supportUsers.password"]').val()),
                        "supportUsers.roleId": roleId},
                    dataType: "html",
                    success: function (data) {
                        jQuery('#content').html(data);
                        jQuery('#closeDiv').click();
                    }
                });
            }
        }

    }

}

function doRoleAdd() {
    var moduleList = new Array();
    if (jQuery.trim(jQuery('input[name="supportRole.roleName"]').val()) == "") {
        alert("请输入角色名！");
    } else {
        var index = 0;
        for (var i = 0; i < jQuery('input[name="moduleList.SupportModule.moduleId"]').length; i++) {
            if (jQuery('input[name="moduleList.SupportModule.moduleId"]').get(i).checked) {
                moduleList.push(jQuery('input[name="moduleList.SupportModule.moduleId"]').get(i).value);
            }

        }

        if (moduleList.length == 0) {
            alert("请选择模块！");
        } else {
            var msg = jQuery('#msg').html();
            if ("" == msg) {
                jQuery.ajax({
                    type: "post",
                    url: "/roleManager/doAdd.action",
                    data: {"supportRole.roleName": jQuery.trim(jQuery('input[name="supportRole.roleName"]').val()),
                        "moduleList": moduleList.toString().trim()},
                    dataType: "html",
                    success: function (data) {
                        jQuery('#content').html(data);
                        jQuery('#closeDiv').click();
                    }
                });
            }

        }

    }

}


function modifiedPwd() {
    if (jQuery.trim(jQuery("[name=supportUsers.password]").val()) == "") {
        alert("请输入密码！");
    } else if (jQuery.trim(jQuery("[name=supportUsers.password]").val()) != jQuery.trim(jQuery("[name=pwd]").val())) {
        alert("两次输入的密码不一致，请重新输入！");
    } else if (jQuery.trim(jQuery('input[name="supportUsers.password"]').val()).length < 6) {
        alert("密码长度不正确，请输入6～16位密码");
    } else {
        jQuery.ajax({
            type: "post",
            url: "/accountManager/doModifiedPassWord.action",
            data: {"supportUsers.account": jQuery.trim(jQuery('input[name="supportUsers.account"]').val()),
                "supportUsers.password": jQuery.trim(jQuery('input[name="supportUsers.password"]').val())},
            dataType: "html",
            success: function (data) {
                jQuery('#content').html(data);
                jQuery('#closeDiv').click();
            }
        });
    }

}

function modifiedRole() {
    var roleId = 0;
    for (var i = 0; i < jQuery("[name=role]").length; i++) {
        if (jQuery("[name=role]").get(i).checked) {
            roleId = jQuery("[name=role]").get(i).value;
            break;
        }

    }

    if (roleId == 0) {
        alert("请选择角色！");
    } else {
        jQuery.ajax({
            type: "post",
            url: "/accountManager/doModifiedRole.action",
            data: {"supportUsers.account": jQuery.trim(jQuery('input[name="supportUsers.account"]').val()),
                "supportUsers.roleId": roleId},
            dataType: "html",
            success: function (data) {
                jQuery('#content').html(data);
                jQuery('#closeDiv').click();
            }
        });
    }

}

function modifiedStatus(status, account) {
    var boolean = false;
    if (0 == status && confirm("确认启用该用户账号吗?")) {
        boolean = true;
    }
    if (1 == status && confirm("用户账号被停用后，就不能再登录，确认要停用吗?")) {
        boolean = true;
    }
    if (boolean) {
        jQuery.ajax({
            type: "post",
            url: "/accountManager/doModifiedStatus.action",
            data: {"supportUsers.account": jQuery.trim(account),
                "supportUsers.accountStatus": jQuery.trim(status)},
            dataType: "html",
            success: function (data) {
                jQuery('#content').html(data);
            }
        });
    }
}

function doModifiedRole() {
    var moduleList = new Array();
    if (jQuery.trim(jQuery('input[name="supportRole.roleName"]').val()) == "") {
        alert("请输入角色名！");
    } else {
        var index = 0;
        for (var i = 0; i < jQuery('input[name="moduleList.SupportModule.moduleId"]').length; i++) {
            if (jQuery('input[name="moduleList.SupportModule.moduleId"]').get(i).checked) {
                moduleList.push(jQuery('input[name="moduleList.SupportModule.moduleId"]').get(i).value);
            }

        }

        if (moduleList.length == 0) {
            alert("请选择模块！");
        } else {
            var msg = jQuery('#msg').html();
            if ("" == msg) {
                jQuery.ajax({
                    type: "post",
                    url: "/roleManager/doModifiedRole.action",
                    data: {"supportRole.roleName": jQuery.trim(jQuery('input[name="supportRole.roleName"]').val()),
                        "supportRole.roleId": jQuery.trim(jQuery('input[name="supportRole.roleId"]').val()),
                        "moduleList": moduleList.toString()},
                    dataType: "html",
                    success: function (data) {
                        jQuery('#content').html(data);
                        jQuery('#closeDiv').click();
                    }
                });
            }

        }

    }

}


function openCreateUser() {
    jQuery("#confirmPop").css("width", "350px");
    jQuery("#confirmPop").css("height", "350px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        async: false,
        url: "/accountManager/add.action",
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}


function openModifiedPwd(account) {
    jQuery("#confirmPop").css("width", "350px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        async: false,
        url: "/accountManager/modifiedPassWord.action",
        data: {"supportUsers.account": account},
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function openModifiedRole(account, roleId) {
    jQuery("#confirmPop").css("width", "350px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        async: false,
        url: "/accountManager/modifiedRole.action",
        data: {"supportUsers.account": account,
            "supportUsers.roleId": roleId},
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function openCreateRole() {
    jQuery("#confirmPop").css("width", "880px");
    jQuery("#confirmPop").css("height", "700px");
    jQuery("#confirmPop").css("overflow", "auto");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        async: false,
        url: "/roleManager/add.action",
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function openModifiedModule(roleName, roleId) {
    jQuery("#confirmPop").css("width", "880px");
    jQuery("#confirmPop").css("height", "700px");
    jQuery("#confirmPop").css("overflow", "auto");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        async: false,
        url: "/roleManager/modifiedRole.action",
        data: {"supportRole.roleId": roleId,
            "supportRole.roleName": roleName},
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}


function clickRole(roleId) {
    jQuery('input[name="supportUsers.roleId"]').val(roleId)
}

function checkedRole() {
    jQuery.ajax({
        type: "post",
        url: "/roleManager/checkedRole.action",
        data: {"supportRole.roleName": jQuery.trim(jQuery('input[name="supportRole.roleName"]').val())},
        dataType: "json",
        success: function (data) {
            if ("error" == data) {
                jQuery('#msg').html("角色名已存在！");
            } else {
                jQuery('#msg').empty();
            }
            ;
            jQuery('input[name="moduleList.SupportModule.moduleId"]').focus();
        }
    });
}

function checkedAccount() {
    jQuery.ajax({
        type: "post",
        url: "/accountManager/checkedAccount.action",
        data: {"supportUsers.account": jQuery.trim(jQuery('input[name="supportUsers.account"]').val())},
        dataType: "json",
        success: function (data) {
            if ("error" == data) {
                jQuery('#msg').html("用户名已存在！");
            } else {
                jQuery('#msg').empty();
            }
            jQuery('input[name="supportUsers.password"]').focus();
        }
    });
}

function checkedPassword() {
    jQuery('#msg2').empty();
    if (jQuery.trim(jQuery('input[name="supportUsers.password"]').val()) != jQuery.trim(jQuery("[name=pwd]").val())) {
        jQuery('#msg2').html("两次输入的密码不一致，请重新输入！");
    }
}

function modifiedCheckedRole() {
    var roleName = jQuery.trim(jQuery('input[name="roleName"]').val());
    if (roleName != jQuery.trim(jQuery('input[name="supportRole.roleName"]').val())) {
        jQuery.ajax({
            type: "post",
            url: "/roleManager/checkedRole.action",
            data: {"supportRole.roleName": jQuery.trim(jQuery('input[name="supportRole.roleName"]').val())},
            dataType: "json",
            success: function (data) {
                if ("error" == data) {
                    jQuery('#msg').html("角色名已存在！");
                } else {
                    jQuery('#msg').empty();
                }
                jQuery('input[name="moduleList.SupportModule.moduleId"]').focus();
            }
        });
    } else {
        jQuery('#msg').empty();
        jQuery('input[name="moduleList.SupportModule.moduleId"]').focus();
    }

}


function deleteRole(roleId) {
    if (confirm("删除角色将会使该角色的用户无法再进行任何操作，确认删除吗?")) {
        jQuery.ajax({
            type: "post",
            url: "/roleManager/deleteRole.action",
            data: {"supportRole.roleId": roleId},
            dataType: "html",
            success: function (data) {
                jQuery('#content').html(data);
                jQuery('#closeDiv').click();
            }
        });
    }
}

function getClick(id, pid) {
    var firstCheckbox = jQuery('#' + id);
    if (firstCheckbox.attr("checked")) {
        selectedParent(id, pid);
        selectedChild(id, pid);
        firstCheckbox.checked = true;
    } else {
        cancelChild(id, pid);
        cancelParent(id, pid);
        firstCheckbox.checked = false;
    }
}

/**
 * 选中子级
 * @param id
 * @param pid
 */
function selectedChild(id, pid) {
    var checkboxName = jQuery('input[name="moduleList.SupportModule.moduleId"]');
    for (var i = 0; i < checkboxName.length; i++) {
        if (checkboxName.get(i).getAttribute("pid") == id) {
            checkboxName.get(i).checked = true;
            selectedChild(checkboxName.get(i).id, checkboxName.get(i).getAttribute("pid"))
        }
    }
}

/**
 * 选中父级
 * @param id
 * @param pid
 */
function selectedParent(id, pid) {
    var checkboxName = jQuery('input[name="moduleList.SupportModule.moduleId"]');
    for (var i = 0; i < checkboxName.length; i++) {
        if (checkboxName.get(i).id == pid) {
            checkboxName.get(i).checked = true;
            selectedParent(checkboxName.get(i).id, checkboxName.get(i).getAttribute("pid"))
        }
    }
}

/**
 * 取消子级选中状态
 * @param id
 * @param pid
 */
function cancelChild(id, pid) {
    var checkboxName = jQuery('input[name="moduleList.SupportModule.moduleId"]');
    for (var i = 0; i < checkboxName.length; i++) {
        if (checkboxName.get(i).getAttribute("pid") == id) {
            checkboxName.get(i).checked = false;
            cancelChild(checkboxName.get(i).id, checkboxName.get(i).getAttribute("pid"))
        }
    }
}

/**
 * 取消父级选中状态
 * @param id
 * @param pid
 */
function cancelParent(id, pid) {
    var count = 0;
    var checkboxName = jQuery('input[name="moduleList.SupportModule.moduleId"]');
    for (var i = 0; i < checkboxName.length; i++) {
        if (checkboxName.get(i).id != id && checkboxName.get(i).getAttribute("pid") == pid) {
            if (checkboxName.get(i).checked == true) {
                count++;
                break;
            }
        }
    }
    if (count == 0) {
        for (var j = 0; j < checkboxName.length; j++) {
            if (checkboxName.get(j).id == pid) {
                checkboxName.get(j).checked = false;
                cancelParent(checkboxName.get(j).id, checkboxName.get(j).getAttribute("pid"))
            }
        }
    }
}


//促销员管理
function salerDetailsManager() {
    var channelId = $("#channelId").val();
    var channelType = $("#channelType").val();
    var salerType = $("#salerType").val();
    var salerNo = $("#salerNo").val();
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        url: "/salerDetailsManager/salerDetailsManager.action",
        dataType: "html",
        data: {
            "salerDetailsParameter.cid": channelId,
            "salerDetailsParameter.salerType": salerType,
            "salerDetailsParameter.channelType": channelType,
            "salerDetailsParameter.salerNo": salerNo
        },
        success: function (data) {
            jQuery('#content').html(data);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
        }
    });
}


function createSalerDetails() {
    jQuery("#confirmPop").css("width", "450px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        url: "/salerDetailsManager/createSalerDetails.action",
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function saveSalerDetails() {
    var province = $("#province").val();
    var city = $("#city").val();
    var cityLevel = $("#cityLevel").val();
    var onlyCode = $("#onlyCode").val();
    var userName = $("#userName").val();
    var level = $("#level").val();
    var salerCategory = $("#salerCategory").val();
    var entryTime = $("#entryTime").val();
    var shopName = $("#shopName").val();
    var phoneNumber = $("#phoneNumber").val();
    jQuery.ajax({
        type: "post",
        data: {"salerDetails.province": province,
            "salerDetails.city": city,
            "salerDetails.cityLevel": cityLevel,
            "salerDetails.onlyCode": onlyCode,
            "salerDetails.userName": userName,
            "salerDetails.level": level,
            "salerDetails.salerCategory": salerCategory,
            "salerDetails.entryTime": entryTime,
            "salerDetails.shopName": shopName,
            "salerDetails.phoneNumber": phoneNumber
        },
        url: "/salerDetailsManager/saveSalerDetails.action",
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                salerDetailsManager();
            }
            $("#closeDiv").click()
        }
    });
}

function deleteSalerDetails(salerNo) {
    if (confirm("您确定要删除该促销员信息?")) {
        jQuery.ajax({
            type: "post",
            data: {"salerNo": salerNo},
            url: "/salerDetailsManager/deleteSalerDetails.action",
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    salerDetailsManager();
                }
            }
        });
    }
}

function modifySalerDetails(salerNo) {
    jQuery("#confirmPop").css("width", "450px");
    jQuery("#confirmPop").css("height", "360px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: "post",
        url: "/salerDetailsManager/modifySalerDetails.action",
        data: {"salerNo": salerNo},
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function updateSalerDetails(salerNo) {
    var cid = $("#channelId").val();
    var salerName = $("#salerName").val();
    var channelType = $("#updateChannelType").val();
    var salerType = $("#updateSalerType").val();
    var shopName = $("#shopName").val();
    var parentId = $("#parentId").val();
    if (salerType == 2 && parentId == null) {
        alert("当前省份无督导或者店长，无法修改为促销员！")
    } else {
        jQuery.ajax({
            type: "post",
            url: "/salerDetailsManager/updateSalerDetails.action",
            data: {
                "saler.salerNo": salerNo,
                "saler.cid": cid,
                "saler.salerName": salerName,
                "saler.channelType": channelType,
                "saler.salerType": salerType,
                "saler.shopName": shopName,
                "saler.parentId": parentId
            },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    salerDetailsManager();
                    $("#closeDiv").click()
                } else {
                    alert(data.mess);
                }
            }
        });
    }
}

function relevanceChannel(userId) {
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery("#confirmPop").css("width", "480px");
    jQuery("#confirmPop").css("height", "400px");
    jQuery.ajax({
        type: "POST",
        url: "/accountManager/relevanceChannel.action",
        data: {"userId": userId},
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}


function saveRelenvanceUser(userId) {
    var chkUpdatePrompt = document.getElementsByName("chkUpdatePrompt");
    var cid = '';
    for (var i = 0; i < chkUpdatePrompt.length; i++) {
        if (chkUpdatePrompt[i].checked) {
            cid = chkUpdatePrompt[i].value.toString();
            break;
        }
    }
    jQuery.ajax({
        type: "POST",
        url: "/accountManager/createChannelUser.action",
        data: {"channelUser.cid": cid,
            "channelUser.userId": userId
        },
        dataType: "json",
        success: function (data) {
            if (data == 1) {
                findAccountsList();
                $('#closeDiv').click();
            }
        }
    });
}


function chooseChannelType(val) {
    var html = "";
    if (val != '') {
        if (val == 0) {
            html = html + "<select style='margin-left: 2px' id='updateSalerType' onchange='changerSalerType(this.value)'>"
                + "<option value='0'>督导</option>"
                + "<option value='2'>促销员</option>"
                + "</select>"
            $("#salerTypeContent").html(html);
        } else if (val == 1) {
            html = html + "<select style='margin-left: 2px' id='updateSalerType' onchange='changerSalerType(this.value)'>"
                + "<option value='1'>店长</option>"
                + "<option value='2'>促销员</option>"
                + "</select>"
            $("#salerTypeContent").html(html);
        }

    }
}


function changerSalerType(val) {
    var cid = $("#channelId").val();
    var channelType = $("#updateChannelType").val();
    if (val == 2) {
        $("#parentIdContent").show();
        jQuery.ajax({
            type: "POST",
            url: "/salerDetailsManager/salerList.action",
            data: {"salerDetailsParameter.cid": cid,
                "salerDetailsParameter.channelType": channelType
            },
            dataType: "html",
            success: function (data) {
                $("#parentIdContent").html(data);
            }
        });
    } else {
        $("#parentIdContent").hide();
    }
}