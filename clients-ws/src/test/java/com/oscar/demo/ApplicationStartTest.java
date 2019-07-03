package com.oscar.demo;



import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oscar.demo.dto.Client;
import com.oscar.demo.repository.ClientDao;




@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationStartTest {
  @Test
  public void applicationStarts() {
	  ClientsWsApplication.main(new String[] {});
  }
  
  @Autowired
  private ClientDao clientService;
  
  @Test
  public void save() {
	  //firstName": "Oscar", "lastName": "Padron","1988-10-30"
    Client client = new Client();
    client.setFirstName("Oscar");
    client.setLastName("Padron");
    SimpleDateFormat dateformat2 = new SimpleDateFormat("YYY-MM-DD");
    try {
		client.setBirthDate(dateformat2.parse("1988-10-30"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    //clientService.save(client);
    Client clientResponse = clientService.save(client);
    //assertThat(clientResponse.getFirstName()).isEqualTo("Oscar");
    assertThat(clientResponse.getBirthDate()).isNotNull();
  }
}