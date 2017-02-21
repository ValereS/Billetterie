<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <title>Billet Ti - Catalogue</title>
    </head>
    <body>
        <c:url value="ControleurMain?section=navigation" var="urul02" />
        <c:import url="${urul02}" />
        <c:url value="ControleurMain?section=search" var="url03" />
        <c:import url="${url03}" />
        <hr />
        <div>
            <c:url value="ControleurMain?section=catalogue-display" var="url04" />
            <c:import url="${url04}" />
        </div>
    </body>
</html>
