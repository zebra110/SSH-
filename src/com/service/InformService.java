package com.service;

import java.util.List;


import com.domain.Inform;


public interface InformService{
	

	public void saveInform(Inform inform) ;

	public void updateInform(Inform inform);

	public Inform findInformById(int id);

	public void deleteInform(Inform inform);
	
	public List<Inform> find(List<Object> param, Integer page, Integer rows);

	public Integer count();

	
}
