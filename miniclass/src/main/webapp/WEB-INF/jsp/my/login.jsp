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
<body bgcolor="#229ddf">
<div class="page-group">
    <div class="page page-current">
        <header class="bar bar-nav" >
            <button class="button button-link button-nav pull-right"><a href="/my/chooseLocation.j" external style="color:#FFFFFF">
                注册
            </a><span class="icon icon-right"></span>
            </button>
            <h1 class='title'>登录</h1>
        </header>
        <%@ include file="../common/bottom4.jsp" %>
        <div class="content">
            <form class="zform zform-radius" action="/my/loginCheck.j" method="post" id="form1">
            <div class="list-block">
                <ul>
                    <!-- Text inputs -->
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-name"></i></div>
                            <div class="item-inner">
                                <div class="item-title label">电话</div>
                                <div class="item-input">
                                    <input type="text" placeholder="请输入电话号码" id="userId" name="userId" value=${userId}>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-email"></i></div>
                            <div class="item-inner">
                                <div class="item-title label">密码</div>
                                <div class="item-input">
                                    <input type="password" placeholder="请输入密码" id="password" name="password" value=${ubVo.password}>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li><p span style="color:red;" >${errorId}</p><p span style="color:red;">${errorNname}</p></li>
                </ul>
            </div>
            <div class="content-block">
                <div class="row">
                    <div class="col-100"><input type="submit" class="button button-big button-fill button-success" value="登录" id="submit-button"></div>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../common/cmnjs.jsp"></jsp:include>

</body>
</html>