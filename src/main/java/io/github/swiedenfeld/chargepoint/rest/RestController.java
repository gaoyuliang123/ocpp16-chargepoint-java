package io.github.swiedenfeld.chargepoint.rest;

import io.github.swiedenfeld.chargepoint.ws.OcppWebSocket;
import io.micronaut.context.annotation.Property;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.websocket.WebSocketClient;
import jakarta.inject.Inject;
import reactor.core.publisher.Mono;

@Controller("/chargepoint")
public class RestController {
    
    @Inject WebSocketClient webSocketClient;
    @Property(name = "url") String url;

    @Get("/boot")
    public void boot() {
        OcppWebSocket webSocket = Mono.from(
        webSocketClient.connect(OcppWebSocket.class, url)).block();
        assert webSocket != null;
        webSocket.sendSync("[2, \"19223201\", \"BootNotification\", {\"chargePointVendor\": \"ACME\", \"chargePointModel\": \"WALLBOX\"}]");
    }

}