import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */

/**
 * @author bsoundar
 *
 */
public class FileIOProgram {
	
	private static Logger logger = Logger.getLogger("FileIOProgram.class");

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.print("Enter the name of the file : ");
		Scanner sr = new Scanner(System.in);
		String fileName = sr.nextLine();
		
		writeFile(fileName);
		readFile(fileName);
		
		sr.close();
	}
	
	/**
	 * Write to a file
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	private static void writeFile(String fileName) throws IOException {
		
		FileWriter fileWriter = null;
		
		try {
			Scanner userInput = new Scanner(System.in);
			System.out.print("Enter the firstname of the employee: ");
			String firstname = userInput.nextLine();
			System.out.print("Enter the lastname of the employee: ");
			String lastname = userInput.nextLine();
			System.out.print("Enter the employee designation: ");
			String empTitle = userInput.nextLine();
			System.out.print("Enter the employee no: ");
			int empno = userInput.nextInt();
			
			fileWriter = new FileWriter(fileName);
			
			fileWriter.write("Firstname : " + firstname);
			fileWriter.write("\nLastname : " + lastname);
			fileWriter.write("\nEmp No : " + empno);
			fileWriter.write("\nDesignation : " + empTitle);
			
			System.out.println("File Writing Program executed successfully!");
		
		} catch (IOException ioe) {
			logger.log(Level.WARNING, "File Writing Program execution failed!");
			logger.log(Level.SEVERE, ioe.getMessage(), ioe);
		} finally {
			if (fileWriter!=null) {
				fileWriter.close();
			}
		}
		
	}
	
	/**
	 * Read a file content
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	private static void readFile(String fileName) throws IOException {

		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(fileName));
			
			String firstname = br.readLine();
			String lastname = br.readLine();
			String designation = br.readLine();
			String empno = br.readLine();
			
			System.out.println(firstname);
			System.out.println(lastname);
			System.out.println(designation);
			System.out.println(empno);
			
			logger.log(Level.INFO, "File Reading Program executed successfully!");
			
		} catch (IOException ioe) {
			logger.log(Level.WARNING, "File Reading Program execution failed!");
			logger.log(Level.SEVERE, ioe.getMessage(), ioe);
		} finally {
			if (br!=null) {
				br.close();
			}
		}
		
	}
	
}

