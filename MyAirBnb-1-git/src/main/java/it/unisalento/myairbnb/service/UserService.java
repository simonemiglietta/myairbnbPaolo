package it.unisalento.myairbnb.service;





import java.util.List;

import org.springframework.data.domain.Page;


import it.unisalento.myairbnb.entities.User;
import it.unisalento.myairbnb.exceptions.UserNotFoundException;

public interface UserService {  
	
	//  interfaccia , disaccoppia restcontroller da oggetti di persistenza
	// nei restcontroller compare dipendenz da interfaccia e non da servizio, per cui eventuali modifiche al servizio
	//non intaccano direttamente i restcontroller
	
	public User saveOrUpdate(User user);
	
	public List<User> getAll();  // metodi per avere diverse informaziono sull'utente in base a diversi input
	
	public List<User> getByEmail(String email);
	
	public User getById(int id) throws UserNotFoundException;     // una get per id, univoco, se id non esiste lancia un eccezione
	
	public List<User> getByName(String name);
	
	public void delete(int id) throws UserNotFoundException;
	
	public List<User> getByNameAndSurname(String name, String surname);
	
	public Page<User> getAll(int page, int size);
	
	
}
