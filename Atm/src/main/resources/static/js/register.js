window.onload = function () {
    //给表单绑定onsubmit事件
    document.getElementById("form").onsubmit = function () {
        return checkUsername() && checkPassword() &&checkIdentitycard() && checkAddress() && checkTelphone();
    }

    //给用户名和密码框、Email、姓名、手机号分别绑定离焦事件
    document.getElementById("telephone").onblur = checkTelphone;
    document.getElementById("userName").onblur = checkUsername;
    document.getElementById("identityCard").onblur = checkIdentitycard;
    document.getElementById("address").onblur = checkAddress;
    document.getElementById("password").onblur = checkPassword;
}

//校验姓名
function checkUsername() {
    //获取姓名的值
    var username = document.getElementById("userName").value;

    //定义正则表达式
    var reg_username = /^[\u4e00-\u9fa5]+$/;
    //判断值是否符合正则表达式的规则
    var flag = reg_username.test(username);

    //提示信息
    var s_username = document.getElementById("s_username");

    if (flag) {
        //提示绿色对勾
        s_username.innerHTML = "<img width='35' height='25' src='/static/img/rememberPassword2.png' />";
    } else {
        //提示红色错误信息
        s_username.innerHTML = "<font color='red'>姓名格式有误，仅支持中文姓名</font>";
    }
    return flag;
}

//校验密码
function checkPassword(){
    //1.获取密码的值
    var password = document.getElementById("password").value;
    //2.定义正则表达式
    var reg_password = /^\d{6}$/;
    //3.判断值是否符合正则的规则
    var flag = reg_password.test(password);
    //4.提示信息
    var s_password = document.getElementById("s_password");

    if(flag){
        //提示绿色对勾
        s_password.innerHTML = "<img width='35' height='25' src='/static/img/rememberPassword2.png' />";
    }else{
        //提示红色错误信息
        s_password.innerHTML = "<font color='red'>密码格式输入错误</font>";
    }
    return flag;
}
//校验身份证号码
function checkIdentitycard(){
    //1.获取身份证号的值
    var identityCard = document.getElementById("identityCard").value;
    //2.定义正则表达式
    var reg_identityCard = /^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;

    //3.判断值是否符合正则的规则
    var flag = reg_identityCard.test(identityCard);
    //4.提示信息
    var s_identitycard = document.getElementById("s_identitycard");

    if(flag){
        //提示绿色对勾
        s_identitycard.innerHTML = "<img width='35' height='25' src='/static/img/rememberPassword2.png' />";
    }else{
        //提示红色错误信息
        s_identitycard.innerHTML = "<font color='red'>身份证号码格式输入错误</font>";
    }
    return flag;
}

//校验手机号
function checkTelphone(){
    //1.获取手机号的值
    var telphone = document.getElementById("telephone").value;
    //2.定义正则表达式
    var reg_telphone = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    //3.判断值是否符合正则的规则
    var flag = reg_telphone.test(telphone);
    //4.提示信息
    var s_telphone = document.getElementById("s_telphone");

    if(flag){
        //提示绿色对勾
        s_telphone.innerHTML = "<img width='35' height='25' src='/static/img/rememberPassword2.png' />";
    }else{
        //提示红色错误信息
        s_telphone.innerHTML = "<font color='red'>手机号格式输入错误</font>";
    }
    return flag;
}

/*//校验开户金额
function checkOpenmoney(){
    //1.获取开户存入金额的值
    var openMoney = document.getElementById("openMoney").value;
    //2.定义正则表达式
    var reg_openMoney = /^\d+$|^\d+[.]?\d+$/;
    //3.判断值是否符合正则的规则
    var flag = reg_openMoney.test(openMoney);
    //4.提示信息
    var s_openMoney = document.getElementById("s_openmoney");

    if(flag){
        //提示绿色对勾
        s_openMoney.innerHTML = "<img width='35' height='25' src='/static/img/rememberPassword2.png' />";
    }else{
        //提示红色错误信息
        s_openMoney.innerHTML = "<font color='red'>开户金额格式输入错误</font>";
    }
    return flag;
}*/

//校验家庭地址
function checkAddress(){
    //1.获取家庭地址的值
    var address = document.getElementById("address").value;
    //2.定义正则表达式
    var reg_address = /^[A-Za-z0-9\u4e00-\u9fa5]+$/;
    //3.判断值是否符合正则的规则
    var flag = reg_address.test(address);
    //4.提示信息
    var s_address = document.getElementById("s_address");

    if(flag){
        //提示绿色对勾
        s_address.innerHTML = "<img width='35' height='25' src='/static/img/rememberPassword2.png' />";
    }else{
        //提示红色错误信息
        s_address.innerHTML = "<font color='red'>家庭地址格式输入错误</font>";
    }
    return flag;
}