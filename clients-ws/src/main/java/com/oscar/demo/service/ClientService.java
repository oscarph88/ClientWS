package com.oscar.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscar.demo.dto.Client;
import com.oscar.demo.repository.ClientDao;

@Service
public class ClientService{
	
	@Autowired
    ClientDao dao;

	public Client save(Client cliente) {
		cliente.setStatus(true);
		 return dao.save(cliente);
	}
	
	public Client update(Client cliente) {
		cliente.setStatus(true);
		 return dao.saveAndFlush(cliente);	 
	}
	
	public Client delete(long idCliente) {
		Client cliente=dao.findId(idCliente);
		cliente.setStatus(false);
		 return dao.saveAndFlush(cliente);
	}
	
	public List<Client> list() {
		boolean s=true;;
		return dao.findAllActive(s);
	}
	
	public Client listById(long id) {
		return dao.findId(id);
	}

	
	

}
