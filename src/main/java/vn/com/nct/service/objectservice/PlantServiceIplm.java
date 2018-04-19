package vn.com.nct.service.objectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nct.model.Plants;
import vn.com.nct.model.response.Page;
import vn.com.nct.model.response.PlantResponse;

@Service("plantService")
@Transactional(readOnly = false)
public class PlantServiceIplm implements ObjectService<Plants, PlantResponse>{

	@Override
	public List<Plants> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plants> getAllBy(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plants> getLimit(int index, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plants> getLimitBy(int index, int offset, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plants getOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plants getOneByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteE(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManyE(List<Plants> lis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Plants saveE(Plants e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plants updateE(Plants e) {
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
	public Page<PlantResponse> getPage(int page_number, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PlantResponse> getPageBy(int page_number, int row, String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlantResponse> parseAll(List<Plants> lis) {
		List<PlantResponse> lp = new ArrayList<>();
		
		for (Plants plant : lis) {
			lp.add(this.parseResponse(plant));
		}
		
		return lp;
	}

	@Override
	public PlantResponse parseResponse(Plants e) {
		PlantResponse pr = new PlantResponse();
		
		pr.setId(e.getId());
		pr.setCo2(e.getPlant_info().getCo2());
		pr.setDescription(e.getPlant_type().getDescription());
		pr.setEc(e.getPlant_info().getEc());
		pr.setHumidity(e.getPlant_info().getHumidity());
		pr.setLight_time(e.getPlant_info().getLight_time());
		pr.setpH(e.getPlant_info().getpH());
		pr.setPlant_name(e.getPlant_name());
		pr.setTemperature(e.getPlant_info().getTemperature());
		pr.setTime_harvest(e.getPlant_info().getTime_harvest());
		pr.setTrack_time(e.getPlant_info().getTrack_time());
		pr.setType_name(e.getPlant_type().getType_name());
		
		return pr;
	}

	@Override
	public Plants parseToStandar(PlantResponse t) {
		// TODO Auto-generated method stub
		return null;
	}

}
