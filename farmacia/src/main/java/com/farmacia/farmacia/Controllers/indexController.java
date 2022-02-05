package com.farmacia.farmacia.Controllers;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value={"/Medicamentos","/Higiene","/Infantil"})
    public ModelAndView listaProdutosMedicamentos(HttpServletRequest request){
        String categoria = request.getRequestURI();
        categoria = categoria.substring(categoria.lastIndexOf("/") + 1); 

        ModelAndView mv = new ModelAndView("index");
        Iterable<produto> produtos = ps.listAllByCategory(categoria);
        mv.addObject("produtos", produtos);
        return mv;
    }
    
}