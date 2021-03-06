package vn.com.nct.service.objectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Devices;
import vn.com.nct.model.response.DevicesResponse;
import vn.com.nct.model.response.Page;

@Service("devicesService")
@Transactional(readOnly = false)
public class DeviceServiceIplm implements ObjectService<Devices,DevicesResponse>{
	
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
		return deviceDao.getOneByCondition(condition);
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
	public Devices saveE(Devices e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devices updateE(Devices e) {
		// TODO Auto-generated method stub
		return deviceDao.updateE(e);
	}

	@Override
	public Page<DevicesResponse> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DevicesResponse> parseAll(List<Devices> lis) {
		List<DevicesResponse> ls = new ArrayList<>();
		
		for (Devices device : lis) {
			ls.add(this.parseResponse(device));
		}
		
		return ls;
	}

	@Override
	public DevicesResponse parseResponse(Devices e) {
		DevicesResponse dr = new DevicesResponse();
		
		dr.setId(e.getId());
		dr.setControl_device(e.getControl_device());
		dr.setDescription(e.getDevice_type().getDescription());
		dr.setDevice_name(e.getDevice_name());
		dr.setDevice_status(e.isDevice_status());
		dr.setDevice_task(e.isDevice_task());
		dr.setType_name(e.getDevice_type().getType_name());
		
		return dr;
	}

	@Override
	public Page<DevicesResponse> getPageBy(int page_number, int row, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devices parseToStandar(DevicesResponse t) {
		// TODO Auto-generated method stub
		return null;
	}

}
