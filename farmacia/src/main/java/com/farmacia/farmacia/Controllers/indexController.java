package com.farmacia.farmacia.Controllers;

import java.util.List;

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

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class indexController {

    @Autowired
    private produtoService ps;

    @RequestMapping("/")
    public String listaProdutos(Model model){
        return listByPage(model, 1, "3");
    }

    @GetMapping("/page/{pageNumber}")
    public String listByPage(Model model, 
            @PathVariable("pageNumber") int currentPage, 
            @Param("sortField") String sortField
            ){

        Page<produto> page = ps.listAllByCategory(currentPage, sortField);

        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        List<produto> listaProdutos = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listaProdutos", listaProdutos);
        model.addAttribute("sortField", sortField);

        return "index";    
    }
}