import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class FileUtility 
{
	public static void save(String contents, 
			String filename, String path) 
			throws IOException
	{
		//page.html, c:\\temp\\, "<html></html>"
		File fileOut = new File(path + filename);
		if(fileOut.exists() == false)
			fileOut.createNewFile();
		
		if(fileOut.exists() && fileOut.canWrite())
		{
			BufferedWriter buff = new BufferedWriter(new FileWriter(fileOut));
			PrintWriter writeOut = new PrintWriter(buff);
			writeOut.println(contents);
			writeOut.flush();
			writeOut.close();
		}
	}
	
	public static StringBuilder load(String filename, String path) 
			throws IOException
	{
		//creates and efficient string with 64 character spaces
		StringBuilder strBuilder = new StringBuilder(64); 
		
		//creating a variable than can interrogate file object
		File fileIn = new File(path + filename);	
		//it exists and is not locked 
		if(fileIn.exists() && fileIn.canRead())
		{
			BufferedReader buff
					= new BufferedReader(new FileReader(fileIn));
			//anything terminated by a '\n'
			String strIn = buff.readLine();
			
			while(strIn != null)
			{
				//instead of concatenate we use StringBuilder::append
				//because it is MUCH faster for concatenation
				//because a StringBuilder object is MUTABLE
				strBuilder.append(strIn);
				
				strIn = buff.readLine(); //StringBuilder
			}
			buff.close();
		}
		else
		{
		}		
		return strBuilder;
	}

	/*
	public static String load(String filename, String path) 
			throws IOException
	{
		String strOut="";
		
		//creating a variable than can interrogate file object
		File fileIn = new File(path + filename);	
		//it exists and is not locked 
		if(fileIn.exists() && fileIn.canRead())
		{
			BufferedReader buff
					= new BufferedReader(new FileReader(fileIn));
			//anything terminated by a '\n'
			String strIn = buff.readLine();
			
			while(strIn != null)
			{
				strOut += strIn;
				strIn = buff.readLine(); //StringBuilder
			}
			buff.close();
		}
		else
		{
		}		
		return strOut;
	}
	*/
}
































