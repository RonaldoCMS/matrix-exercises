<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="includes/head.jsp"/>
		<title>Register</title>
	</head>
	
	<body>
		<div class="container">
			<div class="d-flex justify-content-center h-100">
				<div class="card">
					<jsp:include page="includes/social.jsp"/>
					<div class="card-body">
					<form method="POST" action="sign-up">
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input name="username" type="text" class="form-control"
									placeholder="username">
							</div>
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								<input type="password" class="form-control" name="password"
									placeholder="password">
							</div>
														<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								<input type="password" class="form-control" name="confirm-password"
									placeholder="confirm password">
							</div>
							<div class="form-group">
								<input type="submit" value="Register"
									class="btn float-right login_btn">
							</div>
							<% if(request.getParameter("error") != null) { %>
							<div>
							<p style="color:red" >
								<% if(request.getParameter("error").equals("0")) {  %>
									 Non puoi lasciare i campi vuoti 
								<% } else if(request.getParameter("error").equals("1")) { %>
									 Le password non coincidono 
								 <% } else if(request.getParameter("error").equals("2")) { %>
								 	La password deve incominciare con una lettera grande, contenere almeno 8 caratteri + numeri e lettere speciali. 
								<% } else { %>
									L'utente già è autenticato.
								<% } %>
							</p>
							</div>
							<% } %>
						</form>
					</div>
					<div class="card-footer">
						<div class="d-flex justify-content-center links">
							have you an account?<a href="index.jsp">Sign In</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>