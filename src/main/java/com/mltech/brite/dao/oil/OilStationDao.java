package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.OilStation;

@Repository
public class OilStationDao extends BaseDao<OilStation>{
	@SuppressWarnings("unchecked")
	public List<OilStation> findEntityListByCond(OilStation cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityListByCond", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<OilStation> updateEntityById(OilStation cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	@SuppressWarnings("unchecked")
	public List<OilStation> deleteEntityById(OilStation cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}

}
