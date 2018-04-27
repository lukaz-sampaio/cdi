package com.cdi.cliente.controller;

import com.cdi.cliente.model.Cliente;
import com.cdi.utils.Formata;
import com.cdi.utils.ServletUtil;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author lucas
 */
@WebServlet(name = "ClienteController", urlPatterns = "/cliente")
public class ClienteController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ClienteController.class.getName());

    @Inject
    private ClienteService service;
//    @Inject
//    private Cliente cliente;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if ("salvar".equals(acao)) {
            salvar(request, response);
        } else if ("deletar".equals(acao)) {
            deletar(request, response);
        } else {
            index(request, response);
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) {
        List<Cliente> list = service.list();
        for(Cliente c : list){
            System.out.println("id: " + c.getId());
            System.out.println("nome: " + c.getRazaoSocial());
            System.out.println("fantasia: " + c.getNomeFantasia());
        }
        request.setAttribute("list", list);
        ServletUtil.render("/cliente/view.index.jsp", request, response);
    }

    private void salvar(HttpServletRequest request, HttpServletResponse response) {
        String botao = request.getParameter("botao_salvar");
        if ("cancelar".equals(botao)) {
            ServletUtil.redirect("/cliente", request, response);
        }
        Cliente cliente;
        try {
            if ("salvar".equals(botao)) {
                cliente = new Cliente();
                popular(request, cliente);
                service.salvar(cliente);
                if ("salvar".equals(botao)) {
                    ServletUtil.redirect("/cliente", request, response);
                }
            } else {
                int id = Formata.parseInt(request.getParameter("id"));
                cliente = service.getCliente(id);
                request.setAttribute("obj", cliente);
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, null, e);
        }

        ServletUtil.render("/cliente/view.add.upd.jsp", request, response);
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Formata.parseInt(request.getParameter("id"));
            Cliente cliente = service.getCliente(id);
            service.deletar(cliente);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, null, e);
        }
        ServletUtil.redirect("/cliente", request, response);
    }

    public void popular(HttpServletRequest request, Cliente c) {
        c.setId(Formata.parseInt(request.getParameter("id")));
        c.setRazaoSocial(StringUtils.trimToEmpty(request.getParameter("nome")));
        c.setNomeFantasia(StringUtils.trimToEmpty(request.getParameter("nome_fantasia")));

        c.setCpfCnpj(Formata.parseLong(request.getParameter("cpf_cnpj")));
        c.setEmail(StringUtils.trimToEmpty(request.getParameter("email")));
        c.setRg(Formata.parseLong(request.getParameter("rg_ie")));
        c.setNascimento(Formata.parseDate(request.getParameter("data_nascimento"), "dd/MM/yyyy"));
        c.setObservacao(StringUtils.trimToEmpty(request.getParameter("observacao")));
        // c.setTelefone(telefone);
        // c.setDataCadastro(new DateTime);
    }
}
