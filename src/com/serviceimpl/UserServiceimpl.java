package com.serviceimpl;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dao.InformDao;
//ҵ���ʵ����
import com.dao.UserDao;
import com.domain.Inform;
import com.domain.User;
import com.service.UserService;

@Transactional
@Service
public class UserServiceimpl implements UserService{
	 
	
	@Resource
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User login(User user){
		User existuser =userDao.findByUsernameAndPassword(user);
		return existuser;
	}

	 
}
