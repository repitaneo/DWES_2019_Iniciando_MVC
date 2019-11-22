package com.marcos.iniciandoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.marcos.iniciandoSpring.beans.Autor;

import java.util.ArrayList;
import java.util.List;



@SpringBootApplication
public class IniciandoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IniciandoSpringApplication.class, args);
	}

	
	
	@Bean
	public Autor juan() {
		
		Autor persona1 = new Autor();
		persona1.setNombre("Juan");
		persona1.setEdad(25);
		
		return persona1;		
	}
	
	
	@Bean 
	public Autor marcos() {
		
		Autor persona1 = new Autor();
		persona1.setNombre("Marcos");
		persona1.setEdad(28);
		
		return persona1;		
	}
		
}
