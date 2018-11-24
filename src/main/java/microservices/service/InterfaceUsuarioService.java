package microservices.service;

import java.util.List;

import microservices.entities.Trabajo;
import microservices.entities.Usuario;


public interface InterfaceUsuarioService {
	public List<Trabajo> getTrabajosEnviados(Long id);
	
	public Usuario getUsuario(Long id);
	
	void createUser(Long user);
}
