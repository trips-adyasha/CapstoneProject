package TestRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/DemoShop.feature", glue = "StepDefinition",
//		tags = "@coupon",
		plugin = { "pretty", "html:target/Report.html" })

public class ShopRunner extends AbstractTestNGCucumberTests {
	public static ThreadLocal<String> BrowserType = new ThreadLocal<String>();

	@BeforeClass
	@Parameters("browser")
	public void GiveBrowser(String browser) {
		BrowserType.set(browser);
	}

}
