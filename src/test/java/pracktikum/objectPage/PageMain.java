package pracktikum.objectPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageMain {

   private WebDriver driver;

   private final By butterCookie = By.id("rcc-confirm-button");

   private String Web = "https://qa-scooter.praktikum-services.ru/";

   private By butterOrder = By.className("Button_Button__ra12g");

    public PageMain(WebDriver driver){
        this.driver = driver;
    }
    public void ClickButterOrder(){
        driver.findElement(butterOrder).click();
    }

    public void getWebOpen(){
        driver.get(Web);
    }
  public void closeButterCookie(){
     driver.findElement(butterCookie).click();
    }
}
