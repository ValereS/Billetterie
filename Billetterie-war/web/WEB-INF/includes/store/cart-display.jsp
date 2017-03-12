<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <th></th>
            </tr>
            <c:forEach var="orderLine" items="${orderLines}">
                <tr>
                    <td>${orderLine.quantiteBillets}</td>
                    <td>${orderLine.seance.spectacle.titre}</td>
                    <td><fmt:formatDate value="${orderLine.seance.date}" pattern="EEEE d MMMM yyyy à HH 'h' mm" /></td>
                    <td>${orderLine.categorie.nom}</td>
                    <td>${orderLine.nomTarif}</td>
                    <td>${orderLine.totalPriceATI}</td>
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
            <label>Total: ${totalPrice} &euro;</label>
        </div>
        <label>${message}</label>
        <div class="col-md-2">
            <button class="btn">Payer</button>
        </div>
    </div>
</div>
