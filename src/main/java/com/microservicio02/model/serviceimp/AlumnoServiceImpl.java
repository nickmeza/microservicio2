package com.microservicio02.model.serviceimp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicio02.model.entity.Alumno;
import com.microservicio02.model.entity.Registro;
import com.microservicio02.model.service.IRegistroDao;

@Service
public class AlumnoServiceImpl implements IRegistroDao{
	@Autowired
	private RestTemplate clienteRestTemplate;
	@Override
	public List<Registro> readAll() {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = Arrays.asList(clienteRestTemplate.getForObject("http://localhost:9090/listar", Alumno[].class));
		return alumnos.stream().map(a->new Registro(a)).collect(Collectors.toList());
	}

	@Override
	public Registro readyBy(Long id) {
		// TODO Auto-generated method stub
		Map<String, String> datos = new HashMap<String, String>();
		datos.put("id",id.toString());
		Alumno alumno = clienteRestTemplate.getForObject("http://localhost:9090/listar/{id}", Alumno.class,datos);
		return new Registro(alumno);
	}

}
