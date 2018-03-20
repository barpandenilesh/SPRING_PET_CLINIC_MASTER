package owner.annotation;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOwnerTestTest {
  @Test
  public void f() {
	  FirefoxDriver driver = new FirefoxDriver();
	  
	   driver.navigate().to("localhost:8086/");
  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
