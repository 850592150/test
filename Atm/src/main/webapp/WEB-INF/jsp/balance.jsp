<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">

    <meta charset="utf-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css" />
</head>
<body>
<div>您的余额为：${balance}</div>
<a href="/"><button>返回</button></a>

<%--<input type=button οnclick="window.location.href('findBalanceByCardId/${card.cardId}')" value="返回">--%>
</body>
</html>