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

/**
 *
 * @author lucas
 */
@WebServlet("/Produto")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoServico produtoServico;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Produto produto = new Produto();

		String nome = request.getParameter("nome");
		produto.setName(nome);

		produtoServico.inserirProduto(produto);

		request.getRequestDispatcher("ok.jsp").forward(request, response);
	}
}
