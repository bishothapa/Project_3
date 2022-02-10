package ableToAddCategory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDown {
	WebDriver driver;

	@BeforeTest
	public void init() {

		String browser = "chrome";
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

	@Test
	public void DueDateDropdown() throws InterruptedException {

		By ClickDueDateDropdown = By.xpath("//body/div[4]/span[1]/select[3]");
		By SelectDateJan = By.xpath("//option[contains(text(),'Jan')]");
		By SelectDateFeb = By.xpath("//option[contains(text(),'Feb')]");
		By SelectDateMar = By.xpath("//option[contains(text(),'Mar')]");
		By SelectDateApr = By.xpath("//option[contains(text(),'Apr')]");
		By SelectDateMay = By.xpath("//option[contains(text(),'May')]");
		By SelectDateJun = By.xpath("//option[contains(text(),'Jun')]");
		By SelectDateJul = By.xpath("//option[contains(text(),'Jul')]");
		By SelectDateAug = By.xpath("//option[contains(text(),'Aug')]");
		By SelectDateSep = By.xpath("//option[contains(text(),'Sep')]");
		By SelectDateOct = By.xpath("//option[contains(text(),'Oct')]");
		By SelectDateNov = By.xpath("//option[contains(text(),'Nov')]");
		By SelectDateDec = By.xpath("//body/div[4]/span[1]/select[3]/option[13]");

		driver.findElement(ClickDueDateDropdown).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateJan).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateFeb).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateMar).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateApr).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateMay).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateJun).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateJul).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateAug).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateSep).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateOct).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateNov).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateDec).click();
		Thread.sleep(2000);

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}