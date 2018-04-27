package com.cdi.produto.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdi.produto.model.Produto;
import com.cdi.produto.servico.ProdutoServico;
import com.cdi.utils.Formata;
import com.cdi.utils.ServletUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author lucas
 */
@WebServlet(name = "Produto", value = "/produto")
public class ProdutoController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ProdutoController.class.getName());
    private static final long serialVersionUID = 1L;

    @Inject
    private ProdutoServico service;
    @Inject
    private Produto produto;

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

    private void salvar(HttpServletRequest request, HttpServletResponse response) {
        String botao = request.getParameter("botao_acao");
        if ("cancelar".equals(botao)) {
            index(request, response);
            return;
        }

        try {
            if ("salvar".equals(botao)) {
                popular(produto, request);
                service.salvarProduto(produto);
                if ("salvar".equals(botao)) {
                    ServletUtil.redirect("/produto", request, response);
                }
            } else {
                int id = Formata.parseInt(request.getParameter("id"));
                produto = service.getProduto(id);
                request.setAttribute("obj", produto);
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, null, e);
        }
        ServletUtil.render("/produto/view.add.upd.jsp", request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) {
        List<Produto> list = service.listarProdutos();
        request.setAttribute("list", list);
        ServletUtil.render("/produto/view.index.jsp", request, response);
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Formata.parseInt(request.getParameter("id"));
            Produto p = service.getProduto(id);
            service.deletarProdutos(p);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, null, e);
        }
        ServletUtil.redirect("/produto", request, response);
    }

    private void popular(Produto p, HttpServletRequest request) {
        p.setId(Formata.parseInt(request.getParameter("id")));
        p.setName(StringUtils.trimToEmpty(request.getParameter("nome")));
    }
}
