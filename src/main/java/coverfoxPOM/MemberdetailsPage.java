package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MemberdetailsPage {

	WebDriver driver;

	@FindBy(xpath ="//select[@id='Age-You']") private WebElement Age;

	public MemberdetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void SelectAge() throws InterruptedException {
		Thread.sleep(2000);
		Select selectAge = new Select(Age);
		selectAge.selectByValue("29y");
	}
}
