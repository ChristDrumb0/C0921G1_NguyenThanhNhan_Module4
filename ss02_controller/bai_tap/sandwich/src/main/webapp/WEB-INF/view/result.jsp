<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>
    <c:if test="${results == null}">
        Sandwich with no condiment
    </c:if>

    <c:if test="${results != null}">
        Condiment include in Sandwich:
        <c:forEach var="condiment" items="${results}">
            ${condiment},
        </c:forEach>
    </c:if>
</h3>
</body>
</html>
