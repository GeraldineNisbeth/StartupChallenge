package startup.challenge;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Apptests {
	private WebDriver webdriver;
	
	@Before
	public void SetDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\Chromedriver\\chromedriver.exe");
		webdriver = new ChromeDriver();
	}
	
	@Test
	public void testParameters() {
		webdriver.get("https://apprater.net/add/");
		webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		sendText("myname", "name", "user-submitted-name", "Juan");
		sendText("myname", "name", "user-submitted-email", "Perez");
		sendText("myname", "xpath", "//*[@id=\"usp_form\"]/fieldset[1]/input", "Television plasma");
		sendText("myname", "css", "#usp_form>div.input_fields_wrap>fieldset>input", "http://facebook.com");
		sendText("myname", "xpath", "//*[@id=\"usp_form\"]/fieldset[2]/textarea", "45' and can be used for entertainment");
				
	}
	
	@After
	public void tearDown() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		webdriver.quit();
	}
	
	public void sendText(String label, String selectorType, String selector, String value ) {
		WebElement elementInput;
	
		switch (selectorType) {
		case "name":
			elementInput = webdriver.findElement(By.name(selector));	
			break;
		case "css":
			elementInput = webdriver.findElement(By.cssSelector(selector));	
			break;
		case "xpath":
			elementInput = webdriver.findElement(By.xpath(selector));	
			break;
		default:
			elementInput = null;
		}
		
		elementInput.sendKeys(value);
	}
}
