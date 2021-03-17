import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author bsoundar
 *
 */
public class SystemInputUtils {
	
	public static final String FIRST_NAME = "firstname";
	public static final String LAST_NAME = "lastname";
	public static final String TITLE = "title";
	public static final String EMP_NO = "empno";

	// Return the system inputs as String Array
    public static String[] readSystemInputsAsString() {
    	System.out.println("++++++Reading the inputs from readSystemInputAsString Method+++++++");
    	String[] inputParams = new String[4];
    	
    	@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter the firstname of the employee: ");
		String firstname = userInput.nextLine();
		System.out.print("Enter the lastname of the employee: ");
		String lastname = userInput.nextLine();
		System.out.print("Enter the title of the employee: ");
		String title = userInput.nextLine();
		System.out.print("Enter the employee no: ");
		String empno = userInput.nextLine();
		
		inputParams[0] = firstname;
		inputParams[1] = lastname;
		inputParams[2] = title;
		inputParams[3] = empno;
		
		return inputParams;
    }
    
    // Return the system inputs as List
    public static List<String> readSystemInputsAsList() {
    	
    	// Get the system inputs as String Array
    	String[] inputParam = readSystemInputsAsString();
		
		List<String> inputParams = Arrays.asList(inputParam);

		return inputParams;
    }
    
    // Return the system inputs as HashMap
    public static Map<String, String> readSystemInputsAsMap() {

    	// Get the system inputs as String Array
    	String[] inputParam = readSystemInputsAsString();
    	
    	Map<String, String> inputParams = new HashMap<String, String>();
		
		inputParams.put(FIRST_NAME, inputParam[0]);
		inputParams.put(LAST_NAME, inputParam[1]);
		inputParams.put(TITLE, inputParam[2]);
		inputParams.put(EMP_NO, inputParam[3]);

		return inputParams;
    }

}
