<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${fn:length(pageNumbers) gt 1}">
    <span class="pagination">
        <c:forEach var="currentPageNumber" items="${pageNumbers}">
            <c:choose>
                <c:when test="${currentPageNumber != pageNumber}">
                    <c:url var="url" value="FrontController">
                        <c:param name="section" value="catalogue" />
                        <c:param name="pageNumber" value="${currentPageNumber}" />
                        <c:param name="maxResults" value="${maxResults}" />
                        <c:param name="paramSearch" value="${paramSearch}" />
                        <c:param name="paramThemeNom" value="${paramThemeNom}" />
                        <c:param name="paramSubThemeNom" value="${paramSubThemeNom}" />
                    </c:url>
                    <a href="${url}">${currentPageNumber}</a>
                </c:when>
                <c:otherwise>
                    <strong>${currentPageNumber}</strong>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </span>
</c:if>
