package LambdaTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CommonSteps {
	public EdgeOptions ep;
	public ChromeOptions cp;
	public FirefoxOptions fp;
	public InternetExplorerOptions ip;
	public String username = "vinothkumarsv9";
	public String accesskey = "PC4maHjYGvBLZzGqgBgSBhsWdZbrqFB8AAikSES2crOBWUQjNn";
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;

	@Parameters({ "browser", "platform", "version" })
	@BeforeMethod

	public void preCondition(String browser, String platform, String bVersion) throws MalformedURLException {

		if (browser.equalsIgnoreCase("chrome")) {

			cp = new ChromeOptions();
			cp.setPlatformName(platform);
			cp.setBrowserVersion(bVersion);
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "vinothkumarsv9");
			ltOptions.put("accessKey", "PC4maHjYGvBLZzGqgBgSBhsWdZbrqFB8AAikSES2crOBWUQjNn");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("project", "Untitled");
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			cp.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), cp);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		}

		else if (browser.equalsIgnoreCase("Edge")) {
			ep = new EdgeOptions();
			ep.setPlatformName(platform);
			ep.setBrowserVersion(bVersion);
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "vinothkumarsv9");
			ltOptions.put("accessKey", "PC4maHjYGvBLZzGqgBgSBhsWdZbrqFB8AAikSES2crOBWUQjNn");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("project", "Untitled");
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			ep.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), ep);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		} else if (browser.equalsIgnoreCase("Firefox")) {
			fp = new FirefoxOptions();
			fp.setPlatformName("Windows 11");
			fp.setBrowserVersion("130.0");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "vinothkumarsv9");
			ltOptions.put("accessKey", "PC4maHjYGvBLZzGqgBgSBhsWdZbrqFB8AAikSES2crOBWUQjNn");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("project", "Untitled");
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			fp.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), fp);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		} else if (browser.equalsIgnoreCase("InternetExplorer")) {
			ip = new InternetExplorerOptions();
			ip.setPlatformName(platform);
			ip.setBrowserVersion(bVersion);
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "vinothkumarsv9");
			ltOptions.put("accessKey", "PC4maHjYGvBLZzGqgBgSBhsWdZbrqFB8AAikSES2crOBWUQjNn");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("project", "Untitled");
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			ip.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), ip);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		}

	}

	@AfterMethod
	public void postCondition() {

		driver.quit();

	}
}
