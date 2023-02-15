var $table = $('#table')
var $button = $('#button')

$(function () {
    $button.click(function () {
        var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.id
        })
        $table.bootstrapTable('remove', {
            field: 'id',
            values: ids
        })
        deldata(ids)
    })
})

$("#table").bootstrapTable({
    url: "../rootGoods",
    method: "GET",
    cache: "false",
    columns: [
        {checkbox:"true",field: "state"},
        {title: "订单号", field: "id"},
        {title: "雇主", field: "anum"},
        {title: "雇员", field: "bnum"},
        {title: "开始时间", field: "time_start"},
        {title: "结束时间", field: "time_end"}
        // {title: "地点", field: "place"},
        // {title: "简介", field: "message"}
    ],

    sidePagination: "server",
    // onClickRow: function (row) {
    //     console.log(row)
    //     var data = row
    // }
})


function deldata(ids){

    $.ajax({
        url: "../rootGoods",
        type: "PUT",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(ids),
        success: function (dat) {
            console.log(dat)
        },
        error: function (e) {
            console.log("error")
        }
    })

    // $table.bootstrapTable('refresh', {
    //     url: "../rootGoods",
    //     method: "GET",
    //     silent:true
    // })
}

function detailFormatter(index, row) {
    var html = []
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>')
    })
    return html.join('')
}
//
// function operateEvents(e, value, row, index) {
//     console.log("1" + row)
//     console.log("1" + e)
//     console.log("1" + value)
// }