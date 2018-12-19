package com.mltech.brite.dao.oil.gts;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.OilCanCom;

@Repository
public class OilCanComDao extends BaseDao<OilCanCom>{

	@SuppressWarnings("unchecked")
	public List<OilCanCom> findEntityListByCond(OilCanCom cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName() + ".findEntityListByCond",cond);
	}
	
	public void updateEntityByCond(OilCanCom cond){
		this.getSqlSession().update(this.getEntityClass().getSimpleName() + ".updateEntityByCond",cond);
	}
	
	public void deleteEntityByCond(OilCanCom cond){
		this.getSqlSession().delete(this.getEntityClass().getSimpleName() + ".deleteEntityByCond",cond);
	}
	
	public void deleteEntityByChannelId(OilCanCom cond){
		this.getSqlSession().delete(this.getEntityClass().getSimpleName() + ".deleteEntityByChannelId",cond);
	}
	
}
