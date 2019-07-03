package com.oscar.demo.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oscar.demo.commons.Messages;
import com.oscar.demo.dto.Client;
import com.oscar.demo.dto.ClientRequest;
import com.oscar.demo.dto.ClientResponse;
import com.oscar.demo.exceptions.BusinessException;
import com.oscar.demo.service.ClientService;


/**
 * ClientsApi class
 * Git push test
 * @author Oscar
 */
@RestController
public class ClientsApi {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ClientService clientService;
	 
	
	// Mapper Dozzer para convertir entre objetos
	@Autowired
	Mapper mapper;
	
	@RequestMapping(value="/clientListById/{idClient}", method=RequestMethod.GET)
	public ClientResponse listById(@PathVariable("idClient") long idClient){

	    if(validateUserExists(idClient)) {
	    Client findById = clientService.listById(idClient);

	    ClientResponse contactResponse= new ClientResponse();
	    contactResponse.setClient(findById);
	    log.info("Usuario listado por ID");
	    return contactResponse;
	    }
	    else{
	    	log.info("Usuario no listado");
	    	throw new BusinessException(Messages.getMessage("messages.serviciosClientes.notFound.list"));
	    }
	}
	
	@RequestMapping(value="/clientCreate", method=RequestMethod.POST)
	public ClientResponse save(@RequestBody @Valid ClientRequest clientRequest){
	    // Mapeo
	    Client client = mapper.map(clientRequest, Client.class);
	    Client updatedClient = clientService.save(client);

	    ClientResponse contactResponse= new ClientResponse();
	    contactResponse.setClient(updatedClient);
	    log.info("Usuario creado");
	    return contactResponse;
	}
	
	
	@RequestMapping(value="/clientUpdate", method=RequestMethod.POST)
	public ClientResponse update(@RequestBody @Valid ClientRequest clientRequest){
	    // Mapeo
	    Client client = mapper.map(clientRequest, Client.class);
	    if(validateUserExists(client.getId())) {
	    Client updatedClient = clientService.update(client);

	    ClientResponse contactResponse= new ClientResponse();
	    contactResponse.setClient(updatedClient);
	    log.info("Usuario actualizado");
	    return contactResponse;
	    }
	    else{
	    	log.info("Usuario no encontrado para actualizar");
	    	throw new BusinessException(Messages.getMessage("messages.serviciosClientes.notFound.update"));
	    }
	}

	
	@RequestMapping(value="/clientDelete/{idClient}", method=RequestMethod.GET)
	public ClientResponse delete(@PathVariable("idClient") long idClient){
	    // Mapeo
	    if(validateUserExists(idClient)) {
	    Client deletedClient = clientService.delete(idClient);

	    ClientResponse contactResponse= new ClientResponse();
	    contactResponse.setClient(deletedClient);
	    log.info("Usuario eliminados");
	    return contactResponse;
	    }
	    else{
	    	log.info("Usuario no encontrado para eliminar");
	    	throw new BusinessException(Messages.getMessage("messages.serviciosClientes.notFound.delete"));
	    }
	}
	
	@RequestMapping(value="/clientList", method=RequestMethod.GET)
	public ClientResponse list(){
	    // Mapeo
	    List<Client> clientes= new ArrayList<Client>();
	    clientes = clientService.list();

	    ClientResponse contactResponse= new ClientResponse();
	    contactResponse.setClientes(clientes);
	    log.info("Usuarios listados");
	    return contactResponse;
	}
	
	public boolean validateUserExists(long id){
		Client client = clientService.listById(id);
		boolean exists=(client!=null) ? true : false;
	    log.info("Usuario existente: "+ exists);
	    if(exists)
		return exists;
	    else
		throw new BusinessException(Messages.getMessage("messages.serviciosClientes.notFound"));
	}
	
	
}