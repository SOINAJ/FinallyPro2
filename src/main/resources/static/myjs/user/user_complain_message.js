var id = 0

$(document).ready(function () {
    id = getQueryVariable("id")
    getMessage_complain(id)
})

function getMessage_complain(pair) {
    var url = "../RComplains/mes/" + pair
    $.ajax({
        url: url,
        type: "GET",
        datatype: "json",
        contentType: "application/json",
        // data:,
        success: function (data) {
            console.log(data)
            makeMes(data.data)
        },
        error: function (data) {
            console.log("error")
        }
    })
}

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

function makeMes(data) {
    if (!isEmpty(data)){
        $(".myspanB").html("")
        $(".mytime").html("")
        $(".myspanA").html("")
        $(".myPmes").html("")
        $(".mypeople").html("")
        $(".mytextarea1").html()
        $(".myspanB").html(data.work)
        $(".mytime").html(data.date)
        $(".myspanA").html(data.user)
        $(".myPmes").html(data.message)
        $(".mypeople").html(data.user)
        $(".mytextarea1").html(data.talk)
    }else{
        alert("已是最后一封")
        id--
    }
}

function nextUrl(){
    // var id = getQueryVariable("id")
    id++
    console.log("id:"+id)
    getMessage_complain(id)
}


function runback(oh){
    if (oh == "20041" || oh == 20041) {
        swal({
            title: "投诉消息反馈已发送",
            text: "",
            type: "success",
            confirmButtonColor: "#009900",
            closeOnConfirm: false
        })
    }
    else {
        swal({
            title: "反馈失败",
            text: "消息上传可能有问题，上传失败",
            type: "warning",
            confirmButtonColor: "#DD6B55",
            closeOnConfirm: false
        })
    }
}