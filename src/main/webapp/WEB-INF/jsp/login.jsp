<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>登录</title>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/css/login.css"
	type=text/css rel=stylesheet>
<link href="${pageContext.request.contextPath}/css/main.css"
	type=text/css rel=stylesheet>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js">
	
</script>
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<script>
	// 判断是登录账号和密码是否为空
	function check() {
		var usercode = $("#usercode").val();
		var password = $("#password").val();
		if (usercode == "" || password == "") {
			$("#message").text("账号或密码不能为空！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="container">
		<div class="box">
			<div class="top">
				<div class="title">登录</div>
				<span class="message" id="message">${msg}</span>
			</div>
			<div class="middle">
				<form action="${pageContext.request.contextPath }/login.action"
					method="post" onsubmit="return check()"
					class="account_and_password">
					<div>
						<label for="user_account">账号</label> <input id="usercode"
							type="text" name="usercode" />
					</div>
					<p></p>
					<div>
						<label for="user_password">密码</label> <input id="password"
							type="password" name="password" />
					</div>
					<div>
						<button class="button" style="vertical-align: middle">
							<span>登录</span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
