package vn.com.nct.service.analysisservice;

import org.springframework.stereotype.Service;

import vn.com.nct.constant.Constant;

@Service
public class PlantAnalysisServiceIplm implements PlantAnalysisService{
	
	private double pre_ph = 0;
	private int pre_action = 0;
	private int a[] = {0,1,2,-1,-2};
	
	@Override
	public int phAnalysisService(String split, double cur_ph) {
		int stage = 0; // -1: low, 0: ok, 1: high
		String info[] = split.split(Constant.SPLIT_PATTERN);
		double min = Double.parseDouble(info[0]);
		double max = Double.parseDouble(info[1]);
		System.out.println(min+" - "+max);
		double reward = -100;
		int action = 0;
		
		if(cur_ph < min){
			stage = -1;
		}else if((cur_ph >= min) && (cur_ph <= max)){
			stage = 0;
		}else{
			stage = 1;
		}
		if(pre_ph != 0) cur_ph = pre_ph + a[pre_action];
		double differrence = pre_ph == 0 ? 0 : (cur_ph - pre_ph);

		for(int i=0;i<5;i++){
			double ph_next = cur_ph + this.phByAction(i) - differrence;
			int pen = ((ph_next >= min) && (ph_next <= max)) ? 0:14;
			
			double alpha = i<3 ? ((this.phByAction(2) - this.phByAction(1))/0.5):
				((this.phByAction(3) - this.phByAction(4))/0.5);
			
			double r = alpha*stage*differrence*a[i] - this.phByAction(i) - pen;
			System.out.println("pre_ph: "+pre_ph+" - current_ph: "+cur_ph+" - v: "+differrence+" - alpha: "+alpha+" - a: "+a[i]+" - stage: "+stage+" - R : "+r);
			if(r > reward){
				reward = r;
				action = i;
			}
		}
		
		pre_ph = cur_ph;
		pre_action = action;
		return action;
	}
	
	private int phByAction(int action){
		switch (action) {
			case 0 : 
				return 0;
			case 1 : 
				return 1;
			case 2 : 
				return 2;
			case 3 : 
				return -1;
			case 4 :
				return -2;
			default :
				return 0;
		}
	}

}
