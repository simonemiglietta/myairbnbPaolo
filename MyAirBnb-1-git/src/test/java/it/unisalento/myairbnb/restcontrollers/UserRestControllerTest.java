package it.unisalento.myairbnb.restcontrollers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.unisalento.myairbnb.entities.User;
import it.unisalento.myairbnb.service.UserService;

@ExtendWith(SpringExtension.class)                       // uguale a mockito.class 
@WebMvcTest(controllers = UserRestController.class)		//avvia app come test solo per controllers (per integrazione)
                                                       // test atomico

public class UserRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;            // strumenti di test mvc forniti da spring mvc, fa chiamate get e post 
	
	@MockBean
	private UserService userServiceMock;
	
	User user;
	
	@Autowired
	private ObjectMapper objectMapper;  // permette conversione oggetti di modello in formato json
	
	
	@BeforeEach
	private void setUp() {
		
		user = new User();
		user.setName("paolo");
		user.setSurname("Fiorentino");			// dati mock 
		user.setEmail("email@gmail.com");
		
		          // metodo post si aspetta dati in formato json				
	}
	
	
	           // testa metodo get
	@Test
	public void getByIdReturnOkTest() throws Exception {
		
		 mockMvc.perform(get("/user/getById/2").content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());   //simula postman
	
		    // aspettati dei dati tipo json
	}
	
	
	      // testa il metodo save
	@Test
	public void saveReturnOk() throws Exception {   
		
		mockMvc.perform(post("/user/save").contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(user)))
		.andExpect(status().isOk()); 
		
	  //  richiesta viene presa in formato stringa (di tipo e contenuto user), e convertita in formato json con mediatype
		
	} 
}