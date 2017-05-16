function selectModuleId(client) {
    var ModuleId = document.getElementById('moduleId').value;
    jQuery("#areaId").empty();
    if (client == 2) {
        if (ModuleId == 0) {
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
        } else if (ModuleId == 1) {
            jQuery("#areaId").append("<option value='0'>Banner</option>");
            jQuery("#areaId").append("<option value='1'>右侧推荐栏(W)</option>");
            jQuery("#areaId").append("<option value='2'>热门推荐</option>");
            jQuery("#areaId").append("<option value='3'>新品推荐</option>");
            jQuery("#areaId").append("<option value='4'>精品软件(P)</option>");
            jQuery("#areaId").append("<option value='9'>专题推荐</option>");
            jQuery("#areaId").append("<option value='7'>男生专区</option>");
            jQuery("#areaId").append("<option value='8'>女生专区</option>");
            jQuery("#areaId").append("<option value='21'>通栏广告(W)</option>");
        } else if (ModuleId == 2) {
            jQuery("#areaId").append("<option value='0'>Banner</option>");
            jQuery("#areaId").append("<option value='1'>右侧推荐栏(W)</option>");
            jQuery("#areaId").append("<option value='2'>热门推荐</option>");
            jQuery("#areaId").append("<option value='3'>新品推荐</option>");
            jQuery("#areaId").append("<option value='5'>精品游戏(P)</option>");
            jQuery("#areaId").append("<option value='9'>专题推荐</option>");
            jQuery("#areaId").append("<option value='7'>男生专区</option>");
            jQuery("#areaId").append("<option value='8'>女生专区</option>");
            jQuery("#areaId").append("<option value='21'>通栏广告(W)</option>");
        } else if (ModuleId == 3) {
            jQuery("#areaId").append("<option value='0'>Banner</option>");
            jQuery("#areaId").append("<option value='1'>右侧推荐栏</option>");
            jQuery("#areaId").append("<option value='2'>热门推荐</option>");
            jQuery("#areaId").append("<option value='21'>通栏广告</option>");
            jQuery("#areaId").append("<option value='22'>左侧广告</option>");
            jQuery("#areaId").append("<option value='23'>右侧广告</option>");
        }
    }
}


function loadHomeArea(homeAreaType, homeAreaPos) {
    var html = '';
    if (homeAreaType == 1) {
        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" id="homeAreaType" value="1"/></td>';
        html += '<td width="345"><p><table align="center" border="0" cellspacing="3" cellpadding="0">';
        html += '<tr><td  style="border: 0;"><img class="voth_img" src="/appstore-man/images/vot/vot_1.png"/></td></tr>';
        html += '</table></p></td>';
    } else if (homeAreaType == 2) {
        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" value="2" id="homeAreaType"/> </td>';
        html += '<td width="345"><p><table align="center" border="0" cellspacing="3" cellpadding="0">';
        html += '<tr><td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_2.png"/></td>';
        html += '<td rowspan="2" style="border: 0;"><img class="voth_img" src="/appstore-man/images/vot/vot_4.png"/></td></tr>';
        html += '<tr><td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_3.png"/></td></tr>';
        html += '</table></p></td>';
    } else if (homeAreaType == 3) {
        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" value="3" id="homeAreaType"/></td>';
        html += '<td width="345"><p><table align="center" border="0" cellspacing="3" cellpadding="0">';
        html += '<tr><td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_5.png"/></td>';
        html += '<td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_6.png"/></td>';
        html += '<td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_7.png"/></td>';
        html += '</tr></table></p></td>';
    }

    jQuery('#homeAreaTypeMode').empty().html(html);
}

function loadPadHomeArea(homeAreaType, homeAreaPos) {
    var html = '';
    if (homeAreaType == 1) {
        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" id="homeAreaType" value="1"/></td>';
        html += '<td width="345"><table align="center" border="0" cellspacing="3" cellpadding="0">';
        html += '<tr><td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_8.png"/></td>';
        html += '<td clospan="2" style="border: 0;"><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_9.png"/></td>';
        html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_10.png"/></td>';
        html += '</tr></table></td>';
    } else if (homeAreaType == 2) {
        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" value="2" id="homeAreaType"/> </td>';
        html += '<td width="345"><table align="center" cellspacing="3" cellpadding="0">';
        html += '<tr><td colspan="2" style="border: 0;"><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_11.png"/></td>';
        html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_12.png"/></td>';
        html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_13.png"/></td></tr>';
        html += '</table></td>';
    } else if (homeAreaType == 3) {
        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" value="3" id="homeAreaType"/></td>';
        html += '<td width="345"><table align="center" border="0" cellspacing="3" cellpadding="0">';
        html += '<tr><td style="border: 0;"><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_12.png"/></td>';
        html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_13.png"/></td>';
        html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_12.png"/></td>';
        html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_13.png"/></td>'
        html += '</tr></table></td>';
    }
    jQuery('#homeAreaTypeMode').empty().html(html);
}


