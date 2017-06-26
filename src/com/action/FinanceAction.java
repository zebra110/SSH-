package com.action;

import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.domain.TbInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TbInfoService;

public class FinanceAction extends ActionSupport {

	@Resource
	private TbInfoService tbInfoService;
	private TbInfo tbInfo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	@Action(value = "/changefinance" , results = { 
			@Result(name = "changefinance", location = "/financemanage.jsp")
		}
	)
    public String changefinance() throws Exception {
		
		  request = ServletActionContext.getRequest(); 
      	  response = ServletActionContext.getResponse(); 
      	  response.setContentType("text/html;charset=UTF-8");
      	  request.setCharacterEncoding("UTF-8");
      	  response.setCharacterEncoding ("UTF-8");
      	String id =request.getParameter("id");
      	String totalfund =request.getParameter("totalfund");
      	String surplusfunds =request.getParameter("surplusfunds");
      	TbInfo tbInfo = tbInfoService.findTbInfoById(Integer.parseInt(id));
      	System.out.println("77777777"+id+totalfund+surplusfunds);
      	tbInfo.setTotalfund(totalfund);
        tbInfo.setUploadTime(new Date());
      	tbInfo.setSurplusfunds(surplusfunds);
      	tbInfoService.updateTbInfo(tbInfo);
		  PrintWriter out = response.getWriter();
		  out.println("<script language = javascript>alert('±£´æ³É¹¦');");
		  out.println("location.href='TbInfoAction/adminshowTb.do?isfinance=isfinance'</script>");
		  out.close();
		  return null;
	}
	
}
