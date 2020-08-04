<%@ page import="com.xzt.utils.RandomCardId" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>开户</title>
<link rel="stylesheet" type="text/css" href="/static/css/regist.css" />
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>

    <base href="${pageContext.request.contextPath}/">

</head>
<body>

<div class="wrapper">
        <article>
            <h1><em></em><span>ATM系统</span></h1>
            <div class="main">
                <form action="register" method="post" id="form">
                    <div class="tel">
                    <em><span id="s_telphone" class="error"></span></em>
                        <input type="tel" name="telephone" id="telephone"  placeholder="手机号">

                    </div>
                    <div class="userName">
                    <em><span id="s_username" class="error"></span></em>
                        <input type="text" name="userName" id="userName" placeholder="姓名，仅支持中文">

                    </div>

                    
                    <div class="userName">
                    <em><span id="s_identitycard" class="error"></span></em>
                        <input type="text" name="identityCard" id="identityCard" placeholder="身份证号">

                    </div>
                    
                    <div class="userName">
                    <em><span id="s_address" class="error"></span></em>
                        <input type="text" name="address" id="address" placeholder="家庭地址">

                    </div>
                    <% String cardId = RandomCardId.getBrankNumber("6"); %>
                    <% request.setAttribute("cardId",cardId);%>
                    <div class="userName">
                        <em><span id="s_address" class="error"></span></em>
                        <input type="hidden" name="cardId" id="cardId" value="<%=request.getAttribute("cardId")%>" placeholder="银行卡号">

                    </div>
                    
                     

                    <div class="password">
                   <em> <span id="s_password" class="error"></span></em>
                        <input type="password" name="password" id="password" placeholder="密码,六位阿拉伯数字">

                    </div>
                    <div class="againpwd">
                    <button type="submit">开户</button>
                </form>
            </div>
        </article>
        
    </div>
<script src="/static/js/register.js"></script>
</body>
</html>