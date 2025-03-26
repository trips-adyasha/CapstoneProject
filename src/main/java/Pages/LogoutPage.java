package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	LoginPage lp;

	public LogoutPage(WebDriver driver, LoginPage lp) {
		this.driver = driver;
		this.lp = lp;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log out")
	WebElement logoutBtn;

	public void GoToLogout() {
		logoutBtn.click();
	}

	public void validateLogout() {
		if (lp.gotologinpage.isDisplayed()) {
			System.out.println("Logout successful");
		} else {
			System.out.println("Logout failed");
		}
	}
}
