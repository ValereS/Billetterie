<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row">
    <div class="col-md-10"></div>
    <jsp:include page="pagination.jsp" />
</div>
<ul class="list-group">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <c:forEach var="show" items="${shows}">
                <li class="list-group-item" style="height:120px">
                    <c:url var="url" value="FrontController?section=show&id=${show.id}" />
                    <a href="${url}">
                        <div class="col-md-2" style="text-align: center">
                            <img src="${show.image.url}" height="100"  alt="${show.titre}" />
                        </div>
                        <div class="col-md-9" >
                            <h3>${show.titre}</h3>
                            <p>${show.description}</p>
                        </div>
                        <div class="col-md-1" >
                        <button class="btn-default" style="height: 100px">Réserver</button>
                        </div>
                    </a>

                </li>
                <br/>
            </c:forEach>
        </div>
    </div>
</ul>
<div class="row">
    <div class="col-md-10"></div>
    <jsp:include page="pagination.jsp" />
</div>