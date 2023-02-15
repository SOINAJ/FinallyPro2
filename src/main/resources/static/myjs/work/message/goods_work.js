$(document).ready(function () {
    button3_onclick()
});


function getGoods_user(number_find) {
    var market = ['家教','清洁','保姆']
    $.ajax({
        url: "../works/" + number_find,
        type: "GET",
        datatype: "json",
        contentType: "application/json:charset=UTF-8",
        data: {
            // "number_find":
        },
        success: function (dat) {
            // console.log(dat.data[1].a_end)
            // console.log(isEmpty(dat.data[1].a_end))
            var data_length = dat.data.length
            var text1 = ""
            // var text2 = ""
            for (var i = 0; i < data_length; i++) {
                if (!isEmpty(dat.data[i].aend) && !isEmpty(dat.data[i].bend)) {
                    text1 +=
                        '<div class="text-data-show">' +
                        '<span class="data-main0" style="margin-left: 0px"><a>' + dat.data[i].id + '</a></span>' +
                        '<span class="data-main0"><a>' + market[parseInt(dat.data[i].market-1)] + '</a></span>' +
                        '<span class="data-main0"><a>' + dat.data[i].anum + '</a></span>' +
                        '<span class="data-main0"><a>' + dat.data[i].place + '</a></span>' +
                        '<span class="data-main1" style="width: 45%"><a>' + dat.data[i].message + '</a></span>' +
                        '<span class="data-main2"><a>' + dat.data[i].time_start + ' ~ ' + dat.data[i].time_end + '</a></span>' +
                        '<span class="data-main3">'+
                        '<span class="data-main3" style="margin-left: 0;width:110px;background: rgba(1, 173, 157, 0.4)">已完成</span></span>' +
                        '</div>'
                }
                // else
                // {
                //     text2 +=
                //         '<div class="text-data-show">' +
                //         '<span class="data-main0" style="margin-left: 0px"><a>' + dat.data[i].id + '</a></span>' +
                //         '<span class="data-main0"><a>' + dat.data[i].anum + '</a></span>' +
                //         '<span class="data-main0"><a>' + dat.data[i].place + '</a></span>' +
                //         '<span class="data-main1"><a>' + dat.data[i].message + '</a></span>' +
                //         '<span class="data-main2"><a>' + dat.data[i].time_start + ' ~ ' + dat.data[i].time_end + '</a></span>' +
                //         '<span class="data-main3">正在进行中</span>' +
                //         '</div>'
                //         // '<button style="pointer-events: none;" class="button1 mybut1"><div' +
                //         // 'className="zindex1"><img class="imgcss2" src="/myimg/write.png">雇主ok</div></button><button' +
                //         // 'className="button2 mybut1_2"><div class="zindex1"><img class="imgcss2"' +
                //         // 'src="/myimg/write.png">雇员ok</div></button>' +
                //         // '</span>' +
                //         // '</div>'
                // }
            }
            $("#finishShow").html(text1)
            // if(text2 == "" && text1 == ""){
            //
            // }else
            // {
            //
            //     $("#notfinishShow").html(text2)
            // }
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