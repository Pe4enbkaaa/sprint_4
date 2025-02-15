package pracktikum.objectPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageAboutRent {
    private final WebDriver driver;

    private final By WhenToBring = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    private By calendar(String date){
        return By.xpath("//div[text() = '" + date + "']");
    }

    private final By RentalPeriod = By.className("Dropdown-control");

    private By numberOfDays(String numberOfDays){
        return By.xpath("//div[text() = '" + numberOfDays + "']");
    }

    private final By colorScooterBlack = By.id("black");
    private final By colorScooterGray = By.id("grey");

    private final By buttonOrder = By.xpath("//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    
    public PageAboutRent(WebDriver driver){
        this.driver = driver;
    }

    public void clickWhenToBring(){
        driver.findElement(WhenToBring).click();
    }

    public void clickCalendar(String numberDate){
        driver.findElement(calendar(numberDate)).click();
    }

    public void clickRentalPeriod(){
        driver.findElement(RentalPeriod).click();
    }
    public void clickNumberOfDays(String ofDays){
        driver.findElement(numberOfDays(ofDays)).click();
    }

    public void clickColorScooterBlack(){
        driver.findElement(colorScooterBlack).click();
    }

    public void clickColorScooterGray(){
        driver.findElement(colorScooterGray).click();
    }

    public void clickButtonOrder(){
        driver.findElement(buttonOrder).click();
    }

}
