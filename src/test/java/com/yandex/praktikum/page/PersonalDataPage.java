package com.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalDataPage {
    private final WebDriver driver;

    private final By namePersonal = By.xpath("//input[@placeholder='* Имя']");
    private final By surnamePersonal = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressDeliver = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By stationSubway = By.className("select-search__input");
    private final By phoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    public By buttonNext = By.className("Button_Middle__1CSJM");

    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public By subwayListon(String number) {
        return By.xpath("//li[@data-index = '" + number + "']");
    }

    public void enteringName(String username) {
        driver.findElement(namePersonal).sendKeys(username);
    }

    public void enteringSurname(String surname) {
        driver.findElement(surnamePersonal).sendKeys(surname);
    }

    public void enteringAddress(String address) {
        driver.findElement(addressDeliver).sendKeys(address);
    }

    public void enteringPhoneNumber(String phone) {
        driver.findElement(phoneNumber).sendKeys(phone);
    }

    public void clickFieldSubway() {
        driver.findElement(stationSubway).click();
    }

    public void clickSubway(String numberSubway) {
        driver.findElement(subwayListon(numberSubway)).click();
    }

    public void clickButtonName() {
        driver.findElement(buttonNext).click();
    }

    public void fillPersonalData(String username,String surname, String address, String phone,String numberSubway){
        enteringName(username);
        enteringSurname(surname);
        enteringAddress(address);
        enteringPhoneNumber(phone);
        clickFieldSubway();
        clickSubway(numberSubway);
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(buttonNext));
        clickButtonName();
    }


}
