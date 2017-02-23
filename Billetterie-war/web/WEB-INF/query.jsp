<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/bootstrap/css/bootstrap.min.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Query</title>
    </head>
    <body>
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
    </body>
</html>
