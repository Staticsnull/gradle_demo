package cn.smbms;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class Demo03ApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
        List<User> userList = userDao.selectList(null);
        userList.forEach(x-> System.out.println(x.getId()+"\t"+x.getName()));
    }

}
