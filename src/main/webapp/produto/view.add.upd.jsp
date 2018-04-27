<%-- 
    Document   : view.add.upd
    Created on : 10/04/2018, 12:37:47
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
        <h1>Produto!</h1>
        <form method="post" >
            <input name="id" type="hidden" value="${obj.id}">
            <input name="nome" type="text" value="${obj.name}">
            
            <br>
            
            <button name="botao_acao" value="salvar">Salvar</button> &nbsp;&nbsp;&nbsp;&nbsp;
            <button name="botao_acao" value="cancelar">Cancelar</button>
        </form>
    </body>
</html>
