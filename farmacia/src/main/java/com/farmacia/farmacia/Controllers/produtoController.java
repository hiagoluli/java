package com.farmacia.farmacia.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.ToDoubleFunction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import com.farmacia.farmacia.Dto.LabelValueDTO;
//import com.farmacia.farmacia.Dto.Request.produtoDTO;
import com.farmacia.farmacia.Models.produto;
import com.farmacia.farmacia.Repositories.ProdutoRepository;
import com.farmacia.farmacia.Services.produtoService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.KPropertyPathExtensionsKt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import org.thymeleaf.standard.expression.Each;

import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class produtoController {

    @Autowired
    private produtoService ps;

    private List<produto> produtos;
/*
    @GetMapping(value = "/cadastrarProduto")
    public String getProduto(Model model) {
        model.addAttribute("produto", new produto());
        return "cadastrarProduto";
    }
*/
    @GetMapping(value = "/cadastrarProduto")
    public ModelAndView getProduto(Model model){
        ModelAndView mv = new ModelAndView("cadastrarProduto");
        model.addAttribute("produto", new produto());
        mv.addObject("produto");
        return mv;
    }

    @GetMapping(value = "/buscarProduto")
    public ModelAndView listandoPorId(@RequestParam("id") Long id, Model model) {
        produto prod = ps.findById(id);
        if(prod == null){
            
        }
        ModelAndView modelAndView = new ModelAndView("/cadastrarProduto");
        modelAndView.addObject("produto", prod);
        return modelAndView;
    }
    
    @GetMapping("/cadastrarProduto/search")
    @ResponseBody
    public List<LabelValueDTO> buscaPorDescricao(HttpServletRequest request) {
        produtos = ps.listAll();
        String keyword = request.getParameter("term");
        List<LabelValueDTO> suggestions = new ArrayList<LabelValueDTO>();       
        
        for(produto prod : produtos){
            if(prod.toString().matches("(?i).*" + keyword + ".*")){
                LabelValueDTO lv = new LabelValueDTO();
                lv.setLabel(prod.getDescricao());
                //lv.setLabel(prod.toString());
                lv.setValue(Long.toString(prod.getId()));
                suggestions.add(lv);               
            }
        }
        
        return suggestions;
    }

    @PostMapping("/registrarProduto")
    @ResponseBody
    public ModelAndView salvarProduto(produto prod){
        if(prod.getImagem() == null){
            prod.setImagem("generico.png");
        }
        ModelAndView mv = new ModelAndView("cadastrarProduto");
        ps.salvarProduto(prod);
        return mv;
    }
/*
    @PostMapping("/excluirProduto")
    @ResponseBody
    public String excluirProduto(@RequestParam("id") Long id, Model model){
        ps.excluirProduto(id);
        return "redirect:/cadastrarProduto";
    }
*/

    @PostMapping("/excluirProduto")
    @ResponseBody
    public ModelAndView excluirProduto(@RequestParam("id") Long id, Model model){
        ModelAndView mv = new ModelAndView("cadastrarProduto");
        model.addAttribute("produto", new produto());
        mv.addObject("produto");
        ps.excluirProduto(id);
        return mv;
    }


}
