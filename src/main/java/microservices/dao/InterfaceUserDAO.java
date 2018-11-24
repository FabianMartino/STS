package microservices.dao;

import java.util.List;

import microservices.entities.Trabajo;
import microservices.entities.Usuario;

public interface InterfaceUserDAO {
	List<Trabajo> findTrabajosEnviados(Long usuario_id);
		
	Usuario findById(Long usuario_id);

	void createUser(Long usuario_id);
}
		

