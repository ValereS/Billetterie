<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/bootstrap/css/bootstrap.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Billetterie - Commande</title>
    </head>
    <body>
        <jsp:include page="menus/menu-main.jsp" />

        <div class="container">
            <h2>Commande du <fmt:formatDate value="${order.date}" pattern="EEEE d MMMM yyyy à HH 'h' mm" /></h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Quantité</th>
                        <th>Spectacle</th>
                        <th>Séance</th>
                        <th>Catégorie</th>
                        <th>Tarif</th>
                        <th>Prix</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="orderLine" items="${order.lignesCommande}">
                        <tr>
                            <td>${orderLine.quantiteBillets}</td>
                            <td>${orderLine.seance.spectacle.titre}</td>
                            <td>
                                <c:url var="urlSeance" value="FrontController">
                                    <c:param name="section" value="show" />
                                    <c:param name="id" value="${orderLine.seance.spectacle.id}" />
                                    <c:param name="seanceId" value="${orderLine.seance.id}" />
                                </c:url>
                                <a href="${urlSeance}">
                                    <fmt:formatDate value="${orderLine.seance.date}" pattern="EEEE d MMMM yyyy à HH 'h' mm" />
                                </a>
                            </td>
                            <td>${orderLine.categorie.nom}</td>
                            <td>${orderLine.nomTarif}</td>
                            <td>
                                <fmt:formatNumber type="currency" currencySymbol="€" value="${orderLine.totalPriceATI}" />
                            </td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <th colspan="5">
                                Mode d’expédition
                            </th>
                            <td>
                                ${order.modeExpedition.nom}
                            </td>
                        </tr>
                        <tr>
                            <th colspan="5">
                                Frais de port
                            </th>
                            <td>
                                <fmt:formatNumber type="currency" currencySymbol="€" value="${order.frais}" />
                            </td>
                        </tr>
                        <tr>
                            <th colspan="5">
                                Total TTC
                            </th>
                            <td>
                                <fmt:formatNumber type="currency" currencySymbol="€" value="${order.totalPriceATI}" />
                            </td>
                        </tr>
                </tbody>
            </table>
        </div>

        <c:url var="urlBootStrapJS" value="/bootstrap/js/bootstrap.js" />
        <script src="${urlBootStrapJS}"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <c:url var="scriptUrl" value="/javascript/script.js" />
        <script src="${scriptUrl}" type="text/javascript"></script>
    </body>
</html>
