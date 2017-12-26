/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.napilnik.someapp.sdk.api;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import net.napilnik.someapp.sdk.model.ResourceResponse;
import net.napilnik.someapp.sdk.rest.ResourceJerseyClient;

/**
 *
 * @author alexr
 */
public class ResourceClient extends ResourceJerseyClient {

    public ResourceClient(String baseUri) {
        try {
            init(baseUri);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public ResourceResponse get() throws ClientErrorException {
        return super.get(ResourceResponse.class); 
    }

    private static final Logger LOGGER = Logger.getLogger(ResourceClient.class.getName());

    private void init(String baseUri) throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        Client newClient = javax.ws.rs.client.ClientBuilder.newClient();
        WebTarget webTarget = newClient.target(baseUri).path("resource");

        Field clientField = ResourceJerseyClient.class.getDeclaredField("client");
        clientField.setAccessible(true);
        clientField.set(this, newClient);

        Field webTargetField = ResourceJerseyClient.class.getDeclaredField("webTarget");
        webTargetField.setAccessible(true);
        webTargetField.set(this, webTarget);
    }
}
