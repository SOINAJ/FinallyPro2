function getline(num) {
    var url = "../RCheck/" + num
    $.ajax({
        url: url,
        type: "GET",
        datatype: "json",
        contentType: "application/json",
        // data:,
        success: function (data) {
            console.log(data)
            console.log(data.data.length)
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
            text += '<tr class="unread" onclick="" id='+value+'>' +
                '<td class="check-mail">' +
                // '<input type="checkbox" class="i-checks" checked>'+
                '</td>' +
                '<td class="mail-ontact"><a href="#">' + data[i].user + '</a>' +
                ' <span class="label label-primary pull-right"></span>'+
                '</td>' +
                '<td class="mail-subject"><a href="#">' + data[i].message + '</a>' +
                '</td>' +
                '<td class=""></td>' +
                '<td class="text-right mail-date">' + data[i].date + '</td>' +
                '</tr>'
    }
    $(".mytbody").html("")
    $(".mytbody").html(text)
}

// var num = 1
// var number = 0
// $(document).ready(function () {
//     getline(num)
// })

function leftBtn(){
    if (num == 1){
        console.log(number)
        return
    }
    if (num > 1){
        getline(--num)
    }
}

function rightBtn(){

    if (num == number){
        console.log(number)
        return
    }
    if (num < number){
        getline(++num)
    }
}

