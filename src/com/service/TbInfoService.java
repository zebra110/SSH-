package com.service;

import java.util.List;

import com.domain.Inform;
import com.domain.TbInfo;

public interface TbInfoService {
	public void saveTbInfo(TbInfo tbInfo) ;
	
	public List<TbInfo> find(String username,List<Object> param, Integer page, Integer rows);

	public Integer count(String username);
	
	public List<TbInfo> adminfind(List<Object> param, Integer page, Integer rows);

	public Integer admincount();
	
	public void updateTbInfo(TbInfo tbInfo);

	public TbInfo findTbInfoById(int id);
}
