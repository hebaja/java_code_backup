<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais - Casa do Código</title>

<c:url value="/resources/css_bootstrap" var="cssPath"/>
<link rel="stylesheet" href="${cssPath }/bootstrap.min.css" >

<style type="text/css">
    body {
        padding-top: 80px;
    }
</style>

</head>
<body>
  
  <div class="container fixed-top">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">Casa do Código</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			  	<li class="nav-item active"> 
				  <a class="nav-link" href="${s:mvcUrl('PC#listar').build() }">Lista de Produtos<span class="sr-only">(current)</span></a>
				</li>
			  	<li class="nav-item active"> 
				  <a class="nav-link" href="${s:mvcUrl('PC#form').build() }">Cadastro de Produtos</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">
				  	<security:authentication property="principal" var="usuario"/>
				  	Usuário: ${usuario.username}
				</a></li>
			</ul>
		 </div>
		</nav>
	</div>

	<div class=container>
		<h1>Lista de Produtos</h1>
		<h2>${sucesso}</h2>
		<h2>${falha}</h2>
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Preços</th>
				<th>Páginas</th>
			</tr>
			<c:forEach items="${produtos }" var="produto">
				<tr>
					<td>
						<a href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build() }">${produto.titulo } </a>
					</td>
					<td>${produto.descricao }</td>
					<td>${produto.precos }</td>
					<td>${produto.paginas }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
				
	
	
	