package io.github.swiedenfeld.chargepoint.ocpp.messages;

import java.util.concurrent.atomic.AtomicLong;
import io.github.swiedenfeld.chargepoint.ocpp.messages.payload.Authorize;
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
	
	public OcppMessage createBootNotification() {
		return new OcppMessage(2, String.valueOf(uniqueidCounter.getAndIncrement()), "BootNotification", new BootNotification(chargePointVendor, chargePointModel));
	}
	
	public OcppMessage createAuthorize() {
		return new OcppMessage(2, String.valueOf(uniqueidCounter.getAndIncrement()), "Authorize", new Authorize("0fe673"));
	}
	
}
