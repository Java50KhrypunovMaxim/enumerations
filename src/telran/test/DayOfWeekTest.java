package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.time.DayOfWeek;
import telran.time.TypeDisplay;

class DayOfWeekTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	
	void test() {
		assertEquals(0, getOrdinalDayOfWeek(DayOfWeek.MON));
		assertEquals("MON", getNameDayOfWeek(DayOfWeek.MON));
	}
	
	private int getOrdinalDayOfWeek(DayOfWeek day)
	{
		return day.ordinal();
	}
	private String getNameDayOfWeek(DayOfWeek day)
	{
		return day.name();
	}
	
	@Test
	void displayNameTest()
	{
		assertEquals("Fri", DayOfWeek.FRI.displayName(TypeDisplay.SHORT));
		assertEquals("Friday", DayOfWeek.FRI.displayName(TypeDisplay.FULL));
	}
	
	@Test
	void displayValueTest()
	{
		assertEquals(5,DayOfWeek.FRI.getValue());
	}
	
	@Test
	void plusDaysTest()
	{
		assertEquals(DayOfWeek.SAT,DayOfWeek.FRI.plusDays(22) );
	}
	@Test
	void minusDaysTest()
	{
		assertEquals(DayOfWeek.THU,DayOfWeek.FRI.minusDays(22) );
	}
	@Test
	void beetweenTest()
	{
		assertEquals(1,DayOfWeek.FRI.berween(DayOfWeek.SAT));
		assertEquals(6,DayOfWeek.FRI.berween(DayOfWeek.THU));
	}
}
