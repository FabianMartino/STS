package microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.dao.UsuarioDAO;
import microservices.entities.Trabajo;
import microservices.entities.Usuario;

@Service
public class UserServices implements InterfaceUsuarioService{
		
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public List<Trabajo> getTrabajosEnviados(Long id) {
		return usuarioDAO.findTrabajosEnviados(id);
	}

	@Override
	public Usuario getUsuario(Long id) {
		return usuarioDAO.findById(id);
	}
	
	public void createUser(Long iduser) {
		// TODO Auto-generated method stub
		usuarioDAO.createUser(iduser);
	}


}