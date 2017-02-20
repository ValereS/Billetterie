<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="navigation-main">
    <ul id="menu-main">
        <li>
            <c:url value="FrontController?section=data&action=create" var="url01" />
            <a href="${url01}">Create test data</a> |
        </li>
        <li>
            <c:url value="FrontController?section=catalogue" var="url02" />
            <a href="${url02}">Catalogue</a> |
        </li>
    </ul>
</nav>
