package com.mltech.brite.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mltech.brite.pagination.PaginationInfo;
import com.mltech.brite.request.oil.AddDepartmentTypeRequest;
import com.mltech.brite.request.oil.AddDistrictTypeRequest;
import com.mltech.brite.request.oil.AddOilCanFeedingRequest;
import com.mltech.brite.request.oil.AddOilCanRequest;
import com.mltech.brite.request.oil.AddOilProductRequest;
import com.mltech.brite.request.oil.AddOilStationRequest;
import com.mltech.brite.request.oil.AddOilStationStaffRequest;
import com.mltech.brite.request.oil.AddOilTypeRequest;
import com.mltech.brite.request.oil.AddShiftWorkRequest;
import com.mltech.brite.request.oil.DeleteDepartmentTypeRequest;
import com.mltech.brite.request.oil.DeleteDistrictTypeRequest;
import com.mltech.brite.request.oil.DeleteEntityRequest;
import com.mltech.brite.request.oil.DeleteOilCanRequest;
import com.mltech.brite.request.oil.DeleteOilStationRequest;
import com.mltech.brite.request.oil.DeleteOilStationStaffRequest;
import com.mltech.brite.request.oil.DeleteOilTypeRequest;
import com.mltech.brite.request.oil.GetOilCanDetailRequest;
import com.mltech.brite.request.oil.GetOilCanFeedingDetailRequest;
import com.mltech.brite.request.oil.GetShitWorkRequest;
import com.mltech.brite.request.oil.GetUserGroupListRequest;
import com.mltech.brite.request.oil.OilCanFeedingListRequest;
import com.mltech.brite.request.oil.OilCanListRequest;
import com.mltech.brite.request.oil.OilStationListRequest;
import com.mltech.brite.request.oil.OilStationStaffListRequest;
import com.mltech.brite.request.oil.UpdateDepartmentTypeRequest;
import com.mltech.brite.request.oil.UpdateDistrictTypeRequest;
import com.mltech.brite.request.oil.UpdateOilCanFeedingRequest;
import com.mltech.brite.request.oil.UpdateOilProductRequest;
import com.mltech.brite.request.oil.UpdateOilStationRequest;
import com.mltech.brite.request.oil.UpdateOilStationStaffRequest;
import com.mltech.brite.request.oil.UpdateOilTypeRequest;
import com.mltech.brite.request.oil.gts.GetOilProductDetailRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.DepartmentListResponse;
import com.mltech.brite.response.oil.DistrictListResponse;
import com.mltech.brite.response.oil.GetOilCanDetailResponse;
import com.mltech.brite.response.oil.GetShiftWorkListResult;
import com.mltech.brite.response.oil.GetUserGroupListResponse;
import com.mltech.brite.response.oil.OilCanFeedingDetailResponse;
import com.mltech.brite.response.oil.OilCanFeedingListResponse;
import com.mltech.brite.response.oil.OilCanFeedingTop10ListResponse;
import com.mltech.brite.response.oil.OilCanListResponse;
import com.mltech.brite.response.oil.OilProductListResponse;
import com.mltech.brite.response.oil.OilStationListResponse;
import com.mltech.brite.response.oil.OilStationStaffListResponse;
import com.mltech.brite.response.oil.OilTypeListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.service.oil.DepartmentTypeService;
import com.mltech.brite.service.oil.DistrictTypeService;
import com.mltech.brite.service.oil.OilCanFeedingService;
import com.mltech.brite.service.oil.OilCanService;
import com.mltech.brite.service.oil.OilProductService;
import com.mltech.brite.service.oil.OilStationService;
import com.mltech.brite.service.oil.OilStationStaffService;
import com.mltech.brite.service.oil.OilTypeService;
import com.mltech.brite.service.oil.ShiftWorkService;
import com.mltech.brite.service.oil.UserGroupService;
import com.mltech.brite.util.LoggerUtil;

@Controller
@RequestMapping("/user/oil")
public class OilManngerController {
	

	@Resource
	OilTypeService oilTypeService;
	
	@Resource
	OilProductService oilProductService;
	
	@Resource
	OilCanService oilCanService;
	
	@Resource
	OilStationService oilStationService;
	
