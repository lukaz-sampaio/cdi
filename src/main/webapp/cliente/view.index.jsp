<%--
    Document   : view.index
    Created on : 16/04/2018, 09:46:27
    Author     : lucas
--%>

<%@include file="../commons/header.jsp" %>
<h1>Clientes!</h1> <hr>
<a href="${pageContext.request.contextPath}/cliente?acao=salvar">Novo</a>
<table>
    <tr>
        <td>Id</td>
        <td>Nome</td>
        <td>Fantasia</td>
        <td>A&ccedil;&otilde;es</td>
    </tr>
    <c:forEach var="obj" items="${list}">
        <tr>
            <td>${obj.id}</td>
            <td>${obj.razaoSocial}</td>
            <td>${obj.nomeFantasia}</td>
            <td>
                <a href="${pageContext.request.contextPath}/cliente?acao=salvar&id=${obj.id}">Editar</a>
                <a href="${pageContext.request.contextPath}/cliente?acao=deletar&id=${obj.id}">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../commons/footer.jsp"%>