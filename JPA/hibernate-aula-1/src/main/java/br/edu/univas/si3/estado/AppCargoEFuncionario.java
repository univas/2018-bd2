package br.edu.univas.si3.estado;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import br.edu.univas.si3.estado.entities.Employee;
import br.edu.univas.si3.estado.entities.Position;
import br.edu.univas.si3.util.HibernateUtil;

public class AppCargoEFuncionario {
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

		Employee e2 = new Employee();
		e2.setName("Jane");
		e2.setActive(true);
		e2.setBirth(new Date());
		
		// persiste os funcionários
		em.getTransaction().begin();
		em.persist(posGerente);
		
		e1.setPosition(posGerente);
		e2.setPosition(posGerente);
		
		em.persist(e1);
		em.persist(e2);
		em.getTransaction().commit();
	}
}