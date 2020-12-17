package cn.konngo;

import cn.konngo.dao.UsersDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BmanagerApplicationTests {
    @Autowired
    private UsersDao usersDao;

    @Test
    void contextLoads() {
    }

    @Test
    void select(){
        System.out.println(usersDao.findAll());
    }

}
