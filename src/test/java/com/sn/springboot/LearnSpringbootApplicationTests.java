package com.sn.springboot;

import com.sn.springboot.aop.CoffeeShop;
import com.sn.springboot.ehcache.EhcacheService;
import com.sn.springboot.mail.MailService;
import com.sn.springboot.properties.DataBaseProperties3;
import com.sn.springboot.redis.RedisService;
import com.sn.springboot.redis.RedisService2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class LearnSpringbootApplicationTests {

    @Autowired
    DataBaseProperties3 dataBaseProperties;

    @Autowired
    CoffeeShop coffeeShop;

    @Autowired
    RedisService redisService;

    @Autowired
    RedisService2 redisService2;

    @Autowired
    MailService mailService;

    @Autowired
    EhcacheService ehcacheService;

    @Test
    void doTest() {
//        System.out.println(dataBaseProperties.getDriverName());
//        coffeeShop.sale("拿铁");
//        redisService2.deletePiplineKV();
//        mailService.send();
//        System.out.println(ehcacheService.getUserById(1L));
//        System.out.println(ehcacheService.getUserById(1L));

        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("qazwsxedc");
        System.out.println(passwordEncoder.encode("123456"));
    }

}
