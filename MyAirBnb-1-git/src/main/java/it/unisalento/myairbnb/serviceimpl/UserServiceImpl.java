package it.unisalento.myairbnb.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.User;
import it.unisalento.myairbnb.exceptions.UserNotFoundException;
import it.unisalento.myairbnb.repositories.UserRepository;
import it.unisalento.myairbnb.service.UserService;

@Service     //specializzazione di component
public class UserServiceImpl implements UserService {   

	// deve implementare TUTTI i metodi dell'interfaccia
	@Autowired
	UserRepository repository;  //iniezione repository
	
	@Override
	@Transactional      // gestisce transazioni 
	public User saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);     //
	}

	@Override
	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll(); // getall è gia implementata di default
		
	}

	@Override
	@Transactional
	public List<User> getByEmail(String email) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	@Transactional(rollbackFor = UserNotFoundException.class)  // se qualcosa va storto nel db, ripristina il valore precedente di user
	public User getById(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		/**
		User user= repository.getOne(id); //  primo modo di getByid
		if (user==null) {

			throw new UserNotFoundException();  // controlla che l'id esista (non sia nullo)		
		}else {
			
			return user;
		}
		
		// secondo metodo         optional è un oggetto che può essere anche null
		Optional<User> optional= repository.findById(id);  //di java.utils
		if (optional.isPresent()) {
			return optional.get();
			
		}
		else {
			throw new UserNotFoundException();
		}
		**/
		//  terzo modo
		
		return repository.findById(id).orElseThrow(()-> new UserNotFoundException());
		//  repository.findById(id) ritorna optional, se è null lancia ()-> new UserNotFoundException()
		// () è la funzione passata (nessuna)
								
	}

	@Override
	@Transactional	
	public List<User> getByName(String name) {
		Sort sort = new Sort(Sort.Direction.DESC, "iduser"); // ordina in modo decrescente per id (è il nome dell id in user entities)
		return repository.findByName(name, sort); // creato da noi nell'interfaccia userRepository
		// TODO Auto-generated method stub
		
				
	}

	
	@Override
	@Transactional(rollbackFor = UserNotFoundException.class)
	
	public void delete(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
		User user = repository.findById(id).orElseThrow(()-> new UserNotFoundException()); // verifica esista user come prima
		repository.delete(user);
			
	}

	
	@Override
	@Transactional

	public List<User> getByNameAndSurname(String name, String surname) {
		// TODO Auto-generated method stub
		
		return repository.findByNameAndSurname(name, surname);
	
	}

	@Override
	@Transactional
	public Page<User> getAll(int page, int size) {
		// TODO Auto-generated method stub
		
		Pageable pageable = PageRequest.of(page, size);
		// visualizza size elementi per pagina, e page è il numero della pagina da visualizzare
		// serve se ci sono molti utenti
		
		
		return repository.findAll(pageable);
	}

	
	

}
//classe che permette di usare repositories = logica -->dao