package vn.com.nct.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.nct.base.BaseMethods;
import vn.com.nct.model.Frame;

@Repository
public class FrameDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<Frame>{

	private BaseMethods base = new BaseMethods();
	
	@Override
	public List<Frame> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Frame> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Frame> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Frame> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frame getOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Frame getOneByCondition(String... condition) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Frame.class,"frame");
		criteria.createAlias("frame.plant", "plant")
		.createAlias("frame.device_control", "device_control");
		criteria = base.setCondition(criteria, condition);

		List<Frame> lis = (List<Frame>)hibernateTemplate.findByCriteria(criteria);
		return lis.get(lis.size() - 1);
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<Frame> lis) {
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
	public Frame saveE(Frame e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frame updateE(Frame e) {
		int id = e.getId();
		this.save(e);
		return this.getOneById(id);
	}

}
