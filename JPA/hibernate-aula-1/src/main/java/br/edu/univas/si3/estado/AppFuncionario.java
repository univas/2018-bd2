package br.edu.univas.si3.estado;

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
		Employee e1 = new Employee();
		// e1.setCode(1);
		e1.setName("João");
		e1.setActive(false);
		e1.setBirth(new Date());

		Employee e2 = new Employee();
		// e2.setCode(2);
		e2.setName("Jane");
		e2.setActive(true);

		// 10 anos atrás ???
		e2.setBirth(new Date(System.currentTimeMillis() - 10 * 365 * 24 * 60 * 60 * 1000));

		// persiste os funcionários
		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.getTransaction().commit();
	}
}