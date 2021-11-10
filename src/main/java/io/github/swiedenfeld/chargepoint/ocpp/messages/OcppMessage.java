package io.github.swiedenfeld.chargepoint.ocpp.messages;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = OcppCallDeserializer.class)
@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class OcppMessage {
	
	int messageTypeId;
	String uniqueId;
	String action;
	Payload payload;
	
}
