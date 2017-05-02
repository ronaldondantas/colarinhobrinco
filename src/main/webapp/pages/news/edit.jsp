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
			<jsp:param name="pageTitle" value="Enviar notícia"/>
		</jsp:include>	
		<aside>
			<%@ include file="/WEB-INF/snippets/site-navbar.jsp"%>
		</aside>	
		<main>
			<div id="site-content">
				<form method="post" action="${pageContext.request.contextPath}/news/save" enctype="multipart/form-data">
					<label for="title">Título:</label>
					<input id="title" name="title" type="text" placeholder="Título" maxlength="75" required autofocus>
					
					<label for="date">Data e horário:</label>
					<input id="date" name="date" type="datetime-local" required>
					
					<label for="headline-content">Conteúdo:</label>
					<textarea id="headline-content" name="headline-content" rows="3"
						placeholder="Manchete" maxlength="350" required></textarea>
					
					<label for="news-content">Conteúdo:</label>
					<textarea id="news-content" name="content" rows="10" placeholder="Conteúdo" required></textarea>
					
					<label for="headline-image">Imagem da manchete:</label>
					<input id="headline-image" name="headline-image" type="file" accept=".jpg,jpeg,.png" required>
					
					<button type="submit"><strong>Enviar</strong></button>
				</form>
			</div>
		</main>
		<%@ include file="/WEB-INF/snippets/footer.jsp"%>
	</body>
</html>