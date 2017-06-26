package com.action;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.domain.Inform;
import com.domain.TbInfo;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.InformService;
import com.service.TbInfoService;  

//@Controller
//@ParentPackage("struts-default") 
@Namespace(value = "/")
//@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })  
public class uploadAction2 extends ActionSupport {   
 
	// <s:file label="上传文件：" name="upload"></s:file>
    private File[] upload;// 命名应该和上传页面name属性值保持一致
    private String[] uploadContentType;// 属性值+ContentType
    private String[] uploadFileName;// 属性值+FielName
    
    private HttpServletRequest request;
	private HttpServletResponse response;

    public void setUpload(File[] upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String[] uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String upload() throws IOException {
    	 request = ServletActionContext.getRequest(); 
        for (int i = 0; i < upload.length; i++) {
            File destFile = new File(ServletActionContext.getServletContext()
                    .getRealPath("/uploads")
                    + "/" + (String)request.getSession().getAttribute("userInfo") + "/"+uploadFileName[i]);
            
          String userinfo = (String)request.getSession().getAttribute("userInfo");
          System.out.println(userinfo);
            try {
                // 工具类
                FileUtils.copyFile(upload[i], destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        request = ServletActionContext.getRequest(); 
      	  response = ServletActionContext.getResponse(); 
      	  response.setContentType("text/html;charset=UTF-8");
      	  request.setCharacterEncoding("UTF-8");
      	  response.setCharacterEncoding ("UTF-8");
        PrintWriter out = response.getWriter();
		out.println("<script language = javascript>alert('文件上传成功!')");
		out.println("location.href='http://localhost:8080/IMSssh/usehistory.jsp'</script>");
		out.close();
		return null;
    }
        	    
     } 
