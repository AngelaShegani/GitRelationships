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
    <h1>Discover NFT Arts</h1>
    <a href="/new">Add new NFT Art</a>
    <table class="table table-dark">
        <thead>
        <tr>
            <th  scope="col">Title</th>
            <th  scope="col">Description</th>
            <th  scope="col">Owner</th>
            <th  scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allArts}" var="art">
            <tr>
                <td> <a href="/artDetail/${art.id}">${art.title}</a> </td>
                <td> <c:out value="${art.description}"></c:out></td>
                <td>${art.owner.firstName}</td>
                <td> <a href="/edit/${art.id}">Edit</a>
                    <form:form action="/delete/${art.id}" method="delete">
                        <button>Delete</button>
                    </form:form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>