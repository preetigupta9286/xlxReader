package excel.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Apache.poi.util.TestUtil;

public class TravelTestNgTest {
	
static WebDriver driver;

@BeforeMethod
public void test_data_sign_page() {
WebDriver driver = new FirefoxDriver();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("https://www.travelmedicare.com/");
//driver.navigate().to("https://www.travelmedicare.com/register");
driver.get("https://www.travelmedicare.com/register");
} 

@DataProvider
public Iterator<Object[]> getTestData() {
ArrayList<Object[]> testdata=TestUtil.getDataFromExcel();	//calling the method by using classname
return testdata.iterator();
}

@Test(dataProvider = "getTestData")
public void sign_up_page(String firstname,String lastname,String email,String password,String confirmpassword) {
	
	//driver.findElement(By.name("first_name")).clear();
   driver.findElement(By.name("first_name")).sendKeys(firstname);
    System.out.println(firstname);

    driver.findElement(By.name("last_name")).clear();
    driver.findElement(By.name("last_name")).sendKeys(lastname);
    System.out.println(lastname);
    
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(email);
    
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);
    
    driver.findElement(By.name("password_confirmation")).clear();
    driver.findElement(By.name("password_confirmation")).sendKeys(confirmpassword);
	
	
}

@AfterMethod
public void teardown() {
	//driver.quit();
}
}
