package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	private ClienteRepository clienteRepository;
	private EmpleadoRepository empleadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String...arg)
	{
		Collection<Usuario> usuarios = usuarioRepository.darUsuarios();
		for (Usuario u: usuarios)
		{
			System.out.println(u);
		}
		
		Collection<Cliente> clientes = clienteRepository.darClientes();
		for (Cliente c: clientes)
		{
			System.out.println(c);
		}

		Collection<Empleado> empleados = empleadoRepository.darEmpleados();
		for (Empleado e: empleados)
		{
			System.out.println(e);
		}


	}

}
