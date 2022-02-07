package com.farmacia.farmacia.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.farmacia.farmacia.Dto.LabelValueDTO;
import com.farmacia.farmacia.Models.Categoria;
import com.farmacia.farmacia.Models.produto;
import com.farmacia.farmacia.Services.categoriaService;
import com.farmacia.farmacia.Services.produtoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class produtoController {

    @Autowired
    private produtoService ps;

    @Autowired
    private categoriaService cs;

    private List<produto> produtos;

    @GetMapping(value = "/cadastrarProduto")
    public ModelAndView getProduto(Model model){
        ModelAndView mv = new ModelAndView("cadastrarProduto");
        model.addAttribute("produto", new produto());
        mv.addObject("produto");
        return mv;
    }

    @GetMapping(value = "/buscarProduto")
    @ResponseBody
    public ModelAndView listandoPorId(@RequestParam("id") Long id, Model model) {
        produto prod = ps.findById(id);
        ModelAndView modelAndView = new ModelAndView("/cadastrarProduto");
        modelAndView.addObject("produto", prod);
        return modelAndView;
    }
    
   /* 
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
                lv.setValue(Long.toString(prod.getId()));
                suggestions.add(lv);               
            }
        }
        
        return suggestions;
    }
*/
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

    @PostMapping("/excluirProduto")
    @ResponseBody
    public ModelAndView excluirProduto(@RequestParam("id") Long id, Model model){
        ModelAndView mv = new ModelAndView("cadastrarProduto");
        model.addAttribute("produto", new produto());
        mv.addObject("produto");
        ps.excluirProduto(id);
        return mv;
    }
/*
    @GetMapping("/Medicamentos")
    public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model,
            @Param("sortField") String sortField,
            @Param("sortDir") String sortDir,
            @Param("keyword") String keyword,
            @Param("category") String category) {
        List<Category> listCategories = ps.listAllByCategory(categoria);
    }
*/
/*
    @GetMapping("/page/{pageNum}")
    public ModelAndView listaProdutosPorPagina(@PathVariable(name = "pageNum") int pageNum, Model model,
        //@Param("sortField") String sortField,
        //@Param("sortDir") String sortDir,
        //@Param("keyword") String keyword,
        @Param("categoria") String categoria
    ){

        List<Categoria> listaCategorias = cs.listAll();

        Page<produto> page = ps.listAll(pageNum, categoria);
        List<produto> listaProdutos = page.getContent();

        model.addAttribute("listaCategorias", listaCategorias);

        if (categoria != null) model.addAttribute("categoria", categoria);

        model.addAttribute("totalPages", pageTotalPages());
        model.addAttribute("totalItems", pageTotalElements());
        model.addAttribute("currentPage", pageNum());

        model.addAttribute("listaProdutos", listaProdutos);

        long startCount = (pageNum - 1) * produtoService.PRODUTOS_POR_PAGINA + 1;
        model.addAttribute("startCount", startCount);

        long endCount = startCount + produtoService.PRODUTOS_POR_PAGINA - 1;
        if (endCount > page.getTotalElements()){
            endCount = page.getTotalElements();
        }
     

        ModelAndView mv = new ModelAndView("index");
        Iterable<produto> produtos = ps.listAllByCategory(categoria);
        mv.addObject("produtos", produtos);
        return mv;
    }
*/

}
