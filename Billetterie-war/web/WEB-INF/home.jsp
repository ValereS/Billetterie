<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/bootstrap/css/bootstrap.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Billetterie - Accueil</title>
    </head>
    <body>
        <jsp:include page="menus/menu-main.jsp" />
        <div>
            <p>
                ${message}
            </p>


            <h2>Meilleures ventes</h2>
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


        </div>

        <c:url var="urlBootStrapJS" value="/bootstrap/js/bootstrap.js" />
        <script src="${urlBootStrapJS}"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <c:url var="scriptUrl" value="/javascript/script.js" />
        <script src="${scriptUrl}" type="text/javascript"></script>
    </body>
</html>
