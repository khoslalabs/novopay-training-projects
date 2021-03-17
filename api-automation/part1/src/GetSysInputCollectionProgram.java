import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author bsoundar
 *
 */
public class GetSysInputCollectionProgram {

	private static final Object COMMA_SEPARATOR = ",";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Map<String, String>> listOfRecords = new ArrayList<Map<String, String>>();
		
		// Reading the inputs for three times - 3 records from system input
	    for (int i = 0; i < 3; i++) {
	    	
	    	// Get each single record one by one
	    	Map<String, String> singleRecordMap = SystemInputUtils.readSystemInputsAsMap();
	        
	    	// Add each record to a list
	    	listOfRecords.add(singleRecordMap);
	    	
	    }
		
	    int recordCount = 0;
	    
	    // Iterating and calling the reusable method to render and print
		for (Map<String, String> inputParams : listOfRecords) {
			recordCount++;
			renderSystemInputRecords(inputParams, recordCount);
		}

	}
	
	private static void renderSystemInputRecords(Map<String, String> inputParams, int recordCount) {
		String firstname = inputParams.get(SystemInputUtils.FIRST_NAME);
		String lastname = inputParams.get(SystemInputUtils.LAST_NAME);
		String title = inputParams.get(SystemInputUtils.TITLE);
		String empno = inputParams.get(SystemInputUtils.EMP_NO);
		
		StringBuilder recordToPrint = new StringBuilder();
		recordToPrint.append("\nRecord ");
		recordToPrint.append(recordCount);
		recordToPrint.append(" : ");
		recordToPrint.append(firstname);
		recordToPrint.append(COMMA_SEPARATOR);
		recordToPrint.append(lastname);
		recordToPrint.append(COMMA_SEPARATOR);
		recordToPrint.append(title);
		recordToPrint.append(COMMA_SEPARATOR);
		recordToPrint.append(empno);
		
		System.out.println(recordToPrint.toString());
	}
	
	}
