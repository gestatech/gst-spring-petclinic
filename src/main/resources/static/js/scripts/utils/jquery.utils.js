function requestContext() {
    var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
    if (contextPath == null) {
        contextPath = "/";
    }
    return (window.location.protocol + "//" + window.location.host + contextPath)
};

function getUrlParam(name) {
    var results = new RegExp('[\?&]' + name + '=([^]*)').exec(window.location.href);
    if (results == null) {
        return null;
    }
    else {
        return decodeURIComponent(results[1]) || 0;
    }
};

