package qtriptest.tests;

import qtriptest.DP;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

public class testCase_01 {

    static RemoteWebDriver driver;
     

	// Method to help us log our Unit Tests
	public static void logStatus(String type, String message, String status) {
		System.out.println(String.format("%s |  %s  |  %s | %s",
				String.valueOf(java.time.LocalDateTime.now()), type, message, status));
	}

	// Iinitialize webdriver for our Unit Tests
	@BeforeSuite(alwaysRun = true, enabled = true)
	public static void createDriver() throws MalformedURLException {
		logStatus("driver", "Initializing driver", "Started");
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
		logStatus("driver", "Initializing driver", "Success");
	}


    @Test(description = "testCase_01:Verify user registration and login",dataProvider = "Qtriptestdata", dataProviderClass =DP.class, enabled=true)
    public void TestCase01(String Username, String Password)
    {   
        //test = report.startTest("QTripLogin");

        //System.out.println(Username);
        //System.out.println(Password);
        //SoftAssert sa = new SoftAssert();
        Boolean status;
        logStatus("Start TestCase", "Test Case 1: Verify User Registration", "DONE");
     try{
        HomePage homepage = new HomePage(driver);
        homepage.navigateToHomePage();
        Thread.sleep(2000);
        homepage.clickRegisterPage();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qtripdynamic-qa-frontend.vercel.app/pages/register/")," Register Page is Displayed");
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(3000);
        RegisterPage registerPage = new RegisterPage(driver);
        //sa.assertTrue(registerPage.navigateToRegisterPage(),"Registration page navigation failed");
        Thread.sleep(3000);
        //status = registerPage.registerNewUser("nsingh@gmail.com","abc123","abc123",true);
        status= registerPage.registerNewUser(Username,Password,Password,true);
        Assert.assertTrue(status, "Failed to register new user");
        Thread.sleep(3000);
        //sa.assertTrue(loginPage.isLoginPage(),"Navigate to login page failed");
        
        //loginPage.performLogin(registerPage.User_Email, "123456");
        loginPage.performLogin(registerPage.lastGeneratedEmail, Password);
        //test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");
        if(homepage.isUserLoggedIn()){
            logStatus("Login Success", "User logged in ", "PASS");
        }else{
            logStatus("Login Failed", "User is Not logged in ", "FAIL");
        }
        
        Thread.sleep(3000);
        
        //sa.assertTrue(homepage.isUserLoggedIn(),"Login failed");
        
        homepage.logOutUser();
     }catch(Exception e){
        logStatus("Page test", "testcase01 Failed", "failed");
			e.printStackTrace();
     }
        //sa.assertAll();
    }

}
