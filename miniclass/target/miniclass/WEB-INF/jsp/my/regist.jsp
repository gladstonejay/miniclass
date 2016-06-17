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
    <jsp:include page="../common/cmnjs.jsp"></jsp:include>

</head>

<body>
<div class="page-group">
    <div class="page page-current">
        <header class="bar bar-nav">
            <button class="button button-link button-nav pull-left">
                <span class="icon icon-left"></span><a href="/my/login.j" external style="color:#FFFFFF" >
                返回
            </a></button>
            <h1 class='title'>注册</h1>
        </header>
        <div class="content">
            <form class="zform zform-radius" action="/my/registCheck.j" method="post" id="form1">
            <div class="list-block">
                <ul>
                    <!-- Text inputs -->
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-name"></i></div>
                            <div class="item-inner">
                                <div class="item-title label">电话</div>
                                <div class="item-input">
                                    <input type="text" placeholder="请输入您的电话号码" id="userId" name="userId" value="${ubVo.userId}" data-validate="userId" data-describedby="userId-description">
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-email"></i></div>
                            <div class="item-inner">
                                <div class="item-title label">昵称</div>
                                <div class="item-input">
                                    <input type="text" placeholder="请输入您想使用的昵称" id="userNname" name="userNname" value="${ubVo.userNname}"  data-validate="userNname" data-describedby="userNname-description">
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-password"></i></div>
                            <div class="item-inner">
                                <div class="item-title label">密码</div>
                                <div class="item-input">
                                    <input type="password" placeholder="请输入6-24位密码：字母或数字组合" id="password" name="password" value="${ubVo.password}" data-validate="password" data-describedby="password-description">
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-password"></i></div>
                            <div class="item-inner">
                                <div class="item-title label">密码确认</div>
                                <div class="item-input">
                                    <input type="password" placeholder="请再次输入密码" id="passwordSure" name="passwordSure" value="${ubVo.passwordSure}" data-required="true" data-descriptions="passwordSure" data-conditional="passwordSure">
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-email"></i></div>
                            <div class="item-inner">
                                <div class="item-title label">验证码</div>
                                <div class="item-input">
                                    <input type="text" placeholder="请输入验证码" name="code" value="${usVo.code}" id="code" data-conditional="code" data-descriptions="code">
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-email"></i></div>
                            <div class="item-inner">
                                <div class="item-title"><img src="/my/captcha.j" /></div>
                            </div>
                        </div>
                    </li>
                    <li><p span style="color:red;" >${errorId}</p><p span style="color:red;">${errorNname}</p></li>
                    <li><input type="hidden" name="location" value="${location}"></li>
                </ul>
            </div>
            <div class="content-block">
                <div class="row">
                    <div class="col-100"><input type="submit" class="button button-big button-fill button-success" value="注册" id="submit-button"></div>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>


<script type="text/javascript">

    $(function () {
        $.mvalidateExtend({
            userId:{
                required : true,
                pattern : /^0?1[3|4|5|8][0-9]\d{8}$/,
                each:function(){
                },
                descriptions:{
                    required : '<div class="field-invalidmsg">请输入手机号码</div>',
                    pattern : '<div class="field-invalidmsg">手机号码格式不正确</div>',
                    valid : '<div class="field-validmsg">正确</div>'
                    }
                },
            userNname:{
                required : true,
                pattern :  /^\S{5,24}(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/,
                each:function(){
                },
                descriptions:{
                    required : '<div class="field-invalidmsg">请输入昵称</div>',
                    pattern : '<div class="field-invalidmsg">昵称请输入6-24位字符：支持中文、英文、数字、“_”</div>',
                    valid : '<div class="field-validmsg">正确</div>'
                }
            },
            password:{
                required : true,
                pattern :  /^\S{5,24}(?!_)(?!.*?_$)[a-zA-Z0-9]+$/,
                each:function(){
                },
                descriptions:{
                    required : '<div class="field-invalidmsg">请输入密码</div>',
                    pattern : '<div class="field-invalidmsg">密码请输入6-24位密码：支持英文、数字</div>',
                    valid : '<div class="field-validmsg">正确</div>'
                }
            }
        });
        $("#form1").mvalidate({
            type:1,
            validateInSubmit:true,
            sendForm:true,
            firstInvalidFocus:false,
            valid:function(event,options){
                //点击提交按钮时,表单通过验证触发函数
            },
            invalid:function(event, status, options){
                //点击提交按钮时,表单未通过验证触发函数
            },
            eachField:function(event,status,options){
                //点击提交按钮时,表单每个输入域触发这个函数 this 执向当前表单输入域，是jquery对象
            },
            eachValidField:function(val){},
            eachInvalidField:function(event, status, options){},
            conditional: {
                passwordSure: function (val) {
                    return val == $("#password").val();
                },
                code:function(val){
                    if(!val && !val.length) return false;
                    var flag
                    $.ajax({
                        url:"/my/captchaCheck.j",
                        type:"post",
                        async:false,
                        data:{code:val},
                        dataType: "json",
                        error:function(){
                            alert('error');
                        },
                        success:function(data){
                            flag=(data.success==0) ? true : false;
                        }
                    });
                    return flag;
                }
            },
            descriptions:{
                userId:{
                    required : '请输入手机号'
                },
                userNname:{
                    required : '请输入昵称'
                },
                password:{
                    required : '请输入密码'
                },
                passwordSure:{
                    required : '请再次输入密码',
                    conditional : '两次密码不一样'
                },
                code:{
                    required:  '请输入验证码',
                    conditional : '您输入的验证码不正确'
                }
            }
        });
    })

</script>
</body>
</html>