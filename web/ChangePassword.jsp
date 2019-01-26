
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link href="style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container"> 
        <div class="header"><center><font size="10" color="silver"><b><u>Change Password</u></b></font></center></div>
        
        <% String uid=request.getParameter("uid"); %>
        
        <form action="ChangePassword" method="post">
        <center>    
        <br><br>    
        <table>
						<tr>
							<td>Enter New Password</td>
							<td><input onkeyup="validate()" type="password" name='pass' id="pass" placeholder="enter password"></td>
							<td><span id="pdisplay"></span></td>
						</tr>
						<tr>
							<td>Re-Enter Password</td>
							<td><input onkeyup="validate()" type="password" name='rpass' id="rpass" placeholder="re-enter password"></td>
							<td><span id="rdisplay"></span></td>
						</tr>
                                                <tr>
                                                    <td><input type="hidden" value="<%=uid%>" name="uid"/></td>
						</tr>
                                                
        </table></center><br>
					<center><input type='submit' name='submit' value='submit'/></center>
					</form>
							<script>
							function validate()    
							{
								var pass=document.getElementById("pass");
								var rpass=document.getElementById("rpass");
							if(pass.value==="")
							{
								var pdisplay=document.getElementById("pdisplay");
								pdisplay.innerHTML="Fill Password";
								pdisplay.style.color="red";
							}
							else
							{
							   var pdisplay=document.getElementById("pdisplay");
							   pdisplay.innerHTML="";
							}
							 if(rpass.value==="")
							{
								var rdisplay=document.getElementById("rdisplay");
								rdisplay.innerHTML="Re-Fill Password";
								rdisplay.style.color="red";
							}
							else
							{
								   if(pass.value===rpass.value)
								   {
								var rdisplay=document.getElementById("rdisplay");
								rdisplay.innerHTML="Password matched";
								rdisplay.style.color="green";
								   }
								   else
								   {
								var rdisplay=document.getElementById("rdisplay");
								rdisplay.innerHTML="Password not matched";
								rdisplay.style.color="blue";
									   
									   
								   }
									
							}   
							}
							</script>
        
        <br><br>
        <div class="footer">
              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>
               Designed By Gagan Patankar</center>
           </div>
        </div>
    </body>
</html>
