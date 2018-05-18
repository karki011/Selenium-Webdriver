package developer.google;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	
	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		
		try 
		{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid white;');", element);	
	}
	
}
