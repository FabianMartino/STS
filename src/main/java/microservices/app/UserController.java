package microservices.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import microservices.entities.Trabajo;
import microservices.entities.Usuario;
import microservices.service.InterfaceUsuarioService;
import microservices.service.UserServices;

public class UserController {

@RestController
@RequestMapping("user")
public class UsuarioController {
	
	@Autowired
	private InterfaceUsuarioService usuarioService;
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id){
		Usuario user = usuarioService.getUsuario(id);
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	@GetMapping("trabajos/{id}")
	public ResponseEntity<List<Trabajo>> getTrabajosEnviados(@PathVariable("id") Long id){
		List<Trabajo> trabajos = usuarioService.getTrabajosEnviados(id);
		return new ResponseEntity<List<Trabajo>>(trabajos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, produces= "application/json",
	consumes = "application/json")
	public void create(@RequestBody Long user)
	{
		usuarioService.createUser(user);
	}
//	
//	@RequestMapping(method = RequestMethod.GET, produces= "application/json")
//	public List<GeoLocation> findAll() {
//	return service.findAll();
//	}

}
	
}
