package vn.com.nct.service.controlservice;

import vn.com.nct.service.PublishService;
import vn.com.nct.service.PublishServiceSeconds;

public interface AutomaticControlService {
	public void plantAnalysis(int id);
	public void trackParamsAnalysis(String msg,String topic);
	public PublishService control(String type, double time, int did,  int harvest_time);
	public PublishServiceSeconds controlOneTime(String type, double time, int did);
}
