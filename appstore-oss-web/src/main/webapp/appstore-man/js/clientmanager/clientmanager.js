(function () {
    var object = document.getElementById("nav-client");
    if (object)object.className += " curr";//当前导航
//    var active = document.getElementById("menu_1");
//    if (active)active.className += "active";//当前位置
    getCPServer();
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


function emptyLogoUrl() {
    document.getElementById('logoUrl').value = '';
}

function selectPhoneLogoStyle(obj) {
    var style = obj.value;
    if (obj.value == 0) {
        document.getElementById('uploadLogo').style.display = 'none';
        jQuery('#url').val('');
    } else {
        document.getElementById('uploadLogo').style.display = 'block';
    }
}


function loadTip() {
    // alert("aaaaaaaaaaaaaa");
    var areaId = document.getElementById('areaId').value;
    var moduleId = document.getElementById('moduleId').value;
    if (areaId == 0) {
        $('#tip').empty().append('建议图片尺寸：580*276');
    }
    if (areaId == 9) {
        $('#tip').empty().append('建议图片尺寸：302*153');
    } else if (areaId == 7 || areaId == 8) {
        $('#tip').empty().append('建议图片尺寸：100*100');
    } else if (areaId == 21) {
        $('#tip').empty().append('建议图片尺寸：990*90');
    } else if (areaId == 22 || areaId == 23) {
        $('#tip').empty().append('建议图片尺寸：110*375');
    }
    if (moduleId == 0) {
        if (areaId == 2) {
            $('#tip').empty().append('建议图片尺寸：165*120');
        } else if (areaId == 12) {
            $('#tip').empty().append('建议图片尺寸：80*80');
        } else if (areaId == 3) {
            $('#tip').empty().append('建议图片尺寸：220*220');
        } else if (areaId == 4 || areaId == 5) {
            $('#tip').empty().append('建议图片尺寸：130*130');
        } else if (areaId == 6) {
            $('#tip').empty().append('建议图片尺寸：218*138');
        }
    } else if (moduleId == 3) {
        if (areaId == 1) {
            $('#tip').empty().append('建议图片尺寸：180*85');
        } else if (areaId == 2) {
            $('#tip').empty().append('建议图片尺寸：220*220');
        }
    } else {
        if (areaId == 1) {
            $('#tip').empty().append('建议图片尺寸：180*85');
        } else if (areaId == 2) {
            $('#tip').empty().append('建议图片尺寸：220*220');
        } else if (areaId == 3) {
            $('#tip').empty().append('建议图片尺寸：220*220');
        } else if (areaId == 4) {
            $('#tip').empty().append('建议图片尺寸：100*100');
        } else if (areaId == 5) {
            $('#tip').empty().append('建议图片尺寸：100*100');
        }
    }
}


/*
 选择图片类型，创建推广内容时是选择应用主图还是手动上传图片做推广图片
 */
function selectLogoStyle(obj) {
    var style = obj.value;
    if (obj.value == 0) {
        document.getElementById('uploadLogo').style.display = 'none';
        jQuery('#url').val('');
    } else {
        document.getElementById('uploadLogo').style.display = 'block';
        var areaId = document.getElementById('areaId').value;
        var moduleId = document.getElementById('moduleId').value;
        if (areaId == 0) {
            $('#tip').empty().append('建议图片尺寸：580*276');
        }
        if (areaId == 9) {
            $('#tip').empty().append('建议图片尺寸：302*153');
        } else if (areaId == 7 || areaId == 8) {
            $('#tip').empty().append('建议图片尺寸：100*100');
        } else if (areaId == 21) {
            $('#tip').empty().append('建议图片尺寸：990*90');
        } else if (areaId == 22 || areaId == 23) {
            $('#tip').empty().append('建议图片尺寸：110*375');
        }
        if (moduleId == 0) {
            if (areaId == 2) {
                $('#tip').empty().append('建议图片尺寸：165*120');
            } else if (areaId == 12) {
                $('#tip').empty().append('建议图片尺寸：80*80');
            } else if (areaId == 3) {
                $('#tip').empty().append('建议图片尺寸：220*220');
            } else if (areaId == 4 || areaId == 5) {
                $('#tip').empty().append('建议图片尺寸：130*130');
            } else if (areaId == 6) {
                $('#tip').empty().append('建议图片尺寸：218*138');
            }
        } else if (moduleId == 3) {
            if (areaId == 1) {
                $('#tip').empty().append('建议图片尺寸：180*85');
            } else if (areaId == 2) {
                $('#tip').empty().append('建议图片尺寸：220*220');
            }
        } else {
            if (areaId == 1) {
                $('#tip').empty().append('建议图片尺寸：180*85');
            } else if (areaId == 2) {
                $('#tip').empty().append('建议图片尺寸：220*220');
            } else if (areaId == 3) {
                $('#tip').empty().append('建议图片尺寸：220*220');
            } else if (areaId == 4) {
                $('#tip').empty().append('建议图片尺寸：100*100');
            } else if (areaId == 5) {
                $('#tip').empty().append('建议图片尺寸：100*100');
            }
        }
    }
}


// 选择连接类型，linkType为2时初始化类目信息
function selectLinkType() {
    emptyLogoUrl();
    loadPhoneLinkType();
}


function selectPCLinkType() {
    emptyLogoUrl();
    loadLinkType();
}


//初始换手机客户端的链接类型
function loadPhoneLinkType() {
    var linkType = document.getElementById('linkType').value;
    var html;
    if (linkType == 0) {
        html = '<td valign="top"><label>选择应用：</label></td>';
        html += '<td valign="top"  style="margin-left: 8px;"><p><input class="input" style="width:145px;" type="text" id="appName"/><input class="btn" type="button" value="搜 索" onclick="searchAppForMobile();"/>'
    } else if (linkType == 1) {
        html = '<td valign="top"><label>选择专题：</label></td>';
        html += '<td valign="top"  style="margin-left: 8px;"><p><input class="input" style="width:145px;" type="text" id="topicName"/><input class="btn" type="button" value="搜 索" onclick="searchTopicForRecommend();"/>'
    } else if (linkType == 2) {
        jQuery.ajax({
            type: 'post',
            url: '/recommendManager/initParentId.action',
            dataType: 'json',
            complete: function (data) {
                var result = eval("(" + data.responseText + ")");
                var pcae = document.getElementById('currentPCategory');
                html = '<td valign="top"><label>选择类目：</label></td>';

                if (pcae == null) {
                    html = '<td valign="top"><label>选择类目：</label></td>';
                    html += '<td valign="top"><p>二级类目：<select id="parentId" onchange="loadCategory();"><option value="' + result.map.mobileSoftId + '" selected>移动软件</option><option value="' + result.map.mobileGameId + '">移动游戏</option></select>';

                }
                else {
                    var pca = jQuery.trim(pcae.value);
                    html += '<td valign="top"><p>二级类目：<select id="parentId" onchange="loadCategory();"><option value="' + result.map.mobileSoftId + '" ';
                    if (pca == '移动软件') {
                        html += 'selected';
                    }
                    html += '>移动软件</option><option value="' + result.map.mobileGameId + '" ';
                    if (pca == '移动游戏') {
                        html += 'selected';
                    }
                    html += '>移动游戏</option></select>';
                }

                html += '<p>三级类目：<select id="childId">';
                html += '</select></p>';
                html += '<div id="result"></div></p></td>';
                jQuery('#linkTypeModel').empty().append(html);
                loadCategory();
            }
        });
    }
    html += '<div id="result"></div></p></td>';
    jQuery('#linkTypeModel').empty().append(html);
}


function loadLink(linkType) {
    var moduleId = document.getElementById('moduleId').value;
    var areaId = document.getElementById('areaId').value;
    var ttt = document.getElementById('linkType');
    ttt.length = 0;
    if (moduleId != 3) {
        if (areaId == 0 || areaId == 1 || areaId == 21 || areaId == 10 || areaId == 11) {
            var option1 = new Option("应用", "0");
            var option2 = new Option("专题", "1");
            var option3 = new Option("类目", "2");
            var option4 = new Option("外链", "3");
            ttt.add(option1);
            ttt.add(option2);
            ttt.add(option3);
            ttt.add(option4);
        } else if (areaId == 2 || areaId == 3 || areaId == 4 || areaId == 5 || areaId == 6 || areaId == 7 || areaId == 8 || areaId == 12) {
            var option = new Option("应用", "0");
            ttt.add(option);
        } else if (areaId == 9) {
            var option = new Option("专题", "1");
            ttt.add(option);
        }
    } else {
        var option1 = new Option("应用", "0");
        var option2 = new Option("类目", "2");
        var option3 = new Option("外链", "3");
        ttt.add(option1);
        ttt.add(option2);
        ttt.add(option3);
    }
    $('#linkType').get(0).value = linkType;
    loadLinkType();
}

function loadLinkType() {
    var linkType = document.getElementById('linkType').value;
    var moduleId = document.getElementById('moduleId');
    var html;
    if (linkType == 0) {
        html = '<td valign="top"><label>选择应用：</label></td>';
        if (moduleId != null) {
            var tempModuleValue = document.getElementById('moduleId').value;
            if (tempModuleValue == 1) {
                html += '<td valign="top"><p><input id="appName" class="input" style="width:145px;" type="text" /><input class="btn" type="button" value="搜 索" onclick="searchAppForSoft();"/>';
            } else if (tempModuleValue == 2) {
                html += '<td valign="top"><p><input id="appName" class="input" style="width:145px;" type="text" /><input class="btn" type="button" value="搜 索" onclick="searchAppForGame();"/>';
            } else if (tempModuleValue == 3) {
                html += '<td valign="top"><p><input id="appName" class="input" style="width:145px;" type="text" /><input class="btn" type="button" value="搜 索" onclick="searchAppForWeb();"/>';
            } else {
                var areaId = document.getElementById('areaId').value;
                if (areaId == 4) {
                    html += '<td valign="top"><p><input id="appName" class="input" style="width:145px;" type="text" /><input class="btn" type="button" value="搜 索" onclick="searchAppForSoft();"/>';
                } else if (areaId == 5) {
                    html += '<td valign="top"><p><input id="appName" class="input" style="width:145px;" type="text" /><input class="btn" type="button" value="搜 索" onclick="searchAppForGame();"/>';
                } else if (areaId == 6) {
                    html += '<td valign="top"><p><input id="appName" class="input" style="width:145px;" type="text" /><input class="btn" type="button" value="搜 索" onclick="searchAppForWeb();"/>';
                } else {
                    html += '<td valign="top"><p><input id="appName" class="input" style="width:145px;" type="text" /><input class="btn" type="button" value="搜 索" onclick="searchAppForRecommend();"/>';
                }
            }
        } else {
            html += '<td valign="top"><p><input id="appName" class="input" style="width:145px;" type="text" /><input class="btn" type="button" value="搜 索" onclick="searchAppForRecommend();"/>';
        }
        html += '<div id="result"></div></p></td>';
        jQuery('#linkTypeModel').empty().append(html);
    } else if (linkType == 1) {
        html = '<td valign="top"><label>选择专题：</label></td>';
        html += '<td valign="top"><p><input id="topicName" class="input" style="width:145px;" type="text"/><input class="btn" type="button" value="搜 索" onclick="searchTopicForRecommend();"/>';
        html += '<div id="result"></div></p></td>';
        jQuery('#linkTypeModel').empty().append(html);
    } else if (linkType == 2) {
        if (moduleId != null) {
            var moduleIdValue = document.getElementById('moduleId').value;
            if (moduleIdValue == 3) {
                jQuery.ajax({
                    type: 'POST',
                    url: '/recommendManager/initWebParentId.action',
                    dataType: 'json',
                    complete: function (data) {
                        var result = eval("(" + data.responseText + ")");


                        html = '<td valign="top"><label>选择类目：</label></td>';
                        html += '<td valign="top"><p>二级类目：<select id="parentId" onchange="loadCategory();"><option value="' + result.map.webAppId + '" selected>网页应用</option></select>';

                        html += '<p>三级类目：<select id="childId">';
                        html += '</select></p>';
                        html += '<div id="result"></div></p></td>';
                        jQuery('#linkTypeModel').empty().append(html);
                        loadCategory();
                    }
                });
            } else {
                jQuery.ajax({
                    type: 'post',
                    url: '/recommendManager/initParentId.action',
                    dataType: 'json',
                    complete: function (data) {
                        var result = eval("(" + data.responseText + ")");
                        var pcae = document.getElementById('currentPCategory');
                        html = '<td valign="top"><label>选择类目：</label></td>';

                        if (pcae == null) {
                            html = '<td valign="top"><label>选择类目：</label></td>';
                            html += '<td valign="top"><p>二级类目：<select id="parentId" onchange="loadCategory();"><option value="' + result.map.mobileSoftId + '" selected>移动软件</option><option value="' + result.map.mobileGameId + '">移动游戏</option></select>';

                        }
                        else {
                            var pca = jQuery.trim(pcae.value);
                            html += '<td valign="top"><p>二级类目：<select id="parentId" onchange="loadCategory();"><option value="' + result.map.mobileSoftId + '" ';
                            if (pca == '移动软件') {
                                html += 'selected';
                            }
                            html += '>移动软件</option><option value="' + result.map.mobileGameId + '" ';
                            if (pca == '移动游戏') {
                                html += 'selected';
                            }
                            html += '>移动游戏</option></select>';
                        }
                        html += '<p>三级类目：<select id="childId">';
                        html += '</select></p>';
                        html += '<div id="result"></div></p></td>';
                        jQuery('#linkTypeModel').empty().append(html);
                        loadCategory();
                    }
                });
            }
        } else {
            jQuery.ajax({
                type: 'post',
                url: '/recommendManager/initParentId.action',
                dataType: 'json',
                complete: function (data) {
                    var result = eval("(" + data.responseText + ")");
                    var pcae = document.getElementById('currentPCategory');
                    html = '<td valign="top"><label>选择类目：</label></td>';

                    if (pcae == null) {
                        html = '<td valign="top"><label>选择类目：</label></td>';
                        html += '<td valign="top"><p>二级类目：<select id="parentId" onchange="loadCategory();"><option value="' + result.map.mobileSoftId + '" selected>移动软件</option><option value="' + result.map.mobileGameId + '">移动游戏</option></select>';

                    }
                    else {
                        var pca = jQuery.trim(pcae.value);
                        html += '<td valign="top"><p>二级类目：<select id="parentId" onchange="loadCategory();"><option value="' + result.map.mobileSoftId + '" ';
                        if (pca == '移动软件') {
                            html += 'selected';
                        }
                        html += '>移动软件</option><option value="' + result.map.mobileGameId + '" ';
                        if (pca == '移动游戏') {
                            html += 'selected';
                        }
                        html += '>移动游戏</option></select>';
                    }


                    html += '<p>三级类目：<select id="childId">';
                    html += '</select></p>';
                    html += '<div id="result"></div></p></td>';
                    jQuery('#linkTypeModel').empty().append(html);
                    loadCategory();
                }
            });
        }

    } else if (linkType == 3) {
        html = '<td valign="top"><label>外链地址：</label></td>';
        html += '<td valign="top"><p><input id="linkedUrl" class="input" style="width:324px;" type="text"/>';
        html += '<div id="result"></div></p></td>';
        jQuery('#linkTypeModel').empty().append(html);
        loadLinkedUrl();
    }

}


function loadLinkedUrl() {
    var lu = jQuery.trim(document.getElementById('currentLinkedUrl').value);
    document.getElementById('linkedUrl').value = lu;
}


function searchAppForMobile() {
    var appName = jQuery.trim(document.getElementById('appName').value);
    var html = '';
    if (appName != '') {
        jQuery.ajax({
            type: 'POST',
            url: '/search/SearchAppForMobile.action',
            data: 'appName=' + appName,
            dataType: 'html',
            success: function (data) {
                jQuery('#result').html(data);
            }
        });
    } else {
        alert('请输入搜索条件');
    }
}


function searchAppForSoft() {
    var appName = jQuery.trim(document.getElementById('appName').value);
    var html = '';
    if (appName != '') {
        jQuery.ajax({
            type: 'POST',
            url: '/search/SearchAppForSoft.action',
            data: 'appName=' + appName,
            dataType: 'html',
            success: function (data) {
                jQuery('#result').html(data);
            }
        });
    } else {
        alert('请输入搜索条件');
    }
}


function searchAppForGame() {
    var appName = jQuery.trim(document.getElementById('appName').value);
    var html = '';
    if (appName != '') {
        jQuery.ajax({
            type: 'POST',
            url: '/search/SearchAppForGame.action',
            data: 'appName=' + appName,
            dataType: 'html',
            success: function (data) {
                jQuery('#result').html(data);
            }
        });
    } else {
        alert('请输入搜索条件');
    }
}


function searchAppForWeb() {
    var appName = jQuery.trim(document.getElementById('appName').value);
    var html = '';
    if (appName != '') {
        jQuery.ajax({
            type: 'POST',
            url: '/search/SearchAppForWeb.action',
            data: 'appName=' + appName,
            dataType: 'html',
            success: function (data) {
                jQuery('#result').html(data);
            }
        });
    } else {
        alert('请输入搜索条件');
    }
}


//推荐中搜索应用
function searchAppForRecommend() {
    var appName = jQuery.trim(document.getElementById('appName').value);
    var html = '';
    if (appName != '') {
        jQuery.ajax({
            type: 'POST',
            url: '/search/SearchAppForRecommend.action',
            data: 'appName=' + appName,
            dataType: 'html',
            success: function (data) {
                jQuery('#result').html(data);
            }
        });
    } else {
        alert('请输入搜索条件');
    }
}


//推荐中搜索专题
function searchTopicForRecommend() {
    var topicName = jQuery.trim(document.getElementById('topicName').value);
    var html = '';
    if (topicName != '') {
        jQuery.ajax({
            type: 'POST',
            url: '/search/SearchTopicForRecommend.action',
            data: 'topicName=' + topicName,
            dataType: html,
            success: function (data) {
                jQuery('#result').html(data);
            }
        });
    } else {
        alert('请输入检索内容')
    }
}


//初始化类目
function loadCategory() {
    var parentCategory = document.getElementById('parentId').value;
    var ca = document.getElementById('currentCategory');
    var cv = 0;
    jQuery.ajax({
        type: 'POST',
        url: '/search/searchCategoryJson.action',
        data: 'category.parentId=' + parentCategory,
        dataType: 'json',
        complete: function (data) {
            var result = eval("(" + data.responseText + ")");
            var selector = document.getElementById('childId');
            selector.length = 0;
            for (var i = 0; i < result.map.categorys.length; i++) {
                if (ca != null) {
                    var tmpca = jQuery.trim(ca.value);
                    if (tmpca == result.map.categorys[i].categoryName) {
                        cv = i;
                    }
                }

                var category = new Option(result.map.categorys[i].categoryName, result.map.categorys[i].categoryId + "," + result.map.categorys[i].logoUrl);
                selector.add(category);
            }
            selector.selectedIndex = cv;
        }
    });
}


/*获取WEB网站首页的推广内容*/
function getWebRecommend() {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/getWebRecommend.action',
        data: 'clientType=3&moduleId=0&areaId=0',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            jQuery('#clientType').val(3);
            loadModuleId(3, 0, 0);
        }
    });
}


