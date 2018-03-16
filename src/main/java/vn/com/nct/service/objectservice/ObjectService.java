package vn.com.nct.service.objectservice;

import java.util.List;

import vn.com.nct.model.response.Page;


public interface ObjectService <E,T>{
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
	public Page<T> getPage(int page_number, int row);
	public Page<T> getPageBy(int page_number, int row, String... condition);
	public List<T> parseAll(List<E> lis);
	public T parseResponse(E e);
	public E parseToStandar(T t);
}
