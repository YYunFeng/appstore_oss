jQuery(document).ready(function () {
    jQuery('#username').keydown(function (e) {
        if (e.which == 13) {
            jQuery('#input_submit').focus;
            jQuery('#input_submit').click();
            return false;
        }
    });
    jQuery('#password').keydown(function (e) {
        if (e.which == 13) {
            jQuery('#input_submit').focus;
            jQuery('#input_submit').click();
            return false;
        }
    });
});
function checkSubmit() {
    if (jQuery.trim(jQuery('input[name="supportUsers.account"]').val()) == "") {
        alert("请输入用户名");
    } else if (jQuery.trim(jQuery('[name="supportUsers.password"]').val()) == "") {
        alert("请输入密码");
    } else {
        jQuery.ajax({
            type: "post",
            url: "/login/login.action",
            data: {"supportUsers.account": jQuery('input[name="supportUsers.account"]').val(),
                "supportUsers.password": jQuery('input[name="supportUsers.password"]').val(),
                "chkRememberUsername": jQuery('#chkRememberUsername').attr('checked')},
            dataType: "json",
            success: function (data) {
                if ("error" == data) {
                    jQuery('#msg').html("登录失败!用户名或密码错误,或已停用!");
                } else if ("income" == data) {
                    document.form1.action = "/appManagement/init.action";
                    document.form1.submit();
                } else {
                    document.form1.action = "/login/init.action";
                    document.form1.submit();
                }
            }
        });
    }
}
function cleanMsg() {
    jQuery('#msg').empty();
}