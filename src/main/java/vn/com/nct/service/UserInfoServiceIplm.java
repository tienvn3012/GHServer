package vn.com.nct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.UserInfo;
import vn.com.nct.model.response.Page;

@Service
@Transactional(readOnly = false)
public class UserInfoServiceIplm implements ObjectService<UserInfo>{

	@Autowired
	private ObjectDaoSupport<UserInfo> userInfoDao;
	
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
		// TODO Auto-generated method stub
		return userInfoDao.getOneById(id);
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

	@Override
	public UserInfo saveOrUpdateE(UserInfo e) {
		// TODO Auto-generated method stub
		return userInfoDao.saveOrUpdateE(e);
	}

	@Override
	public void saveOrUpdateManyE(List<UserInfo> lis) {
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

	@Override
	public Page<UserInfo> getPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
