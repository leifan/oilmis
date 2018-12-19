package com.mltech.brite.service.oil.gts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.gts.OilCanAlarmDao;
import com.mltech.brite.model.GtsOilCanAlarm;
import com.mltech.brite.request.oil.gts.ConfirmSystemAlarmRequest;
import com.mltech.brite.request.oil.gts.GetOilCanAlarmDetailRequest;
import com.mltech.brite.request.oil.gts.OilCanAlarmRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.gts.GetOilCanAlarmDetailResponse;
import com.mltech.brite.response.oil.gts.OilCanAlarmResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.UserUtil;

@Service
public class GtsOilCanAlarmService {
	
	@Resource
	OilCanAlarmDao oilCanAlarmDao;
	
	public OilCanAlarmResponse getOilCanAlarmList(OilCanAlarmRequest pojo){
		
		OilCanAlarmResponse response = new OilCanAlarmResponse(ResultType.success);
		GtsOilCanAlarm cond = new GtsOilCanAlarm();
		cond.setBeginDate(pojo.getBeginDate());
		cond.setEndDate(pojo.getEndDate());
		
		List<GtsOilCanAlarm> list = oilCanAlarmDao.findEntityByCond(cond);
		response.setList(list);
		return response;
		
	}
	
	/**
	 * 获取报警列表，对确实有报警和没有报警的，默认只展示15天的数据信息
	 * @param pojo
	 * @return
	 */
	public OilCanAlarmResponse getOilCanConfirmAlarmList(){
		
		OilCanAlarmResponse response = new OilCanAlarmResponse(ResultType.success);
		GtsOilCanAlarm cond = new GtsOilCanAlarm();
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String now = sdf.format(calendar.getTime());
		
		calendar.add(Calendar.DAY_OF_YEAR, -15);
		String last = sdf.format(calendar.getTime());
		
		cond.setBeginDate(last);
		cond.setEndDate(now);
		
		List<GtsOilCanAlarm> list = oilCanAlarmDao.findEntityByCond(cond);
		response.setList(list);
		return response;
		
	}
	
	/**
	 * 获取报警列表，对确实有报警和没有报警的，默认只展示15天的数据信息
	 * @param pojo
	 * @return
	 */
	public GetOilCanAlarmDetailResponse getOilCanConfirmAlarmDetail(GetOilCanAlarmDetailRequest request){
		
		GetOilCanAlarmDetailResponse response = new GetOilCanAlarmDetailResponse(ResultType.success);
		GtsOilCanAlarm cond = new GtsOilCanAlarm();
		cond.setId(request.getId());
		List<GtsOilCanAlarm> list = oilCanAlarmDao.findEntityByCond(cond);
		
		if(list == null || list.size() == 0){
			response = new GetOilCanAlarmDetailResponse(ResultType.noRecord);
		}
		
		response.setDetail(list.get(0));
		return response;
		
	}
	
	/**
	 * 报警确认
	 * @param pojo
	 * @return
	 */
	public BaseResponse confirmSystemAlarm(ConfirmSystemAlarmRequest pojo){
		
		GtsOilCanAlarm cond = new GtsOilCanAlarm();
		cond.setId(pojo.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String confirmTime = sdf.format(System.currentTimeMillis());
		cond.setConfirmTime(confirmTime);
		cond.setConfirmUser(UserUtil.getCurrentUserInfo());
		
		oilCanAlarmDao.updateEntityById(cond);
		
		return new BaseResponse(ResultType.success);
	}
	

}
