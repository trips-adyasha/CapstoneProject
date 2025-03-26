package Pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage {
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "small-searchterms")
	WebElement searchBar;
	@FindBy(xpath = "//input[@value='Search']")
	WebElement searchBtn;
	@FindBy(xpath = "//div[@class='product-item']")
	WebElement productClick;
	@FindBy(xpath = "//input[@value='Add to cart']")
	WebElement addToCart;
	@FindBy(xpath = "//p[@class='content']")
	WebElement successMsg;

	public void SearchProduct(String product) {
		try {
			searchBar.sendKeys(product);
			searchBtn.click();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}

	}

	public void ClickProduct() {
		productClick.click();
	}

	public void AddingtoCart() {
		addToCart.click();
	}

	public void ValidateAddToCart() {
		Assert.assertTrue(successMsg.isDisplayed());
	}

}
