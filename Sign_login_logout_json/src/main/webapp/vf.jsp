<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
input[type=submit] {
  width: 40%;
  background-color: #FF0000;
  color: white;
  padding: 7px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: #B22222;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<meta charset="UTF-8">
<title>Email Verify</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
 <form action="Code" method="Post">
 <h3 style="color:#001f3f;">---Email Verification---</h3>
        Enter the verification code: <input type="text" name="authcode" />
        <input type= "submit"  value="Verify">
        </form>

</body>
</html>