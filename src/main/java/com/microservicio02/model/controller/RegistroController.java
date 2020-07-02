package com.microservicio02.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio02.model.entity.Registro;
import com.microservicio02.model.service.IRegistroDao;

@RestController
public class RegistroController {
	@Autowired
	private IRegistroDao iRegistroDao; 
	@GetMapping("/listar")
	public List<Registro> listar(){
		return iRegistroDao.readAll();
	};
	
	@GetMapping("listar/{id}")
	public Registro registrar(@PathVariable Long id) {
		return iRegistroDao.readyBy(id);
	}
}
