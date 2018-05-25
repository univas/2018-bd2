package br.edu.univas.si3.estado;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.univas.si3.estado.entities.Position;
import br.edu.univas.si3.util.HibernateUtil;

public class AppConsultaHQL {
	
	public static void main(String[] args) {
		
		EntityManager em = HibernateUtil.getEntityManager();

		String ql = "select p from Position p where p.name = :nome";
		TypedQuery<Position> query = em.createQuery(ql, Position.class);
		query.setParameter("nome", "Gerente");
		
		//pega apenas um objeto
		//dá erro se existir mais de um objeto
		Position cargo = query.getSingleResult();
		System.out.println("Cargo: " + cargo.getCode());
		
		String ql2 = "select e.position from Employee e where e.name = :usuario";
		
		TypedQuery<Position> query2 = em.createQuery(ql2, Position.class);
		query2.setParameter("usuario", "Jane");
		
		Position cargo2 = query2.getSingleResult();
		System.out.println("Cargo 2: " + cargo2.getCode());
	}
}