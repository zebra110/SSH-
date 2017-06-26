package com.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dao.InformDao;
import com.domain.Inform;
import com.mchange.v2.ser.IndirectlySerialized;
import com.service.InformService;




@Transactional //启用事务机制
@Service
public class InformServiceimpl implements InformService{
	
	@Resource
	private InformDao<Inform> informDao;
	
	@Override
	public void saveInform(Inform inform) {
		informDao.save(inform);
	}

	@Override
	public void updateInform(Inform inform) {
		informDao.update(inform);
	}

	@Override
	public Inform findInformById(int id) {
		return informDao.get(Inform.class, id);
	}
	
	


	@Override
	public void deleteInform(Inform inform) {
		informDao.delete(inform);
	}
	
	public List<Inform> find(List<Object> param, Integer page,Integer rows) {
		
		return informDao.find("from Inform  where year(t_upload_time)=YEAR(NOW()) order by t_upload_time desc",param, page, rows);
		
	}
	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return informDao.countA("select count(*) from Inform");
	
	}

		
}
