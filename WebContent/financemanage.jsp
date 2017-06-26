<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>财务管理</title>
    <!--<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!--<link rel="stylesheet" href="css/bootstrap-responsive.min.css">-->
    <link rel="stylesheet" href="css/style.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.4.js"></script>
    <script src="https://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
</script>
    <script> 
//     $(document).ready(function(){
//     	$(function(){
//     	    $("input:button").click(function() {
//     	        str = $(this).val()=="编辑"?"确定":"编辑";  
//     	        $(this).val(str);   // 按钮被点击后，在“编辑”和“确定”之间切换
//     	        $(this).parent().siblings("td").each(function() {  // 获取当前行的其他单元格
//     	            obj_text = $(this).find("input:text");    // 判断单元格下是否有文本框
//     	          /*   if(!obj_text.length)   // 如果没有文本框，则添加文本框使之可以编辑
//     	                $(this).html("<input type='text' value='"+$(this).text()+"'>");
//     	            else   // 如果已经存在文本框，则将其显示为文本框修改的值
//     	                $(this).html(obj_text.val());  */
    	                
//     	            $(".input-xlarge").attr("readonly",false);
//     	    		  $(".input-xlarge").attr("readonly",false);
//     	        });
//     	    });
//     	}); 
    /* 	
    	$("input").click(function(){
    		var name = $(this).val(); 
  		  if(name == "编辑") 
  		 
    		});*/
    	 
    	
//     	}); 
    	  
    	  function bianji(obj){
    		  $("#"+obj).hide();//隐藏
    		  $("#"+obj+obj+obj+obj).removeAttr("disabled");//隐藏
    		  $("#"+obj+obj).attr("readonly",false);
    		  $("#"+obj+obj+obj).attr("readonly",false);
    	  }
    	
  
    </script>
    
   
    
    
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="img-mindle">
        <img src="image/7.png">
        <!--<p style="color: white;font-size: 42px;padding-top: 60px;margin-left: 80px;">成教管理系统</p>-->
    </div>
</nav>
<div class="left">
    <div class="bs-example">
        <ul class="nav nav-pills nav-stacked" role="tablist" style="background-color: white">
            <li style="padding-top: 20px;padding-left: 20px">
                <p style="font-size: 18px">超级管理员   <a href="" style="font-size: 14px">注销</a></p>
            </li>
            <li role="presentation"><a href="adminuploadinform.jsp">发布公告</a></li>
            <li role="presentation"><a href="informAction/findAll.do?isadmin=isadmin">公告管理</a></li>
            <li role="presentation"><a href="TbInfoAction/adminshowTb.do">项目审核</a></li>
            <li role="presentation"><a href="TbInfoAction/adminshowTb.do?isfinance=history">历史记录</a></li>
            <li role="presentation"><a href="TbInfoAction/adminshowTb.do?isfinance=isfinance">财务管理</a></li>
        </ul>
    </div>
</div>

<div class="right">
    <div class="bs-docs-example centent">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>编号</th>
                <th>项目名</th>
                <th>发布时间</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
                <s:iterator var="tbInfo" value="#request.tbInfo">
             <form id="formId" class="form-horizontal" action="changefinance.do" enctype="multipart/form-data" method="post" >
             
           
            <tr>
                <td bgcolor="#FFFFFF"><s:property value="#tbInfo.number"/></td>
                <td bgcolor="#FFFFFF"><a href="TbInfoAction/showTb.do?isadmin=isuser&id=<s:property value="#tbInfo.id"/>"><s:property value="#tbInfo.pname"/></a></td>
                <td bgcolor="#FFFFFF"><s:property value="#tbInfo.uploadTime2"/></td>
                <td bgcolor="#FFFFFF"><s:property value="#tbInfo.statuss"/></td>
            </tr>
            
            <tr>
	                <td>
	                    <div  class="controls" style="width: 100%">
	                        <label class="control-label" >经费总额:</label>
	                        <div class="textarea">
	                        	<input id ="s" type="hidden" name="id" value="<s:property value="#tbInfo.id"/>">
	                            <input  id="<s:property value="#tbInfo.id"/><s:property value="#tbInfo.id"/>"  value="<s:property value="#tbInfo.totalfund"/>" name="totalfund" type="text"  placeholder="待设置*" class="input-xlarge " readonly="readonly"></input>
	                        </div>
	                    </div>
	                </td>
	                <td>
	                    <label class="control-label">剩余经费:</label>
	                    <div class="controls">
	                        <div class="textarea">
	                            <input  id="<s:property value="#tbInfo.id"/><s:property value="#tbInfo.id"/><s:property value="#tbInfo.id"/>" value="<s:property value="#tbInfo.surplusfunds"/>" name="surplusfunds" type="text"  placeholder="待设置*" class="input-xlarge " readonly="readonly">
	                        </div>
	                    </div>
	                </td>
	              
               
                <td >
                    <input id="<s:property value="#tbInfo.id"/>" type="button" class="btn btn-danger"   value="编辑" onclick="bianji('<s:property value="#tbInfo.id"/>')" ></button>
                </td>
                    <td>
                    <input id="<s:property value="#tbInfo.id"/><s:property value="#tbInfo.id"/><s:property value="#tbInfo.id"/><s:property value="#tbInfo.id"/>" type="submit" class="btn btn-danger"   value="保存" disabled="disabled"  ></button>
                </td>
            </tr>
      
               
            
             </form>
             
              </s:iterator>	
                    
            <table width="55%" border="0" align="center" cellpadding="0" >
		   		<tr>
					<td width="15%" bgcolor="#FFFFFF">共有<s:property value="#request.countPage"/>页</td>
					<td width="15%" bgcolor="#FFFFFF">当前第<s:property value="#request.currentlyPage"/>页</td>
					
					<s:if test="#request.currentlyPage !=1">
					<td width="15%" bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/adminshowTb.do?currentlyPage=1">首页</a></td>
					<td width="15%" bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/adminshowTb.do?currentlyPage=<s:property value="#request.currentlyPage - 1"/>">上一页</a></td>
					</s:if>
					<s:if test="#request.currentlyPage != #request.countPage">
					<td width="15%" bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/adminshowTb.do?currentlyPage=<s:property value="#request.currentlyPage + 1"/>">下一页</a></td>
			<td width="15%" bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/adminshowTb.do?currentlyPage=<s:property value="#request.countPage"/>">尾页</a></td> 
					</s:if>
				</tr>
   			</table>
            
            </tbody>
        </table>
    </div>
</div>

<div id="footer" class="footer">
    <p class="ft-copy">Copyright ©2016 Corporation, All Rights Reserved</p>
    <p>baicai　<a href="">版权所有</a>　<a href="" target="_blank">京ICP证</a></p>
</div>
</body>
</html>