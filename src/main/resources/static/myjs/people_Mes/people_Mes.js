// var img1 = ""
// var img2 = ""
var url = ""
var url2 = ""

function getParttoUrl(number) {
    if (getPart()) {
        url = "../UMes/" + number
    } else {
        url = "../WMes/" + number
    }
}

function getImg() {
    if (getPart()) {
        url2 = "../UMes/url"
    } else {
        url2 = "../WMes/url"
    }
    $.ajax({
        url: url2,
        type: "GET",
        datatype: "json",
        contentType: "application/json",
        success: function (dat) {
            if (!isEmpty(dat.data[0].sfz)) {
                console.log(dat.data[0].sfz)
                $("#show1").attr("src", "")
                $("#show1").attr("src", dat.data[0].sfz + "?" + Math.random())
                $("#mysubmit1").val("修改图片")
            }
            if (!isEmpty(dat.data[0].prove)) {
                $("#show2").attr("src", "")
                $("#show2").attr("src", dat.data[0].prove + "?" + Math.random())
                $("#mysubmit2").val("修改图片")
            }
        },
        error: function (e) {
            console.log("error")
        }
    })
}


function changepic() {

    getParttoUrl("3")
    $(".myform1").attr("action", url)

    var reads = new FileReader();

    f = document.getElementById('file1').files[0];

    if (f instanceof Object) {
        reads.readAsDataURL(f);

        reads.onload = function (e) {

            document.getElementById('show1').src = "";
            document.getElementById('show1').src = this.result;
            // console.log(img1.substring(img1.indexOf(",")+1,img1.length))
            // img1 = encodeURI(this.result).replace(/\+/g,"%2B");
            // console.log(img1)
        };
    }

}

function changepic2() {


    getParttoUrl("2")
    $(".myform2").attr("action", url)

    var reads = new FileReader();

    f = document.getElementById('file2').files[0];

    if (f instanceof Object) {
        reads.readAsDataURL(f);

        reads.onload = function (e) {

            // console.log(this.result)
            document.getElementById('show2').src = "";
            document.getElementById('show2').src = this.result;

            // img2 = encodeURI(this.result).replace(/\+/g,"%2B");
        };
    }
}

function runback(oh) {
    if (oh == "20021") {
        swal({
            title: "该图片已成功上传",
            text: "",
            type: "success",
            confirmButtonColor: "#009900",
            closeOnConfirm: false
        })
    } else {
        swal({
            title: "图片上传失败",
            text: "图片上传可能有问题，上传失败",
            type: "warning",
            confirmButtonColor: "#DD6B55",
            closeOnConfirm: false
        })
    }
}

$(function () {
    getImg()

    $(".myform1").ajaxForm(function (data) {
        var mydata = JSON.stringify(data)
        console.log("data" + data.code)
        console.log("data" + data)
        console.log("data" + mydata)
        runback(data.code)
        $("#mysubmit1").val("修改图片")
    })

    $(".myform2").ajaxForm(function (data) {
        var mydata = JSON.stringify(data)

        runback(data.code)
        $("#mysubmit2").val("修改图片")
    })
})


// function getbtn_U_W1() {
//     getParttoUrl()
//
//     var test = img1.substring(img1.indexOf(",")+1)
//
//     $.ajax({
//         url: url,
//         type: "POST",
//         datatype: "json",
//         contentType: "application/json;charset=UTF-8",
//         data:{
//             "myimg1":test
//         },
//         success: function (dat) {
//             console.log("success"+dat)
//         },
//         error: function (e) {
//             console.log("error")
//         }
//     })
// }
//
// function getbtn_U_W2() {
//     getParttoUrl()
//
//     $.ajax({
//         url: url,
//         type: "POST",
//         datatype: "json",
//         contentType: "application/json;charset=UTF-8",
//         data:{
//             "myimg2":img2
//         },
//         success: function (dat) {
//             console.log("success"+dat)
//         },
//         error: function (e) {
//             console.log("error")
//         }
//     })
// }