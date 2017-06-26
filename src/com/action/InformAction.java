package com.action;

import com.domain.Inform;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qiniu.http.Response;
import com.service.AdminService;
import com.service.InformService;
import com.sun.net.httpserver.Authenticator.Success;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javassist.bytecode.Descriptor.Iterator;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import sun.misc.Request;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.sql.Delete;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.tiles2.SpringWildcardServletTilesApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller//通常作用在控制层，但是目前该功能与 @Component(是一个泛化的概念 仅仅表示一个组件 (Bean)可以作用在任何层次)相同
@ParentPackage("struts-default") 
@Namespace(value ="/informAction")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })  

public class InformAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Resource
	private InformService informService;
	private final static int PAGEROW = 3;//每页显示的行数
	private int countRow=0;//总行数
	private int countPage;//总页数
	private int currentlyPage;//当前第几页
	private String strPageNum =null;
	private  String isadmin;
	
	public int setCountPage(){
		if(countRow % PAGEROW == 0){
			countPage = (int) (countRow / PAGEROW);
		}else{
			countPage = (int) (countRow / PAGEROW + 1);
		}
		return countPage;
	}

	public String getIsadmin() {
		return isadmin;
	}



	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}


	String isuser;
		
	public String getIsuser() {
		return isuser;
	}

	public void setIsuser(String isuser) {
		this.isuser = isuser;
	}

	
	
	@Action(value = "/findAll" , results = { @Result(name = "findall", location = "/CommoIndex.jsp"),
		@Result(name = "adminfindall", location = "/Announcementmanagement.jsp"),
		@Result(name = "usefindAll", location = "/useinform.jsp"),
	})
	public String findAll(){
		System.out.println("进入findAll。。。");
		request = ServletActionContext.getRequest();  
		strPageNum =request.getParameter("currentlyPage");
		if(strPageNum==null){
			currentlyPage=1;
		}
		else{
			currentlyPage = Integer.parseInt(strPageNum);
		 System.out.println("当前页" + currentlyPage);}
	List<Inform> inform = informService.find(null, currentlyPage, PAGEROW);
	countRow=informService.count();
	System.out.println(countRow);

	int j=(currentlyPage-1)*PAGEROW+1;
//	Iterator it =  tmp.iterator();
//	while(it.hasNext()) {
//		
//    }  
	for(int i = 0; i < inform.size(); i++)  
    {  
		
		inform.get(i).setNumber(j);
		System.out.println("jjjj"+j);
		System.out.println(inform.get(i).getPictureName());
        j++; 
        String s=(new SimpleDateFormat("yyyy-MM-dd")).format(inform.get(i).getUploadTime());
        inform.get(i).setUploadTime2(s);
       
    }  	
	request.setAttribute("inform", inform);
	request.setAttribute("currentlyPage", currentlyPage);
	request.setAttribute("countPage",setCountPage());
//		ActionContext.getContext().getValueStack().push(inform);
	System.out.println("isadmin里面有没有东西呢 看->"+isadmin);
		if(isadmin==null&&isuser==null)
		return "findall";
		if(isadmin==null)
		return "usefindAll";
			return "adminfindall";
	}
	
	
	String operate="111";
	
	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	@Action(value = "/showInform" , results = { @Result(name = "showInform", location = "/alloperaterannouncement.jsp"),
			@Result(name = "useshowInform", location = "/useanounce.jsp"),
			@Result(name = "modify", location = "/modifyAnnouncement.jsp"),
			@Result(name = "adminshowInform", location = "/adminshowInform.jsp")
	})
	public String showInform(){
		
		request = ServletActionContext.getRequest(); 
		String id =request.getParameter("id");
		System.out.println(id);
		Inform inform1 = informService.findInformById(Integer.parseInt(id));
	
	        String s=(new SimpleDateFormat("yyyy-MM-dd")).format(inform1.getUploadTime());
	        inform1.setUploadTime2(s);
	       
	      	
		System.out.println(inform1.getPictureName());
		request.setAttribute("inform1", inform1);
		System.out.println("operate是什麼操作呢"+operate);
		if(operate.equals("alluser"))
			return "showInform";
		if(operate.equals("commonuser"))
			return "useshowInform";
		if(operate.equals("adminlook"))
			return "adminshowInform";
		return "modify";
		
	}
	
	Inform deleteobject;
	String deleteobjectid;
	
	

	public String getDeleteobjectid() {
		return deleteobjectid;
	}

	public void setDeleteobjectid(String deleteobjectid) {
		this.deleteobjectid = deleteobjectid;
	}

	public void setDeleteobject(Inform deleteobject) {
		this.deleteobject = deleteobject;
	}

	@Action(value = "/deleteInform" , results = { @Result(name = "deleteInform", location = "/manageindex.jsp")
	})
	public String deleteInform() throws IOException{
		response = ServletActionContext.getResponse(); 
		System.out.println("进入delete action");
		request = ServletActionContext.getRequest(); 
		String title =request.getParameter("title");
		String content =request.getParameter("content");
		System.out.println("要删除的对象的id是"+deleteobjectid);
		deleteobject=informService.findInformById(Integer.parseInt(deleteobjectid));
		informService.deleteInform(deleteobject);
//		PrintWriter out = response.getWriter();
//		out.println("<script language = javascript>alert('删除成功!');");
//		out.println("location.href='Announcementmanagement.jsp'</script>");
//		out.close();
		
//		List<Inform> inform1 = informService.find(null, currentlyPage, PAGEROW);
//		isadmin="isadmin";
//		findAll();
		return "deleteInform";
	}
	
	
	String modifyobjectid;
	Inform modifyobject;
	
	public String getModifyobjectid() {
		return modifyobjectid;
	}

	public void setModifyobjectid(String modifyobjectid) {
		this.modifyobjectid = modifyobjectid;
	}

	@Action(value = "/modifyInform" , results = { @Result(name = "modifyInform", location = "/manageindex.jsp")
	})
	public String modifyInform() throws IOException{
		response = ServletActionContext.getResponse(); 
		System.out.println("进入modify action");
		request = ServletActionContext.getRequest(); 
		String modifyobjectid =request.getParameter("id");
		String title =request.getParameter("title");
		String content =request.getParameter("content");
		Inform inform=informService.findInformById(Integer.parseInt(modifyobjectid));
		inform.setContent(content);
		inform.setUploadTime(new Date());
		inform.setTitle(title);
		informService.updateInform(inform);
//		PrintWriter out = response.getWriter();
//		out.println("<script language = javascript>alert('修改成功!');");
//		out.println("location.href='Announcementmanagement.jsp'</script>");
//		out.close();
		
//		List<Inform> inform1 = informService.find(null, currentlyPage, PAGEROW);
//		isadmin="isadmin";
//		findAll();
		return "modifyInform";
	}
	
	
	
}
