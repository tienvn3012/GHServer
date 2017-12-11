package vn.com.nct.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import vn.com.nct.model.UserInfo;

@Repository
public class UserInfoDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<UserInfo>{

	@Override
	public List<UserInfo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getOneById(int id) {
		return hibernateTemplate.get(UserInfo.class, id);
	}

	@Override
	public UserInfo getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<UserInfo> lis) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserInfo saveE(UserInfo e) {
		save(e);
		DetachedCriteria criteria = DetachedCriteria.forClass(UserInfo.class)
			    .setProjection( Projections.max("id") );
		List<Integer> lis = ((List<Integer>)hibernateTemplate.findByCriteria(criteria));
		
		return getOneById(lis.get(0).intValue());
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
	public UserInfo updateE(UserInfo e) {
		// TODO Auto-generated method stub
		return null;
	}

}
