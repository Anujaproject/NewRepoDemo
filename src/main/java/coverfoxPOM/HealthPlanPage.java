package coverfoxPOM;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthPlanPage {

	WebDriver driver;

	@FindBy(xpath = "//div[contains(text(),'Next')]") private WebElement ButtonNext;

	public HealthPlanPage(WebDriver driver) {
		// driver = idriver;
		PageFactory.initElements(driver, this);
	}

	public void NextBtn() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		ButtonNext.click();
	}

}
