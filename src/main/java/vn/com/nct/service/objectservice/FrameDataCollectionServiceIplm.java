package vn.com.nct.service.objectservice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.base.TimerService;
import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Frame;
import vn.com.nct.model.FrameDataColection;
import vn.com.nct.model.response.FrameDataCollectionResponse;
import vn.com.nct.model.response.FrameResponse;
import vn.com.nct.model.response.Page;

@Service("frameDataCollectionService")
@Transactional(readOnly = false)
public class FrameDataCollectionServiceIplm implements ObjectService<FrameDataColection, FrameDataCollectionResponse>{

	@Autowired
	private ObjectDaoSupport<FrameDataColection> frameDataCollectionDao;
	
	@Autowired
	private ObjectService<Frame, FrameResponse> frameService;
	
	@Autowired
	private TimerService timer;

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
	public Page<FrameDataCollectionResponse> getPage(int page_number, int row) {
		
		
		return null;
	}
	
	@Override
	public Page<FrameDataCollectionResponse> getPageBy(int page_number, int row, String... condition) {
		Page<FrameDataCollectionResponse> page = new Page<>();
		page.setPage_number(page_number);
		page.setRow(row);
		//set role
		
		page.setLis(this.parseAll(frameDataCollectionDao.
				getLimitBy(row*(page_number - 1), row, condition)));
		return page;
	}

	@Override
	public List<FrameDataCollectionResponse> parseAll(List<FrameDataColection> lis) {
		List<FrameDataCollectionResponse> lis_res = new ArrayList<>();
		for (int i = 0; i < lis.size(); i++) {
			lis_res.add(this.parseResponse(lis.get(i)));
		}
		return lis_res;
	}

	@Override
	public FrameDataCollectionResponse parseResponse(FrameDataColection e) {
		try {
			return new FrameDataCollectionResponse(e.getId(), timer.getMiliseconds(e.getTime()), e.getpH(),
					e.getTemperature(), e.getHumidity(), e.getCo2(), frameService.parseResponse(e.getFrame()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public FrameDataColection parseToStandar(FrameDataCollectionResponse t) {
		// TODO Auto-generated method stub
		return null;
	}




	
	

}
