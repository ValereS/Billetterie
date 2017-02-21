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
                <label>Retpoŝto:</label><input type="text" name="email" value="" /><br/>
                <label>Pasvorto:</label><input type="password" name="mdp" value="" /><br/>
                <input type="hidden" name="section" value="client">
                <input type="hidden" name="action" value="login">
                <input type="submit" value="Se connecter" />
            </form>
            <p class="error" style="color: red">
                ${errorMessage}
            </p>
        </div>
    </body>
</html>