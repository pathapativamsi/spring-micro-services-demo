package com.dailycodebuffer.springbootdemo.controller;

import com.dailycodebuffer.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Hello world!";
    }

    //@RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User user(){
        User usr = new User();
        usr.setId("1");
        usr.setName("vamsi");
        usr.setEmailId("pathapativamsi@gmail.com");

        return usr;
    }

    @GetMapping("/{id1}/{id2}")
    public String pathvariable(@PathVariable String id1, @PathVariable("id2") String name){
        return "path variable is:"+id1+name;
    }
}
