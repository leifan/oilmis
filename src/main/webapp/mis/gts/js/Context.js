/**
 * Created by user on 16/3/19.
 */

/**通过此请求进行验证，如果当前用户尚未登录，则跳转到登录页面*/

function getUserInfo() {

    jQuery.ajax({
        async:false,
        url: "../user/info",
        contentType:"application/x-www-form-urlencoded",
        dataType:"json",
        success: function(response){
            location.href="index2.html";
            return;
        },
        error:function(response){
            location.href="login.html";
            return;
        }
    });

}