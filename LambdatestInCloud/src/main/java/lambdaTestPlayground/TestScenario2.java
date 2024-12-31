package lambdaTestPlayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import LambdaTest.CommonSteps;

public class TestScenario2 extends CommonSteps {

	@Test
	public void scenario2() {

		// Step 1: Open the LambdaTest Selenium Playground page
		driver.get("https://www.lambdatest.com/selenium-playground");

		// Click “Drag & Drop Sliders” under “Progress Bars & Sliders”
		WebElement dragDropSlidersLink = driver.findElement(By.linkText("Drag & Drop Sliders"));
		dragDropSlidersLink.click();

		// Step 2: Locate the slider with "Default value 15"
		WebElement slider = driver.findElement(By.xpath("//h4[text()=' Default value 15']//following::input"));

		// Locate the range value element to validate the value
		WebElement rangeValue = driver.findElement(By.id("rangeSuccess"));

		// Create an Actions object for performing the drag action
		Actions actions = new Actions(driver);

		// Drag the slider to make it 95
		// Dragging is done by moving the slider horizontally by an offset
		int offset = 215; // Adjust this value based on the slider sensitivity
		actions.dragAndDropBy(slider, offset, 0).perform();

		// Validate whether the range value shows 95
		String actualValue = rangeValue.getText();
		if (actualValue.equals("95")) {
			System.out.println("Validation Passed: Slider value is 95");
		} else {
			System.out.println("Validation Failed: Expected 95 but got " + actualValue);
		}

	}

}

//Validation Passed: Slider value is 95
