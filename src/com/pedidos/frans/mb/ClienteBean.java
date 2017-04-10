package com.pedidos.frans.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pedidos.frans.dao.ClienteDao;
import com.pedidos.frans.modelo.Cliente;;

@Named
@SessionScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;

	@Inject
	private ClienteDao clienteDao;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void grava() {
		if (this.cliente.getCodigoCliente() == null) {
			clienteDao.adiciona(cliente);
		} else {
			clienteDao.altera(cliente);
		}
		this.clientes = clienteDao.listar();
		limpaFormularioDoJSF();
	}

	public List<Cliente> getClientes() {
		if (this.clientes == null) {
			this.clientes = clienteDao.listar();
		}
		return this.clientes;
	}
	
	public void remove() {
		clienteDao.remove(this.cliente);
		this.clientes = clienteDao.listar();
		limpaFormularioDoJSF();
	}

	private void limpaFormularioDoJSF() {
		this.cliente = new Cliente();
	}

}
