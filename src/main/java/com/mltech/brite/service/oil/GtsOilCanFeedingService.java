package com.mltech.brite.service.oil;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.OilCanFeedingDao;
import com.mltech.brite.model.OilCanFeeding;
import com.mltech.brite.pagination.PaginationInfo;
import com.mltech.brite.pagination.PaginationList;
import com.mltech.brite.request.oil.AddOilCanFeedingRequest;
import com.mltech.brite.request.oil.DeleteEntityRequest;
import com.mltech.brite.request.oil.GetGtsOilCanFeedingDetailRequest;
import com.mltech.brite.request.oil.OilCanFeedingListRequest;
import com.mltech.brite.request.oil.UpdateOilCanFeedingRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.OilCanFeedingDetailResponse;
import com.mltech.brite.response.oil.OilCanFeedingListResponse;
import com.mltech.brite.response.oil.OilCanFeedingTop10ListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;


@Service
public class GtsOilCanFeedingService {
	
	@Resource
	OilCanFeedingDao oilCanFeedingDao;
	
	public BaseResponse addOilCanFeeding(AddOilCanFeedingRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilCanFeeding entity = new OilCanFeeding();
		
		entity.setFeedingType(pojo.getFeedingType());
		entity.setOilCanName(pojo.getOilCanName());
		entity.setStationName(pojo.getStationName());
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
		
		oilCanFeedingDao.addEntity(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 更新操作
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	public BaseResponse updateOilCanFeeding(UpdateOilCanFeedingRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilCanFeeding entity = new OilCanFeeding();
		entity.setId(pojo.getId());
		entity.setFeedingType(pojo.getFeedingType());
		entity.setOilCanName(pojo.getOilCanName());
		entity.setStationName(pojo.getStationName());
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
		entity.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		entity.setUpdater(httpServletRequest.getRemoteHost());
		
		oilCanFeedingDao.updateEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	public BaseResponse deleteEntityById(DeleteEntityRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse response;
		OilCanFeeding entity = new OilCanFeeding();
		entity.setId(pojo.getId());
		oilCanFeedingDao.deleteEntityById(entity);
		
		response = new BaseResponse(ResultType.success);
		return response;
		
	}
	
	/**
	 * 查询进油记录列表
	 * @param paginationInfo
	 * @return
	 */
	public OilCanFeedingListResponse getOilCanFeedingList(OilCanFeedingListRequest pojo,PaginationInfo paginationInfo){
		OilCanFeedingListResponse response = null;
		OilCanFeeding cond = new OilCanFeeding();
		cond.setStationName(pojo.getStationName());
		cond.setBeginTime(pojo.getBeginTime());
		cond.setEndTime(pojo.getEndTime());
		
		PaginationList<OilCanFeeding> list = oilCanFeedingDao.selectPaginationList(cond,paginationInfo);
		
		response = new OilCanFeedingListResponse(ResultType.success);
		response.setList(list);
		
		return response;
	}
	
	public OilCanFeedingDetailResponse getOilCanFeedingDetail(GetGtsOilCanFeedingDetailRequest pojo){
		
		OilCanFeedingDetailResponse response = null;
		OilCanFeeding cond = new OilCanFeeding();
		cond.setId(pojo.getId());
		List<OilCanFeeding> list = oilCanFeedingDao.selectPaginationList(cond,null);
		if( list != null && list.size() > 0 ){
			response = new OilCanFeedingDetailResponse(ResultType.success);
			response.setDetail(list.get(0));
			return response;
		}else{
			response = new OilCanFeedingDetailResponse(ResultType.success);
			return response;
		}
		
	}
	
	/**
	 * 查询进油记录列表
	 * @param paginationInfo
	 * @return
	 */
	public OilCanFeedingTop10ListResponse getOilCanFeedingTop10(){
		OilCanFeedingTop10ListResponse response = null;
		List<OilCanFeeding> list = oilCanFeedingDao.recentTop10();
		
		if(list == null|| list.size() < 10){
			for(int i=list.size();i<=10;i++){
				OilCanFeeding e = new OilCanFeeding();
				e.setOilHeight("0");
				e.setNetOilCapacity("0");
				e.setId(Integer.toString(i));
				list.add(e);
			}
		}
		
		response = new OilCanFeedingTop10ListResponse(ResultType.success);
		response.setList(list);
		
		return response;
	}

}
