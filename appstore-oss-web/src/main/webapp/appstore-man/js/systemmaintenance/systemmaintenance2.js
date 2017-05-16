function bulkUploadStart() {
    jQuery.ajax({
                type:"post",
                url:"/bulkUpload/bulkUploadStart.action",
                dataType:"html",
                success:function(data) {
                    jQuery('#content').html(data);
                }
            });
}
;
/**
 * 卓望全量数据线程启动
 */
function zhuoWangApp() {
    if (confirm('您确定要同步所有卓望数据？')) {
        jQuery.ajax({
                    type:"post",
                    url:"/bulkUpload/zhuoWangApp.action",
                    dataType:"json",
                    success:function(data) {
                        alert(data.mess);
                    }
                });
        return true;
    } else {
        return false;
    }
}

function versionManager(clientType) {
    jQuery.ajax({
                type:"post",
                url:"/versionManager/loadVersionList.action",
                dataType:"html",
                success:function(data) {
                    jQuery('#content').html(data);
                }
            });
}

function findFeedBackListOne() {
    jQuery.ajax({
                type:"POST",
                url:'/feedBack/findfeedBackList.action',
                data:{
                    "page":1
                },
                dataType:"html",
                success:function(msg) {
                    jQuery('#content').html(msg);
                }
            });
}

function findAndroidDriver() {
    jQuery.ajax({
                type:"post",
                url:'/driverManager/findAndroidDriver.action',
                data:{
                    "page":1
                },
                dataType:'html',
                success:function(data) {
                    jQuery('#content').html(data);
                }
            });
}
;

function findFeedBackList() {
    jQuery.ajax({
                type:"POST",
                url:'/feedBack/findfeedBackList.action',
                dataType:"html",
                success:function(msg) {
                    jQuery('#content').html(msg);
                }
            });
}

function delFeedBack(id) {
    if (confirm("确定要删除此条问题反馈吗？")) {
        jQuery.ajax({
                    type:"POST",
                    url:'/feedBack/delFeedBack.action',
                    data:{
                        "id":id
                    },
                    dataType:"json",
                    success:function(msg) {
                        findFeedBackList();
                    }
                });
    }
}