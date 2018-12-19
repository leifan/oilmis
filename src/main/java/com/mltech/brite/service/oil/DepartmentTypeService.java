package com.mltech.brite.service.oil;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.DepartmentTypeDao;
import com.mltech.brite.model.DepartmentType;
import com.mltech.brite.request.oil.AddDepartmentTypeRequest;
import com.mltech.brite.request.oil.DeleteDepartmentTypeRequest;
import com.mltech.brite.request.oil.UpdateDepartmentTypeRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.DepartmentListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;

/**
 * 油品类型service
 * @author user
 *
 */
@Service
public class DepartmentTypeService {
	
	@Resource
	DepartmentTypeDao departmentTypeDao;
	
	public BaseResponse addDepartmentType(AddDepartmentTypeRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		DepartmentType entity = new DepartmentType();
		entity.setDepartmentId(pojo.getDepartmentId());
		List<DepartmentType> list = departmentTypeDao.findListByCond(entity);
		
		if(list != null && list.size() >0){
			response = new BaseResponse(ResultType.repeat);
			return response;
		}
		
		entity.setDepartmentName(pojo.getDepartmentName());
		entity.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setCreator(httpServletRequest.getRemoteHost());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		departmentTypeDao.addEntity(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}

	public BaseResponse updateDepartmentType(UpdateDepartmentTypeRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		DepartmentType entity = new DepartmentType();
		entity.setDepartmentId(pojo.getDepartmentId());
		List<DepartmentType> list = departmentTypeDao.findListByCond(entity);
		
		if(list != null && list.size() >0){
			if( !list.get(0).getId().equals(pojo.getId()) ){
				response = new BaseResponse(ResultType.repeat);
				response.setRetDesc("已存在相同编码和名称的部门信息，请重新核对后再更新");
				return response;
			}
		}
		
		entity.setId(pojo.getId());
		entity.setDepartmentName(pojo.getDepartmentName());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		departmentTypeDao.updateEntityById(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}
	
	public BaseResponse deleteDepartmentType(DeleteDepartmentTypeRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		DepartmentType entity = new DepartmentType();
		entity.setId(pojo.getId());
		departmentTypeDao.deleteEntityById(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}
	
	public DepartmentListResponse getDepartmentList(){
		
		List<DepartmentType> list = departmentTypeDao.findListByCond(null);
		DepartmentListResponse response = new DepartmentListResponse(ResultType.success);
		response.setList(list);
		return response;
	}
	
	
}
