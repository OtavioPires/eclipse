package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Order;

public class ManyToManyTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("testjpa");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		Order order = em.find(Order.class, 111);

		em.close();
		entityManagerFactory.close();
		System.out.println("Order  : " + order.getProductList());

	}
}
