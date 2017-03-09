<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container" >
    <div class="row" >
        <h1>${show.titre}</h1>
    </div>
    <div class="row" >
        <div class="col-md-4" >
            <img src="${show.image.url}" width="250" height="250"/>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-4">
            <p>
                <br>
                Thème : ${show.sousTheme.theme.nom} : ${show.sousTheme.nom}
                <br>
                Description : ${show.description}
                <br>
            </p>
            <ul>
                <c:forEach var="groupe" items="${show.groupes}">   
                    <li>
                        ${groupe.nom}
                    </li>
                    <%-- <ul>
                        <c:forEach var="fonction" items=""
                    </ul>
                    --%>
                </c:forEach>

            </ul>  
        </div>
    </div>

    <br>
    <div class="row">   
        <form action="FrontController" method="GET">
            <input type="hidden" name="section" value="show" />
            <input type="hidden" name="id" value="${show.id}" />
            <select name="seanceId">
                <c:forEach var="seance" items="${show.seances}" >
                    <c:choose>
                        <c:when test="${seanceId == seance.id}">
                            <option selected value="${seance.id}">${seance.date}-${seance.lieu.nom}-${seance.lieu.salle}-${seance.lieu.description}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${seance.id}">${seance.date}-${seance.lieu.nom}-${seance.lieu.salle}-${seance.lieu.description}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <input type="submit" name="doIt" value="OK" >
        </form>

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
    </div>
    <br>

    <div class="row">
        <div class="col-md-12">
    <c:if test="${not empty seance}">
        <table class="table tableShowDisplayCat" >
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
                                    <select name="choixBillets,${categorie.nom},${tarifNom}" style="">
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
                    
        </div>
    </div>
    </c:if>



</div>


