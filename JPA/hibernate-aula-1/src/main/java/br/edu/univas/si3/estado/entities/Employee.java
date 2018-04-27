package br.edu.univas.si3.estado.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FUNCIONARIO")
public class Employee implements Serializable {

	@Id
	@Column(name = "CODIGO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_gen")
	@SequenceGenerator(name = "funcionario_gen", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
	private int code;

	@Column(name = "NOME", nullable = false, length = 30)
	private String name;

	@Column(name = "ATIVO", nullable = false)
	private boolean active;

	@Temporal(TemporalType.DATE)
	@Column(name = "NASCIMENTO")
	private Date birth;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
