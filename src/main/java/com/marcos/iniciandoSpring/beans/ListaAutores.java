package com.marcos.iniciandoSpring.beans;

import java.util.ArrayList;
import java.util.List;

public class ListaAutores {

	
	private static ArrayList<Autor> lista = new ArrayList<Autor>();


	/**
	 * Devuelve un autor en concreto
	 * @param id
	 * @return
	 */
	public static Autor getAutor(int id) {
		
		return lista.get(id);
	}
	
	
	
	/**
	 * Devuleve a todos los autores
	 * @return
	 */
	public static List<Autor> contruirLista() {
		
		Autor autor = new Autor();
		autor.setId(0);
		autor.setNombre("Ket Follet");
		autor.setEdad(70);
		autor.setEmail("kent@educastur.org");
		lista.add(autor);
		

		Autor autor2 = new Autor();
		autor2.setId(1);
		autor2.setNombre("JK Rowling");
		autor2.setEdad(58);
		autor2.setEmail("jk@educastur.org");
		lista.add(autor2);		
		

		Autor autor3 = new Autor();
		autor3.setId(2);
		autor3.setNombre("Perez Reverte");
		autor3.setEdad(62);
		autor3.setEmail("aurturo@educastur.org");
		lista.add(autor3);		
		

		Autor autor4 = new Autor();
		autor4.setId(3);
		autor4.setNombre("Orson Scott Card");
		autor4.setEdad(62);
		autor4.setEmail("orson@educastur.org");
		lista.add(autor4);	
		
		
		return lista;
	}
}
