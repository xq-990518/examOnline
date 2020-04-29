<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>考试历史</title>

    <link rel="stylesheet" href="<%=path%>/css/style.default.css" type="text/css" />
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-fileupload.min.css" type="text/css" />
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-timepicker.min.css" type="text/css" />


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

<body>

<div class="mainwrapper">

    <div class="header">
        <div class="logo">
            <a href="<%=path %>/student/showInfo.jsp"><img src="<%=path%>/images/logo.png" alt="" /></a>
        </div>
        <div class="headerinner">
            <ul class="headmenu">

                <li class="right">
                    <div class="userloggedinfo">
                        <img src="<%=path%>/images/photos/thumb1.png" alt="" />
                        <div class="userinfo">
                            <h5>${sessionScope.student.s_Name} <small>you are welcome</small></h5>
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

        <div class="leftmenu">
            <ul class="nav nav-tabs nav-stacked">
                <li class="nav-header">Navigation</li>

                <li class="dropdown active"><a href=""><span class="iconfa-briefcase"></span> 考试中心</a>
                    <ul>
                        <li><a href="<%=path %>/showExam?s_id=${student.s_id}">所有试卷</a></li>
                        <li><a href="<%=path %>/historyExam?s_id=${student.s_id}&pageNo=0">考试历史</a></li>
                    </ul>
                </li>

            </ul>
        </div><!--leftmenu-->

    </div><!-- leftpanel -->

    <div class="rightpanel">

        <ul class="breadcrumbs">
            <li><a href="<%=path %>/student/showInfo.jsp"><i class="iconfa-home"></i></a> <span class="separator"></span></li>
            <li>考试中心 <span class="separator"></span></li>
            <li>考试历史</li>

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
                        <col class="con0" style="align: center; width: 15%" />

                        <col class="con0"style="align: center; width: 15%" />
                        <col class="con1" style="align: center; width: 15%"/>
                        <col class="con0" style="align: center; width: 15%"/>
                        <col class="con1" />
                        <col class="con0" style="align: center; width: 15%"/>
                        <col class="con1" />
                    </colgroup>
                    <thead>
                    <tr>

                        <th width="20%" class="head0">学生姓名</th>
                        <th width="20%" class="head1">试卷标题</th>
                        <th width="20%" class="head0">考试科目</th>
                        <th width="20%" class="head1">考试时间</th>
                        <th width="20%" class="head0">分数</th>
                    </tr>

                    </thead>
                    <tbody>
                        <c:forEach var="historyExam" items="${page.topicList}">
                        <tr align="center">
                            <td>
                                ${historyExam.student.s_Name}
                            </td>
                            <td align="left">
                               ${historyExam.exam.e_name}
                            </td>
                            <td>
                                ${historyExam.exam.discipline.subject_name}
                            </td>
                            <td>
                                <fmt:formatDate value="${historyExam.a_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                            <td>
                                ${historyExam.mark}
                            </td>
                        </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="6" align="center">
                                共${page.totalCount}条纪录，当前第${page.currentPageNO}/${page.totalPageCount}页，每页${page.pageSize}条纪录

                                <a href="historyExam?pageNo=1&s_id=${student.s_id}">首页</a> |
                                <a href="historyExam?pageNo=${page.currentPageNO - 1}&s_id=${student.s_id}">上一页</a> |

                                <a href="historyExam?pageNo=${page.currentPageNO + 1}&s_id=${student.s_id}">下一页</a> |
                                <a href="historyExam?pageNo=${page.totalPageCount}&s_id=${student.s_id}">尾页</a>

                            </td>
                        </tr>
                    </tbody>
                </table>

                <br /><br />
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
	