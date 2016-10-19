<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/Account.tld" prefix="acc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Escolha a operação</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<header>
		<hgroup class="text-center container">
			<h1 class="text-left">${acc:currentAccount().client.name}</h1>
			<h3>Escolha a operação</h3>
		</hgroup>
	</header>
	
	<section class="container">
		<c:if test="${Info ne null}">
			<div class="alert alert-warning alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				${Info.mensagem}
			</div>
		</c:if>
	</section>
	
	<section class="container">
		<button class="btn btn-default" type="submit" ><a href="opcoesSacar.jsp">Sacar</a></button>
		<button class="btn btn-default" type="submit" ><a href="extrato.jsp">Extrato</a></button>
	</section>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js" type="text/javascript" />
	<script src="bootstrap/js/bootstrap.min.js" type="text/javascript" />
</body>
</html>