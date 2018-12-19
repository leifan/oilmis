/**
 * Created by user on 16/3/5.
 *
 */

var districtList = new Array();
var oilStationList = new Array();
var oilProductList = new Array();

function init(){

    initDateTimePicker();
    initTableHead();
    getShiftWorkList();
    getDistrictList();
    getilProductList();
    getOilStationList();
    getFeedingType();
    //deleteElementListener();
    print();
    initModal();
}


function initModal(){
    jQuery('#addModal').modal({
        backdrop: 'static',//禁止点击空白处小时
        keyboard: false,//禁止键盘事件消失
        show:false //初始化时不显示
    });
}

//初始化表头，每次查询后需要重新调用该方法
function initTableHead(){

    jQuery("#shiftWorkTable").bootstrapTable('destroy').bootstrapTable({
        columns: [{
            field: 'id',
            title: '编号'
        },{
            field: 'className',
            title: '班号'
        },{
            field: 'oilCanName',
            title: '罐名'
        },{
            field: 'oilProductName',
            title: '油品类型'
        },{
            field: 'districtName',
            title: '区域'
        },{
            field: 'shiftTime',
            title: '交班时间'
        },{
            field: 'stationName',
            title: '站名'
        },{
            field: 'oilHeight',
            title: '油高'
        },{
            field: 'waterHeight',
            title: '水高'
        },{
            field: 'avergeTemperate',
            title: '日期'
        },{
            field: 'shiTemperate',
            title: '视温'
        },{
            field: 'shiDensity',
            title: '视密度'
        },{
            field: 'standardDensity',
            title: '标准密度'
        },{
            field: 'standardCapacity',
            title: '标准体积'
        },{
            field: 'netOilCapacity',
            title: '净油体积'
        },{
            field: 'waterCapacity',
            title: '水体积'
        },{
            field: 'netOilQuality',
            title: '净油质量'
        },{
            field: 'createTime',
            title: '创建时间'
        }, {
            field: 'creator',
            title: '创建人'
        }]
    });

}

