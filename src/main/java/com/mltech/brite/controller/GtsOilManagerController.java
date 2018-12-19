package com.mltech.brite.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mltech.brite.request.oil.DeleteEntityRequest;
import com.mltech.brite.request.oil.GetGtsOilCanFeedingDetailRequest;
import com.mltech.brite.request.oil.gts.AddOilCanComRequest;
import com.mltech.brite.request.oil.gts.AddOilProductRequest;
import com.mltech.brite.request.oil.gts.ConfirmSystemAlarmRequest;
import com.mltech.brite.request.oil.gts.DeleteOilCanComRequest;
import com.mltech.brite.request.oil.gts.GetOilCanAlarmDetailRequest;
import com.mltech.brite.request.oil.gts.GetOilProductDetailRequest;
import com.mltech.brite.request.oil.gts.OilCanAlarmRequest;
import com.mltech.brite.request.oil.gts.UpdateOilCanComRequest;
import com.mltech.brite.request.oil.gts.UpdateOilProductRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.OilCanFeedingDetailResponse;
import com.mltech.brite.response.oil.gts.GetOilCanAlarmDetailResponse;
import com.mltech.brite.response.oil.gts.OilCanAlarmResponse;
import com.mltech.brite.response.oil.gts.OilCanComResponse;
import com.mltech.brite.response.oil.gts.OilProductDetailResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.service.oil.GtsOilCanFeedingService;
import com.mltech.brite.service.oil.gts.GtsOilCanAlarmService;
import com.mltech.brite.service.oil.gts.GtsOilComService;
import com.mltech.brite.service.oil.gts.GtsOilProductService;
import com.mltech.brite.util.LoggerUtil;

@Controller
@RequestMapping("/user/oil/gts/")
public class GtsOilManagerController {
	
	@Resource
	GtsOilCanFeedingService gtsOilCanFeedingService;
	
	@Resource
	GtsOilCanAlarmService gtsOilCanAlarmService;
	
	@Resource
	GtsOilProductService gtsOilProductService;
	
	@Resource
	GtsOilComService gtsOilComService;

	@RequestMapping(value = "getOilCanFeedingDetail", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getGtsOilCanFeedingDetail(GetGtsOilCanFeedingDetailRequest pojo,HttpServletRequest httpServletRequest){
		
		OilCanFeedingDetailResponse oilCanFeedingDetailResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			oilCanFeedingDetailResponse = gtsOilCanFeedingService.getOilCanFeedingDetail(pojo);
		}catch(Exception e){
			oilCanFeedingDetailResponse = new OilCanFeedingDetailResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilCanFeedingDetailResponse);
	}
	
