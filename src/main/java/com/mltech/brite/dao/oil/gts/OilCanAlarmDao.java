package com.mltech.brite.dao.oil.gts;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.mltech.brite.dao.BaseDao;
import com.mltech.brite.model.GtsOilCanAlarm;

@Repository
public class OilCanAlarmDao extends BaseDao<GtsOilCanAlarm>{
	
	@SuppressWarnings("unchecked")
	public List<GtsOilCanAlarm> findEntityByCond(GtsOilCanAlarm cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".findEntityByCond", cond);
	}

	public void updateEntityById(GtsOilCanAlarm cond){
		this.getSqlSession().update(this.getEntityClass().getSimpleName()+".updateEntityById", cond);
	}
	
	@SuppressWarnings("unchecked")
	public List<GtsOilCanAlarm> deleteEntityById(GtsOilCanAlarm cond){
		return this.getSqlSession().selectList(this.getEntityClass().getSimpleName()+".deleteEntityById", cond);
	}
	
}