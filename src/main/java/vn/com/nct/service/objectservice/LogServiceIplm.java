package vn.com.nct.service.objectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Frame;
import vn.com.nct.model.Notifications;
import vn.com.nct.model.Statements;
import vn.com.nct.model.SystemLogActivity;
import vn.com.nct.model.Users;
import vn.com.nct.model.response.FrameResponse;
import vn.com.nct.model.response.LogResponse;
import vn.com.nct.model.response.NotificationResponse;
import vn.com.nct.model.response.Page;
import vn.com.nct.model.response.StatementResponse;
import vn.com.nct.model.response.UserResponse;

@Service("logService")
@Transactional(readOnly = false)
public class LogServiceIplm implements ObjectService<SystemLogActivity, LogResponse>{
	
	@Autowired
	private ObjectDaoSupport<SystemLogActivity> logDao;
	
	@Autowired
	private ObjectService<Users, UserResponse> userService;
	
	@Autowired
	private ObjectService<Frame, FrameResponse> frameService;
	
	@Autowired
	@Qualifier("statementService")
	private ObjectService<Statements, StatementResponse> statementService;
	
	@Autowired
	private ObjectService<Notifications, NotificationResponse>  notificationService;

	@Override
	public List<SystemLogActivity> getAll() {
		// TODO Auto-generated method stub
		return logDao.getAll();
	}

	@Override
	public List<SystemLogActivity> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return logDao.getAllBy(condition);
	}

	@Override
	public List<SystemLogActivity> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemLogActivity> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemLogActivity getOneById(int id) {
		// TODO Auto-generated method stub
		return logDao.getOneById(id);
	}

	@Override
	public SystemLogActivity getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return logDao.getOneByCondition(condition);
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<SystemLogActivity> lis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SystemLogActivity saveE(SystemLogActivity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemLogActivity updateE(SystemLogActivity e) {
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
	public Page<LogResponse> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<LogResponse> getPageBy(int page_number, int row, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogResponse> parseAll(List<SystemLogActivity> lis) {
		List<LogResponse> lr = new ArrayList<>();
		for (SystemLogActivity systemLogActivity : lis) {
			lr.add(this.parseResponse(systemLogActivity));
		}
		return lr;
	}

	@Override
	public LogResponse parseResponse(SystemLogActivity e) {
		LogResponse r = new LogResponse();
		
		r.setAuto(e.isAuto());
		r.setId(e.getId());
		r.setTime(e.getTime());
		r.setUsers(userService.parseResponse(e.getUsers()));
		r.setFrame(frameService.parseResponse(e.getFrame()));
		r.setNotification(notificationService.parseResponse(e.getNotification()));
		r.setStatement(statementService.parseResponse(e.getStatements()));
		
		return r;
	}

	@Override
	public SystemLogActivity parseToStandar(LogResponse t) {
		// TODO Auto-generated method stub
		return null;
	}

}