/*获取Phone客户端的首页推广内容*/
function getPhoneRecommend() {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/getPhoneRecommend.action',
        data: 'clientType=0&moduleId=0&areaId=10',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
        }
    });
}


/*获取Pad客户端的首页推广内容*/
function getPadRecommend() {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/getPadRecommend.action',
        data: 'clientType=1&moduleId=0&areaId=11',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
        }
    });
}


//更新手机推荐中内容的发布状态
function updatePhoneRecommendPubedStatus(id, pubedStatus) {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/updatePhonePubedStatus.action',
        data: 'recommendManagerResult.clientType=0&recommendManagerResult.moduleId=0&recommendManagerResult.areaId=10&recommendManagerResult.homeAreaId=' + id + '&recommendManagerResult.pubedStatus=' + pubedStatus,
        dataType: 'html',
        success: function (data) {
            getPhoneRecommend();
        }
    });
}


//推荐Pad客户端推荐内容的发布状态
function updatePadRecommendPubedStatus(id, pubedStatus) {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/updatePhonePubedStatus.action',
        data: 'recommendManagerResult.clientType=1&recommendManagerResult.moduleId=0&recommendManagerResult.areaId=11&recommendManagerResult.homeAreaId=' + id + '&recommendManagerResult.pubedStatus=' + pubedStatus,
        dataType: 'html',
        success: function (data) {
            getPadRecommend();
        }
    });
}


