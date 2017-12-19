package vn.com.nct.service.objectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Roles;

import vn.com.nct.model.response.Page;
import vn.com.nct.model.response.RoleResponse;

@Service("roleService")
@Transactional(readOnly = false)
public class RoleServiceIplm implements ObjectService<Roles,RoleResponse>{

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
	public Roles saveE(Roles e) {
		// TODO Auto-generated method stub
		return roleDao.saveE(e);
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
	public Page<RoleResponse> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roles updateE(Roles e) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<RoleResponse> parseAll(List<Roles> lis) {
		List<RoleResponse> lisResponse = new ArrayList<>();
		
		for (int i = 0; i < lis.size(); i++) {
			lisResponse.add(this.parseResponse(lis.get(i)));
		}
		
		return lisResponse;
	}

	@Override
	public RoleResponse parseResponse(Roles role) {
		RoleResponse response = new RoleResponse();
		
		response.setId(role.getId());
		response.setRole(role.getRole());
		
		return response;
	}
	
}
