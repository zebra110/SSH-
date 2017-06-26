package com.action;

import com.domain.Inform;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.AdminService;
import com.service.InformService;
import com.service.UserService;
import com.sun.net.httpserver.Authenticator.Success;
import com.sun.org.apache.bcel.internal.generic.NEW;

import sun.misc.Request;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
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
import org.hibernate.sql.Delete;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.tiles2.SpringWildcardServletTilesApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private User user = null;
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unused")
	public  String cookie() throws IOException{
 
		request = ServletActionContext.getRequest(); 
		response = ServletActionContext.getResponse(); 
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String ck=request.getParameter("ck");
       
        //被选中的状态是on 没有被选中的状态下是null
        if("on".equals(ck)){
        //构造Cookie对象
        //添加到Cookie中
        Cookie c=new Cookie("users", user.getUsername()+"-"+user.getPassword());
        
        //设置过期时间
        c.setMaxAge(6000);
        
        //存储
        response.addCookie(c);
     
    }
        
		User user1 = userService.login(user);
//		session.setAttribute("userInfo",(Object)user1);
//		System.out.println("是不是管理员"+user1.getIsAdmin());
		if (user1 == null) {
			response.setCharacterEncoding ("UTF-8");
//			response.getWriter().write("alert(抱歉!您非本系统用户!)");

			PrintWriter out = response.getWriter();
			out.println("<script language = javascript>alert('抱歉!您非本系统用户!')");
			out.println("location.href='index.jsp'</script>");
			out.close();
			return null;
		}
		
		if (user1.getIsAdmin().equals("0")) {
			System.out.println("是不是管理员"+user1.getIsAdmin());
			request.getSession().setAttribute("userInfo", user1.getUsername());
			System.out.println("user1中"+user1.getUsername());
			System.out.println("senssion中"+(String)request.getSession().getAttribute("userInfo"));
			return "usefindAll";
		}
		return "success1";
       
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		System.out.println("进入模型驱动");
		if (user == null) {
			user = new User();
		}
		return user;
	}
}
