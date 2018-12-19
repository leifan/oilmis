package com.mltech.brite.service.oil;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.OilStationDao;
import com.mltech.brite.model.OilStation;
import com.mltech.brite.request.oil.AddOilStationRequest;
import com.mltech.brite.request.oil.DeleteOilStationRequest;
import com.mltech.brite.request.oil.OilStationListRequest;
import com.mltech.brite.request.oil.UpdateOilStationRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.OilStationListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;


@Service
public class OilStationService {
	
	@Resource
	OilStationDao oilStationDao;
	
	public BaseResponse addOilStation(AddOilStationRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilStation entity = new OilStation();
		entity.setDistrictName(pojo.getDistrictName());
		entity.setStationCode(pojo.getStationCode());
		entity.setStationName(pojo.getStationName());
		entity.setStationRealCode(pojo.getStationRealCode());
		
		List<OilStation> list = oilStationDao.findEntityListByCond(entity);
		if(list != null && list.size() > 0){
			response = new BaseResponse(ResultType.repeat);
			response.setRetDesc("已存在油站，请确认后重新添加");
			return response;
		}
		
		entity.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setCreator(httpServletRequest.getRemoteHost());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		oilStationDao.addEntity(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 更新操作；每次更新时先查询库中的记录项，如果有结果且结果和当前编辑的油罐id相同，则直接更新，否则则返回重复记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	public BaseResponse updateOilStation(UpdateOilStationRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilStation entity = new OilStation();
		entity.setDistrictName(pojo.getDistrictName());
		entity.setStationCode(pojo.getStationCode());
		entity.setStationName(pojo.getStationName());
		entity.setStationRealCode(pojo.getStationRealCode());
		
		List<OilStation> list = oilStationDao.findEntityListByCond(entity);
		if(list != null && list.size() > 0){
			
			if( !list.get(0).getId().equals(pojo.getId()) ){
				response = new BaseResponse(ResultType.repeat);
				response.setRetDesc("已存在油罐，请确认后重新添加");
				return response;
			}
		}
		
		entity.setId(pojo.getId());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		oilStationDao.updateEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	public BaseResponse deleteOilStation(DeleteOilStationRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilStation entity = new OilStation();
		entity.setId(pojo.getId());
		oilStationDao.deleteEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 查询油罐列表
	 * @param paginationInfo
	 * @return
	 */
	public OilStationListResponse getOilStationList(OilStationListRequest request){
		OilStationListResponse response = null;
		OilStation cond = new OilStation();
		cond.setDistrictName(request.getDistrictName());
		
		List<OilStation> list = oilStationDao.findEntityListByCond(cond);
		
		response = new OilStationListResponse(ResultType.success);
		response.setList(list);
		
		return response;
	}

}
