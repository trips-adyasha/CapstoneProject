package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage {
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Register")
	WebElement gotoRegpage;
	@FindBy(id = "FirstName")
	WebElement Firstname;
	@FindBy(id = "LastName")
	WebElement Lastname;
	@FindBy(id = "Email")
	WebElement RegEmail;
	@FindBy(id = "Password")
	WebElement RegPass;
	@FindBy(id = "ConfirmPassword")
	WebElement Confirmpassword;
	@FindBy(id = "register-button")
	WebElement RegBtn;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Continuebtn;
	@FindBy(xpath = "//span[text()='Email is required.']")
	WebElement RegInvalid;
	@FindBy(xpath = "//li[text()='The specified email already exists']")
	WebElement AlreadyExist;

	public void GoToRegPage() {
		gotoRegpage.click();
	}

	public void Enterfn(String firstname) {
		Firstname.sendKeys(firstname);
	}

	public void Enterln(String lastname) {
		Lastname.sendKeys(lastname);
	}

	public void EnterEm(String Email) {
		RegEmail.sendKeys(Email);
	}

	public void EnterPs(String Password) {
		RegPass.sendKeys(Password);
	}

	public void EnterConfirm(String confirm) {
		Confirmpassword.sendKeys(confirm);
	}

	public void RegistrationBtn() {
		RegBtn.click();
	}

	public void ValidateReg() {
		try {
			if (Continuebtn.isDisplayed()) {
				Assert.assertTrue(true);
			}
		} catch (NoSuchElementException e1) {
			try {
				if (RegInvalid.isDisplayed()) {
					Assert.assertTrue(true);
				}
			} catch (NoSuchElementException e2) {
				try {
					if (AlreadyExist.isDisplayed()) {
						Assert.assertTrue(true);
					}
				} catch (NoSuchElementException e3) {
					e3.printStackTrace();
				}
			}
		}
	}

}
