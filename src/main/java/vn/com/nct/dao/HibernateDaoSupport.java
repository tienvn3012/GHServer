package vn.com.nct.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class HibernateDaoSupport {
	@Autowired
	protected HibernateTemplate hibernateTemplate;

	public SessionFactory getSession() {
		return hibernateTemplate.getSessionFactory();
	}
	
	public void save(Object entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	public void delete(Object entity) {
		hibernateTemplate.delete(entity);
	}
}
