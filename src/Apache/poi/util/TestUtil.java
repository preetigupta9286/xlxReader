package Apache.poi.util;

import java.util.ArrayList;

public class TestUtil {
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		
		try {
		reader=new	Xls_Reader("C:/Users/surbh/eclipse-workspace/ApachePoiConcept/src/Apache/poi/util/Travelmedicare_TestData - Copy.xlsx");
		}catch(Exception e) {
		e.printStackTrace();
		}
		
		
 for(int rowNum=2;rowNum<=reader.getRowCount("signup_data");rowNum++) {
	 
	 
 String firstname=reader.getCellData("signup_data", "firstname", rowNum);
 String lastname=reader.getCellData("signup_data", "lastname", rowNum);
 String email=reader.getCellData("signup_data", "email", rowNum);
 String password=reader.getCellData("signup_data", "password", rowNum);
 String confirmpassword=reader.getCellData("signup_data", "confirmpassword", rowNum);
 
 Object obj[]= {firstname,lastname,email,password,confirmpassword};
 mydata.add(obj);
}
 return mydata;
}}
