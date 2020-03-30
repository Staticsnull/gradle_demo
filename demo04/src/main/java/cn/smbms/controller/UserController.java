package cn.smbms.controller;

import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import cn.smbms.tools.Constants;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("/")
    public String login(){
        return "login";
    }


    @Autowired
    private UserService userService;
    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String userCode,
                          @RequestParam String userPassword,
                          HttpServletRequest request,HttpSession session){
        User user = userService.getOne(new QueryWrapper<User>().eq("userCode", userCode));
        if (user!=null && user.getUserPassword().equals(userPassword)){
            session.setAttribute(Constants.USER_SESSION,user);
            return "redirect:main";
        }
        request.setAttribute("error","用户名或者密码有误！！");
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "frame";
    }

}
