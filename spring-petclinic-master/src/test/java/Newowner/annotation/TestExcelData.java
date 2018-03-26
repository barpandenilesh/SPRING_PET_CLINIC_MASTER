package Newowner.annotation;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
/*
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.SheetNameFormatter;*/
import org.hibernate.validator.internal.constraintvalidators.bv.AssertTrueValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.thymeleaf.context.IWebContext;
public class TestExcelData extends testUtility
{
	WebDriver driver;
	public String SheetName="sheet2";
	
	@BeforeMethod
	public void setup()
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("localhost:8086/");
			
		
	}

	@DataProvider
	public Object[][] getTesdata()
	{
		
		Object[][] ob=testUtility.getDatafromExcel(SheetName);
		 return ob;
		
		
	}
	
	@Test(dataProvider="getTesdata")
	
	public void Addownertest(String FirstName,String LastName,String Address,String City,String Telephone)
	{
		   driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a/span[2]")).click();
		   driver.findElement(By.xpath("/html/body/div/div/a")).click();
		   driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[1]/div/input")).sendKeys(FirstName);
		   driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div/input")).sendKeys(LastName);
		   driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div/input")).sendKeys(Address);
		   driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[4]/div/input")).sendKeys(City);
		   driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[5]/div/input")).sendKeys(Telephone);
		   driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click(); 
		
		driver.close();
		
	}

}
