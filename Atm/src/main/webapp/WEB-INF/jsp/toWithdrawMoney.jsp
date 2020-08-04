<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>取钱</title>
    <link rel="stylesheet" type="text/css" href="/static/css/regist.css" />
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


</head>
<body>
<script src="/static/js/toWithdrawMoney.js"></script>
<div class="wrapper" >
    <article>
        <h1><em></em><span>ATM系统取钱</span></h1>
        <div class="main">
            <form action="withdrawMoney" method="post" id="form">
                <div class="tel">
                    <em><span id="" class="error"></span></em>
                    本人银行卡号：<input type="text" readonly="readonly"  name="cardId" id="cardId"  placeholder="" value="${cardId}">

                </div>

                <div class="tel">
                    <em><span id="s_withdrawMoney" class="error"></span></em>
                    请输入取出金额： <input type="text" name="transMoney" id="transMoney"  placeholder="取出金额">

                </div>
                <div class="userName">
                    <em><span id="s_remark" class="error"></span></em>
                    备注： <input type="text" name="remark" id="remark" placeholder="备注,可不填">

                </div>



                <button type="submit">取出</button>
            </form>

        </div>
    </article>
    <a href="/findAll/${cardId}" class="btn btn-default btn-lg active" role="button">返回</a>
</div>

</body>
</html>