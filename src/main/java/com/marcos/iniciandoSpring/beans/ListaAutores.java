package com.marcos.iniciandoSpring.beans;

import java.util.ArrayList;
import java.util.List;

public class ListaAutores {

	
	private ArrayList<Autor> lista = null;
	private static ListaAutores listaAutores = null;
	
	
	private ListaAutores() {
		
		lista = new ArrayList<Autor>();
	}
	


	/**
	 * 
	 * @return
	 */
	public List<Autor> getDatos() {
		
		return lista;
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
	 * Añade un autor a la lista (a.k.a. Modelo)
	 * 
	 * @param autor
	 */
	public void addAutor(Autor autor) {

		
		autor.setId(getIdNoRepetido());
		lista.add(autor);
	}
	
	
	
	
	
	/**
	 * Actualiza un autor buscando primero su posicion en la lista
	 * 
	 * @param autor
	 */
	public void updateAutor(Autor autor) {

		int posicion = buscarDondeEsta(autor.getId());

		
		lista.set(posicion, autor);
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
	 * Petición del singleton
	 * @return
	 */
	public static ListaAutores getLista() {
		
		if(listaAutores==null) {
			
			listaAutores = new ListaAutores();
		}
		
		return listaAutores;
	}
	
		
	
}
