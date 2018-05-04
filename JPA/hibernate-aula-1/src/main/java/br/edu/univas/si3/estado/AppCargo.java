package br.edu.univas.si3.estado;

import javax.persistence.EntityManager;

import br.edu.univas.si3.estado.entities.Position;
import br.edu.univas.si3.util.HibernateUtil;

public class AppCargo {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		EntityManager em = HibernateUtil.getEntityManager();

		Position posGerente = new Position();
		// posGerente.setCode(1);//não seta o código (PK) quando o valor é gerado pelo banco
		posGerente.setName("Gerente");

		Position posAnalisa = new Position();
		// posAnalisa.setCode(2);//não seta o código (PK) quando o valor é gerado pelo banco
		posAnalisa.setName("Analista");

		em.getTransaction().begin();
		em.persist(posGerente);
		em.persist(posAnalisa);
		em.getTransaction().commit();

		System.err.println("Codigo do gerente: " + posGerente.getCode());
		System.err.println("Codigo do analista: " + posAnalisa.getCode());

	}
}