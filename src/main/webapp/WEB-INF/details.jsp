<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Nft Art</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<a href="/">Dashboard</a>
<h2>Title: ${art.title}</h2>
<h2>Description: ${art.description}</h2>
<h2>Assigned Designers</h2>
<c:forEach items="${art.designers}" var="designer">
  <p>
    <c:out value="${designer.name}"></c:out>x
    Name: ${designer.speciality}
  </p>
</c:forEach>




<h2>Assign new Designers</h2>
<form:form action="/assign/${art.id}" method="post">
  <select name="designerId" id="designerId">
    <c:forEach var="designer" items="${allDesigners}">
      <option value="${designer.id}">${designer.name}</option>
    </c:forEach>
  </select>

  <button>Assign Designer</button>

</form:form>
</body>
</html>