package cn.smbms.service.impl;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public User login(String username,String email){
        //BINARY 用来严格区分大小写 加到列名之前就可以
        User user = userDao.selectOne(new QueryWrapper<User>().eq("BINARY name",username));
        if (user != null && user.getEmail().equals(email)){
            return user;
        }
        return null;
    }
}
