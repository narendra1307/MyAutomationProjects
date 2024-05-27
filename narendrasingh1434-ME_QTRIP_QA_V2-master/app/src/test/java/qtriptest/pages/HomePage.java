package qtriptest.pages;


import org.apache.logging.log4j.message.Message;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;


public class HomePage {

    RemoteWebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/";
    

    //**** Web Elements in the Pages */
    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerBtn;

    @FindBy(xpath = "//div[text()='Logout']")
    private WebElement logoutButton;


    public HomePage(RemoteWebDriver driver)
    {
        this.driver = driver;   
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

    }

    public void navigateToHomePage(){
        driver.get(url);
        driver.manage().window().maximize();

    }

    public void clickRegisterPage() {
        registerBtn.click();
        //Thread.sleep(2000);
        //Verify Register Page is displayed
        //Assert.assertEquals(driver.getCurrentUrl(), "https://qtripdynamic-qa-frontend.vercel.app/pages/register/");
    
    }

    public Boolean isUserLoggedIn()
    {
        boolean status = logoutButton.isDisplayed();
        //System.out.println(status);
        return status;
    }

    public void logOutUser()
    {
        logoutButton.click();
    }










}
