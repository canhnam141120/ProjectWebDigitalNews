<%-- 
    Document   : right
    Created on : May 17, 2021, 9:50:27 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="right">
    <div class="block">
        <h3 class="title">Digital News</h3>
        <p class="line-height-fix content">${requestScope.latestArticle.description}</p>
    </div>
    <div class="block">
        <h3 class="title">Search</h3>
        <form action="search" method="get" id="search-form" onsubmit="formSubmit()">
            <input type="text" name="keyword" id="search-input" value="${param.keyword}" oninput="input()" required=""/>
            <input type="submit" value="Go" id="search-btn" />
        </form>
        <p id="error"></p>
        <script src="resources/js/form.js" type="text/javascript"></script>
    </div>
    <div class="block">
        <h3 class="title">Last Articles</h3>
        <ul class="list-unstyled newest-article">
            <c:forEach items="${requestScope.last5Articles}" var="a">
                <li><a href="article?id=${a.id}">${a.title}</a></li>
                </c:forEach>
        </ul>
    </div>
</div>
