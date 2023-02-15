$(document).ready(function(){
        getfun()
});

function getfun(){
    let id = $(".number-find").val();
    let number = $(".number-last").val();
    $.ajax({
        type:"GET",
        url:"../messages/"+id+"?number="+number,
        datatype:"json",
        contentType:"application/json:charset=UTF-8",
        success:function (dat){
            // var apoint = 0
            var text = ""
            let length = dat.data.length;
            for (let i = 0; i < length ; i++){
                let checkbox = 'data-checkbox'
                text +=
                    '<div class="text-data-show">'+
                        '<span class="data-mainAll"><input class='+checkbox+' type="checkbox"></span>'+
                        '<span class="data-main1"><a>'+dat.data[i].data+'</a></span>'+
                        '<span class="data-main2"><a>'+dat.data[i].number+'</a></span>'+
                        '<span class="data-main3"><button class="button1"><div class="zindex1"><img class="imgcss2" src="../myimg/write.png">修改</div></button><button class="button2"><div class="zindex1"><img class="imgcss2"src="../myimg/del2.png">删除</div></button></span>'+
                   '</div>'

                // console.log(text)
            }
            $(".show").html(text)
        },
        error:function (e){
            console.log("error")
        }
    })
}