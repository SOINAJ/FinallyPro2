var number = 2

function mybut_fun1(num) {
//	console.log("234")
	var num1 = num
	var name = "mybin_"
	var ele = $(".myform_2")
	if(num1 == 1) {
		name += num1
		ele.children().remove()
		number = 2
	}
	else {
		name += number
		number++
	}
	var text = ""
	text +=	'<div class="'+name+'">'+
		'<div class="form-group">'+
		'<label>用户名：</label>'+
		'<input type="email" placeholder="请输入用户名" class="form-control"></div>'+
		'<div class="form-group">'+
		'<label>密码：</label>'+
		'<input type="password" placeholder="请输入密码" class="form-control"></div>'+
		'<div>'+
		'<label>'+
		'<input type="checkbox" class="i-checks">自动登录</label>'+
		'<hr /></div></div>'



	ele.append(text)
//				console.log("123")

}