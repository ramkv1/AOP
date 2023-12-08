<%@page import="java.util.Random"%>
<%@ page isELIgnored="false" %>

<h1 style="color: red;text-align: center">Account Balance</h1>

<center>
		<h3>Account Balance is::: <%=new Random().nextInt(100000000) %></h3>
</center>

<br>

<a href="./">Home</a>
<br>
<a href="signout">Logout</a>