package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {

        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));

        Assert.assertEquals(10, userRepository.findAll().size());

        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

        Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

        userRepository.delete(userRepository.findByName("AAA"));

        Assert.assertEquals(9, userRepository.findAll().size());
    }
}
