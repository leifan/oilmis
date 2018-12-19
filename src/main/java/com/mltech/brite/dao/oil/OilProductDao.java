package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.OilProduct;

@Repository
public class OilProductDao extends BaseDao<OilProduct>{
	
	@SuppressWarnings("unchecked")
	public List<OilProduct> findListByCond(OilProduct cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityByCond", cond);
	}

	@SuppressWarnings("unchecked")
	public List<OilProduct> updateEntityById(OilProduct cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<OilProduct> deleteEntityById(OilProduct cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}
	
}
