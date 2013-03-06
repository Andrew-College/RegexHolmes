package mainapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class licenseFinderTest {
	
	@Test
	public void testIsCorrectFormat() {
		//Pass
		String test = "00 MH 24243";
		assertTrue(licenseFinder.matchesDescription(test));
		
		//Blank
		test = "";
		assertFalse(licenseFinder.matchesDescription(test));
		
		//Failure
		test = "0 MH 4326";
		assertFalse(licenseFinder.matchesDescription(test));
		test = "00 AZCX 12345";
		assertFalse(licenseFinder.matchesDescription(test));
	}

	@Test
	public void testMatchesDescription() {
		//Pass
		String test = "08 MH 12345";
		assertTrue(licenseFinder.matchesDescription(test));
		
		//Blank
		test = "";
		assertFalse(licenseFinder.matchesDescription(test));
		
		//Failure
		test = "08 MX 12345";
		assertFalse(licenseFinder.matchesDescription(test));
		test = "08 MH 345";
		assertFalse(licenseFinder.matchesDescription(test));
	}
}
