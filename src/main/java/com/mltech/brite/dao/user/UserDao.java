package com.mltech.brite.dao.user;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.model.UserModel;
import com.mltech.brite.dao.BaseDao;

@Repository
public class UserDao extends BaseDao<UserModel>{
	
	@SuppressWarnings("unchecked")
	public List<UserModel> findEntityByCond(UserModel model){
		
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityByCond", model);
		
	}
	@SuppressWarnings("unchecked")
	public List<UserModel> loginValidate(UserModel model){
		
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".loginValidate", model);
		
	}

}
