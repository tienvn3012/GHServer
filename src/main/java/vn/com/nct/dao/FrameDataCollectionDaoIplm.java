package vn.com.nct.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import vn.com.nct.base.BaseMethods;
import vn.com.nct.model.FrameDataColection;

@Repository
public class FrameDataCollectionDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<FrameDataColection>{

	private BaseMethods base = new BaseMethods();
	
	@Override
	public List<FrameDataColection> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrameDataColection> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrameDataColection> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrameDataColection> getLimitBy(int index, int offset, String... condition) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FrameDataColection.class, "framedatacolection");
		criteria.createAlias("framedatacolection.frame", "frame");
		
		criteria = base.setCondition(criteria, condition);
		
		return (List<FrameDataColection>)hibernateTemplate.findByCriteria(criteria,index,offset);
	}

	@Override
	public FrameDataColection getOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FrameDataColection getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<FrameDataColection> lis) {
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

	@SuppressWarnings("unchecked")
	@Override
	public FrameDataColection saveE(FrameDataColection e) {
		save(e);
		DetachedCriteria criteria = DetachedCriteria.forClass(FrameDataColection.class)
			    .setProjection( Projections.max("id") );
		Integer i = ((List<Integer>)hibernateTemplate.findByCriteria(criteria)).get(0);
		return getOneById(i.intValue());
	}

	@Override
	public FrameDataColection updateE(FrameDataColection e) {
		// TODO Auto-generated method stub
		return null;
	}

}
