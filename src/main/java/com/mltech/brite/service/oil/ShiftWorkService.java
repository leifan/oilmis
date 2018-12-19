package com.mltech.brite.service.oil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.ShiftWorkDao;
import com.mltech.brite.model.ShiftWork;
import com.mltech.brite.pagination.PaginationInfo;
import com.mltech.brite.pagination.PaginationList;
import com.mltech.brite.request.oil.AddShiftWorkRequest;
import com.mltech.brite.request.oil.DeleteEntityRequest;
import com.mltech.brite.request.oil.GetShitWorkRequest;
import com.mltech.brite.request.oil.UpdateShiftWorkRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.GetShiftWorkListResult;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;

@Service
public class ShiftWorkService {
	
	@Resource
	ShiftWorkDao shiftWorkDao;
	
	public BaseResponse addShiftWork(AddShiftWorkRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		ShiftWork entity = new ShiftWork();
		
		entity.setClassName(pojo.getClassName());
		entity.setOilCanName(pojo.getOilCanName());
		entity.setStationName(pojo.getStationName());
		entity.setDistrictName(pojo.getDistrictName());
		entity.setShiftTime(pojo.getShiftTime());
		entity.setOilProductName(pojo.getOilProductName());
		entity.setAvergeTemperate(pojo.getAvergeTemperate());
		entity.setNetOilCapacity(pojo.getNetOilCapacity());
		entity.setNetOilQuality(pojo.getNetOilQuality());
		entity.setOilHeight(pojo.getOilHeight());
		entity.setWaterHeight(pojo.getWaterHeight());
		entity.setWaterCapacity(pojo.getWaterCapacity());
		entity.setShiDensity(pojo.getShiDensity());
		entity.setShiTemperate(pojo.getShiTemperate());
		entity.setStandardCapacity(pojo.getStandardCapacity());
		entity.setStandardDensity(pojo.getStandardDensity());
		
		entity.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setCreator(httpServletRequest.getRemoteHost());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		shiftWorkDao.addEntity(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 更新操作
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	public BaseResponse updateShiftWork(UpdateShiftWorkRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		ShiftWork entity = new ShiftWork();
		
		entity.setId(pojo.getId());
		entity.setClassName(pojo.getClassName());
		entity.setOilCanName(pojo.getOilCanName());
		entity.setStationName(pojo.getStationName());
		entity.setDistrictName(pojo.getDistrictName());
		entity.setShiftTime(pojo.getShiftTime());
		entity.setOilProductName(pojo.getOilProductName());
		entity.setAvergeTemperate(pojo.getAvergeTemperate());
		entity.setNetOilCapacity(pojo.getNetOilCapacity());
		entity.setNetOilQuality(pojo.getNetOilQuality());
		entity.setOilHeight(pojo.getOilHeight());
		entity.setWaterHeight(pojo.getWaterHeight());
		entity.setWaterCapacity(pojo.getWaterCapacity());
		entity.setShiDensity(pojo.getShiDensity());
		entity.setShiTemperate(pojo.getShiTemperate());
		entity.setStandardCapacity(pojo.getStandardCapacity());
		entity.setStandardDensity(pojo.getStandardDensity());
		
		shiftWorkDao.updateEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	public BaseResponse deleteEntityById(DeleteEntityRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		ShiftWork entity = new ShiftWork();
		entity.setId(new Integer(pojo.getId()));
		shiftWorkDao.deleteEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 查询交班记录列表
	 * @param paginationInfo
	 * @return
	 */
	public GetShiftWorkListResult getShiftWorkList(GetShitWorkRequest pojo,PaginationInfo paginationInfo){
		GetShiftWorkListResult response = null;
		ShiftWork cond = new ShiftWork();
		cond.setStationName(pojo.getStationName());
		cond.setBeginTime(pojo.getBeginTime());
		cond.setEndTime(pojo.getEndTime());
		cond.setDistrictName(pojo.getDistrictName());
		
		PaginationList<ShiftWork> list = shiftWorkDao.selectPaginationList(cond,paginationInfo);
		
		response = new GetShiftWorkListResult(ResultType.success);
		response.setList(list);
		
		return response;
	}
	
}
