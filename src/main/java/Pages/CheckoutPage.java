package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;

public class CheckoutPage {
	WebDriver driver;
	LoginPage lp;
	SearchPage sp;

	public CheckoutPage(WebDriver driver, LoginPage lp, SearchPage sp) {
		this.driver = driver;
		this.lp = lp;
		this.sp = sp;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Shopping cart")
	WebElement cartpage;
	@FindBy(id = "termsofservice")
	WebElement checkbox;
	@FindBy(id = "checkout")
	WebElement coBtn;
	@FindBy(id = "billing-address-select")
	WebElement billaddr;
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement country;
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addr1;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalzip;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phone;
	@FindBy(xpath = "//span[text()='Phone is required']")
	WebElement phoneError;
	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	WebElement ctn1;
	@FindBy(xpath = "(//input[@value='Continue'])[2]")
	WebElement ctn2;
	@FindBy(xpath = "(//input[@value='Continue'])[3]")
	WebElement ctn3;
	@FindBy(xpath = "(//input[@value='Continue'])[4]")
	WebElement ctn4;
	@FindBy(xpath = "(//input[@value='Continue'])[5]")
	WebElement ctn5;
	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement confirm;
	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	WebElement orderSuccess;

	public void CheckOut() {
		cartpage.click();
		checkbox.click();
		coBtn.click();
	}

	public void addValidDetails(DataTable table) {
		List<String> data = table.asList();
		Select b = new Select(billaddr);
		b.selectByContainsVisibleText("New Address");
		Select c = new Select(country);
		c.selectByContainsVisibleText(data.get(0));
		city.sendKeys(data.get(1));
		addr1.sendKeys(data.get(2));
		postalzip.sendKeys(data.get(3));
		phone.sendKeys(data.get(4));
		ctn1.click();
		ctn2.click();
		ctn3.click();
		ctn4.click();
		ctn5.click();
		confirm.click();

	}

	public void addInvalidDetails(DataTable table) {
		List<String> data = table.asList();
		Select b = new Select(billaddr);
		b.selectByContainsVisibleText("New Address");
		Select c = new Select(country);
		c.selectByContainsVisibleText(data.get(0));
		city.sendKeys(data.get(1));
		addr1.sendKeys(data.get(2));
		postalzip.sendKeys(data.get(3));
		ctn1.click();

	}

	public void validateCheckout() {
		Assert.assertTrue(orderSuccess.isDisplayed());
	}

	public void InvalidateCheckout() {
		Assert.assertTrue(phoneError.isDisplayed());

	}

}