/*获取PC客户端首页的推广内容*/
function getPCRecommend() {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/getPCRecommend.action',
        data: 'clientType=2&moduleId=0&areaId=0',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            jQuery('#clientType').val(2);
            loadModuleId(2, 0, 0);
        }
    });
}


function getCPServer() {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/getCPServer.action',
        data: 'clientType=4&moduleId=0&areaId=13',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
        }
    });
}


//获取推荐内容
function getWebRecommendAll(clientType, moduleId, areaId) {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/getWebRecommend.action',
        data: 'clientType=' + clientType + '&moduleId=' + moduleId + '&areaId=' + areaId,
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            jQuery('#clientType').val(clientType);
            //alert("moduleId="+moduleId+" areaId = " + areaId);
            jQuery('#moduleId').get(0).value = moduleId;
            loadModuleId(clientType, moduleId, areaId);
        }
    });
}


//获取PC推荐的所有内容
function getPCRecommendAll(clientType, moduleId, areaId) {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/getPCRecommend.action',
        data: 'clientType=' + clientType + '&moduleId=' + moduleId + '&areaId=' + areaId,
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            jQuery('#clientType').val(clientType);
            jQuery('#moduleId').get(0).value = moduleId;
            //alert("moduleid = " + moduleId + " areaId = " + areaId + " clientType = " + clientType);
            loadModuleId(clientType, moduleId, areaId);
        }
    });
}


