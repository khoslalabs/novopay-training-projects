package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractDataFromExcel {

	public ArrayList<Object[]> ExtractData(String APIName,String TestType) throws IOException {
		ArrayList<Object[]> Dataset = new ArrayList<Object[]>();
		
		FileInputStream fis = new FileInputStream("./test-data\\Actor.xlsx");
		XSSFWorkbook Workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = 	Workbook.getSheet(APIName);
		for(int R=1;R<=sheet.getLastRowNum();R++) {
			String cell0 = sheet.getRow(R).getCell(0).getStringCellValue();
			System.out.println("Executing test case : "+cell0);
			XSSFCell cell1 = sheet.getRow(R).getCell(1);
			if (cell1.getStringCellValue().equalsIgnoreCase(TestType)){

				System.out.println(TestType +" test case");
				XSSFCell cell2 = sheet.getRow(R).getCell(2);
				
				int id=(int) cell2.getNumericCellValue();
				String ID = id+"";
				//System.out.println("\t ID : "+id);
				Dataset.add(new Object[] {ID});
			}
		}
		return Dataset;
	}

	public ArrayList<Object[]> extractDataGetCorporateList(String APIName,String TestType) throws IOException {
		ArrayList<Object[]> Dataset = new ArrayList<Object[]>();
		
		FileInputStream fis = new FileInputStream("./test-data\\Actor.xlsx");
		XSSFWorkbook Workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = 	Workbook.getSheet(APIName);
		for(int R=1;R<=sheet.getLastRowNum();R++) {
			String cell0 = sheet.getRow(R).getCell(0).getStringCellValue();
			System.out.println("Executing test case : "+cell0+" ");
			XSSFCell cell1 = sheet.getRow(R).getCell(1);
			if (cell1.getStringCellValue().equalsIgnoreCase(TestType)){

				System.out.println(TestType +" test case"+"\n");
				String Offset = (int) sheet.getRow(R).getCell(2).getNumericCellValue()+"";
				String page_size = (int) sheet.getRow(R).getCell(3).getNumericCellValue()+"";
				String sort_order = sheet.getRow(R).getCell(4).getStringCellValue();
				String field_name = sheet.getRow(R).getCell(5).getStringCellValue();
				Dataset.add(new Object[] {Offset,page_size,sort_order,field_name});
				
				
			}
		}
		return Dataset;
	}
}
