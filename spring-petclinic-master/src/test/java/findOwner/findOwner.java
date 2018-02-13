package findOwner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;
public class findOwner {
	WebDriver driver = null;
	@Given("^I am on petclinic find owner page")
	public void goToFacebook() {
		driver = new FirefoxDriver();
		driver.navigate().to("localhost:8086/");
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a/span[2]")).click();
	}
	@When("^I enter owner Last name as \"([^\"]*)\"$")
	public void I_enter_owner_Last_name_as(String arg1) 
	{
	
		driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div/div/input")).sendKeys(arg1);
		
		// Express the Regexp above with the code you wish you had
	   
	}

	@When("^I click on FindOwner button$")
	public void I_click_on_FindOwner_button() 
	{
	    // Express the Regexp above with the code you wish you had
		driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click();
		
	}
	@Then("^message Owner Information display$")
	public void message_Owner_Information_display() 
	{
	  
		String M1 =driver.findElement(By.xpath("/html/body/div/div/h2[1]")).getText();
		
		String M3 =driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b")).getText();
						
		Assert.assertEquals(M1, "Owner Information");
		Assert.assertEquals(M3, "Mike Pence");
		System.out.println("Test1 Pass");
		driver.close();
	}
	

	@Then("^message has not been found display$")
	public void message_has_not_been_found_display() {
	    
		String M2 =driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div/div/span/div/p")).getText();
		Assert.assertEquals(M2, "has not been found");
		System.out.println("Test2 passed");
		driver.close();
	}

}


