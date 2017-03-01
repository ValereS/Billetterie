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
        <title>Billet Ti - Client</title>
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
                        <input type="hidden" name="section" value="client" />
                        <input type="hidden" name="action" value="manage" />
                        <label>Civilité:&nbsp;</label> ${client.civilite}<br>
                        <label>Nom:&nbsp;</label><input type="text" name="nom" value="${client.nom}" /><br>
                        <label>Prenom:&nbsp;</label><input type="text" name="prenom" value="${client.prenom}" /><br>
                        <label>Mail:&nbsp;</label><input type="text" name="mail" value="${client.email}" /><br>
                        <label>Mot de passe:&nbsp;</label><input type="password" name="motDePasse" /><br>
                        <label>Date de Naissance:&nbsp;</label><input type="date" name="dateNaissance" value="${client.dateNaissance}" placeholder="JJ/MM/AAAA" pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d" title="JJ/MM/AAAA"/><br>
                        <label>Statut:&nbsp;</label>${client.statut}<br>
                    </div>
                    <div class="col-md-2">
                        <input type="submit" value="Modification" name="doIt" />
                    </div>
                </form>

            </div>
            <div class="col-md-6">
                <p class="alert-info">
                    ${message}
                </p>
            </div>        
        </div>
    </body>
</html>



