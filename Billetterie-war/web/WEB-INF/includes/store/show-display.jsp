<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<p>
    ${show.id} 
    <br>
    ${show.titre}
    <br>
    ${show.sousTheme.theme.nom} ${show.sousTheme.nom}
    <br>
    ${show.description}
    <br>
    ${show.statut}
    <br> 
    <img src="${show.image.url}" width="250" height="250"/>
</p>    

<ul>
    <c:forEach var="seance" items="${show.seances}" > 
        <li>
            ${seance.statut} ${seance.date}
            <ul>
                <li>
                    ${seance.lieu.nom}
                </li>
                <li>
                    ${seance.lieu.salle}
                </li>
                <li>
                    ${seance.lieu.description}
                </li>
                <li>
                    <a href="https://maps.google.fr/maps/place/${seance.lieu.coordonnees.adresse}" target="_blank">${seance.lieu.coordonnees.adresse}</a>
                    <!-- valérian grosse merde -->
                </li>
            </ul>
        </li>
    </c:forEach>
</ul>    



