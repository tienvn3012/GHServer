package vn.com.nct.service.objectservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.FrameDataColection;
import vn.com.nct.model.response.Page;

@Service("frameDataCollectionService")
@Transactional(readOnly = false)
public class FrameDataCollectionServiceIplm implements ObjectService<FrameDataColection, Object>{

	@Autowired
	private ObjectDaoSupport<FrameDataColection> frameDataCollectionDao;

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

	@Override
	public List<FrameDataColection> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
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
	public FrameDataColection saveE(FrameDataColection e) {
		// TODO Auto-generated method stub
		return frameDataCollectionDao.saveE(e);
	}

	@Override
	public FrameDataColection updateE(FrameDataColection e) {
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
	public Page<Object> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> parseAll(List<FrameDataColection> lis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseResponse(FrameDataColection e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
