package com.oscar.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oscar.demo.dto.Client;

/**
 * @author Oscar
 *
 */
@Repository
public interface ClientDao extends JpaRepository<Client, Long>{
	@Query(name = "Client.findActiveClients")
	List<Client> findAllActive(@Param("status") boolean f);
	@Query(name = "Client.findClientId")
	Client findId(@Param("id") long i);
}
