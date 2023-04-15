package br.com.pessoa.apipessoa.controller;

import org.springframework.stereotype.Controller;
/*import org.springframework.ui.Model;*/
/*import org.springframework.ui.ModelMap;*/
import org.springframework.web.bind.annotation.GetMapping;
/*import org.springframework.web.bind.annotation.PathVariable;*/
/*import org.springframework.web.bind.annotation.RequestAttribute;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*import org.springframework.web.bind.annotation.RequestMethod;*/
/*import org.thymeleaf.engine.AttributeName;*/
import org.springframework.web.servlet.ModelAndView;

/*Controller - Sobre Essa Anotação da classe informei para o Spring saber que aqui tem uma declaração controller */
@Controller
/*
 * RequestMapping - Essa anotação serve para informar ao Spring qual a rota HOME
 * vai responder
 */
@RequestMapping("/")
public class HomeController {

    /* Metodo ao qual o HTTP ele vai responder */
    /* @RequestMapping(path="/", method = RequestMethod.GET) */

    /*
     * Ja no Spring MVC ele me prové outa anotação que é o GetMapping
     * Ele tem a mesma função do RequestMapping só que ele ja me passa o metodo GET
     */
    @GetMapping("/")
    public String home() {
        return "home";
        /*
         * Essa String Home é o nome da View que vai ser exibida
         * para o cliente quando ele acessar a rota /
         */
    }

    @GetMapping("/mensagem")
    public ModelAndView mensagem() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("mensagem");
        modelAndView.addObject("mensagem", "Teste mensagem do servidor");
        return modelAndView;
        /* Passei as informações da camada Controller para a View */
    }

    @GetMapping("/saudacao/{nome}")
    public ModelAndView saudacao(@RequestParam(required = false, defaultValue = "API pessoa") 
    String nome) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("saudacao");
        modelAndView.addObject("nome", nome);
        return modelAndView;
        /* Passei as informações da camada View para a Controller */

    }

}
