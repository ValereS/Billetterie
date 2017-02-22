<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="navigation-main">
    <ul id="menu-main">
        <li>
            <c:url value="FrontController?section=data&action=create" var="url01" />
            <a href="${url01}">Krei la testo ludo</a> |
        </li>
        <li>
            <c:url value="FrontController?section=catalogue" var="url02" />
            <a href="${url02}">Katalogo</a> |
        </li>
        <li>
            <c:url value="FrontController?section=signup" var="url03" />
            <a href="${url03}">Registriĝu</a> |
        </li>
        <li>
            <c:if test="${empty client}">
            <c:url value="FrontController?section=login" var="url04" />
            <a href="${url04}">Konekti</a>
            </c:if>
            <c:if test="${not empty client}">
                <c:url value="FrontController?section=client" var="url05" />
                <a href="${url05}">Saluton, ${client.nomComplet} !</a>
                <c:url value="FrontController?section=client&action=logout" var="url06" />
                <a href="${url06}">Malkonekti</a>
            </c:if>
        </li>
    </ul>
</nav>
