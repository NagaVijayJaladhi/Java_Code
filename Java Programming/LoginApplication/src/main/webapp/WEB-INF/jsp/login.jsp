<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Application</title>
</head>
<body>
<font color = "red"> ${errorMessage}</font>
<form method = "post">
Name : <input type = "text" name = "name" /> Password : <input type = "password" name = "password"/> <input type = "submit"/>
</form>
</body>
</html>