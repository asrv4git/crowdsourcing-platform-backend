package com.github.crowdsourcingplatformapi.repository;

import com.github.crowdsourcingplatformapi.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import javax.sql.DataSource;
import java.util.*;
import java.util.stream.Collectors;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired private UserRepository userRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        Assertions.assertNotNull(dataSource);
        Assertions.assertNotNull(jdbcTemplate);
        Assertions.assertNotNull(entityManager);
        Assertions.assertNotNull(userRepository);
    }
    //to propagate data into the db
    @BeforeEach
    public void insertDataIntoDb(){
        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(new User(UUID.randomUUID(),"Jhon Wick","jhon.wick@localhost.com",
                        10, Arrays.asList("JAVA","SPRING")),
                new User(UUID.randomUUID(),"Lebron James rawat","lebrom.james@gamil.com",
                        10, Arrays.asList("PYTHON","C++","JAVA")),
                new User(UUID.randomUUID(),"Jhon Cena","cena.jhon@localhost.com",
                        10, Arrays.asList("JAVA","SPRING","PYTHON"))));
        userRepository.saveAll(userList);
    }

    @Test
    public void validateGetUsersFilteredByNameEmailAndSkillsWithPagination(){
        Page<User> userPage = userRepository.getUsersFilteredByNameEmailAndSkillsWithPagination(
                "adarsh","adarsh",Arrays.asList("JAVA, SPRING"),PageRequest.of(1,1));
        System.out.println(userRepository.findAll());
        System.out.println("List of Users: "+userPage.getContent());
        System.out.println(userPage.getTotalElements());
    }

    @Test
    public void testFindBySkills(){
        List<User> userList = userRepository.findBySkills(Arrays.asList("JAVA, SPRING"),2L);
        //2 is expected
        Assertions.assertEquals(2,userList.size());
        /*System.out.println(userList.size());
        userList.stream().forEach(System.out::println);*/
    }

    @Test
    public void findUserWith() {
        List<String> skills = Arrays.asList("JAVA, SPRING");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> userQuery = cb.createQuery(User.class);
        Root<User> userRoot = userQuery.from(User.class);
        List<Predicate> skillsPredicate = skills.stream()
                .map(skill -> cb.isMember(skill, userRoot.get("skills")))
                .collect(Collectors.toList());

        userQuery.select(userRoot)
                .where(skillsPredicate.toArray(new Predicate[]{}));
        List<User> userList =entityManager.createQuery(userQuery).getResultList();
        System.out.println(userList.size());
        userList.stream().forEach(System.out::println);

    }
}
