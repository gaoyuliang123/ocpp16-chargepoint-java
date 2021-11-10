package io.github.swiedenfeld.chargepoint.ocpp.messages.payload;

import io.github.swiedenfeld.chargepoint.ocpp.messages.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BootNotification implements Payload {

	String chargePointVendor;
	String chargePointModel;

}
