package com.ruano.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruano.demo.models.ModeloJson;

//@Controller
@RestController
public class ControllerWeb {

	@RequestMapping(value = "/consultar/usuario", method = RequestMethod.POST)
	public ResponseEntity<String> mostrarpagAnterior(@RequestBody ModeloJson input) {
		String resultado = "";
		if(input.getDocumento().equals("10121314") && input.getTipoDocument().equals("c")) {
			resultado = "{ \"mensaje\":\"El usuario si esta registrado.\", \"users\":[{\"firstname\":\"Pepe\",\"secondname\":\"Anderson\",\"lastname\":\"Perez\",\"sendlastname\":\"Gutierrez\",\"telefono\":\"5550102\",\"dirección\":\"Av siempre vida 123\",\"ciudad\":\"Springfield\"}]}";
			return new ResponseEntity<String>(resultado, HttpStatus.OK);
		} else {
			resultado = "{ \"mensaje\":\"El usuario no se encuentra.\"}";
			return new ResponseEntity<String>(resultado, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/consultar/empleado", method = RequestMethod.GET)
	public ResponseEntity<String> mostrarpagAnterior() {
		String resultado = "{ \"mensaje\":\"No hay datos de entrada para consultar.\"}";
		return new ResponseEntity<String>(resultado, HttpStatus.OK);
	}
}
