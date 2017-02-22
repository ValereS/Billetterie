<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<ul>
    <c:forEach var="show" items="${shows}">
        <li>
            <c:url var="url" value="FrontController?section=show&id=${show.id}" />
            <a href="${url}">
                <img src="${show.image.url}" width="100" alt="${show.titre}" />
                ${show.titre}
            </a>
        </li>
    </c:forEach>
</ul>