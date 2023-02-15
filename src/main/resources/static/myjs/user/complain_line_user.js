function getline(num, part) {
    var url = "../UComplains/" + num + "?part=" + part
    $.ajax({
        url: url,
        type: "GET",
        datatype: "json",
        contentType: "application/json",
        // data:,
        success: function (data) {
            console.log(data)
            number = data.msc
            getData(data.data)
        },
        error: function (data) {
            console.log("error")
        }
    })
}

function getData(data) {
    var length = data.length
    var text = ""

    for (var i = 0; i < length; i++) {
        var value = "value" + data[i].id
        if (data[i].state == '0') {
            text += '<tr class="unread" onclick="touser_Url(this)" id=' + value + '>' +
                '<td class="check-mail">' +
                // '<input type="checkbox" class="i-checks" checked>'+
                '</td>' +
                '<td class="mail-ontact"><a href="#">' + data[i].user + '</a>' +
                ' <span class="label label-primary pull-right">未读</span>' +
                '</td>' +
                '<td class="mail-subject"><a href="#">' + data[i].message + '</a>' +
                '</td>' +
                '<td class=""></td>' +
                '<td class="text-right mail-date">' + data[i].date + '</td>' +
                '</tr>'
        } else {
            text += '<tr class="read" onclick="touser_Url(this)" id=' + value + '>' +
                '<td class="check-mail">' +
                '</td>' +
                '<td class="mail-ontact"><a href="#">' + data[i].user + '</a> ' +
                ' <span class="label label-warning pull-right">已读</span>' +
                '</td>' +
                '<td class="mail-subject"><a href="#">' + data[i].message + '</a>' +
                '</td>' +
                '<td class=""></td>' +
                '<td class="text-right mail-date">' + data[i].date + '</td>' +
                '</tr>'
        }
    }
    $(".mytbody").html("")
    $(".mytbody").html(text)
}

var num = 1
var number = 0
var data = window.parent.document.getElementById("mypart")
var part = ($(data).html()).substring(0, 2)
$(document).ready(function () {
    getline(num, part)
})

function leftBtn() {
    if (num == 1) {
        console.log(number)
        return
    }
    if (num > 1) {
        getline(--num)
    }
}

function rightBtn() {

    if (num == number) {
        console.log(number)
        return
    }
    if (num < number) {
        getline(++num)
    }
}

