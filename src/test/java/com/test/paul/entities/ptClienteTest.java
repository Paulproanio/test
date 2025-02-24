package com.test.paul.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ptClienteTest {

	ptCliente ptCliente = new ptCliente();
	
	@Test
	void validateSetIdentificacion() {
		String identificacionExpected = "1002712857";
		ptCliente.setIdentificador("1002712857");
		Assertions.assertEquals(ptCliente.getIdentificador(), identificacionExpected);
	}
	
	@Test
	void validateSetAge() {
		long edad = 25;
		ptCliente.setEdad(25L);
		Assertions.assertEquals(ptCliente.getEdad(), edad);
	}
}
