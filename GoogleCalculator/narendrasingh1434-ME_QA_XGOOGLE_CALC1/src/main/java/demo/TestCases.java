package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    
    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");

        WebElement searchbar = driver.findElement(By.id("APjFqb"));
        searchbar.click();
        searchbar.sendKeys("calculator");
        searchbar.sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        String pageTitle = driver.getTitle();
        String expectedTitle = "calculator";

        if(pageTitle.contains(expectedTitle))
        {
            System.out.println("Google calculator Loaded");
        }
        else
        {
            System.out.println("Google calculator not loaded");
        }

        String initialDisplay = driver.findElement(By.id("cwos")).getText();

        String display = "0";

        if(initialDisplay.equals(display))
        {
            System.out.println("Testcase01 Passed : The Google Calculator loaded, and the initial display show the specified value 0.");
        }
        else
        {
            System.out.println("Testcase01 Failed : The Google Calculator loaded, and the initial display not show the specified value 0.");
        }

        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.google.com");

        WebElement searchbar = driver.findElement(By.id("APjFqb"));
        searchbar.click();
        searchbar.sendKeys("calculator");
        searchbar.sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        String pageTitle = driver.getCurrentUrl();
        String expectedTitle = "google";

        if(pageTitle.contains(expectedTitle))
        {
            System.out.println("Google calculator Loaded");
        }
        else
        {
            System.out.println("Google calculator not loaded");
        }

        driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr[3]/td[2]//div[@role='button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[5]/td[4]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr[2]/td[1]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr[5]/td[3]//div[@role='button']")).click();
        Thread.sleep(2000);

        String actualResult = driver.findElement(By.id("cwos")).getText();
        String expectedResult = "12";
        if(actualResult.equals(expectedResult))
        {
            System.out.println("Addition Testcase02 Passed"+actualResult);
        }
        else
        {
            System.out.println("Addition Testcase02 Failed");
        }

        driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr[4]/td[1]//div[@role='button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[3]/td[2]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr[4]/td[4]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr[2]/td[2]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr[5]/td[3]//div[@role='button']")).click();
        Thread.sleep(2000);

        String actualResult2 = driver.findElement(By.id("cwos")).getText();
        String expectedResult2 = "7";
        if(actualResult2.equals(expectedResult2))
        {
            System.out.println("Substraction Testcase02 Passed");
        }
        else
        {
            System.out.println("Substraction Testcase02 Failed");
        }

       // System.out.println(actualResult+ " " +actualResult2);


    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.google.com");

        WebElement searchbar = driver.findElement(By.id("APjFqb"));
        searchbar.click();
        searchbar.sendKeys("calculator");
        searchbar.sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[4]/td[1]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[5]/td[1]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[3]/td[4]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[4]/td[3]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[5]/td[3]//div[@role='button']")).click();

        String actualResult = driver.findElement(By.id("cwos")).getText();
        String expectedResult = "30";
        if(actualResult.equals(expectedResult))
        {
            System.out.println("Testcase03 Passed");
        }
        else{
            System.out.println("Testcase03 Failed");   
        }

        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[1]/td[4]//div[@role='button']")).click();
        Thread.sleep(2000);

        String display = driver.findElement(By.id("cwos")).getText();

        String Expecteddisplay = "0";

        if(display.equals(Expecteddisplay))
        {
            System.out.println("Testcase03 Passed : display show the value 0.");
        }
        else
        {
            System.out.println("Testcase03 Failed : display does not show the value 0.");
        }

        System.out.println("end Test case: testCase03");


    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.google.com");

        WebElement searchbar = driver.findElement(By.id("APjFqb"));
        searchbar.click();
        searchbar.sendKeys("calculator");
        searchbar.sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[4]/td[2]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[5]/td[1]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[2]/td[4]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[3]/td[1]//div[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class=\"ElumCf\"]/tbody/tr[5]/td[3]//div[@role='button']")).click();


        String actualResult = driver.findElement(By.id("cwos")).getText();
        String expectedResult = "5";
        if(actualResult.equals(expectedResult))
        {
            System.out.println("Testcase04 Passed");
        }

    }



}
