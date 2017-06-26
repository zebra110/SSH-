package com.dao;

import java.io.Serializable;
import java.util.List;

public interface TbInfoDao<T> {
	
	
	public void update(T o);
	public Serializable save(T o);
	public List<T> find(String hql, List<Object> param, Integer page,Integer rows);
	public Integer countA(String hql);
	public T get(Class<T> c, Serializable id);
	
}
