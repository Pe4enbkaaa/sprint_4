package com.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainFoodElementPage {
    private final WebDriver driver;

    public MainFoodElementPage(WebDriver driver) {
        this.driver = driver;
    }

    public By numberTextQuestion(String number) {
        return By.id("accordion__heading-" + number);
    }

    public By numberTextAnswer(String number) {
        return By.id("accordion__panel-" + number);
    }

    public String getTextQuestion(String number) {
        return driver.findElement(numberTextQuestion(number)).getText();
    }

    public String getTextAnswer(String number) {
        return driver.findElement(numberTextAnswer(number)).getText();
    }

    public void clickQuestionFood(String number) {
        driver.findElement(numberTextQuestion(number)).click();
    }

    public void scrollToQuestion(String number) {
        WebElement element = driver.findElement(numberTextQuestion(number));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }

}
