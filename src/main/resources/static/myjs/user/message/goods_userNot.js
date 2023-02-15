$(document).ready(function () {
    button3_onclick()
});

function getGoods_userNot(number_find) {
    var market = ['家教','清洁','保姆']
    $.ajax({
        url: "../usersNot/" + number_find,
        type: "GET",
        datatype: "json",
        contentType: "application/json:charset=UTF-8",
        data: {
            // "number_find":
        },
        success: function (dat) {
            console.log(dat)
            var data_length = dat.data.length
            var text2 = ""
            for (var i = 0; i < data_length; i++) {
                if (isEmpty(dat.data[i].aend) && isEmpty(dat.data[i].bend)) {
                    text2 +=
                        '<div class="text-data-show">' +
                        '<span class="data-main0" style="margin-left: 0px"><a>' + dat.data[i].id + '</a></span>' +
                        '<span class="data-main0"><a>' + market[parseInt(dat.data[i].market-1)] + '</a></span>' +
                        '<span class="data-main0"><a>' + dat.data[i].bnum + '</a></span>' +
                        '<span class="data-main0"><a>' + dat.data[i].place + '</a></span>' +
                        '<span class="data-main1" style="width: 45%"><a>' + dat.data[i].message + '</a></span>' +
                        '<span class="data-main2"><a>' + dat.data[i].time_start + ' ~ ' + dat.data[i].time_end + '</a></span>' +
                        '<span class="data-main3">'+
                        '<span class="data-main3" style="margin-left: 0;width:110px;background: rgba(246, 141, 108,0.4);">正在进行中</span></span>' +
                        '</div>'
                }

            }
            $("#notfinishShow").html(text2)
        },
        error: function (e) {
            console.log("error")
        }
    })
}


function button3_onclick() {
    var number_find = $(".number-find").val()
    getGoods_userNot(number_find)
}