	@RequestMapping(value = "getOilCanAlarmList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilCanAlarmList(OilCanAlarmRequest pojo,HttpServletRequest httpServletRequest){
		
		OilCanAlarmResponse oilCanAlarmResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			oilCanAlarmResponse = gtsOilCanAlarmService.getOilCanAlarmList(pojo);
		}catch(Exception e){
			oilCanAlarmResponse = new OilCanAlarmResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilCanAlarmResponse);
	}
	
	/**
	 * 报警页面查询报警，默认查询15天之内的报警信息
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getOilCanAlarmConfirmList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilCanAlarmConfirmList(HttpServletRequest httpServletRequest){
		
		OilCanAlarmResponse oilCanAlarmResponse = null;
		
		try{
			oilCanAlarmResponse = gtsOilCanAlarmService.getOilCanConfirmAlarmList();
		}catch(Exception e){
			oilCanAlarmResponse = new OilCanAlarmResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilCanAlarmResponse);
	}
	
	/**
	 * 报警页面查询报警，默认查询15天之内的报警信息
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "confirmSystemAlarm", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String confirmSystemAlarm(ConfirmSystemAlarmRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse confirmSystemAlarmResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			
			confirmSystemAlarmResponse = gtsOilCanAlarmService.confirmSystemAlarm(pojo);
		}catch(Exception e){
			confirmSystemAlarmResponse = new OilCanAlarmResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(confirmSystemAlarmResponse);
	}
	
	/**
	 * 报警页面查询报警，默认查询15天之内的报警信息
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getOilCanAlarmConfirmDetail", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilCanAlarmConfirmDetail(GetOilCanAlarmDetailRequest request,HttpServletRequest httpServletRequest){
		
		GetOilCanAlarmDetailResponse oilCanAlarmDetailResponse = null;
		
		try{
			BaseResponse response = request.validate();
			
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			oilCanAlarmDetailResponse = gtsOilCanAlarmService.getOilCanConfirmAlarmDetail(request);
		}catch(Exception e){
			oilCanAlarmDetailResponse = new GetOilCanAlarmDetailResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilCanAlarmDetailResponse);
	}
	
	/**
	 * 报警页面查询报警，默认查询15天之内的报警信息
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "addOilProduct", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addOilProduct(AddOilProductRequest request,HttpServletRequest httpServletRequest){
		
		BaseResponse baseResponse = null;
		try{
			BaseResponse response = request.validate();
			
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			baseResponse = gtsOilProductService.addOilProduct(request, httpServletRequest);
		}catch(Exception e){
			baseResponse = new GetOilCanAlarmDetailResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
	/**
	 * 报警页面查询报警，默认查询15天之内的报警信息
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "updateOilProduct", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateOilProduct(UpdateOilProductRequest request,HttpServletRequest httpServletRequest){
		
		BaseResponse baseResponse = null;
		try{
			BaseResponse response = request.validate();
			
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			baseResponse = gtsOilProductService.updateOilProduct(request, httpServletRequest);
		}catch(Exception e){
			baseResponse = new GetOilCanAlarmDetailResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
	/**
	 * 获取所有的油料员工信息列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getOilProductDetail", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilProductDetail(GetOilProductDetailRequest request){
		OilProductDetailResponse oilProductDetailResponse;
		
		try{
			oilProductDetailResponse = gtsOilProductService.getOilProductDetail(request);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.getOilProductDetail异常",e);
			oilProductDetailResponse = new OilProductDetailResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilProductDetailResponse);
	}
	
	
	/**
	 * 报警页面查询报警，默认查询15天之内的报警信息
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "deleteOilProduct", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteOilProduct(DeleteEntityRequest request,HttpServletRequest httpServletRequest){
		
		BaseResponse baseResponse = null;
		try{
			BaseResponse response = request.validate();
			
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			baseResponse = gtsOilProductService.deleteOilProduct(request, httpServletRequest);
		}catch(Exception e){
			baseResponse = new GetOilCanAlarmDetailResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
	/**
	 * 通道设置页面-通道列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getComList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getComList(HttpServletRequest httpServletRequest){
		
		OilCanComResponse baseResponse = null;
		try{
			baseResponse = gtsOilComService.getOilCanComList();
		}catch(Exception e){
			baseResponse = new OilCanComResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
	/**
	 * 通道设置页面-通道列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "updateCom", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateCom(UpdateOilCanComRequest request,HttpServletRequest httpServletRequest){
		
		BaseResponse baseResponse = null;
		try{
			BaseResponse response = request.validate();
			
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			
			baseResponse = gtsOilComService.udpateOilCanCom(request);
		}catch(Exception e){
			baseResponse = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
	/**
	 * 通道设置页面-通道列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "deleteCom", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteCom(DeleteOilCanComRequest request,HttpServletRequest httpServletRequest){
		
		BaseResponse baseResponse = null;
		try{
			BaseResponse response = request.validate();
			
			if( response.getRetCode() != ResultType.success.getCode()){
				baseResponse = new BaseResponse(ResultType.paramFail);
				return JSON.toJSONString(response);
			}
			
			baseResponse = gtsOilComService.deleteOilCanCom(request);
		}catch(Exception e){
			baseResponse = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
	/**
	 * 通道设置页面-通道列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "addCom", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addCom(AddOilCanComRequest request,HttpServletRequest httpServletRequest){
		
		BaseResponse baseResponse = null;
		try{
			BaseResponse response = request.validate();
			
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			baseResponse = gtsOilComService.addOilCanCom(request);
		}catch(Exception e){
			baseResponse = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
}
