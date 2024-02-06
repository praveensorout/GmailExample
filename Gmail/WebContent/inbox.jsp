<head>
	<link rel="stylesheet" href="assets/css/style.css">
	<%@ include file="links.jsp"%>
	<%@ page import = "java.sql.*" %>
</head>

<body>
	<%@ include file="navbar.jsp" %>
	
	<jsp:useBean id="pr" class="datainbox.DataInbox" >
	<jsp:setProperty name="pr" property="email" value="<%= mail %>"/>
	</jsp:useBean>

<%
	ResultSet rs= pr.inbox();
%>
	
	
	<div class="main_body">
		<%@ include file="sidebar.jsp" %>
		<div class="emailList">
		<table>
		<tr>
			<%@ include file="email_list.jsp"%>
			<div class="emailList_list">
                <div class="emailrow">
                    <table>
						<%
							while(rs.next())
							{
						%>
							<tr class="msg" onclick="myFunction()">
									<td class="inb" id="message"> <% rs.getString("id"); %> </td>
									<td class="inb" id="sender">
									<i class="fa-regular fa-star"></i>
									<i class="fa-solid fa-square-caret-right"></i>						
									<%= rs.getString("sender") %> </td>
									<td class="inb" id="message"> <%=rs.getString("message") %> </td>
									<td class="inb" id="time"> <%= rs.getString("date") %></td>
							</tr>
						<%
							}
						%>
					</table>
                </div>
            </div>
		</div>
	</div>
	
</body>