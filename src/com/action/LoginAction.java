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
       
        //��ѡ�е�״̬��on û�б�ѡ�е�״̬����null
        if("on".equals(ck)){
        //����Cookie����
        //��ӵ�Cookie��
        Cookie c=new Cookie("users", user.getUsername()+"-"+user.getPassword());
        
        //���ù���ʱ��
        c.setMaxAge(6000);
        
        //�洢
        response.addCookie(c);
     
    }
        
		User user1 = userService.login(user);
//		session.setAttribute("userInfo",(Object)user1);
//		System.out.println("�ǲ��ǹ���Ա"+user1.getIsAdmin());
		if (user1 == null) {
			response.setCharacterEncoding ("UTF-8");
//			response.getWriter().write("alert(��Ǹ!���Ǳ�ϵͳ�û�!)");

			PrintWriter out = response.getWriter();
			out.println("<script language = javascript>alert('��Ǹ!���Ǳ�ϵͳ�û�!')");
			out.println("location.href='index.jsp'</script>");
			out.close();
			return null;
		}
		
		if (user1.getIsAdmin().equals("0")) {
			System.out.println("�ǲ��ǹ���Ա"+user1.getIsAdmin());
			request.getSession().setAttribute("userInfo", user1.getUsername());
			System.out.println("user1��"+user1.getUsername());
			System.out.println("senssion��"+(String)request.getSession().getAttribute("userInfo"));
			return "usefindAll";
		}
		return "success1";
       
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		System.out.println("����ģ������");
		if (user == null) {
			user = new User();
		}
		return user;
	}
}
