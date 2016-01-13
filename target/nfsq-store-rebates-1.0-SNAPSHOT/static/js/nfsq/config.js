+function(window){
	function getQueryParams(){
        var params = window.location.search;
        var obj = new Object;
        if(!params){
            return obj;
        }
        var param_array = params.substring(1).split("&");
        for(var i in param_array) {
            var temp = param_array[i].split("=");
            obj[temp[0]] = temp[1];
        }
        return obj;
	}
	// window.UNAUTH_URL = "sapSignon/unauthenticated";
	// window.ROOT = 'http://127.0.0.1:8080/display-service/';
    window.REMOTE_IMPORT_URL = "http://uidev.nfsq.com.cn/nfsq_ui";
    //window.REMOTE_IMPORT_URL = "http://127.0.0.1/nfsq_ui";

}(window);