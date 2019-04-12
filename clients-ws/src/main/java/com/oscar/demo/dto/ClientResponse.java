package com.oscar.demo.dto;

import java.util.List;

public class ClientResponse {
	
	private Client client;
	List<Client> clientes;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Client> getClientes() {
		return clientes;
	}
	public void setClientes(List<Client> clientes) {
		this.clientes = clientes;
	}

	
}