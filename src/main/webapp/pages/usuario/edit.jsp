<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Enviar notícia</title>
		<%@ include file="/WEB-INF/snippets/head-includes.jsp"%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/news-edit.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/snippets/site-header.jsp">
			<jsp:param name="pageTitle" value="Cadastrar Usuário"/>
		</jsp:include>	
		<aside>
			<%@ include file="/WEB-INF/snippets/site-navbar.jsp"%>
		</aside>	
		<main>
			<div id="site-content">
				<form method="post" action="${pageContext.request.contextPath}/usuario/save" enctype="multipart/form-data">
					<label for="title">Nome:</label>
					<input id="nome" name="nome" type="text" placeholder="Nome" maxlength="75" required autofocus>					
					
					<label for="headline-content">Email:</label>
					<input id="email" name="email" type="text" placeholder="Email" maxlength="75" required autofocus>
					
					<label for="news-content">Senha:</label>
					<input id="senha" name="senha" type="text" placeholder="Senha" maxlength="15" required autofocus>					
					
					<button type="submit"><strong>Enviar</strong></button>
				</form>
			</div>
		</main>
		<%@ include file="/WEB-INF/snippets/footer.jsp"%>
	</body>
</html>