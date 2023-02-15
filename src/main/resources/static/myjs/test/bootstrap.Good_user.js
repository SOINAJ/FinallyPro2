var address = $("body").attr("class")

$("#table").bootstrapTable({
    url: "../" + address + "/T",
    method: "GET",
    cache: "false",
    columns: [
        {title: "订单号", field: "id"},
        {title: "雇员", field: "bnum"},
        {title: "开始时间", field: "time_start"},
        {title: "结束时间", field: "time_end"},
        {title: "地点", field: "place"},
        {title: "评分", field: "scope"},
        {title: "简介", field: "message", width: 250}
    ],

    sidePagination: "client",
    onClickRow: function (row, field) {
        // console.log(row)
        // console.log(field)
        var data = field[0]
        console.log(data.dataset.index)
        if (isEmpty(row.scope)) {
            showOnclick(row, data.dataset.index)
        }

    }

})