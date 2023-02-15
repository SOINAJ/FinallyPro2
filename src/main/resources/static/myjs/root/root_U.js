var number = 1
var now_num = 1
var url = ""
$(document).ready(function () {
    url = get_User_mes("U")
    get_Mes()
    get_Mes_number(url)
})

function get_Mes() {
    if (now_num <= number) {
        var myUrl = url + "/" + now_num
        $.ajax({
            url: myUrl,
            type: "GET",
            contentType: "application/json",
            data: {},
            success: function (dat) {
                // console.log(dat.data)
                build(dat.data, "U")
            },
            error: function (dat) {
                console.log("error")
            }
        })
    }

}

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
                if (now_num < number) {
                    now_num++
                    get_Mes()
                }

            }, 1000);
        }
    }
});