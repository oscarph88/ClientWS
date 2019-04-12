package com.oscar.demo;


import static org.junit.Assert.assertTrue;
import org.junit.Test;



public class TestService extends TestBase{ 

    @Test
    public void contextLoads() {
        assertTrue(template.getForEntity("/actuator/health", String.class).getStatusCode().is2xxSuccessful());
    }
    @Test
    public void test_is_server_up() {
        assertTrue(template.getForEntity("/actuator/health", String.class).getStatusCode().is2xxSuccessful());

    }

}
