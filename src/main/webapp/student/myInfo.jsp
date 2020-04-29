<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<%=path%>/css/student.css" type="text/css"/>
    <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
    <title>学生登陆成功</title>
</head>
<body>

<div class="container">

    <div class="header">
        <div class="logo">
            <img src="<%=path%>/images/logo.png" alt=""/>
        </div>
        <div class="headerinner">
            <ul class="headmenu">

                <li class="right">
                    <div class="userloggedinfo">
                        <img src="<%=path%>/images/photos/thumb5.png" alt=""/>
                        <div class="userinfo">
                            <h5>${student.s_Name}
                                <small>you are welcome</small>
                            </h5>
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

    <div class="maincontent">
        <div class="maincontentinner">
            <h4 class="widgettitle" style=" background: #0866c6; color: #fff; padding: 12px 15px; font-size: 18px; margin-top:30px;">确认信息</h4>
            <table id="dyntable" class="table table-bordered responsive">
                <colgroup>
                    <col class="con0" style="align: center; width: 15%" />
                    <col class="con0"style="align: center; width: 15%" />
                    <col class="con1" style="align: center; width: 15%"/>
                    <col class="con0" style="align: center; width: 15%"/>
                    <col class="con1" />
                </colgroup>
                <thead>
                <tr style=" background:#333; color:#FFF; padding: 12px 15px; font-size: 14px;">
                    <th class="head0">姓名</th>
                    <th class="head1">学号</th>
                    <th class="head0">班级</th>
                    <th class="head0">操作</th>
                </tr>
                </thead>
                <tbody>


                <tr align="center">
                    <td>${student.s_Name}</td>
                    <td>${student.s_No}</td>
                    <td>${student.tClass.c_name}</td>
                    <td><center><input type="button" value="进入主页" id="CheckInfo" onclick="enter()" class="btn btn-primary"></center></td>
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

</div><!--mainwrapper-->
<script type="text/javascript" src="../js/jquery-3.4.0.js"></script>
<script type="text/javascript">
    function showInfo() {
        location.href = "student/showInfo.jsp";
    }

    function enter() {
        if (confirm('信息是否正确?')) {
            showInfo();
        } else {
            return false;
        }
    }
</script>

</body>
</html>