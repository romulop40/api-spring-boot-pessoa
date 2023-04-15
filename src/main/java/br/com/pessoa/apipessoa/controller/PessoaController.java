package br.com.pessoa.apipessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pessoa.apipessoa.model.Pessoa;
import br.com.pessoa.apipessoa.repository.PessoaRepository;




@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public  ModelAndView listar(){
        ModelAndView modelAndView=new ModelAndView("pessoa/listar.html");
        List<Pessoa> pessoas= pessoaRepository.findAll();
        modelAndView.addObject("pessoas", pessoas);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("pessoa/detalhar.html");
        /*Pessoa pessoa= pessoaRepository.getOne(id);*/
        Pessoa pessoa= pessoaRepository.getReferenceById(id);
        modelAndView.addObject("pessoa", pessoa);
        return modelAndView;
       
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("redirect:/pessoa");

        pessoaRepository.deleteById(id);
        return modelAndView;

    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){

        ModelAndView modelAndView=new ModelAndView("pessoa/cadastro");
        modelAndView.addObject("pessoa", new Pessoa());
        return modelAndView;

    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Pessoa pessoa){
        ModelAndView modelAndView=new ModelAndView("redirect:/pessoa");
        pessoaRepository.save(pessoa);
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("pessoa/edicao");
        Pessoa pessoa= pessoaRepository.getReferenceById(id);
        modelAndView.addObject("pessoa", pessoa);
        return modelAndView;
    }
    @PostMapping("/{id}/editar")
    public ModelAndView editar(Pessoa pessoa){
        ModelAndView modelAndView=new ModelAndView("redirect:/pessoa");
        pessoaRepository.save(pessoa);
        return modelAndView;
    }
    
}

