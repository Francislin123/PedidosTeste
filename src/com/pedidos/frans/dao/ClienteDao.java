package com.pedidos.frans.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pedidos.frans.modelo.Cliente;

@Stateless
public class ClienteDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager manager;
	
	public void adiciona(Cliente cliente) {
		manager.joinTransaction();
		this.manager.persist(cliente);
	}

	public Cliente busca(Integer codigoCliente) {
		manager.joinTransaction();
		return this.manager.find(Cliente.class, codigoCliente);
	}

	public List<Cliente> listar() {
		manager.joinTransaction();
		return this.manager.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}

	public void altera(Cliente cliente) {
		manager.joinTransaction();
		this.manager.merge(cliente);
	}

	public void remove(Cliente cliente) {
		manager.joinTransaction();
		Cliente clienteParaRemover = this.manager.find(Cliente.class, cliente.getCodigoCliente());
		this.manager.remove(clienteParaRemover);
	}
	
	public Cliente procura(Integer codigoCliente) {
		manager.joinTransaction();
		return this.manager.find(Cliente.class, codigoCliente);
	}
}
