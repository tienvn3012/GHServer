package vn.com.nct.service.objectservice;

import java.util.List;

import vn.com.nct.model.response.Page;

public interface ObjectService <E>{
	public List<E> getAll();
	public List<E> getAllBy(String... condition);
	public List<E> getLimit(int index, int offset);
	public List<E> getLimitBy(int index, int offset, String... condition);
	public E getOneById(int id);
	public E getOneByCondition(String... condition);
	public void deleteE(int id);
	public void deleteManyE(List<E> lis);
	public E saveOrUpdateE(E e);
	public void saveOrUpdateManyE(List<E> lis);
	public int countAll();
	public int countBy(String... condition);
	public Page<E> getPage();
}
