
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
    <title>公告</title>
     <base href="<%=basePath%>">
    <!--<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!--<link rel="stylesheet" href="css/bootstrap-responsive.min.css">-->
    <link rel="stylesheet" href="css/style.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.4.js"></script>
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
            <li role="presentation"><a href="Create%20announcement.html">发布公告</a></li>
            <li role="presentation"><a href="index.html">公告管理</a></li>
            <li role="presentation"><a href="">项目审核</a></li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/showTb.do?isadmin=isadmin">历史记录</a></li>
            <li role="presentation"><a href="TbInfoAction/adminshowTb.do">财务管理</a></li>
        </ul>
    </div>
</div>

<div class="right">
    <div class="bs-docs-example centent">
        <form class="form-horizontal">
            <fieldset>
                <div id="legend" class="">
                    <legend class=""><s:property value="#request.inform1.title"/></legend>
                </div>
                <div class="control-group">
                    <p style="text-indent: 2em" "><s:property value="#request.inform1.content"/></p>
                </div>
                    <div class="control-group">
                    <label class="control-label">附件下载:</label>
                    <!-- File Upload -->
	                    <div class="controls" >
	                    <s:url value="down/download.do" var="url">
						<s:param name="downloadFileName" value="#request.inform1.pictureName"></s:param>
						<s:property value="#request.inform1.pictureName"/>
						</s:url>
						<a href="${url}">点击下载</a>
	                    </div>
	                    
                </div>
            </fieldset>
        </form>
    </div>
</div>

<div id="footer" class="footer">
    <p class="ft-copy">Copyright ©2016 Corporation, All Rights Reserved</p>
    <p>baicai　<a href="">版权所有</a>　<a href="" target="_blank">京ICP证</a></p>
</div>
</body>
</html>