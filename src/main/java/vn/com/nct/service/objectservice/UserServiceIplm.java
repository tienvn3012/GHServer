package vn.com.nct.service.objectservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Users;
import vn.com.nct.model.response.Page;

@Service
@Transactional(readOnly = false)
public class UserServiceIplm implements ObjectService<Users>{

	@Autowired
	private ObjectDaoSupport<Users> userDao;
	
	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getOneById(int id) {
		// TODO Auto-generated method stub
		return userDao.getOneById(id);
	}

	@Override
	public Users getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<Users> lis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users saveOrUpdateE(Users e) {
		// TODO Auto-generated method stub
		return userDao.saveOrUpdateE(e);
	}

	@Override
	public void saveOrUpdateManyE(List<Users> lis) {
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
	public Page<Users> getPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
