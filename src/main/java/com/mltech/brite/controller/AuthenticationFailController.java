package com.mltech.brite.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mltech.brite.constant.Constant;

@RequestMapping("/user")
@Controller
public class AuthenticationFailController {

	
	/**
	 * 对验证结果进行进一步处理
	 * @param errorId
	 * @return
	 */
	@RequestMapping(value = "auth_fail",produces="text/json;charset=UTF-8")
	@ResponseBody
	public void authtificationFail(int errorId,HttpServletRequest request,HttpServletResponse response){
		
//		BaseResultInfo resultInfo = new BaseResultInfo(authHandlerService.processAuthFail(errorId));
		try {
			response.sendRedirect(Constant.redirectUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return JSON.toJSONString(resultInfo);
		
	}
	
}
