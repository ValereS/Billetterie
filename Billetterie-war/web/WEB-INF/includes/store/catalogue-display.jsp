<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
    <c:when test="${fn:length(shows) gt 0}">
        <div class="row">
            <div class="col-md-10"></div>
            <jsp:include page="pagination.jsp" />
        </div>
        <div class="row">
            <div class="col-md-1 col-sd-0"></div>
            <div class="col-md-10 col-sd-12">
                <ul class="list-group">
                    <c:forEach var="show" items="${shows}">
                        <li class="list-group-item" style="height:120px">
                            <c:url var="url" value="FrontController?section=show&id=${show.id}" />
                            <a href="${url}">
                                <div class="col-md-2 col-sd-3" style="text-align: center">
                                    <img src="${show.image.url}" height="100"  alt="${show.titre}" />
                                </div>
                                <div class="col-md-9 col-sd-8" >
                                    <h3>${show.titre}</h3>
                                    <p>${show.description}</p>
                                </div>
                                <div class="col-md-1 col-sd-1" >
                                    <button class="btn-default" style="height: 100px">Réserver</button>
                                </div>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10"></div>
            <jsp:include page="pagination.jsp" />
        </div>    </c:when>
    <c:otherwise>
        <p>No results</p>
    </c:otherwise>
</c:choose>

