<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>老师登陆成功</title>
<body>
<c:if test="${! empty tip }">
    <script>
        alert("${tip}");
    </script>
</c:if>
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
                            <h5>${teacher.t_Name}
                                <small>you are welcome</small>
                            </h5>
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
                <li class="dropdown active"><a href=""><span class="iconfa-briefcase"></span> 班级管理</a>
                    <ul>
                        <li><a href="<%=path %>/showAllTClass?t_id=${teacher.t_id}&pageNo=0">查询所有班级</a></li>
                        <%----%>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-briefcase"></span> 试题管理</a>
                    <ul>
                        <li><a href="<%=path %>/teachers/subjectAdd.jsp">添加试题</a></li>
                        <li><a href="<%=path %>/QueryQuestion?s_id=${teacher.subject.subject_id}&pageNo=0">查询所有试题</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span> 试卷管理</a>
                    <ul>
                        <li><a href="<%=path %>/teachers/ExamAdd.jsp">生成试卷</a></li>
                        <li><a href="<%=path %>/TeacherExamQuery?pageNo=0&s_id=${teacher.subject.subject_id}">查询所有试卷</a>
                        </li>
                        <%----%>
                    </ul>
                </li>
            </ul>
        </div><!--leftmenu-->

    </div><!-- leftpanel -->

    <div class="rightpanel">

        <ul class="breadcrumbs">
            <li><a href="<%=path %>/teachers/teacher.jsp"><i class="iconfa-home"></i></a> <span class="separator"></span>
            </li>
            <li>学生管理<span class="separator"></span></li>
            <li>查询所有学生</li>

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

                <h4 class="widgettitle">学生表</h4>
                <table id="dyntable" class="table table-bordered responsive">
                    <%--判断是否考试，未考试则不显示成绩列--%>
                    <c:forEach var="acc" items="${achievementList}">
                        <c:if test="${not empty acc.mark}">
                            <colgroup>
                                <col class="con0" style="align: center;width: 25%"/>
                                <col class="con1" style="align: center;width: 25%"/>
                                <col class="con0" style="align: center;width: 25%"/>
                                <col class="con1"/>
                            </colgroup>
                        </c:if>
                        <c:if test="${empty acc.mark}">
                            <colgroup>
                                <col class="con0" style="align: center;width: 33%"/>
                                <col class="con1" style="align: center;width: 33%"/>
                                <col class="con0" style="align: center;width: 33%"/>
                                <col class="con1"/>
                            </colgroup>
                        </c:if>

                    </c:forEach>


                    <thead id="AllStuList">
                    <tr>
                        <th class="head0">学生编号</th>
                        <th class="head1">所属班级</th>
                        <th class="head0">学生姓名</th>
                        <%--判断是否考试，未考试则不显示成绩列--%>
                        <c:forEach var="acc" items="${achievementList}">
                            <c:if test="${not empty acc.mark}">
                                <th class="head1" width="25%">
                                    <c:forEach var="exam" items="${TeaIdSubIdGetEName}" varStatus="getLastName">
                                        <c:if test="${getLastName.last==true}">
                                            第${getLastName.count}次考试：${exam.e_name}
                                        </c:if>
                                    </c:forEach>
                                    成绩（空为未考试）
                                </th>
                            </c:if>
                        </c:forEach>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.topicList}" var="list">
                        <p>
                            <input type="hidden" name="stu_id" id="s_id" value="${list.s_id}"/>
                            <input type="hidden" name="subject_id" id="subject_id" value="${requestScope.subject_id}"/>
                        </p>
                        <tr align="center">
                            <td>${list.s_No}</td>
                            <td>${list.tClass.c_name}</td>
                            <td>${list.s_Name}</td>
                                <%--判断是否考试，未考试则不显示成绩列--%>
                            <c:forEach var="acc" items="${achievementList}">
                                <c:if test="${not empty acc.mark}">
                                    <td>
                                            <%--将ach考试集合遍历--%>
                                        <c:forEach items="${list.achievements}" var="ach" varStatus="isLast">
                                            <%--  判断老师带的学科与成绩表中对应的学科是否相同--%>
                                            <c:if test="${teacher.subject.subject_id==ach.exam.discipline.subject_id}">
                                                <%--  判断是否是最后一次考试（数据库中满足上面条件以后的最后一条数据）--%>
                                                <c:if test="${isLast.last==true}">
                                                    <c:if test="${not empty achievementList}">
                                                        <c:if test="${ach.exam.e_id==LastExamID}">
                                                            ${ach.mark}
                                                        </c:if>
                                                    </c:if>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td colspan="6" align="center">
                            共${page.totalCount}条纪录，当前第${page.currentPageNO}/${page.totalPageCount}页，每页${page.pageSize}条纪录

                            <a href="ShowAllStudentByClass?subject_id=${teacher.subject.subject_id}&t_id=${teacher.t_id}&c_id=${c_id}&pageNo=1">首页</a>
                            |
                            <a href="ShowAllStudentByClass?subject_id=${teacher.subject.subject_id}&t_id=${teacher.t_id}&c_id=${c_id}&pageNo=${page.currentPageNO - 1}">上一页</a>
                            |

                            <a href="ShowAllStudentByClass?subject_id=${teacher.subject.subject_id}&t_id=${teacher.t_id}&c_id=${c_id}&pageNo=${page.currentPageNO + 1}">下一页</a>
                            |
                            <a href="ShowAllStudentByClass?subject_id=${teacher.subject.subject_id}&t_id=${teacher.t_id}&c_id=${c_id}&pageNo=${page.totalPageCount}">尾页</a>

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