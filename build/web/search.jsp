<%-- 
    Document   : search
    Created on : May 17, 2021, 9:51:52 AM
    Author     : DELL
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/search.css" rel="stylesheet" type="text/css"/>
        <title>My Digital News</title>
    </head>
    <body>
        <%@include file="components/header.jsp" %>
        <div class="page-body">
            <div class="container">
                <div class="left">
                    <c:forEach items="${requestScope.results}" var="a">
                        <div class="article">
                            <h3><a href="article?id=${a.id}">${a.title}</a></h3>
                            <img class="article-img" src="${a.image}" />
                            <p class="content">${a.description}</p>
                        </div>
                    </c:forEach>
                    <ul class="list-unstyled" id="pagination"></ul>
                    <script src="resources/js/pagger.js" type="text/javascript"></script>
                    <script>pagger('pagination', '${requestScope.keyword}', ${requestScope.pageIndex}, ${requestScope.totalPages});</script>
                </div>
                <%@include file="components/right.jsp" %>
            </div>
        </div>
        <%@include file="components/footer.jsp" %>
    </body>
</html>

