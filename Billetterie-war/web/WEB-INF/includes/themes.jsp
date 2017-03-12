<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
    <ul class="tier_theme">
        <c:forEach var="theme" items="${themes}">
            <li>
            <c:url var="urlTheme" value="FrontController">
                <c:param name="section" value="catalogue"/>
                <c:param name="paramThemeNom" value="${theme.nom}"/>
            </c:url>
            <a href="${urlTheme}" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">
                ${theme.nom}
                <span class="caret"></span>
            </a>
            <ul class="tier_subtheme">
                <c:forEach items="${theme.sousThemes}" var="sousTheme">
                    <c:url var="urlSubTheme" value="FrontController?section=catalogue&paramSubThemeNom=${sousTheme.nom}" />
                    <li><a href="${urlSubTheme}">${sousTheme.nom}</a></li>
                </c:forEach>
            </ul>
            </li>
        </c:forEach>
    </ul>
</div>
