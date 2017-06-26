package com.daoimpl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.AdminDao;
@Repository("adminDAO")
@SuppressWarnings("all")//不显示使用了不赞成使用的类或方法时的警告

public class AdminDaoimpl extends HibernateDaoSupport implements AdminDao{

}
