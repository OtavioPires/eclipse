package test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Customer;
import entity.Invoice;
import entity.Order;

public class OneToOneTest {

	public static void main(String[] args) {
		
		//inserir();
		recuperar();
		
	}
	
	public static void recuperar(){
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("testjpa");
		
		EntityManager em = entityManagerFactory.createEntityManager();

		Order order = em.find(Order.class, 1L);
		em.close();
		entityManagerFactory.close();
		System.out.println("order : " + order);
		System.out.println("customer : " + order.getCustomer());
	}
	
	public static void inserir(){
		
		
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("testjpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//inserindo customer
		Customer customer = new Customer();
		customer.setFirstName("Jefferson");
		customer.setLastName("Carvalho");
		customer.setStreet("Rua dos Coelhos");
		customer.setEmail("carvalho@gmail.com");
		customer.setZipCode("60411205");
		customer.setUpdatedTime(new Date());
		
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		
		//inserindo order
		Order order = new Order();
		order.setOrderDesc("bla bla bla");
		order.setOrderDt(new Date());
		order.setTotPrice(24.9);
		order.setUpdatedTime(new Date());
		
		Invoice inv = new Invoice();
		inv.setAmountDue(68.5);
		inv.setOrder(order);
		
		order.setInvoice(inv);
		order.setCustomer(customer);
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		em.close();
		
		
		entityManagerFactory.close();
		
		
		
	}
}
