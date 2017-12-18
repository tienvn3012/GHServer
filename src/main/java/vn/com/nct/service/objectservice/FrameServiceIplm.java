package vn.com.nct.service.objectservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Frame;
import vn.com.nct.model.response.Page;

@Service("frameService")
@Transactional(readOnly = false)
public class FrameServiceIplm implements ObjectService<Frame,Object>{
	
	@Autowired
	private ObjectDaoSupport<Frame> frameDao;

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

	@Override
	public Frame getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return frameDao.getOneByCondition(condition);
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
	public Page<Object> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frame saveE(Frame e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frame updateE(Frame e) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Object> parseAll(List<Frame> lis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseResponse(Frame user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
