/**
 * Created by user on 16/3/5.
 *
 */

/*检测当前系统报警信息*/
function checkSystemAlarmInfo(){
	
	jQuery.ajax({
        url: "../../user/oil/checkSystemAlarmInfo",
        data: requestData,
        contentType:"application/x-www-form-urlencoded",
        dataType:"json",
        success: function(response){
            switch (response.retCode){
                case 200:
                	break;
                	
                default:
                	alert("加载系统报警信息失败，请重试，如果重试多次有问题，请联系技术人员核对");
                	break;
            }
        }
	});
	
}

/*获取当前报警状态信息*/
function getSystemAlarmStatus(){
	
	jQuery.ajax({
        url: "../../user/oil/getSystemAlarmStatus",
        data: requestData,
        contentType:"application/x-www-form-urlencoded",
        dataType:"json",
        success: function(response){
            switch (response.retCode){
                case 200:
                	if(response.status == 1){
                		//
                		$("#systemAlarmSystemImg").attribute("src","img/index/noAlarm.png");
                	}else if(response.status == 2){
                		//
                		$("#systemAlarmSystemImg").attribute("src","img/index/checkedAlarm.png");
                	}else if(response.status == 4){
                		//
                		$("#systemAlarmSystemImg").attribute("src","img/index/uncheckedAlarm.png");
                	}
                	
                	break;
                	
                default:
                	alert("加载系统报警信息失败，请重试，如果重试多次有问题，请联系技术人员核对");
                	break;
            }
        }
	});
}

