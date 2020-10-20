<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" >
	<link rel="stylesheet" type="text/css" href="css/login.css">

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/jquery.serializejson.min.js"></script>
	<script type="text/javascript" src="js/md5.js"></script>

	<script type="text/javascript">
	$(function(){
		$("#registerForm").validate({
			rules:{
				username:{
					required:true,
					minlength:3,
					remote:"user?action=check_username"
				},
				password:{
					required: true,
					minlength: 6,
				},
				confirm:{
					required: true,
					equalTo:"#password"
				},
				email:{
					required: true,
					email: true,
					remote: "user?action=check_email"
				},
				gender:{
					required: true,
				}
			},
			messages:{
				username: {
					required:"必填",
					minlength:"不得少于3位",
					remote:"bug"
				},
				password:{
					required:"必填",
					minlength:"不得少于6位",
				},
				confirm: {
					required:"必填",
					equalTo:"两次密码需一致",
				},
				email:{
					required:"必填",
					remote:"bug"
				},
				gender:{
					required:"必填",
				}
			},
			submitHandler:function (element) {
				var formData = $(element).serializeJSON();

				formData.password = md5(formData.password);

				delete formData.confirm;

				$.post({
					url:"user?action=register",
					data:formData,
					success:function (data) {
						location.href = "registerSuccess.jsp";
					}
				});

				return false;
			}
		});
	});
</script>
<title>注册</title>
</head>
<body>
<div class="regist">
	<div class="regist_center">
		<div class="regist_top">
			<div class="left fl"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;会员注册</div>
			<div class="right fr">
				<a href="index.jsp" target="_black">小米商城</a>
			</div>
			<div class="clear"></div>
			<div class="xian center"></div>
		</div>
		<div class="center-block" style="margin-top: 80px;">
			<form id="registerForm" class="form-horizontal" action="userRegister" method="post">

				<div class="form-group">
					<label class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-8" style="width: 40%">
						<input type="text" id="username" name="username" class="form-control col-sm-10"
							   placeholder="Username"/>
					</div>
					<div class="col-sm-2">
						<label for="username" class="error text-danger help-block" style="display:none;"></label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">密码</label>
					<div class="col-sm-8" style="width: 40%">
						<input id="password" type="password" name="password"
							   class="form-control col-sm-10" placeholder="Password"/>
					</div>
					<div class="col-sm-2">
						<label for="password" class="error text-danger help-block" style="display:none;">请输入6位以上字符</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">确认密码</label>
					<div class="col-sm-8" style="width: 40%">
						<input id="confirm" type="password" name="confirm" class="form-control col-sm-10"
							   placeholder="Password Again"/>
					</div>
					<div class="col-sm-2">
						<label for="confirm" class="error text-danger help-block" style="display:none;">两次密码要输入一致哦</label>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-8" style="width: 40%">
						<input id="email" type="text" name="email" class="form-control col-sm-10"
							   placeholder="Email"/>
					</div>
					<div class="col-sm-2">
						<label for="email" class="error text-danger help-block" style="display:none;">填写正确邮箱格式</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">性别</label>
					<div id="gender" class="col-sm-8" style="width: 40%">
						<label class="radio-inline">
							<input type="radio" name="gender" value="m"> 男
						</label>
						<label class="radio-inline">
							<input type="radio" name="gender" value="f"> 女
						</label>
					</div>
					<div class="col-sm-2">
						<label for="gender" class="error text-danger help-block" style="display:none;">你是帅哥 还是美女</label>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<div class="col-sm-7 col-sm-push-2">
						<input id="registerBtn" type="submit" value="注册" class="btn btn-primary  btn-lg"
							   style="width: 200px;"/> &nbsp; &nbsp;
						<input type="reset" value="重置" class="btn btn-default  btn-lg" style="width: 200px;"/>
					</div>
				</div>
				<div>${session.registerMsg}</div>
			</form>
		</div>
	</div>
</div>

</body>
</html>