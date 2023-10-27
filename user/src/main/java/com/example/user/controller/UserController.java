package com.example.user.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.User;
import com.example.user.exception.CampoObrigatorioException;
import com.example.user.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService enderecoService;
	private final Logger logger = Logger.getLogger(UserService.class);
	
	@RequestMapping("/consultar")
	@ResponseBody
	public ResponseEntity<User> consultar(@RequestBody User endereco) throws CampoObrigatorioException{
		logger.info("Rest consultar endereco");
		if(endereco.getId() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para consulta!");
		}
			User resultX = enderecoService.consultar(endereco.getId());
		return new ResponseEntity<User>(resultX, HttpStatus.OK);
	}
	
	@RequestMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<User> atualizar(@RequestBody @Valid User endereco, BindingResult bindingResult) throws CampoObrigatorioException{
		logger.info("Rest atualizar endereco");
		if(bindingResult.hasErrors()){
			throw new CampoObrigatorioException(bindingResult);
		}else if(endereco.getId() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para atualizar!");
		}
		enderecoService.atualizar(endereco);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@RequestMapping("/deletar")
	@ResponseBody
	public ResponseEntity<User> deletar(@RequestBody User endereco) throws CampoObrigatorioException{
		logger.info("Rest deletar endereco");
		if(endereco.getId() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para exclusao!");
		}
		enderecoService.deletar(endereco.getId());
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@RequestMapping("/incluir")
	@ResponseBody
	public ResponseEntity<User> incluir(@RequestBody @Valid User endereco, BindingResult bindingResult) throws CampoObrigatorioException{
		logger.info("Rest incluir endereco");
		if(bindingResult.hasErrors()){
			throw new CampoObrigatorioException(bindingResult);
		}
		enderecoService.incluir(endereco);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}