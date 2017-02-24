<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <title>Billet Ti - Home</title>
    </head>
    <body>
        <c:url value="FrontController?section=navigation" var="url02" />
        <c:import url="${url02}" />
        <c:url value="FrontController?section=search" var="url03" />
        <c:import url="${url03}" />
        <hr />
        <div>
            
            <form action="FrontController" method="POST">
                <input type="hidden" name="section" value="client" />
                <input type="hidden" name="action" value="manage" />
                <input type="text" name="nom" value="${client.nom}" /><br>
                <input type="text" name="nom" value="${client.prenom}" /><br>
                <input type="text" name="nom" value="${client.email}" /><br>
                <input type="password" name="nom" ${client.hashMotPasse} /><br>
                
                <input type="submit" value="OK" name="doIt" />
            </form>
            <p>${message}</p>
        </div>
    </body>
</html>
