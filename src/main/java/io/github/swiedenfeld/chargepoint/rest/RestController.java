package io.github.swiedenfeld.chargepoint.rest;

import javax.ws.rs.core.Response;
import io.github.swiedenfeld.chargepoint.ocpp.OcppClient;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/chargepoint")
public class RestController {
    
    private final OcppClient ocppClient;
    
    @Inject
    RestController(OcppClient ocppClient) {
        this.ocppClient = ocppClient;
    }
    
    @Get("/boot")
    public Response boot() {
        ocppClient.sendBootNotification();
        return Response.ok().build();
    }

}