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
    <script>
        window.onload = function () {
            daojishi();
        }
        var second = "${exam.e_examDate}";
        var counttime = second * 60;//总秒钟

        function daojishi() {
            if (counttime >= 0) {
                var ms = counttime % 60;//余数 89%60==29秒
                var mis = Math.floor(counttime / 60);//分钟
                if (mis >= 60) {
                    var hour = Math.floor(mis / 60);

                    mis = Math.floor((counttime - hour * 60 * 60) / 60);

                    document.getElementById("mss").innerHTML = hour + "小时" + mis + "分" + ms + "秒";

                } else if (mis >= 1) {
                    document.getElementById("mss").innerHTML = mis + "分" + ms + "秒";
                } else {
                    document.getElementById("mss").innerHTML = ms + "秒";
                }

                counttime--;
                vartt = window.setTimeout("daojishi()", 1000);
            } else {
                window.clearTimeout(vartt);
                alert("考试时间结束,提交试卷");
                examIndex();
            }
        }
    </script>

    <title>学生登陆成功</title>
</head>
<body>

<div class="container">

    <div class="header">
        <div class="logo">
            <a href="<%=path%>/student/showInfo.jsp"><img src="<%=path%>/images/logo.png" alt=""/></a>
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

    <div class="examed_uc maincontentinner">
        <h3 style="text-align: center;">${exam.e_name}</h3>
        <br>
        <div class="exam_time" style="font-size:16px;">
            <span>剩余时间为：</span><label name="mss" id="mss" style="font-size:16px;"></label>
        </div>
        <div class="questionCell" id="D_Title_P">
            <div class="titleBar">
                <span><b id="D_Title">选择题</b></span>
                <div class="clear"></div>
            </div>
            <form action="" method="post">
                <c:set var="index" value="0"/>
                <input type="hidden" name="exam_id" id="exam_id" value="${exam_id}"/>
                <c:forEach var="question" items="${exam.questions}">
                    <c:if test="${question.answer.length()==1}">
                    <div class="question">
                        <input type="hidden" name="stID" value="${question.q_id}"/>
                        <p><span class="subscript">${index=index+1}</span>、${question.q_name}（）&nbsp;(<span class="D_score">${question.mark}</span>分)</p>
                        <ul>
                            <li>
                                <input type="radio" name="stAnswer${index}" value="A"/>A．${question.optionA}
                            </li>

                            <li>
                                <input type="radio" name="stAnswer${index}" value="B"/>B．${question.optionB}
                            </li>

                            <li>
                                <input type="radio" name="stAnswer${index}" value="C"/>C．${question.optionC}
                            </li>

                            <li>
                                <input type="radio" name="stAnswer${index}" value="D"/>D．${question.optionD}
                            </li>
                        </ul>
                    </div>
                        </c:if>
                    <c:if test="${question.answer.length()>1}">
                        <div class="question">
                            <input type="hidden" name="stID" value="${question.q_id}"/>
                            <p><span class="subscript">${index=index+1}</span>、${question.q_name}（）&nbsp;(<span class="D_score">${question.mark}</span>分)</p>
                            <ul>
                                <li>
                                    <input type="checkbox" name="stAnswer${index}" value="A"/>A．${question.optionA}
                                </li>

                                <li>
                                    <input type="checkbox" name="stAnswer${index}" value="B"/>B．${question.optionB}
                                </li>

                                <li>
                                    <input type="checkbox" name="stAnswer${index}" value="C"/>C．${question.optionC}
                                </li>

                                <li>
                                    <input type="checkbox" name="stAnswer${index}" value="D"/>D．${question.optionD}
                                </li>
                            </ul>
                        </div>
                    </c:if>
                </c:forEach>
                <br>
                <div align="center">
                   <%-- <input type="submit" value=" 提交答卷 " onclick=" return confirm('确认提交?')" name="Submit"/>--%>
                    <input type="button" value="提交答卷" id="examSubmit" onclick="submitExam()"/>
                </div>
            </form>

        </div>

    </div>

</div>

<script type="text/javascript" src="<%=path%>/js/jquery-3.4.0.js"></script>
<script type="text/javascript" >
        function examIndex() {
            var mydiv= document.getElementsByClassName("question"); //获取div
            var q_id=new Array(); //题号集合
            var answerList=new Array(); //答案集合
            var exam_id=$("#exam_id").val(); //试卷id
            for (var i = 0; i <mydiv.length ; i++) {    //遍历div
                var s=mydiv[i].children;    //获取div子元素
                q_id[i]=s[0].value; //获取题号放入集合
                var li=s[2].children;   //获取ul
                var answer;         //单选答案
                var manyAnswer='';  //多选答案
                for (var j = 0; j <li.length ; j++) {   //遍历ul
                    if (li[j].children[0].type=="radio"){   //判断是否是单选题
                        if (li[j].children[0].checked==true){   //判断选中答案
                            answer=li[j].children[0].value.toString();  //获取答案
                            answerList[i]=answer;   //把答案放入答案集合
                        }
                    } else if (li[j].children[0].type=="checkbox"){ //判断是否是复选题
                        if (li[j].children[0].checked==true){    //判断选中答案
                            manyAnswer+=li[j].children[0].value.toString(); //获取答案，拼接答案
                            answerList[i]=manyAnswer;   //把答案放入答案集合
                        }
                    }
                }
            }
            location.href="examSource?list="+q_id+"&answerList="+answerList+"&exam_id="+exam_id+"&s_id="+"${student.s_id}";
        }
        function submitExam() {
            if (confirm('确认提交?')){
                examIndex();
            }else {
                return false;
            }
        }
</script>

</body>
</html>