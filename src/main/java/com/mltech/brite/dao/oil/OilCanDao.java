package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.OilCan;
import com.mltech.brite.pagination.PaginationInfo;

@Repository
public class OilCanDao extends BaseDao<OilCan>{

	@SuppressWarnings("unchecked")
	public List<OilCan> findEntityListByCond(OilCan cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityListByCond", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<OilCan> updateEntityById(OilCan cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	@SuppressWarnings("unchecked")
	public List<OilCan> deleteEntityById(OilCan cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}
	
	public List<OilCan> selectPaginationList(OilCan cond,PaginationInfo paginationInfo){
		return super.selectPaginationList(this.getEntityClass().getSimpleName()+".findEntityListByCond", cond,paginationInfo);
	}
	
}
