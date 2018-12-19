/**
 * 基础信息
 */

function getDistrictList() {
    $.ajax({
        type: "GET",
        url: "../user/oil/getDistrictList",
        timeout: 20000,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        success: function (data) {
            switch (data.retCode) {
                case 200:
                    var str = '';
                    jQuery.each(data.list, function (i, item) {
                        str += "<option value='" + item.districtName + "'>" + item.districtName + "</option>";
                        districtList.push(item.districtName);
                    });

                    $("#districtName_selection").html(str);
                    $("#filter_districtName_selection").html(str);
                    $("#update_districtName_selection").html(str);
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
        success: function (data) {
            switch (data.retCode) {
                case 200:
                    var str = '';
                    jQuery.each(data.list, function (i, item) {
                        str += "<option value='" + item.stationName + "'>" + item.stationName + "</option>";
                        oilStationList.push(item.stationName);
                    });

                    $("#oilStationName_selection").html(str);
                    $("#filter_oilStationName_selection").html(str);
                    $("#update_oilStationName_selection").html(str);
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



function getilProductList () {
    $.ajax({
        type: "GET",
        url: "../user/oil/getOilProductList",
        timeout: 20000,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        success: function (data) {
            switch (data.retCode) {
                case 200:
                    var str = '';
                    jQuery.each(data.list, function (i, item) {
                        str += "<option value='" + item.oilProductName + "'>" + item.oilProductName + "</option>";
                        oilProductList.push(item.oilProductName);
                    });

                    $("#oilProduct_selection").html(str);
                    $("#filter_oilProduct_selection").html(str);
                    $("#update_oilProduct_selection").html(str);
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

function getFeedingType(){

    var feedingType= new Array();
    feedingType.push("前尺");
    feedingType.push("后尺");
    var str='';
    jQuery.each(feedingType,function(i,item){
        str += "<option value='" + item +"'>" +item +"</option>";
    });

    jQuery("#feedingType_selection").html(str);
    jQuery("#filter_feedingType_selection").html(str);


}