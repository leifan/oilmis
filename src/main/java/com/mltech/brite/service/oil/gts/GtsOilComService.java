package com.mltech.brite.service.oil.gts;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mltech.brite.constant.ComPortEnum;
import com.mltech.brite.dao.oil.gts.OilCanComDao;
import com.mltech.brite.model.OilCanCom;
import com.mltech.brite.request.oil.gts.AddOilCanComRequest;
import com.mltech.brite.request.oil.gts.DeleteOilCanComRequest;
import com.mltech.brite.request.oil.gts.UpdateOilCanComRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.oil.gts.OilCanComResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.util.DateUtil;
import com.mltech.brite.util.FileUtils;

@Service
public class GtsOilComService {
	
	@Resource
	OilCanComDao oilCanComDao;
	
	public OilCanComResponse getOilCanComList(){
		
		OilCanComResponse response = new OilCanComResponse(ResultType.success);
		List<OilCanCom> list = oilCanComDao.findEntityListByCond(null);
		response.setList(list);
		
		String portListStr = FileUtils.configProperties.getProperties("portList");
		response.setPortList(JSON.parseArray(portListStr,String.class));
		
		String protocolList = FileUtils.configProperties.getProperties("protocolList");
		response.setProtocolList(JSON.parseArray(protocolList,String.class));
		
		response.getPortList();
		
		return response;
	}
	
	public BaseResponse udpateOilCanCom(UpdateOilCanComRequest request){
		
		BaseResponse response = new BaseResponse(ResultType.success);
		
		OilCanCom cond = new OilCanCom();
		cond.setId(request.getId());
		cond.setChannelId(request.getChannelId());
		cond.setPort(request.getPort());
		cond.setProtocol(request.getProtocol());
		cond.setComPeriod(request.getComPeriod());
		cond.setUpdater("www");
		cond.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		
		oilCanComDao.updateEntityByCond(cond);
		return response;
	}
	
	public BaseResponse addOilCanCom(AddOilCanComRequest request){
		
		BaseResponse response = new BaseResponse(ResultType.success);
		
		OilCanCom cond = new OilCanCom();
		cond.setChannelId(request.getChannelId());
		
		List<OilCanCom> existedList = oilCanComDao.findEntityListByCond(cond);
		if(existedList != null && existedList.size() > 0){
			return response = new BaseResponse(ResultType.repeat);
		}
		
		cond.setPort(request.getPort());
		cond.setProtocol(request.getProtocol());
		cond.setComPeriod(request.getComPeriod());
		cond.setCreator("www");
		cond.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		cond.setUpdater("www");
		cond.setUpdateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		
		oilCanComDao.addEntity(cond);
		return response;
	}
	
	public BaseResponse deleteOilCanCom(DeleteOilCanComRequest request){
		
		BaseResponse response = new BaseResponse(ResultType.success);
		
		OilCanCom cond = new OilCanCom();
		cond.setChannelId(request.getChannelId());
		
		oilCanComDao.deleteEntityByChannelId(cond);
		return response;
	}

}
