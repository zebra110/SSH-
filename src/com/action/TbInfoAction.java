package com.action;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.domain.Inform;
import com.domain.TbInfo;
import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.InformService;
import com.service.TbInfoService;

@Controller//通常作用在控制层，但是目前该功能与 @Component(是一个泛化的概念 仅仅表示一个组件 (Bean)可以作用在任何层次)相同
@ParentPackage("struts-default") 
@Namespace(value = "/")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })  

public class TbInfoAction extends ActionSupport implements ModelDriven<TbInfo>{
	
	@Resource
	private TbInfoService tbInfoService;
	private TbInfo tbInfo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	private final static int PAGEROW = 3;//每页显示的行数
	private Integer countRow=0;//总行数
	private int countPage;//总页数
	private int currentlyPage;//当前第几页
	private String strPageNum =null;
	
	public int setCountPage(){
		if(countRow % PAGEROW == 0){
			countPage = (int) (countRow / PAGEROW);
		}
		else{
			countPage = (int) (countRow / PAGEROW + 1);
		}
		if(countRow <PAGEROW ){
			countPage =1;
		}
		return countPage;
	}
	
	@Action(value = "saveTb" , results = {@Result(name = "useshowTb", location = "/usehistory.jsp")
	})
    public String saveTb() throws Exception {
		
		  request = ServletActionContext.getRequest(); 
      	  response = ServletActionContext.getResponse(); 
      	  request.setCharacterEncoding("utf-8");
      	  response.setCharacterEncoding ("utf-8");
	      	tbInfo.setUsername((String)request.getSession().getAttribute("userInfo"));
	      	System.out.println("userInfo中的东西"+(String)request.getSession().getAttribute("userInfo"));
	      	tbInfo.setStatuss("待审核");
	      	tbInfo.setUploadTime(new Date());
      	  System.out.println(tbInfo);
      	  tbInfoService.saveTbInfo(tbInfo);
		  PrintWriter out = response.getWriter();
		  out.println("<script language = javascript>alert('提交成功');");
		  out.println("location.href='usetable.jsp'</script>");
		  out.close();
		  return null;
	}
	private String status="111";
	private String button="111";
	
	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String isadmin="111";
	
	public String getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	@Action(value = "/showTb" , results = { 
			@Result(name = "useshowTb", location = "/usehistory.jsp"),
			@Result(name = "useagain1", location = "/usetable.jsp"),
			@Result(name = "useshowTb1", location = "/userapplication1.jsp"),
			@Result(name = "useshowTb2", location = "/userapplication2.jsp"),
			@Result(name = "useshowTb3", location = "/userapplication3.jsp")
		})
		public String showTb() throws UnsupportedEncodingException{
		 request = ServletActionContext.getRequest(); 
     	  response = ServletActionContext.getResponse(); 
     	  response.setContentType("text/html;charset=UTF-8");
     	  request.setCharacterEncoding("UTF-8");
     	  response.setCharacterEncoding ("UTF-8");
			System.out.println("进入findAll。。。");
			strPageNum =request.getParameter("currentlyPage");
			if(strPageNum==null){
				currentlyPage=1;
			}
			else{
				currentlyPage = Integer.parseInt(strPageNum);
			 System.out.println("当前页" + currentlyPage);}
		List<TbInfo> tbInfo = tbInfoService.find((String)request.getSession().getAttribute("userInfo"),null, currentlyPage, PAGEROW);
		countRow=tbInfoService.count((String)request.getSession().getAttribute("userInfo"));
		System.out.println("sssssssss"+countRow);

		int j=(currentlyPage-1)*PAGEROW+1;
//		Iterator it =  tmp.iterator();
//		while(it.hasNext()) {
//			
//	    }  
		for(int i = 0; i < tbInfo.size(); i++)  
	    {  
			
			tbInfo.get(i).setNumber(j);
			System.out.println("jjjj"+j);
//			System.out.println(tbInfo.get(i).getPictureName());
	        j++; 
	        String s=(new SimpleDateFormat("yyyy-MM-dd")).format(tbInfo.get(i).getUploadTime());
	        tbInfo.get(i).setUploadTime2(s);
	    }  	
		request.setAttribute("tbInfo", tbInfo);
		request.setAttribute("currentlyPage", currentlyPage);
		request.setAttribute("countPage",setCountPage());
		System.out.println("该用户的当前状态是"+status);
		if(isadmin.equals("isuser"))
			return "useshowTb";
		if(status.equals("审核未通过 请重新提交表格"))
			return "useagain1";
		if(status.equals("待开班")||status.equals("审核未通过 请重新上传开班文件"))
			return "useshowTb1";
		if(status.equals("待结业")||status.equals("审核未通过 请重新上传结业文件"))
			return "useshowTb2";
//		if(status.equals("结业"))
			return "useshowTb3";
		}
		
	
	


