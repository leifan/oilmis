package com.mltech.brite.service.oil;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.OilTypeDao;
import com.mltech.brite.model.OilType;
import com.mltech.brite.request.oil.AddOilTypeRequest;
import com.mltech.brite.request.oil.DeleteOilTypeRequest;
import com.mltech.brite.request.oil.UpdateOilTypeRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.OilTypeListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;

/**
 * 油品类型service
 * @author user
 *
 */
@Service
public class OilTypeService {
	
	@Resource
	OilTypeDao oilTypeDao;
	
	public BaseResponse addOilType(AddOilTypeRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		OilType entity = new OilType();
		entity.setOilTypeCode(pojo.getOilTypeCode());
		entity.setOilTypeName(pojo.getOilTypeName());
		List<OilType> list = oilTypeDao.findListByCond(entity);
		
		if(list != null && list.size() >0){
			response = new BaseResponse(ResultType.repeat);
			return response;
		}
		
		entity.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setCreator(httpServletRequest.getRemoteHost());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		oilTypeDao.addEntity(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}

	public BaseResponse updateOilType(UpdateOilTypeRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		OilType entity = new OilType();
		entity.setOilTypeCode(pojo.getOilTypeCode());
		entity.setOilTypeName(pojo.getOilTypeName());
		List<OilType> list = oilTypeDao.findListByCond(entity);
		
		if(list != null && list.size() >0){
			if( !list.get(0).getId().equals(pojo.getId()) ){
				response = new BaseResponse(ResultType.repeat);
				response.setRetDesc("已存在相同编码和名称的油品类型，请重新核对后再更新");
				return response;
			}
		}
		entity.setId(pojo.getId());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		oilTypeDao.updateEntityById(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}
	
	public BaseResponse deleteOilType(DeleteOilTypeRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		OilType entity = new OilType();
		entity.setId(pojo.getId());
		oilTypeDao.deleteEntityById(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}
	
	public OilTypeListResponse getOilTypeList(){
		
		OilTypeListResponse response = null;
		List<OilType> list = oilTypeDao.findListByCond(null);
		
		response = new OilTypeListResponse(ResultType.success);
		response.setList(list);
		return response;
	}
	
	
}
