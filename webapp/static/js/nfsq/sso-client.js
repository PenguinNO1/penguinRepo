/**
 * Created by chenqi on 15/8/27.
 */
/*
 * 基础信息定义
 */
var redrict_url = window.location.href;
if(redrict_url.indexOf("#") > 0){
    redrict_url = redrict_url.substring(0,redrict_url.indexOf("#"));
}

var client = new Object;
client["client_id"] = "crmtest";
client["client_secret"] = "crm-test";

var authUrl = new Object;
//authUrl["domain"] = "http://10.1.4.9/nfsq-sso/oauth2";
authUrl["domain"] = "http://10.1.3.223/nfsq-sso/oauth2";
authUrl["authorize"] = authUrl["domain"] + "/authorize?response_type=token&state=portal"
    + "&client_id=" + client.client_id
    + "&redirect_uri=" + redrict_url
    + "&rd=" + new Date().getTime();
authUrl["refresh"] = authUrl["domain"] + "/refreshToken?response_type=token";


var auth_cookie;
(function(){
    //1.获取cookie
    auth_cookie =  _OAuth_SDK.getAuth();
    //2.刷新令牌不存在，则再解析url(当回调时会进入这一步)
    if(!auth_cookie.refresh_token){
        _OAuth_SDK.setAuthWithFragment(client);
        auth_cookie = _OAuth_SDK.getAuth();
    }
    //3.刷新令牌还是不存在，则引导用户到登陆界面
    if(!auth_cookie.refresh_token){
        window.location.href = authUrl.authorize;
        return;
    }
    //**以上可以确保refresh_token一定存在
    //4.访问令牌不存在，则使用刷新令牌去获取
    if(!auth_cookie.access_token){
        refreshToken();
        return;
    }
    //5.定时刷新access_token
    _OAuth_SDK.timerRefresh(refreshToken, 5 * 60 * 1000);
})();

function refreshToken() {
    $.ajax({
        type: "GET",
        url: authUrl.refresh,
        dataType: "jsonp",
        jsonpCallback: "callback",
        data: {
            grant_type: "refresh_token",
            refresh_token: auth_cookie.refresh_token,
            client_id: client.client_id
        }
    });
}


//定义回调接口(刷新refresh_token时需要定义)
function callback(json){
    if(json.error){
        //重置auth,必须调用
        _OAuth_SDK.resetAuth();
        alert(json.error);
        console.debug(json.error);
        return;
        //window.location.href = authUrl.authorize;
        //return;
    }
    _OAuth_SDK.setAuth({
        access_token: json.access_token
    });
}