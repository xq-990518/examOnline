<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>首页</title>
<link rel="stylesheet" href="<%=path%>/css/style.default.css" type="text/css" />

<link rel='stylesheet' href='<%=path%>/css/slidetounlock.css'>

<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=path%>/js/custom.js"></script>
<script type="text/javascript" src="<%=path%>/js/slidetounlock.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function(){
        jQuery("#password").hide();
        jQuery('#login').submit(function(){
            var u = jQuery('#username').val();
            var p = jQuery('#password').val();
            if(u == '' && p == '') {
                jQuery('.login-alert').fadeIn();
                return false;
            }
        });
        jQuery("#student").click(function () {
            jQuery("#password").hide();
        });
        jQuery("#teacher").click(function () {
            jQuery("#password").show();
        });
        jQuery("#admin").click(function () {
            jQuery("#password").show();
        });

    });
</script>
</head>
<body class="loginpage">


<div class="loginpanel">
    <div class="loginpanelinner">
        <div class="logo animate0 bounceIn"><img src="images/logo.png" alt="" /></div>
        <form id="login" action="login" method="post">
       
            <div class="inputwrapper login-alert">
                <div class="alert alert-error">Invalid username or password</div>
            </div>
            <div class="inputwrapper animate1 bounceIn">
                <input type="text" name="username" id="username" placeholder="Enter any username" />
            </div>
            <div class="inputwrapper animate2 bounceIn">
                <input type="password" name="password" id="password" placeholder="Enter any password" />
            </div>
           <div class="inputwrapper animate3 bounceIn">
				<label  class="signlabel" ><input name="role" type="radio" id="student" value="student"checked="checked" />学生</label>
                <label  class="signlabel"><input  name="role" type="radio" id="teacher" value="teacher"/>教师</label>
				<label  class="signlabel"><input  name="role" type="radio" id="admin" value="admin" />管理员</label>
			</div>
           <div id="well" class="inputwrapper animate4 bounceIn">
				<div id="unlock">
					<span id="slider"></span>
				</div>
			</div>
            <div class="inputwrapper animate5 bounceIn">
                <button id="submit" class="btn" style="background-color: #e6e6e6;">登录</button>
            </div>
<%--              <div class="inputwrapper animate5 bounceIn" >--%>
<%--                <button id="submit2" name="submit" class="btn" style="background-color: #e6e6e6;">登录</button>--%>
<%--            </div>--%>
       	</form>
    </div><!--loginpanelinner-->
</div><!--loginpanel-->
</body>

<script language="javascript">
    //防止页面后退
    history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);
    });
</script>
</html>