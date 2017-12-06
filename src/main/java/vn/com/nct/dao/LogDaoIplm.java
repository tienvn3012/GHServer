package vn.com.nct.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import vn.com.nct.model.SystemLogActivity;

public class LogDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<SystemLogActivity>{

	@Override
	public List<SystemLogActivity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemLogActivity> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemLogActivity> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemLogActivity> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemLogActivity getOneById(int id) {
		return hibernateTemplate.get(SystemLogActivity.class, id);
	}

	@Override
	public SystemLogActivity getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<SystemLogActivity> lis) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public SystemLogActivity saveOrUpdateE(SystemLogActivity e) {
		this.save(e);
		DetachedCriteria criteria = DetachedCriteria.forClass(SystemLogActivity.class)
			    .setProjection( Projections.max("id") );
		Integer i = ((List<Integer>)hibernateTemplate.findByCriteria(criteria)).get(0);
		return getOneById(i.intValue());
	}

	@Override
	public void saveOrUpdateManyE(List<SystemLogActivity> lis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countBy(String... condition) {
		// TODO Auto-generated method stub
		return 0;
	}

}
