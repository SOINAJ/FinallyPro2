var $table = $('#table')
var $button1 = $('#button1')
var $button2 = $('#button2')
var data = window.parent.document.getElementById("mypart")
var url = "../returns/U"+ $(data).html()


$(function () {
    $button1.click(function () {
        var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.good_id
        })
        $table.bootstrapTable('remove', {
            field: 'good_id',
            values: ids
        })
        agree_return(ids)
    })

    $button2.click(function () {
        var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.good_id
        })
        $table.bootstrapTable('remove', {
            field: 'good_id',
            values: ids
        })
        refuse_return(ids)
    })
})


$("#table").bootstrapTable({
    url: url,
    method: "GET",
    cache: "false",
    columns: [
        {checkbox:"true",field: "state"},
        {title: "单号", field: "id"},
        {title: "雇主", field: "anum"},
        {title: "雇员", field: "bnum"},
        {title: "订单号", field: "good_id"}
    ],

    sidePagination: "client"

})

function agree_return(ids){
    $.ajax({
        url: "../returns/1",
        type: "POST",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(ids),
        success: function (dat) {
            console.log(dat)
            swal({
                title: "取消申请",
                text: "取消订单申请已同意",
                type: "success",
                confirmButtonColor: "#009900",
                timeout: "3000"
            })

        },
        error: function (e) {
            console.log("error")
        }
    })
}

function refuse_return(ids){
    $.ajax({
        url: "../returns/2",
        type: "POST",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(ids),
        success: function (dat) {
            console.log(dat)
            swal({
                title: "取消申请",
                text: "取消订单申请已拒绝",
                type: "warning",
                confirmButtonColor: "#DD6B55",
                timeout: "3000"
            })
        },
        error: function (e) {
            console.log("error")
        }
    })
}