//初始化模块
function loadModuleId(client, module, area) {
    //alert("modu = " + module + " area = " + area + " client = " + client);
    if (client == 2) {
        if (module == 0) {
            jQuery("#areaId").append("<option value='0'>Banner</option>");
            jQuery("#areaId").append("<option value='2'>热门推荐(W)</option>");
            jQuery("#areaId").append("<option value='12'>热门推荐(P)</option>");
            jQuery("#areaId").append("<option value='3'>新品推荐</option>");
            jQuery("#areaId").append("<option value='5'>移动游戏精品</option>");
            jQuery("#areaId").append("<option value='4'>移动软件精品</option>");
            jQuery("#areaId").append("<option value='6'>网页应用精品(W)</option>");
            jQuery("#areaId").append("<option value='9'>专题推荐</option>");
            jQuery("#areaId").append("<option value='7'>男生专区</option>");
            jQuery("#areaId").append("<option value='8'>女生专区</option>");
            jQuery("#areaId").append("<option value='21'>通栏广告(W)</option>");
        } else if (module == 1) {
            jQuery("#areaId").append("<option value='0'>Banner</option>");
            jQuery("#areaId").append("<option value='1'>右侧推荐栏(W)</option>");
            jQuery("#areaId").append("<option value='2'>热门推荐</option>");
            jQuery("#areaId").append("<option value='3'>新品推荐</option>");
            jQuery("#areaId").append("<option value='4'>精品软件(P)</option>");
            jQuery("#areaId").append("<option value='9'>专题推荐</option>");
            jQuery("#areaId").append("<option value='7'>男生专区</option>");
            jQuery("#areaId").append("<option value='8'>女生专区</option>");
            jQuery("#areaId").append("<option value='21'>通栏广告(W)</option>");
        } else if (module == 2) {
            jQuery("#areaId").append("<option value='0'>Banner</option>");
            jQuery("#areaId").append("<option value='1'>右侧推荐栏(W)</option>");
            jQuery("#areaId").append("<option value='2'>热门推荐</option>");
            jQuery("#areaId").append("<option value='3'>新品推荐</option>");
            jQuery("#areaId").append("<option value='5'>精品游戏(P)</option>");
            jQuery("#areaId").append("<option value='9'>专题推荐</option>");
            jQuery("#areaId").append("<option value='7'>男生专区</option>");
            jQuery("#areaId").append("<option value='8'>女生专区</option>");
            jQuery("#areaId").append("<option value='21'>通栏广告(W)</option>");
        } else if (module == 3) {
            jQuery("#areaId").append("<option value='0'>Banner</option>");
            jQuery("#areaId").append("<option value='1'>右侧推荐栏</option>");
            jQuery("#areaId").append("<option value='2'>热门推荐</option>");
            jQuery("#areaId").append("<option value='21'>通栏广告</option>");
            jQuery("#areaId").append("<option value='22'>左侧广告</option>");
            jQuery("#areaId").append("<option value='23'>右侧广告</option>");
        }
    }
    /*else if (client = 3) {
     if (module == 0) {
     //alert("ModuleId = " + module);
     jQuery("#areaId").append("<option value='0'>Banner</option>");
     jQuery("#areaId").append("<option value='2'>热门推荐</option>");
     jQuery("#areaId").append("<option value='3'>新品推荐</option>");
     jQuery("#areaId").append("<option value='5'>移动游戏精品</option>");
     jQuery("#areaId").append("<option value='4'>移动软件精品</option>");
     jQuery("#areaId").append("<option value='6'>网页应用精品</option>");
     jQuery("#areaId").append("<option value='9'>专题推荐</option>");
     jQuery("#areaId").append("<option value='7'>男生专区</option>");
     jQuery("#areaId").append("<option value='8'>女生专区</option>");
     jQuery("#areaId").append("<option value='21'>通栏广告</option>");
     } else if (module == 1 || module == 2) {
     jQuery("#areaId").append("<option value='0'>Banner</option>");
     jQuery("#areaId").append("<option value='2'>热门推荐</option>");
     jQuery("#areaId").append("<option value='9'>专题推荐</option>");
     jQuery("#areaId").append("<option value='7'>男生专区</option>");
     jQuery("#areaId").append("<option value='8'>女生专区</option>");
     jQuery("#areaId").append("<option value='21'>通栏广告</option>");
     } else if (module == 3) {
     jQuery("#areaId").append("<option value='0'>Banner</option>");
     jQuery("#areaId").append("<option value='1'>右侧推荐栏</option>");
     jQuery("#areaId").append("<option value='2'>热门推荐</option>");
     jQuery("#areaId").append("<option value='21'>通栏广告</option>");
     }
     }*/
    jQuery('#areaId').get(0).value = area;
}


