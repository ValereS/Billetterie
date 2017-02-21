<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="FrontController" var="url150" />
<form action="${url150}" method="GET" accept-charset="UTF-8" id="search">
    <label>spektaklo</label>
    <input type="hidden" name="section" value="catalogue" />
    <input type="text" name="paramSearch" value="${paramSearch}" />
    <input type="submit" value="Search" />        
</form>