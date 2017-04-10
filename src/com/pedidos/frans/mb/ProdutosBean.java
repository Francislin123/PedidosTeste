package com.pedidos.frans.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pedidos.frans.dao.ClienteDao;
import com.pedidos.frans.dao.ProdutoDao;
import com.pedidos.frans.modelo.Cliente;
import com.pedidos.frans.modelo.Produtos;

@Named
@SessionScoped
public class ProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Produtos> produtos;
	private Produtos produto = new Produtos();
	private Integer codigoCliente;

	@Inject
	private ClienteDao clienteDao;
	@Inject
	private ProdutoDao produtosDao;

	public void grava() {
		Cliente clienteRelacionado = clienteDao.busca(codigoCliente);
		produto.setCliente(clienteRelacionado);
		produtosDao.adiciona(produto);
		this.produtos = produtosDao.listar();
		limpaFormularioDoJSF();
	}

	public void remove() {
		produtosDao.remove(this.produto);
		this.produtos = produtosDao.listar();
		limpaFormularioDoJSF();
	}

	public List<Produtos> getProdutos() {
		if (this.produtos == null) {
			this.produtos = produtosDao.listar();
		}
		return this.produtos;
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento manager que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.produto = new Produtos();
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

}
