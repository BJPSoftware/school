/**
 * 
 */
function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0, index + 1);
    return result;
}
jQuery(function($) {
    $("#btnLogin").bind("click", function() {
        $.ajax({
            dataType : "json",
            url : getContextPath() + "/login/login",
            type : "post",
            data : {
                userName : $('#userName').val(),
                userPwd : $('#userPwd').val()
            },
            complete : function(xmlRequest) {
                var returninfo = eval("(" + xmlRequest.responseText + ")");
                if (returninfo.result == 1) {
                    document.location.href = "index.html";
//                    window.opener = null;  
//                    window.open('','_self');  
//                    window.close();  
//                    window.open('index.html','11','location=0,resizable=no,fullscreen=true,titlebar=no,status=no,toolbar=no,menubar=no,left=0,top=0'); 
                } else if (returninfo.result == -1) {
                    $("#loginTip").html("用户名有误或已被禁用");
                } else if (returninfo.result == -2) {
                    $("#loginTip").html("密码错误");
                } else {
                    $("#loginTip").html("服务器错误");
                }
            }
        });        
    });
})