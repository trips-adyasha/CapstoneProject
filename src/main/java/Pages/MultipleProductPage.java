package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MultipleProductPage {
	WebDriver driver;
	double ExpectedSum;

	public MultipleProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(linkText = "Books")
	WebElement ProductType;
	@FindBy(xpath = "(//div[@class='product-item'])[1]")
	WebElement Product1;
	@FindBy(xpath = "(//div[@class='product-item'])[3]")
	WebElement Product2;
	@FindBy(xpath = "//span[@itemprop='price']")
	WebElement itemRate;
	@FindBy(xpath = "//input[@value='Add to cart']")
	WebElement addToCart;
	@FindBy(linkText = "Shopping cart")
	WebElement cartPage;
	@FindBy(xpath = "(//span[@class='product-price'])[1]")
	WebElement totalSum;

	public void SearchProducts() {
		ProductType.click();
	}

	public void SelectProducts() throws InterruptedException {
		Product1.click();
		ExpectedSum += Double.parseDouble(itemRate.getText());
		addToCart.click();
		driver.navigate().back();
		Thread.sleep(5000);
		Product2.click();
		addToCart.click();
		ExpectedSum += Double.parseDouble(itemRate.getText());
	}

	public void ValidateCartPage() {
		cartPage.click();
		double ActualSum = Double.parseDouble(totalSum.getText());
		System.out.println(ActualSum);
		Assert.assertEquals(ActualSum, ExpectedSum);
	}
}
