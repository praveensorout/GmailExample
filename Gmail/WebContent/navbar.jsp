
<link rel="stylesheet" href="assets/css/navbar.css">

<style>
	.user{
		color:red;
		font-weight:bold;
	}
	.user button{
		padding:5px 10px;
		border:none;
		background-color:red;
		border-radius:12px;
		margin:5px;
		cursor:pointer;
	}
	.user button a{
		color:white;
		text-decoration:none;
		font-size:18px;
	}
</style>

<!-- navbar -->
	
		<div class="header">
			<div class="header_left">
				<i class="fa-solid fa-bars"></i>
				<img src="assets/images/logo.jpg" alt="">
			</div>
			<div class="header_middle">
				<i class="fa-solid fa-magnifying-glass"></i>
				<input type="text" placeholder="Search Mail">
				<i class="fa-solid fa-caret-down"></i>
			</div>
			<div class="header_right">
				<i class="fa-solid fa-grip"></i>
				<i class="fa-regular fa-bell"></i>
				<i class="fa-solid fa-circle-user"></i>
			</div>
		</div>
		<div class="user">
			<% String mail = (String)session.getAttribute("useremail"); %>
			<%= mail %>
			<button><a href="logout.jsp">Log out</a></button>
		</div>
<!-- end navbar -->