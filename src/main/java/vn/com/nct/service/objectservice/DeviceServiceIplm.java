package vn.com.nct.service.objectservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Devices;
import vn.com.nct.model.response.Page;

@Service("devicesService")
@Transactional(readOnly = false)
public class DeviceServiceIplm implements ObjectService<Devices,Object>{
	
	@Autowired
	private ObjectDaoSupport<Devices> deviceDao;

	@Override
	public List<Devices> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Devices> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return deviceDao.getAllBy(condition);
	}

	@Override
	public List<Devices> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Devices> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devices getOneById(int id) {
		return deviceDao.getOneById(id);
	}

	@Override
	public Devices getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<Devices> lis) {
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
	public Page<Object> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devices saveE(Devices e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devices updateE(Devices e) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Object> parseAll(List<Devices> lis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseResponse(Devices user) {
		// TODO Auto-generated method stub
		return null;
	}

}
