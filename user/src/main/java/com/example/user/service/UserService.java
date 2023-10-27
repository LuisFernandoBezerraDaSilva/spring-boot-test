package com.example.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.entity.User;
import com.example.user.exception.CampoObrigatorioException;
import com.example.user.repository.UserRepository;

@Service
public class UserService implements UserInterface{
	
	private final Logger logger = Logger.getLogger(UserService.class);
	@Autowired
	UserRepository repository;
	
	@Override
	public User consultar(Long id) throws CampoObrigatorioException {
		logger.info("Consultando endereco...");
		User result = repository.findById(id);
		if(result == null){
			logger.error("Erro ao consultar Endereco!");
			throw new CampoObrigatorioException("Endereco Nao encontrado!");
		}
		return repository.findById(id);
	}
	@Override
	public void incluir(User user) throws CampoObrigatorioException {
		logger.info("Incluindo Usuário...");
		repository.save(user);
	}
	@Override
	public void atualizar(User endereco) throws CampoObrigatorioException {
		logger.info("Atualizando endereco...");
		/* Pega o CEP elaborado na função buscaCep,
		 * caso o CEP não seja encontrado de primeira
		 * ira atribuir o primeiro CEP encontrado no algorítimo.
		 */
		User result = repository.findOne(endereco.getId());
		if(result == null){
			logger.error("Erro ao atualizar endereco!");
			throw new CampoObrigatorioException("Endereco Nao encontrado para ser atualizado!");
		}
		repository.save(result);
	}
	@Override
	public void deletar(Long id) throws CampoObrigatorioException {
		logger.info("Deletando endereco...");
		User result = repository.findOne(id);
		if(result == null){
			logger.error("Erro ao deletar Endereco!");
			throw new CampoObrigatorioException("Endereco Nao encontrado para ser excluido!");
		}
		repository.delete(id);
	}
}
