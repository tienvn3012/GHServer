package vn.com.nct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Roles;
import vn.com.nct.model.response.Page;

@Service
@Transactional(readOnly = false)
public class RoleServiceIplm implements ObjectService<Roles>{

	@Autowired
	private ObjectDaoSupport<Roles> roleDao;
	
	@Override
	public List<Roles> getAll() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return roleDao.getOneById(id);
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

	@Override
	public Roles saveOrUpdateE(Roles e) {
		// TODO Auto-generated method stub
		return roleDao.saveOrUpdateE(e);
	}

	@Override
	public void saveOrUpdateManyE(List<Roles> lis) {
		
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
	public Page<Roles> getPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
