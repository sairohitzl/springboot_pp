package com.example.demo.controller;

import com.example.demo.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/greeting")
    public String greeting(){
        return "Hello All..";
    }

    @PostMapping("/validation")
    public String validate(@RequestBody User user ){

            if(user.getUsername().equals("sai") && user.getPassword().equals("123") ){

                return "success";
            }
        return "fail";
    }


}
