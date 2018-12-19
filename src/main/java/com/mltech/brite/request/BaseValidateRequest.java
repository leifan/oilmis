package com.mltech.brite.request;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.util.StringUtils;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.annotation.NotNull;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class BaseValidateRequest {
	
	public BaseResponse validate() throws Exception {
		
		BaseResponse baseResponse = null;
		//扫描pojo中的注解信息，并返回响应错误结果
		Field[] fileds = this.getClass().getDeclaredFields();
		
		if(fileds == null){
			baseResponse = new BaseResponse(ResultType.success);
			return baseResponse;
		}
		
		for(Field field : fileds){
			
			Annotation[] annotions = field.getAnnotations();
			
			if(annotions != null){
				
				for(int i=0;i<annotions.length;i++){
					
					if( annotions[i] instanceof NotBlank ){
							Method method = (Method) this.getClass().getDeclaredMethod("get"+getMethodName(field.getName()));
							String value = (String)method.invoke(this);
							
							if(StringUtils.isEmpty(value)){
								baseResponse = new BaseResponse(ResultType.paramFail);
								baseResponse.setRetDesc(field.getName()+"不能为空");
								return baseResponse;
							}
						
					}else if( annotions[i] instanceof NotNull ){
						if( this.getClass().getField(field.getName()) == null){
							
							Method method = (Method) this.getClass().getDeclaredMethod("get"+getMethodName(field.getName()));
							String value = (String)method.invoke(this);
							
							if(StringUtils.isEmpty(value)){
								baseResponse = new BaseResponse(ResultType.paramFail);
								baseResponse.setRetDesc(field.getName()+"不能为空");
								return baseResponse;
							}
						}
						
					}
				}
				
			}
			
		}
		
		baseResponse = new BaseResponse(ResultType.success);
		return baseResponse;
		
	}
	
	private static String getMethodName(String fildeName) throws Exception{  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0] - 'a' + 'A');  
        return new String(items);  
    }  
	
	

}
