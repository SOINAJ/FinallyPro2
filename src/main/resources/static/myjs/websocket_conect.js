function conectWebSocket(data) {

    $(".talk_send").css("display","block")

    $(".talk_friend h4").css("background", "#FFFFFF")
    $(data).css("background", "#CCCCCC")
    $(".uname").text($(data).text())
    $(".talk_message").text("")
    // var key = "<a>查看更多聊天记录</a>"
    // $(".talk_message").html(key)

    // var username = $("#nickname").text()
    // var toUser = $(data).text()
    // var nickname = username +":"+ toUser
    var nickname = $(data).attr("class")


    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/mysocket/" + nickname);
    } else {
        alert('Not support websocket')
    }
    //连接发生错误的回调方法
    websocket.onerror = function () {
        // setMessageInnerHTML("error");
    };
    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        // setMessageInnerHTML("Loc MSG: 成功建立连接");
    }
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        console.log(event)
        setMessageInnerHTML(event.data);
    }
    //连接关闭的回调方法
    websocket.onclose = function () {
        // setMessageInnerHTML("Loc MSG:关闭连接");
    }
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        websocket.close();
    }

}

//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    var arr = innerHTML.split(":")
    var message = ""
    console.log(arr[1])
    if (arr[2] == "1") {
        message = '<div class="mytestyou"><span class="youmes">' + arr[1] + '</span><p></p></div>'
    } else {
        message = '<div class="mytestmy"><span class="mymes">' + arr[1] + '</span><p></p></div>'
    }
    $(".talk_message").append(message)
}

//关闭连接
function closeWebSocket() {
    websocket.close();
}

function send_mes() {
    var toUser = $(".uname").text()
    if (!isEmpty(toUser)) {
        var message = $(".mytextarea").val()
        var socketMsg = {msg: message, toUser: toUser};
        //单聊.
        socketMsg.type = 1;
        websocket.send(JSON.stringify(socketMsg));
        $(".mytextarea").val("")
    }

}