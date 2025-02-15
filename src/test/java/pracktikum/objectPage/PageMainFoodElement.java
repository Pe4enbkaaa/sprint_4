package pracktikum.objectPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PageMainFoodElement {
    private WebDriver driver;
    public By numberTextQuestion(String number){
        return By.id("accordion__heading-" + number);
    }

    public By numberTextAnswer(String number){
        return By.id("accordion__panel-" + number);
    }

    public PageMainFoodElement(WebDriver driver){
        this.driver = driver;
    }

    public void questionFoodClick(String number){
        driver.findElement(numberTextQuestion(number)).click();
    }

    public void scrollToQuestion(String number){
        WebElement element = driver.findElement(numberTextQuestion(number));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    public String getTextQuestion (String number){
        return driver.findElement(numberTextQuestion(number)).getText();
    }
    public String getTextAnswer (String number){
       return driver.findElement(numberTextAnswer(number)).getText();
    }
    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
