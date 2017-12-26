/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.napilnik.someapp.sdk.rest;

/**
 * Jersey REST client generated for REST resource:application [resource]<br>
 * USAGE:
 * <pre>
 *        ResourceJerseyClient client = new ResourceJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author alexr
 */
public class ResourceJerseyClient {

    private javax.ws.rs.client.WebTarget webTarget;
    private javax.ws.rs.client.Client client;
    private static final String BASE_URI = "http://127.0.0.1:8080/";

    public ResourceJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("resource");
    }

    /**
     * @param responseType Class representing the response
     * @return response object (instance of responseType class)
     */
    public <T> T get(Class<T> responseType) throws javax.ws.rs.ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @return response object (instance of responseType class)
     */
    public <T> T post(Class<T> responseType) throws javax.ws.rs.ClientErrorException {
        return webTarget.request().post(null, responseType);
    }

    public void close() {
        client.close();
    }
    
}
