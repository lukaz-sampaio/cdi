<%-- 
    Document   : view.index
    Created on : 10/04/2018, 10:54:27
    Author     : lucas
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
        <h1>Lista de produtos!</h1> <hr>
        
        <a href="${pageContext.request.contextPath}/produto?acao=salvar">Novo</a>
        
        <table>
            <tr>
                <td>#Id</td>
                <td>Nome</td>
                <td>A&ccedil;&otilde;es</td>
            </tr>
            <c:forEach var="obj" items="${list}">
                <tr>
                    <td>${obj.id}</td>
                    <td>${obj.razaoSocial}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/produto?acao=salvar&id=${obj.id}">EDITAR</a>
                        <a href="${pageContext.request.contextPath}/produto?acao=deletar&id=${obj.id}">DELETAR</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
