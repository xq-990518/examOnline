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

    <link rel="stylesheet" href="<%=path%>/css/style.default.css" type="text/css"/>
    <link rel="stylesheet" href="<%=path%>/css/responsive-tables.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-fileupload.min.css" type="text/css"/>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-timepicker.min.css" type="text/css"/>

    <script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-migrate-1.1.1.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/responsive-tables.js"></script>
    <script type="text/javascript" src="<%=path%>/js/custom.js"></script>
    <script type="text/javascript" src="<%=path%>/js/forms.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            // dynamic table
            jQuery('#dyntable').dataTable({
                "sPaginationType": "full_numbers",
                "aaSortingFixed": [[0, 'asc']],
                "fnDrawCallback": function (oSettings) {
                    jQuery.uniform.update();
                }
            });

            jQuery('#dyntable2').dataTable({
                "bScrollInfinite": true,
                "bScrollCollapse": true,
                "sScrollY": "300px"
            });
        });

        //ajax
        function showStatus(str) {
            //如果form表单中的字符串为空的话，就把显示的返回值清空，并且返回函数，不再往下执行
            if (str.length == 0) {
                document.getElementById("txt").innerHTML = "";
                return;
            }
            if (window.XMLHttpRequest) {
                //chrome Firefox opera Safari……
                var xmlhttp = new XMLHttpRequest();
            } else {
                //兼容老版本
                var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                //如果可以连接的通
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    // 并且返回值是HTTP200
                    document.getElementById("txt").innerHTML = xmlhttp.responseText;
                    // 获取ajax 从后台回传的数据
                }
            }
            //打开ajax
            xmlhttp.open("GET", "checkStudentID.action?studentID=" + str, true);
            //发送请求
            xmlhttp.send();
        }
    </script>
    <title>管理员登陆成功</title>
</head>
<body>
<c:if test="${! empty tip }">
    <script>
        alert("${tip}");
    </script>
</c:if>
<div class="mainwrapper">
    <div class="header">
        <div class="logo">
            <a href="<%=path %>/teacher/teacher.jsp"><img src="<%=path %>/images/logo.png" alt=""/></a>
        </div>
        <div class="headerinner">
            <ul class="headmenu">

                <li class="right">
                    <div class="userloggedinfo">
                        <img src="<%=path %>/images/photos/thumb1.png" alt=""/>
                        <div class="userinfo">
                            <h5>${admin.admin_name} <small>you are welcome</small></h5>
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

                <li class="dropdown active"><a href=""><span class="iconfa-pencil"></span> 学生管理</a>
                    <ul>
                        <li><a href="<%=path %>/teacher/studentAdd.jsp">添加学生</a></li>
                        <li><a href="<%=path %>/teacher/SelAllStu">查询所有学生</a></li><%----%>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span> 学科管理</a>
                    <ul>
                        <li><a href="<%=path %>/teacher/courseAdd.jsp">添加科目</a></li>
                        <li><a href="<%=path %>/SubjectQuery?pageNo=0">查询所有科目</a></li><%----%>

                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-briefcase"></span> 班级管理</a>
                    <ul>
                        <li><a href="<%=path %>/teacher/classAdd.jsp">添加班级</a></li><%----%>
                        <li><a href="<%=path %>/QueryAllTClass?pageNo=0">查询所有班级</a></li><%----%>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-briefcase"></span> 试题管理</a>
                    <ul>
                        <li><a href="<%=path %>/teacher/subjectAdd.jsp">添加试题</a></li>
                        <li><a href="<%=path %>/ShowAllQue">查询所有试题</a></li>
                        <li><a href="<%=path %>/SelQueShowSub">搜索试题</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span> 试卷管理</a>
                    <ul>
                        <li><a href="<%=path %>/teacher/ExamAdd.jsp">生成试卷</a></li>
                        <li><a href="<%=path %>/TeacherExamShow?pageNo=0">查询所有试卷</a></li><%----%>
                    </ul>
                </li>
            </ul>
        </div><!--leftmenu-->

    </div><!-- leftpanel -->
    <div class="rightpanel">

        <ul class="breadcrumbs">
            <li><a href="<%=path %>/teacher/teacher.jsp"><i class="iconfa-home"></i></a> <span class="separator"></span>
            </li>
            <li>学生管理 <span class="separator"></span></li>
            <li>修改学生信息</li>

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
                    <h4 class="widgettitle">添加学生</h4>
                    <div class="widgetcontent">
                        <form class="stdform" action="UpdStudentByAll" method="post">

                            <label>学生编号：</label>
                            <span class="field"><input type="text" name="StuNo" class="input-xlarge"
                                                       placeholder="请输入..." required="required"
                                                       onkeyup="showStatus(this.value)"
                                                       value="${requestScope.ShowStuInfo.s_No}"/>
                            </span>
                            <label>学生姓名：</label>
                            <span class="field"><input type="text" name="StuName" class="input-xlarge"
                                                       placeholder="请输入..." required="required"
                                                       value="${requestScope.ShowStuInfo.s_Name}"/></span>
                            <label>所属班级:</label>
                            <span class="field">
                                 <select name="sclass" class="form-control">
                                     <c:forEach items="${requestScope.ClaList}" var="ShowCla">
                                            <option value="${ShowCla.c_id}"
                                                    <c:if test="${ShowCla.c_id==requestScope.ShowStuInfo.tClass.c_id}">selected='selected'</c:if>>${ShowCla.c_name}</option>
                                     </c:forEach>
                                 </select>
                             </span>
                            <p>
                                <input type="hidden" name="ByAll" value="${ByAll}"/>
                                <input type="hidden" name="pageNo" value="${requestScope.pageNo}"/>
                                <input type="hidden" name="StuId" value="${requestScope.ShowStuInfo.s_id}"/>
                            </p>
                            <p class="stdformbutton">
                                <input class="btn btn-primary" type="submit" value="修改">
                                <input class="btn btn-primary" type="reset" value="重置">

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

</div><!--mainwrapper-->

</body>
</html>