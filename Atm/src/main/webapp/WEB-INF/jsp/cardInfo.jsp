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
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


</head>
<body>

<div class="wrapper">
    <article>
        <h1><em></em><span>银行卡信息</span></h1>





        <font color="#f0f8ff"></font>
        <div><font color="#f0f8ff">银行卡号:</font><font color="red">${card.cardId} </font></div>
        <div><font color="#f0f8ff">余额:</font><font color="red">${card.balance}   </font></div>

       <%-- <a href="/findAll/${card.cardId}"><button>返回</button></a>--%>

        <a href="/findAll/${card.cardId}" class="btn btn-default btn-lg active" role="button">返回</a>


    </article>

</div>
<script src="/static/js/register.js"></script>
</body>
</html>