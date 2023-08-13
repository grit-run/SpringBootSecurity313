package com.elinsky.threeonethree.repository;

import com.elinsky.threeonethree.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select p from User p left join fetch p.roles where p.login=(:login)")
    Optional<User> findUserByLogin(String login);
}
