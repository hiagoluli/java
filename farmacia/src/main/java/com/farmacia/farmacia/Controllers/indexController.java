package com.farmacia.farmacia.Controllers;

import com.farmacia.farmacia.Models.produto;
import com.farmacia.farmacia.Services.produtoService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class indexController {

    private final produtoService ps;

    @RequestMapping("/")
    public ModelAndView listaProdutos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<produto> produtos = ps.listAll();
        mv.addObject("produtos", produtos);
        return mv;
    }
    
}