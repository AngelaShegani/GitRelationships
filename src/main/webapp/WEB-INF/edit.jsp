<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Nft Art</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h2>Edit Art</h2>
<div class="container">
<%--@elvariable id="editArt" type="java"--%>
    <form:form action="/update/${editArt.id}" method="put" modelAttribute="editArt">
        <p class="form-group">
            <form:label path="title">Title</form:label>
            <form:input path="title" class="form-control"></form:input>
            <form:errors path="title" class="text-danger"></form:errors>
        </p>
        <p class="form-group">
            <form:label path="description">Title</form:label>
            <form:input path="description" class="form-control"></form:input>
            <form:errors path="description" class="text-danger"></form:errors>
        </p>
        <button class="btn btn-primary">Edit</button>

    </form:form>
</div>
</body>
</html>