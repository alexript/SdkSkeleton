package net.napilnik.someapp.testserver;

import net.napilnik.someapp.serversimulator.ServerSimulator.pojos.ExampleResponse;

public class BadExampleResponse extends ExampleResponse{
    
    public BadExampleResponse() {
        this.status = "not success";
    }
}
