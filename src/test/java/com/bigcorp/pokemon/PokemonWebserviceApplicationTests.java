package com.bigcorp.pokemon;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bigcorp.pokemon.model.Hello;

@SpringBootTest
class PokemonWebserviceApplicationTests {

	@Autowired
	Hello hello;

	@Test
	public void testHello() {
		Assertions.assertNotNull(hello);

		hello.setPrenom("Bernard");

		hello.sayHello();
	}

}
