<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Swapping Programming</title>
</head>
<body>
	<h2 align="center">Swapping Programming</h2>
	<font color="red"> ${errorMessage} </font>
	<form method="post">
		<table>
			<tr>
				<td>First Value</td>
				<td>:</td>
				<td><input type="text" name="firstValue" /></td>
			</tr>
			<tr>
				<td>Second Value</td>
				<td>:</td>
				<td><input type="text" name="secondValue" /></td>
			</tr>
			<tr>
				<td>Select Operation</td>
				<td>:</td>
				<td><select name="operation">
						<option>--- Select Operation ---</option>
						<option>Single Line Operation</option>
						<option>Bit Wise XOR Operation</option>
						<option>Third Variable Operation</option>
						<option>Multiple Division Operation</option>
						<option>Addition Subtraction Operation</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Swapping Operation" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>