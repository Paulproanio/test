package com.test.paul.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.paul.entities.ptCliente;
import com.test.paul.entities.ptCuenta;
import com.test.paul.services.ptCuentaService;


@WebMvcTest(ptCuentaController.class)
public class ptCuentaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ptCuentaService service;
	
	private ptCuenta paulCuenta = new  ptCuenta();
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	
	/*@BeforeEach
	 void setUp() {
		ptCliente ptCliente = new ptCliente();
		ptCliente.setContraseniaCliente("123");
		ptCliente.setEstadoCliente(1L);
		ptCliente.setIdentificador("2001478524");
		ptCliente.setNombre("maria");
		ptCliente.setGenero("sucre y cuba");
		ptCliente.setEdad(18L);
		ptCliente.setDireccion("sucre y cuba");
		ptCliente.setTelefono("0984567892");
		
		
		paulCuenta.setNumeroCuenta(1111L);
		paulCuenta.setPtCliente(ptCliente);
		paulCuenta.setSaldoInicial(100.0f);
		
		when(this.service.createptCuenta(paulCuenta)).thenReturn(paulCuenta);
	}
	
	@Test
	void registeredNewAccountsReturn200Ok() throws Exception {
		
		String expectedNumeroCuenta = "1111";
		String jsonRequest = mapper.writeValueAsString(paulCuenta);
		
		this.mockMvc.perform(post("/api/tp/ptCuenta").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(jsonRequest))
		.andDo(print()).andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.numeroCuenta").value(expectedNumeroCuenta));
				//.andExpect(content().json(jsonRequest));
	}*/
}
