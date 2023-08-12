package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.measure.WeigthUnit;

class WeigthUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void convertTest() {
		assertEquals(0.01f, WeigthUnit.KG.convert(WeigthUnit.TN, 10), 0.01);
	}

}
