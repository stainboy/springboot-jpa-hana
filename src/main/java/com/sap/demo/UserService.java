package com.sap.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    Page<User> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    Optional<User> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional()
    User save(User user) {
        return repository.saveAndFlush(user);
    }

    @Transactional(readOnly = true)
    Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }


}