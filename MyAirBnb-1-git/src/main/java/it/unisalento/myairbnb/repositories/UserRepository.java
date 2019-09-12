package it.unisalento.myairbnb.repositories;



import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { // interfaccia Dao , primo campo è il nome della
	//classe entities il secondo il tipo della chiave primaria
	// il nome del metodo definisce la qury da effettuare
	
	public List<User> findByName (String name, Sort sort); // possiamo anche ordinare i risultati
	
	@Query("select u from User u where u.name=:name")   //se vogliamo usare una certa query personalizzata
	public List<User> findByNameUsingQuery(@Param("name")String name);  // il nome della query deve essere il parametro di questa funzione
	// repository non ha un metodo built in per prendere byName
	// con questo metdoo capisce che deve cercare per nome 
	// attenzionae al nome di findBy; altrimenti da errore nell'esecuzione
	
	
	public List<User> findByNameAndSurname(String name, String surname)	; //uguale ma con query fatta da noi:
	
	@Query("select u from User u where u.name=:name and u.surname=:surname") //Jquery
	public List<User> findByNameAndSurnameUsingQuery(@Param("name")String name, @Param("surname")String surname);
}
//scrive nel db