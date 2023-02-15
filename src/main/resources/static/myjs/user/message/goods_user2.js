$(document).ready(function () {
    button3_onclick()
});


function getGoods_user(number_find) {

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
            var columnss =
                [{
                    field: "id", title: "订单号"
                }, {
                    field: "bnum", title: "雇员"
                }, {
                    field: "message", title: "信息"
                }, {
                    field: "time_start", title: "开始时间"
                }, {
                    field: "time_end", title: "结束时间"
                }]
            $("#finishShowTable").bootstrapTable({
                columns:columnss,
                data: dat.data
            })
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
        area: ['350px', '300px'],
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
            var number = $(".select-main").val()
            console.log(number)
            layer.close(index)
        }

        ,
    })
}