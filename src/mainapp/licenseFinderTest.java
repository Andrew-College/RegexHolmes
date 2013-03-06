package mainapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class licenseFinderTest {

	@Test
	public void testIsCorrectFormat() {
		// Pass
		String test = "00 MH 3";
		assertTrue(licenseFinder.isCorrectFormat(test));
		test = "00 MH 43213";
		assertTrue(licenseFinder.isCorrectFormat(test));
		// Blank
		test = "";
		assertFalse(licenseFinder.isCorrectFormat(test));

		// Failure
		test = "0 MH 6";
		assertFalse(licenseFinder.isCorrectFormat(test));
		test = "00 AZCX 12345";
		assertFalse(licenseFinder.isCorrectFormat(test));
	}

	@Test
	public void testMatchesDescription() {
		// Pass
		String test = "08 WH 9971";
		assertTrue(licenseFinder.matchesDescription(test));

		// Blank
		test = "";
		assertFalse(licenseFinder.matchesDescription(test));

		// Failure
		test = "08 MX 12345";
		assertFalse(licenseFinder.matchesDescription(test));
		test = "08 MH 345";
		assertFalse(licenseFinder.matchesDescription(test));
	}
}
