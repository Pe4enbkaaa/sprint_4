package com.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {
    private final WebDriver driver;

    private final By whenToBring = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriod = By.className("Dropdown-control");
    private final By colorScooterBlack = By.id("black");
    private final By colorScooterGray = By.id("grey");
    private final By buttonOrder = By.xpath("//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By calendar(String date) {
        return By.xpath("//div[text() = '" + date + "']");
    }

    private By numberOfDays(String numberOfDays) {
        return By.xpath("//div[text() = '" + numberOfDays + "']");
    }

    private void clickWhenToBring() {
        driver.findElement(whenToBring).click();
    }

    private void clickCalendar(String numberDate) {
        driver.findElement(calendar(numberDate)).click();
    }

    private void clickRentalPeriod() {
        driver.findElement(rentalPeriod).click();
    }

    private void clickNumberOfDays(String ofDays) {
        driver.findElement(numberOfDays(ofDays)).click();
    }

    private void clickColorScooterBlack() {
        driver.findElement(colorScooterBlack).click();
    }

    private void clickColorScooterGray() {
        driver.findElement(colorScooterGray).click();
    }

    private void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    public void fillAboutRent(String numberDate, String ofDays,String colorScooter){
        clickWhenToBring();
        clickCalendar(numberDate);
        clickRentalPeriod();
        clickNumberOfDays(ofDays);
        if (colorScooter.equals("black")) {
            clickColorScooterBlack();
        } else if (colorScooter.equals("grey")) {
            clickColorScooterGray();
        }
        clickButtonOrder();
    }


}
