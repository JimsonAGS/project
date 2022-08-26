<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
	
	<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=password], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 40%;
  background-color: #228B22;
  color: white;
  padding: 7px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #006400;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>
  <%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  %>
  <div>
<script>
function myFunction() {
  alert("A verfication link is send ur mail id Pls check... expire in 15 s");
}
</script>
 <form action="login" method="Post">
  
        <h1 style="color:#001f3f;">Enter Login details</h1>
         
        <table>
            <tr>
                <td>User Name:</td>
                <td><input type="text" name="usName" placeholder="abc@gmail.com"
                pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/></td>
            </tr>
            <tr>
                <td>User Password:</td>
                <td><input type="password" name="usPass" placeholder="length more than 5"
                pattern=".{5,}" required/></td>
            </tr>
            
  
 
        </table> 
         <input  onclick="myFunction()" type="submit" value="Login" /> 
        </form>
         
        
        <form action="Signup.jsp" >
        <input type= "submit" name ="Submit" value="Signup">
        </form>
       
  
    </div>
    
</body>
</html>