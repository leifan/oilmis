/**
 * Created by user on 16/3/19.
 */



/**
 * 登录
 * @returns {Boolean}
 */
function login(){

    var userName = document.getElementById("userName").value;

    if( isBlank(userName) ){
        alert("用户名不能为空奥");
        return false;
    }

    var password = document.getElementById("password").value;
    if( isBlank(password)){
        alert("密码不能为空奥");
        return false;
    }

    var request = {
        userName:userName,
        password:password
    }

    jQuery.ajax({
        url: "/user/login",
        data: request,
        contentType:"application/x-www-form-urlencoded",
        dataType:"json",
        success: function(response){
            switch (response.retCode){
                case 200:
                	jQuery.cookie("userName", userName, { expires: 7 });
                    location.href="/mis/indexofapp.html";
                    break;
                default:
                    alert(response.retDesc);
            }
        },
        error:function(response){
            alert("获取数据失败，请稍后重试");
        }
    });

}

/**
 * 判断当前用户是否登录状态
 * @returns {Boolean}
 */
function isLogin(){

    var userName = jQuery.cookie("userName");

    if( isBlank(userName) ){
        alert("登录已过期，请重新登录");
        return false;
    }

    var request = {
        userName:userName,
    }

    jQuery.ajax({
        url: "/user/info",
        data: request,
        contentType:"application/x-www-form-urlencoded",
        dataType:"json",
        async:false,
        success: function(response){
            switch (response.retCode){
                case 200:
                	alert("登录已过期，请重新登录");
                    location.href="/mis/indexofapp.html";
                    break;
                default:
                    alert(response.retDesc);
            }
        },
        error:function(response){
            alert("获取数据失败，请稍后重试");
        }
    });

}

/**
 * 修改用户名和密码
 * @returns {Boolean}
 */
function modifyPassword(){
	
	isLogin();

//    var userName = document.getElementById("userName").value;
//
//    if( isBlank(userName) ){
//        alert("用户名不能为空奥");
//        return false;
//    }
//
//    var password = document.getElementById("password").value;
//    if( isBlank(password)){
//        alert("密码不能为空奥");
//        return false;
//    }
//
//    var request = {
//        userName:userName,
//        password:password
//    }
//
//    jQuery.ajax({
//        url: "/user/update",
//        data: request,
//        contentType:"application/x-www-form-urlencoded",
//        dataType:"json",
//        success: function(response){
//            switch (response.retCode){
//                case 200:
////                	$.cookie("userName", userName, { expires: 7 });
//                    location.href="/mis/indexofapp.html";
//                    break;
//                default:
//                    alert(response.retDesc);
//            }
//        },
//        error:function(response){
//            alert("获取数据失败，请稍后重试");
//        }
//    });

}

/**字符串判定工具*/
function isBlank(str){
    if(str == undefined || str.replace(/(^\s*)|(\s*$)/g,"").length==0){
        return true;
    }
}
