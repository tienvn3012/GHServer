package vn.com.nct.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.nct.base.BaseMethods;
import vn.com.nct.model.Devices;

@Repository
public class DeviceDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<Devices>{

	private BaseMethods base = new BaseMethods();
	
	@Override
	public List<Devices> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Devices> getAllBy(String... condition) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Devices.class,"devices");
		criteria.createAlias("devices.device_type", "device_type");
		
		criteria = base.setCondition(criteria, condition);
		
		return (List<Devices>)hibernateTemplate.findByCriteria(criteria);
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
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Devices.class, id);
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
	public Devices saveE(Devices e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devices updateE(Devices e) {
		// TODO Auto-generated method stub
		return null;
	}

}
