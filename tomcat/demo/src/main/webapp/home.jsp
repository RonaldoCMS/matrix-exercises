<%@page import="demo.servlet.AuthSignOut"%>
<%@page import="demo.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="demo.model.UserAuth"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<html>

<head>
	<jsp:include page="includes/head.jsp" />  
	<title>Home</title>
</head>

<body>
	<input type="submit" onClick=<% new AuthSignOut().signOut(request, response); %>>
	<section class="section-products">
		<div class="container">
			<div class="row justify-content-center text-center">
				<div class="col-md-8 col-lg-6">
					<div class="header">
						<h3>Featured Product</h3>
						<h2>Popular Products</h2>
					</div>
				</div>
			</div>
			<div class="row">
			<% List<Prodotto> prodotti = (ArrayList) request.getSession().getAttribute("prodotti"); %>
		  
			<% for(Prodotto prodotto : prodotti) { %>
								<!-- Single Product -->
				<div class="col-md-6 col-lg-4 col-xl-3">
					<div id="product-2" class="single-product">
						<div class="part-1">
						<img src="<%= prodotto.getImg() %>"/>
						<% if(prodotto.getSconto() != 0) { %>
							<span class="discount"><%=prodotto.getSconto()%>% SCONTO</span>
							<% } %>
							<ul>
								<li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
								<li><a href="#"><i class="fas fa-heart"></i></a></li>
								<li><a href="#"><i class="fas fa-plus"></i></a></li>
								<li><a href="#"><i class="fas fa-expand"></i></a></li>
							</ul>
						</div>
						<div class="part-2">
							<h3 class="product-title"><%= prodotto.getNome() %></h3>
							<h4 class="product-price"><%= prodotto.getCosto() %>€</h4>
						</div>
					</div>
				</div>
				<%}%>
			</div>
		</div>
	</section>
</body>

</html>