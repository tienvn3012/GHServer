package vn.com.nct.service.objectservice;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.nct.model.Notifications;
import vn.com.nct.model.response.NotificationResponse;
import vn.com.nct.model.response.Page;

@Service
public class NotificationServiceIplm implements ObjectService<Notifications, NotificationResponse>{

	@Override
	public List<Notifications> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notifications> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notifications> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notifications> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notifications getOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notifications getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<Notifications> lis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notifications saveE(Notifications e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notifications updateE(Notifications e) {
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
	public Page<NotificationResponse> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<NotificationResponse> getPageBy(int page_number, int row, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotificationResponse> parseAll(List<Notifications> lis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificationResponse parseResponse(Notifications e) {
		NotificationResponse r = new NotificationResponse();
		r.setId(e.getId());
		r.setNotifications(e.getNotifications());
		return r;
	}

	@Override
	public Notifications parseToStandar(NotificationResponse t) {
		// TODO Auto-generated method stub
		return null;
	}

}
