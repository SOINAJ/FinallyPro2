$(document).ready(function () {
    button3_onclick()
});


function getGoods_user(number_find) {
    var market = ['家教','清洁','保姆']
    $.ajax({
        url: "../users/" + number_find,
        type: "GET",
        datatype: "json",
        contentType: "application/json:charset=UTF-8",
        data: {
            // "number_find":
        },
        success: function (dat) {
            console.log(dat)
            var data_length = dat.data.length
            var text1 = ""
            for (var i = 0; i < data_length; i++) {
                var value = "value" + dat.data[i].id
                var scope = "scope" + dat.data[i].id
                if (isEmpty(dat.data[i].scope)) {
                    text1 +=
                        '<div id=' + value + ' class="text-data-show" onclick="showOnclick(this)">'
                } else {
                    text1 +=
                        '<div id=' + value + ' class="text-data-show">'
                }
                text1 +=
                    '<span class="data-main0" style="margin-left: 0px"><a>' + dat.data[i].id + '</a></span>' +
                    '<span class="data-main0"><a>' + market[parseInt(dat.data[i].market-1)] + '</a></span>' +
                    '<span class="data-main0"><a>' + dat.data[i].bnum + '</a></span>' +
                    '<span class="data-main0"><a>' + dat.data[i].place + '</a></span>' +
                    '<span id='+scope+' class="data-main0"><a>' + returnEmpty(dat.data[i].scope) + '</a></span>' +
                    '<span class="data-main1"><a>' + dat.data[i].message + '</a></span>' +
                    '<span class="data-main2"><a>' + dat.data[i].time_start + ' ~ ' + dat.data[i].time_end + '</a></span>' +
                    '<span id=' + value + ' class="data-main3">' +
                    '<span class="data-main3" style="margin-left: 0;width:110px;background: rgba(1, 173, 157, 0.4)">已完成</span></span>' +
                    '</div>'
            }
            $("#finishShow").html(text1)
        },
        error: function (e) {
            console.log("error")
        }
    })
}

function button3_onclick() {
    var number_find = $(".number-find").val()
    getGoods_user(number_find)
}

function showOnclick(data) {
    var idName = $(data).prop("id")
    var name = idName.substring(5)
    console.log(idName + "??" + name)

    var index = layer.open({
        title: "评价页面",
        type: 1,
        area: ['350px', '220px'],
        shadeClose: true,
        content:
            '<h4 style="text-align: center">请你对这次家政服务订单号为 <a style="text-align: center;text-decoration: none;cursor: pointer">' + name + '</a> 进行评价</h4><p></p>' +
            '<h5 style="text-align: center">请你对此次此次服务评价' +
            '<select class="select-main" style="width: 43px">' +
            '<option value="1">1</option>' +
            '<option value="2">2</option>' +
            '<option value="3">3</option>' +
            '<option value="4">4</option>' +
            '<option value="5">5</option>' +
            '</select>' +
            '分' +
            '</h5>',

        btn: ['是', '否'],
        scrollbar: false,
        yes: function () {
            var scope = $(".select-main").val()
            $.ajax({
                url: "../users/" + scope,
                type: "PUT",
                datatype: "json",
                contentType: "application/json",
                data: {"id": name},
                success: function (dat) {
                    if (dat.data == '1') {
                        swal({
                            title: "订单评分",
                            text: "你已给予该订单评分",
                            type: "success",
                            timeout: "3000"
                        })
                        $("#scope"+name).html(scope)
                    }else{
                        swal({
                            title: "订单评分",
                            text: "评分失败",
                            type: "warning",
                            timeout: "3000"
                        })
                    }
                },
                error: function (e) {
                    console.log("error")
                }
            })
            layer.close(index)
        }

        ,
    })
}