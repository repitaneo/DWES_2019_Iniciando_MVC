package com.marcos.iniciandoSpring.beans;

import java.util.ArrayList;
import java.util.List;

public class ListaAutores {

	
	private ArrayList<Autor> lista = null;
	private static ListaAutores listaAutores = null;
	
	
	private ListaAutores() {
		
		lista = new ArrayList<Autor>();
		
		Autor autor = new Autor();
		autor.setId(getIdNoRepetido());
		autor.setNombre("Ket Follet");
		autor.setEdad(70);
		autor.setEmail("kent@educastur.org");
		lista.add(autor);
		

		Autor autor2 = new Autor();
		autor2.setId(getIdNoRepetido());
		autor2.setNombre("JK Rowling");
		autor2.setEdad(58);
		autor2.setEmail("jk@educastur.org");
		lista.add(autor2);		
		

		Autor autor3 = new Autor();
		autor3.setId(getIdNoRepetido());
		autor3.setNombre("Perez Reverte");
		autor3.setEdad(62);
		autor3.setEmail("aurturo@educastur.org");
		lista.add(autor3);		
		

		Autor autor4 = new Autor();
		autor4.setId(getIdNoRepetido());
		autor4.setNombre("Orson Scott Card");
		autor4.setEdad(62);
		autor4.setEmail("orson@educastur.org");
		lista.add(autor4);		
		
	}
	


	/**
	 * 
	 * @return
	 */
	public List<Autor> getDatos() {
		
		return lista;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private int getIdNoRepetido() {
		
		int numero = (int)(Math.random()*100)+1;
		
		// busco hasta que no lo encuentro
		while(buscarDondeEsta(numero)>=0) {

			numero = (int)(Math.random()*100)+1;
		}
		return numero;
	}





	/**
	 * Devuleve a todos los autores
	 * @return
	 */
	public static ListaAutores getLista() {
		
		if(listaAutores==null) {
			
			listaAutores = new ListaAutores();
		}
		
		return listaAutores;
	}
	
	
	
	
	
	
	
	/**
	 * Devuelve un autor en concreto, si lo encuentra
	 * @param id
	 * @return
	 */
	public Autor getAutor(int idBuscado) {
		
		// busco donde está en el array
		int dondeEsta = buscarDondeEsta(idBuscado);
		
		// si me devuelve una posición válida
		if(dondeEsta>=0) {
			
			return lista.get(dondeEsta);
		}
		else return null;
	}	
	
	
	
	
	
	
	
	
	
	/**
	 * Borra un objeto
	 * @param idBuscado
	 */
	public void del(int idBuscado) {
		
		// pregunto que si existe el ID
		int dondeEsta = buscarDondeEsta(idBuscado);
		
		// si lo encuentra, lo borra
		if(dondeEsta>=0) {
			
			lista.remove(dondeEsta);
		}
	}
	
	
	
	
	
	
	/**
	 * 
	 * @param idBuscado
	 * @return posición en el arrayList donde se encuentra
	 */
	private int buscarDondeEsta(int idBuscado) {
		
		// iniciamos con una bandera indicando que no está encontrado
		boolean encontrado = false;
		
		
		int indice = 0;
		// mientras que no se encuentra y no llego al final
		while((!encontrado)&&(indice<lista.size())) {
			
			// lo voy buscando
			if(lista.get(indice).getId()==idBuscado) {
				
				encontrado = true;
			}
			// y si no aparece, avanzo
			else indice ++;
		}
		if(encontrado) return indice; else return -1;
	}	
	
}
