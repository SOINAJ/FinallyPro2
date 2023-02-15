$(document).ready(function (){
    getPart()
})

function getPart(){
    var data = window.parent.document.getElementById("mypart")
    var part = ($(data).html()).substring(0,1)
    if (part == "A"){
        $(".myform2").css("display","none")
        $(".myiframe2").css("display","none")
        return true
    }else if (part == "B"){
        return false
    }else {
        return null
    }

}
