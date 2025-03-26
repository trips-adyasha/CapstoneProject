package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CouponPage {
	public CouponPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@value='Add to cart'])[2]")
	WebElement anyProduct;
	@FindBy(linkText = "Shopping cart")
	WebElement cartpage;
	@FindBy(name = "discountcouponcode")
	WebElement couponBar;
	@FindBy(name = "applydiscountcouponcode")
	WebElement couponBtn;
	@FindBy(xpath = "//div[@class='message']")
	WebElement message;

	public void addProduct() {
		anyProduct.click();
		cartpage.click();
	}

	public void addCoupon(String coupon) {
		couponBar.sendKeys(coupon);
		couponBtn.click();
	}

	public void validateCoupon() {
		Assert.assertTrue(message.isDisplayed());
	}
}