window.onload = function () {
    //给表单绑定onsubmit事件
    document.getElementById("form").onsubmit = function () {
        return checktransMoney();
    }

    //给交易金额绑定离焦事件
    document.getElementById("transMoney").onblur = checktransMoney;

}








//校验开户金额
function checktransMoney(){
    //1.获取开户存入金额的值
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
        s_transMoney.innerHTML = "<font color='red'>存入金额格式输入错误</font>";
    }
    return flag;
}
