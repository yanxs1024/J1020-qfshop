<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<link rel="stylesheet" type="text/css" href="css/login.css">

    <script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.serializejson.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/md5.js"></script>

	<title>登录</title>
    <script type="text/javascript">
        $(function () {
        	$("#userLogin").validate({
				rules:{
					username:{
						required:true,
						minlength:3
					},
					password:{
						required: true,
						minlength: 6
					},
					vcode:{
						required:true,
						minlength:4
					}
				},
				messages:{
					username: {
						required:"请输入账号",
						minlength:"账号输入有误"
					},
					password:{
						required:"请输入密码",
						minlength:"密码输入有误"
					},
					vcode: {
						required:"请输入验证码",
						minlength:"验证码输入有误"
					}

				},
				submitHandler:function (element,event) {
					var formData = $(element).serializeJSON();
					formData.password = md5(formData.password);

					$.post({
						url:"user?action=login",
						data:formData,
						dataType:"json",
						success:function (data) {
							if (data.success) {
								location.href = "index.jsp";
							} else {
								$("#checkMsg").text(data.msg);
							}

							$("#captcha").click();
						},
						error:function () {
							console.log();
						}
					});
				}
			});

        	$("#captcha").click(function () {
				$("#captcha").attr("src","captcha?id=" + Math.random());
			});

        	$("#captcha").attr("src","captcha");

            // //1.验证用户名是否存在
            // $("#username").change(function () {
            //     $.get("checkUserName", "username=" + this.value, function (data) {
            //         if (data == 0) {
            //             $("#nameMsg").html("用户名不存在").css("color", "red");
            //         } else {
            //             $("#nameMsg").html("");
            //         }
            //     })
            // });
            // //2.点击验证码 跟新验证码
            // $("#pagecode").click(function () {
            //     $("#pagecode").attr("src", "code?" + Math.random());
            // });
            // //3.验证输入的验证码 是否正确
            // $("#vcode").change(function () {
            //     $.get("checkCode", "code=" + this.value, function (data) {
            //         if (data == 0) {
            //             $("#checkMsg").html("<font color='green'>OK</font>");
            //             $("#btn").removeAttr("disabled");
            //         } else {
            //             $("#checkMsg").html("<font color='red'>ERROR</font>");
            //             $("#pagecode").attr("src", "code?" + Math.random());
            //             $("#btn").Attr("disabled", true);
            //         }
            //     })
            // });
            // //4.两周以内自动登录  友好提示
            // $("#autoLogin").click(function () {
            //     if (this.checked) {
            //         $("#autoLoginMsg").html("公司电脑请勿勾选此项").css("color", "red");
            //     } else {
            //         $("#autoLoginMsg").html("");
            //     }
            // })
        });
    </script>
</head>
<body>
<!-- login -->
<div class="top center">
    <div class="logo center">
        <a href="${pageContext.request.contextPath }/index.jsp" target="_blank"><img src="./image/mistore_logo.png"
                                                                                     alt=""></a>
    </div>
</div>
<form method="post" action="userLogin" class="form center" id="userLogin">
    <div class="login">
        <div class="login_center">
            <div class="login_top">
                <div class="left fl">会员登录</div>
                <div class="right fr">您还不是我们的会员？<a href="${pageContext.request.contextPath }/register.jsp"
                                                   target="_self">立即注册</a></div>
                <div class="clear"></div>
                <div class="xian center"></div>
            </div>
            <div class="login_main center">
                <div class="username">
                    <div class="left fl">用户名:&nbsp;</div>
                    <div class="right fl">
                        <input class="shurukuang" type="text" name="username" id="username" placeholder="请输入你的用户名"/>
                        <label for="username"></label>
                    </div>
                </div>
                <div class="username">
                    <div class="left fl">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</div>
                    <div class="right fl">
                        <input class="shurukuang" type="password" name="password" id="password" placeholder="请输入你的密码"/>
                  		<label for="password"></label>
                    </div>
                </div>
                <div class="username">
                    <div class="left fl">验证码:&nbsp;</div>
                    <div class="right fl">
						<input name="vcode" class="yanzhengma" id="vcode" type="text" placeholder="验证码"/>
                        <img id="captcha">
						<label for="vcode"></label></div>
                </div>
                <div class="username">
                    <div class="left fl">&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <div class="right fl"><label id="checkMsg"></label></div>
                </div>
                <div class="username">
                    <input id="autoLogin" name="auto" type="checkbox"/>&nbsp;&nbsp;两周以内自动登录
                    <span id="autoLoginMsg"></span>
                </div>
                <div class="login_submit">
                    <input class="submit" type="submit" id="btn" >
                </div>
                <span style="color:red">${msg}</span>
            </div>
        </div>
    </div>
</form>
<footer>
    <div class="copyright">简体 | 繁体 | English | 常见问题</div>
    <div class="copyright">小米公司版权所有-京ICP备10046444-<img src="./image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号
    </div>

</footer>
</body>
</html>