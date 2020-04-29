<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<%=path%>/css/student.css" type="text/css" />

    <title>管理员登陆成功</title>
</head>
<body>

<div class="container">

    <div class="header">
        <div class="logo">
            <a href="<%=path%>/teacher/teacher.jsp"><img src="<%=path%>/images/logo.png" alt="" /></a>
        </div>
        <div class="headerinner">
            <ul class="headmenu">

                <li class="right">
                    <div class="userloggedinfo">
                        <img src="<%=path%>/images/photos/thumb5.png" alt="" />
                        <div class="userinfo">
                            <h5>${admin.admin_name} <small>you are welcome</small></h5>
                            <ul>
                                <li><a href="<%=path %>/login.jsp">退出登录</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul>
            <!--headmenu-->
        </div>
    </div>

    <div class="examed_uc maincontentinner">
        <h3 style="text-align: center;">${exam.e_name}</h3>
        <br>
        <div>
            <span>考试时间：${exam.e_examDate} 分钟</span>  &nbsp; &nbsp; &nbsp; &nbsp;总分 ：${exam_score} 分
        </div>
        <div class="questionCell" id="D_Title_P">
            <div class="titleBar">
                <span><b id="D_Title">选择题</b></span>
                <div class="clear"></div>
            </div>
            <c:set var="index" value="0"/>
            <c:forEach var="question" items="${exam.questions}">
                <div class="question">
                    <input type="hidden" name="stID" value="${question.q_id}" />
                    <p><strong>第<span class="STYLE5">${index=index+1}</span>题&nbsp;${question.q_name}（）&nbsp;(<span class="D_score">${question.mark}</span>分)</strong></p>
                    <ul>
                        <li>
                            <strong>A．</strong>${question.optionA}
                        </li>

                        <li >
                            <strong>B．</strong>${question.optionB}
                        </li>

                        <li >
                            <strong>C．</strong>${question.optionC}
                        </li>

                        <li >
                            <strong>D．</strong>${question.optionD}
                        </li>
                        <strong>【正确答案】：${question.answer}</strong><br/>
                        <strong>【参考解析】：${question.resolution}</strong>
                    </ul>
                </div>
            </c:forEach>
            <br>
        </div>
        <input class="btn btn-primary" id="showInfo" type="button" value="返回查看全部试卷" align="center"/>
    </div>

</div>

<script type="text/javascript" src="<%=path%>/js/jquery-3.4.0.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#showInfo").click(function () {
            location.href="TeacherExamShow?pageNo=${pageNo}";
        });
    });
</script>

</body>
</html>