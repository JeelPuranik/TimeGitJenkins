package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class TimeTest {
@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05:000");
		assertTrue("The seconds were not calculated properly", seconds == 18305);
	}

	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,()->{Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetTotalSecondsBoundary() {
		int seconds = Time.getTotalSeconds("10:59:59:000");
		assertTrue("The seconds were not calculated properly", seconds == 39599);
	}

	@ParameterizedTest
	@ValueSource(strings = {"08:01:00:000", "08:01:59:999", "08:01:25:155" })
	void testGetMinutesGoodAndBoundary(String timeString) {
		int minutes = Time.getTotalMinutes(timeString);
		assertTrue("The Minutes were not calculated properly", minutes== 1);
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class,()->{Time.getTotalMinutes("10");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"08:00:00:000", "08:59:59:999", "08:10:36:241" })
	void testGetHoursGoodAndBoundary(String timeString) {
		int hours = Time.getTotalHours(timeString);
		assertTrue("The Hours were not calculated properly", hours== 8);
	}
	
	@Test
	void testGetTotalHoursBad() {
		assertThrows(NumberFormatException.class,()->{Time.getTotalHours("abjd");});
	}
	@Test
	void testGetMillisecondsBad() {
		assertThrows(NumberFormatException.class,()->{Time.getTotalHours("avdw1c");});

	}
	@Test
	void testGetMillisecondsBoundary() {
		int milliseconds = Time.getMilliSeconds("10:59:59:001");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 1);
	}
	
	@Test
	void testGetMillisecondsGood() {
		int milliseconds = Time.getMilliSeconds("05:05:05:024");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 24);
	}
	
//	@Test
//	void testGetGradtuationYearGood() throws InvalidStartingMonthException {
//		int Year = Time.whenWillIGraduate(1, "January");
//		assertTrue("Year Calculated correctly", Year == 2);
//	}
//	
//	@Test
//	void testGetGradtuationYearBad() {
//		//int Year = Time.whenWillIGraduate(2, "March");
//		assertThrows(InvalidStartingMonthException.class, ()->{Time.whenWillIGraduate(1, "March");});
//		
//	}
//		
	
//	@Test
//	void testGetVacationDaysBoundary() {
//		int days = Time.calculateVacationDays(1, 1);
//		assertTrue("The Hours were not calculated properly", days== 5);
//	}
//	
//	@Test 
//	void testGetVacationDaysBoundary2() {
//		int days = Time.calculateVacationDays(24, 9);
//		assertTrue("The Hours were not calculated properly", days== 60);
//	}
	
	
	
	
}