/*获得排行榜列表*/
function getRankingList(ranking_style, ranking_type) {
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/rankingManager/getRankingList.action',
        data: 'rankingStyle=' + ranking_style + '&rankingType=' + ranking_type,
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
//                    jQuery('#rankingStyle').val(ranking_style);
//                    jQuery('#rankingType').val(ranking_type);

        }
    });
}


function searchAppByName() {
    jQuery('#appInTopic').empty();
    var appName = jQuery.trim(document.getElementById('appName').value);
    var html = '';
    var result = '';
    jQuery.ajax({
        type: 'POST',
        url: '/search/SearchApp.action',
        data: 'appName=' + appName,
        dataType: 'html',
        success: function (data) {
            jQuery('#appInTopic').empty().html(data);
        }
    });
}


function searchAppByNameForTopic() {
    jQuery('#appInTopic').empty();
    var appName = jQuery.trim(document.getElementById('appName').value);
    var html = '';
    var result = '';
    jQuery.ajax({
        type: 'POST',
        url: '/search/SearchAppForTopic.action',
        data: 'appName=' + appName,
        dataType: 'html',
        success: function (data) {
            jQuery('#appInTopic').empty().html(data);
        }
    });
}


//cp上传图片的路径
function changeUrlCP(url) {
    return '$coverserver.getTarget("")' + url;
}


