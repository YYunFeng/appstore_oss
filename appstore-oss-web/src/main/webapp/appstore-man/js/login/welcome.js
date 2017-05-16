(function() {
            var object = document.getElementById("nav-home");
            if (object)object.className += " curr";
        })();
        var img = new Array();
        for (i = 1; i < 6; i++) {
            img[i] = false;
        };
        function img_chk(sb) {
            if (eval("img[" + sb + "]") == false) {
                document.getElementById(sb).src = "images/checkbox_hover.png";
                eval("img[" + sb + "]=true");
            } else {
                document.getElementById(sb).src = "images/checkbox.png";
                eval("img[" + sb + "]=false");
            }
        };
        function forWordAction(actionUrl){
            document.form1.action=actionUrl;
            document.form1.submit();
        };