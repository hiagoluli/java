package com.farmacia.farmacia.Controllers;

import java.util.List;
import java.util.Optional;

import com.farmacia.farmacia.Dto.Request.produtoDTO;
import com.farmacia.farmacia.Models.produto;
import com.farmacia.farmacia.Repositories.ProdutoRepository;
import com.farmacia.farmacia.Services.produtoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.engine.AttributeName;

import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;

@Controller
//@RestController
//@RequestMapping("/buscarProduto")
//@Log4j2
@RequiredArgsConstructor
public class produtoController {

    @Autowired
    private ProdutoRepository ps;

    //private final produtoService ps;
/*
    @RequestMapping("/")
    public ResponseEntity<List<produto>> list() {
        return ResponseEntity.ok(ps.listAll());
    }
*/
    /*
    @RequestMapping("/")
    public ModelAndView listaProdutos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<produto> produtos = pr.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }
    */
/*
    @RequestMapping("/")
    public ModelAndView listaProdutos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<produto> produtos = ps.listAll();
        mv.addObject("produtos", produtos);
        return mv;
    }
    */
/*
    @PostMapping
    public produto getProduto(@RequestBody produtoDTO prodDto){
        this.ps.findById(prodDto.build());
        return produto;
    }
*/
/*
    @PostMapping(path="buscarProduto/{id}")
    public ResponseEntity<produto> findById(@PathVariable long id) {
        return null;
        //return ResponseEntity<produto>.ok(produtoService listAll().get(0));
    }
*/
    @GetMapping("/buscarProduto/{id}")
    public ModelAndView mostrar(@PathVariable Long id) {
        Optional<produto> optional = this.ps.findById(id);

        if(optional.isPresent()){
            produto produto = optional.get();
            ModelAndView mv = new ModelAndView("redirect:/cadastrarProduto");
            mv.addObject("produto", produto);
            return mv;
        }else {
            return new ModelAndView("redirect:/index");
        } 
    }

}
