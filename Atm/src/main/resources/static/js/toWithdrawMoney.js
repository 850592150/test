window.onload = function () {
    //给表单绑定onsubmit事件
    document.getElementById("form").onsubmit = function () {
        return checktransMoney();
    }

    //给交易金额绑定离焦事件
    document.getElementById("transMoney").onblur = checktransMoney;

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
    var s_withdrawMoney = document.getElementById("s_withdrawMoney");

    if(flag){
        //提示绿色对勾
        s_withdrawMoney.innerHTML = "<img width='35' height='25' src='/static/img/rememberPassword2.png' />";
    }else{
        //提示红色错误信息
        s_withdrawMoney.innerHTML = "<font color='red'>取款金额格式输入错误</font>";
    }
    return flag;
}
