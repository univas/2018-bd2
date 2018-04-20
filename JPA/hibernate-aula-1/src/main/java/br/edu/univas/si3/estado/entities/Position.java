package br.edu.univas.si3.estado.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARGO")
public class Position implements Serializable {

	@Id
	@Column(name="CODIGO", nullable = false)
	private int code;
	
	@Column(name="NOME", nullable = false, length = 20)
	private String name;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
