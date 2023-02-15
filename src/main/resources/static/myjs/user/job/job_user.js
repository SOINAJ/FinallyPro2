$(document).ready(
    getValue()
)


$(".myplace").blur(function (){
    var place = $(".myplace").val()
    if (isEmpty(place)){
        $("#msg_place").html("工作地址不能为空")
        var classname = $(".msg_place1").attr("class")
        classname += " animated rubberBand"
        $(".msg_place1").attr("class",classname)
        $(".msg_place1").css("display","block")
    }
})

$(".mytextarea").blur(function (){
    var textate = $(".mytextarea").val()
    if (isEmpty(textate)){
        $("#msg_textarea").html("工作内容简介不能为空")
        var classname = $(".msg_textarea1").attr("class")
        classname += " animated rubberBand"
        $(".msg_textarea1").attr("class",classname)
        $(".msg_textarea1").css("display","block")
    }
})

$(".start_date").focus(function (){
    $("#msg_start_date").text("")
    $(".msg_start_date1").attr("class","msg_start_date1")
})

$(".end_date").focus(function (){
    $("#msg_end_date").text("")
    $(".msg_end_date1").attr("class","msg_end_date1")
})



$(".myplace").focus(function (){
    $("#msg_place").text("")
    $(".msg_place1").attr("class","msg_place1")
})

$(".mytextarea").focus(function (){
    $("#msg_textarea").text("")
    $(".msg_textarea1").attr("class","msg_textarea1")
})

$(".start_date").blur(function (){
    var start_date = $(".start_date").val()
    if (isEmpty(start_date)) {
        $("#msg_start_date").html("开始时间不能为空")
        var classname = $(".msg_start_date1").attr("class")
        classname += " animated rubberBand"
        $(".msg_start_date1").attr("class", classname)
        $(".msg_start_date1").css("display", "block")
    }else
    {
        dataS_E()
    }
})

$(".end_date").blur(function (){
    var end_date = $(".end_date").val()
    if (isEmpty(end_date)) {
        $("#msg_end_date").html("结束时间不能为空")
        var classname = $(".msg_end_date1").attr("class")
        classname += " animated rubberBand"
        $(".msg_end_date1").attr("class", classname)
        $(".msg_end_date1").css("display", "block")
    }
})

function dataS_E(){
    var start_date = $(".start_date").val()
    $(".end_date").val(start_date)
}

function getValue(){
    $.ajax({
        url:"../checkUsers",
        type:"POST",
        datatype:"json",
        contentType:"application/json:charset=UTF-8",
        success:function (dat){
            $(".mypeople").val(dat.data.part)
        },
        error:function (e){
            console.log("error")
        }
    })
}

function getbtnFun(){
    var people = $(".mypeople").val()
    var place = $(".myplace").val()
    var data1 = Date.parse($(".start_date").val())
    var data2 = Date.parse($(".end_date").val())
    var market = $("#mymarket").val()
    var textate = $(".mytextarea").val()
    console.log(people+"!"+place+"!"+data1+"!"+data2+"!"+market+"!"+textate)
    if(!isEmpty(people)&&!isEmpty(place)&&!isEmpty(data1)&&!isEmpty(data2)&&!isEmpty(market)&&!isEmpty(textate)){
        $.ajax({
            url: "../users",
            type: "POST",
            datatype: "json",
            contentType: "application/json;charset=UTF-8",
            data: {
                "mypeople":people,
                "myplace":place,
                "mytextarea":textate,
                "start_date":data1,
                "end_date":data2,
                "market":market
            },
            success:function (msg){
                if (msg.data == '1') {
                    swal({
                        title: "订单发布",
                        text: "你新建的订单已发布",
                        type: "success",
                        timeout: "3000"
                    })
                }else{
                    swal({
                        title: "订单发布",
                        text: "你新建的订单发布失败",
                        type: "warning",
                        timeout: "3000"
                    })
                }
            },
            error:function (msg){
                console.log("error")
            }
        })
    }else {
        swal({
            title: "订单发布",
            text: "订单信息不能为空",
            type: "warning",
            timeout: "3000"
        })
    }

}