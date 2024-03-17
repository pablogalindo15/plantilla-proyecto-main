package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.PuntoDeAtencion;
import uniandes.edu.co.proyecto.repositorio.PuntoDeAtencionRepository;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;

@Controller
public class PuntoDeAtencionController {

    @Autowired
    private PuntoDeAtencionRepository puntoDeAtencionRepository;

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping("/puntosDeAtencion")
    public String puntosDeAtencion(Model model) {
        model.addAttribute("puntosDeAtencion", puntoDeAtencionRepository.darPuntoDeAtencions());
        return "puntosDeAtencion";
    }

    @GetMapping("/puntoDeAtencion/new")
    public String puntoDeAtencionForm(Model model) {
        model.addAttribute("puntoDeAtencion", new PuntoDeAtencion());
        model.addAttribute("oficinas", oficinaRepository.darOficinas());
        return "puntoDeAtencionNuevo";
    }

    @PostMapping("/puntosDeAtencion/new/save")
    public String puntoDeAtencionGuardar(@ModelAttribute PuntoDeAtencion puntoDeAtencion) {
        puntoDeAtencionRepository.insertarPuntoDeAtencion(puntoDeAtencion.getTipo(), puntoDeAtencion.getIdOficinaFK().getId());
        return "redirect:/puntosDeAtencion";
    }

    @GetMapping("/puntosDeAtencion/{id}/edit")
    public String puntoDeAtencionEditarForm(@PathVariable("id") int id, Model model) {
        PuntoDeAtencion puntoDeAtencion = puntoDeAtencionRepository.darPuntoDeAtencion(id);
        if (puntoDeAtencion != null) {
            model.addAttribute("puntoDeAtencion", puntoDeAtencion);
            model.addAttribute("oficinas", oficinaRepository.darOficinas());
            return "puntoDeAtencionEditar";
        } else {
            return "redirect:/puntosDeAtencion";
        }
    }

    @PostMapping("/puntosDeAtencion/{id}/edit/save")
    public String puntoDeAtencionEditarGuardar(@PathVariable("id") int id, @ModelAttribute PuntoDeAtencion puntoDeAtencion) {
        puntoDeAtencionRepository.actualizarPuntoDeAtencion(puntoDeAtencion.getTipo(), puntoDeAtencion.getIdOficinaFK().getId());
        return "redirect:/puntosDeAtencion";
    }

    @GetMapping("/puntosDeAtencion/{id}/delete")
    public String puntoDeAtencionEliminar(@PathVariable("id") int id) {
        puntoDeAtencionRepository.eliminarPuntoDeAtencion(id);
        return "redirect:/puntosDeAtencion";
    }
}