function selectHomeAreaTypeById(id, homeAreaType, homeAreaPos) {
    jQuery("#confirmPop").css("width", "600px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    var html = '';
    var tip_html = '';
    if (homeAreaType == 1) {
        html = '<td width="110" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" id="homeAreaType" value="1"/></td>';
        html += '<td width="550"><p><table align="center" border="0" cellspacing="3" cellpadding="0">';
        html += '<tr><td><img class="voth_img" src="/appstore-man/images/vot/vot_1.png"/></td></tr>';
        html += '</table></p></td>';

        tip_html = '<label style="display:block">图片尺寸：460*220</label>';
        tip_html += '<label><img id="tempImg"  width="460" height="220"  src="/appstore-man/images/vot/vot_1.png"</label>';
    } else if (homeAreaType == 2) {
        html = '<td width="110" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" value="2" id="homeAreaType"/></td>';
        html += '<td width="550"><p><table align="center" border="0" cellspacing="3" cellpadding="0"><tr>';
        if (homeAreaPos == 1) {
            html += '<td><img class="vot_img" src="/appstore-man/images/vot/vot_2.png"/></td>';
            tip_html = '<label style="display:block">图片尺寸：226*108</label>';
            tip_html += '<label><img id="tempImg" width="226" height="108" src="/appstore-man/images/vot/vot_2.png"</label>';
        } else {
            html += '<td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_2.png"/></td>';
            /*tip_html = '<label style="display:block">图片尺寸：226*108</label>';
             tip_html += '<label><img id="tempImg" src="/appstore-man/images/vot/vot_2.png"</label>';*/
        }
        if (homeAreaPos == 3) {
            html += '<td rowspan="2"><img class="voth_img" src="/appstore-man/images/vot/vot_4.png"/></td></tr>';
            tip_html = '<label style="display:block">图片尺寸：226*226</label>';
            tip_html += '<label><img id="tempImg" width="226" height="226" src="/appstore-man/images/vot/vot_4.png"</label>';
        } else {
            html += '<td rowspan="2" style="border: 0;"><img class="voth_img" src="/appstore-man/images/vot/vot_4.png"/></td></tr>';
            /* tip_html = '<label style="display:block">图片尺寸：226*226</label>';
             tip_html += '<label><img id="tempImg" src="/appstore-man/images/vot/vot_4.png"</label>';*/
        }
        if (homeAreaPos == 2) {
            html += '<tr><td><img class="vot_img" src="/appstore-man/images/vot/vot_3.png"/></td>';
            tip_html = '<label style="display:block">图片尺寸：226*108</label>';
            tip_html += '<label><img id="tempImg" width="226" height="108"  src="/appstore-man/images/vot/vot_3.png"</label>';
        } else {
            html += '<tr><td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_3.png"/></td>';
            /*tip_html = '<label style="display:block">图片尺寸：226*108</label>';
             tip_html += '<label><img id="tempImg" src="/appstore-man/images/vot/vot_3.png"</label>';*/
        }

        html += '</tr></table></p></td>';
    } else if (homeAreaType == 3) {
        tip_html = '<label style="display:block">图片尺寸：148*148</label>';
        tip_html += '<label><img id="tempImg" width="148" height="148" src="/appstore-man/images/vot/vot_5.png"</label>';

        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" value="3" id="homeAreaType"/></td>';
        html += '<td width="345"><p><table align="center" border="0" cellspacing="3" cellpadding="0"><tr>';
        if (homeAreaPos == 1) {
            html += '<td><img class="vot_img" src="/appstore-man/images/vot/vot_5.png"/></td>';
        } else {
            html += '<td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_5.png"/></td>';
        }
        if (homeAreaPos == 2) {
            html += '<td><img class="vot_img" src="/appstore-man/images/vot/vot_6.png"/></td>';
        } else {
            html += '<td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_6.png"/></td>';
        }
        if (homeAreaPos == 3) {
            html += '<td><img class="vot_img" src="/appstore-man/images/vot/vot_7.png"/></td>';
        } else {
            html += '<td style="border: 0;"><img class="vot_img" src="/appstore-man/images/vot/vot_7.png"/></td>';
        }
        html += '</tr></table></p></td>';
    }
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/load.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
            jQuery('#recommendId').val(id);
            jQuery('#homeAreaPos').val(homeAreaPos);
            jQuery('#homeAreaTypeMode').empty().html(html);
            jQuery('#tip').empty().html(tip_html);
        }
    });
}


