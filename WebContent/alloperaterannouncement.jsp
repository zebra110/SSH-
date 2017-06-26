<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%String Username="";
String password="";
//取出Cookie
Cookie[] c=request.getCookies();
for(int i=0;i<c.length;i++){
    if(c[i].getName().equals("users")){
        //存着数据（用户名+密码）
        Username=c[i].getValue().split("-")[0];
        password=c[i].getValue().split("-")[1];
        
        //再一次的存起来（备用）
        request.setAttribute("xingming",Username);
        request.setAttribute("mima", password);
    }
}
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
        <div class="left centent">
            <h2 style="">个人中心</h2>
           <form class="form-horizontal" action="${pageContext.request.contextPath}/cookie.do" method="post">
                <div class="control-group">
                    <label>用户名</label>
                    <input type="text" placeholder="Email" name="username" value="${xingming}">
                    
                </div>
                <div class="control-group">
                    <label>密码</label>
                    <input type="password" id="inputPassword" name ="password" placeholder="Password" value="${mima}">
                	   </div>
                <div class="">
                   	<input type="checkbox" name="ck" <%if(!Username.equals("")) out.println("checked='checked'");%>>记住我<br>
                </div>
                <div class="control-group">
                    <div class="">
                        <button type="submit" class="btn">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

<div class="right">
    <div class="bs-docs-example centent">
        <form class="form-horizontal">
            <fieldset>
            	
                
               
                <div id="legend" class="">
                    <legend class="">发布名:<s:property value="#request.inform1.title"/></legend>
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