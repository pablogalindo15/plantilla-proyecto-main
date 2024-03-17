package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsuarioController {

    @Autowired 
    private UsuarioRepository usuarioRepository;

  @GetMapping("/usuarios")
  public String Usuarios(Model model) {
    model.addAttribute("usuarios",usuarioRepository.darUsuario(0));
    return "usuarios";
  }

  @GetMapping("/usuario/new")
  public String usuarioForm(Model model) {
      model.addAttribute("usuarios", new Usuario());
      return "usuarioNuevo";
  }

  @PostMapping("/usuarios/new/save")
  public String usuarioGuardar(@ModelAttribute Usuario usuario) {
    usuarioRepository.insertarUsuario(usuario.getNumeroDocumento(), usuario.getTipoDocumento(), usuario.getNombre(),
     usuario.getDireccionFisica(), usuario.getDireccionElectronica(), usuario.getTelefono(),usuario.getCiudad(),
      usuario.getClave(),usuario.getLogin(),usuario.getCiudad(), usuario.getDepartamento(), usuario.getCodigoPostal());
      return "redirect:/usuarios";
  }
  
  @GetMapping("/usuarios/{id}/edit")
  public String usuarioEditarForm(@PathVariable("id") int id, Model model) {
    Usuario usuario =usuarioRepository.darUsuario(id);
    if (usuario != null){
        model.addAttribute("usuario", usuario);
        return "barEditar";
    }
    else{
        return "redirect/usuarios";
    }
  }

  @PostMapping("usuarios/{id}/edit/save")
  public String usuarioEditaGuardar(@PathVariable("id")int id, @ModelAttribute Usuario usuario ) {
      usuarioRepository.actualizarUsuario(id, usuario.getNumeroDocumento(), usuario.getTipoDocumento(), usuario.getNombre(),
      usuario.getDireccionFisica(), usuario.getDireccionElectronica(), usuario.getTelefono(),usuario.getCiudad(),
       usuario.getClave(),usuario.getLogin(),usuario.getCiudad(), usuario.getDepartamento(), usuario.getCodigoPostal());
       return "redirect/usuarios";
  }
  
  @GetMapping("usuarios/{id}/delete")
  public String usuarioEliminar(@PathVariable("id")int id) {
    usuarioRepository.eliminarUsuario(id);
    return "redirect/usuarios";
  }
  
  
  
  
    }
