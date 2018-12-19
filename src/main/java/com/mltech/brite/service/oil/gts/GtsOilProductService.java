package com.mltech.brite.service.oil.gts;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.OilProductDao;
import com.mltech.brite.model.OilProduct;
import com.mltech.brite.request.oil.DeleteEntityRequest;
import com.mltech.brite.request.oil.gts.AddOilProductRequest;
import com.mltech.brite.request.oil.gts.GetOilProductDetailRequest;
import com.mltech.brite.request.oil.gts.UpdateOilProductRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.OilProductListResponse;
import com.mltech.brite.response.oil.gts.OilProductDetailResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;

/**
 * 油品类型service
 * @author user
 *
 */
@Service
public class GtsOilProductService {
	
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
		entity.setDensity(pojo.getDensity());
		
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
		entity.setDensity(pojo.getDensity());
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
	
	public OilProductDetailResponse getOilProductDetail(GetOilProductDetailRequest request){
		
		OilProductDetailResponse response = null;
		OilProduct cond = new OilProduct();
		cond.setId(request.getId());
		List<OilProduct> list = oilProductDao.findListByCond(cond);
		
		if(list == null || list.size() == 0){
			response = new OilProductDetailResponse(ResultType.noRecord);
			return response;
		}
		
		response = new OilProductDetailResponse(ResultType.success);
		response.setDetail(list.get(0));
		return response;
	}
	
	
}
