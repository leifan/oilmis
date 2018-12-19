package com.mltech.brite.dao.oil;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.OilStationStaff;

@Repository
public class OilStationStaffDao extends BaseDao<OilStationStaff>{
	
	@SuppressWarnings("unchecked")
	public List<OilStationStaff> findEntityListByCond(OilStationStaff cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityListByCond", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<OilStationStaff> updateEntityById(OilStationStaff cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	@SuppressWarnings("unchecked")
	public List<OilStationStaff> deleteEntityById(OilStationStaff cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}


}
