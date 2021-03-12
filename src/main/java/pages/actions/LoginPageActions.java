package pages.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.BasePage;

public class LoginPageActions extends BasePage {
    private Logger logger;
    private By inputUsername;
    private By inputPassword;
    private By optionRegistrationDesk;
    private By buttonLogin;

    public LoginPageActions() {
        super();
        initElement();
    }

    public void initElement() {
        logger = LogManager.getLogger(HomePageActions.class);
        inputUsername = By.xpath("//input[@id='username']");
        inputPassword = By.xpath("//input[@id='password']");
        optionRegistrationDesk = By.xpath("//li[@id='Registration Desk']");
        buttonLogin = By.xpath("//input[@id='loginButton']");

    }

    //This method open the application
    public void navigateToApplication(String url) {
        logger.info("Navigating to application.");
        navigateToUrl(url);
    }

    //This method is to enter username on login page
    public void enterUsername(String username) {
        logger.info("Entering user name on login page.");
        enterText(username, inputUsername);
    }

    //This method is to enter password on login page
    public void enterPassword(String password) {
        logger.info("Entering user name on login page.");
        enterText(password, inputPassword);
    }

    //This method is to select the Registration Desk option on login page
    public void selectRegistrationDeskOption() {
        logger.info("Selecting Registration Desk option on login page.");
        click(optionRegistrationDesk);
    }

    //This method is to click Login button
    public void clickLoginButton() {
        logger.info("Clicking Login button");
        click(buttonLogin);
    }


}
