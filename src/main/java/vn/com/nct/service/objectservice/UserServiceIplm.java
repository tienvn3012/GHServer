package vn.com.nct.service.objectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Roles;
import vn.com.nct.model.UserInfo;
import vn.com.nct.model.Users;
import vn.com.nct.model.response.Page;
import vn.com.nct.model.response.RoleResponse;
import vn.com.nct.model.response.UserInfoResponse;
import vn.com.nct.model.response.UserResponse;

@Service("userService")
@Transactional(readOnly = false)
public class UserServiceIplm implements ObjectService<Users,UserResponse>{

	@Autowired
	private ObjectDaoSupport<Users> userDao;
	
	@Autowired
	private ObjectService<UserInfo, UserInfoResponse> userInfoService;
	
	@Autowired
	private ObjectService<Roles, RoleResponse> roleService;
	
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
		return userDao.getLimit(index, offset);
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
	public Users saveE(Users e) {
		// TODO Auto-generated method stub
		return userDao.saveE(e);
	}



	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return userDao.countAll();
	}

	@Override
	public int countBy(String... condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page<UserResponse> getPage(int page_number, int row) {
		
		Page<UserResponse> page = new Page<>();
		page.setPage_number(page_number);
		page.setRow(row);
		//set role
		
		List<Users> lis = this.getLimit(row*(page_number - 1), row);
		page.setLis(parseAll(lis));
		
		return page;
	}

	@Override
	public Users updateE(Users e) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserResponse> parseAll(List<Users> lis){
		List<UserResponse> lisResponse = new ArrayList<>();
		
		for (int i = 0; i < lis.size(); i++) {
			lisResponse.add(this.parseResponse(lis.get(i)));
		}
		return lisResponse;
	}
	
	public UserResponse parseResponse(Users user){
		UserResponse ur = new UserResponse();
		ur.setActive(user.isActive());
		ur.setAvatar(user.getAvatar());
		ur.setCreate_by(user.getCreate_by());
		ur.setCreate_time(user.getCreate_time());
		ur.setCreate_to(user.isCreate_to());
		ur.setId(user.getId());
		ur.setLast_login(user.getLast_login());
		ur.setUsername(user.getUsername());
		
		ur.setInfo(userInfoService.parseResponse(user.getInfo()));
		ur.setRole(roleService.parseResponse(user.getRole()));
		
		return ur;
	}

	@Override
	public Page<UserResponse> getPageBy(int page_number, int row, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
