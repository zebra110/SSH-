<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!--首页的框架模板包括head-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>宁波大红鹰学院成教管理系统</title>
    <!--<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!--<link rel="stylesheet" href="css/bootstrap-responsive.min.css">-->
    <link rel="stylesheet" href="css/style.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
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
                    <p style="font-size: 18px">成教学院   <a href="index.jsp" style="font-size: 14px">注销</a></p>
                </li>
                <li role="presentation"><a href="useindex.jsp">公告</a></li>
                <li role="presentation"><a href="usetable.jsp">填表</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/showTb.do?isadmin=isuser">历史记录</a></li>
            </ul>
        </div>
    </div>
    

<body>

	<div class="right">
    <div class="bs-docs-example centent">
        <form class="form-horizontal">
            <fieldset>
                <div id="legend" class="">
                    <legend class="">结业</legend>
                </div>

                <div class="bs-docs-example">
                    <table class="table">
                            <tr>
                                <td bgcolor="#FFFFFF"><s:property value="#tbInfo.number"/></td>
				                <td bgcolor="#FFFFFF"><a href="TbInfoAction/specificTb.do?id=<s:property value="#tbInfo.id"/>"><s:property value="#tbInfo.pname"/></a></td>
				                <td bgcolor="#FFFFFF"><s:property value="#tbInfo.uploadTime2"/></td>
				                <td bgcolor="#FFFFFF"><s:property value="#tbInfo.statuss"/></td>
                            </tr>
                    </table>
                </div>

                <div class="control-group">
                    <label class="control-label">所有文件:</label>
                   <s:iterator var="fa" value="#request.fa">
				
			  <tr bgcolor="#FFFFFF"><s:property value="#fa"/></br>
			  
			 	</tr>
		</s:iterator>	
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