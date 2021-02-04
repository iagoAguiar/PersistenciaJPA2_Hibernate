package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		
		Conta conta = new Conta();
		conta.setTitular("Caramelo");
		conta.setNumero(12468);
		conta.setAgencia(86421);
		conta.setSaldo(500.00);
		
		
		em.getTransaction().begin();
		
		em.persist(conta);

		

		em.getTransaction().commit();
		em.close();
		EntityManager em2 = emf.createEntityManager();
		
		
		
		em2.getTransaction().begin();
		
		em2.merge(conta);

		em2.getTransaction().commit();

		
		
		
	}

}
