package model.entities;

import java.io.Serializable;

public class Operacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String simbolo;

	public Operacao(String simbolo) {
		super();
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {
		return simbolo;
	}
	
}
