var stompClient = null;
var socket;

//这个方法仅仅是用来改变样式，不是核心
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#notice").html("");
}

function openSocket() {
    if (typeof (WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
    } else {
        console.log("您的浏览器支持WebSocket");
        //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
        if (socket != null) {
            socket.close();
            socket = null;
        }
        socket = new WebSocket("ws://localhost:9999/webSocket/" + $("#userId").val());
        //打开事件
        socket.onopen = function (msg) {
            console.log("websocket已打开");
            setConnected(true)
            // socket.send("这是来自客户端的消息" + location.href + new Date());
        };
        //获得消息事件
        socket.onmessage = function (msg) {
            const msgDto = JSON.parse(msg.data);
            console.log(msg)
            showContent(msgDto);
            showOnlineUser(msgDto.onlineUser);
            //发现消息进入    开始处理前端触发逻辑
        };
        //关闭事件
        socket.onclose = function () {
            console.log("websocket已关闭");
            setConnected(false)
            removeOnlineUser();
        };
        //发生了错误事件
        socket.onerror = function () {
            setConnected(false)
            console.log("websocket发生了错误");
        }
    }
}

//2、关闭连接
function disconnect() {
    if (socket !== null) {
        socket.close();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    if (typeof (WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
    } else {
        var msg = '{"uid":"' + $("#userId").val() + '", "toUId": null, "content":"' + $("#content").val() + '"}';
        console.log("向服务端发送消息体：" + msg);
        socket.send(msg);
    }
}

// 订阅的消息显示在客户端指定位置
function showContent(serverMsg) {
    $("#notice").html("<tr><td>" + serverMsg.uid + ": </td> <td>" + serverMsg.content + "</td><td>" + serverMsg.dateTime + "</td></tr>" +  $("#notice").html())
    // $("#notice").append("<tr><td>" + serverMsg.uid + ": </td> <td>" + serverMsg.content + "</td><td>" + serverMsg.dateTime + "</td></tr>");
}

//显示实时在线用户
function showOnlineUser(serverMsg) {
    if (null != serverMsg) {
        let html = '';
        for (let i = 0; i < serverMsg.length; i++) {
            // $("#online").html("<tr><td>" + serverMsg[i] + "</td> <td>" + "时间" + "</td></tr>");
            html += "<tr><td>" + serverMsg[i] + "</td></tr>";
        }
        $("#online").html(html);
        $("#onLineUserCount").html(" ( " + serverMsg.length + " )");
    }
}

//显示实时在线用户
function removeOnlineUser() {
    $("#online").html("");
    $("#onLineUserCount").html("");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        openSocket();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendMessage();
    });
});

