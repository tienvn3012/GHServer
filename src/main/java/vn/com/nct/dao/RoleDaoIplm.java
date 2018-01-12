package vn.com.nct.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import vn.com.nct.model.Roles;

@Repository
public class RoleDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<Roles>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Roles.class);
		return (List<Roles>)hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<Roles> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roles> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roles> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roles getOneById(int id) {
		return hibernateTemplate.get(Roles.class, id);
	}

	@Override
	public Roles getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<Roles> lis) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Roles saveE(Roles e) {
		save(e);
		DetachedCriteria criteria = DetachedCriteria.forClass(Roles.class)
			    .setProjection( Projections.max("id") );
		Integer i = ((List<Integer>)hibernateTemplate.findByCriteria(criteria)).get(0);
		return getOneById(i.intValue());
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

	@Override
	public Roles updateE(Roles e) {
		// TODO Auto-generated method stub
		return null;
	}

}
