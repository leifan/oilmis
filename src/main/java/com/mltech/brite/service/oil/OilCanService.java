package com.mltech.brite.service.oil;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.OilCanDao;
import com.mltech.brite.model.OilCan;
import com.mltech.brite.request.oil.AddOilCanRequest;
import com.mltech.brite.request.oil.DeleteOilCanRequest;
import com.mltech.brite.request.oil.GetOilCanDetailRequest;
import com.mltech.brite.request.oil.OilCanListRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.GetOilCanDetailResponse;
import com.mltech.brite.response.oil.OilCanListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;


@Service
public class OilCanService {
	
	@Resource
	OilCanDao oilCanDao;
	
	public BaseResponse addOilCan(AddOilCanRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilCan entity = new OilCan();
		entity.setOilCanCode(pojo.getOilCanCode());
		entity.setOilCanName(pojo.getOilCanName());
		entity.setStationName(pojo.getStationName());
		entity.setDistrictName(pojo.getDistrictName());
		entity.setStationRealCode(pojo.getStationRealCode());
		
		List<OilCan> list = oilCanDao.findEntityListByCond(entity);
		if(list != null && list.size() > 0){
			response = new BaseResponse(ResultType.repeat);
			response.setRetDesc("已存在油罐，请确认后重新添加");
			return response;
		}
		
		entity.setOilCanHeight(pojo.getOilCanHeight());
		entity.setOilCanVolumn(pojo.getOilCanVolumn());
		entity.setOilCanType(pojo.getOilCanType());
		entity.setOilProductName(pojo.getOilProductName());
		entity.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setCreator(httpServletRequest.getRemoteHost());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());

		if(!StringUtils.isBlank(pojo.getStationRealCode())){
			entity.setStationRealCode(pojo.getStationRealCode());
		}else{
			entity.setStationRealCode("");
		}
		if(!StringUtils.isBlank(pojo.getStationCode())){
			entity.setStationCode(pojo.getStationCode());
		}else{
			entity.setStationCode("");
		}
		entity.setCheckTime("");
		
		entity.setOilCanStatus(pojo.getOilCanStatus());
		
		oilCanDao.addEntity(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 更新操作；每次更新时先查询库中的记录项，如果有结果且结果和当前编辑的油罐id相同，则直接更新，否则则返回重复记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	public BaseResponse updateOilCan(AddOilCanRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilCan entity = new OilCan();
		entity.setOilCanCode(pojo.getOilCanCode());
		entity.setOilCanName(pojo.getOilCanName());
		entity.setDistrictName(pojo.getDistrictName());
		entity.setStationName(pojo.getStationName());
		entity.setStationRealCode(pojo.getStationRealCode());
		
		List<OilCan> list = oilCanDao.findEntityListByCond(entity);
		if(list != null && list.size() > 0){
			
			if( !list.get(0).getId().equals(pojo.getId()) ){
				response = new BaseResponse(ResultType.repeat);
				response.setRetDesc("已存在油罐，请确认后重新添加");
				return response;
			}
		}
		entity.setId(pojo.getId());
		entity.setOilCanHeight(pojo.getOilCanHeight());
		entity.setOilCanVolumn(pojo.getOilCanVolumn());
		entity.setOilCanType(pojo.getOilCanType());
		entity.setOilProductName(pojo.getOilProductName());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		entity.setStationCode("");
		
		oilCanDao.updateEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	public BaseResponse deleteEntityById(DeleteOilCanRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilCan entity = new OilCan();
		entity.setId(pojo.getId());
		oilCanDao.deleteEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 查询油罐列表
	 * @param paginationInfo
	 * @return
	 */
	public OilCanListResponse getOilCanList(OilCanListRequest request){
		OilCanListResponse response = null;
		OilCan cond = new OilCan();
		cond.setStationName(request.getOilStationName());
		
		List<OilCan> list = oilCanDao.findEntityListByCond(cond);
		
		response = new OilCanListResponse(ResultType.success);
		response.setList(list);
		
		return response;
	}
	
	public GetOilCanDetailResponse getOilCanDetail(GetOilCanDetailRequest pojo){
		
		GetOilCanDetailResponse response = null;
		OilCan cond = new OilCan();
		cond.setOilCanName(pojo.getOilCanName());
		
		List<OilCan> list = oilCanDao.findEntityListByCond(cond);
		if( list != null && list.size() > 0 ){
			response = new GetOilCanDetailResponse(ResultType.success);
			response.setDetail(list.get(0));
			return response;
		}else{
			response = new GetOilCanDetailResponse(ResultType.success);
			return response;
		}
		
	}

}
