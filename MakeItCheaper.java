package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class MakeItCheaper {
 public static void main(String[] args) throws InterruptedException {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\david\\eclipse-workspace\\TestAuto\\libs\\geckodriver.exe");
  WebDriver driver = new FirefoxDriver();
 driver.get("https://staging:Password1@business-energy-staging.makeitcheaper.com");
 driver.manage().window().maximize();

 driver.findElement(By.id("postcode-field")).sendKeys("EC3R 7AG");
 driver.findElement(By.id("compare-button")).click();
 
 Thread.sleep(5000);
 driver.findElement(By.xpath("//label[contains(text(),'Electricity')]")).click();
 driver.findElement(By.id("address-field")).sendKeys("The Minster Building, 21 Mincing Ln, London");
 driver.findElement(By.xpath("//a[@id='mpan-manual-open']")).click();

 driver.findElement(By.xpath("//div[@class='top-line']//span[1]//input[1]")).sendKeys("03");
 driver.findElement(By.xpath("//span[@class='middle']//input[@class='connected']")).sendKeys("801");
 driver.findElement(By.xpath("//span[@class='last manual']//input[@class='connected']")).sendKeys("110");
 driver.findElement(By.xpath("//span[@class='first']//input[@class='connected']")).sendKeys("22");
 driver.findElement(By.xpath("//div[@class='bottom-line']//span[2]//input[1]")).sendKeys("0001");
 driver.findElement(By.xpath("//div[@class='bottom-line']//span[3]//input[1]")).sendKeys("4969");
 driver.findElement(By.xpath("//span[@class='last']//input[@class='connected']")).sendKeys("380");
 WebElement Webelement = driver.findElement(By.xpath("//div[@class='question-container']//div[3]//label[1]//img[1]"));
 
 JavascriptExecutor jse = (JavascriptExecutor)driver;
 jse.executeScript("arguments[0].scrollIntoView()", Webelement);
 Webelement.click();
 driver.findElement(By.xpath("//input[@id='spend-total']")).sendKeys("400");
   
 Select periodSelect = new Select(driver.findElement(By.id("consumption_period")));
 periodSelect.selectByVisibleText("Quarter");
 
 driver.findElement(By.id("details_quote_name")).sendKeys("Toyin Ola");
 driver.findElement(By.id("details_quote_business_name")).sendKeys("Toyin Limited");
 driver.findElement(By.id("details_quote_phone_number")).sendKeys("07582525676");
 driver.findElement(By.id("details_quote_email")).sendKeys("toyin@yahoo.com");
 WebElement showResults = driver.findElement(By.className("button-text"));
 
 JavascriptExecutor show = (JavascriptExecutor)driver;
 show.executeScript("arguments[0].scrollIntoView()", showResults);
 showResults.click();
 
 String confirmationResult = driver.findElement(By.xpath("//div[@class='dialog']//div")).getText();
 System.out.println(confirmationResult);
 driver.close();  

}
}
