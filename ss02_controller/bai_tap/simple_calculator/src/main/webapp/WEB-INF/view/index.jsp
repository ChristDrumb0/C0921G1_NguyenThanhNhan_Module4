<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form method="post" action="/calculate">
  <p>
    <input type="text" name="first" value="${first}">
    <input type="text" name="second" value="${second}">
  </p>
  <button type="submit" name="operator" value="+">Addition(+)</button>
  <button type="submit" name="operator" value="-">Subtraction(-)</button>
  <button type="submit" name="operator" value="*">Multiplication(*)</button>
  <button type="submit" name="operator" value="/">Division(/)</button>

  <c:if test="${result!=null}">
    <p>
        ${result}
    </p>
  </c:if>

</form>
</body>
</html>