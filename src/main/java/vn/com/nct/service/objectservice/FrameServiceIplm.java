package vn.com.nct.service.objectservice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.base.TimerService;
import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.AvailableFrame;
import vn.com.nct.model.Devices;
import vn.com.nct.model.Frame;
import vn.com.nct.model.Plants;
import vn.com.nct.model.response.AvailableFrameResponse;
import vn.com.nct.model.response.DevicesResponse;
import vn.com.nct.model.response.FrameResponse;
import vn.com.nct.model.response.Page;
import vn.com.nct.model.response.PlantResponse;

@Service("frameService")
@Transactional(readOnly = false)
public class FrameServiceIplm implements ObjectService<Frame,FrameResponse>{
	
	@Autowired
	private ObjectDaoSupport<Frame> frameDao;
	
	@Autowired
	@Qualifier("availableFrameService")
	private ObjectService<AvailableFrame, AvailableFrameResponse> availableFrameService;
	
	@Autowired
	@Qualifier("devicesService")
	private ObjectService<Devices, DevicesResponse> deviceService;
	
	@Autowired
	@Qualifier("plantService")
	private ObjectService<Plants, PlantResponse> plantService;
	
	@Autowired
	private TimerService timerService;

	@Override
	public List<Frame> getAll() {
		// TODO Auto-generated method stub
		return frameDao.getAll();
	}

	@Override
	public List<Frame> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return frameDao.getAllBy(condition);
	}

	@Override
	public List<Frame> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return frameDao.getLimit(index, offset);
	}

	@Override
	public List<Frame> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return frameDao.getLimitBy(index, offset, condition);
	}

	@Override
	public Frame getOneById(int id) {
		// TODO Auto-generated method stub
		return frameDao.getOneById(id);
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
		return frameDao.countAll();
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
		// TODO Auto-generated method stub
		return frameDao.updateE(e);
	}

	@Override
	public Page<FrameResponse> getPage(int page_number, int row) {
		
		Page<FrameResponse> page = new Page<>();
		page.setPage_number(page_number);
		page.setRow(row);
		
		List<Frame> lf = this.getLimit(row*(page_number - 1), row);
		page.setLis(parseAll(lf));
		
		return page;
	}

	@Override
	public List<FrameResponse> parseAll(List<Frame> lis) {
		List<FrameResponse> lis_fr = new ArrayList<>();
		for (int i = 0; i < lis.size(); i++) {
			lis_fr.add(this.parseResponse(lis.get(i)));
		}
		return lis_fr;
	}

	@Override
	public FrameResponse parseResponse(Frame e) {
		FrameResponse fr = new FrameResponse();
		fr.setId(e.getId());
		fr.setAutomatic_mode(e.isAutomatic_mode());
		fr.setHarvested(e.isHarvested());
		fr.setTime_begin(e.getTime_begin());
		try {
			fr.setDays(timerService.countDays(e.getTime_begin()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Error when count day !!!!");
		}
		
		fr.setDevice_collect(deviceService.parseResponse(e.getDevice_colect()));
		fr.setDevice_control(deviceService.parseResponse(e.getDevice_control()));
		
		fr.setPlant(plantService.parseResponse(e.getPlant()));
		
		fr.setAvailable_frame(availableFrameService.parseResponse(e.getAvailable_frame()));
		
		return fr;
	}

	@Override
	public Page<FrameResponse> getPageBy(int page_number, int row, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frame parseToStandar(FrameResponse t) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
