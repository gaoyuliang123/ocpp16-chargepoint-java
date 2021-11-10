package io.github.swiedenfeld.chargepoint.ocpp.messages;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class OcppCall {
	
	int messageTypeId;
	String uniqueId;
	String action;
	Payload payload;
	
}
