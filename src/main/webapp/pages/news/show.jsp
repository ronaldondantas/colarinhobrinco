<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Notícia</title>
		<%@ include file="/WEB-INF/snippets/head-includes.jsp"%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/news-show.css">
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
						alt="Eike Batista deixa presídio Bangu">
					<div class="news-text">
						<pre>${news.content}</pre>
					</div>
				</article>
			</div>
		</main>
		<%@ include file="/WEB-INF/snippets/footer.jsp"%>
	</body>
</html>