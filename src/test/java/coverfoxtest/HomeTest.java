package coverfoxtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverfoxPOM.HealthPlanPage;
import coverfoxPOM.HomePage;
import coverfoxPOM.MemberdetailsPage;

public class HomeTest {

	WebDriver driver;
	HomePage homepgobj;
	HealthPlanPage healthplnobj;
	MemberdetailsPage memberDetailsobj;

	@BeforeMethod
	public void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.coverfox.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void homepage() throws InterruptedException {
		homepgobj = new HomePage(driver);
		homepgobj.Clickgender();
		healthplnobj = new HealthPlanPage(driver);
		healthplnobj.NextBtn();
		memberDetailsobj=new MemberdetailsPage(driver);
		memberDetailsobj.SelectAge();
		healthplnobj.NextBtn();
	}

	@AfterTest
	public void CloseBrowser() {
		// driver.quit();
	}

}
