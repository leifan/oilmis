package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.ShiftWork;
import com.mltech.brite.pagination.PaginationInfo;
import com.mltech.brite.pagination.PaginationList;

@Repository
public class ShiftWorkDao extends BaseDao<ShiftWork>{
	
	@SuppressWarnings("unchecked")
	public List<ShiftWork> findEntityListByCond(ShiftWork cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityListByCond", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<ShiftWork> updateEntityById(ShiftWork cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	@SuppressWarnings("unchecked")
	public List<ShiftWork> deleteEntityById(ShiftWork cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}
	
	public PaginationList<ShiftWork> selectPaginationList(ShiftWork cond,PaginationInfo paginationInfo){
		return super.selectPaginationList(this.getEntityClass().getSimpleName()+".findEntityByCond", cond,paginationInfo);
	}

}
