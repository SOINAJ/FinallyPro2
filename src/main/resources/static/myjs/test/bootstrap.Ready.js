var address = $("body").attr("class")

$("#table").bootstrapTable({
    url: "../" + address + "/T",
    method: "GET",
    cache: "false",
    columns: [
        {title: "订单号", field: "id"},
        {title: "开始时间", field: "time_start"},
        {title: "结束时间", field: "time_end"},
        {title: "地点", field: "place"},
        {title: "简介", field: "message", width: 250},
        {title: "是否接受", field: "state",formatter:operateFormatter()}
    ],

    sidePagination: "client",
})

function updatainline(data, indexnum) {
    console.log(data)
    var rows = {
        index: indexnum,
        field: "scope",
        value: data.scope
    }
    $("#table").bootstrapTable("updateCell", rows)
}

function operateFormatter(value, row, index) {
    // console.log(value)
    // console.log(row)
    return [
        '<button type="button" class="btn btn-outline btn-success mybut1" onclick="putReady_workDown('+index+')">接受</button>' ,
        '<button type="button" class="btn btn-outline btn-danger mybut1_2" onclick="putReady_workNot('+index+')">拒接</button>'
    ].join('')
}

function putReady_workDown(data) {
    // var parent1 = $(data).parent()
    // var idName = $(parent1).prop("id")
    // putReady_work(idName, "1")

    swal({
            title: "接受订单",
            text: "你已接受该订单",
            type: "success"
        }, function () {
            putReady_work(data, "1")
        }
    )

}

function putReady_workNot(data) {
    // var parent1 = $(data).parent()
    // var idName = $(parent1).prop("id")
    // putReady_work(idName, "0")
    swal({
        title: "您确定要拒接此次工作吗",
        text: "",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "拒接",
        closeOnConfirm: false
    }, function () {
        swal("已拒接！", "您已经拒接此次工作。", "success");
        putReady_work(data, "0")
    });


}

function putReady_work(data, state) {
    // var str1 = {"idName": idName, "state": state};
    $.ajax({
        url: "../readys/" + state,
        type: "PUT",
        datatype: "json",
        contentType: "application/json",
        data: {"idName": data},
        success: function (dat) {
            console.log(dat)
            if (dat.data == "1") {
                // alert("你已确定该订单")
                $("#" + idName).html("<span class=\"data-main3\" style=\"margin-left: 0;width:110px;background: rgba(1, 173, 157, 0.4)\">已接受</span>")
            } else if (dat.data == "2") {
                // alert("你已拒接该订单")
                $("#" + idName).html("<span class=\"data-main3\" style=\"margin-left: 0;width:110px;background: rgba(246, 141, 108,0.4);\">已拒接</span>")
            }

        },
        error: function (e) {
            console.log("error")
        }
    })
}