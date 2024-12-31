package lambdaTestPlayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import LambdaTest.CommonSteps;

public class TestScenario3 extends CommonSteps {

	@Test

	public void scenario3() {

		// Step 1: Open the LambdaTest Selenium Playground page
		driver.get("https://www.lambdatest.com/selenium-playground");

		// Click “Input Form Submit”
		WebElement inputFormSubmitLink = driver.findElement(By.linkText("Input Form Submit"));
		inputFormSubmitLink.click();

		// Step 2: Click “Submit” without filling in any information
		WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));

		Actions action = new Actions(driver);
		action.scrollToElement(submitButton).perform();
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
		submitButton.click();
		// Step 3: Assert “Please fill out this field.” error message
		WebElement nameField = driver.findElement(By.id("name"));
		String validationMessage = nameField.getAttribute("validationMessage");
		if (validationMessage.equals("Please fill out this field.")) {
			System.out.println("Validation Passed: " + validationMessage);
		} else {
			System.out
					.println("Validation Failed: Expected 'Please fill out this field.' but got " + validationMessage);
		}

		// Step 4: Fill in Name, Email, and other fields
		nameField.sendKeys("Vinoth");
		driver.findElement(By.id("inputEmail4")).sendKeys("vinoth@example.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("Password123");
		driver.findElement(By.id("company")).sendKeys("Test Company");
		driver.findElement(By.id("websitename")).sendKeys("www.example.com");
		driver.findElement(By.id("inputCity")).sendKeys("India");
		driver.findElement(By.id("inputAddress1")).sendKeys("No 2 Main Street");
		driver.findElement(By.id("inputAddress2")).sendKeys("Apt 4B");
		driver.findElement(By.id("inputState")).sendKeys("TN");
		driver.findElement(By.id("inputZip")).sendKeys("600126");

		// Step 5: From the Country drop-down, select “United States” using the text
		// property
		WebElement countryDropdown = driver.findElement(By.name("country"));
		Select selectCountry = new Select(countryDropdown);
		selectCountry.selectByVisibleText("India");

		// Step 6: Click “Submit” after filling in all fields
		submitButton.click();

		// Step 7: Validate the success message
		WebElement successMessage = driver.findElement(By.cssSelector(".success-msg"));
		String successText = successMessage.getText();
		if (successText.equals("Thanks for contacting us, we will get back to you shortly.")) {
			System.out.println("Success Message Validation Passed: " + successText);
		} else {
			System.out.println(
					"Success Message Validation Failed. Expected: 'Thanks for contacting us, we will get back to you shortly.' but got: "
							+ successText);
		}

	}

}

//Validation Passed: Slider value is 95
