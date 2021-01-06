package com.hello.human;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HumanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanApplication.class, args);
    }
    @RequestMapping("/")
    public String hello(@RequestParam(value="name",required = false)String name,@RequestParam(value="last",required = false)String last){
    if (name==null){
        return "<h1>Hello Human</h1><p>Welcome to spring </p>";
    }else{
        return "<h1>Hello "+name+" "+last+"<h1>";
    }
    }
    }


