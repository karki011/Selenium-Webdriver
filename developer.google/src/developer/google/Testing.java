package developer.google;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testing {
	
	WebDriver driver; 	
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "//Users/skarki//Downloads//chromedriver");
			driver = new ChromeDriver();
			
			driver.manage().deleteAllCookies();
			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://developers.google.com/");
			
			clickEvent();
			confirmText();
			confirmImagine();
			formSubmit();
			Thread.sleep(3000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void clickEvent() {
		try {
			driver.findElement(By.linkText("Events")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void confirmText() {
		String expectedText = "Hone your skills on the latest cloud technologies with Google experts at hundreds of breakout sessions and interactive on-demand hands-on labs and bootcamps. You'll have the opportunity to engage with the best minds in cloud technology on how your industry is adapting, innovating, and growing with cloud.";
		boolean Text = driver.getPageSource().contains(expectedText);
	    if (Text == true)
	    {
	     System.out.print("Found text");
	     driver.findElement(By.linkText("Google Cloud Next ’18")).click();
	    }
	    else
	    {
	     System.out.print("Text not found.");
	    }     	    
	}
	
	public void confirmImagine() {
		
		WebElement strvalue = driver.findElement(By.xpath("//html//div[@class='module']//div[1]/div[1]/div[1]/div[2]/h3[1]"));
		String actual = strvalue.getText();
		System.out.println("Text present  : "+ actual);
		Helper.highLightElement(driver, strvalue);
		
	    if(actual.contains("Imagine")){
	        System.out.println("Pass");
	    }
	    else {
	        System.out.println("Fail");
	    }	  
	}
	
	public void formSubmit() {
		
		driver.findElement(By.xpath("//button[@class='btn hero-cta-btn light-blue btn_border_white']")).click();
		
		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("Subash");
		
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Karki");
		
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("karki011@gmail.com");
		
		WebElement jobTitle = driver.findElement(By.name("jobTitle"));
		jobTitle.sendKeys("Manager");
		
		WebElement company = driver.findElement(By.name("company"));
		company.sendKeys("Muskan Inc.");
		
		Select industry = new Select(driver.findElement(By.name("industry")));
		industry.selectByVisibleText("Retail & Wholesale Trade");

		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText("United States");
		
		WebElement radio1 = driver.findElement(By.xpath("//label[@for='Yes']"));
        radio1.click();		
        
        driver.findElement(By.xpath("//button[@type='button']")).click();

	}
	
	public static void main(String[] args) {
		Testing myObj = new Testing();
		myObj.invokeBrowser();
	}
	
}
