package com.trips.controllers;



import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trips.models.Trip;

import com.trips.services.ITripServices;
import com.trips.services.IRolService;




@Controller	
public class HomeControllers {
	
	
	@Autowired
	private ITripServices tripServices;
	
	@Autowired
	private IRolService rolService;
	
	@GetMapping("/")
	public String mostrarHome (Model model) {
	
		String trip = "Rapel en Volcan";
		Date fechaPublicacion = new Date();
		double costo = 5.0;
		boolean vigente = true;
		
		model.addAttribute("trip", trip);
		model.addAttribute("fechaPublicacion", fechaPublicacion);
		model.addAttribute("costo", costo);
		model.addAttribute("vigente", vigente);
		
		return "home";
		
	}
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		
		List<String> lista = new LinkedList<String>();
		lista.add("En la Montaña");
		lista.add("En la Ciudad");
		lista.add("En los pueblos");
		lista.add("En las playas");
		model.addAttribute("ListadoTrips", lista);
		
		return "listado";
	}
	
		@GetMapping("/detalle")
		public String mostrarDetalle(Model model) {
			Trip trip = new Trip ();
			trip.setNomTrip("Rapel en Volcatenango");
			trip.setDescripcion("Aventa rapel en un circuito conectado en las...");
			trip.setFecha(new Date());
			trip.setCosto(10.0);
			model.addAttribute("trip" , trip);
			
			return "detalle";
		}
		
		@Controller
		public class HomeController {

		    @GetMapping("/tabla")
		    public String mostrarTabla(Model model) {
		        List<Trip> lista = tripServices.buscarTodo();
		        model.addAttribute("trips", lista);
		        return "tabla";
		    }
		}
		
	
	
}
