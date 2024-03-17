package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.OperacionBancaria;
import uniandes.edu.co.proyecto.repositorio.OperacionBancariaRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@Controller
public class OperacionBancariaController {

    @Autowired
    private OperacionBancariaRepository operacionBancariaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/operacionesBancarias")
    public String listarOperacionesBancarias(Model model) {
        model.addAttribute("operacionesBancarias", operacionBancariaRepository.findAll());
        return "operacionesBancarias"; 
    }

    @GetMapping("/operacionBancaria/new")
    public String nuevaOperacionBancariaForm(Model model) {
        model.addAttribute("operacionBancaria", new OperacionBancaria());
        model.addAttribute("clientes", clienteRepository.findAll());
        return "operacionBancariaNueva"; 
    }

    @PostMapping("/operacionesBancarias/new/save")
    public String guardarNuevaOperacionBancaria(@ModelAttribute OperacionBancaria operacionBancaria) {
        operacionBancariaRepository.save(operacionBancaria);
        return "redirect:/operacionesBancarias";
    }

    @GetMapping("/operacionesBancarias/{id}/edit")
    public String editarOperacionBancariaForm(@PathVariable("id") int id, Model model) {
        OperacionBancaria operacionBancaria = operacionBancariaRepository.findById(id).orElse(null);
        if (operacionBancaria != null) {
            model.addAttribute("operacionBancaria", operacionBancaria);
            model.addAttribute("clientes", clienteRepository.findAll());
            return "operacionBancariaEditar"; 
        } else {
            return "redirect:/operacionesBancarias";
        }
    }

    @PostMapping("/operacionesBancarias/{id}/edit/save")
    public String guardarEdicionOperacionBancaria(@PathVariable("id") int id, @ModelAttribute OperacionBancaria operacionBancaria) {
        operacionBancaria.setId(id);
        operacionBancariaRepository.save(operacionBancaria);
        return "redirect:/operacionesBancarias";
    }

    @GetMapping("/operacionesBancarias/{id}/delete")
    public String eliminarOperacionBancaria(@PathVariable("id") int id) {
        operacionBancariaRepository.deleteById(id);
        return "redirect:/operacionesBancarias";
    }
}