function selectPadHomeAreaTypeById(id, homeAreaType, homeAreaPos) {
    jQuery("#confirmPop").css("width", "600px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    var tip_html = '';
    var html = '';
    //alert("aaaaaaaa")
    if (homeAreaType == 1) {
        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" id="homeAreaType" value="1"/></td>';
        html += '<td width="345"><p><table align="center" border="0" cellspacing="3" cellpadding="0"><tr>';
        if (homeAreaPos == 1) {
            html += '<td><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_8.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
            tip_html += '<label><img id="tempImg" width="255" height="255" src="/appstore-man/images/vot/vot_8.png"/></label>';
        } else {
            html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_8.png"/></td>';
        }
        if (homeAreaPos == 2) {
            html += '<td clospan="2"><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_9.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：544*255</label>';
            tip_html += '<label><img id="tempImg" width="544" height="255" src="/appstore-man/images/vot/vot_9.png"/></label>';
        } else {
            html += '<td clospan="2" style="border: 0;"><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_9.png"/></td>';
        }
        if (homeAreaPos == 3) {
            html += '<td><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_10.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
            tip_html += '<label><img id="tempImg" width="255" height="255" src="/appstore-man/images/vot/vot_10.png"/></label>';
        } else {
            html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_10.png"/></td>';
        }
        html += '</tr></table></p></td>';
    } else if (homeAreaType == 2) {
        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" value="2" id="homeAreaType"/> </td>';
        html += '<td width="345"><p><table align="center" border="0" cellspacing="3" cellpadding="0"><tr>';
        if (homeAreaPos == 1) {
            html += '<td colspan="2"><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_11.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：544*255</label>';
            tip_html += '<label><img id="tempImg" width="544" height="255" src="/appstore-man/images/vot/vot_11.png"/></label>';
        } else {
            html += '<td colspan="2" style="border: 0;"><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_11.png"/></td>';
        }
        if (homeAreaPos == 2) {
            html += '<td><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_12.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
            tip_html += '<label><img id="tempImg" width="255" height="255" src="/appstore-man/images/vot/vot_12.png"/></label>';
        } else {
            html += '<td style="border: 0"><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_12.png"/></td>';
            /*tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
             tip_html = '<label><img id="tempImg" src="/appstore-man/images/vot/vot_12.png"/></label>';*/
        }
        if (homeAreaPos == 3) {
            html += '<td><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_13.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
            tip_html += '<label><img id="tempImg" width="255" height="255" src="/appstore-man/images/vot/vot_13.png"/></label>';
        } else {
            html += '<td style="border: 0;"><img style="max-height: 80px;" src="/appstore-man/images/vot/vot_13.png"/></td>';
            /*tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
             tip_html = '<label><img id="tempImg" src="/appstore-man/images/vot/vot_13.png"/></label>';*/
        }
        html += '</tr></table></p></td>';
    } else if (homeAreaType == 3) {
        html = '<td width="95" valign="top"><label>版&#12288;&#12288;位：</label><input type="text" class="hide" value="3" id="homeAreaType"/></td>';
        html += '<td width="345"><p><table align="center" border="0" cellspacing="3" cellpadding="0"><tr>';
        if (homeAreaPos == 1) {
            html += '<td><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_14.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
            tip_html += '<label><img id="tempImg" width="255" height="255" src="/appstore-man/images/vot/vot_14.png"/></label>';
        } else {
            html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_14.png"/></td>';
            /*tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
             tip_html = '<label><img id="tempImg" src="/appstore-man/images/vot/vot_17.png"/></label>';*/
        }
        if (homeAreaPos == 2) {
            html += '<td><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_15.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
            tip_html += '<label><img id="tempImg" width="255" height="255" src="/appstore-man/images/vot/vot_15.png"/></label>';
        } else {
            html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_15.png"/></td>';
            /*tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
             tip_html = '<label><img id="tempImg" src="/appstore-man/images/vot/vot_15.png"/></label>';*/
        }
        if (homeAreaPos == 3) {
            html += '<td><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_16.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
            tip_html += '<label><img id="tempImg" src="/appstore-man/images/vot/vot_16.png"/></label>';
        } else {
            html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_16.png"/></td>';
            /*tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
             tip_html = '<label><img id="tempImg" src="/appstore-man/images/vot/vot_16.png"/></label>';*/
        }
        if (homeAreaPos == 4) {
            html += '<td><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_17.png"/></td>';
            tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
            tip_html += '<label><img id="tempImg"  width="255" height="" src="/appstore-man/images/vot/vot_17.png"/></label>';
        } else {
            html += '<td style="border: 0;"><img style="max-width: 80px;" src="/appstore-man/images/vot/vot_17.png"/></td>';
            /*tip_html = '<label style="display:block">建议图片尺寸：255*255</label>';
             tip_html = '<label><img id="tempImg" src="/appstore-man/images/vot/vot_17.png"/></label>';*/
        }

        html += '</tr></table></p></td>';
    }
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/loadPad.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
            jQuery('#recommendId').val(id);
            jQuery('#homeAreaPos').val(homeAreaPos);
            jQuery('#homeAreaTypeMode').empty().html(html);
            jQuery('#tip').empty().html(tip_html);
        }
    });
}


