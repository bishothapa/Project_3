package ableToAddCategory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCategory {

	static WebDriver driver;
	 String browser;
     
	@BeforeClass
	public void readConfig() {

		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser used:" + browser);

		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	@BeforeMethod
	public void init() {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get("http://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void AbletoAddCategory() {
		System.out.println(" Validate a user is able to add a category");
		By AbleToAddCategory = By.xpath("//body/div[4]/span[1]/input[1]");
//		By ClickonAddButton = By.xpath("//body/div[4]/span[1]/input[2]");
		By ClickonSelectColorButton = By.xpath("//span[contains(text(),'CHRISTMAS2021')]");

		driver.findElement(AbleToAddCategory).clear();
		driver.findElement(AbleToAddCategory).sendKeys("CHRISTMAS2021");
//		driver.findElement(ClickonAddButton).click();
		driver.findElement(ClickonSelectColorButton).click();
		driver.findElement(ClickonSelectColorButton).getCssValue("Brunt Orange");

//		String AbleToAddCategory  = "TestNGproject";
//		driver.findElement(AbleToAddCategory).sendKeys("TechFios_June2021");
//		driver.findElement(ClickonAddButton).click();
	}
		@Test(priority = 2)
		public void  NotAbleToAddDuplicate() throws InterruptedException {
			
			System.out.println("<duplicated category name>");
			By AbleToAddCategory = By.xpath("//body/div[4]/span[1]/input[1]");
			By ClickonAddButton = By.xpath("//body/div[4]/span[1]/input[2]");
			By ClickonSelectColorButton = By.xpath("//span[contains(text(),'CHRISTMAS2021')]");
			
			driver.findElement(AbleToAddCategory).clear();
			driver.findElement(AbleToAddCategory).sendKeys("CHRISTMAS2021");
			driver.findElement(ClickonAddButton).click();
			Thread.sleep(2000);
			driver.findElement(ClickonSelectColorButton).click();
			Thread.sleep(2000);
			driver.findElement(ClickonSelectColorButton).getCssValue("Brunt Orange");
			Thread.sleep(2000);
		}
			@Test(priority = 3)
 			public void DueDateDropdown() throws InterruptedException {
				 
                System.out.println("Validate the month drop down has all the months");
				By DropDown = By.xpath("//body/div[4]/span[1]/select[4]");
				By ClickonDropDown = By.xpath("//body/div[4]/span[1]/select[3]");
                 
				driver.findElement(DropDown).click();
				Thread.sleep(2000);
				driver.findElement(ClickonDropDown).click();
				Thread.sleep(2000);
				
				
			}
	
		

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
}
}
