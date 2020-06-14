package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	public WebDriver driver;
	public Properties prop = new Properties();

	public WebDriver initializeDriver() throws IOException

	{		
		//FileInputStream fls = new FileInputStream("C:\\Users\\amit\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		// Replace  hard coded path of above statement with java command  System.getprperty("user.dir)
		
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fls);
		//mvn test -Dbrowser = chrome **this is mvn command to run test using browser parameter
		
		String browserName = System.getProperty("browser"); // this command teske browser from mvn command
		
		//String browserName = prop.getProperty("browser"); // this is line get browser from data property file

		if (browserName.contains("chrome"));

		{
			
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");

			ChromeOptions option = new ChromeOptions();
			
			if (browserName.contains("headless")) // to run the browser in headless mode
			{
				option.addArguments("headless");
			}
			
			driver = new ChromeDriver(option);

		}

		if (browserName.equals("firefox"));

		{
			// write a code for firefox

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}





}
