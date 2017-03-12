<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="jumbotron"><h1>Billetterie</h1>
    <c:url value="FrontController?section=navigation" var="url02" />
    <c:import url="${url02}" />|
    <c:url value="FrontController?section=cart-header" var="urlCart" />
    <c:import url="${urlCart}" />    
    <c:url value="FrontController?section=search" var="url03" />
    <c:import url="${url03}" />
    <c:url value="FrontController?section=themes" var="urlThemes" />
    <c:import url="${urlThemes}" />
</div>
