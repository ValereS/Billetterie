<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/css/style.css" var="url01" />
    <link href="${url01}" rel="stylesheet" type="text/css"/>
    <c:url value="/bootstrap/css/bootstrap.css" var="urlBootstrap" />
    <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
    <title>Billetterie - Commandes</title>
</head>
<body>
    <jsp:include page="menus/menu-main.jsp" />
    <div>
        <c:url var="url" value="FrontController">
            <c:param name="section" value="orders-display" />
        </c:url>
        <c:import url="${url}" />
    </div>
<c:url var="urlBootStrapJS" value="/bootstrap/js/bootstrap.js" />
<script src="${urlBootStrapJS}"></script>
<c:url var="scriptUrl" value="/javascript/script.js" />
<script src="${scriptUrl}" type="text/javascript"></script>
</body>
</html>
