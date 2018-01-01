package com.jetsoft.platform.utils.jsondeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Deserializer the string value that follows the pattern <b>dd-MM-yyyy HH:mm:ss</b> to
 * {@link LocalDate}.
 * 
 * @author José Júnior <jose.junior@jetsoft.com.br>
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException {

		String date = arg0.getValueAsString();
		DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
        return LocalDateTime.parse(date, format);
	}

}