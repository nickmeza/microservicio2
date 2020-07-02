package com.microservicio02.model.service;

import java.util.List;

import com.microservicio02.model.entity.Registro;

public interface IRegistroDao {
	public List<Registro> readAll();
	public Registro readyBy(Long id);
}
