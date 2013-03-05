package mainapp;

/*
 * What is going to happen is the input is going to be split here by String.split,
 * Then, if each of the parts are passed through an assertTrue,
 *  if it returns true, then the part is valid(country code, etc., matches)
 *  and is sent into a second assertTrue which compares it to the target description
 *  If this matches, its added to an array 
 *  After all these are done, the results in the array are displayed   
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
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
		for (int i = 0; i < format.length; i++) {
			if(isCorrectFormat(format[i])){
				if(matchesDescription(format[i])){
					output.add(format[i]);
				}
			}
		}
	}

	private boolean matchesDescription(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isCorrectFormat(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
