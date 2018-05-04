package br.edu.univas.si3.estado.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARGO")
public class Position implements Serializable {

	@Id
	@Column(name = "CODIGO", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;

	@Column(name = "NOME", nullable = false, length = 20)
	private String name;
	
	//relacionamento com os funcionários
	@OneToMany(fetch=FetchType.EAGER, mappedBy="position")
	private List<Employee> employees;

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
