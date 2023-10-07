package com.sistemaescolar.app.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatosalumnosService {

	@GetMapping(value = "mostrarformularioalumnos")
	public String mostrarFormularioAlumnos() {
		return "alumnosformulario"; //este es el nombre del HTML (ARCHIVO QU ESTAN EN LA CARPETA template) al que quiero mandar llamar siempre es diferente por cada flujo
	}
	
	
}
