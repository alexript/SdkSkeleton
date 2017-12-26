/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.napilnik.someapp.sdk.api;

import static net.napilnik.someapp.sdk.api.Constants.EXAMPLE_SERVER_BASE_URL;
import net.napilnik.someapp.sdk.model.ResourceResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexr
 */
public class ResourceClientTest {
    
    public ResourceClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private ResourceClient client;
    
    @Before
    public void setUp() {
        client = new ResourceClient(EXAMPLE_SERVER_BASE_URL);
    }
    
    @After
    public void tearDown() {
        client.close();
    }

    /**
     * Test of get method, of class ResourceClient.
     */
    @org.junit.Test
    public void testGet() {
        System.out.println("get");
        String expResult = "success";
        ResourceResponse result = client.get();
        assertEquals("Result should be success", expResult, result.status);
       
    }
    
}
