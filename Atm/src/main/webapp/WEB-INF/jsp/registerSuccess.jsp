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
    <base href="${pageContext.request.contextPath}/">

</head>
<body>

<div class="wrapper">
    <article>
        <h1><em></em><span>开户成功</span></h1>
        <div>
           您开户的银行卡号为： ${cardId}
        </div>
        <a href="/">登录<a>
    </article>

</div>

</body>
</html>