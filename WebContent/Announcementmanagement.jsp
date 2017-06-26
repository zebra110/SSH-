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
    <title>用户填表</title>
    <!--<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!--<link rel="stylesheet" href="css/bootstrap-responsive.min.css">-->
    <link rel="stylesheet" href="css/style.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.4.js"></script>
    <script type="text/javascript"> 
	function del(){ 
	if(!confirm("确认要删除？")){ 
	window.event.returnValue = false; 
	} 
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
		          <th>公告编号</th>
		          <th>公告名</th>
		          <th>发布时间</th>
		      	  <th>可执行操作</th>
		        </tr>
	        <thead>
		
		<s:iterator var="inform" value="#request.inform">
			<tr align="center">
			  <td bgcolor="#FFFFFF"><s:property value="#inform.number"/></td>
			<td bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/informAction/showInform.do?operate=adminlook&id=<s:property value="#inform.id"/>"><s:property value="#inform.title"/></a></td>
			  <td bgcolor="#FFFFFF"><s:property value="#inform.uploadTime2"/> </td>
			  <td><a href="${pageContext.request.contextPath}/informAction/showInform.do?operate=modify&id=<s:property value="#inform.id"/>">修改</a></a>
			  <!-- <a href="deleteInform.jsp">删除</a> -->
			   
			          <s:url value="informAction/deleteInform.do" var="url">
						<%-- <s:param name="deleteobject" value="#request.inform"></s:param> --%>
						
						</s:url>
						<!--  <a href="${url}?isadmin=isadmin">公告管理</a>-->
 <a href="${url}?deleteobjectid=<s:property value="#inform.id"/>" onclick="return del()">删除</a>

 
 
			<!--    <a href="javascript:if(confirm('确实要删除吗?'))location=${url}?deleteobjectid=<s:property value="#inform.id"/>">删除</a>-->
			  </td>
			  
			 	</tr>
		</s:iterator>	
	 
	</table>
		   
			<table width="55%" border="0" align="center" cellpadding="0" >
		   		<tr>
					<td width="15%" bgcolor="#FFFFFF">共有<s:property value="#request.countPage"/>页</td>
					<td width="15%" bgcolor="#FFFFFF">当前第<s:property value="#request.currentlyPage"/>页</td>
					
					<s:if test="#request.currentlyPage !=1">
					<td width="15%" bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/informAction/findAll.do?isadmin=isadmin&currentlyPage=1">首页</a></td>
					<td width="15%" bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/informAction/findAll.do?isadmin=isadmin&currentlyPage=<s:property value="#request.currentlyPage - 1"/>">上一页</a></td>
					</s:if>
					<s:if test="#request.currentlyPage != #request.countPage">
					<td width="15%" bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/informAction/findAll.do?isadmin=isadmin&currentlyPage=<s:property value="#request.currentlyPage + 1"/>">下一页</a></td>
			<td width="15%" bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/informAction/findAll.do?isadmin=isadmin&currentlyPage=<s:property value="#request.countPage"/>">尾页</a></td> 
					</s:if>
				</tr>
   			</table>
	
        </div>
    </div>
    <div id="footer" class="footer">
        <p class="ft-copy">Copyright ©2016 Corporation, All Rights Reserved</p>
        <p>baicai　<a href="">版权所有</a>　<a href="" target="_blank">京ICP证</a></p>
    </div>
</body>
</html>