function compulsoryInstallation() {
    jQuery.ajax({
        type: 'POST',
        url: '/compulsory/compulsoryInstallation.action',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
        }
    });
}


function marketApps() {
    jQuery.ajax({
        type: 'POST',
        url: '/activityManager/marketApps.action',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
        }
    });
}


function addInstallApp(id) {
    jQuery("#confirmPop").css("width", "430px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/compulsory/addInstallApp.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function saveIntallApp() {
    var installApps = document.getElementsByName("installApp");
    var appId = '';
    for (var i = 0; i < installApps.length; i++) {
        if (installApps[i].checked) {
            appId = installApps[i].value.toString();
            break;
        }
    }
    if (appId != '') {
        jQuery.ajax({
            type: 'POST',
            url: '/compulsory/saveIntallApp.action',
            data: {"appid": appId},
            dataType: 'json',
            success: function (data) {
                if (data.code == 1) {
                    $('#close').click();
                    compulsoryInstallation();
                } else {
                    alert(data.mess);
                }
            }
        });
    } else {
        alert("请选择应用");
    }
}


function deleteCompulsoryApp(id) {
    if (confirm("确定要移除该应用？")) {
        jQuery.ajax({
            type: 'POST',
            url: '/compulsory/deleteCompulsoryApp.action',
            data: {"id": id},
            dataType: 'json',
            success: function (data) {
                if (data.code == 1) {
                    compulsoryInstallation();
                } else {
                    alert(data.mess);
                }
            }
        });
    }
}


function suNingApps() {
    jQuery.ajax({
        type: 'POST',
        url: '/suning/suNingApps.action',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
        }
    });
}


