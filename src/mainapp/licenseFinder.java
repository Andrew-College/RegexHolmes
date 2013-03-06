package mainapp;

/*
 * What is going to happen is the input is going to be split here by String.split,
 * Then, if each of the parts are passed through an assertTrue,
 *  if it returns true, then the part is valid(country code, etc., matches)
 *  and is sent into a second assertTrue which compares it to the target description
 *  If this matches, its added to an array 
 *  After all these are done, the results in the array are displayed   
 */
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.util.Date;

import mainapp.fileUtil;

public class licenseFinder {
	public static void main(String[] args) {
		licenseFinder theApp = new licenseFinder();
		theApp.run();
	}

	public void run() {
		String csvFile = "";
		// System.out.println(new File("bin/licenseplates.csv").canRead());
		try {
			csvFile = fileUtil.load("licenseplates.csv", "bin/").toString();
		} catch (Exception e) {
			System.out.println("File not found");
		}
		String[] format = csvFile.split(",");
		ArrayList<String> output = new ArrayList<String>(5);
		long then = System.nanoTime();
		for (int i = 0; i < format.length; i++) {
			if (isCorrectFormat(format[i])) {
				// System.out.println(format[i]+"a");
				if (matchesDescription(format[i])) {
					output.add(formatInput(format[i]));
				}
			}
		}
		long now = System.nanoTime();
		System.out.println(((now - then)/Math.pow(10, 9))+" nanoSecs");
		for(String s: output){
			System.out.println(s);
		}
	}

	public static boolean isCorrectFormat(String input) {
		String countries = "";
		try {
			countries = fileUtil.load("county codes.txt", "bin/").toString();
		} catch (Exception e) {
		}
		// System.out.println(input.matches("[0-9]{2}(\\s|\\t|-)*"+countries+"{1,2}(\\s|\\t|-)*[0-9]{1,5}"));
		return (input.matches("[0-9]{2}(\\s|\\t|-)*" + countries
				+ "{1,2}(\\s|\\t|-)*[0-9]{1,5}")) ? true : false;
	}

	public static boolean matchesDescription(String input) {
		int temp = 0;
		//System.out.println(input);
		input = formatInput(input);
		if (input == null){
			return false;
		}
		//System.out.println(input);
		// Go to the beginning, find a '0'
		String inputTest = input.substring(0, input.indexOf(" ") - 1);
		if (inputTest.matches(".*0.*")) {
			// goto the end, find one '1'
			inputTest = input.substring(input.lastIndexOf(" "));
			if (inputTest.matches(".*1.*")) {
				// get middle bit, test if theres a 'W'
				inputTest = input.substring(input.indexOf(" ") + 1,
						input.lastIndexOf(" "));
				if (inputTest.matches(".*W.*")) {
					// go back to end, test the length
					if (input.lastIndexOf(" ") - input.length() >= 3
							|| input.lastIndexOf(" ") - input.length() <= 5) {
						for (int i = input.lastIndexOf(" ") + 1; i < input
								.length(); i++) {
							temp += Integer.parseInt(String.valueOf(input
									.charAt(i)));
							// System.out.println(temp);
						}
						// Finally, test the sum
						if (temp == 26) {
							return true;
						}
					}
				}
			}
		}
		return false;
		// This could probably be alot shorter but oh well...
	}

	private static String formatInput(String input) {
		if(input.length() == 0){
			System.out.println("Nice try, testing punk");
			return null;
		}
		input = input.replaceAll("(\\s|\\t|-){1,}", "");
		if (String.valueOf(input.charAt(3)).matches("[A-Z]")) {
			return input.substring(0, 2)+" "+input.substring(2,4)+" "+input.substring(4);
		}
		else{
			return input.substring(0, 2)+" "+input.substring(2,3)+" "+input.substring(3);
		}
		//From all that (\/) junk. into this (/\), which is small and all inclusive (and lazy ;))
		/*int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				count++;
			}
		}
		switch (count) {
		case 0:
			if (String.valueOf(input.charAt(3)).matches("[A-Z]")) {
				return input.substring(0, 2)+" "+input.substring(2,4)+" "+input.substring(4);
			}
			else{
				return input.substring(0, 2)+" "+input.substring(2,3)+" "+input.substring(3);
			}
		case 1:
			StringBuilder tempo = new StringBuilder(input);
			String[] spaceFind = input.split(" ");
			if (spaceFind[0].length() == 3) {
				// find the values of the next two characters in [1]
				// and find if theyre both within the ascii alphabet range
				if (spaceFind[1].substring(0, 1).matches("[A-Z][A-Z]")) {
					tempo.insert(spaceFind[0].length() + 2, ' ');
				} else if (String.valueOf(spaceFind[1].charAt(0)).matches(
						"[A-Z]")) {
					tempo.insert(spaceFind[0].length() + 1, ' ');
				}
			} else {
				tempo.insert(3, ' ');
			}
			System.out.println(tempo.toString() + "ye tic");
			return tempo.toString();
		case 2:
			// Making assumption that the spaces are in the right place,
			// otherwise the plate would have been dropped in isCorrectFormat()
			return input.replaceAll("(\\s|\\t|-){1,}", " ");
		default:
			return null;
			// Should never get here, but just incase
			// someone tries to be a genius
		}*/
	}
}
// Handy way of finding last part of license plate;
// input.substring(input.lastIndexOf(" "),input.length()).length()
// (Assumes spaces were used)
