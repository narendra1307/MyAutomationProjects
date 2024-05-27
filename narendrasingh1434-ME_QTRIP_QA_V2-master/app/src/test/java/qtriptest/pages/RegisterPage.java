package qtriptest.pages;

import java.util.UUID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage {
    RemoteWebDriver driver;
    public static String userEmail;
    public String lastGeneratedEmail="";

    @FindBy(name = "email")
    private WebElement username_txt_box;

    @FindBy(name = "password")
    private WebElement password_text_box;

    @FindBy(name = "confirmpassword")
    private WebElement confirmpassword_text_box;

    @FindBy(xpath = "//button[text() = 'Register Now']")
    private WebElement registernow_button;

    public RegisterPage(RemoteWebDriver driver)
    {
        this.driver = driver;   
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

    }

    public boolean registerNewUser(String Username, String Password, String confirmPassword, boolean makeUserDynameic) throws InterruptedException
    {
        if (makeUserDynameic){
          userEmail = Username.split("@")[0]+UUID.randomUUID().toString() +"@"+ Username.split("@")[1];
        }else{
          userEmail = Username;
        }
        
        username_txt_box.sendKeys(userEmail);
        password_text_box.sendKeys(Password);
        confirmpassword_text_box.sendKeys(confirmPassword);
        registernow_button.click();

        this.lastGeneratedEmail = userEmail;

        Thread.sleep(3000);

        

        return this.driver.getCurrentUrl().endsWith("/pages/login");

        //return true;        
    }




}
