package io.github.swiedenfeld.chargepoint.ws;

import io.micronaut.websocket.annotation.ClientWebSocket;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import lombok.extern.slf4j.Slf4j;

@ClientWebSocket(subprotocol = "ocpp1.6")
@Slf4j
public abstract class OcppWebSocket implements AutoCloseable {

    @OnOpen
    public void onOpen(){
        log.info("Connection opened");
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("Received {}", message);
    }

    public abstract void sendSync(String message);

}