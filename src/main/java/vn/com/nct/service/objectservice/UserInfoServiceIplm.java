package vn.com.nct.service.objectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.UserInfo;
import vn.com.nct.model.response.Page;
import vn.com.nct.model.response.UserInfoResponse;

@Service
@Transactional(readOnly = false)
public class UserInfoServiceIplm implements ObjectService<UserInfo,UserInfoResponse>{

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
	public UserInfo saveE(UserInfo e) {
		// TODO Auto-generated method stub
		return userInfoDao.saveE(e);
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
	public Page<UserInfoResponse> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo updateE(UserInfo e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoResponse> parseAll(List<UserInfo> lis) {
		List<UserInfoResponse> lisResponse = new ArrayList<>();
		
		for (int i = 0; i < lis.size(); i++) {
			lisResponse.add(this.parseResponse(lis.get(i)));
		}
		
		return lisResponse;
	}

	@Override
	public UserInfoResponse parseResponse(UserInfo info) {
		UserInfoResponse response = new UserInfoResponse();
		
		response.setAddress(info.getAddress());
		response.setDate_of_birth(info.getDate_of_birth());
		response.setEmail(info.getEmail());
		response.setFullname(info.getFullname());
		response.setGender(info.isGender());
		response.setId(info.getId());
		response.setLevel(info.getLevel());
		response.setPhone(info.getPhone());
		
		return response;
	}


}
