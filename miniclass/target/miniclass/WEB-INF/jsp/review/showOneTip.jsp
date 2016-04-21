<%--
  Created by IntelliJ IDEA.
  User: shuaizhiguo
  Date: 16/4/12
  Time: 00:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

    <jsp:include page="../common/head.jsp"></jsp:include>

</head>
<body>
<div class="page-group">
    <div class="page page-current">
        <header class="bar bar-nav">
            <a class="button button-link button-nav pull-left" href="/review/showTips.j" external data-transition='slide-out'>
                <span class="icon icon-left"></span>
                返回
            </a>
            <h1 class='title'>微信答疑第${weixin.itemId}篇: ${weixin.title}</h1>
        </header>
        <%@ include file="../common/bottom3.jsp" %>
        <div class="content">
            <div class="content-padded"><p> ${weixin.context} </p></div>
        </div>
    </div>
</div>

<jsp:include page="../common/cmnjs.jsp"></jsp:include>

</body>
</html>
