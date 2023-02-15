$(document).ready(
    getW_mes()
)

var img1
var img2

function getW_mes() {
    $.ajax({
        url: "../WMes/getWmes/",
        type: "GET",
        datatype: "json",
        contentType: "application/json:charset=UTF-8",
        success: function (dat) {
            $(".mypeople").val(dat.data.part)
            $(".myphone").val(dat.data.phone)
            $(".myplace").val(dat.data.place)
            $(".mytextarea").val(dat.data.message)
        },
        error: function (e) {
            console.log("error")
        }
    })
}

function getbtn_U_W() {
    var people = $(".mypeople").val()
    var place = $(".myplace").val()
    var myphone = $(".myphone").val()
    var textate = $(".mytextarea").val()
    // console.log(myphone+"!"+people+"!"+place+"!"+textate)
    $.ajax({
        url: "../WMes",
        type: "PUT",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data: {
            "myphone": myphone,
            "mypeople": people,
            "myplace": place,
            "mytextate": textate
        },
        success: function (msg) {
            console.log(msg)
            swal({
                title: "信息修改",
                text: "个人信息修改完成",
                type: "success",
                timeout: "3000"
            })
        },
        error: function (msg) {
            console.log("error")
        }
    })
    // console.log(myphone+"!"+people+"!"+place+"!"+textate)
}

