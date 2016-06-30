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
            <h1 class='title'><span class="icon" ><img src="../../../static/imags/tab/tab2-active.png" width="28" ></span> 学习排名 前十达人</h1>
        </header>
        <%@ include file="../common/bottom2.jsp" %>

        <div class="content">
            <div class="buttons-tab">
                <a href="#tab1" class="tab-link active button">第三季度</a>
                <a href="#tab2" class="tab-link  button">第四季度</a>
                <a href="#tab3" class="tab-link  button">年度</a>
            </div>
            <h6>积分获取规则：每次听课，考试，阅读文章都可以获得相应的分数；每天只能获取同一内容的积分一次</h6>
                <div class="tabs">
                    <div id="tab1" class="tab active">
                        <div class="list-block">
                            <ul>
                                <c:forEach items="${autumnList}" var="item" varStatus="xh">
                                    <li class="item-content">
                                        <div class="item-inner">
                                            <c:if test="${xh.count<4}">
                                                <div class="item-title"><span class="icon" ><img src="../../../static/imags/cups/tab2-${xh.count}.png" width="28" ></span> ${item.userNname}</div>
                                                <div class="item-after">${item.autumn}</div>
                                            </c:if>
                                            <c:if test="${xh.count>3}">
                                                <div class="item-title"> ${xh.count} ${item.userNname}</div>
                                                <div class="item-after">${item.autumn}</div>
                                            </c:if>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div id="tab2" class="tab">
                        <div class="list-block">
                            <ul>
                                <c:forEach items="${winterList}" var="item" varStatus="xh">
                                    <li class="item-content">
                                        <div class="item-inner">
                                            <c:if test="${xh.count<4}">
                                                <div class="item-title"><span class="icon" ><img src="../../../static/imags/cups/tab2-${xh.count}.png" width="28" ></span> ${item.userNname}</div>
                                                <div class="item-after">${item.winter}</div>
                                            </c:if>
                                            <c:if test="${xh.count>3}">
                                                <div class="item-title"> ${xh.count} ${item.userNname}</div>
                                                <div class="item-after">${item.winter}</div>
                                            </c:if>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div id="tab3" class="tab">
                        <div class="list-block">
                            <ul>
                                <c:forEach items="${resultList}" var="item" varStatus="xh">
                                    <li class="item-content">
                                        <div class="item-inner">
                                            <c:if test="${xh.count<4}">
                                                <div class="item-title"><span class="icon" ><img src="../../../static/imags/cups/tab2-${xh.count}.png" width="28" ></span> ${item.userNname}</div>
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
            </div>
       </div>
    </div>
</div>

<jsp:include page="../common/cmnjs.jsp"></jsp:include>

</body>
</html>