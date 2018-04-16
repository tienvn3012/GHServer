package vn.com.nct.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import vn.com.nct.base.BaseMethods;
import vn.com.nct.model.Frame;

@Repository
public class FrameDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<Frame>{

	private BaseMethods base = new BaseMethods();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Frame> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Frame.class);
		return (List<Frame>)hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<Frame> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Frame> getLimit(int index, int offset) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Frame.class,"frame");
		return (List<Frame>)hibernateTemplate.findByCriteria(criteria,index,offset);
	}

	@Override
	public List<Frame> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frame getOneById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Frame.class, id);
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
		Criteria criteria = getSession().getCurrentSession().createCriteria(Frame.class,"frame");
		Integer count = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		return count;
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
