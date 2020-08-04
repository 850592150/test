<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">

    <meta charset="utf-8">
    <title>个人银行卡账户</title>
    <link rel="stylesheet" type="text/css" href="/static/css/regist.css" />
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>


</head>
<body>

<div class="wrapper">
    <article>
        <h1><em></em><span>抱歉，您的余额不足，请返回重新进行操作</span></h1>








        <a href="/findAll/${card.cardId}"><button><font color="red" style="font-size: large">返回</font></button></a>




    </article>

</div>
<script src="/static/js/register.js"></script>
</body>
</html>