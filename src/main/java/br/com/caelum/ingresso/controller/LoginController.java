package br.com.caelum.ingresso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nando on 03/04/17.
 */
@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
