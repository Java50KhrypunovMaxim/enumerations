package telran.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.UnsupportedTemporalTypeException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.date_time.BarMizvaAdjuster;
import telran.date_time.NextFriday13;

class TemperalTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void test() {
		LocalDate birthDateASP = LocalDate.of(1799, 6, 6);
		LocalDate.parse("1799-06-06");
		LocalDate barMizvaAs = birthDateASP.plusYears(130);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM, d EEEE");
		System.out.printf("Birth day of AS is %s\n", birthDateASP.format(dtf));
		System.out.printf("BarMizva of AS is %s\n", barMizvaAs.format(dtf));
		ChronoUnit unit = ChronoUnit.DAYS;
		System.out.printf("Number of %s between %s and %s is %d\n", unit, birthDateASP, barMizvaAs, 
				unit.between(birthDateASP, barMizvaAs) );
	}
	@Test
	@Disabled
	void barMizvaAdjusterTest()
	{
		TemporalAdjuster adjuster = new BarMizvaAdjuster();
		LocalDateTime ldt= LocalDateTime.of(2000, 1, 1, 0, 0);
		LocalDateTime expected = LocalDateTime.of(2013, 1, 1, 0, 0);
		assertEquals(expected, ldt.with(new BarMizvaAdjuster()));
		assertThrows(UnsupportedTemporalTypeException.class, ()-> LocalTime.now().with(adjuster));
	}
	@Test
	@Disabled
	void next13FridayTest()
	{
		TemporalAdjuster adjuster = new NextFriday13();
		LocalDate ld = LocalDate.of(2023, 8, 15);
		LocalDate expected1 = LocalDate.of(2023, 10, 13);
		LocalDate expected2 = LocalDate.of(2024, 9, 13);
		assertEquals(expected1, ld.with(adjuster));
		assertEquals(expected2, expected1.with(adjuster));
	}
	
	@Test
	void instantTest()
	{
		Instant instant  = Instant.ofEpochSecond(0);
		System.out.println(instant);
	}
	
	@Test
	void instantTestZone()
	{
		ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Rome"));
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("d/M/YYYY H:m z");
		System.out.println(zdt.format(dtf));
	}
	@Test
	void dayTimeTest()
	{
		zoneDateTimeTest("Kiev");
	}

	private void zoneDateTimeTest(String cityCountry) {
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("d/M/YYYY H:m zzzz Z");
		for (String zoneId : ZoneId.getAvailableZoneIds())
		{
			if(zoneId.contains(cityCountry)) {
				ZonedDateTime zdt =ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(zoneId));
				System.out.println(zdt.format(dtf));
			}
		}
		
	}

}
