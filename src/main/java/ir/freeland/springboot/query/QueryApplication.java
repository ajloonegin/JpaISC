package ir.freeland.springboot.query;

import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import ir.freeland.springboot.query.model.User;
import ir.freeland.springboot.query.repository.UserRepository;
import ir.freeland.springboot.query.repository.UserRepositoryCustomImpl;

@SpringBootApplication
@EntityScan (basePackages = "ir.freeland.springboot.query")
public class QueryApplication {

    public static void main(String[] args) {
    	 System.setProperty("spring.config.name", "application-query");
        var context = SpringApplication.run(QueryApplication.class, args);
        var userRepository = context.getBean( UserRepository.class);
        List<User> users;

        userRepository.count();
        userRepository.findAllActiveUsers();
        userRepository.findUserByStatusAndName( Integer.valueOf(1),"John");

        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        users = userRepository.findAllUsersWithPagination( firstPageWithTwoElements );
        users = userRepository.findAllUsersWithPaginationNative( firstPageWithTwoElements );
        //Query by example
        User user = new User("John", null, null, null);
        userRepository.findAll( Example.of(user) );
        userRepository.findAll( Example.of(user , ExampleMatcher.matchingAll().withIgnoreCase() ) );

        var userRepositoryCustomImpl = context.getBean( UserRepositoryCustomImpl.class);
        users = userRepositoryCustomImpl.findUserByEmails(Set.of("bob@email.com", "john@email.com"));


    }

}
