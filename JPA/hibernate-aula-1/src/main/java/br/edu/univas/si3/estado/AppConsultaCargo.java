package br.edu.univas.si3.estado;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.univas.si3.estado.entities.Employee;
import br.edu.univas.si3.estado.entities.Position;
import br.edu.univas.si3.util.HibernateUtil;

public class AppConsultaCargo {
	
	public static void main(String[] args) {
		
		EntityManager em = HibernateUtil.getEntityManager();

		//consulta pela chave primária
		//LAZY - busca apenas o cargo
		//EAGER - busca o cargo e os funcionários
		//verificar o select que é executado no banco
		Position cargo = em.find(Position.class, 4);
		
		System.out.println("Cargo: " + cargo.getName());

		//LAZY - busca apenas os funcionários
		//EAGER - não faz nada, pois o find já buscou tudo
		//verificar o select que é executado no banco
		List<Employee> empregados = cargo.getEmployees();

		for (Employee employee : empregados) {
			System.out.println("Empregado: " + employee.getName());
		}
		
		//Exercício:
		//Fazer uma consulta de um funcionário e obter o seu cargo.
		//Testar com LAZY e EAGER e verificar as consultas executadas para cada caso.
		
		
	}
}