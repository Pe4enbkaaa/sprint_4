package pracktikum.objectPage.Popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupWantPlaceOrder {
    private WebDriver driver;

    public By ButtonDesignOrderYes = By.xpath("//button[text() = 'Да']");

    public PopupWantPlaceOrder(WebDriver driver){
        this.driver = driver;
    }

    public void clickDesignOrderYes(){
        driver.findElement(ButtonDesignOrderYes).click();
    }


}
