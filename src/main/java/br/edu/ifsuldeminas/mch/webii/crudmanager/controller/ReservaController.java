package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.QuartoRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.ReservaRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.UserRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Quarto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Reserva;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;

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
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private QuartoRepository quartoRepository;
    @Autowired
	private UserRepository userRepository;

    @GetMapping("/reservas")
    public String reservas(Model model) {

        List<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "reserva";
    }

    @GetMapping("/reservas/form")
    public String userForm(@ModelAttribute("reserva") Reserva reserva, Model model) {
        List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
        List<Quarto> quartos = quartoRepository.findQuartosByStatus("Disponivel");
        model.addAttribute("quartos", quartos);
        return "reserva_form";
    }

    @PostMapping("/reservas/new")
    public String userNew(@ModelAttribute("reserva") Reserva reserva) {
        reserva.setUsuario(userRepository.findById(reserva.getIdUsuario()).get());
        reserva.setQuarto(quartoRepository.findById(reserva.getIdQuarto()).get());
        reserva.getQuarto().setStatus("Reservado");
        quartoRepository.save(reserva.getQuarto());
        if(reserva.getId() != null){
            Quarto oldQuarto = reservaRepository.findById(reserva.getId()).get().getQuarto();
            oldQuarto.setStatus("Disponivel");
            quartoRepository.save(oldQuarto);
        }
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/update/{id}")
    public String ReservaUpdate(@PathVariable("id")Integer id, Model model) {
        List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
        List<Quarto> quartos = quartoRepository.findQuartosByStatus("Disponivel");
        model.addAttribute("quartos", quartos);
        Optional<Reserva> optReserva = reservaRepository.findById(id);
        if(optReserva.isPresent()) {
            //gerar erro
        }

        Reserva reserva = optReserva.get();
        quartos.add(reserva.getQuarto());
        model.addAttribute("reserva", reserva);

        return "reserva_form";
    }

    @GetMapping("/reservas/delete/{id}")
    public String reservaDelete(@PathVariable("id")Integer id) {

        Optional<Reserva> optReserva = reservaRepository.findById(id);
        if(optReserva.isPresent()) {
            //gerar erro
        }

        Reserva reserva = optReserva.get();
        Quarto oldQuarto = reservaRepository.findById(reserva.getId()).get().getQuarto();
        oldQuarto.setStatus("Disponivel");
        quartoRepository.save(oldQuarto);

        reservaRepository.delete(reserva);

        return "redirect:/reservas";


    }
}
