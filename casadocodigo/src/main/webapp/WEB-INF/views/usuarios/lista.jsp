<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Lista de usuarios">

	<jsp:body>

	<section class="container middle">
		<h2><a href="usuarios/form">Novo usuário</a></h2>
		<h1>Lista de usuários</h1>
		<h2>${sucesso }</h2>
		<h2>${falha }</h2>
			<table>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Roles</th>
					<th></th>
				</tr>
				<c:forEach items="${usuarios }" var="usuario">
					<tr>
						<td>${usuario.name}</td>
						<td>${usuario.email}</td>
						<td>${usuario.roles }</td>
						<td>
							<a href="${s:mvcUrl('UC#detalhe').arg(0,usuario.email).build()}">					
							<img src="${contextPath } /resources/imagens/add.gif" width="18" height="18" alt="add" title="roles" /> 
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
	</section>
	
	</jsp:body>
	
</tags:pageTemplate>