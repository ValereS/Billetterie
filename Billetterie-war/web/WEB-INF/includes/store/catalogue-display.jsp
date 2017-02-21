<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

Catalogue display!!!

<p>
    paramSearch = ${paramSearch}
</p>

<ul>
    <c:forEach var="show" items="${shows}">
        <li><img src="${show.image.url}" width="100px"/>${show.titre}</li>
    </c:forEach>
</ul>