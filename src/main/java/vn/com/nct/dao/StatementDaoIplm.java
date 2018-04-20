package vn.com.nct.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.nct.base.BaseMethods;
import vn.com.nct.model.Statements;

@Repository
public class StatementDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<Statements>{
	
	private BaseMethods base = new BaseMethods();

	@Override
	public List<Statements> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Statements> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Statements> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Statements> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statements getOneById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Statements.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Statements getOneByCondition(String... condition) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Statements.class, "statements");
		
		criteria = base.setCondition(criteria, condition);
		
		List<Statements> lis = ((List<Statements>)hibernateTemplate.findByCriteria(criteria));
		
		return lis.get(0);
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<Statements> lis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Statements saveE(Statements e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statements updateE(Statements e) {
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
