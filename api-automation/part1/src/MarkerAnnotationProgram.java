
/**
 * @author bsoundar
 *
 */
public class MarkerAnnotationProgram extends BaseAnnotationProgram {

	public MarkerAnnotationProgram() {
		
	}

	@Override
	public void printStringValue(String value) {
		System.out.println("MarkerAnnotation - value : " + value);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String value = "Successfully executed the annotation example!";
		BaseAnnotationProgram bap = new BaseAnnotationProgram();
		bap.printStringValue(value);
		
		BaseAnnotationProgram bmap = new MarkerAnnotationProgram();
		bmap.printStringValue(value);
		
		MarkerAnnotationProgram map = new MarkerAnnotationProgram();
		map.printStringValue(value);
	}
	
}