function WebRecommendSearch() {
    var moduleId = document.getElementById('moduleId').value;
    var areaId = document.getElementById('areaId').value;
    var clientType = document.getElementById('clientType').value;
    //alert("moduleId = " + moduleId + " areaId = " + areaId + " clientType = " + clientType);
    if (clientType == 2) {
        getPCRecommendAll(clientType, moduleId, areaId);
    } else if (clientType == 3) {
        getWebRecommendAll(clientType, moduleId, areaId);
    } else if (clientType == 4) {
        getCPServer();
    }
}


function addPCRecommend() {
    jQuery("#confirmPop").css("width", "600px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/addPCRecommend.action',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}


function addWebRecommend() {
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/addWebRecommend.action',
        dataType: 'html',
        success: function (data) {
            jQuery('#confirmPop').html(data);
            loadLink();
        }
    });
}

/*更新推荐中的排行顺序*/
function updateRecommendSeq(id, orderSeq, val) {
    var clientType = document.getElementById('clientType').value;
    var moduleId = document.getElementById('moduleId').value;
    var areaId = document.getElementById('areaId').value;
    if (orderSeq != val) {
        var r = confirm("是否修改排序？");
        if (r == true) {
            jQuery.ajax({
                type: 'POST',
                url: '/recommendManager/updateRecommendSeq.action',
                data: 'recommendManagerResult.id=' + id + '&recommendManagerResult.seq=' + val + '&recommendManagerResult.clientType=' + clientType + '&recommendManagerResult.moduleId=' + moduleId + '&recommendManagerResult.areaId=' + areaId,
                dataType: 'html',
                success: function (data) {
                    WebRecommendSearch();
                }
            });
        }
    }
}


/*更新客户端推荐中的排行顺序*/
function updatePhoneRecommendSeq(homeAreaId, val, id) {
    if (homeAreaId != val) {
        var r = confirm("是否修改排序？");
        if (r == true) {
            jQuery.ajax({
                type: 'POST',
                url: '/recommendManager/updatePhoneRecommendSeq.action',
                data: 'recommendManagerResult.id=' + id + '&recommendManagerResult.homeAreaId=' + val + '&recommendManagerResult.seq=' + homeAreaId + '&recommendManagerResult.clientType=0&recommendManagerResult.moduleId=0&recommendManagerResult.areaId=10',
                dataType: 'html',
                success: function (data) {
                    getPhoneRecommend();
                }
            });
        }
    }
}


function updatePadRecommendSeq(homeAreaId, val, id) {
    if (homeAreaId != val) {
        var r = confirm("是否修改排序？");
        if (r == true) {
            jQuery.ajax({
                type: 'POST',
                url: '/recommendManager/updatePhoneRecommendSeq.action',
                data: 'recommendManagerResult.id=' + id + '&recommendManagerResult.homeAreaId=' + val + '&recommendManagerResult.seq=' + homeAreaId + '&recommendManagerResult.clientType=1&recommendManagerResult.moduleId=0&recommendManagerResult.areaId=11',
                dataType: 'html',
                success: function (data) {
                    getPadRecommend();
                }
            });
        }
    }
}


