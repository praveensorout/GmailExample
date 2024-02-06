<%@ include file="links.jsp"%>
<head>
	<link rel="stylesheet" href="assets/css/compose.css">
</head>

<body>
	<nav>
	<h1>New Messages</h1>
		<div class="icons">
			<i class="fa-solid fa-minus"></i>
			<i class="fa-solid fa-up-right-and-down-left-from-center"></i>
			<i class="fa-solid fa-xmark"></i>
		</div>
	</nav>
	<div class="container">
		 <form method="post" id="myform">
		  <table>
			   <tr class="tab"><td><span class="inp">To:</span></td><td><input type="text" name="to" class="inpf" id="compto"></td></tr>
			   <tr class="tab"><td><span class="inp">Subject:</span></td><td><input type="text" name="subj" class="inpf" id="compsubj"></td></tr>
			   <tr class="tab"><td><span class="inp">Message:</span></td><td><input type="text" name="msg" class="inpf" id="compmsg"></td></tr>
				   <div>
						<table>
							 <tbody class="button">
								  <tr> <td><input type="reset" value="reset" class="bttn"></td></tr>
								  <tr> <td><input type="submit" value="submit" class="bttn" id="sbmt"></td></tr>
								  <tr> <td><input type="submit" value="save" class="bttn" id="save"></td></tr>
							 </tbody>
						</table>
				   </div>  
		  </table>
		 </form>
	</div>
		 <script>
		  document.getElementById("sbmt").addEventListener("click",abc);

		  function abc(){
			   document.getElementById("myform").action = "compose";
		  }

		  document.getElementById("save").addEventListener("click",xyz);

		  function xyz(){
			   document.getElementById("myform").action = "draft";
		  }
		 </script>
</body>

     
   

