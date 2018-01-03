package com.atech.flight.app.templates.flight;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.atech.flight.app.model.Flight;
import com.atech.flight.app.model.FlightStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Generate templates of an {@link Flight} to be use in endpoint tests.
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */

public class FlightTemplateLoader implements TemplateLoader {
	public static final String TO_SAVE = "object-to-save";
	public static final String TO_UPDATE = "object-to-update";
	public static final String NOT_EXISTS = "object-not-exists";
		
	@Override
	public void load() {
		Fixture.of(Flight.class).addTemplate(TO_SAVE, new Rule(){
			{
				add("flightNumber", uniqueRandom("1", "2", "3"));
				add("departureDateTime", LocalDateTime.parse("2017-12-28T09:11:00-03:00", DateTimeFormatter.ISO_DATE_TIME));
				add("arrivalDateTime", LocalDateTime.parse("2017-12-29T19:30:00-03:00", DateTimeFormatter.ISO_DATE_TIME));
				add("status", FlightStatus.LANDED);
			}
		});

		Fixture.of(Flight.class).addTemplate(TO_UPDATE, new Rule(){
			{
				add("id", "1");
				add("flightNumber", uniqueRandom("100", "200", "300"));
				add("departureDateTime", LocalDateTime.parse("2018-12-28T09:11:00-03:00", DateTimeFormatter.ISO_DATE_TIME));
				add("arrivalDateTime", LocalDateTime.parse("2018-12-29T19:30:00-03:00", DateTimeFormatter.ISO_DATE_TIME));
				add("status", FlightStatus.CANCELLED);
			}
		});

		Fixture.of(Flight.class).addTemplate(NOT_EXISTS, new Rule(){
			{
				add("id", "200");
				add("flightNumber", uniqueRandom("1", "2", "3"));
				add("departureDateTime", LocalDateTime.parse("2017-12-28T09:11:00-03:00", DateTimeFormatter.ISO_DATE_TIME));
				add("arrivalDateTime", LocalDateTime.parse("2017-12-29T19:30:00-03:00", DateTimeFormatter.ISO_DATE_TIME));
				add("status", FlightStatus.LANDED);
			}
		});
	}
}
