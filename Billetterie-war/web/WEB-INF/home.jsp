<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/bootstrap/css/bootstrap.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Billet Ti - Home</title>
    </head>
    <body>
        <div class="jumbotron"><h1>Tickey Tousse</h1>
        <c:url value="FrontController?section=search" var="url03" />
        <c:import url="${url03}" />
        </div>
        <c:url value="FrontController?section=navigation" var="url02" />
        <c:import url="${url02}" />
        <c:url value="FrontController?section=cart-header" var="urlCart" />
        <c:import url="${urlCart}" />
        <hr />
        <div>
            <p>
                Welcome to Billet Ti
            </p>
            <p>
                ${message}
            </p>
        </div>
        <c:url var="urlBootStrapJS" value="/bootstrap/js/bootstrap.js" />
        <script src="${urlBootStrapJS}">
        </script>
    </body>
</html>
