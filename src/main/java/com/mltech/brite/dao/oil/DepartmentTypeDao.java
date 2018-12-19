package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.DepartmentType;

@Repository
public class DepartmentTypeDao extends BaseDao<DepartmentType>{
	
	@SuppressWarnings("unchecked")
	public List<DepartmentType> findListByCond(DepartmentType cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityByCond", cond);
	}

	@SuppressWarnings("unchecked")
	public List<DepartmentType> updateEntityById(DepartmentType cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<DepartmentType> deleteEntityById(DepartmentType cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}
	
}
