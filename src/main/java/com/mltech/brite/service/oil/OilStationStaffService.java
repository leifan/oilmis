package com.mltech.brite.service.oil;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.OilStationStaffDao;
import com.mltech.brite.model.OilStationStaff;
import com.mltech.brite.request.oil.AddOilStationStaffRequest;
import com.mltech.brite.request.oil.DeleteOilStationStaffRequest;
import com.mltech.brite.request.oil.OilStationStaffListRequest;
import com.mltech.brite.request.oil.UpdateOilStationStaffRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.OilStationStaffListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;


@Service
public class OilStationStaffService {
	
	@Resource
	OilStationStaffDao OilStationStaffDao;
	
	public BaseResponse addOilStationStaff(AddOilStationStaffRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilStationStaff entity = new OilStationStaff();
		entity.setDistrictName(pojo.getDistrictName());
		entity.setOilStationName(pojo.getOilStationName());
		entity.setStaffId(pojo.getStaffId());
		
		List<OilStationStaff> list = OilStationStaffDao.findEntityListByCond(entity);
		if(list != null && list.size() > 0){
			response = new BaseResponse(ResultType.repeat);
			response.setRetDesc("该油站已存在该编号员工，请确认后重新添加");
			return response;
		}
		
		entity.setStaffName(pojo.getStaffName());
		entity.setStaffType(pojo.getStaffType());
		entity.setTel(pojo.getTel());
		entity.setPhone(pojo.getPhone());
		entity.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setCreator(httpServletRequest.getRemoteHost());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		OilStationStaffDao.addEntity(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 更新操作；每次更新时先查询库中的记录项，如果有结果且结果和当前编辑的id相同，则直接更新，否则则返回重复记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	public BaseResponse updateOilStationStaff(UpdateOilStationStaffRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilStationStaff entity = new OilStationStaff();
		entity.setDistrictName(pojo.getOilStationCode());
		entity.setOilStationName(pojo.getOilStationName());
		entity.setStaffId(pojo.getStaffId());
		
		List<OilStationStaff> list = OilStationStaffDao.findEntityListByCond(entity);
		if(list != null && list.size() > 0){
			
			if( !list.get(0).getId().equals(pojo.getId()) ){
				response = new BaseResponse(ResultType.repeat);
				response.setRetDesc("已存在该员工，请确认后重新添加");
				return response;
			}
		}
		
		entity.setId(pojo.getId());
		entity.setStaffName(pojo.getStaffName());
		entity.setStaffType(pojo.getStaffType());
		entity.setTel(pojo.getTel());
		entity.setPhone(pojo.getPhone());
		
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		OilStationStaffDao.updateEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	public BaseResponse deleteOilStationStaff(DeleteOilStationStaffRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilStationStaff entity = new OilStationStaff();
		entity.setId(pojo.getId());
		OilStationStaffDao.deleteEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 获取某个油站的所有员工
	 * @param pojo
	 * @return
	 */
	public OilStationStaffListResponse getOilStationStaffList(OilStationStaffListRequest pojo){
		
		OilStationStaffListResponse response = null;
		
		OilStationStaff cond = new OilStationStaff();
		cond.setOilStationName(pojo.getOilStationName());
		cond.setDistrictName(pojo.getDistrictName());
		
		List<OilStationStaff> list = OilStationStaffDao.findEntityListByCond(cond);
		response = new OilStationStaffListResponse(ResultType.success);
		response.setList(list);
		
		return response;
	}

}
