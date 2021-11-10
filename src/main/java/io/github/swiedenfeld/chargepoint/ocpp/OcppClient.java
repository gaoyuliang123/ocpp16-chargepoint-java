package io.github.swiedenfeld.chargepoint.ocpp;

import io.github.swiedenfeld.chargepoint.ocpp.messages.OcppCall;
import io.github.swiedenfeld.chargepoint.ocpp.messages.OcppMessageFactory;
import io.github.swiedenfeld.chargepoint.ws.OcppWebSocket;
import io.micronaut.context.annotation.Property;
import io.micronaut.websocket.WebSocketClient;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Singleton
@Slf4j
public class OcppClient {
	
	private final WebSocketClient webSocketClient;
	private final String url;

	private OcppWebSocket webSocket;
	private OcppMessageFactory factory;
	
	@Inject
	public OcppClient(WebSocketClient webSocketClient,
					  OcppMessageFactory ocppMessageFactory,
					  @Property(name = "url") String url) {
		this.webSocketClient = webSocketClient;
		this.factory = ocppMessageFactory;
		this.url = url;
	}
	
	public void sendBootNotification() {
		sendOcppCall(factory.createBootNotification());
	}
	
	private void sendOcppCall(OcppCall ocppCall) {
		if (webSocketIsClosed()) {
			openWebSocket();
		}
		try {
			webSocket.sendSync(ocppCall);
		} catch (Exception e) {
			log.info("Oops, that messed up. Closing websocket. Please try again.", e);
			webSocket = null;
		}
	}
	
	private boolean webSocketIsClosed() {
		return this.webSocket == null;
	}
	
	private void openWebSocket() {
		this.webSocket = Mono.from(webSocketClient.connect(OcppWebSocket.class, url)).block();
	}
	
}
