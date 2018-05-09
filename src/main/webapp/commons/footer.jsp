<%--
    Document   : footer
    Created on : 02/05/2018, 10:30:10
    Author     : lucas
--%>

<c:if test="${css ne null}">
    <c:forEach var="css" items="${css}">
        <link rel="stylesheet" type="text/css" href="${css}"/>
    </c:forEach>
</c:if>
<c:if test="${js ne null}">
    <c:forEach var="js" items="${js}">
        <script src="${js}" type="text/javascript"/>
    </c:forEach>
</c:if>
</body>
</html>