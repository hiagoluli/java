package com.farmacia.farmacia.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("Login");
        return mv;
    }
    
/*
    @RequestMapping("/cadastrarProduto")
    public ModelAndView cadastrarProduto(){
        ModelAndView mv = new ModelAndView("cadastrarProduto");
        return mv;
    }
*/

    @RequestMapping("/cadastrarProduto")
    public String cadastrarProduto(){
        return "cadastrarProduto";
    }
    
}
