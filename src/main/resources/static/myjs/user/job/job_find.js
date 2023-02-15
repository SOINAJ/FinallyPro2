$(document).ready(function () {
    get_market_number()
    // getpart()
    button3_onclick()
});




var number = 0
var now_num = 1
// var state = ["panel-primary", "panel-success", "panel-info", "panel-warning", "panel-default"]

function button3_onclick() {
    geWorkMes(now_num)
}


function get_market_number() {
    $.ajax({
        url: "../UMes",
        type: "GET",
        datatype: "json",
        contentType: "application/json:charset=UTF-8",
        success: function (dat) {
            number += parseInt(dat.data)
        },
        error: function (e) {
            console.log("error")
        }
    })
}


function geWorkMes(number) {
    $.ajax({
        url: "../UMes/" + number,
        type: "GET",
        datatype: "json",
        contentType: "application/json:charset=UTF-8",
        success: function (dat) {
            var data_length = dat.data.length
            var text1 = ""
            for (var i = 0; i < data_length; i++) {
                var classname = "myid" + dat.data[i].id
                text1 +=
                    '<div class="panel panel-success" id=' + classname + '>' +
                    '<div class="panel-heading">' +
                    '<h3 class="panel-title"><i class="glyphicon glyphicon-cloud"></i> 服务人员信息表 </h3>' +
                    '</div>' +
                    '<div class="panel-body"> ' + dat.data[i].name + ' </div>' +
                    '<table class="table">' +
                    '<tr><th>工作代号</th><td>' + dat.data[i].part + '</td> </tr>' +
                    '<tr><th>目前地址</th><td>' + dat.data[i].place + '</td></tr>' +
                    '<tr><th>电 话</th><td>' + dat.data[i].phone + '</td></tr>' +
                    // '<tr><th>地 点</th><td>' + dat.data[i].place + '</td></tr>' +
                    '<tr><th>累计评分</th><td>' + dat.data[i].scope + '</td></tr>' +
                    '<tr><th>累计订单</th><td>' + dat.data[i].worknum + '</td></tr>' +
                    '</table>' +
                    '</div>'
            }
            $("#mymarket_find").append(text1)
        },
        error: function (e) {
            console.log("error")
        }
    })
    console.log(now_num)
}


function getbtnFun_find(){
    var people = $(".mypeople").val()
    var employee = $(".myemployee").val()
    var place = $(".myplace").val()
    var data1 = Date.parse($(".start_date").val())
    var data2 = Date.parse($(".end_date").val())
    var market = $("#mymarket").val()
    var textate = $(".mytextarea").val()
    console.log(people+"!"+place+"!"+data1+"!"+data2+"!"+market+"!"+textate)
    if(!isEmpty(people)&&!isEmpty(place)&&!isEmpty(data1)&&!isEmpty(data2)&&!isEmpty(market)&&!isEmpty(textate)){
        $.ajax({
            url: "../readyUs",
            type: "POST",
            datatype: "json",
            contentType: "application/json;charset=UTF-8",
            data: {
                "mypeople":people,
                "myplace":place,
                "employee":employee,
                "mytextarea":textate,
                "start_date":data1,
                "end_date":data2,
                "market":market
            },
            success:function (msg){
                if (msg.data == '1') {
                    swal({
                        title: "订单发布",
                        text: "你指定人员的订单已发布",
                        type: "success",
                        timeout: "3000"
                    })
                }else{
                    swal({
                        title: "订单发布",
                        text: "你指定人员的订单发布失败",
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