package Trip;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Makemytrip {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void url() {

		//driver.get("https://www.abhibus.com/?utm_source=google&utm_medium=cpc&utm_campaign=GenericKW&utm_term=bus%20ticket&utm_content=Generic&gclid=Cj0KCQjwldKmBhCCARIsAP-0rfw2BMYDU-QNOHmJYregiLmPrJbuapBuWHEd0BScQrR-fyr9UOZFUmMaAkfEEALw_wcB");
		driver.get("https://www.abhibus.com/");
	}

	@Test
	public void test() throws Exception {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"source\"]")).sendKeys("Agra");
		driver.findElement(By.xpath("//*[@id=\"source\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id=\"source\"]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"destination\"]")).sendKeys("Delhi");
		driver.findElement(By.xpath("//*[@id=\"destination\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id=\"destination\"]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"datepicker1\"]")).click();
		while (true) {
			WebElement month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]"));

			String month1 = month.getText();
			if (month1.equals("September")) {
				System.out.println(month1);
				break;
			} else {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a/span")).click();

			}
		}
		List<WebElement> alldates = driver
				.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td/a"));

		for (WebElement dateelement : alldates) {
			String date = dateelement.getText();
			if (date.equals("30")) {
				dateelement.click();
				System.out.println("date selected");
			}
		}

		WebElement button = driver.findElement(By.xpath("//*[@id=\"frmFinal\"]/div/div[5]/a"));
		button.click();
		
	
 driver.findElement(By.xpath("//*[@id=\"Bustypes1\"]")).click(); // bus type
  
//  driver.findElement(By.xpath("//*[@id=\"filterPos1\"]/div/div[1]/div[2]/div[4]/div[1]/span[1]/span")).click();// boarding // drop
 // driver.findElement(By.xpath("//*[@id=\"bpoint0\"]/label")).click(); //boarding point
  
  //driver.findElement(By.xpath("//*[@id=\"filterPos1\"]/div/div[1]/div[2]/div[5]/div[1]/span[1]/span")).click(); // dropping // point // arrow
  
  
  //driver.findElement(By.xpath("//*[@id=\"dpoint0\"]/label")).click();
  
  driver.findElement(By.xpath("//*[@id=\"startTime1\"]/p")).click();
  
  WebElement drag = driver.findElement(By.xpath("//*[@id=\"filterPos1\"]/div/div[1]/div[2]/div[7]/div[1]/div[2]/div/div[3]"));
  WebElement drop = driver.findElement(By.xpath("//*[@id=\"filterPos1\"]/div/div[1]/div[2]/div[7]/div[1]/div[2]/div/div[1]/div")); 
  Actions obj = new Actions(driver); obj.dragAndDrop(drag, drop);
  obj.perform(); String text = drop.getText();
  if (text.equals("handle high"))
  { System.out.println("not dropped"); } 
  else
  
  { System.out.println(" dropped"); } JavascriptExecutor js =
  (JavascriptExecutor) driver; js.executeScript("scroll(0,-250);");
  
  String parentwindow = driver.getWindowHandle();
  
  driver.findElement(By.xpath("//*[@id=\"1665037247\"]")).click();
  
  Set<String> allwindowhandles = driver.getWindowHandles();
  for (String handle: allwindowhandles) {
  
  System.out.println(handle); 
  if (!handle.equalsIgnoreCase(parentwindow)) {
  driver.switchTo().window(handle); driver.close(); }
  driver.switchTo().window(parentwindow);
  
  }
  
  driver.findElement(By.xpath("//*[@id=\"O5-12ZZ\"]")).click();
 /*driver.findElement(By.xpath("//*[@id=\"boardingpoint_id\"]")).sendKeys(Keys.ARROW_DOWN);
 driver.findElement(By.xpath("//*[@id=\"droppingpoint_id\"]")).sendKeys(Keys.ENTER);
  driver.findElement(By.xpath("//*[@id=\"droppingpoint_id\"]")).sendKeys(Keys.ARROW_DOWN);
 driver.findElement(By.xpath("//*[@id=\"droppingpoint_id\"]/option[2]")).sendKeys(Keys.ENTER);*/
  driver.findElement(By.xpath("//*[@id=\"btnEnable1\"]")).click();
  }
  }
  
 

	
