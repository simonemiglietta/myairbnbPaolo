package it.unisalento.myairbnb.restcontrollers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import it.unisalento.myairbnb.dto.UserDTO;
import it.unisalento.myairbnb.entities.User;
import it.unisalento.myairbnb.exceptions.UserNotFoundException;
import it.unisalento.myairbnb.repositories.UserRepository;
import it.unisalento.myairbnb.service.UserService;

@RestController
@RequestMapping("/user")
//@CrossOrigin()      // CORS si specifica manualmente origini sicure accettate dal web browser
public class UserRestController { // metodo per salvare dati utente

	@Autowired
	UserService userService;  // specifica il service univoco che userà (tipo var. globale)
	
	
	
	
	@PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE) 
	//consumes si usa per il post , specifica il formato dati inviato dall'utente
	
	
	public User post(@RequestBody @Valid UserDTO userDTO) {  
		
		//oggetto contenuto nel body convertilo in oggetto java
		//@valid permette di specificare validation definiti in DTO
		
		userDTO.setId(457); // l'id viene restituito dal sistema e non dall'utente
		User user = new User();
		
		
		user.setBirthdate(new Timestamp(0));
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setEmail(userDTO.getEmail());    

		userService.saveOrUpdate(user);    
			
		return userService.saveOrUpdate(user);
		
			
	}
	
	
	@PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public User update(@RequestBody @Valid UserDTO userDTO) throws UserNotFoundException {
		
		if (userDTO.getId() !=0) {
		User user = new User();
		user.setBirthdate(new Timestamp(0));
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setEmail(userDTO.getEmail());    
		user.setIduser(userDTO.getId());
		userService.saveOrUpdate(user);
		return userService.saveOrUpdate(user);
		
		}else
		{
			throw new UserNotFoundException();
		}
	} 

	
	
	
	
	
	// metodo per tornare utente dato id
	@GetMapping(value="/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO get(@PathVariable int id) throws UserNotFoundException{  //aggiungiamo eventuale eccezione
		
		User user= userService.getById(id);
		UserDTO userDTO= new UserDTO();
		userDTO.setId(user.getIduser());
		userDTO.setDataNascita(new Date(user.getBirthdate().getTime()));
		
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
		userDTO.setSurname(user.getSurname());
		return userDTO;
		
		
		}
	
	@GetMapping(value= "/getAll", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<UserDTO> getAll(){ //ritorna tutti gli user (una lista)
		 
		
		// niente più dati moke
		List<User> list = userService.getAll();
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		for (User user : list) {
			UserDTO userDTO= new UserDTO();
			userDTO.setId(user.getIduser());
			userDTO.setDataNascita(new Date(user.getBirthdate().getTime()));
			
			userDTO.setEmail(user.getEmail());
			userDTO.setName(user.getName());
			userDTO.setSurname(user.getSurname());
			dtoList.add(userDTO);
			
		}
		
		return dtoList;
	}
	@GetMapping(value="/getByName/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> getByName(@PathVariable String name){
		List<User> list = userService.getByName(name);
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		for (User user : list) {
			UserDTO userDTO= new UserDTO();
			userDTO.setId(user.getIduser());
			userDTO.setDataNascita(new Date(user.getBirthdate().getTime()));
			
			userDTO.setEmail(user.getEmail());
			userDTO.setName(user.getName());
			userDTO.setSurname(user.getSurname());
			dtoList.add(userDTO);
			
		}
		return dtoList;
		
	}
	
	@GetMapping(value="/getByNameAndSurname/{name}&{surname}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> getByNameAndSurname(@PathVariable String name,@PathVariable String surname){
		List<User> list = userService.getByNameAndSurname(name, surname);
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		for (User user : list) {
			UserDTO userDTO= new UserDTO();
			userDTO.setId(user.getIduser());
			userDTO.setDataNascita(new Date(user.getBirthdate().getTime()));
			
			userDTO.setEmail(user.getEmail());
			userDTO.setName(user.getName());
			userDTO.setSurname(user.getSurname());
			dtoList.add(userDTO);
			
		}
		return dtoList;
		
	}

}
