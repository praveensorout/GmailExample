<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Acount</title>
    <link rel="stylesheet" href="assets/css/registration.css">
</head>
<body>
    <div class="container">
        <h1><span class="spn1">G</span><span class="spn2">o</span><span class="spn3">o</span><span class="spn4">g</span><span class="spn5">l</span><span class="spn6">e</span></h1>
        <h2>Create a Google Acount</h2>
        <p>Enter your detail</p>
        <form action="register" method="post" onsubmit="return formvalidate()">
            <table>
                <tr><td>Email</td><td><input class="inp" type="text" name="email" id="email"></td></tr>
                <tr><td>First Name</td><td><input class="inp" type="text" name="fname" id="fname"></td></tr>
                <tr><td>Last Name</td><td><input class="inp" type="text" name="lname" id="lname"></td></tr>
                <tr><td>Password</td><td><input class="inp" type="password" name="password" id="pass"></td></tr>
                <tr><td>Confirm Password</td><td><input class="inp" type="password" name="cpass" id="cpass"></td></tr>
                <tr class="inp1"><td><input type="Submit" value="Enter" id="btn"></td></tr>
            </table>
        </form>
    </div>
</body>
<script>
  let email = document.getElementById("email");
  let fname = document.getElementById("fname");
  let lname = document.getElementById("lname");
  let pass = document.getElementById("pass");
  let cpass = document.getElementById("cpass");
  function formvalidate(){
    if(email.value && fname.value && lname.value && pass.value && cpass.value && pass.value==cpass.value){
        return true;
    }
    else{
            return false;
        }
  }
  document.querySelector("#btn").onclick = function()
   {
    let pass = document.querySelector("#pass").value;
    let cpass = document.querySelector("#cpass").value;
    if(pass=="")
    {
        alert("please enter password");
    }
    else if(pass!==cpass){
        alert("password didn't match");
    }
   }
</script>
</html>