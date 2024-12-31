package lambdaTestPlayground;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import LambdaTest.CommonSteps;

public class TestScenario1 extends CommonSteps {

	@Test
	public void scenario1() {

		// Step 1: Open LambdaTest’s Selenium Playground
		driver.get("https://www.lambdatest.com/selenium-playground");

		// to scroll the page
		WebElement element = driver.findElement(By.xpath("//a[text()=' Context Menu']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		// Actions action = new Actions(driver);
		// action.scrollToElement(element).perform();
		// Step 2: Click “Simple Form Demo”
		driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();

		// Step 3: Validate that the URL contains “simple-form-demo”
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("simple-form-demo")) {
			System.out.println("URL validation passed: " + currentUrl);
		} else {
			System.out.println("URL validation failed.");
		}

		// Step 4: Create a variable for a string value
		String message = "Welcome to LambdaTest";

		// Step 5: Use this variable to enter values in the “Enter Message” text box
		WebElement messageInputBox = driver.findElement(By.id("user-message"));
		messageInputBox.sendKeys(message);

		// Step 6: Click “Get Checked Value”
		WebElement showMessageButton = driver.findElement(By.id("showInput"));
		showMessageButton.click();

		// Step 7: Validate whether the same text message is displayed
		WebElement displayedMessage = driver.findElement(By.id("message"));
		String displayedText = displayedMessage.getText();

		if (displayedText.equals(message)) {
			System.out.println("Message validation passed: " + displayedText);
		} else {
			System.out.println("Message validation failed. Expected: " + message + ", but got: " + displayedText);
		}

	}

}

//URL validation passed: https://www.lambdatest.com/selenium-playground/simple-form-demo
//Message validation passed: Welcome to LambdaTest
