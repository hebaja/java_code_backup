<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Permissões de usuarios">

	<jsp:body>
		<article email="${usuario.email }">
			<section class="container middle"> 
				<h1>Cadastro de Permissões Para ${usuario.name } User</h1>
					
					<form:form action="${s:mvcUrl('UC#alteraRoles').arg(0,usuario.email).build() }" method="post" commandName="usuario">
						<div>
							Permissões: 
							<form:checkboxes path="roles" items="${roles }" />
						</div>
						<div>
							<button class="button">Atualizar</button>
						</div>
					</form:form>
			</section>
		</article>
	</jsp:body>
	
</tags:pageTemplate>