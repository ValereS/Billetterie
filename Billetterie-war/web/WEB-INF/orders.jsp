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
    <title>Billetterie - Commandes</title>
</head>
<body>
    <jsp:include page="menus/menu-main.jsp" />

    <div class="container">
        <h2>Commandes</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Statut</th>
                    <th>Prix total TTC</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>
                        <fmt:formatDate value="${order.date}" pattern="EEEE d MMMM yyyy à HH 'h' mm" />
                    </td>
                    <td>
                        ${order.statut}
                    </td>
                    <td>
                        <fmt:formatNumber type="currency" currencySymbol="€" value="${order.totalPriceATI}" />
                    </td>
                    <td>
                        <c:url var="urlOrder" value="FrontController">
                            <c:param name="section" value="display-order" />
                            <c:param name="number" value="${order.numero}" />
                        </c:url>
                        <a href="${urlOrder}">
                            Détails
                        </a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

<c:url var="urlBootStrapJS" value="/bootstrap/js/bootstrap.js" />
<script src="${urlBootStrapJS}"></script>
<c:url var="scriptUrl" value="/javascript/script.js" />
<script src="${scriptUrl}" type="text/javascript"></script>
</body>
</html>
