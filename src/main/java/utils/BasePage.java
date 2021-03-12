package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class BasePage {
    private static Logger logger;
    private static BasePage basePage;
    static WebDriver driver;
    private WebDriverWait expWait;
    public static final int MIN_WAIT = 5;
    public static final int MEDIUM_WAIT = 10;
    public static final int LONG_WAIT = 30;
    public static final int PAGE_LOAD_TIMEOUT = 60;
    public static final int POLLING = 2;


    public BasePage() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            logger = LogManager.getLogger(BasePage.class);
        }

    }

    // This method returns the driver value
    public static WebDriver getDriver() {
        return driver;
    }

    // This method set up the driver
    public static void setUpDriver() {
        if (basePage == null) {
            basePage = new BasePage();
        }
    }

    // This method is to tear down the driver after execution
    public static void tearDownDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        driver = null;
    }

    //Set Explicit Wait
    public WebDriverWait explicitWait(long seconds) {
        this.expWait = new WebDriverWait(driver, seconds);
        return expWait;
    }

    //Set Fluent Wait
    public Wait<WebDriver> fluentWait() {
        Wait<WebDriver> fluWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(LONG_WAIT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .ignoring(org.openqa.selenium.WebDriverException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        return fluWait;
    }

    private WebElement fWait(By locator) {
        WebElement webElement = null;
        try {
            webElement = fluentWait().until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    WebElement element = driver.findElement(locator);
                    return element;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        return webElement;
    }


    //This method is to open web page
    public void navigateToUrl(String url) {
        logger.info("The URL is:: " + url);
        driver.get(url);
        letMeFinishLoading();
    }

    // Sync logic for page load
    public void letMeFinishLoading() {
        long startTime = System.currentTimeMillis(), endTime;
        try {
            fluentWait().until(driver1 -> {
                String state;
                state = String.valueOf((executeJavaScript(
                        "try{return document.readyState;}catch(exception){return\"loading\";}")));
                logger.info("Current State Of Page Is : " + state);
                return state.equals("complete");
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        endTime = System.currentTimeMillis();
        logger.info("This page took :: " + (endTime - startTime) + "ms.");

    }

    // Execute JavaScript
    public Object executeJavaScript(String script) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        return jsExec.executeScript(script);
    }

    // This method is to wait until element visible
    public WebElement getVisibleElement(By locator) {
        logger.info("Get Visible Element");
        WebElement element = explicitWait(10).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    // This method is to wait until element is displayed and enabled
    public WebElement getElementDisplayedAndEnabled(By locator) throws Exception {
        WebElement element;
        element = getVisibleElement(locator);
        if (element.isEnabled()) {
            return element;
        } else {
            throw new Exception("Element Not Enabled");
        }
    }

    // This method is to select dropdown by value
    public void selectByValueInDropdown(By locator, String value) {
        try {
            logger.info("Selecting value :: " + value + "  from dropdown.");
            WebElement element = getElementDisplayedAndEnabled(locator);
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    // This method is to select dropdown by index
    public void selectByIndexInDropDown(By locator, int value) {
        try {
            logger.info("Selecting value by index :: " + value + "  from dropdown.");
            WebElement element = getVisibleElement(locator);
            Select select = new Select(element);
            select.selectByIndex(value);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    //Pausing execution for seconds
    public static void pause(int number) {
        try {
            Thread.sleep(1000 * number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // This method is to enter text on element
    public void enterText(String textToBeEntered, By locator) {
        try {
            logger.info("Enter Text :" + textToBeEntered);
            WebElement element = getVisibleElement(locator);
            element.clear();
            element.sendKeys(textToBeEntered);
            pause(1);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());

        }
    }

    // This method is to get text from element
    public String getTextFromElement(By locator) {
        String text = "";
        try {
            logger.info("Get text from element");
            text = driver.findElement(locator).getText().trim();
            logger.info("Text from element is :: " + text);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        return text;
    }

    // This method is to perform click operation on locator
    public void click(By locator) {
        try {
            logger.info("Clicking on object by locator: " + locator);
            WebElement element = getElementDisplayedAndEnabled(locator);
            element.click();
            letMeFinishLoading();
        } catch (Exception e) {
            logger.info("Exception occurred while clicking on object : " + locator);
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }


    // This method is to check is alert displayed on page
    public boolean isAlertPresent() {
        boolean alertFlag = false;
        try {
            driver.switchTo().alert();
            alertFlag = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return alertFlag;
    }

    // This method is to accept the alert
    public void acceptAlert() {
        try {
            logger.info("Accepting alert !!!");
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            logger.info("Cause of Exception:: " + e.getCause());
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    public boolean verifyActualContainsExpected(String actual, String expected) {
        return actual.contains(expected);
    }

    public String randomStringGenerator(int numberOfCharacters) {
        return RandomStringUtils.randomAlphabetic(numberOfCharacters);
    }

    public String randomNumberGenerator(int numberOfCharacters) {
        return RandomStringUtils.randomNumeric(numberOfCharacters);
    }


}
