package br.edu.univas.si3.estado;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import br.edu.univas.si3.estado.entities.Employee;
import br.edu.univas.si3.estado.entities.Position;
import br.edu.univas.si3.util.HibernateUtil;

public class AppFuncionario {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		EntityManager em = HibernateUtil.getEntityManager();

		// instancia os objetos
		Position posGerente = new Position();
		posGerente.setName("Gerente");

		Employee e1 = new Employee();
		e1.setName("João");
		e1.setActive(false);
		e1.setBirth(new Date());

		ArrayList<Employee> empregados = new ArrayList<Employee>();
		empregados.add(e1);
		
		posGerente.setEmployees(empregados);

		// persiste os funcionários
		em.getTransaction().begin();
		em.persist(posGerente);
		em.getTransaction().commit();
	}
}