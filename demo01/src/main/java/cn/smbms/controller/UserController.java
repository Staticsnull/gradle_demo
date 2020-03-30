package cn.smbms.controller;

import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String username,
                          @RequestParam String email,
                          HttpServletRequest request,
                          HttpSession session){
        User user = userService.login(username,email);
        if (user == null){
            request.setAttribute("error","用户名或者密码有误！！");
            return "login";
        }
        session.setAttribute("user",user);
        return "redirect:/main";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(){
        System.out.println("logout====");
        return "login";
    }
}
