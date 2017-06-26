<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>用户填表</title>
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.4.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>
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

    <div class="right">
        <div class="bs-docs-example centent">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/saveTb.do" method="post"  >
                <fieldset>
                    <div id="legend" class="">
                        <legend class="">宁波大红鹰学院非学历教育培训申请表</legend>
                    </div>
                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">培训项目名称:</label>
                        <div class="controls">
                            <input type="text" name="pname" placeholder="必填*" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">办班单位:</label>
                        <div class="controls">
                            <input type="text" name="office" placeholder="必填*" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">联系人:</label>
                        <div class="controls">
                            <input type="text" name="linkman" placeholder="必填*" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">联系电话:</label>
                        <div class="controls">
                            <input type="text" name="linknum" placeholder="必填*" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">政府委托项目:</label>
                        <div class="controls">
                            <!-- Inline Radios -->
                            <label class="radio inline">
                                <input type="radio" name="isGovernmentcommissionedprojects" value="1" checked="checked" >
                                是
                            </label>
                            <label class="radio inline">
                                <input type="radio" name="isGovernmentcommissionedprojects" value="2" >
                                否
                            </label>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">培训对象:</label>
                        <div class="controls">
                            <!-- Inline Radios -->
                            <label class="radio inline">
                                <input type="radio" name="trainees" value="1" checked="checked">
                                社会人员
                            </label>
                            <label class="radio inline">
                                <input type="radio" name="trainees" value="2" >
                                本校在校生
                            </label>
                        </div>
                    </div>

				   <div class="control-group">
                        <label class="control-label">校外人员需要进入校园:</label>
                        <div class="controls">
                            <!-- Inline Radios -->
                            <label class="radio inline">
                                <input type="radio" name="isOutofschoolpersonnelneedtoenterthecampus" value="1" checked="checked" >
                                是
                            </label>
                            <label class="radio inline">
                                <input type="radio" name="isOutofschoolpersonnelneedtoenterthecampus" value="2" >
                                否
                            </label>
                        </div>
                    </div>
                    
                   
                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">合作单位</label>
                        <div class="controls">
                            <input type="text" name="partner" placeholder="必填*" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Textarea -->
                        <label class="control-label">培训内容</label>
                        <div class="controls">
                            <div class="textarea">
                                <textarea name="content" type="text" class=""> </textarea>
                            </div>
                        </div>
                    </div>

                      <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">计划开始时间</label>
                        <div class="controls">
                            <div class="input-append date form_datetime" data-date="2013-02-21">
                                <input name="starttime" class="input-xlarge add-on" type="text" id="datetimepicker" value="" readonly>
                                <span class="add-on"><i class="icon-calendar"></i></span>
                            </div>

                            <script type="text/javascript">
                            $(".form_datetime").datetimepicker({
                                format: "yyyy-mm-dd",
                                lang:"ch",           //语言选择中文
                                minView: "month",
                                timePicker:false,    //关闭时间选项
                                yearStart:2016,     //设置最小年份
                                yearEnd:2150,        //设置最大年份
                                todayButton:true,    //关闭选择今天按钮
                                autoclose: true,
                                startDate: "2016-12-1"
                            });

                            </script>
                        </div>
                    </div>

                    
                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">计划结束时间</label>
                        <div class="controls">
                            <div class="input-append date form_datetime" data-date="2013-02-21">
                                <input name="endtime" class="input-xlarge add-on" type="text" id="datetimepicker" value="" readonly>
                                <span class="add-on"><i class="icon-calendar"></i></span>
                            </div>

                            <script type="text/javascript">
                            $(".form_datetime").datetimepicker({
                                format: "yyyy-mm-dd",
                                lang:"ch",           //语言选择中文
                                minView: "month",
                                timePicker:false,    //关闭时间选项
                                yearStart:2016,     //设置最小年份
                                yearEnd:2150,        //设置最大年份
                                todayButton:true,    //关闭选择今天按钮
                                autoclose: true,
                                startDate: "2016-12-1"
                            });

                            </script>
                        </div>
                    </div>
					 
                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">计划招生人数</label>
                        <div class="controls">
                            <input type="text" name="enrollment" placeholder="必填*" class="input-xlarge">
                        </div>
                    </div>

                    <!--<label class="control-label">联系人:</label><br><br>-->
                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">培训费：</label>
                        <div class="controls">
                            <input type="text" name="trainingexpense" placeholder="收费标准（元/人）" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">代管费：</label>
                        <div class="controls">
                            <input type="text" name="escrowfee" placeholder="收费标准（元/人）" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">办班单位：</label>
                        <div class="controls">
                            <input  name="classunitPercentage" style="width: 20%;float: left" type="text" placeholder="培训费分配比例" class="input-xlarge">
                            <p style="float: left;">%，计</p>
                            <input  name="classunitmoney" style="width: 20%;float: left" type="text" placeholder="培训费分配比例" class="input-xlarge">
                            <p style="float: left;">元/人</p>
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label">合作单位：</label>
                        <div class="controls">
                            <input  name="partnerPercentage" style="width: 20%;float: left" type="text" placeholder="培训费分配比例" class="input-xlarge">
                            <p style="float: left;">%，计</p>
                            <input  name="partnermoney" style="width: 20%;float: left" type="text" placeholder="培训费分配比例" class="input-xlarge">
                            <p style="float: left;">元/人</p>
                        </div>
                        
                    </div>
            <div class="control-group">
                <!-- Button -->
	                <div class="controls">
	                    <button type="submit" class="btn-success">提交</button>
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