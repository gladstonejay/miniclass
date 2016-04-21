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
            <h1 class='title'><span class="icon" ><img src="../../../static/imags/tab3-active.png" width="22" ></span> 温故知新</h1>
        </header>
        <%@ include file="../common/bottom3.jsp" %>
        <div class="content">
            <div class="buttons-tab">
                <a href="#tab1" class="tab-link active button">微信答疑总结</a>
                <a href="#tab2" class="tab-link button">课件精要</a>
            </div>
                <div class="tabs">
                    <div id="tab1" class="tab active">
                        <c:forEach items="${weixinList}" var="item" varStatus="xh">
                        <div class="card">
                                <div class="card-content">
                                    <div class="list-block media-list">
                                        <ul>
                                            <li >
                                                <a href="/review/showOneTip.j?id=${item.itemId}" external class="item-link item-content">
                                                    <div class="item-media">
                                                        <img src="../../../static/imags/tab3.png" width="44" >
                                                    </div>
                                                    <div class="item-inner">
                                                        <div class="item-title-row">
                                                            <div class="item-title">微信答疑第${item.itemId}篇</div>
                                                        </div>
                                                        <div class="item-subtitle">${item.title}</div>
                                                    </div>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <%--<div class="card-footer">--%>
                                    <%--<span>2016/04/12</span>--%>
                                <%--</div>--%>
                            </div>
                        </c:forEach>
                    </div>
                    <div id="tab2" class="tab">
                        <c:forEach items="${pptList}" var="item" varStatus="xh">
                        <div class="card">
                            <div class="card-content">
                                <div class="list-block media-list">
                                    <ul>
                                            <li >
                                                <a href="/review/showOnePPT.j?id=${item.itemId}" external class="item-link item-content">
                                                    <div class="item-media">
                                                        <img src="../../../static/imags/video${item.itemId}.png" width="44" >
                                                    </div>
                                                    <div class="item-inner">
                                                        <div class="item-title-row">
                                                            <div class="item-title">课件精要第${item.itemId}篇</div>
                                                        </div>
                                                        <div class="item-subtitle">${item.title}</div>
                                                    </div>
                                                </a>
                                            </li>
                                    </ul>
                                </div>
                            </div>
                            <%--<div class="card-footer">--%>
                                <%--<span>${item.date}</span>--%>
                            <%--</div>--%>
                        </div>
                        </c:forEach>
                    </div>

        </div>
    </div>
</div>

<jsp:include page="../common/cmnjs.jsp"></jsp:include>

</body>
</html>