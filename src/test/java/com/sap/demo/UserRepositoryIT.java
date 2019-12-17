package com.sap.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIT {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    // write test cases here
    @Test
    public void whenFindByEmail_thenReturnUser() {
        // given
        User miles = new User("miles", "miles.chen01@sap.com");
        entityManager.persist(miles);
        entityManager.flush();

        // when
        User found = userRepository.findByEmail(miles.getEmail()).get();

        // then
        assertThat(found.getName(), equalTo(miles.getName()));
    }
}