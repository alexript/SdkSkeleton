/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.napilnik.someapp.sdk.api;

import com.codahale.metrics.JmxReporter;
import java.net.URI;
import static net.napilnik.someapp.sdk.api.Constants.EXAMPLE_SERVER_BASE_URL;
import net.napilnik.someapp.sdk.model.ResourceResponse;
import net.napilnik.someapp.serversimulator.ServerSimulator.Main;
import static net.napilnik.someapp.serversimulator.ServerSimulator.Main.METRIC_REGISTRY;
import static net.napilnik.someapp.serversimulator.ServerSimulator.Main.getBaseUri;
import static net.napilnik.someapp.serversimulator.ServerSimulator.Main.startServer;
import net.napilnik.someapp.serversimulator.ServerSimulator.providers.GsonProvider;
import net.napilnik.someapp.serversimulator.ServerSimulator.routes.Resource;
import net.napilnik.someapp.testserver.BadResponseResource;
import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
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

    @Test
    public void testGet() {
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://127.0.0.1:8080/"), new ResourceConfig(Resource.class));
        System.out.println("get");
        String expResult = "success";
        ResourceResponse result = client.get();
        if (server != null) {
            server.shutdown();
        }
        assertEquals("Result should be success", expResult, result.status);
    }

    @Test
    public void testBadGet() {
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://127.0.0.1:8080/"), new ResourceConfig(BadResponseResource.class));
        System.out.println("get");
        String expResult = "success";
        ResourceResponse result = client.get();
        if (server != null) {
            server.shutdown();
        }

        assertNotEquals("Result should not be success", expResult, result.status);

    }

}
