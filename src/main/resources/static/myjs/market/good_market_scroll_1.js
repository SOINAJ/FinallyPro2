$(window).scroll(function () {
    var scrollh = $(document).height();
    var scrollTop = Math.max(document.documentElement.scrollTop || document.body.scrollTop);
    if (parseInt(now_num) < parseInt(number)) {
        if ((scrollTop + $(window).height()) >= scrollh) {
            $("#jiazai").show();
            var interval = setTimeout(function () {
                $("#jiazai").hide();
            }, 1000);
            var inter = setTimeout(function () {
                // $("#container div").first().clone().appendTo($("#container"));
                now_num ++
                getGoods_user(parseInt(now_num))
            }, 1000);
        }
    }
});

function getpart(){
    $.ajax({
        url:"../checkUsers",
        type:"POST",
        datatype:"json",
        contentType:"application/json:charset=UTF-8",
        success:function (dat){
            var part = dat.data.part
            var data = part.substring(0,1)
            console.log(data)
            $("#myp").attr("class",data)
        },
        error:function (e){
            console.log("error")
        }
    })
}

function put_goods_market(idName){
    $.ajax({
        url: "../markets/" + idName,
        type: "PUT",
        datatype: "json",
        contentType: "application/json",
        // data: {"idName": idName},
        success: function (dat) {
            console.log(dat)
        },
        error: function (e) {
            console.log("error")
        }
    })
}

function choosethis(data) {
    var part = $("#myp").attr("class")
    var classname = $(data).prop("id")
    var idName = classname.substring(4)
    // var myidName = idName.substring()
    console.log(idName)
    if (part == "B") {
        swal({
            title: "您确定要接受这次服务吗",
            text: "",
            type: "info",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "接受",
            closeOnConfirm: false
        }, function () {
            swal("已接受！", "您已经接受此次工作。", "success");
            put_goods_market(idName)
            $(data).remove()
        })
    }
    else {
        swal({
            title: "不可接受",
            text: "你不可接受该订单",
            type: "warning",
            showCancelButton: true,
        })
    }

}