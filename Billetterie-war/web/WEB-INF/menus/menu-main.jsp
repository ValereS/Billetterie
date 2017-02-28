<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="navigation-main">
    <div>
        <ul id="menu-main">
            <li>
                <c:url value="FrontController?section=data&action=create" var="url01" />
                <a href="${url01}" style='text-decoration:none;color:graytext'>Créer le jeu d’essais</a>
            </li>|
            <li>
                <c:url value="FrontController?section=query" var="urlQuery" />
                <a href="${urlQuery}" style='text-decoration:none;color:graytext'>Exécuter des requêtes</a>
            </li>|
            <li>
                <c:url value="FrontController?section=home" var="urlHome" />
                <a href="${urlHome}">Accueil</a>
            </li>|
            <li>
                <c:url value="FrontController?section=catalogue" var="url02" />
                <a href="${url02}">Catalogue</a>
            </li>|
            <li>
                <c:url value="FrontController?section=signup" var="url03" />
                <a href="${url03}">S'inscrire</a>
            </li>|
            <li>
                <c:if test="${empty client}">
                    <c:url value="FrontController?section=login" var="url04" />
                    <a href="${url04}">Connexion</a>
                </c:if>
                <c:if test="${not empty client}">
                    <c:url value="FrontController?section=client&action=manage" var="url05" />
                    <a href="${url05}">Bonjour, ${client.nomComplet} !</a>
                    <c:url value="FrontController?section=client&action=logout" var="url06" />
                    <a href="${url06}">Déconnexion</a>
                </c:if>
            </li>
        </ul>
    </div>
    <div>
        <ul class="tier_theme">
            <c:forEach var="theme" items="${themes}">
                <li>
                    <a href="FrontController?section=catalogue&paramThemeNom=${theme.nom}" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">
                        ${theme.nom}
                        <span class="caret"></span>
                        <ul class="tier_subtheme">
                            <c:forEach items="${theme.sousThemes}" var="sousTheme">
                                <li><a href="FrontController?section=catalogue&paramSubThemeNom=${sousTheme.nom}">${sousTheme.nom}</a></li>
                                </c:forEach>
                        </ul>
                </li>
            </c:forEach>
        </ul>
    </div>
</nav>
