package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.OilType;

@Repository
public class OilTypeDao extends BaseDao<OilType>{
	
	@SuppressWarnings("unchecked")
	public List<OilType> findListByCond(OilType cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityByCond", cond);
	}

	@SuppressWarnings("unchecked")
	public List<OilType> updateEntityById(OilType cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<OilType> deleteEntityById(OilType cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}
	
}
