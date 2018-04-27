<%-- 
    Document   : view.add.upd
    Created on : 16/04/2018, 10:07:03
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Clientes!</h1> <hr>
        
        <ul>
            <li>
                <a href="#aba-telefone">Telefone</a>
            </li>
        </ul>
        
        <form method="post">
            <input type="hidden" value="${obj.id}" name="id">
            <label>Nome</label>
            <input value="${obj.razaoSocial}" name="nome"><br>
            <label>Fantasia</label>
            <input value="${obj.nomeFantasia}" name="nome_fantasia"><br>
            <label>CPF/CNPJ</label>
            <input value="${obj.cpfCnpj}" name="cpf_cnpj"><br>
            <label>RG</label>
            <input value="${obj.rg}" name="rg_ie"><br>
            <label>Email</label>
            <input value="${obj.email}" name="email"><br>
            <label>Nascimento</label>
            <input value="${obj.nascimento}" name="data_nascimento"><br>
<%--            <label>Telefone</label>
            <input value="${obj.telefone}" name="id_telefone"><br>--%>
            <label>Observa&ccedil;&atilde;o</label>
            <input value="${obj.observacao}" name="observacao">
            <br><br>
            <button name="botao_salvar" value="salvar">Salvar</button>
            <button name="botao_salvar" value="cancelar">Cancelar</button>
        </form>
    </body>
</html>
