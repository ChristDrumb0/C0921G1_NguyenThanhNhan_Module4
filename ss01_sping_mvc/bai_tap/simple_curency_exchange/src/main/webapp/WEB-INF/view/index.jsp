<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form action="/curency" method="post">

  <p>Enter USD</p>
  <input type="text" name="usd" value="${usd}">

  <p>Enter the exchange rates</p>
  <input type="text" name="rate" value="${rate}">

  <input type="submit" value="convert">


  <c:if  test="${vnd != null}">
    <p>Exchange to VND is: ${vnd} </p>

  </c:if>

</form>
</body>
</html>