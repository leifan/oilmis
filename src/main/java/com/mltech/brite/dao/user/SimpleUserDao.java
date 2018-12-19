package com.mltech.brite.dao.user;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.model.SimpleUserModel;
import com.mltech.brite.dao.BaseDao;

@Repository
public class SimpleUserDao extends BaseDao<SimpleUserModel>{
	
	@SuppressWarnings("unchecked")
	public List<SimpleUserModel> findEntityByCond(SimpleUserModel model){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityByCond", model);
	}
	@SuppressWarnings("unchecked")
	public List<SimpleUserModel> loginValidate(SimpleUserModel model){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".loginValidate", model);
	}

}
