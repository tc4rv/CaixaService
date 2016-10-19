<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="business.Account" %>
<%@ page import="business.Client" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Escolha o valor</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<hgroup class="container">
				<h1><%= Account.currentAccount().getClient().getName() %></h1>
				<h3>Escolha o valor</h3>
			</hgroup>
		</header>
		
		<section class="container">
			<form action="Controller.do?command=Sacar" method="post">
				<div>
					<button class="btn btn-default" type="submit" name="valor" id="valor" value="10">10</button>
					<button class="btn btn-default" type="submit" name="valor" id="valor" value="20">20</button>
					<button class="btn btn-default" type="submit" name="valor" id="valor" value="50">50</button>
					<button class="btn btn-default" type="submit" name="valor" id="valor" value="100">100</button>
					<button class="btn btn-default" type="submit" name="valor" id="valor" value="200">200</button>
				</div>
				
				<div>
					<input class="form-control" type="text" name="escolha" id="escolha" placeholder="R$ 0,00" />
					<button class="btn btn-success" type="submit" name="valor" id="valor" value="">Sacar valor especificado</button>
				</div>
			</form>
		</section>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js" type="text/javascript" />
		<script src="bootstrap/js/bootstrap.min.js" type="text/javascript" />
	</body>
</html>
