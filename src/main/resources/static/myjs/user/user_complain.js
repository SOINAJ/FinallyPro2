$(document).ready(function(){
    var user = window.parent.document.getElementById("mypart")
    var part = ($(user).html()).substring(0,2)
    $("#user").val(part)

    $(".select2").change(function(){
        Myoption()
    })

    // $(".form-report").ajaxForm(function (data) {
    //   var mydata = JSON.stringify(data)
    //   console.log("data" + data.code)
    //   console.log("data" + data)
    //   console.log("data" + mydata)
    //   runback(data.code)
    //   // $("#mysubmit1").val("修改图片")
    // })
})

function form_post(){
    $.ajax({
        url:"../UComplains",
        type:"post",
        contentType:"application/json",
        // contentType:"application/x-www-form-urlencoded",
        // processData:false,
        datatype:"json",
        data:$(".form-report").serialize(),
        success:function(data){
            runback(data.code)
            console.log(data)
        },
        error:function (data){
            console.log(data)
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
            title: "投诉成功",
            text: "我们将于3个工作日内处理,并且进行改进",
            type: "success",
            confirmButtonColor: "#009900",
            closeOnConfirm: false
        })
    }
    else {
        swal({
            title: "投诉消息上传失败",
            text: "消息上传可能有问题，上传失败",
            type: "warning",
            confirmButtonColor: "#DD6B55",
            closeOnConfirm: false
        })
    }
}



function Myoption(){
    var number = $(".select2").val()
    console.log(number)
    if(number == "4"){
        $(".otherlabel").css("display","block")
    }else{
        $(".otherlabel").css("display","none")
    }
}
