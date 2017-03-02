<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
    div{
        border:#000 solid 1px;
    };
</style>
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
                ${show.sousTheme.theme.nom} ${show.sousTheme.nom}
                <br>
                ${show.description}
                <br>
                ${show.statut}
                <br>
            </p>
        </div>
    </div>
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
    <br>
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
        <input type="submit" name="doIt" value="OK" />
    </form>


        

    <%--
<a href="https://maps.google.fr/maps/place/${seance.lieu.coordonnees.adresse}" target="_blank">${seance.lieu.coordonnees.adresse} </a>
<img src="${seance.lieu.image.url}" width="250" height="250"/>   
    --%>
    <%--   
       <ul>
           <c:forEach var="categorie" items="${show.seance.categorie}" >
               <li>
                   ${categorie.nom}
               </li>
           </c:forEach>
       </ul>
    --%>
</div>


