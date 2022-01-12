<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form action="/sandwich" method="post">

  <p>Sanwich Condiments</p>

  <input type="checkbox" id="condiment1" name="condiment" value="Lettuce">
  <label for="condiment1">Lettuce</label><br>

  <input type="checkbox" id="condiment2" name="condiment" value="Tomato">
  <label for="condiment2"> Tomato</label><br>

  <input type="checkbox" id="condiment3" name="condiment" value="Mustard">
  <label for="condiment3"> Mustard</label><br>

  <input type="checkbox" id="condiment4" name="condiment" value="Sprouts">
  <label for="condiment4"> Sprouts</label><br>

  <input type="submit" value="Save">

  <c:if test="${empty save}">
    <p>${message}</p>
  </c:if>
</form>
</body>
</html>