package excel.test;

import Apache.poi.util.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		Xls_Reader reader=new Xls_Reader("C:\\Users\\surbh\\eclipse-workspace\\ApachePoiConcept\\src\\Apache\\poi\\util\\Travelmedicare_TestData - Copy.xlsx");
		String sheetname="signup_data";
		
		
		if(!reader.isSheetExist("valid_data")) {
		reader.addSheet("valid_data");
		}
		int total_colm_count=reader.getColumnCount(sheetname);
		System.out.println(total_colm_count);
		
		
	}

}
