package com.pedidos.frans.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroControle;

	private String nomeDoProduto;
	private BigDecimal valorUnitárioProduto;
	private int quantidadeDeProdutos;
	int nome;

	@ManyToOne
	private Cliente cliente;

	public Integer getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(Integer numeroControle) {
		this.numeroControle = numeroControle;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		if (nomeDoProduto == null || nomeDoProduto.equals("")) {
			nome = Integer.parseInt(nomeDoProduto);
			this.nomeDoProduto = nomeDoProduto;
		}
	}

	public int getQuantidadeDeProdutos() {
		return quantidadeDeProdutos += 1;
	}

	public void setQuantidadeDeProdutos(int quantidadeDeProdutos) {
		this.quantidadeDeProdutos = quantidadeDeProdutos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValorUnitárioProduto() {
		return valorUnitárioProduto;
	}

	public void setValorUnitárioProduto(BigDecimal valorUnitárioProduto) {
		this.valorUnitárioProduto = valorUnitárioProduto;
	}

}
