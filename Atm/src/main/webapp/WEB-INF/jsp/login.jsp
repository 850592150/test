<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="/static/css/login.css" />
    <base href="${pageContext.request.contextPath}/">

</head>
<body>

  <div class="container">
        <div class="wrap">
            <header><em>ATM</em><span>ATM系统</span></header>
            <article>
                <section>
                    <aside>
                      
                         <form action="login" method="post">
                             <c:if test="${msg != ''}">
                                 <p style="color: red">${msg}</p>
                             </c:if>

                            <p class="name"><i></i><input type="text" name="cardId" name="cardId" class="userName" placeholder="请输入用户卡号"></p>
                            <p class="password"><i></i><input type="password" name="password" class="pwd" placeholder="请输入密码"></p>
                            <button type="submit">登录</button>

                            <p class="regist"><span>没有开户?</span><a href="toRegister">立即开户</a></p>
                            <div class="clear"></div>
                        </form>
                    </aside>
                   
                </section>               
            </article>
           
        </div>
    </div>
</body>
</html>