<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
    <div class="row">
        <table class="table table-bordered">
            <tr >
                <th>Qte</th>
                <th>Spectacle</th>
                <th>Séance</th>
                <th>Catégorie</th>
                <th>Tarif Nom</th>
                <th>Tarif</th>
                <th>Type de place</th>
                <th></th>
            </tr>
            <c:forEach var="orderLine" items="${orderLines}">
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
                    <td>
                        ${orderLine.typeBillet.description}
                        <c:if test="${orderLine.typeBillet.id == PLACE_NUMEROTE}">
                            <c:choose>
                                <c:when test="${orderLine.contiguous}">
                                    (places contiguës)
                                </c:when>
                                <c:otherwise>
                                    (places non contiguës)
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </td>
                    <c:url var="urlDelete" value="FrontController">
                        <c:param name="section" value="cart-operations" />
                        <c:param name="action" value="remove" />
                        <c:param name="categoryId" value="${orderLine.categorie.id}" />
                        <c:param name="rateName" value="${orderLine.nomTarif}" />
                    </c:url>
                    <td><a href='${urlDelete}'>X</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <div class="col-md-7"></div>
        <div class="col-md-3">
            <label>Total: <fmt:formatNumber type="currency" currencySymbol="€" value="${totalPrice}" /></label>
        </div>
        <label>${message}</label>
        <div class="col-md-2">
            <c:url var="urlPayer" value="FrontController">
                <c:param name="section" value="order" />
                <c:param name="action" value="checkOut" />
            </c:url>
            <form action="${urlPayer}">
                <button class="btn">Payer</button>
            </form>
        </div>
    </div>
</div>
