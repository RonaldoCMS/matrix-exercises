<%
	if(request.getSession().getAttribute("login") == null) {
		System.out.print("Eccomi");
		response.sendRedirect("index.jsp");
	}
%>
