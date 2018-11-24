package microservices.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import microservices.entities.LugarDeTrabajo;
import microservices.entities.Trabajo;
import microservices.entities.Usuario;

@Transactional
@Repository
public class UsuarioDAO implements InterfaceUserDAO {
		
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Trabajo> findTrabajosEnviados(Long id){
		Usuario user = this.findById(id);
		
		if(user == null) {
			System.out.println("No existe el usuario");
		}
		
		else {		
		Query query = entityManager.createNativeQuery(		
		"SELECT t "
		+ "FROM Trabajo t "
		+ "JOIN t.usuarios a "
		+ "WHERE a.id_user =:id", Trabajo.class);
		query.setParameter("id", id);
		List<Trabajo> result = query.getResultList();
		
		return result;
		
		}
		
		return null;
	}

	@Override
	public Usuario findById(Long id) {
		EntityManager entityManager=EMF.createEntityManager();
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.close();
		return usuario;
	}
	
	public String getUserData(Long id) {
		Usuario usuario = findById(id);
		return usuario.toString();
	}

	@Override
	public void createUser(Long usuario_id) {
		// TODO Auto-generated method stub
		LugarDeTrabajo lt = new LugarDeTrabajo("lugartrab");
		Usuario user = new Usuario("nombre", "apellido", lt);
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
