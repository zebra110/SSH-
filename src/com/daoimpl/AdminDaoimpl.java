package com.daoimpl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.AdminDao;
@Repository("adminDAO")
@SuppressWarnings("all")//����ʾʹ���˲��޳�ʹ�õ���򷽷�ʱ�ľ���

public class AdminDaoimpl extends HibernateDaoSupport implements AdminDao{

}
