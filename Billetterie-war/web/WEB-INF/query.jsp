<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/bootstrap/css/bootstrap.min.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Billet Ti - Query</title>
    </head>
    <body>
        <c:url value="FrontController?section=navigation" var="url02" />
        <c:import url="${url02}" />
        <c:url value="FrontController?section=search" var="url03" />
        <c:import url="${url03}" />
        <hr />
        <div>
            <form action="FrontController" method="POST">
                <input type="hidden" name="section" value="query" />
                <textarea name="query" rows="4" cols="80">${query}</textarea>
                <input type="submit" value="Execute" />
            </form>

            <p>
                ${fn:length(resultList)} result(s)
            </p>

            <ul>
                <c:forEach var="item" items="${resultList}">
                    <li>
                        ${item}
                    </li>
                </c:forEach>
            </ul>
            <p>
                ${message}            
            </p>

        </div>
    </body>
</html>
