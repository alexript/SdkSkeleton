/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.napilnik.someapp.examples;

import static net.napilnik.someapp.examples.Constants.EXAMPLE_SERVER_BASE_URL;
import net.napilnik.someapp.sdk.api.ResourceClient;
import net.napilnik.someapp.sdk.model.ResourceResponse;

/**
 *
 * @author alexr
 */
public class ResourceExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ResourceClient client = new ResourceClient(EXAMPLE_SERVER_BASE_URL);
        ResourceResponse response = client.get();
        client.close();
        System.out.println("Response status is: " + response.status);
    }
    
}
