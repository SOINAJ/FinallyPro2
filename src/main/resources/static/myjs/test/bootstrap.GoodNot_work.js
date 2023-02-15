var address = $("body").attr("class")
var part = window.parent.document.getElementById("mypart")
$("#table").bootstrapTable({
    url: "../" + address + "/T/" + $(part).html(),
    method: "GET",
    cache: "false",
    columns: [
        {title: "订单号", field: "id"},
        {title: "雇主", field: "remarks"},
        {title: "雇主号", field: "anum"},
        {title: "开始时间", field: "time_start"},
        {title: "结束时间", field: "time_end"},
        {title: "地点", field: "place"},
        {title: "简介", field: "message", width: 250}
    ],

    sidePagination: "client",
    onClickRow: function (row, field) {
        // console.log(row)
        // console.log(field)
        // var data = field[0]
        // console.log(data.dataset.index)
        if (!isEmpty(row)) {
            apply_return_good(row,"W")
        }

    }
})

function apply_return(myarrays){

    $.ajax({
        url: "../returns/2",
        type: "PUT",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(myarrays),
        success: function (dat) {
            setTimeout(function(){
                return_code(dat.code+"")
            },300);
            // console.log(dat)
        },
        error: function (e) {
            console.log("error")
            swal({
                title: "取消申请",
                text: "取消订单请求异常，请重试",
                type: "warning",
                confirmButtonColor: "#009900",
                timeout: "3000"
            })
        }
    })
}

function return_code(code){
    switch (code){
        case "20031":
            swal({
                title: "取消申请",
                text: "订单已取消",
                type: "success",
                confirmButtonColor: "#009900",
                timeout: "3000",
            })
            break
        case "20032":
            swal({
                title: "取消申请",
                text: "订单取消请求异常，请重试",
                type: "warning",
                confirmButtonColor: "#DD6B55",
                timeout: "3000",
            })
            break
        case "20041":
            swal({
                title: "取消申请",
                text: "取消订单请求已发送",
                type: "success",
                confirmButtonColor: "#009900",
                timeout: "3000",
            })
            break
        case "20042":
            swal({
                title: "取消申请",
                text: "取消订单请求已发送，请勿重发",
                type: "warning",
                confirmButtonColor: "#DD6B55",
                timeout: "3000",
            })
            break
    }
}