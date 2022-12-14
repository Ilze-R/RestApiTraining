package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
// @ResponseBody tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object
@RestController
//combine @controller and @responseBody
public class HelloWorldController {

    @GetMapping("/hello-world")
    //to map HTTP GET request onto specific handler method
    public String helloWorld(){
        return "Hello World";
    }
}
