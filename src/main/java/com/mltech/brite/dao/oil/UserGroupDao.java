package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.UserGroup;

@Repository
public class UserGroupDao extends BaseDao<UserGroup>{
	
	@SuppressWarnings("unchecked")
	public List<UserGroup> findListByCond(UserGroup cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityByCond", cond);
	}

}
