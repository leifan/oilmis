/**
 * 获取用户的个人信息
 */
document.write("<script language='javascript' src='/mis/js/util.js'></script>");

function userInfo(){
	
	var userName = $.cookie('userName');
	
	var request = {
		userName:userName
	};
	
	
	jQuery.ajax({
        url: "/user/info",
        data: request,
        contentType:"application/x-www-form-urlencoded",
        dataType:"json",
        async:false,
        success: function(response){
            switch (response.retCode){
                case 200:
                	loadData(response.userModel);
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

function loadData(data){
	
	document.getElementById("userName").value=data.userName;
	document.getElementById("password").value=data.password;
//	document.getElementById("oilStationName_selection").value=data.stationName;
    $("#districtName_selection").val(data.districtName);
    $("#departmentName_selection").val(data.departmentName);
	$("#oilStationName_selection").val(data.stationName);
    $("#groupName_selection").val(data.groupName);
    $("#role").val(data.role);
    document.getElementById("lastLoginTime").value=data.lastLoginTime;
	
}


function initData(){
	getDistrictList();
//	getOilProductList();
	getOilStationList();
	getDepartment();
	getUserGroup();
	setReadOnly();
	userInfo();
}
/**
 * 基础信息
 */
var oilProductList= new Array();
var districtList= new Array();
var oilStationList= new Array();
var departmentList = new Array();
var groupList = new Array();

function getDistrictList() {
    $.ajax({
        type: "GET",
        url: "../user/oil/getDistrictList",
        timeout: 20000,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        async:false,
        success: function (data) {
            switch (data.retCode) {
                case 200:
                    var str = '';
                    jQuery.each(data.list, function (i, item) {
                        str += "<option value='" + item.districtName + "'>" + item.districtName + "</option>";
                        districtList.push(item.districtName);
                    });

                    $("#districtName_selection").html(str);
                    break;
                default:
                    alert(data.retDesc);
                    break;
            }
        },
        error: function (data) {
            alert("页面提交出错，错误信息为：" + data);
        }

    });
}

//展示油站的条件是首先根据筛选的区域名称，再筛选对应的站点名称
//用户点击分两种(1) 显示点击区域后选择站点(2)先点击站点后点击区域，针对(2)需要提示用户首先选择区域再选择站点
function getOilStationList() {
    $.ajax({
        type: "GET",
        url: "../user/oil/getOilStationList",
        timeout: 20000,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        async:false,
        success: function (data) {
            switch (data.retCode) {
                case 200:
                    var str = '';
                    jQuery.each(data.list, function (i, item) {
                        str += "<option value='" + item.stationName + "'>" + item.stationName + "</option>";
                        oilStationList.push(item.stationName);
                    });

                    $("#oilStationName_selection").html(str);
                    break;
                default:
                    alert(data.retDesc);
                    break;
            }
        },
        error: function (data) {
            alert("页面提交出错，错误信息为：" + data);
        }
    });
}



function getOilProductList () {
    $.ajax({
        type: "GET",
        url: "../user/oil/getOilProductList",
        timeout: 20000,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        async:false,
        success: function (data) {
            switch (data.retCode) {
                case 200:
                    var str = '';
                    jQuery.each(data.list, function (i, item) {
                        str += "<option value='" + item.oilProductName + "'>" + item.oilProductName + "</option>";
                        oilProductList.push(item.oilProductName);
                    });

                    $("#oilProduct_selection").html(str);
                    break;
                default:
                    alert(data.retDesc);
                    break;
            }
        },
        error: function (data) {
            alert("页面提交出错，错误信息为：" + data);
        }

    });
}


function getDepartment(){
	
	$.ajax({
        type: "GET",
        url: "../user/oil/getDepartmentTypeList",
        timeout: 20000,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        async: false,
        success: function (data) {
            switch (data.retCode) {
                case 200:
                	var str = '';
                    jQuery.each(data.list, function (i, item) {
                        str += "<option value='" + item.departmentName + "'>" + item.departmentName + "</option>";
                        departmentList.push(item.departmentName);
                    });
                    $("#departmentName_selection").html(str);
                    break;
                default:
                    alert(data.retDesc);
                    break;
            }
        },
        error: function (data) {
            alert("页面提交出错，错误信息为：" + data);
        }

    });
	
}

function getUserGroup(){
	
	$.ajax({
        type: "GET",
        url: "../user/oil/getUserGroupList",
        timeout: 20000,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        async:false,
        success: function (data) {
            switch (data.retCode) {
                case 200:
                	var str = '';
                    jQuery.each(data.list, function (i, item) {
                        str += "<option value='" + item.groupName + "'>" + item.groupName + "</option>";
                        groupList.push(item.groupName);
                    });
                    $("#groupName_selection").html(str);
                    break;
                default:
                    alert(data.retDesc);
                    break;
            }
        },
        error: function (data) {
            alert("页面提交出错，错误信息为：" + data);
        }

    });
	
}

/**
 * 编辑用户信息
 */
function udpateUserInfo(){
	
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
    var districtName = document.getElementById("districtName_selection").value;
    var departmentName = document.getElementById("departmentName_selection").value;
	var stationName = document.getElementById("oilStationName_selection").value;
    var groupName = document.getElementById("groupName_selection").value
    var userInfo = document.getElementById("userInfo").value;
    
    if(isBlank(userName)){
    	alert("用户名不能为空");
    	return;
    }
    
    if(isBlank(password) || password.length < 6){
    	alert("密码不能为空并且密码长度不能小于6位");
    	return;
    }
    
    if(isBlank(userInfo)){
    	alert("用户信息不能为空");
    	return;
    }
    
    var request = {
    	userName:userName,
    	password:password,
    	districtName:districtName,
    	departmentName:departmentName,
    	stationName:stationName,
    	groupName:groupName,
    	userInfo:userInfo
    };
    
    $.ajax({
        type: "POST",
        url: "../user/update",
        timeout: 20000,
        data:request,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        async:false,
        success: function (data) {
            switch (data.retCode) {
                case 200:
                	jQuery("#operationResultMessage").text(data.retDesc);
                    jQuery("#updateConfirmModal").modal();
                    initData();
                    break;
                default:
                    alert(data.retDesc);
                    break;
            }
        },
        error: function (data) {
            alert("页面提交出错，错误信息为：" + data);
        }

    });
    
}


/**
 * 设置标签只读，点击编辑后才可以进行编辑修改
 */
function setReadOnly(){
	
	$("#userName").attr("readOnly","readOnly");
	$("#password").attr("readOnly","readOnly");
//	document.getElementById("oilStationName_selection").value=data.stationName;
    $("#districtName_selection").attr("disabled",true);
    $("#departmentName_selection").attr("disabled",true);
	$("#oilStationName_selection").attr("disabled",true);
    $("#groupName_selection").attr("disabled",true);
    $("#userInfo").attr("readOnly","readOnly");
    $("#lastLoginTime").attr("readOnly","readOnly");
    $("#role").attr("readOnly","readOnly");
}

/**
 * 设置标签只读，点击编辑后才可以进行编辑修改
 */
function reDefaultReadOnly(){
	
	$("#userName").attr("readOnly","readOnly");
	$("#password").attr("readOnly","readOnly");
//	document.getElementById("oilStationName_selection").value=data.stationName;
    $("#districtName_selection").attr("disabled",true);
    $("#departmentName_selection").attr("disabled",true);
	$("#oilStationName_selection").attr("disabled",true);
    $("#groupName_selection").attr("disabled",true);
    $("#userInfo").attr("readOnly","readOnly");
	
}

/**
 * 设置标签只读，点击编辑后才可以进行编辑修改
 */
function setEditable(){
	
	$("#userName").removeAttr("readOnly");
	$("#password").removeAttr("readOnly");
//	document.getElementById("oilStationName_selection").value=data.stationName;
    $("#districtName_selection").removeAttr("disabled");
    $("#departmentName_selection").removeAttr("disabled");
	$("#oilStationName_selection").removeAttr("disabled");
    $("#groupName_selection").removeAttr("disabled");
    $("#userInfo").removeAttr("readOnly");
	
}


