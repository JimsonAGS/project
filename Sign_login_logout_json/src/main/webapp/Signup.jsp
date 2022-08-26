<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Page</title>
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
  background-color: #00BFFF;
  color: white;
  padding: 7px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}


input[type=submit]:hover {
  background-color: #00CED1;
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
<h1 style="color:#001f3f;">User Signup</h1>
<div>
<form action="Signup" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="name"  placeholder="abc@gmail.com"
pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/></td></tr>
<tr><td>Password:</td><td><input type="password" name="password" placeholder="length more than 5"
 pattern=".{5,}" required/></td></tr>
<tr><td>Gender: <br>
<input type="radio" name="gender" value="Boy" required>
  <label for="gender">Boy</label><br>
<input type="radio" name="gender" value="Girl" required>
  <label for="gender">Girl</label><br></td><tr>
<tr><td>City:</td><td>
<select name="city" style="width:150px" required>

<option>Tirunelveli</option>
<option>tenkasi</option>

</select>
</td></tr>
</table>
<input type="submit" value="Sign-in"/>
</form>
 <form action="login.jsp" >
        <input type= "submit"  value="Back">
</form>
</div>
</body>
</html>