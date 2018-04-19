package vn.com.nct.service.objectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.AvailableFrame;
import vn.com.nct.model.response.AvailableFrameResponse;
import vn.com.nct.model.response.Page;

@Service
@Transactional(readOnly = false)
public class AvailableFrameServiceIplm implements ObjectService<AvailableFrame, AvailableFrameResponse>{
	
	@Autowired
	private ObjectDaoSupport<AvailableFrame> availableFrameService;

	@Override
	public List<AvailableFrame> getAll() {
		// TODO Auto-generated method stub
		return availableFrameService.getAll();
	}

	@Override
	public List<AvailableFrame> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return availableFrameService.getAllBy(condition);
	}

	@Override
	public List<AvailableFrame> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return availableFrameService.getLimit(index, offset);
	}

	@Override
	public List<AvailableFrame> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return availableFrameService.getLimitBy(index, offset, condition);
	}

	@Override
	public AvailableFrame getOneById(int id) {
		// TODO Auto-generated method stub
		return availableFrameService.getOneById(id);
	}

	@Override
	public AvailableFrame getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return availableFrameService.getOneByCondition(condition);
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
		return availableFrameService.saveE(e);
	}

	@Override
	public AvailableFrame updateE(AvailableFrame e) {
		// TODO Auto-generated method stub
		return availableFrameService.updateE(e);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return availableFrameService.countAll();
	}

	@Override
	public int countBy(String... condition) {
		// TODO Auto-generated method stub
		return availableFrameService.countBy(condition);
	}

	@Override
	public Page<AvailableFrameResponse> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AvailableFrameResponse> getPageBy(int page_number, int row, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvailableFrameResponse> parseAll(List<AvailableFrame> lis) {
		List<AvailableFrameResponse> ar = new ArrayList<>();
		
		for (AvailableFrame availableFrame : lis) {
			ar.add(this.parseResponse(availableFrame));
		}
		
		return ar;
	}

	@Override
	public AvailableFrameResponse parseResponse(AvailableFrame e) {
		
		return new AvailableFrameResponse(e.getId(), e.getDescription(), e.getImage(),
				e.isStatus(), e.getControl_device(), e.getCollect_device());
	}

	@Override
	public AvailableFrame parseToStandar(AvailableFrameResponse t) {
		// TODO Auto-generated method stub
		return null;
	}

}
