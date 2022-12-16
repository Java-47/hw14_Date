package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.time.tools.DateOperation;

class DateOperationTest {

	@Test
	void testGetAge() {
		assertEquals(61, DateOperation.getAge("12/04/1961"));
		assertEquals(60, DateOperation.getAge("1961-12-31"));
	}

	@Test
	void testSortStringDate() {
		String[] dates = { "2000-12-01", "10/12/2000", "1970-08-12", "2010-10-05" };
		String[] expected = { "1970-08-12", "2000-12-01", "10/12/2000",  "2010-10-05" };
		String[] actual = DateOperation.sortStringDate(dates);
		assertArrayEquals(expected, actual);
	}

}
