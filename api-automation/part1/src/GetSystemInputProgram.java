import java.io.IOException;
import java.util.Map;

/**
 * 
 * @author bsoundar
 *
 */
public class GetSystemInputProgram {

	private static final String WHITE_SPACE = " ";

	/**
	 * @param args
	 */
	public static void main(String args[]) throws IOException {
		
		Map<String, String> inputParams = SystemInputUtils.readSystemInputsAsMap();
		
		/*System.out.print("Enter the firstname of the employee: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String firstname = reader.readLine();
		System.out.print("Enter the lastname of the employee: ");
		String lastname = reader.readLine();
		System.out.print("Enter the employee no: ");
		int empno = Integer.parseInt(reader.readLine());*/
		
		System.out.println("Scanned Employee No : " + inputParams.get(SystemInputUtils.EMP_NO));
		System.out.println("Individual Method Approach 1 - Fullname : " 
		+ getFullName1(inputParams.get(SystemInputUtils.FIRST_NAME), inputParams.get(SystemInputUtils.LAST_NAME)));
		System.out.println("Individual Method Approach 2 - Fullname : " 
		+ getFullName2(inputParams.get(SystemInputUtils.FIRST_NAME), inputParams.get(SystemInputUtils.LAST_NAME)));
		System.out.println("Individual Method Approach 3 - Fullname : " 
		+ getFullName3(inputParams.get(SystemInputUtils.FIRST_NAME), inputParams.get(SystemInputUtils.LAST_NAME)));
		
		System.out.println("Reusable Method Approach 1 - Fullname : " + getFullName(inputParams.get(SystemInputUtils.FIRST_NAME), inputParams.get(SystemInputUtils.LAST_NAME), 1));
		System.out.println("Reusable Method Approach 2 - Fullname : " + getFullName(inputParams.get(SystemInputUtils.FIRST_NAME), inputParams.get(SystemInputUtils.LAST_NAME), 2));
		System.out.println("Reusable Method Approach 3 - Fullname : " + getFullName(inputParams.get(SystemInputUtils.FIRST_NAME), inputParams.get(SystemInputUtils.LAST_NAME), 3));
		System.out.println("Reusable Method Approach 0 - Fullname : " + getFullName(inputParams.get(SystemInputUtils.FIRST_NAME), inputParams.get(SystemInputUtils.LAST_NAME), 0));
		System.out.println("Reusable Method Approach 4 - Fullname : " + getFullName(inputParams.get(SystemInputUtils.FIRST_NAME), inputParams.get(SystemInputUtils.LAST_NAME), 4));
		
	}
	
	private static String getFullName1(String firstname, String lastname) {

		System.out.println("\nBegin of getFullName1");
		// Approach 1
		String fullname = firstname + WHITE_SPACE + lastname;
		System.out.println("Concatenate using operator");
		
		System.out.println("End of getFullName1");
		return fullname;
	}
	
	private static String getFullName2(String firstname, String lastname) {

		System.out.println("\nBegin of getFullName2");
		// Approach 2
		StringBuffer fullname2 = new StringBuffer();
		fullname2.append(firstname);
		fullname2.append(WHITE_SPACE);
		fullname2.append(lastname);
		System.out.println("Concatenate using simple StringBuffer appends");
		
		System.out.println("End of getFullName2");
		return fullname2.toString();
	}
	
	private static String getFullName3(String firstname, String lastname) {
		System.out.println("\nBegin of getFullName3");
		
		// Approach 3
		StringBuffer fullname3 = new StringBuffer();
		fullname3.append(firstname).append(WHITE_SPACE).append(lastname);
		System.out.println("Concatenate using multiple appenders");
		
		System.out.println("End of getFullName3");
		return fullname3.toString();
	}
	
	private static String getFullName(String firstname, String lastname, int approach) {
		String fullname = null;
		
		switch (approach) {
		case 1:
			System.out.println("Switching to Approach 1");
			fullname = getFullName1(firstname, lastname);
		break;
		case 2:
			System.out.println("Switching to Approach 2");
			fullname = getFullName2(firstname, lastname);
		break;
		case 3:
			System.out.println("Switching to Approach 3");
			fullname = getFullName3(firstname, lastname);
		break;
	    default:
	    	System.out.println("Switching to default");
	    	fullname = getFullName3(firstname, lastname);	
		}

		return fullname;
	}
	
}