/*更新推荐发布状态*/
function updateRecommendPubedStatus(id, pubedStatus) {
    var clientType = document.getElementById('clientType').value;
    var moduleId = document.getElementById('moduleId').value;
    var areaId = document.getElementById('areaId').value;
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/updateRecommendPub.action',
        data: 'recommendManagerResult.id=' + id + '&recommendManagerResult.pubedStatus=' + pubedStatus + '&recommendManagerResult.clientType=' + clientType + '&recommendManagerResult.moduleId=' + moduleId + '&recommendManagerResult.areaId=' + areaId,
        dataType: 'html',
        success: function (data) {
            WebRecommendSearch();
        }
    });
}

function deletePhoneRecommend(id) {
    var r = confirm("确定删除？");
    if (r == true) {
        jQuery.ajax({
            type: 'POST',
            url: '/recommendManager/deletePhoneRecommend.action',
            data: 'recommendManagerResult.homeAreaId=' + id + '&recommendManagerResult.clientType=0&recommendManagerResult.moduleId=0&recommendManagerResult.areaId=10',
            dataType: 'html',
            success: function (data) {
                getPhoneRecommend();
            }
        });
    }
}


function deletePadRecommend(id) {
    var r = confirm("是否删除？");
    if (r == true) {
        jQuery.ajax({
            type: 'POST',
            url: '/recommendManager/deletePhoneRecommend.action',
            data: 'recommendManagerResult.homeAreaId=' + id + '&recommendManagerResult.clientType=1&recommendManagerResult.moduleId=0&recommendManagerResult.areaId=11',
            dataType: 'html',
            success: function (data) {
                getPadRecommend();
            }
        });
    }
}


function editRecommend(id) {
    var clientType = document.getElementById('clientType').value;
    var moduleId = document.getElementById('moduleId').value;
    var areaId = document.getElementById('areaId').value;
    jquery.ajax({
        type: 'POST',
        url: '/recommendManager/editRecommend.action',
        data: 'recommendManagerResult.id=' + id,
        dataType: 'html',
        success: function (data) {
            jQuery('#confirmPop').html(data);
        }
    });
}


function deleteRecommend(id) {
    var r = confirm("是否删除?");
    if (r == true) {
        var clientType = document.getElementById('clientType').value;
        var moduleId = document.getElementById('moduleId').value;
        var areaId = document.getElementById('areaId').value;
        jQuery.ajax({
            type: 'POST',
            url: '/recommendManager/deleteRecommend.action',
            data: 'recommendManagerResult.id=' + id + '&recommendManagerResult.clientType=' + clientType + '&recommendManagerResult.moduleId=' + moduleId + '&recommendManagerResult.areaId=' + areaId,
            dataType: 'html',
            success: function (data) {
                WebRecommendSearch();
            }
        });
    }
}


/*更新排行榜排序*/
function updateRankingSeq(rankingStyle, rankingType, id, orderSeq, val) {
    if (orderSeq != val) {
        var r = confirm("是否修改排序?");
        if (r == true) {
            jQuery.ajax({
                type: 'POST',
                url: '/rankingManager/updateRankingSeq.action',
                data: 'rankingManagerResult.id=' + id + '&rankingManagerResult.rankingStyle=' + rankingStyle + '&rankingManagerResult.rankingType=' + rankingType + '&rankingManagerResult.orderSeq=' + val,
                dataType: 'html',
                success: function (data) {
                    getRankingList(rankingStyle, rankingType);
                }
            });
        }
    }
}


/*编辑排行榜*/
function editRanking(id) {
    jQuery("#confirmPop").css("width", "800px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/rankingManager/editRanking.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
            jQuery('#rankingId').val(id);
        }
    });
}


