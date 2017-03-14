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
        <title>Billetterie - Connexion</title>
    </head>
    <body>
        <jsp:include page="menus/menu-main.jsp" />
       <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <form action="FrontController" method="POST">
                    <div class="col-md-4">
                        <label>Email:</label><input type="email" name="email" value="" /><br/>
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
                    
        <c:url var="urlBootStrapJS" value="/bootstrap/js/bootstrap.js" />
        <script src="${urlBootStrapJS}"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <c:url var="scriptUrl" value="/javascript/script.js" />
        <script src="${scriptUrl}" type="text/javascript"></script>
    </body>
</html>




