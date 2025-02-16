package com.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final By butterCookie = By.id("rcc-confirm-button");
    private final String web = "https://qa-scooter.praktikum-services.ru/";
    private final By butterOrderHeader = By.xpath("//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    private final By butterOrderBody = By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/button[text() = 'Заказать']");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButterOrderHeader() {
        driver.findElement(butterOrderHeader).click();
    }

    public void clickButterOrderBody() {
        driver.findElement(butterOrderBody).click();
    }

    public void getWebOpen() {
        driver.get(web);
    }

    public void clickButterCookie() {
        driver.findElement(butterCookie).click();
    }

    public void scrollToButterOrderBody() {
        WebElement element = driver.findElement(butterOrderBody);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }
}
