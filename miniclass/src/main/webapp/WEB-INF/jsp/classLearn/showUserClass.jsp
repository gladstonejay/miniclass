<%--
  Created by IntelliJ IDEA.
  User: shuaizhiguo
  Date: 2016/3/28
  Time: 17:30
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
            <h1 class="title"><span class="icon" ><img src="../../../static/imags/tab4-active.png" width="22" ></span> 我的课程</h1>
        </header>
        <%@ include file="../common/bottom.jsp" %>
        <div class="content">

            <div class="card">

            </div>
            <div class="card demo-card-header-pic">
                <div valign="bottom" class="card-header color-white no-border no-padding">
                    <img class='card-cover' src="../../../static/imags/tab1_milk.png" alt="">
                </div>
                <div class="card-content">
                    <div class="card-content-inner">
                        <p>各位母婴店的销售精英们：大家好</p>
                        <p>母婴营养达人微课堂开课啦！</p>
                        <p>本课程旨在帮您：</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;高效轻松的学习，让您的话术更专业</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;专业营养师授课，令您的知识更系统</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;系统的课程回看，使您的学习更方便</p>
                    </div>
                </div>
            </div>

            <c:forEach items="${videoInfoList}" var="item" varStatus="xh">
            <div class="card">
                <div class="card-content">
                    <div class="list-block media-list">
                        <ul>
                            <li>
                                <a href="/classLearn/showOneClass.j?id=${item.orderId}" external class="item-link item-content">
                                    <div class="item-media"><i class="icon icon-f7"></i></div>
                                <div class="item-media">
                                    <%--<img src="../../../static/imags/video${item.orderId}.png" width="44">--%>
                                        <img src="../../../static/imags/video1.png" width="44">
                                </div>
                                <div class="item-inner">
                                    <div class="item-title-row">
                                        <div class="item-title">第${item.orderId}课</div>
                                    </div>
                                    <div class="item-subtitle">${item.title}</div>
                                </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="card-footer">
                    <span>${item.timestamp}</span>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>

<jsp:include page="../common/cmnjs.jsp"></jsp:include>

</body>
</html>