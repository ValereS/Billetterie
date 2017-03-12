<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
            <select name="seanceId" id="seanceId" onchange="updateShowingDisplay(); return false;">
                <c:forEach var="s" items="${show.seances}" >
                    <c:choose>
                        <c:when test="${seanceId == s.id}">
                            <option selected value="${s.id}">${s.date}-${s.lieu.nom}-${s.lieu.salle}-${s.lieu.description}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${s.id}">${s.date}-${s.lieu.nom}-${s.lieu.salle}-${s.lieu.description}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <input type="submit" value="OK" >
        </form>
    </div>
    <br>

    <div id="showing-display">
        <c:if test="${not empty seanceId}">
            <c:url var="showingUrl" value="FrontController">
                <c:param name="section" value="showing-display" />
                <c:param name="seanceId" value="${seanceId}" />
            </c:url>
            <c:import url="${showingUrl}" />
        </c:if>
    </div>

</div>
