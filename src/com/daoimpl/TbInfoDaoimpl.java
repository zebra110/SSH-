package com.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.TbInfoDao;

@Component
@SuppressWarnings("all")

public class TbInfoDaoimpl<T>  implements  TbInfoDao<T>{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
	
	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
	}

	/**
	 * ²éÑ¯×Ü¼ÇÂ¼
	 */
	public  Integer countA(String hql) {
		int count=Integer.parseInt(this.getCurrentSession().createSQLQuery(hql).list().get(0).toString());
		return (Integer)count;
	}
	
	
//	public Integer countA(String hql, List<Object> param) {
//		Query q = this.getCurrentSession().createQuery(hql);
//		if (param != null && param.size() > 0) {
//			for (int i = 0; i < param.size(); i++) {
//				q.setParameter(i, param.get(i));
//			}
//		}
//		return q.list().size();
//	}
	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	
	public void update(T o) {
		this.getCurrentSession().update(o);
	}
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}
	
}
