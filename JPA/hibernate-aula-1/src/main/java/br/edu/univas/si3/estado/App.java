package br.edu.univas.si3.estado;

import javax.persistence.EntityManager;

import br.edu.univas.si3.estado.entities.Position;
import br.edu.univas.si3.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        EntityManager em = HibernateUtil.getEntityManager();
        
        Position posGerente = new Position();
        posGerente.setCode(1);
        posGerente.setName("Gerente");
        
        em.getTransaction().begin();
        em.persist(posGerente);
        em.getTransaction().commit();
    }
}
