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
public class Withdrawal1Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void withdrawal1() {
    // Test name: Withdrawal1
    // Step # | name | target | value
    // 1 | open | /solium/servlet/adminLogout.do?state=loggedout | 
    driver.get("http://localhost:7001/solium/servlet/adminLogout.do?state=loggedout");
    // 2 | setWindowSize | 1196x1026 | 
    driver.manage().window().setSize(new Dimension(1196, 1026));
    // 3 | click | linkText=Sign back in | 
    driver.findElement(By.linkText("Sign back in")).click();
    // 4 | type | id=password | q1w2e3r4
    driver.findElement(By.id("password")).sendKeys("q1w2e3r4");
    // 5 | click | id=sw-contentMain | 
    driver.findElement(By.id("sw-contentMain")).click();
    // 6 | type | id=account_number_input | SA12345678
    driver.findElement(By.id("account_number_input")).sendKeys("SA12345678");
    // 7 | click | css=#account-input-container > .row | 
    driver.findElement(By.cssSelector("#account-input-container > .row")).click();
    // 8 | click | css=#submit-box > input | 
    driver.findElement(By.cssSelector("#submit-box > input")).click();
    // 9 | type | id=search_value | CS00057592
    driver.findElement(By.id("search_value")).sendKeys("CS00057592");
    // 10 | click | id=search | 
    driver.findElement(By.id("search")).click();
    // 11 | click | linkText=HARPER, DOERING | 
    driver.findElement(By.linkText("HARPER, DOERING")).click();
    // 12 | click | css=#Transaction\ View\ of\ Manulife\ GSOP\ \(US\)_table tr:nth-child(4) > .newReportCellStyle:nth-child(7) > .withdrawal-link | 
    driver.findElement(By.cssSelector("#Transaction\\ View\\ of\\ Manulife\\ GSOP\\ \\(US\\)_table tr:nth-child(4) > .newReportCellStyle:nth-child(7) > .withdrawal-link")).click();
    // 13 | click | id=purchase_selection_earliest | 
    driver.findElement(By.id("purchase_selection_earliest")).click();
    // 14 | click | id=ee_quantity_60243648784_60243644394 | 
    driver.findElement(By.id("ee_quantity_60243648784_60243644394")).click();
    // 15 | type | id=ee_quantity_60243648784_60243644394 | 5
    driver.findElement(By.id("ee_quantity_60243648784_60243644394")).sendKeys("5");
    // 16 | click | id=er_quantity_60243648784_60243644394 | 
    driver.findElement(By.id("er_quantity_60243648784_60243644394")).click();
    // 17 | type | id=er_quantity_60243648784_60243644394 | 5
    driver.findElement(By.id("er_quantity_60243648784_60243644394")).sendKeys("5");
    // 18 | click | css=#tranche_plan_top_next_continue_button_div > .primaryActionButton | 
    driver.findElement(By.cssSelector("#tranche_plan_top_next_continue_button_div > .primaryActionButton")).click();
    // 19 | click | css=.primaryActionButton | 
    driver.findElement(By.cssSelector(".primaryActionButton")).click();
    // 20 | click | id=CASH_MAIL_TO_PARTICIPANT | 
    driver.findElement(By.id("CASH_MAIL_TO_PARTICIPANT")).click();
    // 21 | click | id=gwt-debug-withdrawalDeliveryInstruction_nextButton | 
    driver.findElement(By.id("gwt-debug-withdrawalDeliveryInstruction_nextButton")).click();
    // 22 | click | id=confirm_transaction_button | 
    driver.findElement(By.id("confirm_transaction_button")).click();
    // 23 | click | css=tr:nth-child(2) > .staticAddEditTableRightCell | 
    driver.findElement(By.cssSelector("tr:nth-child(2) > .staticAddEditTableRightCell")).click();
    // 24 | click | css=tr:nth-child(2) > .staticAddEditTableRightCell | 
    driver.findElement(By.cssSelector("tr:nth-child(2) > .staticAddEditTableRightCell")).click();
    // 25 | click | id=nav_tools | 
    driver.findElement(By.id("nav_tools")).click();
    // 26 | click | id=main-wrapper | 
    driver.findElement(By.id("main-wrapper")).click();
    // 27 | click | linkText=Search for Transaction | 
    driver.findElement(By.linkText("Search for Transaction")).click();
    // 28 | click | name=withdrawalReference | 
    driver.findElement(By.name("withdrawalReference")).click();
    // 29 | type | name=withdrawalReference | WRC32E25941-1ER
    driver.findElement(By.name("withdrawalReference")).sendKeys("WRC32E25941-1ER");
    // 30 | click | name=action | 
    driver.findElement(By.name("action")).click();
    // 31 | click | css=b:nth-child(1) | 
    vars.put("window_handles", driver.getWindowHandles());
    // 32 | storeWindowHandle | root | 
    driver.findElement(By.cssSelector("b:nth-child(1)")).click();
    // 33 | selectWindow | handle=${win1903} | 
    vars.put("win1903", waitForWindow(2000));
    // 34 | click | css=td > table .tableTitle | 
    vars.put("root", driver.getWindowHandle());
    // 35 | click | name=reference_number | 
    driver.switchTo().window(vars.get("win1903").toString());
    // 36 | type | name=reference_number | WRC32E25941-1ER
    driver.findElement(By.cssSelector("td > table .tableTitle")).click();
    // 37 | sendKeys | name=reference_number | ${KEY_ENTER}
    driver.findElement(By.name("reference_number")).click();
    // 38 | click | name=reference_number | 
    driver.findElement(By.name("reference_number")).sendKeys("WRC32E25941-1ER");
    // 39 | type | name=reference_number | WRC32E25941-1ER
    driver.findElement(By.name("reference_number")).sendKeys(Keys.ENTER);
    // 40 | click | css=#cfoAction_div tr:nth-child(3) input:nth-child(1) | 
    driver.findElement(By.name("reference_number")).click();
    // 41 | click | linkText=Add Fill | 
    driver.findElement(By.name("reference_number")).sendKeys("WRC32E25941-1ER");
    // 42 | click | css=tr:nth-child(30) > td:nth-child(2) | 
    driver.findElement(By.cssSelector("#cfoAction_div tr:nth-child(3) input:nth-child(1)")).click();
    // 43 | click | css=tr:nth-child(20) > td:nth-child(2) | 
    driver.findElement(By.linkText("Add Fill")).click();
    // 44 | click | css=tr:nth-child(20) > td:nth-child(2) | 
    driver.findElement(By.cssSelector("tr:nth-child(30) > td:nth-child(2)")).click();
    // 45 | click | name=fill_quantity | 
    driver.findElement(By.cssSelector("tr:nth-child(20) > td:nth-child(2)")).click();
    // 46 | type | name=fill_quantity | 10
    driver.findElement(By.cssSelector("tr:nth-child(20) > td:nth-child(2)")).click();
    // 47 | click | css=tr:nth-child(30) > td:nth-child(2) | 
    driver.findElement(By.name("fill_quantity")).click();
    // 48 | click | css=tr:nth-child(30) > td:nth-child(2) | 
    driver.findElement(By.name("fill_quantity")).sendKeys("10");
    // 49 | click | name=fill_price | 
    driver.findElement(By.cssSelector("tr:nth-child(30) > td:nth-child(2)")).click();
    // 50 | type | name=fill_price | 19.59
    driver.findElement(By.cssSelector("tr:nth-child(30) > td:nth-child(2)")).click();
    // 51 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.name("fill_price")).click();
    // 52 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.name("fill_price")).sendKeys("19.59");
    // 53 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 54 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 55 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 56 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 57 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 58 | click | css=body | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 59 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 60 | close |  | 
    driver.findElement(By.cssSelector("body")).click();
    // 61 | selectWindow | handle=${root} | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 62 | click | css=b:nth-child(1) | 
    driver.close();
    // 63 | selectWindow | handle=${win1848} | 
    driver.switchTo().window(vars.get("root").toString());
    // 64 | click | css=p:nth-child(2) | 
    vars.put("window_handles", driver.getWindowHandles());
    // 65 | click | linkText=Add Fill | 
    driver.findElement(By.cssSelector("b:nth-child(1)")).click();
    // 66 | click | css=tr:nth-child(20) | 
    vars.put("win1848", waitForWindow(2000));
    // 67 | click | name=fill_quantity | 
    driver.switchTo().window(vars.get("win1848").toString());
    // 68 | click | name=fill_quantity | 
    driver.findElement(By.cssSelector("p:nth-child(2)")).click();
    // 69 | type | name=fill_quantity | 10
    driver.findElement(By.linkText("Add Fill")).click();
    // 70 | click | css=tr:nth-child(20) > td:nth-child(2) | 
    driver.findElement(By.cssSelector("tr:nth-child(20)")).click();
    // 71 | click | css=tr:nth-child(20) > td:nth-child(2) | 
    driver.findElement(By.name("fill_quantity")).click();
    // 72 | doubleClick | css=tr:nth-child(20) > td:nth-child(2) | 
    driver.findElement(By.name("fill_quantity")).click();
    // 73 | click | css=tbody:nth-child(2) > tr:nth-child(1) | 
    driver.findElement(By.name("fill_quantity")).sendKeys("10");
    // 74 | click | css=tr:nth-child(30) > td:nth-child(2) | 
    driver.findElement(By.cssSelector("tr:nth-child(20) > td:nth-child(2)")).click();
    // 75 | click | css=tr:nth-child(30) > td:nth-child(2) | 
    driver.findElement(By.cssSelector("tr:nth-child(20) > td:nth-child(2)")).click();
    // 76 | click | name=fill_price | 
    {
      WebElement element = driver.findElement(By.cssSelector("tr:nth-child(20) > td:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    // 77 | type | name=fill_price | 19.59
    driver.findElement(By.cssSelector("tbody:nth-child(2) > tr:nth-child(1)")).click();
    // 78 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector("tr:nth-child(30) > td:nth-child(2)")).click();
    // 79 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector("tr:nth-child(30) > td:nth-child(2)")).click();
    // 80 | click | css=tr:nth-child(1) > td:nth-child(2) | 
    driver.findElement(By.name("fill_price")).click();
    // 81 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.name("fill_price")).sendKeys("19.59");
    // 82 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 83 | click | name=fill_date | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 84 | click | name=fill_date | 
    driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).click();
    // 85 | type | name=fill_date | 11-Mar-2022 16:42
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 86 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 87 | click | name=fill_date | 
    driver.findElement(By.name("fill_date")).click();
    // 88 | type | name=fill_date | 11-Mar-2022 16:43
    driver.findElement(By.name("fill_date")).click();
    // 89 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.name("fill_date")).sendKeys("11-Mar-2022 16:42");
    // 90 | click | name=fill_date | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 91 | click | css=.defaultTextBold > input:nth-child(2) | 
    driver.findElement(By.name("fill_date")).click();
    // 92 | selectWindow | handle=${root} | 
    driver.findElement(By.name("fill_date")).sendKeys("11-Mar-2022 16:43");
    // 93 | click | css=b:nth-child(1) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 94 | selectWindow | handle=${win1848} | 
    driver.findElement(By.name("fill_date")).click();
    // 95 | click | linkText=Add Fill | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(2)")).click();
    // 96 | click | css=tr:nth-child(20) > td:nth-child(2) | 
    driver.switchTo().window(vars.get("root").toString());
    // 97 | click | name=fill_quantity | 
    driver.findElement(By.cssSelector("b:nth-child(1)")).click();
    // 98 | type | name=fill_quantity | 10
    driver.switchTo().window(vars.get("win1848").toString());
    // 99 | click | name=fill_price | 
    driver.findElement(By.linkText("Add Fill")).click();
    // 100 | click | css=tr:nth-child(21) > td:nth-child(2) | 
    driver.findElement(By.cssSelector("tr:nth-child(20) > td:nth-child(2)")).click();
    // 101 | click | css=tr:nth-child(30) > td:nth-child(2) | 
    driver.findElement(By.name("fill_quantity")).click();
    // 102 | click | name=fill_price | 
    driver.findElement(By.name("fill_quantity")).sendKeys("10");
    // 103 | type | name=fill_price | 19.59
    driver.findElement(By.name("fill_price")).click();
    // 104 | mouseDownAt | css=.defaultTextBold > input:nth-child(1) | 38.670135498046875,13.197895050048828
    driver.findElement(By.cssSelector("tr:nth-child(21) > td:nth-child(2)")).click();
    // 105 | mouseMoveAt | css=.defaultTextBold > input:nth-child(1) | 38.670135498046875,13.197895050048828
    driver.findElement(By.cssSelector("tr:nth-child(30) > td:nth-child(2)")).click();
    // 106 | mouseUpAt | css=.defaultTextBold > input:nth-child(1) | 38.670135498046875,13.197895050048828
    driver.findElement(By.name("fill_price")).click();
    // 107 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.name("fill_price")).sendKeys("19.59");
    // 108 | click | css=.defaultTextBold > input:nth-child(2) | 
    {
      WebElement element = driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 109 | click | linkText=Add Fill | 
    {
      WebElement element = driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 110 | click | css=tr:nth-child(20) > td:nth-child(2) | 
    {
      WebElement element = driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 111 | click | css=tr:nth-child(20) > td:nth-child(2) | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click();
    // 112 | click | name=fill_quantity | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(2)")).click();
    // 113 | type | name=fill_quantity | 10
    driver.findElement(By.linkText("Add Fill")).click();
    // 114 | click | name=fill_price | 
    driver.findElement(By.cssSelector("tr:nth-child(20) > td:nth-child(2)")).click();
    // 115 | click | css=tr:nth-child(22) > td:nth-child(2) | 
    driver.findElement(By.cssSelector("tr:nth-child(20) > td:nth-child(2)")).click();
    // 116 | click | css=tr:nth-child(30) > td:nth-child(2) | 
    driver.findElement(By.name("fill_quantity")).click();
    // 117 | click | name=fill_price | 
    driver.findElement(By.name("fill_quantity")).sendKeys("10");
    // 118 | type | name=fill_price | 19.59
    driver.findElement(By.name("fill_price")).click();
    // 119 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector("tr:nth-child(22) > td:nth-child(2)")).click();
    // 120 | click | css=.defaultTextBold > input:nth-child(1) | 
    driver.findElement(By.cssSelector("tr:nth-child(30) > td:nth-child(2)")).click();
    // 121 | click | css=td > input:nth-child(2) | 
    driver.findElement(By.name("fill_price")).click();
    // 122 | close |  | 
    driver.findElement(By.name("fill_price")).sendKeys("19.59");
    // 123 | selectWindow | handle=${root} | 
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click(); //Verify Fill Button
    driver.findElement(By.cssSelector(".defaultTextBold > input:nth-child(1)")).click(); //commit button
    driver.findElement(By.cssSelector("td > input:nth-child(2)")).click();
    driver.close();
    driver.switchTo().window(vars.get("root").toString());
  }
}
