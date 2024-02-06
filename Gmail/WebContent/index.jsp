
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gmail</title>
    <link rel="stylesheet" href="assets/css/index.css">
</head>
<script>
    function formvalidate()
    {
		let email = document.getElementById("email");
		let password = document.getElementById("password");
		if(email.value && password.value)
		{
			return true;    
		}
		else
		{
			return false;
		}
    }
</script>
<body  onload="document.myform.email.focus()">
    <div class="container">
        <h1><span class="spn1">G</span><span class="spn2">o</span><span class="spn3">o</span><span class="spn4">g</span><span class="spn5">l</span><span class="spn6">e</span></h1>
        <h2>Sign In</h2>
        <p>to continue to Gmail</p>
			<form action="login" method="post" name = "myform" onsubmit="return formvalidate()">
					<input type="text" name="email" oninput = "ajaxFunction(this.value)" placeholder="Email" id="email" class="inp"> 
					<div> <span id="disp" name="disp"></span><br> </div>
					<input type="password" name="password" placeholder="Password" id="password" class="inp">
					<div class="button">
						<input type="submit" value="Log In" class="btn" id="log">
						<button class="btn" id="acnt"><a href="registration.jsp" >Create Acount</a></button>
					</div>
			</form>
    </div>
	<div class="lang">
		<h1>Language:</h1>
		<p>English</p>
	</div>
</body>

</html>