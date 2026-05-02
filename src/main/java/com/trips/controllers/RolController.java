package com.trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trips.models.Rol;
import com.trips.services.IRolService;

@Controller
@RequestMapping("/roles")
public class RolController {
	
	@Autowired
	private IRolService rolService;

    @GetMapping("")
    public String mostrarRoles(Model model) {
        model.addAttribute("roles", rolService.buscarTodos());
        return "roles";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idRol, Model model) {

        Rol rol = rolService.buscarPorId(idRol);
        model.addAttribute("rol", rol);

        return "roles/detalle";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idRol) {

        rolService.eliminar(idRol);

        return "redirect:/roles";
    }
}