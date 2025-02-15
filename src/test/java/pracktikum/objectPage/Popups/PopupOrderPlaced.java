package pracktikum.objectPage.Popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupOrderPlaced {

    private WebDriver driver;

    public By popupOrder = By.className("Order_NextButton__1_rCA");



    public PopupOrderPlaced(WebDriver driver){
        this.driver = driver;
    }


}
