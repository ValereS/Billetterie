<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:choose>
    <c:when test="${seance.lieu.image.url != null}">
        <div class="col-md-4">
            <img src="${seance.lieu.image.url}" width="250" height="250"/> 
        </div>
        <a href="https://maps.google.fr/maps/place/${seance.lieu.coordonnees.adresse}" target="_blank">${seance.lieu.coordonnees.adresse} </a>
    </c:when>
    <c:otherwise>
        <a href="https://maps.google.fr/maps/place/${seance.lieu.coordonnees.adresse}" target="_blank">${seance.lieu.coordonnees.adresse} </a>
    </c:otherwise>
</c:choose>

<form action="FrontController" method="GET">
    <div class="row">
        <div class="col-md-12">
            <input type="hidden" name="section" value="cart-operations" />
            <input type="hidden" name="action" value="add" />
            <input type="hidden" name="showingId" value="${seance.id}" />
            <table class="table tableShowDisplayCat">
                <thead>
                    <tr>
                        <th style="background-color: #ffffff">

                        </th>

                <c:forEach var="categorie" items="${categories}">
                    <th>
                        ${categorie.nom}
                    </th>
                </c:forEach>

                </tr>
                </thead>
                <tbody>

                <c:forEach var="tarifNom" items="${tarifNoms}">
                    <tr>
                        <th style="width: 20%">
                            ${tarifNom}
                        </th>

                    <c:forEach var="categorie" items="${categories}">
                        <td>
                        <c:if test="${not empty mapTarifs[categorie][tarifNom]}">
                            <fmt:formatNumber type="currency" currencySymbol="€" value="${mapTarifs[categorie][tarifNom].prix}" />

                            <br/>
                            <select name="choixBillets,${categorie.id},${mapTarifs[categorie][tarifNom].id}" style="">
                                <c:forEach var="i" items="${nombreBillets}" end="${fn:length(categorie.billets)}" >
                                    <option>${i}</option>
                                </c:forEach>

                            </select>
                        </c:if>
                        </td>
                    </c:forEach>

                    </tr>
                </c:forEach>


                </tbody>
            </table>
            <input type="submit" value="Ajouter au panier" />
        </div>
    </div>
</form>