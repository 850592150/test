<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="/static/css/regist.css" />
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <base href="${pageContext.request.contextPath}/">


</head>
<body>

<div class="wrapper">
    <article>
        <h1><em></em><span>用户信息</span></h1>

        <div><font color="#f0f8ff">姓名:</font><font color="red">${user.userName}</font></div>
        <div><font color="#f0f8ff">电话:</font><font color="red">${user.telephone}</font></div>
        <div><font color="#f0f8ff">地址:</font><font color="red">${user.address}</font></div>


        <a href="logout"><button>退出</button></a>

        <a href="toWithdraw/${card.cardId}"><button>取款</button></a>
        <a href="toSaveMoney/${card.cardId}"><button>存款</button></a>
        <a href="toTrans/${card.cardId}"><button>转账</button></a>

       <%-- <a href="/findCardInfoByCardId/${card.cardId}">个人银行卡账户</a>--%>
        <a href="/findCardByCardId/${card.cardId}" class="btn btn-default btn-lg active" role="button">个人银行卡账户</a>









    </article>

</div>
<script src="/static/js/register.js"></script>
</body>
</html>