package vn.com.nct.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.com.nct.model.Plants;

@Repository
public class PlantDaoIplm extends HibernateDaoSupport implements ObjectDaoSupport<Plants>{

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

}
