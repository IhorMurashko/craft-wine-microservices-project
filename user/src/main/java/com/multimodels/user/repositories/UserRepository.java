package com.multimodels.user.repositories;

import com.multimodels.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    List<User> findAll();

    void deleteByEmail(String email);

    void deleteById(Long id);

     User saveAndFlush(User entity);

    @Override
    <S extends User> S save(S entity);



}
