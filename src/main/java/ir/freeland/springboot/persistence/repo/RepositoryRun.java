package ir.freeland.springboot.persistence.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class RepositoryRun {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	StudentRepository repository;

	public void sampleRun() {
	var allStudents = repository.findAll();
    System.out.println(allStudents);
    
    var student1 = repository.findByName("Alireza");
    System.out.println(student1);
    
    var student2 = repository.findByNameIgnoreCase("ALIREZA");
    System.out.println(student2);
    
    var student3 = repository.findByNameEndingWith("Reza");
    System.out.println(student3); //??
    
    var student4 = repository.findByNameEndingWithIgnoreCase("Reza");
    System.out.println(student4); 
    
    var student5 = repository.findByNameEndingWithIgnoreCaseOrderByIdDesc("Reza");
    System.out.println(student5); 
    
    var student6 = repository.findTop1ByNameEndingWithIgnoreCaseOrderByIdDesc("Reza");
    System.out.println(student6); 
	}
}
