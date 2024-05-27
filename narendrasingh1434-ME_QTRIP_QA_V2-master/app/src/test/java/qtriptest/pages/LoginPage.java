package qtriptest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {


    RemoteWebDriver driver;
    private final static String Login_Page_Identifier = "/pages/login";

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement Password;

    @FindBy(xpath = "//button[text()= 'Login to QTrip']")
    private WebElement loginButton;

    public LoginPage(RemoteWebDriver driver)
    {
        this.driver = driver;   
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

    }

    

    public Boolean isLoginPage()
    {
        boolean status = driver.getCurrentUrl().contains(Login_Page_Identifier);
        return status;
    }

    public void performLogin(String username, String password) throws InterruptedException
    {

        
        email.sendKeys(username);
        Password.sendKeys(password);
        
        loginButton.click();
       
        
    }


}
