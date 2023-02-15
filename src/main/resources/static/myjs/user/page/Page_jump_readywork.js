$(document).ready(function(){
    a_number()
});

function a_number(){
    $.ajax({
        url:"../readyUs",
        type:"GET",
        datatype:"json",
        contentType:"application/json:charset=UTF-8",
        success:function (dat){
            // console.log(dat)
            $(".a_number").html(dat.data)
        },
        error:function (e){
            console.log("error")
        }
    })
}

$(".a_few").click(function(){
    var beginnum = $(".number-select").val()
    console.log("beginnum:"+beginnum)
    var num = parseInt(beginnum)
    if(num == 1){
        return
    }else {
        num--
        console.log("num"+num)
        $("#getShow").html("")
        getReady_work(num)
        $(".number-select").val(num)
    }
});

$(".a_more").click(function(){
    var endnum = $(".a_number").html()
    var beginnum = $(".number-select").val()
    console.log("beginnum:"+beginnum+"endnum"+endnum)
    var num = parseInt(beginnum)
    var endnumber = parseInt(endnum)
    if(num < endnumber){
        num++
        $("#getShow").html("")
        getReady_work(num)
        $(".number-select").val(num)
    }else {
        return
    }
});