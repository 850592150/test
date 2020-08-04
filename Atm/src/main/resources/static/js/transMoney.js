window.onload = function () {
    //给表单绑定onsubmit事件
    document.getElementById("form").onsubmit = function () {
        return checktransMoney()&&checkCardId();
    }

    //给交易金额绑定离焦事件
    document.getElementById("transMoney").onblur = checktransMoney;

    //给对方银行卡号绑定离焦事件
    document.getElementById("otherCardId").onblur = checkCardId;

}








//校验取出金额格式
function checktransMoney(){
    //1.获取取出金额的值
    var transMoney = document.getElementById("transMoney").value;
    //2.定义正则表达式
    var reg_transMoney = /^\d+$|^\d+[.]?\d+$/;
    //3.判断值是否符合正则的规则
    var flag = reg_transMoney.test(transMoney);
    //4.提示信息
    var s_transMoney = document.getElementById("s_transMoney");

    if(flag){
        //提示绿色对勾
        s_transMoney.innerHTML = "<img width='35' height='25' src='/static/img/rememberPassword2.png' />";
    }else{
        //提示红色错误信息
        s_transMoney.innerHTML = "<font color='red'>转账金额格式输入错误</font>";
    }
    return flag;
}

//校验银行卡号格式
function checkCardId(){
    //1.获取对方银行卡号的值
    var otherCardId = document.getElementById("otherCardId").value;
    //2.定义正则表达式,银行卡号(16~19)位正则验证
    var reg_cardId2 = /^([1-9]{1})(\d{15}|\d{18})$/;
    //3.判断值是否符合正则的规则
    var flag = reg_cardId2.test(otherCardId);
    //4.提示信息
    var s_cardId = document.getElementById("s_cardId");

    if(flag){
        //提示绿色对勾
        s_cardId.innerHTML = "<img width='35' height='25' src='/static/img/rememberPassword2.png' />";
    }else{
        //提示红色错误信息
        s_cardId.innerHTML = "<font color='red'>对方银行卡号格式输入错误</font>";
    }
    return flag;
}
