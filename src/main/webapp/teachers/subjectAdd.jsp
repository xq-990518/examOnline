<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Shamcey - Metro Style Admin Template</title>

    <link rel="stylesheet" href="<%=path%>/css/style.default.css" type="text/css"/>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-fileupload.min.css" type="text/css"/>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-timepicker.min.css" type="text/css"/>


    <script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-migrate-1.1.1.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/bootstrap-fileupload.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/bootstrap-timepicker.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.tagsinput.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.autogrow-textarea.js"></script>
    <script type="text/javascript" src="<%=path%>/js/charCount.js"></script>
    <script type="text/javascript" src="<%=path%>/js/colorpicker.js"></script>
    <script type="text/javascript" src="<%=path%>/js/ui.spinner.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/chosen.jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/custom.js"></script>
    <script type="text/javascript" src="<%=path%>/js/forms.js"></script>
</head>
<title>老师登陆成功</title>
<body>
<c:if test="${! empty tip }">
    <script>
        alert("${tip}");
    </script>
</c:if>
<div class="mainwrapper">

    <div class="mainwrapper">
        <div class="header">
            <div class="logo">
                <a href="<%=path %>/teachers/teacher.jsp"><img src="<%=path %>/images/logo.png" alt=""/></a>
            </div>
            <div class="headerinner">
                <ul class="headmenu">

                    <li class="right">
                        <div class="userloggedinfo">
                            <img src="<%=path %>/images/photos/thumb1.png" alt=""/>
                            <div class="userinfo">
                                <h5>${teacher.t_Name} <small>you are welcome</small></h5>
                                <ul>
                                    <li><a href="<%=path %>/login.jsp">退出登录</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul><!--headmenu-->
            </div>
        </div>


        <div class="leftpanel" style="margin-left: 0px;">
            <%--待更改--%>
                <div class="leftmenu">
                    <ul class="nav nav-tabs nav-stacked">
                        <li class="nav-header">Navigation</li>
                        <li class="dropdown"><a href=""><span class="iconfa-briefcase"></span> 班级管理</a>
                            <ul>
                                <li><a href="<%=path %>/showAllTClass?t_id=${teacher.t_id}&pageNo=0">查询所有班级</a></li><%----%>
                            </ul>
                        </li>
                        <li class="dropdown active"><a href=""><span class="iconfa-briefcase"></span> 试题管理</a>
                            <ul>
                                <li><a href="<%=path %>/teachers/subjectAdd.jsp">添加试题</a></li>
                                <li><a href="<%=path %>/QueryQuestion?s_id=${teacher.subject.subject_id}&pageNo=0">查询所有试题</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a href=""><span class="iconfa-pencil"></span> 试卷管理</a>
                            <ul>
                                <li><a href="<%=path %>/teachers/ExamAdd.jsp">生成试卷</a></li>
                                <li><a href="<%=path %>/TeacherExamQuery?pageNo=0&s_id=${teacher.subject.subject_id}">查询所有试卷</a></li><%----%>
                            </ul>
                        </li>
                    </ul>
                </div><!--leftmenu-->

        </div><!-- leftpanel -->

        <div class="rightpanel">

            <ul class="breadcrumbs">
                <li><a href="<%=path %>/teachers/teacher.jsp"><i class="iconfa-home"></i></a> <span
                        class="separator"></span>
                </li>
                <li>试题管理<span class="separator"></span></li>
                <li>修改试题</li>

                <li class="right">
                    <a href="" data-toggle="dropdown" class="dropdown-toggle"><i class="icon-tint"></i> Color Skins</a>
                    <ul class="dropdown-menu pull-right skin-color">
                        <li><a href="default">Default</a></li>
                        <li><a href="navyblue">Navy Blue</a></li>
                        <li><a href="palegreen">Pale Green</a></li>
                        <li><a href="red">Red</a></li>
                        <li><a href="green">Green</a></li>
                        <li><a href="brown">Brown</a></li>
                    </ul>
                </li>
            </ul>
            <div class="maincontent" style="">
                <div class="maincontentinner">
                    <div class="widget">
                        <h4 class="widgettitle">试题编辑</h4>
                        <div class="widgetcontent">
                            <form class="stdform" action="teacherQuestionAdd" method="post">

                                <p>
                                    <label>试题题目</label>
                                    <span class="field">
						 <textarea name="QueName" cols="80" rows="5"
                                   class="span5"></textarea>
						 </span>
                                </p>
                                <p>
                                    <label>选项A:</label>
                                    <span class="field"><input type="text" name="optionA" class="input-large"
                                                               placeholder="选项A"></span>
                                </p>
                                <p>
                                    <label>选项B:</label>
                                    <span class="field"><input type="text" name="optionB" class="input-large"
                                                               placeholder="选项B"></span>
                                </p>
                                <p>
                                    <label>选项C:</label>
                                    <span class="field"><input type="text" name="optionC" class="input-large"
                                                               placeholder="选项C"></span>
                                </p>
                                <p>
                                    <label>选项D:</label>
                                    <span class="field"><input type="text" name="optionD" class="input-large"
                                                               placeholder="选项D"></span>
                                </p>
                                <p id="checkmany">
                                    <label>答案</label>
                                    <input name="answer" class="answer" type="checkbox"  value="A" checked="checked"/>A
                                    <input name="answer" class="answer"  type="checkbox" value="B"/>B
                                    <input name="answer" class="answer"  type="checkbox" value="C"/>C
                                    <input name="answer" class="answer"  type="checkbox" value="D"/>D
                                </p>

                                <p>
                                    <label>试题解析</label>
                                    <span class="field"><textarea cols="80" name="stParse" rows="5"
                                                                  class="span5"></textarea></span>
                                </p>
                                <p>
                                    <label>分值:</label>
                                    <span class="field"><input type="text" name="mark" class="input-large"
                                                               placeholder="分值"></span>
                                </p>
                                <p class="stdformbutton">
                                    <input type="submit" class="btn btn-primary" id="add" value="录入">
                                    <input type="reset" class="btn btn-primary" value="重置">
                                </p>
                                <p>
                                    <input type="hidden" name="pageNo" value="${requestScope.pageNo}"/>
                                    <input type="hidden" name="s_id" value="${teacher.subject.subject_id}"/>
                                </p>
                            </form>
                        </div><!--widgetcontent-->
                    </div><!--widget-->

                    <br/><br/>

                    <div class="footer">
                        <div class="footer-left">
                            <span>&copy; Clown Team. All Rights Reserved.</span>
                        </div>

                    </div><!--footer-->

                </div><!--maincontentinner-->
            </div><!--maincontent-->

        </div><!--rightpanel-->

    </div>
    <!--rightpanel-->

</div>
<!--mainwrapper-->

</body>

</html>


	