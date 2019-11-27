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
	
	
	private ListaAutores lista = ListaAutores.getLista();
	
	
	
	/*
	@GetMapping("/start/{nombre}/{edad}")
	public String rutaBasicaInicial(@PathVariable String nombre,
									@PathVariable Integer edad,
									Model model) {
	*/

	
	
	
	
	/*
	 * ************************************
	 * ************************************
	 * ************************************
	 * ************************************
	 * L I S T A N D O    A U T O R E S 
	 * ************************************
	 * ************************************
	 */
	@GetMapping("/")
	public String rutaBasicaInicial(Model model) {
		
		model.addAttribute("autores",lista.getDatos());

		return "hola";
	}
	
	

	
	
	
	
	/*
	 * ************************************
	 * ************************************
	 * ************************************
	 * ************************************
	 * D E T A L L E    A U T O R 
	 * ************************************
	 * ************************************
	 */
	@GetMapping("/autores/{id}")
	public String verAutor(	@PathVariable Integer id,
							Model model) {
		
		Autor autor = lista.getAutor(id);
		model.addAttribute("autor",autor);
		
		return "autor"; //html
	}	
	
	
	
	
	
	

	
	
	/*
	 * ************************************
	 * ************************************
	 * ************************************
	 * ************************************
	 * E L I M I N A N D O    A U T O R E S 
	 * ************************************
	 * ************************************
	 */
	
	@GetMapping("/eliminarAutor/{id}")
	public String eliminarAutor(	@PathVariable Integer id,
									Model model) {
		
		lista.del(id);
		
		/*
		 * ME LO CURRO YO
		 * 
		model.addAttribute("autores",lista.getDatos());
		
		return "hola"; //html
		 */
		return("redirect:/");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * ************************************
	 * ************************************
	 * ************************************
	 * ************************************
	 * A Ñ A D I E N D O     A U T O R E S 
	 * ************************************
	 * ************************************
	 */
	@GetMapping("/nuevoAutor")
	public String nuevoAutor(Model model) {
		
		model.addAttribute("autor",new Autor());
		
		return "nuevoAutor"; // html del formulario nuevo autor		
		
	}
	
	@PostMapping("/addAutor")
	public String addAutor(@ModelAttribute Autor autor) {
		
		lista.addAutor(autor);
		
		return "redirect:/"; 		
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * ************************************
	 * ************************************
	 * ************************************
	 * ************************************
	 * 	E D I T A R     A U T O R E S 
	 * ************************************
	 * ************************************
	 */
	@GetMapping("/editarAutor/{id}")
	public String editarAutor(	@PathVariable Integer id,
								Model model) {
		
		Autor autor = lista.getAutor(id);
		model.addAttribute("autor",autor);
		
		return "editarAutor"; // html del formulario editar autor		
	}

	
	
	
	@PostMapping("/updateAutor")
	public String updateAutor(@ModelAttribute Autor autor) {
		
		lista.updateAutor(autor);
		
		return "redirect:/"; 		
		
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
