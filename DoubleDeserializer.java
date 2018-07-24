package robertina.renzi.test;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DoubleDeserializer extends JsonDeserializer<Object> {

	@Override
	public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		try {
			Double d = Double.valueOf(p.getText());
			return d;
		} catch (NumberFormatException nfe) {

		}

		return String.valueOf(p.getText());
	}
}