package vn.com.nct.service.controlservice;

import vn.com.nct.model.Frame;
import vn.com.nct.service.PublishService;
import vn.com.nct.service.PublishServiceAnsyn;
import vn.com.nct.service.PublishServiceMinutes;
import vn.com.nct.service.PublishServiceSeconds;
import vn.com.nct.service.PublishServiceSecondsAnsyn;

public interface AutomaticControlService {
	public void pumpWaterToFrame(Frame frame,int water);
	public void plantAnalysis(Frame frame);
	public void trackParamsAnalysis(String msg,String topic);
	public PublishService control(String type, double time, int did,  int harvest_time);
	public PublishServiceSeconds controlSeconds(String type, double time, int did);
	public PublishServiceSecondsAnsyn controlSecondsAnsyn(String type, double time, int did);
	public PublishServiceAnsyn controlAnsyn(String type, double time, int did);
	public PublishServiceMinutes controlMinutes(String type, double time, int did);
}