function getShiftWorkList(requestData) {

    if(requestData == undefined || requestData == ''){
        requestData='';
    }

    jQuery.ajax({
        url: "../user/oil/getShiftWorkList",
        data: requestData,
        contentType:"application/x-www-form-urlencoded",
        dataType:"json",
        success: function(response){
            switch (response.retCode){
                case 200:
                    initTableHead();/// 每次查询都要重新初始化table
                    //var originTableDatas = jQuery.parseJSON(response.list);
                    var originTableDatas = response.list;
                    var itemInfos = [];
                    originTableDatas.forEach(function(item){
                        var itemInfo = {
                            id: item.id,
                            className: item.className,
                            oilCanName: item.oilCanName,
                            oilProductName: item.oilProductName,
                            stationName: item.stationName,
                            districtName: item.districtName,
                            shiftTime: item.shiftTime,
                            oilHeight: item.oilHeight,
                            waterHeight: item.waterHeight,
                            avergeTemperate: item.avergeTemperate,
                            shiTemperate: item.shiTemperate,
                            shiDensity: item.shiDensity,
                            standardDensity: item.standardDensity,
                            standardCapacity: item.standardCapacity,
                            netOilCapacity: item.netOilCapacity,
                            waterCapacity: item.waterCapacity,
                            netOilQuality: item.netOilQuality,
                            createTime: item.createTime,
                            creator: item.creator,
                            //operation:'<span class="btn btn-info btn-xs" onclick="deleteElementModal(this)">删除</span>'
                        };

                        itemInfos.push(itemInfo);
                    });
                    jQuery('#shiftWorkTable').bootstrapTable('append', itemInfos);
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


function initDateTimePicker(){
    jQuery("#beginTime").datetimepicker({
        format : 'yyyy-mm-dd',
        minView: 'month',
        autoclose:true,
        language: 'zh-cn',
        lang:"ch",
        todayHighlight:true
    });
    jQuery("#endTime").datetimepicker({
        format : 'yyyy-mm-dd',
        minView: 'month',
        autoclose:true,
        language: 'zh-cn',
        lang:"ch",
        todayHighlight:true
    });
    jQuery("#shiftTime").datetimepicker({
        format : 'yyyy-mm-dd hh:ii:ss',
        minView: 'hour',
        autoclose:true,
        language: 'zh-cn',
        lang:"ch",
        todayHighlight:true
    });
}

function searchRecord(){

    var beginTime = jQuery.trim(document.getElementById("beginTime").value);
    var endTime = jQuery.trim(document.getElementById("endTime").value);
    var stationName = jQuery.trim(document.getElementById("filter_oilStationName_selection").value);
    var districtName = jQuery.trim(document.getElementById("filter_districtName_selection").value);

    if (beginTime.length == 0) {
        alert("请选择开始时间");
        return;
    }

    if (endTime.length == 0) {
        alert("请选择结束时间");
        return;
    }

    if (beginTime >= endTime) {
        alert("开始时间不能大于等于结束时间");
        return;
    }


    var requestData = '';
    requestData = {
        beginTime:beginTime,
        endTime:endTime,
        stationName:stationName,
        districtName:districtName
    }

    getShiftWorkList(requestData);

}

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

//增加新的记录
function addShiftWork(reqestData){

    var className = document.getElementById("className").value;
    var oilCanName = document.getElementById("oilCanName").value;
    var oilProductName = document.getElementById("oilProduct_selection").value;
    var shiftTime = document.getElementById("shiftTime").value;
    var districtName = document.getElementById("districtName_selection").value;
    var stationName = document.getElementById("oilStationName_selection").value;
    var oilHeight = document.getElementById("oilHeight").value;
    var waterHeight = document.getElementById("waterHeight").value;
    var avergeTemperate = document.getElementById("avergeTemperate").value;
    var shiTemperate = document.getElementById("shiTemperate").value;
    var shiDensity = document.getElementById("shiDensity").value;
    var standardDensity = document.getElementById("standardDensity").value;
    var standardCapacity = document.getElementById("standardCapacity").value;
    var netOilCapacity = document.getElementById("netOilCapacity").value;
    var waterCapacity = document.getElementById("waterCapacity").value;
    var netOilQuality = document.getElementById("netOilQuality").value;

    var requestData={
        "className":className,
        "oilCanName":oilCanName,
        "oilProductName":oilProductName,
        "shiftTime":shiftTime,
        "districtName":districtName,
        "stationName":stationName,
        "shiftTime":shiftTime,
        "oilHeight":oilHeight,
        "waterHeight":waterHeight,
        "avergeTemperate":avergeTemperate,
        "shiTemperate":shiTemperate,
        "shiDensity":shiDensity,
        "standardDensity":standardDensity,
        "standardCapacity":standardCapacity,
        "netOilCapacity":netOilCapacity,
        "waterCapacity":waterCapacity,
        "netOilQuality":netOilQuality
    };

    $.ajax({
        type: "GET",
        url: "../user/oil/addShiftWork",
        data:requestData,
        timeout: 20000,
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            switch (data.retCode) {
                case 200:
                    jQuery("#addModal").modal('hide');
                    jQuery("#operationResultMessage").text(data.retDesc);
                    jQuery("#operaionModal").modal();
                    getShiftWorkList();//刷新数据页
                    break;
                default:
                    jQuery("#operationResultMessage").text(data.retDesc);
                    jQuery("#operaionModal").modal();
                    break;
            }
        },
        error: function (data) {
            jQuery("#operationResultMessage").text("页面提交出错，错误信息为"+data);
            jQuery("#operationModal").modal();
        }

    });

}

function deleteElementListener(){

    $("#shiftWorkTable").mousedown(function(event){
        alert(e.which);
        var tr = event.parentNode.parentNode.html();
        var tds = tr.cells;
        var id = tds[0];

    });
}

function updateElement(row){

}

var deleteId=-1;

/**---------表格栏有删除按钮进行删除开始---------------**/
function deleteElementModal(row) {

    jQuery("#deleteConfirmModal").modal();
    var tr = jQuery(row).parent().parent();
    var id = tr.find(":nth-child(1)").html();
    deleteId = id;
}

function deleteElement(id){

    if(id != undefined && id != ''){
        deleteId = id;
    }

    var requestData = {
      id:deleteId
    };

    $.ajax({
        type: "GET",
        url: "../user/oil/deleteShiftWork",
        data:requestData,
        timeout: 20000,
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            switch (data.retCode) {
                case 200:
                    //jQuery("#deleteConfirmModal").modal('hide');
                    jQuery("#deleteModal").modal('hide');
                    jQuery("#operationResultMessage").text(data.retDesc);
                    jQuery("#operationModal").modal();
                    getShiftWorkList();//刷新数据页
                    break;
                default:
                    jQuery("#operationResultMessage").text(data.retDesc);
                    jQuery("#operationModal").modal();
                    break;
            }
        },
        error: function (data) {
            jQuery("#operationResultMessage").text("页面提交出错，错误信息为"+data);
            jQuery("#operationModal").modal();
        }

    });

}
/**---------表格栏有删除按钮进行删除结束---------------**/


function print() {

    $("#btnPrint").click(function () {
        $("#shiftWorkTable").jqprint({
            debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
            importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
            printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
            operaSupport: false//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
        });
    });
}

function exportTable() {
    jQuery("#shiftWorkTable").tableExport({type:'excel',escape:'false'});
}

