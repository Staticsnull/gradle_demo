
package cn.smbms.controller;

import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController  {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "index";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String name,
                          @RequestParam String email){
        User user = userService.getOne(new QueryWrapper<User>().eq("name",name));
        if (user != null && user.getEmail().equals(email)){
            return "main";
        }
        return "index";
    }

}
