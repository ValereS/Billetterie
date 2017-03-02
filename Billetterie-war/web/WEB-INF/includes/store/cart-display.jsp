<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>mon panier</p>
<c:forEach var="orderLine" items="${orderLines}">
    ${orderLine.quantiteBillets}
</c:forEach>

