package vn.com.nct.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.nct.base.BaseMethods;
import vn.com.nct.model.Users;

@Repository
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
		criteria.add(Restrictions.eq("users.deleted",0));
		
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
		criteria.add(Restrictions.eq("users.deleted",0));
		
		criteria = base.setCondition(criteria, condition);
		
		return ((List<Users>)hibernateTemplate.findByCriteria(criteria)).get(0);
	}

	@Override
	public void deleteE(int id) {
		Users user = getOneById(id);
		user.setDeleted(1);
		saveE(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users saveE(Users e) {
		save(e);
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class)
			    .setProjection( Projections.max("id") );
		Integer i = ((List<Integer>)hibernateTemplate.findByCriteria(criteria)).get(0);
		return getOneById(i.intValue());
	}

	@Override
	public int countAll() {
		Criteria criteria = getSession().getCurrentSession().createCriteria(Users.class,"users");
		criteria.add(Restrictions.eq("users.deleted",0));
		
		Integer count = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		return count;
	}

	@Override
	public int countBy(String... condition) {
		Criteria criteria = getSession().getCurrentSession().createCriteria(Users.class,"users");
		criteria.createAlias("users.role", "role")
		.createAlias("users.info", "userinfo");
		criteria.add(Restrictions.eq("users.deleted",0));
		
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
		criteria.add(Restrictions.eq("users.deleted",0));
		
		criteria = base.setCondition(criteria, condition);
		
		return (List<Users>)hibernateTemplate.findByCriteria(criteria,index,offset);
	}

	@Override
	public void deleteManyE(List<Users> lis) {
		for (int i = 0; i < lis.size(); i++) {
			lis.get(i).setDeleted(1);
			updateE(lis.get(i));
		}
	}

	@Override
	public Users updateE(Users e) {
		int id = e.getId();
		
		this.save(e);
		
		return this.getOneById(id);
	}

	

}
