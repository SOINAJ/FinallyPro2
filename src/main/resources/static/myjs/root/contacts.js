function get_Work_mes(path) {
    var Wurl = "../RCheck/" + path
    return Wurl
}

function get_User_mes(path) {
    var Uurl = '../RCheck/' + path
    return Uurl
}

function build(data, part) {
    var text = ""
    for (var i = 0; i < data.length; i++) {
        var state = "已审核"
        var value = "value" + part + data[i].part
        if (data[i].state == '0') state = "未审核"
        if (data[i].part == '') state = "已注销"

        text +=
            '<div class="col-sm-4">' +
            '<div class="contact-box" onclick="to_Profile(this)" id=' + value + '>' +
            '<a>' +
            '<div class="col-sm-4">' +
            '<div class="text-center">' +
            '<img alt="image" class="img-circle m-t-xs img-responsive" src="/img/mynone.png">' +
            '<div class="m-t-xs font-bold">' + data[i].part + '</div>' +
            '</div>' +
            '</div>' +
            '<div class="col-sm-8">' +
            '<span title="state" style="margin-left: 120px;font-family: 华光琥珀_CNKI;font-size: 23px">' + state + '</span>' +
            '<h3><strong>' + data[i].name + '</strong></h3>' +
            '<p><i class="fa fa-map-marker"></i> ' + data[i].place + '</p>' +
            '<address>' +
            // '<strong></strong><br><br>Weibo:<a href="#">http://weibo.com/xxx</a><br>' +
            '<abbr title="Phone">Tel:</abbr>' + data[i].phone +
            '</address>' +
            '</div>' +
            '<div class="clearfix"></div>' +
            '</a>' +
            '</div>' +
            '</div>'
    }
    $(".myrow").html(text)
}

// function User_build(data) {
//     var text = ""
//     var state = "审核"
//     for (var i = 0; i < data.length; i++) {
//         if (data.state == '0')
//             state = "未审核"
//
//         text +=
//             '<div class="col-sm-4">' +
//             '<div class="contact-box">' +
//             '<a href="profile.html">' +
//             '<div class="col-sm-4">' +
//             '<div class="text-center">' +
//             '<img alt="image" class="img-circle m-t-xs img-responsive" src="/img/mynone.png">' +
//             '<div class="m-t-xs font-bold">' + data.part + '</div>' +
//             '</div>' +
//             '</div>' +
//             '<div class="col-sm-8">' +
//             '<span title="state" style="margin-left: 150px;font-family: 华光琥珀_CNKI;font-size: 30px">'+state+'</span>' +
//             '<h3><strong>' + data.name + '</strong></h3>' +
//             '<p><i class="fa fa-map-marker"></i> ' + data.place + '</p>' +
//             '<address>' +
//             // '<strong></strong><br><br>Weibo:<a href="#">http://weibo.com/xxx</a><br>' +
//             '<abbr title="Phone">Tel:</abbr>' + data.phone +
//             '</address>' +
//             '</div>' +
//             '<div class="clearfix"></div>' +
//             '</a>' +
//             '</div>' +
//             '</div>'
//     }
//     $(".myrow").html(text)
// }

function get_Mes_number(url) {
    $.ajax({
        url: url,
        type: "GET",
        contentType: "application/json",
        data: {},
        success: function (dat) {
            // console.log("GetNUM" + dat.data)
            // number = dat.data
            if (dat.data % 6 == 0) {
                number = dat.data / 6
            } else {
                number = (dat.data / 6) + 1
            }
        },
        error: function (dat) {
            console.log("error")
        }
    })
}

function to_Profile(data) {
    var idName = $(data).prop("id")
    var name = idName.substring(6)
    var part = idName.substring(5, 6)
    if (part == "U") UserUrl(part + name)
    else WorkUrl(part + name)

}

function WorkUrl(data) {
    window.location.href = "../myfile/root_profile.html?part=" + data
}

function UserUrl(data) {
    window.location.href = "../myfile/root_profile.html?part=" + data
}