function createSuning() {
    jQuery("#confirmPop").css("width", "480px");
    jQuery("#confirmPop").css("height", "350px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/suning/addSuning.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}



function saveSuning() {
    var shopId = $("#shopId").val();
    var shopName = $("#shopName").val();
    var fileUrl = $("#FileUrl").val();
    jQuery.ajax({
        type: 'POST',
        url: '/suning/saveSuning.action',
        data: {"suning.shopId": shopId,
            "suning.shopName": shopName,
            "suning.fileUrl": fileUrl
        },
        dataType: 'json',
        success: function (data) {
            if (data.code == 1) {
                $('#close').click();
                suNingApps();
            } else {
                alert(data.mess);
            }
        }
    });
}

function modifySuning(id) {
    jQuery("#confirmPop").css("width", "480px");
    jQuery("#confirmPop").css("height", "350px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/suning/modifySuning.action',
        data: {"id":id},
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}


function updateSuning(id){
    var shopId = $("#shopId").val();
    var shopName = $("#shopName").val();
    var fileUrl = $("#FileUrl").val();
    jQuery.ajax({
        type: 'POST',
        url: '/suning/updateSuning.action',
        data: {"suning.shopId": shopId,
            "suning.shopName": shopName,
            "suning.fileUrl": fileUrl,
            "suning.id":id
        },
        dataType: 'json',
        success: function (data) {
            if (data.code == 1) {
                $('#close').click();
                suNingApps();
            } else {
                alert(data.mess);
            }
        }
    });
}

function deleteSuning(id) {
    if (confirm("确定要移除该安装包？")) {
        jQuery.ajax({
            type: 'POST',
            url: '/suning/deleteSuning.action',
            data: {"id": id},
            dataType: 'json',
            success: function (data) {
                if (data.code == 1) {
                    suNingApps();
                } else {
                    alert(data.mess);
                }
            }
        });
    }
}


function cpDateImport() {
    jQuery.ajax({
        type: 'POST',
        url: '/cpdateimport/cpDateImport.action',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
        }
    });
}

function addCpDateImport() {
    jQuery("#confirmPop").css("width", "580px");
    jQuery("#confirmPop").css("height", "450px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/cpdateimport/addCpDateImport.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function saveCpDateImport() {
    var installApps = document.getElementsByName("installApp");
    var appId = '';
    for (var i = 0; i < installApps.length; i++) {
        if (installApps[i].checked) {
            appId = installApps[i].value.toString();
            break;
        }
    }

    var fileUrl = $("#FileUrl").val();
    jQuery.ajax({
        type: 'POST',
        url: '/cpdateimport/saveCpDateImport.action',
        data: {
            "cpDateImport.appid": appId,
            "cpDateImport.fileUrl": fileUrl
        },
        dataType: 'json',
        success: function (data) {
            if (data.code == 1) {
                $('#close').click();
                cpDateImport();
            } else {
                alert(data.mess);
            }
        }
    });
}

function deleteCpDateImport(id) {
    if (confirm("确定要移除该激活数据？")) {
        jQuery.ajax({
            type: 'POST',
            url: '/cpdateimport/deleteCpDateImport.action',
            data: {"id": id},
            dataType: 'json',
            success: function (data) {
                if (data.code == 1) {
                    cpDateImport();
                } else {
                    alert(data.mess);
                }
            }
        });
    }
}


