package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//rahulonlinetutor@gmail.com
public class LandingPage {

	public WebDriver driver;

	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By Header = By.cssSelector("div[class*='video-banner'] h3");
	By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;

	}

	public WebElement getNavigationBar() {
		return driver.findElement(NavBar);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getHeader() {
		return driver.findElement(Header);
	}


}
