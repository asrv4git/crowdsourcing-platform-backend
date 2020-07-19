package com.github.crowdsourcingplatformapi.repository;

import com.github.crowdsourcingplatformapi.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    //skills which a user must have
    @Query(value = "SELECT u FROM App_User u LEFT JOIN u.skills sk WHERE sk IN :skillList"
            + " GROUP BY u HAVING COUNT(DISTINCT sk) = :skillListSize")
    List<User> findByMandatorySkills(@Param("skillList") List<String> skills,
                                     @Param("skillListSize") long skillListSize);

}