	@Action(value = "/showTbList" , results = { 
			@Result(name = "useshowTb", location = "/usehistory.jsp"),
			@Result(name = "useagain1", location = "/usetable.jsp"),
			@Result(name = "useshowTb1", location = "/userapplication1.jsp"),
			@Result(name = "useshowTb2", location = "/userapplication2.jsp"),
			@Result(name = "useshowTb3", location = "/userapplication3.jsp")
		})
		public String showTbList() throws UnsupportedEncodingException{
		 request = ServletActionContext.getRequest(); 
     	  response = ServletActionContext.getResponse(); 
     	  response.setContentType("text/html;charset=UTF-8");
     	  request.setCharacterEncoding("UTF-8");
     	  response.setCharacterEncoding ("UTF-8");
     	 String id = request.getParameter("id");
     	 System.out.println("id是:"+id);
		System.out.println("进入findAll。。。");
		
		TbInfo tbInfo2 = tbInfoService.findTbInfoById(Integer.parseInt(id));
		System.out.println(tbInfo2.getStatuss());
		status = tbInfo2.getStatuss();
		request.setAttribute("tbInfo", tbInfo2);
		System.out.println("该用户的当前状态是"+status);
		if(isadmin.equals("isuser"))
			return "useshowTb";
		if(status.equals("审核未通过 请重新提交表格"))
			return "useagain1";
		if(status.equals("待开班")||status.equals("审核未通过 请重新上传开班文件"))
			return "useshowTb1";
		if(status.equals("待审核")||status.equals("审核未通过 请重新上传结业文件"))
			return "useshowTb2";
//		if(status.equals("结业"))
		String path = ServletActionContext.getServletContext()
                .getRealPath("/uploads")
                + "/" + (String)request.getSession().getAttribute("userInfo"); // 路径
		         File f = new File(path);
		       
		         File fa[] = f.listFiles();
		         List<String> aList=new ArrayList<String>();
		         for (int i = 0; i < fa.length; i++) {
		             File fs = fa[i];
		             aList.add(fs.getName());
		             if (fs.isDirectory()) {
		                 System.out.println(fs.getName() + " [目录]");
		             } else {
		                 System.out.println(fs.getName());
		             }
		             
		        }request.setAttribute("fa", aList);
			return "useshowTb3";
		}
	
	private String isfinance="111";
	
	public String getIsfinance() {
		return isfinance;
	}

	public void setIsfinance(String isfinance) {
		this.isfinance = isfinance;
	}

