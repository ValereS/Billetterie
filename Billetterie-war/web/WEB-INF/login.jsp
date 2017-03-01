<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/bootstrap/css/bootstrap.min.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Billet Ti - Home</title>
    </head>
    <body>
        <c:url value="FrontController?section=navigation" var="url02" />
        <c:import url="${url02}" />
        <c:url value="FrontController?section=search" var="url03" />
        <c:import url="${url03}" />
        <hr />
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                    <form action="FrontController" method="POST">
                        <div class="col-md-4">
                            <label>Email:</label><input type="text" name="email" value="" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" /><br/>
                            <label>Password:</label><input type="password" name="mdp" value="" pattern=".{4,30}"/><br/>
                            <input type="hidden" name="section" value="client">
                            <input type="hidden" name="action" value="login">
                        </div>
                        <div class="col-md-2">
                            <input type="submit" value="Se connecter" id="buttonConnection"/>
                        </div>
                    </form>
                <div class="col-md-2">
                    <p class="error" style="color: red">
                        ${errorMessage}
                    </p>
                    </div>
            </div>
        </div>
    </body>
</html>