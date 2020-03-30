package cn.test;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserDao {
    @Autowired
    private UserDao userDao;

    @Autowired
    UserService userService;
    @Test
    public void test_01(){
        List<User> userList = userDao.selectList(null);
        userList.forEach(x-> System.out.println(x.getId()+"\t"+x.getName()));
    }
    @Test
    public void test_02(){
        User user = userService.login("Jone", "test1@baomidou.com");
        System.out.println(user);
    }

}
