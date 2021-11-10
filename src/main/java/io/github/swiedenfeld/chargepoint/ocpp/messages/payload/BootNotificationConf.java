package io.github.swiedenfeld.chargepoint.ocpp.messages.payload;

import java.time.Instant;
import io.github.swiedenfeld.chargepoint.ocpp.messages.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BootNotificationConf implements Payload {
	
	Status status;
	Instant currentTime;
	int heartbeatInterval;
	
	public enum Status { ACCEPTED, PENDING, REJECTED }
	
}
