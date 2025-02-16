package com.yandex.praktikum.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPlacedPopup {

    public By popupOrder = By.className("Order_NextButton__1_rCA");
    private final WebDriver driver;

    public OrderPlacedPopup(WebDriver driver) {
        this.driver = driver;
    }


}
