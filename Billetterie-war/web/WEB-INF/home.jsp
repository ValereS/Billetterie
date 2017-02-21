<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <title>Billet Ti - Accueil</title>
    </head>
    <body>
        <c:url value="FrontController?section=navigation" var="url02" />
        <c:import url="${url02}" />
        <c:url value="ControleurMain?section=search" var="url03" />
        <c:import url="${url03}" />
        <hr />
        <div>
            <p>
                Welcome to Billet Ti
            </p>
            <p>
                ${message}
            </p>
        </div>
    </body>
</html>
