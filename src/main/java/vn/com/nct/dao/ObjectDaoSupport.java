package vn.com.nct.dao;

import java.util.List;

public interface ObjectDaoSupport <E>{
	
	public List<E> getAll();
	public List<E> getAllBy(String... condition);
	public List<E> getLimit(int index, int offset);
	public List<E> getLimitBy(int index, int offset, String... condition);
	public E getOneById(int id);
	public E getOneByCondition(String... condition);
	public void deleteE(int id);
	public void deleteManyE(List<E> lis);
	public E saveE(E e);
	public E updateE(E e);
	public int countAll();
	public int countBy(String... condition);
	
}
