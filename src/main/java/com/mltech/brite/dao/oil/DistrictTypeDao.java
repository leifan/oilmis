package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.DistrictType;

@Repository
public class DistrictTypeDao extends BaseDao<DistrictType>{
	
	@SuppressWarnings("unchecked")
	public List<DistrictType> findListByCond(DistrictType cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityByCond", cond);
	}

	@SuppressWarnings("unchecked")
	public List<DistrictType> updateEntityById(DistrictType cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<DistrictType> deleteEntityById(DistrictType cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}
	
}
