<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Notícias</title>
		<%@ include file="/WEB-INF/snippets/head-includes.jsp"%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/news-list.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/snippets/site-header.jsp">
			<jsp:param name="pageTitle" value="Notícias"/>
		</jsp:include>	
		<aside>
			<%@ include file="/WEB-INF/snippets/site-navbar.jsp"%>
		</aside>	
		<main>	
			<div id="site-content">	
					
				<c:forEach items="${news}" var="item" varStatus="status">	
				
					<article class="news-headline ${status.count % 2 == 0 ? 'even' : 'odd'}">
					
						<h2 class="news-headline-title">
							<a href="
								<c:url value='/front'>
                                                                        <c:param name='command' value='Show' />
                                                                        <c:param name='newsId' value='${item.id}' />
                                                                </c:url>">
								${item.title}
							</a>
						</h2>
						
						<a href="
							<c:url value='/front'>
								<c:param name='command' value='Show' />
                                                                <c:param name='newsId' value='${item.id}' />
							</c:url>">
							<img src="${pageContext.request.contextPath}/image?newsId=${item.id}&imageFileName=${item.headlineImage}"
								class="news-headline-image" >
						</a>
						
						<time datetime="<fmt:formatDate value='${item.date}' type='both' pattern='yyyy-MM-dd HH:mm:ss'/>"
							class="news-headline-time">
							<fmt:formatDate value="${item.date}" type="both"/>
						</time>
						
						<p>${item.headlineContent}</p>
					
					</article>
				
				</c:forEach>
				
			</div>
		</main>
		<%@ include file="/WEB-INF/snippets/footer.jsp"%>
	</body>
</html>