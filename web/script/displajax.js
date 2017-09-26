var ajax;

window.onload = init;

function init() {
    ajax = getXMLHttpRequestObject();
    if (ajax) {
        if (document.getElementById('main_feed')) {
            document.getElementById('ReturnHome').onsubmit = function () {                
                ajax.open('get','NewsFeed.jsp?btnRetHome=Home');
                ajax.onreadystatechange = function() { handleResponse(); };
                ajax.send(null);
                return false;
            };
            
            document.getElementById('ViewCharacters').onsubmit = function () {                
                ajax.open('get','ViewChars.jsp?btnViewChars="View Champions"');
                ajax.onreadystatechange = function() { handleResponse(); };
                ajax.send(null);
                return false;
            };
            
            document.getElementById('ViewStats').onsubmit = function () {                
                ajax.open('get','ViewStats.jsp?btnViewStats="View Statistics"');
                ajax.onreadystatechange = function() { handleResponse(); };
                ajax.send(null);
                return false;
            };
            
            document.getElementById('BattleMenu').onsubmit = function () {                
                ajax.open('get','BattleMenu.jsp?btnBattleMenu="Battle Menu"');
                ajax.onreadystatechange = function() { handleResponse(); };
                ajax.send(null);
                return false;
            };
        }
    }
}

function handleHomeResponse() {
    if (ajax.readyState === 4) {
        if (ajax.status === 200 || ajax.status === 304) {
            var r = document.getElementById('main_feed');
            r.innerHTML = ajax.responseText;
        } else {
            document.getElementById('ReturnHome').submit();
        }
    }
}

function handleViewCharsResponse() {
    if (ajax.readyState === 4) {
        if (ajax.status === 200 || ajax.status === 304) {
            var r = document.getElementById('main_feed');
            r.innerHTML = ajax.responseText;
        } else {
            document.getElementById('ViewChars').submit();
        }
    }
}

function handleViewStatsResponse() {
    if (ajax.readyState === 4) {
        if (ajax.status === 200 || ajax.status === 304) {
            var r = document.getElementById('main_feed');
            r.innerHTML = ajax.responseText;
        } else {
            document.getElementById('ViewStats').submit();
        }
    }
}

function handleBattleMenuResponse() {
    if (ajax.readyState === 4) {
        if (ajax.status === 200 || ajax.status === 304) {
            var r = document.getElementById('main_feed');
            r.innerHTML = ajax.responseText;
        } else {
            document.getElementById('BattleMenu').submit();
        }
    }
}