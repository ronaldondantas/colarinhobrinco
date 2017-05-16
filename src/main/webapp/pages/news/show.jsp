<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Notícia</title>
		<%@ include file="/WEB-INF/snippets/head-includes.jsp"%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/news-show.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/news-commentaries.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/snippets/site-header.jsp">
			<jsp:param name="pageTitle" value="Notícia"/>
		</jsp:include>	
		<aside>
			<%@ include file="/WEB-INF/snippets/site-navbar.jsp"%>
		</aside>	
		<main>
			<div id="site-content">
				<article class="news">
					<h1 class="title">${news.title}</h1>
					<img src="${pageContext.request.contextPath}/image?newsId=${news.id}&imageFileName=${news.headlineImage}"
						alt="${news.title}">
					<div class="news-text">
						<pre>${news.content}</pre>
					</div>
				</article>
				<hr>
				<aside class="commentaries">
					<h1>Comentários</h1>
					<div id="news-commentaries">
						
						<c:forEach items="${news.comments}" var="item" varStatus="status">
							<div class="comment">
								<h2>${item.author}</h2>
								<p>${item.content}</p>
							</div>
						</c:forEach>						
					</div>
					
					<form id="add-commentary-form">
						<input type="hidden" value="${news.id}" name="newsId">
						
						<label for="commentary-author">Autor:</label>
						<input type="text" name="author" id="commentary-author" placeholder="Autor do comentário"
							maxlength=50 required>
					
						<label for="commentary-content">Comentário:</label>
						<textarea id="commentary-content" name="content" rows="3"
							placeholder="Comentário" maxlength="350" required></textarea>
							
						<button type="submit" id="submit-commentary-button"><strong>Enviar</strong></button>
					</form>
					
				</aside>
			</div>
		</main>
		<%@ include file="/WEB-INF/snippets/footer.jsp"%>
		<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif"
			alt="Processando requisição" id="ajaxloader" class="invisible">
		<script src="${pageContext.request.contextPath}/resources/scripts/commentaries.js"></script>
	</body>
</html>