
<!-- cookie操作 start-->

/**
 * 写入cookie
 *
 * @param name
 * @param value
 */
function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";

}

/**
 * 读取cookie
 * @param name
 * @returns {null}
 */
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

/**
 * 删除cookie
 * @param name
 */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}
function isNull(obj) {
    if (obj == null || obj == undefined || obj.trim() == ""||obj=="undefined") {
        return true;
    }
    return false;
}
/**
 * 检查cookie
 */
function checkCookie() {
    if (isNull(getCookie("beforeuser"))) {
        alert("未登录！");
        window.location.href = "/before/login.html";
    }
}

//检查后台的cookie
function checkCookieAdmin() {
    if (isNull(getCookie("adminuser"))) {
        alert("未登录！");
        window.location.href = "/admin/login.html";
    }
}


//注销前台用户
function zhuxiao() {
    setCookie("beforeuser","");
    window.location.href = "/before/index.html";
}


//注销后台用户
function zhuxiaoadmin() {
    setCookie("adminuser","");
    window.location.href = "/admin/index.html";
}



/**
 * 检查cookie
 */
function checkResultCode(code) {
    if (code == 402) {
        window.location.href = "login.jsp";
    }
}
