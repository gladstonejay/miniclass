<%--
  Created by IntelliJ IDEA.
  User: shuaizhiguo
  Date: 2016/3/29
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

    <jsp:include page="../common/head.jsp"></jsp:include>

</head>
<body>
<div class="page-group">
    <div class="page page-current">
        <header class="bar bar-nav">
            <h1 class='title'><span class="icon" ><img src="../../../static/imags/tab2-active.png" width="28" ></span> 学习排名</h1>
        </header>
        <%@ include file="../common/bottom2.jsp" %>

        <div class="content">
            <div class="buttons-tab">
                <a href="#tab1" class="tab-link active button">排名</a>
                <a href="#tab2" class="tab-link button">考试</a>
            </div>
                <div class="tabs">
                    <div id="tab1" class="tab active">
                                <div class="list-block">
                                    <ul>
                                        <c:forEach items="${resultList}" var="item" varStatus="xh">
                                            <li class="item-content">
                                                <div class="item-inner">
                                                    <c:if test="${xh.count<4}">
                                                    <div class="item-title"><span class="icon" ><img src="../../../static/imags/tab2-${xh.count}.png" width="28" ></span> ${item.userNname}</div>
                                                    <div class="item-after">${item.score}</div>
                                                    </c:if>
                                                    <c:if test="${xh.count>3}">
                                                    <div class="item-title"> ${xh.count} ${item.userNname}</div>
                                                    <div class="item-after">${item.score}</div>
                                                    </c:if>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                    </div>
                    <div id="tab2" class="tab">
                        <div class="content-block">
                            <p>This is tab 2 content</p>
                        </div>
                    </div>
            </div>
       </div>
    </div>
</div>

<jsp:include page="../common/cmnjs.jsp"></jsp:include>

</body>
</html>