package ir.freeland.springboot.relation.onetoone.foreignkeybased2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class ForeignKeyBasedRun {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	public void sampleRun() {
		entityManager=entityManager.getEntityManagerFactory().createEntityManager();		
		Session session = entityManager.unwrap(Session.class);
		Transaction transaction = session.getTransaction();
		
		//*****************************************
		transaction.begin();		
		CorruptedItem myCorruptedItem = new CorruptedItem();

		myCorruptedItem.setReason("shekastegi");
		
		Item myItem = new Item();
		myItem.setName("nike");
		myItem.setCategory("shoes");
		myItem.setPrice("10000");
		myItem.setCorruptedItem(myCorruptedItem);
		
		session.persist(myItem);
		
		
    	transaction.commit();
    	
	
    	//*****************************************
    	transaction.begin();
    	Item myItem2 = new Item();
    	myItem2.setName("puma");		
		
		session.persist(myItem2);
    	
    	transaction.commit();
    	
    	//*****************************************
    	transaction.begin();
    	List<Item> items = session.createQuery("from Item i where i.Name like '%puma%' " , Item.class).getResultList();		
    	items.stream().forEach( i -> System.out.println( i.getCorruptedItem().getReason() ));
    	transaction.commit();
    	
    	//*****************************************
    	transaction.begin();    	
    	session.remove(myItem);
    	transaction.commit();
	}
}
