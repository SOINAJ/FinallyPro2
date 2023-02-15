$(document).ready(function () {
    button3_onclick()
});

function putReady_work(idName, state) {
    // var str1 = {"idName": idName, "state": state};
    $.ajax({
        url: "../readys/" + state,
        type: "PUT",
        datatype: "json",
        contentType: "application/json",
        data: {"idName": idName},
        success: function (dat) {
            console.log(dat)
            if (dat.data == "1") {
                // alert("你已确定该订单")
                $("#" + idName).html("<span class=\"data-main3\" style=\"margin-left: 0;width:110px;background: rgba(1, 173, 157, 0.4)\">已接受</span>")
            } else if (dat.data == "2") {
                // alert("你已拒接该订单")
                $("#" + idName).html("<span class=\"data-main3\" style=\"margin-left: 0;width:110px;background: rgba(246, 141, 108,0.4);\">已拒接</span>")
            }

        },
        error: function (e) {
            console.log("error")
        }
    })
}


function getReady_work(number_find) {
    $.ajax({
        url: "../readys/" + number_find,
        type: "GET",
        datatype: "json",
        contentType: "application/json:charset=UTF-8",
        data: {
            // "number_find":
        },
        success: function (dat) {
            console.log(dat.data[0].a_end)
            console.log(isEmpty(dat.data[0].a_end))
            var data_length = dat.data.length

            var text2 = ""
            for (var i = 0; i < data_length; i++) {
                var value = "value" + dat.data[i].id
                text2 += '<div class="text-data-show">' +
                    '<span class="data-main0" style="margin-left: 0px"><a class=' + value + '>' + dat.data[i].id + '</a></span>' +
                    '<span class="data-main0"><a data-toggle="modal">' + dat.data[i].anum + '</a></span>' +
                    '<span class="data-main0"><a>' + dat.data[i].place + '</a></span>' +
                    '<span class="data-main1" style="width: 50%"><a>' + dat.data[i].message + '</a></span>' +
                    '<span class="data-main2"><a>' + dat.data[i].time_start + ' ~ ' + dat.data[i].time_end + '</a></span>' +
                    '<span id=' + value + ' class="data-main3">'
                if (isEmpty(dat.data[i].state)) {
                    text2 +=   '<button type="button" class="btn btn-outline btn-success mybut1" onclick="putReady_workDown(this)">接受</button>' +
                               '<button type="button" class="btn btn-outline btn-danger mybut1_2" onclick="putReady_workNot(this)">拒接</button>' +
                               '</span>' +
                               '</div>'

                } else {
                    if (dat.data[i].state == "1") {
                        text2 += '<span class="data-main3" style="margin-left: 0;width:110px;background: rgba(1, 173, 157, 0.4)">已接受</span></span></div>'
                    } else if (dat.data[i].state == "0") {
                        text2 += '<span class="data-main3" style="margin-left: 0;width:110px;background: rgba(246, 141, 108,0.4);">已拒接</span></span></div>'
                    }else {
                        text2 += '<span class="data-main3" style="margin-left: 0;width:110px;background: rgba(134, 141, 108,0.4);">已过期</span></span></div>'
                    }
                }
            }

            $("#getShow").html(text2)
        },
        error: function (e) {
            console.log("error")
        }
    })
}


function button3_onclick() {
    var number_find = $(".number-find").val()
    getReady_work(number_find)
}

function putReady_workDown(data) {
    var parent1 = $(data).parent()
    var idName = $(parent1).prop("id")
    // putReady_work(idName, "1")
    swal({
            title: "接受订单",
            text: "你已接受该订单",
            type: "success"
        }, function () {
            putReady_work(idName, "1")
        }
    )

}

function putReady_workNot(data) {
    var parent1 = $(data).parent()
    var idName = $(parent1).prop("id")
    // putReady_work(idName, "0")
    swal({
        title: "您确定要拒接此次工作吗",
        text: "",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "拒接",
        closeOnConfirm: false
    }, function () {
        swal("已拒接！", "您已经拒接此次工作。", "success");
        putReady_work(idName, "0")
    });


}

