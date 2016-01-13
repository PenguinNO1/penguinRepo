+function(window) {
    'use strict';

    var base,
        include = [
            'sso',              //统一登陆
            'common'            //自行定义其他本地组件
        ],
        need_remote = true;

    var _import = function (path){
        var i, type,
            src = "route.js",
        //html中已经加载的js文件，为的是取得base路径
            scripts = document.getElementsByTagName("script");
        //只解析一次
        if(!base){
            //遍历html中已经加载的js，取得整个应用加载js的base路径
            for (i = 0; i < scripts.length; i++) {
                if (scripts[i].src.match(src)) {
                    //不加载remote
                    if(scripts[i].getAttribute("remote") && scripts[i].getAttribute("remote") == "false"){
                        need_remote = false;
                    }
                    if(scripts[i].getAttribute("include")){
                        var t = scripts[i].getAttribute("include").toLowerCase();
                        include = t.toLowerCase().split(",");
                    }
                    base = scripts[i].src.substring(0, scripts[i].src.lastIndexOf(src));
                    break;
                }
            }
        }
        if(path.lastIndexOf(".js") > -1){
            type = "js";
        }
        if(path.lastIndexOf(".css") > -1){
            type = "css";
        }
        if(!type) {
            return;
        }
        path = (path.indexOf("http") > -1 ? path : (base + path));
        if(type.toLowerCase() == "css"){
            document.write("<" + "link href=\"" + path + "\" rel=\"stylesheet\" type=\"text/css\"></" + "link>");
        }else{
            document.write("<" + "script src=\"" + path + "\"></" + "script>");
        }
        console.info("load: [" + path + "] finish");
    };

    //首先加载本地配置文件
    _import('config.js');
    //如果有远程，就优先加载远程js，require中的组件由nfsq-adapter.js加载
    if(need_remote) {
        _import(window.REMOTE_IMPORT_URL + '/lib/nfsq-adapter.js');
    }

    //以下为每个应用自行定义，加载本地js
    for(var i in include){
        switch(include[i].trim()){
            case 'sso':
                //_import('http://10.1.4.9/nfsq-sso/open-api/oauth_sdk.js');
                _import('http://10.1.3.223/nfsq-sso/open-api/oauth_sdk.js');
                _import('sso-client.js');
                break;
            case 'common':
                //_import('app-utils.js');
                break;
            default:
                break;
        }
    }
}(window);