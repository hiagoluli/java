package com.farmacia.farmacia.Controllers;

import com.farmacia.farmacia.Models.produto;
import com.farmacia.farmacia.Repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class produtoController {

    @Autowired
    private ProdutoRepository pr;
    
    @RequestMapping("/")
    public ModelAndView listaProdutos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<produto> produtos = pr.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }
}