	@Action(value = "/adminshowTb" , results = { 
			@Result(name = "financeshowTb", location = "/financemanage.jsp"),
			@Result(name = "historyshowTb", location = "/managehistory.jsp"),
			@Result(name = "projectaudit", location = "/projectaudit.jsp")
		})
		public String adminshowTb(){
			request = ServletActionContext.getRequest();  
			strPageNum =request.getParameter("currentlyPage");
			if(strPageNum==null){
				currentlyPage=1;
			}
			else{
				currentlyPage = Integer.parseInt(strPageNum);
			 System.out.println("当前页" + currentlyPage);}
		List<TbInfo> tbInfo = tbInfoService.adminfind(null, currentlyPage, PAGEROW);
		countRow=tbInfoService.admincount();
		System.out.println("共有项目信息"+countRow+"条");
		System.out.println("vvvvvvv"+countRow);

		int j=(currentlyPage-1)*PAGEROW+1;
		for(int i = 0; i < tbInfo.size(); i++)  
	    {  
			
			tbInfo.get(i).setNumber(j);
			System.out.println("jjjj"+j);
	        j++; 
	        String s=(new SimpleDateFormat("yyyy-MM-dd")).format(tbInfo.get(i).getUploadTime());
	        tbInfo.get(i).setUploadTime2(s);
	        System.out.println("完成日期转化");
	    }  	
		request.setAttribute("tbInfo", tbInfo);
		request.setAttribute("currentlyPage", currentlyPage);
		request.setAttribute("countPage",setCountPage());
		if(isfinance.equals("history"))
			return "historyshowTb";
		if(isfinance.equals("isfinance"))
				return "financeshowTb";
					return "projectaudit";
		}
	
	
	
	
	
	
	@Action(value = "/setstatus" , results = { 
			@Result(name = "setstatus", location = "/financemanage.jsp")
		}
	)
    public String setstatus() throws Exception {
		
		  request = ServletActionContext.getRequest(); 
      	  response = ServletActionContext.getResponse(); 
      	  response.setContentType("text/html;charset=UTF-8");
      	  request.setCharacterEncoding("UTF-8");
      	  response.setCharacterEncoding ("UTF-8");
      	  System.out.println("状态"+status+"button的值"+button);
      	  if(button.equals("1"))
      	{if(status.equals("tostatus2"))
      		status="待开班";
      	if(status.equals("tostatus3"))
      		status="待审核";
      	if(status.equals("tostatus4"))
      		status="结业";}
      	  
      	if(button.equals("2"))
      	{if(status.equals("tostatus2"))
      		status="审核未通过 请重新提交表格";
      	else
      		status="审核未通过 请重新上传文件";}
      	String id =request.getParameter("id");
      	TbInfo tbInfo = tbInfoService.findTbInfoById(Integer.parseInt(id));
      	tbInfo.setUploadTime(new Date());
      	tbInfo.setStatuss(status);
      	tbInfoService.updateTbInfo(tbInfo);
//      	System.out.println("更新后的tbinfo"+tbInfo.getStatuss());
		  PrintWriter out = response.getWriter();
		  out.println("<script language = javascript>alert('审核成功');");
		  out.println("location.href='TbInfoAction/adminshowTb.do'</script>");
		  out.close();
		  return null;
	}
	
	@Action(value = "/specificTb" , results = { 
			@Result(name = "specificTb1", location = "/examineproject1.jsp"),
			@Result(name = "specificTb2", location = "/examineproject2.jsp"),
			@Result(name = "specificTb3", location = "/examineproject3.jsp"),
			@Result(name = "specificTb4", location = "/manageprojectindex.jsp")
			
	})
	public String specificTb(){
		
		request = ServletActionContext.getRequest(); 
		String id =request.getParameter("id");
		System.out.println(id);
		TbInfo tbInfo = tbInfoService.findTbInfoById(Integer.parseInt(id));
		
        tbInfo.setUploadTime2(new SimpleDateFormat("yyyy-MM-dd").format(tbInfo.getUploadTime()));
        tbInfo.setStarttime2(new SimpleDateFormat("yyyy-MM-dd").format(tbInfo.getStarttime()));
        tbInfo.setEndtime2(new SimpleDateFormat("yyyy-MM-dd").format(tbInfo.getEndtime()));
		request.setAttribute("tbInfo", tbInfo);
		
		if(tbInfo.getStatuss().equals("待开班"))
		return "specificTb1";
		if(tbInfo.getStatuss().equals("待审核"))
			return "specificTb2";
		if(tbInfo.getStatuss().equals("结业"))
		return "specificTb3";
			return "specificTb4";
	}
	
	
	@Override
	public TbInfo getModel() {
		// TODO Auto-generated method stub
		if (tbInfo == null) {
			tbInfo = new TbInfo();
		}
		return tbInfo;
	}  
	
	
}
