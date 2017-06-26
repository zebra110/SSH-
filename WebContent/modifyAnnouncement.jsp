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
    <title>发布公告</title>
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
                <p style="font-size: 18px">超级管理员  <a href="" style="font-size: 14px">注销</a></p>
            </li>
            <li role="presentation"><a href="adminuploadinform.jsp">发布公告</a></li>
            <li role="presentation"><a href="informAction/findAll.do?isadmin=isadmin">公告管理</a></li>
            <li role="presentation"><a href="TbInfoAction/adminshowTb.do">项目审核</a></li>
            <li role="presentation"><a href="TbInfoAction/adminshowTb.do?isfinance=history">历史记录</a></li>
            <li role="presentation"><a href="TbInfoAction/adminshowTb.do?isfinance=isfinance">财务管理</a></li>
        </ul>
    </div>
</div>

</div>

<div class="right">
    <div class="bs-docs-example centent">
     <form class="form-horizontal" action="${pageContext.request.contextPath}/informAction/modifyInform.do" method="post"  enctype="multipart/form-data">
    
                <fieldset>
                <%-- <a href="${pageContext.request.contextPath}/informAction/findAll.do?isadmin=isadmin">返回</a>
                --%>
                 <div id="legend" class="">
                   <legend class="">修改公告</legend>
                </div>
                
                <input type="hidden" name="id" value="${requestScope.inform1.id}">
                <div class="control-group">
                    <label class="control-label">公告标题:</label>
                    <div class="controls">
                        <input type="text" placeholder="必填*" name="title" class="input-xlarge" value="${requestScope.inform1.title}">
                    </div>
                </div>
 
                 <div class="control-group">
                    <label class="control-label">公告内容:</label>
                    <div class="controls">
                        <div class="textarea">
                            <textarea type="text" class="" name="content">${requestScope.inform1.content} </textarea>
                        </div>
                    </div>
                </div>
          
                <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button type="submit" class="btn-success">确认修改</button>
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