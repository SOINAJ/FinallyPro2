function isEmpty(str){
    if(str==null||str.trim()==""){
        return true;
    }
    return false;
}


$(document).ready(function(){
    $(".passwdInput").blur(function(){
        var area = $(".passwdInput").val()
        console.log(area)
        if (isEmpty(area)){
            $(".null_blur1").html("请输入你的密码")
            $(".null_blur1").css("display","block").fadeOut(4000)
        }

    });

    $(".useInput").blur(function() {
        var area = $(".useInput").val()
        console.log(area)
        if (isEmpty(area)){
            $(".null_blur").html("请输入你的账号")
            $(".null_blur").css("display","block").fadeOut(4000)
        }

    });


});

