// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class NewrecordTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() throws MalformedURLException {
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void newrecord() {
    // Test name: new record
    // Step # | name | target | value
    // 1 | open | /solium/servlet/userLogin.do | 
    driver.get("http://localhost:7001/solium/servlet/userLogin.do");
    // 2 | setWindowSize | 1497x1021 | 
    driver.manage().window().setSize(new Dimension(1497, 1021));
    // 3 | click | id=account_number_input | 
    driver.findElement(By.id("account_number_input")).click();
    // 4 | click | id=password | 
    driver.findElement(By.id("password")).click();
    // 5 | click | css=#submit-box > input | 
    driver.findElement(By.cssSelector("#submit-box > input")).click();
    // 6 | click | id=nav_tools | 
    driver.findElement(By.id("nav_tools")).click();
    // 7 | click | linkText=Deleted Transaction Summary | 
    driver.findElement(By.linkText("Deleted Transaction Summary")).click();
    // 8 | click | css=.gwt-InlineHTML:nth-child(1) | 
    driver.findElement(By.cssSelector(".gwt-InlineHTML:nth-child(1)")).click();
    // 9 | click | css=.gwt-InlineHTML:nth-child(1) | 
    driver.findElement(By.cssSelector(".gwt-InlineHTML:nth-child(1)")).click();
    // 10 | click | css=.ZSe-h:nth-child(16) | 
    driver.findElement(By.cssSelector(".ZSe-h:nth-child(16)")).click();
  }
}
