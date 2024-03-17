package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "clientes"; // Asumiendo que tienes una vista 'clientes.html' para listar los clientes
    }

    @GetMapping("/cliente/new")
    public String nuevoClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clienteNuevo"; // Asumiendo que tienes una vista 'clienteNuevo.html' para el formulario de nuevo cliente
    }

    @PostMapping("/cliente/new/save")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}/edit")
    public String editarClienteForm(@PathVariable Integer id, Model model) {
        Cliente cliente = clienteRepository.darCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clienteEditar"; // Asumiendo que tienes una vista 'clienteEditar.html' para editar el cliente
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{id}/edit/save")
    public String actualizarCliente(@PathVariable Integer id, @ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente); // Esto puede requerir un ajuste para asegurar que el Usuario asociado también se actualice.
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}/delete")
    public String eliminarCliente(@PathVariable Integer id) {
        clienteRepository.eliminarCliente(id);
        // Considera la necesidad de eliminar también el Usuario asociado, si es pertinente.
        return "redirect:/clientes";
    }
}
