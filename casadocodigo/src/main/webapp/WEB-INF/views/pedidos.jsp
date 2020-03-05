<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Lista de pedidos">

	<jsp:body>

	<section class="container middle">
		<h1>Lista de pedidos atuais</h1>

<h2>Data: ${response.data.time }</h2>

			<table>
				<tr>
					<th>ID</th>
					<th>Valor</th>
					<th>Data pedido</th>
					<th>Títulos</th>
				</tr>
				<c:forEach items="${carrinhoCompras.itens }" var="item">
					<tr>
						<td>${item.produto.id}</td>
						<td>${item.preco}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pedidos.data.time }"/></td>
						<td>${item.produto.titulo}</td>
					</tr>
				</c:forEach>
			</table>
	</section>
	
	</jsp:body>
	
</tags:pageTemplate>