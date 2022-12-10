package CreatedBug;

import net.rcarz.jiraclient.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestClass {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    private static final Logger _logger = LoggerFactory.getLogger(TestClass.class);

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/hong.lu/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws JiraException {
        driver.quit();
        if(result.getStatus() == ITestResult.FAILURE) {
            BasicCredentials credentials = new BasicCredentials("hong.lu", "Lu112169");
            JiraClient jira = new JiraClient("https://jira.solium.com", credentials);
            Issue issueName = jira.createIssue("DEV", "Bug")
                    .field(Field.SUMMARY, result.getMethod().getMethodName() + " is failed due to " + result.getThrowable().toString())
                    .field(Field.DESCRIPTION, "get description")
                    .execute();
            issueName.getKey();
            System.out.println("Issue is created in JIRA with issue number " +  issueName.getKey());
            _logger.info("Issue is created in JIRA with issue number {}", issueName.getKey());

        }
    }

    @Test
    public void Test() {
        driver.navigate().to("https://automationtalks.com/");
        System.out.println("Test title is " + driver.getTitle());
        _logger.info("Test title is {}", driver.getTitle());
        Assert.assertEquals(" Expected Title ", driver.getTitle());

    }
}
