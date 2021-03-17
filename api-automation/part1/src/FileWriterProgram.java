import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author bsoundar
 *
 */
public class FileWriterProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter the firstname of the employee: ");
		String firstname = userInput.nextLine();
		System.out.print("Enter the lastname of the employee: ");
		String lastname = userInput.nextLine();
		System.out.print("Enter the employee designation: ");
		String empTitle = userInput.nextLine();
		System.out.print("Enter the employee no: ");
		int empno = userInput.nextInt();
		
		
		// File to Write the data
		//FileWriter fileWriter = new FileWriter("/Users/bsoundar/novopay/employeeInfo.txt");
		FileWriter fileWriter = new FileWriter("employeeInfo.txt");
		
		fileWriter.write("Firstname : " + firstname);
		fileWriter.write("\nLastname : " + lastname);
		fileWriter.write("\nEmp No : " + empno);
		fileWriter.write("\nDesignation : " + empTitle);
		
		System.out.println("File Writing Program executed successfully!");
		
		fileWriter.close();
	}
}

