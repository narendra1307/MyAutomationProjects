package demo;

import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
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

    
    public  void testCase00(){
        System.out.println("Start Test case: testCase00");
        driver.get("https://www.google.com");
        System.out.println("end Test case: testCase00");
    }

    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.navigate().to("https://www.makemytrip.com/");
        if(driver.getCurrentUrl().contains("makemytrip"))
        {
            System.out.println("Testcase01 Passed : The URL of the Make My Trip homepage contains \"makemytrip");
        }
        else
        {
           System.out.println("Testcase01 Failed : The URL of the Make My Trip homepage not contains \"makemytrip");
 
        }

        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.navigate().to("https://www.makemytrip.com/");

        //driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
        Thread.sleep(3000);

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        fromCity.sendKeys("blr");

        //Thread.sleep(3000);

        WebElement selectFromCity = driver.findElement(By.xpath("//p[text()='Bengaluru, India']"));
        selectFromCity.click();

        //Thread.sleep(3000);
        WebElement toCity = driver.findElement(By.id("toCity"));
        toCity.click();
        toCity.sendKeys("del");

        WebElement selectToCity = driver.findElement(By.xpath("//p[text()='New Delhi, India']"));
        selectToCity.click();
        //Thread.sleep(3000);
        
        //Click on Departure Catendar
        //driver.findElement(By.xpath("//input[@id='departure']")).click();

        String date = "January 2024";

        while(driver.findElement(By.xpath("//div[@role='heading']//div[1]")).isDisplayed()){

            //System.out.println("Testcase02 : " + driver.findElement(By.xpath("//div[@role='heading']//div[1]")));
            driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
            String currMonth =driver.findElement(By.xpath("//div[@role='heading']//div[1]")).getText();
            if(date.equalsIgnoreCase(currMonth))
            {
                driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']")).click();
                break;
            }
            
        }


        

        driver.findElement(By.xpath("//a[text()='Search']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();

        String tripPrice = driver.findElement(By.xpath("(//div[@class='textRight flexOne'])[1]")).getText();
        System.out.println("Rate per adult==" +tripPrice);

        System.out.println("Testcase02 Passed : The correct flight details are obtained and the price per adult is stored");

        System.out.println("end Test case: testCase02");
    }

    public void testCase03() throws InterruptedException
    {
        System.out.println("Start Test case: testcase03");
        driver.get("https://www.makemytrip.com/");

       
        Thread.sleep(3000);

        WebElement trains = driver.findElement(By.xpath("//span[@class='headerIconTextAlignment chNavText darkGreyText' and text()='Trains']"));
        trains.click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        fromCity.sendKeys("ypr");

        Thread.sleep(3000);

        WebElement selectFromCity = driver.findElement(By.xpath("//span[text()='Bangalore']"));
        selectFromCity.click();

        Thread.sleep(3000);

        WebElement toCity = driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']"));
        //toCity.click();
        toCity.sendKeys("ndls");

        Thread.sleep(2000);

        WebElement selectToCity = driver.findElement(By.xpath("//span[text()='NDLS']"));
        selectToCity.click();
        Thread.sleep(3000);

        String date = "January 2024";

        while(driver.findElement(By.xpath("//div[@role='heading']//div[1]")).isDisplayed()){

            System.out.println("Testcase03 : " + driver.findElement(By.xpath("//div[@role='heading']//div[1]")));
            driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
            String currMonth =driver.findElement(By.xpath("//div[@role='heading']//div[1]")).getText();
            if(date.equalsIgnoreCase(currMonth))
            {
                driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']")).click();
                break;
            }
            
        }


 

        driver.findElement(By.xpath("//li[text()='Third AC']")).click();

        driver.findElement(By.xpath("//a[text()='Search']")).click();

        Thread.sleep(3000);
        String trainRate= driver.findElement(By.xpath("//div[@class='ticket-price justify-flex-end' and text()=2225]")).getText();
        System.out.println("Train Rate ==" +trainRate);

        System.out.println("Testcase03 Passed : The correct train details are obtained.");

        


    }

    public void testCase04() throws InterruptedException
    {
        System.out.println("Start Test case: testcase04");
        driver.get("https://www.makemytrip.com/");

        
        Thread.sleep(3000);

        WebElement trains = driver.findElement(By.xpath("//span[@class='headerIconTextAlignment chNavText darkGreyText' and text()='Buses']"));
        trains.click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys("bangl");
        driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka']")).click();

        WebElement toCity = driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']"));
        toCity.sendKeys("del");
        driver.findElement(By.xpath("//span[text()='Delhi']")).click();

        Thread.sleep(3000);

        String date = "January 2024";

        while(driver.findElement(By.xpath("//div[@role='heading']//div[1]")).isDisplayed()){

            System.out.println("Testcase04 : " + driver.findElement(By.xpath("//div[@role='heading']//div[1]")));
            driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
            String currMonth =driver.findElement(By.xpath("//div[@role='heading']//div[1]")).getText();
            if(date.equalsIgnoreCase(currMonth))
            {
                driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']")).click();
                break;
            }
            
        }

        
        driver.findElement(By.xpath("//button[text()='Search']")).click();

        Thread.sleep(3000);

        String msg = driver.findElement(By.xpath("//span[text()='No buses found for 20 Jan']")).getText();

        if(msg.equals("No buses found for 20 Jan"))
        {
            System.out.println("Testcase04 Passed : The message \"No buses found\" is displayed for the specified route and date");
        }
        else
        {
            System.out.println("Testcase04 Failed : The message \"No buses found\" is not displayed for the specified route and date");
        }

        


    }



}
