package com.mltech.brite.service.oil;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.DistrictTypeDao;
import com.mltech.brite.model.DistrictType;
import com.mltech.brite.request.oil.AddDistrictTypeRequest;
import com.mltech.brite.request.oil.DeleteDistrictTypeRequest;
import com.mltech.brite.request.oil.UpdateDistrictTypeRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.DistrictListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;

/**
 * 油品类型service
 * @author user
 *
 */
@Service
public class DistrictTypeService {
	
	@Resource
	DistrictTypeDao districtTypeDao;
	
	public BaseResponse addDistrictType(AddDistrictTypeRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		DistrictType entity = new DistrictType();
		entity.setDistrictId(pojo.getDistrictId());
		List<DistrictType> list = districtTypeDao.findListByCond(entity);
		
		if(list != null && list.size() >0){
			response = new BaseResponse(ResultType.repeat);
			return response;
		}
		
		entity.setDistrictName(pojo.getDistrictName());
		entity.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setCreator(httpServletRequest.getRemoteHost());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		districtTypeDao.addEntity(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}

	public BaseResponse updateDistrictType(UpdateDistrictTypeRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		DistrictType entity = new DistrictType();
		entity.setDistrictId(pojo.getDistrictId());
		List<DistrictType> list = districtTypeDao.findListByCond(entity);
		
		if(list != null && list.size() >0){
			if( !list.get(0).getId().equals(pojo.getId()) ){
				response = new BaseResponse(ResultType.repeat);
				response.setRetDesc("已存在相同编码和名称的区域信息，请重新核对后再更新");
				return response;
			}
		}
		
		entity.setId(pojo.getId());
		entity.setDistrictName(pojo.getDistrictName());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		districtTypeDao.updateEntityById(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}
	
	public BaseResponse deleteDistrictType(DeleteDistrictTypeRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		DistrictType entity = new DistrictType();
		entity.setId(pojo.getId());
		districtTypeDao.deleteEntityById(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}
	
	/**
	 * 区域列表
	 * @return
	 */
	public DistrictListResponse getDistrictList(){
		
		DistrictListResponse response = null;
		List<DistrictType> list = districtTypeDao.findListByCond(null);
		response = new DistrictListResponse(ResultType.success);
		response.setList(list);
		return response;
	}
	
	
}
