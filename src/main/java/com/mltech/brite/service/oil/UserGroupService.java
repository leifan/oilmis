package com.mltech.brite.service.oil;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mltech.brite.dao.oil.UserGroupDao;
import com.mltech.brite.model.UserGroup;
import com.mltech.brite.request.oil.GetUserGroupListRequest;
import com.mltech.brite.response.oil.GetUserGroupListResponse;
import com.mltech.brite.response.user.ResultType;

@Service
public class UserGroupService {
	
	@Resource
	UserGroupDao userGroupDao;
	
	public GetUserGroupListResponse getUserGroupList(GetUserGroupListRequest pojo){
		
		GetUserGroupListResponse response = new GetUserGroupListResponse(ResultType.success);
		List<UserGroup> list = userGroupDao.findListByCond(null);
		response.setList(list);
		return response;
	}

}
