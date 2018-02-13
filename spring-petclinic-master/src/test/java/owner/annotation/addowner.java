package owner.annotation;
import java.util.List;

import org.hibernate.validator.internal.constraintvalidators.bv.AssertTrueValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.thymeleaf.context.IWebContext;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
//import cucumber.table.xstream.*;
//import gherkin.formatter.model.DataTableRow;
import junit.framework.Assert;
//@SuppressWarnings("unused")
public class addowner
{

	WebDriver driver = null;
	
	@Given("^I am on petclinic Add owner page$")
	public void I_am_on_petclinic_Add_owner_page()
	   { 
	      
		  driver = new FirefoxDriver();
		  
		   driver.navigate().to("localhost:8086/");
		   driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a/span[2]")).click();
		} 
	@When("^I Entered valid data on page$") 
	public void I_Entered_valid_data_on_page(DataTable arg1)
	   { 
	   
         driver.findElement(By.xpath("/html/body/div/div/a")).click();
         
	     // @SuppressWarnings("rawtypes")
		List<List<String>> data = arg1.raw();
	     // System.out.println(((DataTable) data).getGherkinRows().get(1)); 
	      driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[1]/div/input")).sendKeys(data.get(1).get(1));
	      driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div/input")).sendKeys(data.get(2).get(1));
	      driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div/input")).sendKeys(data.get(3).get(1));
	      driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[4]/div/input")).sendKeys(data.get(4).get(1));
	      driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[5]/div/input")).sendKeys(data.get(5).get(1));
	      driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click(); 
	     
	      
	   }
	@Then("^New owner registered scuccessfully$")
	public void New_owner_registered_scuccessfully() 
	{
		
		String H=driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b")).getText();
		Assert.assertEquals(H, "Jow Root");
		 System.out.println("Test1 Pass");
		driver.close();	
    }
}