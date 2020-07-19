package com.github.crowdsourcingplatformapi.service;

import com.github.crowdsourcingplatformapi.models.entity.User;
import com.github.crowdsourcingplatformapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    @Autowired
    public EntityManager entityManager;
    @Autowired
    UserRepository userRepository;

    public User addUser(@NotNull User user) {
        return userRepository.save(user);
    }


    @Transactional
    public List<User> findUsersHavingMandatorySkills(List<String> skillList) {

        /*List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(new User(UUID.randomUUID(), "Jhon Wick", "jhon.wick@localhost.com",
                        10, Arrays.asList("JAVA", "SPRING")),
                new User(UUID.randomUUID(), "Lebron James", "lebrom.james@gamil.com",
                        10, Arrays.asList("PYTHON", "C++", "JAVA")),
                new User(UUID.randomUUID(), "Jhon Cena", "cena.jhon@localhost.com",
                        10, Arrays.asList("JAVA", "SPRING", "PYTHON"))));
        userRepository.saveAll(userList);*/

        /*List<String> skills = Arrays.asList("JAVA, SPRING");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> userQuery = cb.createQuery(User.class);
        Root<User> userRoot = userQuery.from(User.class);
        List<Predicate> skillsPredicate = skills.stream()
                .map(skill -> cb.isMember(skill, userRoot.get("skills")))
                .collect(Collectors.toList());

        userQuery.select(userRoot)
                .where(skillsPredicate.toArray(new Predicate[]{}));
        List<User> userList2 =entityManager.createQuery(userQuery).getResultList();*/
        List<User> userList2 = userRepository.findByMandatorySkills(skillList, Integer.toUnsignedLong(skillList.size()));
        log.info("Users with mandatory skills: " + userList2.size());
        userList2.stream().forEach(System.out::println);
        return userList2;
    }

    public User findUserById(UUID userId) {
        Optional<User> userOptional =userRepository.findById(userId);
        if(userOptional.isPresent())
            return userOptional.get();
        else{
            log.debug("No such user with id: "+userId);
            return null;
        }
    }

    public User updateSkillsForTheUserWithId(UUID userId, List<String> skills) {
        User user = this.findUserById(userId);
        if(user==null)
            return null;
        else{
            user.setSkills(skills);
            return userRepository.saveAndFlush(user);
        }

    }
}
