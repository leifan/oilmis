package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.OilCanFeeding;
import com.mltech.brite.pagination.PaginationInfo;
import com.mltech.brite.pagination.PaginationList;

@Repository
public class OilCanFeedingDao extends BaseDao<OilCanFeeding>{
	
	@SuppressWarnings("unchecked")
	public List<OilCanFeeding> findEntityListByCond(OilCanFeeding cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityListByCond", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<OilCanFeeding> updateEntityById(OilCanFeeding cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	@SuppressWarnings("unchecked")
	public List<OilCanFeeding> deleteEntityById(OilCanFeeding cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}
	
	public PaginationList<OilCanFeeding> selectPaginationList(OilCanFeeding cond,PaginationInfo paginationInfo){
		return super.selectPaginationList(this.getEntityClass().getSimpleName()+".findEntityByCond", cond,paginationInfo);
	}
	
	@SuppressWarnings("unchecked")
	public List<OilCanFeeding> recentTop10(){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".recentTop10");
	}

}
