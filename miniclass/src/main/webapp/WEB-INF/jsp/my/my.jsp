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
            <button class="button button-link button-nav pull-right"><a href="/my/loginOut.j" external style="color:#FFFFFF">
                注销
            </a><span class="icon icon-right"></span>
            </button>
            <h1 class='title'>我的微课堂</h1>
        </header>
        <%@ include file="../common/bottom4.jsp" %>
        <div class="content">
            <div class="card">
                <div class="card-content">
                    <div class="list-block media-list">
                        <ul>
                            <li class="item-content">
                                <div class="item-media">
                                    <img src="../../../static/imags/tab1_milk.png" width="44">
                                </div>
                                <div class="item-inner">
                                    <div class="item-title-row">
                                        <c:if test="${userShowInfo.userType=='n'}">
                                        <div class="item-title">学员</div>
                                        </c:if>
                                        <c:if test="${userShowInfo.userType=='a'}">
                                            <div class="item-title">管理员</div>
                                        </c:if>
                                    </div>
                                    <div class="item-subtitle">${userShowInfo.userNickName}</div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="list-block">
                <ul>
                    <li class="item-content">
                        <div class="item-media"><img src="../../../static/imags/tab/tab4-item1.png" width="34"></div>
                        <div class="item-inner">
                            <div class="item-title">累计上课 : ${userShowInfo.count}次</div>
                        </div>
                    </li>
                    <li class="item-content">
                        <div class="item-media"><img src="../../../static/imags/tab/tab4-item1.png" width="34"></div>
                        <div class="item-inner">
                            <div class="item-title">累计考试 : ${userShowInfo.examCount}次</div>
                        </div>
                    </li>
                    <li class="item-content">
                        <div class="item-media"><img src="../../../static/imags/tab/tab4-item2.png" width="34"></div>
                        <div class="item-inner">
                            <div class="item-title">我的积分 : ${userShowInfo.score}分</div>
                        </div>
                    </li>
                    <li class="item-content">
                        <div class="item-media"><img src="../../../static/imags/tab/tab4-item3.png" width="34"></div>
                        <div class="item-inner">
                            <div class="item-title">我的等级 : Level ${userShowInfo.level}</div>
                        </div>
                    </li>
                </ul>
            </div>

    </div>
</div>

<jsp:include page="../common/cmnjs.jsp"></jsp:include>

</body>
</html>