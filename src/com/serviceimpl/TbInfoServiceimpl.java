package com.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TbInfoDao;
import com.domain.Inform;
import com.domain.TbInfo;
import com.service.TbInfoService;



@Transactional //启用事务机制
@Service

public class TbInfoServiceimpl implements TbInfoService{
	@Resource
	private TbInfoDao<TbInfo> tbInfoDao;
	
	
	@Override
	public void updateTbInfo(TbInfo tbInfo) {
		tbInfoDao.update(tbInfo);
	}

	@Override
	public TbInfo findTbInfoById(int id) {
		return tbInfoDao.get(TbInfo.class, id);
	}
	
	@Override
	public void saveTbInfo(TbInfo tbInfo) {
		tbInfoDao.save(tbInfo);
	}
	
	public List<TbInfo> find(String username,List<Object> param, Integer page,Integer rows) {
		
		return tbInfoDao.find("from TbInfo where username=" + username,param, page, rows);
		
	}
	
	@Override
	public Integer count(String username) {
		// TODO Auto-generated method stub
		return tbInfoDao.countA("select count(*) from tb_info where t_username="+ username);
	
	}
	
	public List<TbInfo> adminfind(List<Object> param, Integer page,Integer rows) {
		
		return tbInfoDao.find("from TbInfo" , param, page, rows);
		
	}
	
	@Override
	public Integer admincount() {
		// TODO Auto-generated method stub
		return tbInfoDao.countA("select count(*) from tb_info");
	
	}
}