	@Resource
	OilStationStaffService oilStationStaffService;
	
	@Resource
	DistrictTypeService districtTypeService;
	
	@Resource
	DepartmentTypeService departmentTypeService;
	
	@Resource
	UserGroupService userGroupService;
	
	@Resource
	OilCanFeedingService oilCanFeedingService;
	
	@Resource
	ShiftWorkService shiftWorkService;
	
	
	/**------------------------------------油料管理-----------------------------------*/	
	/**
	 * 增加油料类型枚举值
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "addOilType", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addOilType(AddOilTypeRequest pojo,HttpServletRequest httpServletRequest) throws Exception{
		
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilTypeService.addOilType(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.addOilType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 更新油料类型枚举值
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "updateOilType", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateOilType(UpdateOilTypeRequest pojo,HttpServletRequest httpServletRequest) throws Exception{
		
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilTypeService.updateOilType(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.updateOilType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 更新油料类型枚举值
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "deleteOilType", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteOilType(DeleteOilTypeRequest pojo,HttpServletRequest httpServletRequest) throws Exception{
		
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilTypeService.deleteOilType(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.deleteOilType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**------------------------------------油品管理-----------------------------------*/
	
	/**
	 * 增加油品
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "addOilProduct", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addOilProduct(AddOilProductRequest pojo,HttpServletRequest httpServletRequest) throws Exception{
		
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilProductService.addOilProduct(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.addOilType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 更新油品
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "updateOilProduct", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateOilProduct(UpdateOilProductRequest pojo,HttpServletRequest httpServletRequest) throws Exception{
		
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilProductService.updateOilProduct(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.updateOilType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 更新油品
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "deleteOilProduct", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteOilProduct(DeleteEntityRequest pojo,HttpServletRequest httpServletRequest) throws Exception{
		
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilProductService.deleteOilProduct(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.deleteOilType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**------------------------------------油罐管理-----------------------------------*/
	/**油罐管理*/
	@RequestMapping(value = "addOilCan", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addOilStation(AddOilCanRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilCanService.addOilCan(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.addOilCan异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	@RequestMapping(value = "updateOilCan", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateOilCan(AddOilCanRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilCanService.updateOilCan(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.updateOilCan异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	@RequestMapping(value = "deleteOilCan", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteOilCan(DeleteOilCanRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilCanService.deleteEntityById(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.deleteOilCan异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**油站管理*/
	/**
	 * 增加一条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "addOilStation", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addOilStation(AddOilStationRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilStationService.addOilStation(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.addOilStation异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 更新某条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "updateOilStation", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateOilStation(UpdateOilStationRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilStationService.updateOilStation(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.updateOilStation异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 删除某一条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "deleteOilStation", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteOilStation(DeleteOilStationRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilStationService.deleteOilStation(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.deleteOilStation异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**油站员工管理*/
	/**
	 * 增加一条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "addOilStationStaff", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addOilStationStaff(AddOilStationStaffRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilStationStaffService.addOilStationStaff(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.addOilStationStaff异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 更新某条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "updateOilStationStaff", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateOilStationStaff(UpdateOilStationStaffRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilStationStaffService.updateOilStationStaff(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.updateOilStationStaff异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 删除某一条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "deleteOilStationStaff", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteOilStationStaff(DeleteOilStationStaffRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = oilStationStaffService.deleteOilStationStaff(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.deleteOilStationStaff异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}

	/**油站员工管理*/
	/**
	 * 增加一条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "addDistrictType", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addDistrictType(AddDistrictTypeRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = districtTypeService.addDistrictType(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.addDistrictType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 更新某条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "updateDistrictType", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateDistrictType(UpdateDistrictTypeRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = districtTypeService.updateDistrictType(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.updateDistrictType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 删除某一条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "deleteDistrictType", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteDistrictType(DeleteDistrictTypeRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = districtTypeService.deleteDistrictType(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.deleteDistrictType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	
	/**油站员工管理*/
	/**
	 * 增加一条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "addDepartmentType", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addDepartmentType(AddDepartmentTypeRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = departmentTypeService.addDepartmentType(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.addDepartmentType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 更新某条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "updateDepartmentType", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateDepartmentType(UpdateDepartmentTypeRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = departmentTypeService.updateDepartmentType(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.updateDepartmentType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 删除某一条油站记录
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "deleteDepartmentType", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteDepartmentType(DeleteDepartmentTypeRequest pojo,HttpServletRequest httpServletRequest){
		BaseResponse respone;
		
		try{
			respone = pojo.validate();
			if( respone.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(respone);
			}
			respone = departmentTypeService.deleteDepartmentType(pojo, httpServletRequest);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.deleteDepartmentType异常",e);
			respone = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(respone);
	}
	
	/**
	 * 获取某个站点的油罐列表，查询油罐列表信息均通过此接口可以获取，群罐列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getOilCanList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilCanList(OilCanListRequest pojo){
		OilCanListResponse oilCanListResponse;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			oilCanListResponse = oilCanService.getOilCanList(pojo);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.oilCanList异常",e);
			oilCanListResponse = new OilCanListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilCanListResponse);
	}
	
	/**
	 * 获取所有的油站列表，查询油罐列表信息均通过此接口可以获取
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getOilStationList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilStationList(OilStationListRequest pojo){
		OilStationListResponse oilCanListResponse;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			oilCanListResponse = oilStationService.getOilStationList(pojo);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.getOilStationList异常",e);
			oilCanListResponse = new OilStationListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilCanListResponse);
	}
	
	/**
	 * 获取所有的区域列表，查询油罐列表信息均通过此接口可以获取
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getDistrictList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String districtList(){
		DistrictListResponse oilCanListResponse;
		
		try{
			oilCanListResponse = districtTypeService.getDistrictList();
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.getDistrictList异常",e);
			oilCanListResponse = new DistrictListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilCanListResponse);
	}
	
	/**
	 * 获取所有的油站员工信息列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getOilStationStaffList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilStationStaffList(OilStationStaffListRequest pojo){
		OilStationStaffListResponse oilStationStaffListResponse;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			oilStationStaffListResponse = oilStationStaffService.getOilStationStaffList(pojo);
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.getOilStationStaffList异常",e);
			oilStationStaffListResponse = new OilStationStaffListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilStationStaffListResponse);
	}
	
	/**
	 * 获取所有的油料员工信息列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getOilTypeList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilTypeList(){
		OilTypeListResponse oilTypeListResponse;
		
		try{
			oilTypeListResponse = oilTypeService.getOilTypeList();
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.getOilTypeList异常",e);
			oilTypeListResponse = new OilTypeListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilTypeListResponse);
	}
	
	/**
	 * 获取所有的油料员工信息列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getDepartmentTypeList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getDepartmentTypeList(){
		DepartmentListResponse departmentListResponse;
		
		try{
			departmentListResponse = departmentTypeService.getDepartmentList();
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.getOilTypeList异常",e);
			departmentListResponse = new DepartmentListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(departmentListResponse);
	}
	
	/**
	 * 获取所有的油料员工信息列表
	 * @param pojo
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "getOilProductList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilProductList(){
		OilProductListResponse oilProductListResponse;
		
		try{
			oilProductListResponse = oilProductService.getOilProductList();
			
		}catch(Exception e){
			
			LoggerUtil.error("OilManngerController.getOilProductList异常",e);
			oilProductListResponse = new OilProductListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilProductListResponse);
	}
	
	/**------------------------------------单罐油罐详情信息-----------------------------------*/
	@RequestMapping(value = "getOilCanDetail", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilCanDetail(GetOilCanDetailRequest pojo,HttpServletRequest request){
		
		GetOilCanDetailResponse getOilCanDetailResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			getOilCanDetailResponse = oilCanService.getOilCanDetail(pojo);
			
		}catch(Exception e){
			getOilCanDetailResponse = new GetOilCanDetailResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(getOilCanDetailResponse);
		
	}
	
	@RequestMapping(value = "getUserGroupList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getUserGroupList(GetUserGroupListRequest pojo){
		
		GetUserGroupListResponse getUserGroupListResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			getUserGroupListResponse = userGroupService.getUserGroupList(pojo);
			
		}catch(Exception e){
			getUserGroupListResponse = new GetUserGroupListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(getUserGroupListResponse);
		
	}
	
	/**----进油统计报告--------*/
	@RequestMapping(value = "getOilCanFeedingList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilCanFeedingList(OilCanFeedingListRequest pojo){
		
		OilCanFeedingListResponse oilCanFeedingListResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			oilCanFeedingListResponse = oilCanFeedingService.getOilCanFeedingList(pojo,null);
		}catch(Exception e){
			oilCanFeedingListResponse = new OilCanFeedingListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilCanFeedingListResponse);
	}
	
	@RequestMapping(value = "addOilCanFeeding", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addOilCanFeeding(AddOilCanFeedingRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse baseResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			baseResponse = oilCanFeedingService.addOilCanFeeding(pojo, httpServletRequest);
		}catch(Exception e){
			baseResponse = new OilCanFeedingListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
	@RequestMapping(value = "updateOilCanFeeding", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateOilCanFeeding(UpdateOilCanFeedingRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse baseResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			baseResponse = oilCanFeedingService.updateOilCanFeeding(pojo, httpServletRequest);
		}catch(Exception e){
			baseResponse = new OilCanFeedingListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
	@RequestMapping(value = "deleteOilCanFeeding", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteOilCanFeeding(DeleteEntityRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse baseResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			baseResponse = oilCanFeedingService.deleteEntityById(pojo, httpServletRequest);
		}catch(Exception e){
			baseResponse = new OilCanFeedingListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(baseResponse);
	}
	
	@RequestMapping(value = "getOilCanFeedingDetail", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOilCanFeedingDetail(GetOilCanFeedingDetailRequest pojo,HttpServletRequest httpServletRequest){
		
		OilCanFeedingDetailResponse oilCanFeedingDetailResponse = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			oilCanFeedingDetailResponse = oilCanFeedingService.getOilCanFeedingDetail(pojo);
		}catch(Exception e){
			oilCanFeedingDetailResponse = new OilCanFeedingDetailResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(oilCanFeedingDetailResponse);
	}
	
	@RequestMapping(value = "addShiftWork", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addShiftWork(AddShiftWorkRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse addShiftWorkResult = null;
		
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			addShiftWorkResult = shiftWorkService.addShiftWork(pojo, httpServletRequest);
		}catch(Exception e){
			addShiftWorkResult = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(addShiftWorkResult);
	}
	
	@RequestMapping(value = "getShiftWorkList", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getShiftWorkList(GetShitWorkRequest pojo,HttpServletRequest httpServletRequest,PaginationInfo paginationInfo){
		
		GetShiftWorkListResult shiftWorkListResult = null;
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			shiftWorkListResult = shiftWorkService.getShiftWorkList(pojo, paginationInfo);
		}catch(Exception e){
			shiftWorkListResult = new GetShiftWorkListResult(ResultType.fail);
		}
		
		return JSON.toJSONString(shiftWorkListResult);
	}
	
	@RequestMapping(value = "deleteShiftWork", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteShiftWork(DeleteEntityRequest pojo,HttpServletRequest httpServletRequest){
		
		BaseResponse deleteShiftWorkResult = null;
		try{
			BaseResponse response = pojo.validate();
			if( response.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(response);
			}
			deleteShiftWorkResult = shiftWorkService.deleteEntityById(pojo, httpServletRequest);
		}catch(Exception e){
			deleteShiftWorkResult = new BaseResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(deleteShiftWorkResult);
	}
	
	@RequestMapping(value = "test", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String test(){
		
		try{
			throw new Exception("thisisatest");
		}catch(Exception e){
			LoggerUtil.error("test", e);
		}
		
		return "success";
	}
	
	@RequestMapping(value = "getRecent10InputRecord", method = { RequestMethod.GET,RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getRecent10InputRecord(HttpServletRequest httpServletRequest){
		
		OilCanFeedingTop10ListResponse top10Result = null;
		try{
			top10Result = oilCanFeedingService.getOilCanFeedingTop10();
		}catch(Exception e){
			top10Result = new OilCanFeedingTop10ListResponse(ResultType.fail);
		}
		
		return JSON.toJSONString(top10Result);
	}
	
}
