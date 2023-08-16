package telran.date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.UnsupportedTemporalTypeException;

public class NextFriday13 implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
	    if (!temporal.isSupported(ChronoUnit.DAYS)) {
	        throw new UnsupportedTemporalTypeException(null);
	    }
	    
	    DayOfWeek dayOfWeek = DayOfWeek.from(temporal);
	    int dayValue = dayOfWeek.getValue();
	    do {temporal = temporal.plus(1, ChronoUnit.DAYS);
	        dayOfWeek = DayOfWeek.from(temporal);
	        dayValue = dayOfWeek.getValue();}
	    
	    while (dayValue != 5 || temporal.get(ChronoField.DAY_OF_MONTH) != 13); 
	    
	    return temporal;
	}
}
