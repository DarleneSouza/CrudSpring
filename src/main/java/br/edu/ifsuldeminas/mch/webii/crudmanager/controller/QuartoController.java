package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.QuartoRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class QuartoController {


    @Autowired
    private QuartoRepository quartoRepository;

    @GetMapping("/quartos")
    public String quartos(Model model) {


        List<Quarto> quartos = quartoRepository.findAll();
        model.addAttribute("quartos", quartos);
        return "quarto";
    }

    @GetMapping("/quartos/form")
    public String quartoForm(@ModelAttribute("quarto") Quarto quarto) {

        return "quarto_form";
    }

    @PostMapping("/quartos/new")
    public String userNew(@ModelAttribute("quarto") Quarto quarto) {

        quartoRepository.save(quarto);

        return "redirect:/quartos";
    }

    @GetMapping("/quartos/update/{id}")
    public String QuartoUpdate(@PathVariable("id")Integer id, Model model) {

        Optional<Quarto> optQuarto = quartoRepository.findById(id);
        if(optQuarto.isPresent()) {
            //gerar erro
        }

        Quarto quarto = optQuarto.get();

        model.addAttribute("quarto", quarto);

        return "quarto_form";
    }

    @GetMapping("/quartos/delete/{id}")
    public String quartoDelete(@PathVariable("id")Integer id) {

        Optional<Quarto> optQuarto = quartoRepository.findById(id);
        if(optQuarto.isPresent()) {
            //gerar erro
        }

        Quarto quarto = optQuarto.get();

        quartoRepository.delete(quarto);

        return "redirect:/quartos";


    }

}
