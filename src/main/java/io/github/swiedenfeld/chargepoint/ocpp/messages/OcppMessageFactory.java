package io.github.swiedenfeld.chargepoint.ocpp.messages;

import java.util.concurrent.atomic.AtomicLong;
import io.github.swiedenfeld.chargepoint.ocpp.messages.payload.BootNotification;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class OcppMessageFactory {
	
	private final String chargePointVendor;
	private final String chargePointModel;
	
	private final AtomicLong uniqueidCounter = new AtomicLong(1);
	
	@Inject
	public OcppMessageFactory(@Value("${chargepoint.vendor}") String chargePointVendor,
							   @Value("${chargepoint.model}") String chargePointModel) {
		this.chargePointVendor = chargePointVendor;
		this.chargePointModel = chargePointModel;
	}
	
	public OcppCall createBootNotification() {
		final int messageTypeId = 2;
		final String uniqueId = String.valueOf(uniqueidCounter.getAndIncrement());
		final String action = "BootNotification";
		final Payload payload = new BootNotification(chargePointVendor, chargePointModel);
		return new OcppCall(messageTypeId, uniqueId, action, payload);
	}
	
}
