package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.exception.CampoObrigatorioException;

public interface UserInterface {
	
	User consultar(Long id) throws CampoObrigatorioException;
	void incluir(User endereco) throws CampoObrigatorioException;
	void atualizar(User endereco) throws CampoObrigatorioException;
	void deletar(Long id) throws CampoObrigatorioException;
}
