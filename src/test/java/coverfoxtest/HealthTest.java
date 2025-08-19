package coverfoxtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverfoxPOM.HealthPlanPage;

public class HealthTest {

	WebDriver driver;
	
	HealthPlanPage healthplnobj;
	
	@BeforeMethod
	public void LaunchBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void ClickNBtn() throws InterruptedException
	{
		healthplnobj=new HealthPlanPage(driver);
		healthplnobj.NextBtn();
				
	}
	@AfterTest
	public void CloseBrowser() {
		//driver.quit();
	}
}
