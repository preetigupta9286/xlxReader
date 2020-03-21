package excel.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Apache.poi.util.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:/Users/surbh/eclipse-workspace/ApachePoiConcept/src/Apache/poi/util/Travelmedicare_TestData - Copy.xlsx");
    	
		String firstname=reader.getCellData("signup_data", "firstname", 2);
		System.out.println(firstname);
		
		String lastname=reader.getCellData("signup_data", "lastname", 2);
		System.out.println(lastname);
		
		String email=reader.getCellData("signup_data", "email", 2);
		System.out.println(email);
		
		String password=reader.getCellData("signup_data", "password", 2);
		System.out.println(password);
		
		String confirmpassword=reader.getCellData("signup_data", "confirmpassword", 2);
		System.out.println(confirmpassword);
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.travelmedicare.com/");
		driver.navigate().to("https://www.travelmedicare.com/register");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//to get data from excel sheet	
        driver.findElement(By.name("first_name")).sendKeys(firstname);
        driver.findElement(By.name("last_name")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("password_confirmation")).sendKeys(confirmpassword);
		
		
		
	}

}
