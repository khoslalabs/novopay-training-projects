import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */

/**
 * @author bsoundar
 *
 */
public class FileReaderProgram {
	
	private static Logger logger = Logger.getLogger("FileReaderProgram.class");

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("employeeInfo.txt"));
			
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

