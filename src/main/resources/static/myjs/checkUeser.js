$(document).ready(function(){
   userReady()
});

function userReady(){
    $.ajax({
        url:"../checkUsers",
        type:"POST",
        datatype:"json",
        contentType:"application/json:charset=UTF-8",
        success:function (dat){
            $("#myname").html(dat.data.username)
            $("#mypart").html(dat.data.part)
            $("#mypart").css("display","none")
            check_have_return(dat.data.part)
            get_notice()
        },
        error:function (e){
            console.log("error")
        }
    })
}