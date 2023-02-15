// var data = window.parent.document.getElementById("mypart")
function check_have_return(data){
    var mydata = ""
    if (data.substring(0,1)=="A"){
        mydata = "U"+ data
    }else if (data.substring(0,1)=="B"){
        mydata = "W"+ data
    }
    var url = "../returns/m/" + mydata
    $.ajax({
        url: url,
        type:"GET",
        datatype:"json",
        contentType:"application/json;charset=UTF-8",
        success:function (dat){
            if (dat.code==20011){
                dealwithFor(dat.data)
            }
        },
        error:function (e){
            console.log("error")
        }
    })
}

function get_notice(){
    var url = "../notices"
    $.ajax({
        url: url,
        type:"GET",
        datatype:"json",
        contentType:"application/json;charset=UTF-8",
        success:function (dat){
            if (dat.code==20011){
                dealwithFor(dat.data)
            }
        },
        error:function (e){
            console.log("error")
        }
    })
}

