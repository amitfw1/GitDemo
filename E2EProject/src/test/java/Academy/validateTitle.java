package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	
	LandingPage l;
	public WebDriver driver;

	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		 log.info("Navigated to Home page");
	}

	@Test

	public void validateAppTitle() throws IOException {

		// one is inheritance
		// creating object to that class and invoke methods of it
		l = new LandingPage(driver);
		// compare the text from the browser with actual text.- Error..
		Assert.assertEquals(l.getTitle().getText(), "FEATURED 123COURSES");
		log.info("Successfully validated Text message");
		System.out.println("Test completed");

		;

	}
	
	@Test

	//Below code for second test to validate header in same page so that, no need to create new class file and thus no need to open browser again for same page testing
	public void validateHeader() throws IOException {

			
		// compare the text from the browser with actual text.- Error..
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated header message");
		System.out.println("Test completed");

		;

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
