package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
	public static ThreadLocal<String> emails = new ThreadLocal<String>();
	public static ThreadLocal<String> passwords = new ThreadLocal<String>();

	public void BrowserSetup(String browser) throws Exception {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			emails.set(ConfigReader.getURL("email1"));
			passwords.set(ConfigReader.getURL("password1"));
			drivers.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			emails.set(ConfigReader.getURL("email2"));
			passwords.set(ConfigReader.getURL("password2"));
			drivers.set(new EdgeDriver());
		} else {
			throw new Exception("Invalid Browser");
		}
	}

	public static WebDriver OpenBrowser() {
		drivers.get().get(ConfigReader.getURL("url"));
		drivers.get().manage().window().maximize();
		drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		return drivers.get();
	}

	public static void CloseBrowser() {
		drivers.get().quit();
	}

}
