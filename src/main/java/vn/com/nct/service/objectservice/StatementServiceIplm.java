package vn.com.nct.service.objectservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Statements;
import vn.com.nct.model.response.Page;
import vn.com.nct.model.response.StatementResponse;

@Service("statementService")
@Transactional(readOnly = false)
public class StatementServiceIplm implements ObjectService<Statements, StatementResponse>{

	@Autowired
	private ObjectDaoSupport<Statements> statementDao;
	
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
		return null;
	}

	@Override
	public Statements getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return statementDao.getOneByCondition(condition);
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

	@Override
	public Page<StatementResponse> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<StatementResponse> getPageBy(int page_number, int row, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatementResponse> parseAll(List<Statements> lis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatementResponse parseResponse(Statements e) {
		// TODO Auto-generated method stub
		return new StatementResponse(e.getId(), e.getStatements(), e.getTitle());
	}

	@Override
	public Statements parseToStandar(StatementResponse t) {
		// TODO Auto-generated method stub
		return null;
	}

}
