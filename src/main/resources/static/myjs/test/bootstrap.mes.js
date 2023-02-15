
function updatainline(data, indexnum) {
    console.log(data)
    var rows = {
        index: indexnum,
        field: "scope",
        value: data.scope
    }
    $("#table").bootstrapTable("updateCell", rows)
}

function showOnclick(data, indexnum) {
    var name = data.id

    var index = layer.open({
        title: "评价页面",
        type: 1,
        area: ['350px', '220px'],
        shadeClose: true,
        content:
            '<h4 style="text-align: center">请你对这次家政服务订单号为 <a style="text-align: center;text-decoration: none;cursor: pointer">' + name + '</a> 进行评价</h4><p></p>' +
            '<h5 style="text-align: center">请你对此次此次服务评价' +
            '<select class="select-main" style="width: 43px">' +
            '<option value="1">1</option>' +
            '<option value="2">2</option>' +
            '<option value="3">3</option>' +
            '<option value="4">4</option>' +
            '<option value="5">5</option>' +
            '</select>' +
            '分' +
            '</h5>',

        btn: ['是', '否'],
        scrollbar: false,
        yes: function () {
            var scope = $(".select-main").val()
            $.ajax({
                url: "../users/" + scope,
                type: "PUT",
                datatype: "json",
                contentType: "application/json",
                data: {"id": name},
                success: function (dat) {
                    if (dat.data == '1') {
                        swal({
                            title: "订单评分",
                            text: "你已给予该订单评分",
                            type: "success",
                            timeout: "3000"
                        })
                        data.scope = scope
                        updatainline(data, indexnum)
                    } else {
                        swal({
                            title: "订单评分",
                            text: "评分失败",
                            type: "warning",
                            timeout: "3000"
                        })
                    }
                },
                error: function (e) {
                    console.log("error")
                }
            })
            layer.close(index)
        }

        ,
    })
}


function apply_return_good(row,role) {

    // var name = row.id
    swal({
        title: "订单取消申请",
        text: "",
        type: "success",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "确定取消订单"
        // closeOnConfirm: false
    }, function () {
        // swal("订单取消！", "本订单取消申请已发送。", "success");
        var myarrays = []
        var arrays = {}
        switch (role){
            case "U":
                arrays.Anum = $(part).html()
                arrays.good_id = row.id
                arrays.Bnum = row.bnum
                myarrays.push(arrays)
                break
            case "W":
                arrays.Bnum = $(part).html()
                arrays.good_id = row.id
                arrays.Anum = row.anum
                myarrays.push(arrays)
                break
        }

        apply_return(myarrays)
    });
    // var index = layer.open({
    //     title: "订单取消申请",
    //     type: 1,
    //     area: ['350px', '220px'],
    //     shadeClose: true,
    //     content:
    //         '<h4 style="text-align: center">请你对这次家政服务订单号为 <a style="text-align: center;text-decoration: none;cursor: pointer">' + name + '</a> 进行评价</h4><p></p>' +
    //         '<h5 style="text-align: center">请你对此次此次服务评价' +
    //         '<select class="select-main" style="width: 43px">' +
    //         '<option value="1">1</option>' +
    //         '<option value="2">2</option>' +
    //         '<option value="3">3</option>' +
    //         '<option value="4">4</option>' +
    //         '<option value="5">5</option>' +
    //         '</select>' +
    //         '分' +
    //         '</h5>',
    //
    //     btn: ['是', '否'],
    //     scrollbar: false,
    //     yes: function () {
    //         var scope = $(".select-main").val()
    //         $.ajax({
    //             url: "../users/" + scope,
    //             type: "PUT",
    //             datatype: "json",
    //             contentType: "application/json",
    //             data: {"id": name},
    //             success: function (dat) {
    //                 if (dat.data == '1') {
    //                     swal({
    //                         title: "订单评分",
    //                         text: "你已给予该订单评分",
    //                         type: "success",
    //                         timeout: "3000"
    //                     })
    //                     data.scope = scope
    //                     updatainline(data, indexnum)
    //                 } else {
    //                     swal({
    //                         title: "订单评分",
    //                         text: "评分失败",
    //                         type: "warning",
    //                         timeout: "3000"
    //                     })
    //                 }
    //             },
    //             error: function (e) {
    //                 console.log("error")
    //             }
    //         })
    //         layer.close(index)
    //     }
    //
    //     ,
    // })
}