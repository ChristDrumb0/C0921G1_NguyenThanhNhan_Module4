<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Choose Condiment </title>
</head>
<body>
<c:if test="${message!=null}">
  <h4 style="color: red">${message}</h4>
</c:if>
<h3>Setting</h3>
<table >
  <tr>
    <td>Language</td>
    <td>${emailSetting.language}</td>
  </tr>
  <tr>
    <td>Page Size</td>
    <td>${emailSetting.pageSize}</td>
  </tr>
  <tr>
    <td>Spam filter</td>
    <td>
      <c:if test="${emailSetting.spamFilter==true}">Enable spam filter</c:if>
      <c:if test="${emailSetting.spamFilter==false}">Unable spam filter</c:if>
    </td>
  </tr>
  <tr>
    <td>Signature</td>
    <td>${emailSetting.signature}</td>
  </tr>
  <tr>
    <td colspan="2" style="padding-left: 30px">
      <button><a href="/update">Update</a></button>
    </td>
  </tr>
</table>

</body>
</html>