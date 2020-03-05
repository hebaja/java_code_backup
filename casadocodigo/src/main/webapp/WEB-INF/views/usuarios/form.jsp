<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Lista de usuários">

		<section class="container">
			<h1>Cadastro de Usuários</h1>
			<form:form action="${s:mvcUrl('UC#gravar').build() }" method = "post" commandName="usuario">
				<div class = "form-group">
					<label class="small">Nome</label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name"/>
				</div>
				<div class = "form-group">
					<label>Email</label>
					<form:input path="email" cssClass="form-control"/>${falha }
					<form:errors path="email"/>
				</div>
				<div class = "form-group">
					<label>Senha</label>
					<form:input type="password" path="senha" cssClass="form-control"/>
					<form:errors path="senha"/>
				</div>
				<div class = "form-group">
					<label>Senha repetida</label>
					<form:input type="password" path="senhaRepetida" cssClass="form-control"/>
					<form:errors path="senhaRepetida"/>
				</div>
				<button class="button" type="submit" class="btn btn-primary">Cadastrar</button>
			</form:form>
		</section>

</tags:pageTemplate>