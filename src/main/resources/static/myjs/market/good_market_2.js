$(document).ready(function () {
    get_market_number()
    getpart()
    button3_onclick()
});


var number = 0
var now_num = 1
var state = ["panel-primary","panel-success","panel-info","panel-warning","panel-default"]

function button3_onclick() {
    getGoods_user(now_num)
}


function get_market_number(){
    $.ajax({
        url:"../marketC2s",
        type:"GET",
        datatype:"json",
        contentType:"application/json:charset=UTF-8",
        success:function (dat){
            number += parseInt(dat.data)
        },
        error:function (e){
            console.log("error")
        }
    })
}


function getGoods_user(num) {
    $.ajax({
        url: "../marketC2s/" + num,
        type: "GET",
        datatype: "json",
        contentType: "application/json:charset=UTF-8",
        success: function (dat) {
            var data_length = dat.data.length
            var text1 = ""
            for (var i = 0; i < data_length; i++) {
                var classname = "myid" + dat.data[i].id
                text1 +=
                    '<div onclick="choosethis(this)" class="panel panel-success" id=' + classname + '>' +
                    '<div class="panel-heading">'+
                        '<h3 class="panel-title"><i class="glyphicon glyphicon-cloud"></i> 清洁兼职 </h3>'+
                    '</div>'+
                    '<div class="panel-body"> '+dat.data[i].message+' </div>'+
                    '<table class="table">'+
                        '<tr><th>订 单</th><td>'+dat.data[i].id+'</td> </tr>'+
                        '<tr><th>雇 主</th><td>'+dat.data[i].anum+'</td></tr>'+
                        '<tr><th>电 话</th><td>' + dat.data[i].phone + '</td></tr>' +
                        '<tr><th>地 点</th><td>'+dat.data[i].place+'</td></tr>'+
                        '<tr><th>开始时间</th><td>'+dat.data[i].time_start+'</td></tr>'+
                        '<tr><th>结束时间</th><td>'+dat.data[i].time_end+'</td></tr>'+
                    '</table>'+
               '</div>'
            }
            $("#mymarket").append(text1)
        },
        error: function (e) {
            console.log("error")
        }
    })
    console.log(now_num)
}

