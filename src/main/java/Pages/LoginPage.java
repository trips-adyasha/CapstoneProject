package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log in")
	WebElement gotologinpage;
	@FindBy(xpath = "//input[@id='Email']")
	WebElement Email_ip;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement Pswd_ip;
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement LoginBtn;
	@FindBy(xpath = "//li[text()='No customer account found']")
	WebElement LogInvalid;

	public void GoToLoginPage() {
		gotologinpage.click();
	}

	public void EnterEmail(String email) {
		Email_ip.sendKeys(email);
	}

	public void EnterPassword(String password) {
		Pswd_ip.sendKeys(password);
	}

	public void ClickLogin() {
		LoginBtn.click();
	}

	public void ValidateLogin(String title) {
		String expected = "Demo Web Shop";
		if (title.equalsIgnoreCase("Demo Web Shop. Login")) {
			Assert.assertTrue(LogInvalid.isDisplayed());
		} else {
			Assert.assertEquals(title, expected);
		}
	}
}

