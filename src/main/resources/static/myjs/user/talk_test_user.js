$(document).ready(function () {
    // conectWebSocket()4
    talk_people()
})




function talk_people(){
    $.ajax({
        url:"../userTalks",
        type:"GET",
        datatype:"json",
        contentType:"application/json:charset=UTF-8",
        success:function (dat){
            console.log(dat)
            update_talk_people(dat)
        },
        error:function (e){
            console.log("error")
        }
    })
}

function update_talk_people(dat){
    var num = dat.data.length
    var data = ""
    for(var i=0;i<num;i++){
        data += '<h4 class='+dat.data[i].apart+':'+dat.data[i].bpart+' onClick="conectWebSocket(this)">'+dat.data[i].name+'</h4>'
    }
    $(".talk_friend").append(data)
}