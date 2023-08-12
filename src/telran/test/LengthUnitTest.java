package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.HW.LengthUnit;
import telran.measure.Length;

class LengthUnitTest {

	Length length1 = new Length(1, LengthUnit.KM);
	Length length2 = new Length(500, LengthUnit.M);
	Length l3 = new Length(50000, LengthUnit.CM);
	Length length4 = new Length(1000, LengthUnit.M);
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testEqualsObject() {
	assertEquals(length2, l3);
	assertNotEquals(length1, length2);
	assertEquals(length1, length4);
	}
	
	@Test
	void testCompareTo() {
	assertTrue(length2.compareTo(length1) < 0);
	assertTrue(length1.compareTo(length2) > 0);
	}
}
