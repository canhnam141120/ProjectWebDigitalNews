<%-- 
    Document   : news
    Created on : May 17, 2021, 9:51:27 AM
    Author     : DELL
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <title>My Digital News</title>
    </head>
    <body>
        <%@include file="components/header.jsp" %>
        <div class="page-body">
            <div class="container">
                <div class="left">
                    <h3 class="title">${requestScope.article.title}</h3>
                    <img src="${requestScope.article.image}" class="article-img" alt="" />
                    <p class="line-height-fix content">${requestScope.article.content}</p>
                    <div class="meta-info">
                        <img src="resources/img/timeicon.gif" alt="" />
                        <img src="resources/img/comment.gif" alt="" />
                        <span>
                            By ${requestScope.article.author}
                            |
                            <fmt:formatDate pattern="MMM dd yyyy - h:mma" value="${requestScope.article.time}"/>
                        </span>
                    </div>
                </div>
                <%@include file="components/right.jsp" %>
            </div>
        </div>
        <%@include file="components/footer.jsp" %>
    </body>
</html>

