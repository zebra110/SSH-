package com.action;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;
import java.io.PrintWriter;
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
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.InformService;  

//@Controller
//@ParentPackage("struts-default") 
//@Namespace(value = "/uploadAction")
//@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })  
public class uploadAction extends ActionSupport implements ModelDriven<Inform>{   
 
				private HttpServletRequest request;
				private HttpServletResponse response;
				
				private Inform inform;
				
				@Autowired
				private InformService informService;
       
        	  // titlename属性用来封装用户名  
//        	    private String titlename;  
        	      
        	    private File image; //上传的文件
        	    private String imageFileName; //文件名称
        	    private String imageContentType; //文件类型

//        	    @Action(value = "/uploadFile")

        	    public String uploadFile() throws Exception {  
        	    	  String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
        	          //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
        	          System.out.println("realpath: "+realpath);
        	          if (image!= null) { 
        	              File savefile = new File(new File(realpath), imageFileName);
//        	              System.out.println("有文件");
        	              if (!savefile.getParentFile().exists())
        	                  savefile.getParentFile().mkdirs();
        	              FileUtils.copyFile(image, savefile);
        	              ActionContext.getContext().put("message", "文件上传成功");
        	              
        	              System.out.println("上傳成功");
        	          }
        	          
        	          inform.setPictureName(imageFileName);
        	  		inform.setUploadTime(new Date());
        	          informService.saveInform(inform);
        	          System.out.println(inform.getTitle());
        	          
        	          request = ServletActionContext.getRequest(); 
	      	      	  response = ServletActionContext.getResponse(); 
	      	      	  response.setContentType("text/html;charset=UTF-8");
	      	      	  request.setCharacterEncoding("UTF-8");
	      	      	  response.setCharacterEncoding ("UTF-8");
	      	      	  
	      			PrintWriter out = response.getWriter();
	    			out.println("<script language = javascript>alert('文件上传成功!')");
	    			out.println("location.href='http://localhost:8080/IMSssh/manageindex.jsp'</script>");
	    			out.close();
	    			return null;

        	    }
        	    
        	    public File getImage() {
        	        return image;
        	    }

        	    public void setImage(File image) {
        	        this.image = image;
        	    }

        	    public String getImageFileName() {
        	        return imageFileName;
        	    }

        	    public void setImageFileName(String imageFileName) {
        	        this.imageFileName = imageFileName;
        	    }

        	    public String getImageContentType() {
        	        return imageContentType;
        	    }

        	    public void setImageContentType(String imageContentType) {
        	        this.imageContentType = imageContentType;
        	    }

        	    
        	  	
//				@Override
				public Inform getModel() {
					// TODO Auto-generated method stub
					if (inform == null) {
						inform = new Inform();
					}
					return inform;
				}  
        	    
     } 
