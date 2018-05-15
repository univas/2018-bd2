package br.edu.univas.si3.estado;

import javax.persistence.EntityManager;

import br.edu.univas.si3.estado.entities.Employee;
import br.edu.univas.si3.estado.entities.Position;
import br.edu.univas.si3.util.HibernateUtil;

public class AppUpdateDelete {

	public static void main(String[] args) {

		EntityManager em = HibernateUtil.getEntityManager();

		// consulta pela chave primária
		Position cargo = em.find(Position.class, 4);

		System.out.println("Cargo: " + cargo.getName());

		cargo.setName("Diretor");

		em.getTransaction().begin();
		em.merge(cargo);
		em.getTransaction().commit();

		// sem usar um objeto gerenciado
		cargo = new Position();
		cargo.setCode(6);
		cargo.setName("Programador");

		em.getTransaction().begin();
		em.merge(cargo);
		em.getTransaction().commit();

		// o empregado possui vários campos, mas aqui setamos apenas dois -> não
		// funciona
		// precisa obter o objeto completo
		Employee e1 = em.find(Employee.class, 10);// new Employee();
		// e1.setCode(10);
		e1.setActive(true);

		em.getTransaction().begin();
		em.merge(e1);
		em.getTransaction().commit();

		// vamos trocar o cargo do empregado 4
		Position novoCargo = new Position();// objeto não gerenciado pelo
											// EntityManager
		novoCargo.setCode(5);

		e1.setPosition(novoCargo);

		em.getTransaction().begin();
		em.merge(e1);
		em.getTransaction().commit();

		// Delete

		// não funciona pois o objeto está detached (não gerenciado pelo EntityManager)
		// Position programador = new Position();
		// programador.setCode(6);

		Position programador = em.find(Position.class, 6);

		em.getTransaction().begin();
		em.remove(programador);
		em.getTransaction().commit();

	}
}