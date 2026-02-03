package com.instituto.equipo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.instituto.equipo.model.Jugador;
import com.instituto.equipo.repository.JugadorRepository;
@RestController
@RequestMapping("/aplicacion/jugador")

public class JugadorController {
	@Autowired
	private JugadorRepository repositorio;
	
	//GET: http://localhost:8080/aplicacion/jugador
	@GetMapping
	public List<Jugador> listarTodos(){
		return repositorio.findAll();
	}
	
	//POST: http://localhost:8080/aplicacion/jugador
	@PostMapping
	public Jugador guardarJugador(@RequestBody Jugador nuevo) {
		return repositorio.save(nuevo);
	}
}
