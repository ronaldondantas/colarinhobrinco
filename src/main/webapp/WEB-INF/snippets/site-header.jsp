<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<header id="site-header">
	<a href="<c:url value='/'/>">
		<figure>
			<img id="site-logo" alt="Logotipo colarinho branco" src="${pageContext.request.contextPath}/resources/images/logo.gif">						
			<figcaption id="site-name">Colarinho branco</figcaption>
		</figure>
	</a>				
	<h1 id="page-title">${param.pageTitle}</h1>			
</header>