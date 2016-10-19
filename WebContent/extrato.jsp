<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/Account.tld" prefix="acc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	</head>
	<body>
		<header class="container">
			<hgroup>
				<h1>${acc:currentAccount().client.name }</h1>
				<h3 class="text-center">Extrato</h3>
			</hgroup>
		</header>
		
		<section class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Data</th>
						<th>Operação</th>
						<th>Valor</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="element" items="${acc:currentAccount().bankStatement}">
						<tr>
							<td>${element.data}</td>
							<td>${element.operacao}</td>
							<td>${element.valor}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button class="btn btn-default" type="submit"><a href="menu.jsp">Menu</a></button>
		</section>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js" type="text/javascript" />
	<script src="bootstrap/js/bootstrap.min.js" type="text/javascript" />
	</body>
</html>