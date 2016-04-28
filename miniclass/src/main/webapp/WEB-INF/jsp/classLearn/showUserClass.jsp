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
            <h1 class="title"><span class="icon" ><img src="../../../static/imags/tab/tab4-active.png" width="22" ></span> 我的课程</h1>
        </header>
        <%@ include file="../common/bottom.jsp" %>
        <div class="content">

            <div class="card demo-card-header-pic">
                <div valign="bottom" class="card-header color-white no-border no-padding">
                    <img class='card-cover' src="../../../static/imags/tab1_milk.png" alt="">
                </div>
                <div class="card-content">
                    <div class="card-content-inner" style="text-align: center">
                        <p>各位母婴店的销售精英们：大家好</p>
                        <p>母婴营养达人微课堂开课啦！</p>
                        <p>本课程旨在帮您：</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;高效轻松的学习，让您的话术更专业</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;专业营养师授课，令您的知识更系统</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;系统的课程回看，使您的学习更方便</p>
                    </div>
                </div>
            </div>

            <div class="card demo-card-header-pic">
                <div class="card-content">
                    <div class="card-content-inner" style="text-align: center">
                        <p>还在比价格？比赠品？</p>
                        <p>那就被淘汰了！</p>
                        <p>你知道什么是奶粉销售的制胜法宝吗？</p>
                        <p>你知道如何才能成为老板满意、妈妈信赖的营养顾问吗？</p>
                        <P>欢迎来到母婴营养微课堂，开启你专业母婴营养顾问之旅。</P>
                    </div>
                </div>
                <div>
                    <p style="text-align: center"> <img src="../../../static/imags/precast.png" width="296"></p>
                </div>
            </div>


            <c:forEach items="${videoInfoList}" var="item" varStatus="xh">
                <c:if test="${item.orderId=='1'}">
                <p style="text-align: center"><img src="../../../static/imags/month/5.0.png"  width="163" ></p>
                </c:if>
                <c:if test="${item.orderId=='3' || item.orderId=='7' || item.orderId=='11' ||item.orderId=='15' ||item.orderId=='19' ||item.orderId=='23' ||item.orderId=='27'}">
                <p style="text-align: center"><img src="../../../static/imags/month/${((item.orderId-3)/4+6)}.png"  width="163" ></p>
                </c:if>
            <div class="card">
                <div class="card-content">
                    <div class="list-block media-list">
                        <ul>
                            <li>
                                <c:choose>
                                <c:when test="${item.videoId !=null }">
                                <a href="/classLearn/showOneClass.j?id=${item.orderId}" external class="item-link item-content">
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#" external class="item-link item-content">
                                    </c:otherwise>
                                    </c:choose>
                                    <div class="item-media"><i class="icon icon-f7"></i></div>
                                <div class="item-media">
                                    <%--<img src="../../../static/imags/video${item.orderId}.png" width="44">--%>
                                        <img src="../../../static/imags/video1.png" width="44">
                                </div>
                                <div class="item-inner">
                                    <div class="item-title-row">
                                        <div class="item-title">第${item.orderId}讲</div>
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