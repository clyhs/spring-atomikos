package org.sa.base;

import java.util.List;

public interface BaseMapper<T> {

	public List<T> getAll();
	public void delete(Integer id);
	public void update(T t);
	public T    getById(Integer id);
	public void insert(T t);
}
