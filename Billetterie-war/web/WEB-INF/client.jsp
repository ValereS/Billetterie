<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/bootstrap/css/bootstrap.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Billetterie - Client</title>
    </head>
    <body>
        <jsp:include page="menus/menu-main.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <h1>Coordonnées:&nbsp;</h1>
                <form action="FrontController" method="POST">
                    <div class="col-md-4">
                        <input type="hidden" name="section" value="client" />
                        <input type="hidden" name="action" value="manage" />
                        <label>Civilité:&nbsp;</label> ${client.civilite}<br>
                        <label>Nom:&nbsp;</label><input type="text" name="nom" value="${client.nom}" /><br>
                        <label>Prenom:&nbsp;</label><input type="text" name="prenom" value="${client.prenom}" /><br>
                        <label>Mail:&nbsp;</label><input type="text" name="mail" value="${client.email}" /><br>
                        <label>Mot de passe:&nbsp;</label><input type="password" name="motDePasse" /><br>
                        <label>Date de Naissance:&nbsp;</label><input type="date" name="dateNaissance" value="<fmt:formatDate value="${client.dateNaissance}" pattern="yyyy-MM-dd" />" placeholder="JJ/MM/AAAA" pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d" title="JJ/MM/AAAA"/><br>
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

            <label>Adresse de Facturation = Livraison</label><input type="checkbox" name="manage" value="ON" checked="checked" />

            <div class="row">
                <%--ADRESSE DE FACTURATION --%>
                <div class="col-sm-7 col-md-5">
                    <div class="thumbnail">
                        <div class="caption">
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="action" value="manage" />
                                <h1>Adresse Facturation:&nbsp;</h1>
                                <label>Prenom:&nbsp;</label><input type="text" name="prenom" value="${client.coordonneesFacturation.prenom}"/><br>
                                <label>Nom:&nbsp;</label><input type="text" name="nom" value="${client.coordonneesFacturation.nom}"/><br>
                                <label>Entreprise:&nbsp;</label><input type="text" name="entreprise" value="${client.coordonneesFacturation.entreprise}"/><br>
                                <label>N°:&nbsp;</label><input type="text" name="numeroVoie" value="${client.coordonneesFacturation.numeroVoie}"/><br>
                                <label>Type de voie:&nbsp;</label><input type="text" name="typeVoie" value="${client.coordonneesFacturation.typeVoie}"/><br>
                                <label>Nom de la voie:&nbsp;</label><input type="text" name="nomVoie" value="${client.coordonneesFacturation.nomVoie}"/><br>
                                <label>Telephone:&nbsp;</label><input type="text" name="telephone" value="${client.coordonneesFacturation.telephone}"/><br>
                                <label>Telephone Mobile:&nbsp;</label><input type="text" name="telephoneMobile" value="${client.coordonneesFacturation.telephoneMobile}"/><br>
                            </form> 
                            <br>
                        </div>
                    </div><button type="button" >Ajouter une nouvelle adresse</button>
                </div>

                <div class="col-sm-7 col-md-5">
                    <div class="thumbnail">
                        <div class="caption">
                            <h1>Adresse Livraison:&nbsp;</h1>
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="action" value="manage" />
                                <select name="adLivraison">
                                    <c:forEach var="i" items="${client.listeCoordonneesLivraison}">
                                        <option>
                                            ${i.nom}
                                            ${i.prenom}
                                            ${i.entreprise}
                                            ${i.numeroVoie}
                                            ${i.nomVoie}
                                            ${i.telephone}
                                            ${i.telephoneMobile}
                                        </option>
                                    </c:forEach>
                                </select>
                                <label>Prenom:&nbsp;</label><input type="text" name="prenom" value="${i.prenom}"/><br>
                                <label>Nom:&nbsp;</label><input type="text" name="nom" value="${i.nom}"/><br>
                                <label>Entreprise:&nbsp;</label><input type="text" name="entreprise" value="${i.entreprise}"/><br>
                                <label>N°:&nbsp;</label><input type="text" name="numeroVoie" value="${i.numeroVoie}"/><br>
                                <label>Type de voie:&nbsp;</label><input type="text" name="typeVoie" value="${i.typeVoie}"/><br>
                                <label>Nom de la voie:&nbsp;</label><input type="text" name="nomVoie" value="${i.nomVoie}"/><br>
                                <label>Telephone:&nbsp;</label><input type="text" name="telephone" value="${i.telephone}"/><br>
                                <label>Telephone Mobile:&nbsp;</label><input type="text" name="telephoneMobile" value="${i.telephoneMobile}"/><br>
                            </form> 
                        </div>
                    </div>
                </div>
            </div>        
        </div>        <c:url var="urlBootStrapJS" value="/bootstrap/js/bootstrap.js" />
        <script src="${urlBootStrapJS}"></script>
        <c:url var="scriptUrl" value="/javascript/script.js" />
        <script src="${scriptUrl}" type="text/javascript"></script>
    </body>
</html>




v