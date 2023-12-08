<%@page import="java.util.Random"%>
<%@ page isELIgnored="false" %>

<h1 style="color: red;text-align: center">Loan Approved</h1>

<center>
		<h3>Pre_Approved loan amount is::: <%=new Random().nextInt(100000) %></h3>
</center>

<br>

<a href="./">Home</a>
<br>
<a href="signout">Logout</a>