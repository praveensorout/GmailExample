<head>
	<link rel="stylesheet" href="assets/css/style.css">
	<%@ include file="links.jsp"%>
</head>
<% String email = (String)session.getAttribute("usermail"); 
	session.setAttribute("useremail",email);
%>
<body>
	<%@ include file="navbar.jsp" %>
	<div class="main_body">
		<%@ include file="sidebar.jsp" %>
	</div>
</body>