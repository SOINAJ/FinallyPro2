var id = 0
var now_num = 1
var number = 1
var part = ""
$(document).ready(function () {
    part = getQueryVariable("part")
    // if (part.substring(0,1) == 'U'){
    //     $(".navleft").css("display","none")
    //     $(".navright").css("display","none")
    // }
    getMessage_complain(part)
    profile_down(part)
    profile_line(part)
})

function getQueryVariable(variable) {
    var query = window.location.search.substring(1)
    var vars = query.split("&")
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=")
        if (pair[0] == variable) {
            return pair[1]
        }
    }
    return false
}

function getMessage_complain(pair) {
    var url = "../RCheck/mes/" + pair
    $.ajax({
        url: url,
        type: "GET",
        datatype: "json",
        contentType: "application/json",
        // data:,
        success: function (data) {
            // console.log("getmes : "+data)
            make_profile(data.data)
        },
        error: function (data) {
            console.log("error")
        }
    })
}

function onBtn1() {
    $(".mybtn1").css("display", "none")
    $(".mybtn2").css("display", "inline-block")
    $(".myZG").attr("type", "text")
    $(".mySFZ").attr("type", "text")
}

function onBtn2() {
    $(".mybtn2").css("display", "none")
    $(".mybtn1").css("display", "inline-block")
    $(".myZG").attr("type", "password")
    $(".mySFZ").attr("type", "password")
}

function navImg1() {
    $(".img1").css("display", "block")
    $(".img2").css("display", "none")
    $(".mysfz").css("display", "block")
    $(".myzg").css("display", "none")
    $(".myZG").attr("type", "password")
    $(".mySFZ").attr("type", "password")
}

function navImg2() {
    $(".img2").css("display", "block")
    $(".img1").css("display", "none")
    $(".myzg").css("display", "block")
    $(".mysfz").css("display", "none")
    $(".myZG").attr("type", "password")
    $(".mySFZ").attr("type", "password")
}

function make_User() {
    $(".myaccount").html("普通用户账号资料信息")
    $(".navleft").css("display", "none")
    $(".navright").css("display", "none")
    $(".myassess").css("display", "none")
    $(".img2").css("display", "none")
    $(".w_profile").css("display", "none")
}

function make_Work() {
    $(".myaccount").html("工作人员账号资料信息")
}

function make_profile(data) {
    // var this_data =
    // console.log("this_data:"+data.prove)

    $(".myplace").text(data.place)
    $(".mytalk").text(data.talk)
    $(".myname").text(data.name)
    console.log(data.part)
    switch (data.part.substring(0, 1)) {
        case "A":
            make_User()
            var str = data.sfzMes
            // console.log(str)
            var string = str.substring(str.indexOf("码") + 1, str.length)
            // console.log(string)
            $(".mySFZ").val(string)
            if (!isEmpty(data.sfz)) {
                $(".img1").attr("src", data.sfz)
            }
            break
        case "B":
            // $(".myaccount").html("工作人员账号资料信息")
            make_Work()
            if (!isEmpty(data.sfz)) {
                $(".img1").attr("src", data.sfz)
            }
            if (!isEmpty(data.prove)) {
                $(".img2").attr("src", data.prove)
                navImg1()
            }
            break
    }
    // if (data.part.substring(0, 1) == "A") {
    //     $(".myaccount").html("普通用户账号资料信息")
    //     var str = data.sfzMes
    //     var string = str.substring(str.indexOf("码") + 1, str.length)
    //     $(".mySFZ").text(string)
    // }else{
    //     $(".myaccount").html("工作人员账号资料信息")
    //     if (!isEmpty(data.sfz)) {
    //         $(".img1").attr("src", data.sfz)
    //     }
    //     if (!isEmpty(data.prove)) {
    //         $(".img2").attr("src", data.prove)
    //         navImg1()
    //     }
    // }
}

function isEmpty(str) {
    if (str == null || $.trim(str) == "" || str == "null" || str.length === 0) {
        return true;
    }
    return false;
}

