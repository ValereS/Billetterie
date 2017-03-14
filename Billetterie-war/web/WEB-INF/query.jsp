<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/bootstrap/css/bootstrap.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Billetterie - Requêtes</title>
    </head>
    <body>
        <jsp:include page="menus/menu-main.jsp" />
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

        <c:url var="urlBootStrapJS" value="/bootstrap/js/bootstrap.js" />
        <script src="${urlBootStrapJS}"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>        
        <c:url var="scriptUrl" value="/javascript/script.js" />
        <script src="${scriptUrl}" type="text/javascript"></script>
    </body>
</html>
