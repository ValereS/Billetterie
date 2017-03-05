<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
                <img src="${seance.lieu.image.url}" width="250" height="250"/>  
                <a href="https://maps.google.fr/maps/place/${seance.lieu.coordonnees.adresse}" target="_blank">${seance.lieu.coordonnees.adresse} </a>
            </c:when>
            <c:otherwise>
                <a href="https://maps.google.fr/maps/place/${seance.lieu.coordonnees.adresse}" target="_blank">${seance.lieu.coordonnees.adresse} </a>
            </c:otherwise>
        </c:choose>
    </div>
    <br>
    <div class="row">  
        <div class="col-md-1"

             <br>
            <table style="background-color: #269abc" class="tableShowDisplayCat">
                <tr>
                    <td style="background-color: #2aabd2">
                        Catégorie
                    </td>
                </tr>
                <tr>
                    <td>
                        Tarif
                    </td>
                </tr>
                <tr>
                    <td>
                        Tarif
                    </td>
                </tr>
            </table>
        </div>
        <c:forEach var="cat" items="${categories}"> 
            <div class="col-md-1" >
                <table class="tableShowDisplayCat">
                    <tr>
                        <td style="background-color: #2aabd2" >
                            ${cat.nom}
                        </td>
                    </tr>
                    <c:forEach var="tarif" items="${cat.tarifs}">
                        <tr>
                            <td>
                                ${tarif.prix}
                            </td>
                        </tr>
                    </c:forEach>
                </table> 
            </div>
        </c:forEach>
    </div>

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


