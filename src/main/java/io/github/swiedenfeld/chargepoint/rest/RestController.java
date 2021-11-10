package io.github.swiedenfeld.chargepoint.rest;

import io.github.swiedenfeld.chargepoint.ocpp.OcppClient;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/chargepoint")
public class RestController {
    
    private final OcppClient ocppClient;
    
    @Inject
    RestController(OcppClient ocppClient) {
        this.ocppClient = ocppClient;
    }
    
    @Post("/boot")
    public HttpResponse<?> boot() {
        ocppClient.sendBootNotification();
        return HttpResponse.ok();
    }
    
    @Post("/authorize")
    public HttpResponse<?> authorize() {
        ocppClient.sendAuthorize();
        return HttpResponse.ok();
    }

}