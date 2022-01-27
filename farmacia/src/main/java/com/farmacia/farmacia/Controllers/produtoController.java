package com.farmacia.farmacia.Controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

//import com.farmacia.farmacia.Dto.Request.produtoDTO;
import com.farmacia.farmacia.Models.produto;
import com.farmacia.farmacia.Repositories.ProdutoRepository;
import com.farmacia.farmacia.Services.produtoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.engine.AttributeName;

import lombok.RequiredArgsConstructor;

@Controller
//@RestController
//@RequestMapping("/buscarProduto")
//@Log4j2
@RequiredArgsConstructor
public class produtoController {

    @Autowired
    private produtoService ps;


    @GetMapping(value = "/cadastrarProduto")
    public String getProduto(Model model) {
        model.addAttribute("produto", new produto());
        return "cadastrarProduto";
    }

    @GetMapping(value = "/buscarProduto")
    public ModelAndView listandoPorId(@RequestParam("id") Long id, Model model) {
        produto prod = ps.findById(id);
        ModelAndView modelAndView = new ModelAndView("/cadastrarProduto");
        modelAndView.addObject("produto", prod);
        return modelAndView;
    }

    @RequestMapping(value = "/cadastrarProduto/search", method = RequestMethod.GET)
	@ResponseBody
	public List<String> search(HttpServletRequest request) {
		return ps.search(request.getParameter("term"));
	}
    
}
