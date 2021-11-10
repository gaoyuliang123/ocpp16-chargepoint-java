package io.github.swiedenfeld.chargepoint.ocpp.messages;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.github.swiedenfeld.chargepoint.ocpp.messages.payload.BootNotificationConf;

public class OcppCallDeserializer extends StdDeserializer<OcppMessage> {
	
	public OcppCallDeserializer() {
		super(OcppMessage.class);
	}
	
	protected OcppCallDeserializer(Class<?> vc) {
		super(vc);
	}
	
	@Override
	public OcppMessage deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
		final OcppMessage ocppCall = new OcppMessage();
		ArrayNode node = jp.getCodec().readTree(jp);
		final JsonNode messageTypeId = node.get(0);
		ocppCall.setMessageTypeId(messageTypeId.asInt());
		final JsonNode uniqueId = node.get(1);
		ocppCall.setUniqueId(uniqueId.asText());
		final JsonNode action = node.get(2);
		ocppCall.setAction(action.asText());
		final JsonNode payload = node.get(3);
		if ("BootNotification".equals(action.asText())) {
			BootNotificationConf bootNotification = jp.getCodec().treeToValue(payload, BootNotificationConf.class);
			ocppCall.setPayload(bootNotification);
		}
		return ocppCall;
	}
	
}
