<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<p>
    ${show.id} 
    <br>
    ${show.titre}
    <br>
    ${show.sousTheme}
    <br>
    ${show.description}
    <br>
    ${show.statut}
    <br>
    <img src=${show.image.url} width="300" height="300"/>
</p>    

<ul>
    <c:forEach var="seance" items="${show.seances}" > 
    <li>
        ${seance}
    </li>
    </c:forEach>
</ul>    

