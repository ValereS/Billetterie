<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/boostrap/css/bootstrap.css" var="urlBootstrap" />
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
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <form action="FrontController" method="POST">
                        <label>Civilité:</label>
                        <input type="radio" name="civilite" value="M" id="radioM" /><label for="radioM">Monsieur</label>
                        <input type="radio" name="civilite" value="MME" id="radioMme" /><label for="radioMme">Madame</label>
                        <br/><br/>
                        <label>Nom</label><input type="text" name="nom" placeholder="Long" pattern="[A-Za-z1-9]{2,150}" required="required" /><br/><br/>
                        <label>Prénom</label><input type="text" name="prenom" placeholder="Phi" pattern="[A-Za-z1-9]{2,150}" /><br/><br/>
                        <label>Email</label><input type="text" name="email" value="" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" placeholder="Enter email" required="required"/><br/><br/>
                        <label>Mot de passe</label><input type="password" name="mdp" value="" pattern=".{4,30}" required="required" /><br/><br/>
                        <label>Validation mot de passe</label><input type="password" name="mdp" value="" pattern=".{4,30}" required="required" /><br/><br/>
                        <label>Date de naissance</label><input type="date" name="dateNaissance" placeholder="JJ/MM/AAAA" pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d" title="JJ/MM/AAAA"/><br/><br/>
                        <input type="hidden" name="section" value="client">
                        <input type="hidden" name="action" value="signup">
                        <input type="submit" value="S'inscrire" />
                    </form>
                    <p class="error" style="color: red">
                        ${errorMessage}
                    </p>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    </body>
</html>