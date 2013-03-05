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
import java.util.regex.*;
import mainapp.fileUtil;

public class licenseFinder {
	public static void main(String[] args) {
		licenseFinder theApp = new licenseFinder();
		theApp.run();
	}

	public void run() {
		StringBuilder csvFile = new StringBuilder();
		try {
			csvFile = fileUtil.load("licenseplates.csv", "");
		} catch (Exception e) {
			System.out.println("nope.mp4");
		}
//		String[] format =   csvFile.split(",");
	//	for(int i = 0; i < format.length; i++){
			System.out.println(csvFile);
		//}
	}
}
