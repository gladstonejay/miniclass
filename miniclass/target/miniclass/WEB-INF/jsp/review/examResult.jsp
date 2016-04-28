<%--
  Created by IntelliJ IDEA.
  User: shuaizhiguo
  Date: 16/4/24
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <jsp:include page="../common/head.jsp"></jsp:include>
</head>
<body>
  <div class="page page-current">
    <header class="bar bar-nav">
        <button class="button button-link button-nav pull-left">
            <span class="icon icon-left"></span><a href="/review/showTips.j" external style="color:#FFFFFF" >
            返回
        </a></button>
      <h1 class='title'>成绩单</h1>
    </header>

    <%@ include file="../common/bottom3.jsp" %>

    <div class="content" style="text-align: center">
      <p>${result}</p>


    </div>
  </div>

</body>
</html>
