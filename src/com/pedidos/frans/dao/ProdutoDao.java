package com.pedidos.frans.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pedidos.frans.modelo.Produtos;

@Stateless
public class ProdutoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;

	public void adiciona(Produtos produtos) {
		System.out.println("Metodo adiciona classe ProdutoDao");
		manager.joinTransaction();
		this.manager.persist(produtos);
	}

	public Produtos busca(Integer numeroControle) {
		System.out.println("Metodo busca classe ProdutoDao");
		manager.joinTransaction();
		return this.manager.find(Produtos.class, numeroControle);
	}

	public List<Produtos> listar() {
		System.out.println("Metodo listar classe ProdutoDao");
		manager.joinTransaction();
		return this.manager.createQuery("select p from Produtos p", Produtos.class).getResultList();
	}

	public void altera(Produtos produtos) {
		System.out.println("Metodo altera classe ProdutoDao");
		manager.joinTransaction();
		this.manager.merge(produtos);
	}

	public void remove(Produtos produtos) {
		System.out.println("Metodo remove classe ProdutoDao");
		manager.joinTransaction();
		Produtos produtosParaRemover = this.manager.find(Produtos.class, produtos.getNumeroControle());
		this.manager.remove(produtosParaRemover);
	}
}
