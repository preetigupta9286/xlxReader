package excel.test;

import Apache.poi.util.Xls_Reader;

public class Parameterized {

	public static void main(String[] args) {
	Xls_Reader reader = new Xls_Reader("C:/Users/surbh/eclipse-workspace/ApachePoiConcept/src/Apache/poi/util/Travelmedicare_TestData - Copy.xlsx");
	int rowCount=reader.getRowCount("signup_data");
	for(int rowNum=2;rowNum<=rowCount;rowNum++) {
		
	}
	
	}

}
