<%-- 
    Document   : listar
    Created on : 11/04/2016, 21:03:01
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listar Anuncios</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descricão</th>
                    <th>Preço</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${anuncios}" var="anuncio">
                <tr>
                    <td>${anuncio.id}</td>
                    <td>${anuncio.nome}</td>
                    <td>${anuncio.descricao}</td>
                    <td>${anuncio.preco}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
