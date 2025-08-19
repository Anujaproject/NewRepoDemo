package coverfoxPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//div[contains(text(),'Female')]") private WebElement gender;

	public HomePage(WebDriver driver) {

		// driver = idriver;
		PageFactory.initElements(driver, this);
	}

	public void Clickgender() {
		gender.click();
	}
}
