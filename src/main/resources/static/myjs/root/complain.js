function toUrl(data){
    var idName = $(data).prop("id")
    var name = idName.substring(5)
    MyUrl(name)
}

function touser_Url(data){
    var idName = $(data).prop("id")
    var name = idName.substring(5)
    UserUrl(name)
}

function MyUrl(name){
    window.location.href = "../myfile/complain_message.html?id="+name
}

function UserUrl(name){
    window.location.href = "../myfile/complain_message_user.html?id="+name
}
