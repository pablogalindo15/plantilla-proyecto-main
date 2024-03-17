package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CuentaController {

    @Autowired 
    private CuentaRepository cuentaRepository;

  @GetMapping("/cuentas")
  public String Cuentas(Model model) {
    model.addAttribute("cuentas",cuentaRepository.darCuentas());
    return "cuentas";
  }

  @GetMapping("/cuentas/new")
  public String cuentasForm(Model model) {
      model.addAttribute("cuentas", new Cuenta());
      return "cuentaNueva";
  }

  @PostMapping("/cuentas/new/save")
  public String cuentaGuardar(@ModelAttribute Cuenta cuenta) {
    cuentaRepository.insertarCuenta(cuenta.getTipo(), cuenta.getNumeroCuenta(), cuenta.getEstado(), cuenta.getIdClienteFK(), cuenta.getSaldo());
      return "redirect:/cuentas";
  }
  
  @GetMapping("/cuentas/{id}/edit")
  public String cuentaEditarForm(@PathVariable("id") int id, Model model) {
    Cuenta cuenta =cuentaRepository.darCuenta(id);
    if (cuenta != null){
        model.addAttribute("cuenta", cuenta);
        return "cuentaEditar";
    }
    else{
        return "redirect/cuentas";
    }
  }

  @PostMapping("cuentas/{id}/edit/save")
  public String cuentaEditaGuardar(@PathVariable("id")int id, @ModelAttribute Cuenta cuenta ) {
      cuentaRepository.actualizarCuenta(cuenta.getTipo(), cuenta.getNumeroCuenta(), cuenta.getEstado(), cuenta.getIdClienteFK(), cuenta.getSaldo());
       return "redirect/cuentas";
  }
  
  @GetMapping("cuentas/{id}/delete")
  public String cuentaEliminar(@PathVariable("id")int id) {
    cuentaRepository.eliminarCuenta(id);
    return "redirect/cuentas";
  }
  
  
  
  
    }