function profile_down(pair) {
    var url = "../RCheck/down/" + pair
    $.ajax({
        url: url,
        type: "GET",
        datatype: "json",
        contentType: "application/json",
        // data:,
        success: function (data) {
            // console.log(data.data)
            //记得注入数据去number
            make_down(data.data)
        },
        error: function (data) {
            console.log("error")
        }
    })
}

function profile_line(pair) {
    // console.log(number)
    $(".mysk-wave").attr("display", "block")
    if (now_num <= number) {
        var url = "../RCheck/line/" + pair + "?num=" + now_num
        $.ajax({
            url: url,
            type: "GET",
            datatype: "json",
            contentType: "application/json",
            // data:,
            success: function (data) {
                // console.log(data.data)
                make_line(data.data)
            },
            error: function (data) {
                // now_num--
                console.log("error")
            }
        })
    } else {
        $(".mysk-wave").attr("display", "none")
        $(".m").css("display", "none")
    }
}

function make_down(data) {
    if (!isEmpty(data)) {
        $(".myfinsh").text(data[0])
        $(".myscope").text(data[1] + (3 * data[2]))
        $(".mycomplain").text(data[3])

        if (data[2] % 6 == 0) {
            number = data[2] / 6
        } else {
            number = (data[2] / 6) + 1
        }
        console.log(data[1])
        console.log(data[2])
        $("#sparkline10").sparkline([data[0] * 5, data[1], data[2] * 3], {
            type: "pie",
            height: "150px",
            sliceColors: ["#1ab394",  "#66AFE9","#b3b3b3"]
        })
        $("#sparkline10").css("margin-left", "100px")
    }
}

function make_line(data) {
    if (!isEmpty(data)) {
        var text = ""
        switch (part.substring(0, 1)) {
            case "U":
                for (var i = 0; i < data.length; i++) {
                    text +=
                        '<div class="feed-element">' +
                        '<a href="profile.html#" class="pull-left">' +
                        '<img alt="image" class="img-circle" src="/img/profile.jpg">' +
                        '</a>' +
                        '<div class="media-body ">' +
                        '<small class="pull-right">' + data[i].date + ' </small>' +
                        '被投诉对象<strong>' + data[i].work + '</strong> ' +
                        '<br>' +
                        '<small class="text-muted"></small>' +
                        '<br>' +
                        '<small class="text-muted">' + data[i].message + '</small>' +
                        '</div>' +
                        '</div>'
                }
                break
            case "W":
                for (var i = 0; i < data.length; i++) {
                    text +=
                        '<div class="feed-element">' +
                        '<a href="profile.html#" class="pull-left">' +
                        '<img alt="image" class="img-circle" src="/img/profile.jpg">' +
                        '</a>' +
                        '<div class="media-body ">' +
                        '<small class="pull-right">' + data[i].date + ' </small>' +
                        '<strong>' + data[i].user + '</strong> 对其投诉' +
                        '<br>' +
                        '<small class="text-muted"></small>' +
                        '<br>' +
                        '<small class="text-muted">' + data[i].message + '</small>' +
                        '</div>' +
                        '</div>'
                }
                break
        }

        $(".myfeed").append(text)
        $(".mysk-wave").attr("display", "none")
    }
}

function onclick_more() {
    now_num++
    profile_line(part)
}

function onclick_pass() {
    var url = "../RCheck/" + part
    $.ajax({
        url: url,
        type: "POST",
        datatype: "json",
        contentType: "application/json",
        // data:,
        success: function (data) {
            console.log(data.data)
            if (data.code == '20021') {
                alert("审核通过")
            } else {
                alert("审核工作异常")
            }
        },
        error: function (data) {
            // now_num--
            console.log("error")
        }
    })
}

function a_onclick_danger(){
    var url = "../RCheck/del/" + part
    $.ajax({
        url: url,
        type: "DELETE",
        datatype: "json",
        contentType: "application/json",
        // data:,
        success: function (data) {
            console.log(data)
            if (data.code == "20031"){
                alert("该账号已注销")
            }
            //记得注入数据去number
            // make_down(data.data)
        },
        error: function (data) {
            console.log("error")
        }
    })
}