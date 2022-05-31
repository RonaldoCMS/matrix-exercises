
<!DOCTYPE html>
<html class="index">
	<head>
		<jsp:include page="includes/head.jsp" />
		<title>Login</title>
	</head>
	<body class="index">
		<div class="container">
			<div class="d-flex justify-content-center h-100">
				<div class="card"><jsp:include page="includes/social.jsp" />
					<div class="card-body">
						<form
						method="post"
						action="sign-in">
							<div class="input-group form-group">
								<div class="input-group-prepend"><span
									class="input-group-text"><i class="fas fa-user"></i></span></div> <input
								name="username"
								type="text"
								class="form-control"
								placeholder="username">
							</div>
							<div class="input-group form-group">
								<div class="input-group-prepend"><span
									class="input-group-text"><i class="fas fa-key"></i></span></div> <input
								type="password"
								class="form-control"
								name="password"
								placeholder="password">
							</div>
							<div class="row align-items-center remember"><input
								type="checkbox">Remember Me</div>
							<div class="form-group"><input
								type="submit"
								value="Login"
								class="btn float-right login_btn"></div> <%
								if (request.getParameter("error") != null) {
								%>
							<div>
								<p style="color: red">
									<%
										if (request.getParameter("error").equals("2")) {
										%> Credenziali errate <%
										} else {
										%> Database OFFLINE <%
										}
										%>
							</p>
							</div> <%}%>
					</form>
					</div>
					<div class="card-footer">
						<div class="d-flex justify-content-center links">Don't have an
							account?<a href="register.jsp">Sign Up</a>
					</div>
						<div class="d-flex justify-content-center">
						<a href="#">Forgot your password?</a></div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>