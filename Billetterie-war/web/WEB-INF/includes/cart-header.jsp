<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="urlPanier" value="FrontController">
    <c:param name="section" value="cart" />
</c:url>
<a href="${urlPanier}">Panier - <fmt:formatNumber type="currency" currencySymbol="€" value="${totalPrice}" /></a>