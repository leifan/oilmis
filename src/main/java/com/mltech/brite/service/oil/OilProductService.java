package com.mltech.brite.service.oil;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.OilProductDao;
import com.mltech.brite.model.OilProduct;
import com.mltech.brite.request.oil.AddOilProductRequest;
import com.mltech.brite.request.oil.DeleteEntityRequest;
import com.mltech.brite.request.oil.UpdateOilProductRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.OilProductListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;

/**
 * 油品类型service
 * @author user
 *
 */
@Service
public class OilProductService {
	
	@Resource
	OilProductDao oilProductDao;
	
	public BaseResponse addOilProduct(AddOilProductRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		OilProduct entity = new OilProduct();
		entity.setOilProductCode(pojo.getOilProductCode());
		List<OilProduct> list = oilProductDao.findListByCond(entity);
		
		if(list != null && list.size() >0){
			response = new BaseResponse(ResultType.repeat);
			return response;
		}
		
		entity.setOilProductName(pojo.getOilProductName());
		entity.setOilColor(pojo.getOilColor());
		entity.setOilTypeName(pojo.getOilTypeName());
		entity.setOilProductNameForOuter(pojo.getOilProductNameForOuter());
		
		entity.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setCreator(httpServletRequest.getRemoteHost());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		oilProductDao.addEntity(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}

	public BaseResponse updateOilProduct(UpdateOilProductRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		OilProduct entity = new OilProduct();
		entity.setOilProductCode(pojo.getOilProductCode());
		List<OilProduct> list = oilProductDao.findListByCond(entity);
		
		if(list != null && list.size() >0){
			if( !list.get(0).getId().equals(pojo.getId()) ){
				response = new BaseResponse(ResultType.repeat);
				response.setRetDesc("已存在相同编码和名称的油品类型，请重新核对后再更新");
				return response;
			}
		}
		
		entity.setId(pojo.getId());
		entity.setOilProductName(pojo.getOilProductName());
		entity.setOilColor(pojo.getOilColor());
		entity.setOilTypeName(pojo.getOilTypeName());
		entity.setOilProductNameForOuter(pojo.getOilProductNameForOuter());
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		oilProductDao.updateEntityById(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}
	
	public BaseResponse deleteOilProduct(DeleteEntityRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response = null;
		
		OilProduct entity = new OilProduct();
		entity.setId(pojo.getId());
		oilProductDao.deleteEntityById(entity);
		response = new BaseResponse(ResultType.success);
		return response;
	}
	
	public OilProductListResponse getOilProductList(){
		
		OilProductListResponse response = null;
		List<OilProduct> list = oilProductDao.findListByCond(null);
		
		response = new OilProductListResponse(ResultType.success);
		response.setList(list);
		return response;
	}
	
	
}
