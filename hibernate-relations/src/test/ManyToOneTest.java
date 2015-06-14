package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Customer;

public class ManyToOneTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("testjpa");
		
		EntityManager em = entityManagerFactory.createEntityManager();
//		Order order = em.find(Order.class, 111);
		Customer customer = em.find(Customer.class, 100);
		em.close();
		entityManagerFactory.close();
		System.out.println("customer : " + customer);

	}
}
