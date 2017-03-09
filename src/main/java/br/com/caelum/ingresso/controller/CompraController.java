package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.FilmeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nando on 09/03/17.
 */
@Controller
public class CompraController {


    @Autowired
    private FilmeDao filmeDao;

    @GetMapping("/compra")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("compra/compra");

        modelAndView.addObject("filmes", filmeDao.findAll());

        return modelAndView;
    }

}
