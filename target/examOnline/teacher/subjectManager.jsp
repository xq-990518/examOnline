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
    </script>
</head>
<title>管理员登陆成功</title>
<body>

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
                <li class="dropdown active"><a href=""><span class="iconfa-pencil"></span> 教师管理</a>
                    <ul>
                        <li><a href="<%=path %>/teacher/teacherAdd.jsp">添加教师</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span> 学生管理</a>
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
                <li class="dropdown active"><a href=""><span class="iconfa-briefcase"></span> 试题管理</a>
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
            <li>试题管理 <span class="separator"></span></li>
            <li>查询所有试题</li>

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


        <div class="maincontent">
            <div class="maincontentinner">

                <h4 class="widgettitle">试题库</h4>
                <table id="dyntable" class="table table-bordered responsive">
                    <colgroup>
                        <col class="con0" style=" width: 6%"/>
                        <col class="con1" style="width: 25%"/>
                        <col class="con0" style=" width: 9%"/>
                        <col class="con1" style="width: 9%"/>
                        <col class="con0" style=" width: 9%"/>
                        <col class="con1" style=" width: 9%"/>
                        <col class="con0" style="width: 6%"/>
                        <col class="con1" style=" width: 5%"/>
                        <col class="con0" style=" width: 6%"/>
                        <col class="con1" style=" width: 8%"/>
                        <col class="con0"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th class="head0">试题编号</th>
                        <th class="head1"> 试题标题</th>
                        <th class="head0"> 试题选项A</th>
                        <th class="head1"> 试题选项B</th>
                        <th class="head0"> 试题选项C</th>
                        <th class="head1"> 试题选项D</th>
                        <th class="head0"> 正确答案</th>
                        <th class="head1"> 分值</th>
                        <th class="head0"> 所属学科</th>
                        <th class="head1"> 备注</th>
                        <th class="head0"> 操作</th>
                    </tr>

                    </thead>
                    <tbody>
                    <c:if test="${page.topicList!=null}">
                        <c:forEach items="${page.topicList}" var="Que">
                            <tr>
                                <td>${Que.q_id}</td>
                                <td>${Que.q_name}</td>
                                <td>${Que.optionA}</td>
                                <td>${Que.optionB}</td>
                                <td>${Que.optionC}</td>
                                <td>${Que.optionD}</td>
                                <td>${Que.answer}</td>
                                <td>${Que.mark}</td>
                                <td>${Que.subject.subject_name}</td>
                                <td>${Que.resolution}</td>
                                <td>
                                    <center>
                                        <a href="<%=path%>/ShowUpdInfo?QueId=${Que.q_id}&pageNo=${page.currentPageNO}">更新</a>&nbsp;&nbsp;
                                      <%--  <a href="<%=path%>/DelQuestion?QueId=${Que.q_id}&pageNo=${page.currentPageNO}">删除</a>--%>
                                    </center>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>

                    <tr>
                        <td colspan="11" align="center">
                            共${page.totalCount}条纪录，当前第${page.currentPageNO}/${page.totalPageCount}页，每页${page.pageSize}条纪录

                            <a href="ShowAllQue?pageNo=1">首页</a> |
                            <a href="ShowAllQue?pageNo=${page.currentPageNO - 1}">上一页</a> |

                            <a href="ShowAllQue?pageNo=${page.currentPageNO + 1}">下一页</a> |
                            <a href="ShowAllQue?pageNo=${page.totalPageCount}">尾页</a>

                        </td>
                    </tr>

                    </tbody>
                </table>

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
	