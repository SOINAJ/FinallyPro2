var id = 0

$(document).ready(function () {
    id = getQueryVariable("id")
    getMessage_complain(id)
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

function showtext(){
    $(".myReturn").css("display","block")
    $(".myAreturn").css("display","none")
    $(".myAcancle").css("display","inline")
}

function hiddentext(){
    $(".myReturn").css("display","none")
    $(".myAreturn").css("display","inline")
    $(".myAcancle").css("display","none")
}

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

function makeMes(data) {
    if (!isEmpty(data)){
        $(".myspanB").html("")
        $(".mytime").html("")
        $(".myspanA").html("")
        $(".myPmes").html("")
        $(".mypeople").html("")
        $(".myspanB").html(data.work)
        $(".mytime").html(data.date)
        $(".myspanA").html(data.user)
        $(".myPmes").html(data.message)
        $(".mypeople").html(data.user)
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

function root_return(){
    var returnBtn = $(".form-control").val()
    $.ajax({
        url: "../RComplains/mes",
        type: "POST",
        datatype: "json",
        contentType: "application/json",
        data:{
            "id":id,
            "returnBtn":returnBtn
        },
        success: function (data) {
            console.log(data)
            runback(data.code);
        },
        error: function (data) {
            console.log("error")
        }
    })
}

function runback(oh){
    // switch (oh){
    //   case "20041":
    //     break;
    //   case "20031":
    //     break;
    //   case "20021":
    //     break;
    //   case "20011":
    //     break;
    // }
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