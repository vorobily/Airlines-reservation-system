package com.example.airlinesreservation.rest;

import com.example.airlinesreservation.entity.User;
import com.example.airlinesreservation.exception.UserException;
import com.example.airlinesreservation.login.Login;
import com.example.airlinesreservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.Base64.Encoder;


@CrossOrigin()
@Controller
public class UserController {

    @Autowired
    private UserService userservice;

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("userForm", new User());
        return "register.html";
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute("userForm") User user) {

        Encoder encoder = Base64.getEncoder();
        String encrypt = encoder.encodeToString(user.getPassword().getBytes());
        user.setPassword(encrypt);
        int uid;
        try {
            System.out.println("Received user data: " + user);
            uid = userservice.createUser(user);
            System.out.println("User added successfully with user id: " + uid);
            return "redirect:/";
        } catch (UserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }

    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        User user = userservice.validate(login);
        if (user != null) {
            user.setPassword(password);
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}