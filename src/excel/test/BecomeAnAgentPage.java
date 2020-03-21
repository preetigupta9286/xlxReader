package excel.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Apache.poi.util.Xls_Reader;

public class BecomeAnAgentPage {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.travelmedicare.com/");
		driver.navigate().to("https://www.travelmedicare.com/register");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//to get data from excel sheet
		Xls_Reader reader = new Xls_Reader("C:/Users/surbh/eclipse-workspace/ApachePoiConcept/src/Apache/poi/util/Travelmedicare_TestData - Copy.xlsx");
    	String sheetName = "signup_data";

		int rowCount = reader.getRowCount(sheetName);

		reader.addColumn(sheetName, "status"); //to add column in excel sheet
		
		//data driven approach or parameterization
		for(int rowNum=2; rowNum<=rowCount; rowNum++){
			
			System.out.println("=====");
			
			String firstname = reader.getCellData(sheetName, "firstname", rowNum);
			System.out.println(firstname);
			
			String lastname = reader.getCellData(sheetName, "lastname", rowNum);
			System.out.println(lastname);
			
			String email = reader.getCellData(sheetName, "email", rowNum);
			System.out.println(email);
			
			String password = reader.getCellData(sheetName, "password", rowNum);
			System.out.println(password);
			
			String confirmpassword = reader.getCellData(sheetName, "confirmpassword", rowNum);
			System.out.println(confirmpassword);
			
			//enter data
			driver.findElement(By.name("first_name")).clear();
            driver.findElement(By.name("first_name")).sendKeys(firstname);
            
            driver.findElement(By.name("last_name")).clear();
            driver.findElement(By.name("last_name")).sendKeys(lastname);
            
            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("email")).sendKeys(email);
            
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys(password);
            
            driver.findElement(By.name("password_confirmation")).clear();
            driver.findElement(By.name("password_confirmation")).sendKeys(confirmpassword);
			
			reader.setCellData(sheetName, "status", rowNum, "pass");  //this is for write the data into cell
}}

}

