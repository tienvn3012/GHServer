package vn.com.nct.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.constant.Constant;
import vn.com.nct.model.Devices;
import vn.com.nct.model.response.DevicesResponse;
import vn.com.nct.service.objectservice.ObjectService;

@Component("keepAlive_countdown")
@Transactional(readOnly = false)
public class KeepAliveCountdownService extends Thread{
	
	@Autowired
	@Qualifier("devicesService")
	private ObjectService<Devices, DevicesResponse> deviceService;

	
	
	public KeepAliveCountdownService() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("start running keep alive checker !!!!");
		this.start();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		super.run();
		
		while(true){
			try {
				System.out.println("keep alive restart !");
				Constant.lis_keepAlive.clear();
				sleep(3*60*1000);
				Set<String> set = new HashSet<>();
				set.addAll(Constant.lis_keepAlive);
				
				List<Devices> lis = deviceService.getAllBy("devices.device_status;true;=;boolean");
				
				if(lis.size() != 0){
					lis = this.checkKeepAlive(lis, set);
					for (int i = 0; i < lis.size(); i++) {
						deviceService.updateE(lis.get(i));
					}
				}
				
				for (int i = 0; i < lis.size(); i++) {
					for (int j = 0; i < Constant.lis_deviceThread.size(); j++) {
						if(Constant.lis_deviceThread.get(j).getId() == lis.get(i).getId()){					
							for (int k = 0; k < Constant.lis_deviceThread.get(j).getLis().size(); k++) {
								Constant.lis_deviceThread.get(j).getLis().get(k).stop();
							}
							break;
						}
					}
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private List<Devices> checkKeepAlive(List<Devices> lis, Set<String> set){
		List<Devices> lis_non_keepAlive = new ArrayList<>();
		
		for (int i = 0; i < lis.size(); i++) {
			if(!set.contains(lis.get(i).getId()+"")){
				lis.get(i).setDevice_status(false);
				lis_non_keepAlive.add(lis.get(i));
			}
		}
		
		return lis_non_keepAlive;
	}
	
}
