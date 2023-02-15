function dealwithFor(data){
    for(var i=0;i<data.length;i++){
        $(".mytitle").val(data[i].title)
        $(".mycontent").val(data[i].content)
        $("#mybtn1").trigger("onclick")
    }
}

function getToastr(){
    var title = $(".mytitle").val()
    var mycontent = $(".mycontent").val()
    // var number = $(data).html()
    // console.log("number is "+ number)
    // console.log(dat)
    //     $('#mybtn1').click(function () {
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "progressBar": true,
        "positionClass": "toast-top-center",
        "showDuration": "400",
        "hideDuration": "1000",
        "timeOut": "10000",
        "extendedTimeOut": "3000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
    toastr.info(mycontent,title);
    toastr.options.onclick = function () {
        // window.open("../test/goods_message_workNot_return.html")
        // window.location.href = "../test/goods_message_workNot_return.html"
    }
    // }
}