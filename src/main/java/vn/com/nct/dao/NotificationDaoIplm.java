package vn.com.nct.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.com.nct.model.Notifications;

@Repository
public class NotificationDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<Notifications>{

	@Override
	public List<Notifications> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notifications> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notifications> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notifications> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notifications getOneById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Notifications.class, id);
	}

	@Override
	public Notifications getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<Notifications> lis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notifications saveE(Notifications e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notifications updateE(Notifications e) {
		// TODO Auto-generated method stub
		return null;
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
