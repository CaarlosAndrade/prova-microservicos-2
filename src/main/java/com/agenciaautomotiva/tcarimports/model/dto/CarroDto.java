package com.agenciaautomotiva.tcarimports.model.dto;

import javax.validation.constraints.NotBlank;

public class CarroDto {
	
	@NotBlank
	private String descricao;

	@NotBlank
	private String marca;

	@NotBlank
	private String modelo;

	@NotBlank
	private String ano;

	@NotBlank
	private String cor;

	private int quilometragem;

	private int portas;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}
}
