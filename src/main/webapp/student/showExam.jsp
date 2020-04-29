<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>所有试卷</title>

    <link rel="stylesheet" href="<%=path%>/css/style.default.css" type="text/css" />
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-fileupload.min.css" type="text/css" />
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-timepicker.min.css" type="text/css" />

    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery-migrate-1.1.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery-ui-1.9.2.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=path %>/js/modernizr.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/responsive-tables.js"></script>
    <script type="text/javascript" src="<%=path %>/js/custom.js"></script>

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
            <li>所有试卷</li>

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

                <h4 class="widgettitle">试卷库</h4>
                <table width="101%" class="table table-bordered responsive" id="dyntable">
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

                        <th width="21%" class="head0">试卷编号</th>
                        <th width="18%" class="head1">试卷标题</th>
                        <th width="17%" class="head0">考试科目</th>
                        <th width="25%" class="head1">考试时间</th>
                        <th width="19%" class="head0">开始考试</th>

                    </tr>

                    </thead>
                    <tbody id="showExam">
                    <c:forEach var="page" items="${page.topicList}">
                        <c:if test="${page.e_type==1}">
                            <tr align="center">
                                <td>
                                        ${page.e_id}
                                </td>
                                <td>
                                        ${page.e_name}
                                </td>
                                <td>
                                        ${page.discipline.getSubject_name()}
                                </td>
                                <td> ${page.e_examDate}</td>
                                    <%--判断传过来的page.achievements是否为空，不为空则遍历输出--%>
                                <c:if test="${not empty page.achievements}">
                                    <c:forEach var="Judge" varStatus="var" items="${page.achievements}">
                                        <c:if test="${not empty Judge.mark}">
                                            <c:if test="${var.last==true}">
                                                <td>已考试</td>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                                    <%--判断传过来的page.achievements是否为空，为空则显示开始考试--%>
                                <c:if test="${empty page.achievements}">
                                    <td><a href="startExam?e_id=${page.e_id}">开始考试</a></td>
                                </c:if>


                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr>
                        <td colspan="6" align="center">
                            共${page.totalCount}条纪录，当前第${page.currentPageNO}/${page.totalPageCount}页，每页${page.pageSize}条纪录

                            <a href="showExam?pageNo=1&s_id=${student.s_id}">首页</a> |
                            <a href="showExam?pageNo=${page.currentPageNO - 1}&s_id=${student.s_id}">上一页</a> |

                            <a href="showExam?pageNo=${page.currentPageNO + 1}&s_id=${student.s_id}">下一页</a> |
                            <a href="showExam?pageNo=${page.totalPageCount}&s_id=${student.s_id}">尾页</a>

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
