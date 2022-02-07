package com.farmacia.farmacia.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.farmacia.farmacia.Models.produto;
import com.farmacia.farmacia.Services.produtoService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class indexController {

    @Autowired
    private produtoService ps;
/*
    @RequestMapping("/")
    public String listaProdutos(Model model){
        Page<produto> page = ps.listAll();
        int totalItems = page.getNumberOfElements();
        int totalPages = page.getTotalPages();

        List<produto> listaProdutos = page.getContent();

        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listaProdutos", listaProdutos);

        return "index";
    }
*/
/*
    @RequestMapping("/")
    public ModelAndView listaProdutos(){
        ModelAndView mv = new ModelAndView("index");
        int currentPage = 1;
        Page<produto> page = ps.listAll();
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        List<produto> listaProdutos = page.getContent();

        //model.addAttribute("totalItems", totalItems);
        //model.addAttribute("totalPages", totalPages);
        //model.addAttribute("listaProdutos", listaProdutos);
        //mv.addObject("currentPage", currentPage);
        //mv.addObject("totalItems", totalItems);
        //mv.addObject("totalPages", totalPages);
        mv.addObject("listaProdutos", listaProdutos);
        return mv;
    }
*/
    @RequestMapping("/")
    public String listaProdutos(Model model){
        return listByPage(model, 1, "descricao","asc");
    }
/*
    @GetMapping("/page/{pageNumber}{sortField}{sortDir}")
    public String listByPage(Model model, @PathVariable("pageNumber") int currentPage, 
            @PathVariable("sortField") String sortField, 
            @PathVariable("sortDir") String sortDir){
        Page<produto> page = ps.listAll(currentPage, sortField, sortDir);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        List<produto> listaProdutos = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listaProdutos", listaProdutos);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseSortDir", reverseSortDir);

        return "index";
        
    }
*/
    @GetMapping("/page/{pageNumber}")
    public String listByPage(Model model, 
            @PathVariable("pageNumber") int currentPage, 
            @Param("sortField") String sortField, 
            @Param("sortDir") String sortDir){

        Page<produto> page = ps.listAll(currentPage, sortField, sortDir);

        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        List<produto> listaProdutos = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listaProdutos", listaProdutos);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseSortDir", reverseSortDir);

        return "index";
        
    }



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
    @RequestMapping(value={"/Medicamentos","/Higiene","/Infantil"})
    public ModelAndView listaProdutosMedicamentos(HttpServletRequest request){
        String categoria = request.getRequestURI();
        categoria = categoria.substring(categoria.lastIndexOf("/") + 1); 

        ModelAndView mv = new ModelAndView("index");
        Iterable<produto> produtos = ps.listAllByCategory(categoria);
        mv.addObject("produtos", produtos);
        return mv;
    }
    */
}