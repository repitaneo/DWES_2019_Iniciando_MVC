package com.marcos.iniciandoSpring.rutas;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.iniciandoSpring.beans.Autor;
import com.marcos.iniciandoSpring.beans.ListaAutores;

@Controller
public class RutasBasicas {

	@Autowired
	Autor marcos;
	
	
	@Autowired
	Autor juan;
	
	
	
	
	
	/*
	@GetMapping("/start/{nombre}/{edad}")
	public String rutaBasicaInicial(@PathVariable String nombre,
									@PathVariable Integer edad,
									Model model) {
	*/

	@GetMapping("/")
	public String rutaBasicaInicial(Model model) {
		
		ListaAutores lista = ListaAutores.getLista();
		model.addAttribute("autores",lista.getDatos());

		return "hola";
	}
	
	

	
	
	@GetMapping("/autores/{id}")
	public String verAutor(	@PathVariable Integer id,
							Model model) {
		
		ListaAutores lista = ListaAutores.getLista();
		Autor autor = lista.getAutor(id);
		model.addAttribute("autor",autor);
		
		return "autor"; //html
	}	
	
	
	
	@GetMapping("/nuevoAutor")
	public String nuevoAutor(Model model) {
		
		model.addAttribute("autor",new Autor());
		
		return "nuevoAutor"; 		
		
	}
	
	
	@PostMapping("/addAutor")
	public String addAutor(@ModelAttribute Autor autor) {
		
		System.out.println(autor);
		
		return "redirect:/"; 		
		
	}
	
	
	@GetMapping("/eliminarAutor/{id}")
	public String eliminarAutor(	@PathVariable Integer id,
									Model model) {
		
		ListaAutores lista = ListaAutores.getLista();
		lista.del(id);
		
		
		model.addAttribute("autores",lista.getDatos());
		
		return "hola"; //html
	}		
	
}







/*
 * 	
	@GetMapping("/start/{nombre}/{edad}")
	public String rutaBasicaInicial(@PathVariable String nombre,
									@PathVariable Integer edad,
									Model model,
									HttpServletRequest  request) {
		
		model.addAttribute("nombre",nombre);
		model.addAttribute("edad",edad);
		
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(marcos);
		lista.add(juan);
		model.addAttribute("personas",lista);
		
		

		System.out.println(request.getServerName());
		System.out.println(request.getMethod());
		System.out.println(request.getRemoteAddr());	
		System.out.println(request.getServletPath());
		Enumeration<String>  cols = request.getPathInfo();
		while(cols.hasMoreElements()) {
			
			System.out.println(cols.nextElement());
		}

		
		return "hola";
	}
	*/
