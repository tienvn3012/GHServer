package vn.com.nct.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.nct.base.BaseMethods;
import vn.com.nct.model.AvailableFrame;

@Repository
public class AvailableFrameDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<AvailableFrame>{
	
	private BaseMethods base = new BaseMethods();

	@Override
	public List<AvailableFrame> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AvailableFrame> getAllBy(String... condition) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AvailableFrame.class,"availableFrame");
		
		criteria = base.setCondition(criteria, condition);
		
		return (List<AvailableFrame>)hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<AvailableFrame> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvailableFrame> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvailableFrame getOneById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(AvailableFrame.class, id);
	}

	@Override
	public AvailableFrame getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<AvailableFrame> lis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AvailableFrame saveE(AvailableFrame e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvailableFrame updateE(AvailableFrame e) {
		// TODO Auto-generated method stub
		return null;
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

}
