package com.yandex.praktikum.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WantPlaceOrderPopup {
    public By buttonDesignOrderYes = By.xpath("//button[text() = 'Да']");
    private final WebDriver driver;

    public WantPlaceOrderPopup(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDesignOrderYes() {
        driver.findElement(buttonDesignOrderYes).click();
    }


}
