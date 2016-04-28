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
      <h1 class='title'><span class="icon" ><img src="../../../static/imags/tab/tab1-active.png" width="32" ></span> 第${videoInfo.orderId}讲:${videoInfo.title}</h1>
    </header>
    <%@ include file="../common/bottom.jsp" %>
    <div class="content">
      <div id="wktvideo">
        <iframe width="100%" height="250" src="http://player.youku.com/embed/${videoInfo.videoId}"  frameborder="0" allowfullscreen="true"></iframe>
      </div>
      <div class="content-padded"><p> ${videoInfo.summary} </p></div>
    </div>
  </div>
</div>

<jsp:include page="../common/cmnjs.jsp"></jsp:include>

</body>
</html>