/*添加专题*/
function addTopic() {
    jQuery('#confirmPop').html("");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery("#confirmPop").css("width", "800px");
    jQuery("#confirmPop").css("height", "500px");
    jQuery.ajax({
        type: 'POST',
        url: '/topicManager/addTopic.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function relenvanceTopic(topicId, topicSeq) {
    jQuery('#confirmPop').html("");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery("#confirmPop").css("width", "480px");
    jQuery("#confirmPop").css("height", "400px");
    jQuery.ajax({
        type: "POST",
        url: "/topicManager/padRelevanceTopic.action",
        data: {"topic.topicId": topicId, "topic.orderSeq": topicSeq},
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}


/*更新专题发布状态*/
function updateTopicPubedStatus(topicId, pubedStatus) {
    var pub = document.getElementById('pubedStatus').value;
    jQuery.ajax({
        type: 'POST',
        url: '/topicManager/updateTopicPubedStatus.action',
        data: 'topic.topicId=' + topicId + "&topic.pubedStatus=" + pubedStatus,
        dataType: 'html',
        success: function (data) {
            getTopicListByPub();
        }
    });

}


/*删除专题*/
function deleteTopic(id, orderSeq) {
    var r = confirm("是否删除?");
    if (r == true) {
        jQuery.ajax({
            type: 'POST',
            url: '/topicManager/deleteTopic.action',
            data: 'topic.topicId=' + id + '&topic.orderSeq=' + orderSeq,
            dataType: 'html',
            success: function (data) {
                deleteTopicApp(id);
                getTopicListByPub();
            }
        });
    }
}


/*编辑专题*/
function editTopic(id) {
    jQuery('#confirmPop').html("");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery("#confirmPop").css("width", "800px");
    jQuery("#confirmPop").css("height", "500px");
    jQuery.ajax({
        type: 'POST',
        url: '/topicManager/editTopic.action',
        data: 'topic.topicId=' + id + '&topic.topicType=1',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}


/*删除专题内容表中的信息*/
function deleteTopicApp(id) {
    jQuery.ajax({
        type: 'POST',
        url: '/topicManager/deleteTopicApp.action',
        data: 'topicApp.topicId=' + id
    });
}


/*更新专题排序*/
function updateTopicSeq(id, orderSeq, val) {
    if (orderSeq != val) {
        var r = confirm("是否修改排序？");
        if (r == true) {
            jQuery.ajax({
                type: 'POST',
                url: '/topicManager/updateTopicSeq.action',
                data: 'topic.topicId=' + id + '&topic.orderSeq=' + val,
                dataType: 'html',
                success: function (data) {
                    getTopicListByPub();
                }
            });
        }
    }

}


/*获得专题列表*/
//function getTopicList(topic_type) {
//    jQuery.ajax({
//                type:'POST',
//                url:'/topicManager/getTopicList.action',
//                data:'topicType=' + topic_type,
//                dataType:'html',
//                success:function(data) {
//                    jQuery('#right_start').html(data);
//                }
//            });
//}
//;

function getTopicList() {
    jQuery.ajax({
        type: 'POST',
        url: '/topicManager/getTopicListByPub.action',
        data: 'pubedStatus=2',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            //jQuery('#pubedStatus').get(0).value = 2;
        }
    });
}

/*通过发布状态检索专题列表*/
function getTopicListByPub() {
    var pubedStatus = document.getElementById('pubedStatus').value;
    jQuery.ajax({
        type: 'POST',
        url: '/topicManager/getTopicListByPub.action',
        data: 'pubedStatus=' + pubedStatus,
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            jQuery('#pubedStatus').get(0).value = pubedStatus;
        }
    });
}


/*更新资讯发布状态*/
function updateNoticePubedStatus(id, pubedStatus) {
    var pub = document.getElementById('pubedStatus').value;
    jQuery.ajax({
        type: 'POST',
        url: '/noticeManager/updateNoticePubedStatus.action',
        data: 'websiteNotice.id=' + id + '&websiteNotice.pubedStatus=' + pubedStatus,
        dataType: 'html',
        success: function (data) {
            getNoticeListByPub();
        }
    });
}


function updateHotWordPublished(id, published) {
    var pub = document.getElementById('published').value;
    jQuery.ajax({
        type: 'POST',
        url: '/hotWordManager/updateHotWordPublished.action',
        data: 'hotWord.id=' + id + '&hotWord.published=' + published,
        dataType: 'html',
        success: function (data) {
            getHotWordsByPub();
        }
    });
}
;

function getWebsitNotice() {
    jQuery.ajax({
        type: 'POST',
        url: '/noticeManager/getNoticeListByPub.action',
        data: 'pubedStatus=2',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            //jQuery('#pubedStatus').get(0).value = 2;
        }
    });
}


function getHotWords() {
    jQuery.ajax({
        type: 'POST',
        url: '/hotWordManager/getHotWords.action',
        data: 'published=2',
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            jQuery('#published').get(0).value = 2;
        }
    });
}


/*通过发布状态检索资讯列表*/
function getNoticeListByPub() {
    var pubedStatus = document.getElementById('pubedStatus').value;
    jQuery.ajax({
        type: 'POST',
        url: '/noticeManager/getNoticeListByPub.action',
        data: 'pubedStatus=' + pubedStatus,
        dataType: 'html',
        success: function (data) {
            jQuery('#right_start').html(data);
            jQuery('#pubedStatus').get(0).value = pubedStatus;
        }
    });
}


/*删除资讯*/
function deleteNotice(id, orderSeq) {
    var r = confirm("确定删除？");
    if (r == true) {
        jQuery.ajax({
            type: 'POST',
            url: '/noticeManager/deleteNotice.action',
            data: 'websiteNotice.id=' + id + '&websiteNotice.orderSeq=' + orderSeq,
            dataType: 'html',
            success: function (data) {
                jQuery('#right_start').html(data);
                getNoticeListByPub();
            }
        });
    }
}


function deleteHotWord(id, orderSeq) {
    var r = confirm("确定删除？");
    if (r == true) {
        jQuery.ajax({
            type: 'POST',
            url: '/hotWordManager/deleteHotWord.action',
            data: 'hotWord.id=' + id + '&hotWord.orderSeq=' + orderSeq,
            dataType: 'html',
            success: function (data) {
                getHotWordsByPub();
            }
        });
    }
}

/*更新资讯排序*/
function updateNoticeSeq(id, orderSeq, val) {
    if (orderSeq != val) {
        var r = confirm("是否修改排序？");
        if (r == true) {
            jQuery.ajax({
                type: 'POST',
                url: '/noticeManager/updateNoticeSeq.action',
                data: 'websiteNotice.id=' + id + '&websiteNotice.orderSeq=' + val,
                dataType: 'html',
                success: function (data) {
                    getNoticeListByPub();
                }
            });
        }
    }

}

function updateHotWordSeq(id, orderSeq, val) {
    if (orderSeq != val) {
        var r = confirm("是否修改排序？");
        if (r == true) {
            jQuery.ajax({
                type: 'POST',
                url: '/hotWordManager/updateHotWordSeq.action',
                data: 'hotWord.id=' + id + '&hotWord.orderSeq=' + val,
                dataType: 'html',
                success: function (data) {
                    getHotWordsByPub();
                }
            });
        }
    }
}

function addHomeAreaType() {
    jQuery("#confirmPop").css("width", "450px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/addHomeAreaType.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function addPadHomeAreaType() {
    jQuery("#confirmPop").css("width", "532px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/recommendManager/addPadHomeAreaType.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}


/*更新排行榜锁定状态*/
function updateRankingLocked(locked, id, rankingStyle, rankingType) {
    jQuery.ajax({
        type: 'POST',
        url: '/rankingManager/updateRankingLocked.action',
        data: 'rankingManagerResult.locked=' + locked + '&rankingManagerResult.id=' + id,
        dataType: 'html',
        success: function (data) {
            getRankingList(rankingStyle, rankingType);
        }
    });
}


function getHotWordsByPub() {
    var published = document.getElementById('published').value;
    jQuery.ajax({
        type: 'POST',
        data: 'published=' + published,
        url: '/hotWordManager/getHotWords.action',
        success: function (data) {
            jQuery('#right_start').html(data);
            jQuery('#published').get(0).value = published;
        }
    });
}

//活动管理
function getActivityList() {
    jQuery.ajax({
        type: 'POST',
        url: '/activityManager/activityList.action',
        success: function (data) {
            jQuery('#right_start').html(data);
        }
    });
}
function addActivity() {
    jQuery("#confirmPop").css("width", "500px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/activityManager/createActivity.action',
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

// 保存活动入库
function saveActivity() {
    var activityName = $("#activityName").val();
    var seq = $("#orderSeq").val();
    var pubedStatus = $('#pubedStatus').val();
    var smallPic = $("#SmallPic").val();
    var largePic = $("#LargePic").val();
    var fileUrl = $("#FileUrl").val();
    if (activityName == '') {
        alert('请填写活动名称!');
    } else if (seq == '') {
        alert('排序不能空！');
    } else if (smallPic == '') {
        alert('请上传活动小图！');
    } else if (largePic == '') {
        alert('请上传活动大图');
    } else {
        jQuery.ajax({
            type: 'POST',
            url: '/activityManager/saveActivity.action',
            data: {"activity.activityName": activityName,
                "activity.seq": seq,
                "activity.pubedStatus": pubedStatus,
                "activity.smallPic": smallPic,
                "activity.largePic": largePic,
                "activity.fileUrl": fileUrl
            },
            dataType: 'json',
            success: function (data) {
                document.getElementById("Loading").style.display = "none";
                document.getElementById("Loading2").style.display = "none";
                if (data.status == 1) {
                    getActivityList();
                }
                $('#close').click();
            }
        });
    }
}

function deleteActivity(Id, seq) {
    if (confirm("你确定要删除该活动？")) {
        jQuery.ajax({
            type: 'POST',
            url: '/activityManager/deleteActivity.action',
            data: {
                "activity.seq": seq,
                "activity.Id": Id
            },
            dataType: 'json',
            success: function (data) {
                if (data.status == 1) {
                    getActivityList();
                }
            }
        });
    }
}

function changePubedStatus(Id, pubedStatus) {
    if (confirm("你确定要修改该活动上下线状态？")) {
        jQuery.ajax({
            type: 'POST',
            url: '/activityManager/updateActivityPubedStatus.action',
            data: {
                "activity.pubedStatus": pubedStatus,
                "activity.Id": Id
            },
            dataType: 'json',
            success: function (data) {
                if (data.status == 1) {
                    getActivityList();
                }
            }
        });
    }
}

function modifyActivity(Id) {
    jQuery("#confirmPop").css("width", "500px");
    jQuery("#confirmPop").css("height", "500px");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery.ajax({
        type: 'POST',
        url: '/activityManager/modifyActivity.action',
        data: {"activity.Id": Id},
        dataType: 'html',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function saveModifyActivity(Id) {
    var activityName = $("#activityName").val();
    var seq = $("#orderSeq").val();
    var pubedStatus = $('#pubedStatus').val();
    var smallPic = $("#SmallPic").val();
    var largePic = $("#LargePic").val();
    var fileUrl = $("#FileUrl").val();
    var seqParameter = $("#seqParameter").val();
    jQuery.ajax({
        type: 'POST',
        url: '/activityManager/saveModifyActivity.action',
        data: {"activity.activityName": activityName,
            "activity.seq": seq,
            "activity.pubedStatus": pubedStatus,
            "activity.smallPic": smallPic,
            "activity.largePic": largePic,
            "activity.fileUrl": fileUrl,
            "activity.seqParameter": seqParameter,
            "activity.Id": Id
        },
        dataType: 'json',
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            if (data.status == 1) {
                getActivityList();
            }
            $('#close').click();
        }
    });
}

function updateSeq(seq, seqParameter, Id) {
    if (confirm("你确定要修改该排序？")) {
        jQuery.ajax({
            type: 'POST',
            url: '/activityManager/saveModifyActivity.action',
            data: {
                "activity.seq": seq,
                "activity.seqParameter": seqParameter,
                "activity.Id": Id
            },
            dataType: 'json',
            success: function (data) {
                document.getElementById("Loading").style.display = "none";
                document.getElementById("Loading2").style.display = "none";
                if (data.status == 1) {
                    getActivityList();
                }
                $('#close').click();
            }
        });
    }
}

function activityRelevanceChannel(activityId) {
    jQuery('#confirmPop').html("");
    document.getElementById("Loading").style.display = "block";
    document.getElementById("Loading2").style.display = "block";
    jQuery("#confirmPop").css("width", "480px");
    jQuery("#confirmPop").css("height", "400px");
    jQuery.ajax({
        type: "POST",
        url: "/activityManager/activityRelevanceChannel.action",
        data: {"activityId": activityId},
        dataType: "html",
        success: function (data) {
            document.getElementById("Loading").style.display = "none";
            document.getElementById("Loading2").style.display = "none";
            jQuery('#confirmPop').html(data);
        }
    });
}

function saveActivityRelenvanceChannel(activityId) {
    var cids = new Array();
    var checkName = document.getElementsByName("chkUpdatePrompt");
    for (var i = 0; i < checkName.length; i++) {
        if (checkName[i].checked == true) {
            cids += checkName[i].value + ",";
        }
    }
    jQuery.ajax({
        type: "POST",
        url: "/activityManager/createActivityReleanceChannel.action",
        data: {
            "activityChannel.activityId": activityId,
            "activityChannel.cids": cids},
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                getActivityList();
            }
            $('#close').click();
        }
    });
}