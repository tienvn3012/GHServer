package vn.com.nct.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import vn.com.nct.base.BaseMethods;
import vn.com.nct.model.Users;

public class UserDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<Users>{
	
	private BaseMethods base = new BaseMethods();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class,"users");
		criteria.add(Restrictions.eq("users.deleted",0));
		return (List<Users>)hibernateTemplate.findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllBy(String... condition) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class,"users");
		criteria.createAlias("users.role", "role")
		.createAlias("users.info", "userinfo");
		
		criteria = base.setCondition(criteria, condition);
		
		return (List<Users>)hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Users getOneById(int id) {
		return hibernateTemplate.get(Users.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users getOneByCondition(String... condition) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class,"users");
		criteria.createAlias("users.role", "role")
		.createAlias("users.info", "userinfo");
		
		criteria = base.setCondition(criteria, condition);
		
		return ((List<Users>)hibernateTemplate.findByCriteria(criteria)).get(0);
	}

	@Override
	public void deleteE(int id) {
		Users user = getOneById(id);
		user.setDeleted(1);
		saveOrUpdateE(user);
	}

	@Override
	public void saveOrUpdateE(Users e) {
		save(e);
	}

	@Override
	public int countAll() {
		Criteria criteria = getSession().getCurrentSession().createCriteria(Users.class);
		Integer count = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		return count;
	}

	@Override
	public int countBy(String... condition) {
		Criteria criteria = getSession().getCurrentSession().createCriteria(Users.class,"users");
		criteria.createAlias("users.role", "role")
		.createAlias("users.info", "userinfo");
		
		criteria = base.setConditionCriteria(criteria, condition);
		Integer count = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getLimit(int index, int offset) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class,"users");
		criteria.add(Restrictions.eq("users.deleted",0));
		return (List<Users>)hibernateTemplate.findByCriteria(criteria,index,offset);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getLimitBy(int index, int offset, String... condition) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class,"users");
		criteria.createAlias("users.role", "role")
		.createAlias("users.info", "userinfo");
		
		criteria = base.setCondition(criteria, condition);
		
		return (List<Users>)hibernateTemplate.findByCriteria(criteria,index,offset);
	}

}
