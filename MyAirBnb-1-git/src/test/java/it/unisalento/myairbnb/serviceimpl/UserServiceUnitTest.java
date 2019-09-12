package it.unisalento.myairbnb.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.BDDMockito.Then;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import it.unisalento.myairbnb.entities.User;
import it.unisalento.myairbnb.service.UserService;

@ExtendWith(MockitoExtension.class) // abilita mockito
@SpringBootTest        // avvia applicazione come test (importante!!)


public class UserServiceUnitTest {
	
	@Mock    // se uso autowired creo istanza reale (scrivo veramente nel DB)
	private  UserService userServiceMock;  // contenuto salvato da UserService non viene salvato nel db ma come mock
	
	
	private User user;
	
	@BeforeEach
	private void Setup() {     //aggiunto dopo
		
		user = new User();
		user.setName("prova name");           //pre condizioni test
		user.setSurname("prova surname");
		user.setEmail("proba@email.com");
	}
	
	
	@Test
	public void saveUserTest() {  //testiamo metodo test della classe userService
		
		//User user = new User();
		  
		
		
		when(userServiceMock.saveOrUpdate(user)).thenReturn(user);   //quando viene chiamato il metodo save della classe mock ritornami un valore

		int id = userServiceMock.saveOrUpdate(user).getIduser(); // effettua chiamata e vedi l'id
		
		assertThat(id).isNotNull();  // condizione da verificare per superare il test
		
		
		
	}

}
