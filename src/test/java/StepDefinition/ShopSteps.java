package StepDefinition;

import org.openqa.selenium.WebDriver;

import Base.BaseTest;
import Base.ConfigReader;
import Pages.CheckoutPage;
import Pages.CouponPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.MultipleProductPage;
import Pages.RegistrationPage;
import Pages.SearchPage;
import TestRunner.ShopRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopSteps {
	String browser = ShopRunner.BrowserType.get();
	BaseTest base = new BaseTest();
	public WebDriver driver;
	LoginPage lp;
	RegistrationPage rp;
	LogoutPage lop;
	SearchPage sp;
	MultipleProductPage mp;
	CouponPage cp;
	CheckoutPage cop;

	@Given("user launch Demo Shop Home Page")
	public void user_launch_demo_shop_home_page() {
		try {
			base.BrowserSetup(browser);
			driver = BaseTest.OpenBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (driver == null) {
			throw new RuntimeException("Driver is not initialized.");
		}

		lp = new LoginPage(driver);
		rp = new RegistrationPage(driver);
		lop = new LogoutPage(driver, lp);
		sp = new SearchPage(driver);
		mp = new MultipleProductPage(driver);
		cp = new CouponPage(driver);
		cop = new CheckoutPage(driver, lp, sp);
	}

	// Login
	@When("^user enters Email(.*)$")
	public void user_enters_emailtrips_siya_gmail_com(String email) {
		lp.GoToLoginPage();
		lp.EnterEmail(email);

	}

	@When("^user enters Password(.*)$")
	public void user_enters_password_demo2siya(String password) {
		lp.EnterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		lp.ClickLogin();
	}

	@Then("validate log in")
	public void validate_log_in() {
		lp.ValidateLogin(driver.getTitle());
		BaseTest.CloseBrowser();
	}

	// Registration
	@When("^user enters First Name(.*)$")
	public void user_enters_first_name_wipro(String firstname) {
		rp.GoToRegPage();
		rp.Enterfn(firstname);
	}

	@When("^user enters Last Name(.*)$")
	public void user_enters_last_name_testing(String lastname) {
		rp.Enterln(lastname);
	}

	@When("^user enters the Email(.*)$")
	public void user_enters_the_email_email(String Email) {
		rp.EnterEm(Email);
	}

	@When("^user enters the Password(.*)$")
	public void user_enters_the_password_password(String Password) {
		rp.EnterPs(Password);
	}

	@When("^user confirms password(.*)$")
	public void user_confirms_password_testing2wip(String confirm) {
		rp.EnterConfirm(confirm);
	}

	@When("user clicks on registration button")
	public void user_clicks_on_registration_button() {
		rp.RegistrationBtn();
	}

	@Then("validate successful registration")
	public void validate_successful_registration() {
		rp.ValidateReg();
		BaseTest.CloseBrowser();
	}

	// Logout
	@When("user goes to login page")
	public void user_goes_to_login_page() {
		lp.GoToLoginPage();
	}

	@When("user enters credentials")
	public void user_enters_credentials() {
		lp.EnterEmail(BaseTest.emails.get());
		lp.EnterPassword(BaseTest.passwords.get());
		lp.ClickLogin();
	}

	@Then("user clicks logout")
	public void user_clicks_logout() {
		lop.GoToLogout();
		lop.validateLogout();
		BaseTest.CloseBrowser();
	}

	// Product Search
	@When("^user searches a product(.*)$")
	public void user_searches_a_productlaptop(String product) {
		sp.SearchProduct(product);
	}

	@When("user clicks on product")
	public void user_clicks_on_product() {
		sp.ClickProduct();
	}

	@When("user adds product to cart")
	public void user_adds_product_to_cart() {
		sp.AddingtoCart();
	}

	@Then("user validates if product is added")
	public void user_validates_if_product_is_added() {
		sp.ValidateAddToCart();
		BaseTest.CloseBrowser();
	}
	
	//Adding Multiple Products
	@When("user searches and adds multiple product")
	public void user_searches_and_adds_multiple_products() throws InterruptedException {
		mp.SearchProducts();
	    mp.SelectProducts();
	}

	@Then("validate the products and their total")
	public void validate_the_products_and_their_total() {
	    mp.ValidateCartPage();
	    BaseTest.CloseBrowser();
	}
	
	//Adding Coupon
	@When("user adds any product to cart")
	public void user_adds_any_product_to_cart() {
	    cp.addProduct();
	}

	@When("^user adds any coupon\"(.*)\"$")
	public void user_adds_any_coupon_xyz123(String coupon) {
	    cp.addCoupon(coupon);
	}

	@Then("validate the message")
	public void validate_the_message() {
	    cp.validateCoupon();
	    BaseTest.CloseBrowser();
	}
	
	//Valid Checkout
	@When("user logs in, searches, adds a product to cart, and clicks checkout")
	public void user_logs_in_searches_adds_a_product_to_cart_and_clicks_checkout() {
		lp.GoToLoginPage();
		lp.EnterEmail(BaseTest.emails.get());
		lp.EnterPassword(BaseTest.passwords.get());
		lp.ClickLogin();
		sp.SearchProduct(ConfigReader.getURL("product"));
		sp.ClickProduct();
		sp.AddingtoCart();
		cop.CheckOut();
		
	}

	@When("user fills all the details like country,city,address,zip,phone and continues")
	public void user_fills_all_the_details_like_country_city_address_zip_phone_and_continues(io.cucumber.datatable.DataTable dataTable) {    
		cop.addValidDetails(dataTable);
	}

	@Then("validate the process")
	public void validate_the_process() {
		cop.validateCheckout();
	    BaseTest.CloseBrowser();
	}
	
	//Invalid Checkout
	@When("user performs logs in, searches, adds a product to cart, and clicks checkout")
	public void user_performs_logs_in_searches_adds_a_product_to_cart_and_clicks_checkout() throws InterruptedException {
		lp.GoToLoginPage();
		lp.EnterEmail(BaseTest.emails.get());
		lp.EnterPassword(BaseTest.passwords.get());
		lp.ClickLogin();
		sp.SearchProduct(ConfigReader.getURL("product"));
		Thread.sleep(2000);
		sp.ClickProduct();
		sp.AddingtoCart();
		cop.CheckOut();
	}

	@When("user fills all the details and continues")
	public void user_fills_all_the_details_and_continues(io.cucumber.datatable.DataTable dataTable) {
		cop.addInvalidDetails(dataTable);
	}

	@Then("validate the entire process")
	public void validate_the_entire_process() {
	    cop.InvalidateCheckout();
	    BaseTest.CloseBrowser();
	}

}

