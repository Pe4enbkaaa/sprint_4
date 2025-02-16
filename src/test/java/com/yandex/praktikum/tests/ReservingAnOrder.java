package com.yandex.praktikum.tests;

import com.yandex.praktikum.page.AboutRentPage;
import com.yandex.praktikum.page.DriverRule;
import com.yandex.praktikum.page.MainPage;
import com.yandex.praktikum.page.PersonalDataPage;
import com.yandex.praktikum.popups.OrderPlacedPopup;
import com.yandex.praktikum.popups.WantPlaceOrderPopup;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class ReservingAnOrder {
    private final String name;
    private final String UserName;
    private final String addressOrder;
    private final String phoneNumber;
    private final String subway;
    private final String dateCalendar;
    private final String dateNumberOfDays;
    private final String colorScooter;
    private final String placeButterOrder;
    private WebDriver driver;

    public ReservingAnOrder(String name, String UserName, String addressOrder, String phoneNumber, String subway,
                            String dateCalendar, String dateNumberOfDays, String placeButterOrder,String colorScooter) {
        this.name = name;
        this.UserName = UserName;
        this.addressOrder = addressOrder;
        this.phoneNumber = phoneNumber;
        this.subway = subway;
        this.dateCalendar = dateCalendar;
        this.dateNumberOfDays = dateNumberOfDays;
        this.placeButterOrder = placeButterOrder;
        this.colorScooter = colorScooter;
    }

    @Parameterized.Parameters
    public static Object[][] getPersonalData() {
        return new Object[][]{
                {"Петя", "Пупкин", "Зверева 12", "89112739646", "3",
                        "15", "трое суток","Header","black"},
                {"Вася", "Сидоров", "Зверева 16", "89118329646", "6",
                        "15", "трое суток","Body","grey"},
        };
    }

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void openMainPage() throws Exception {

        WebDriver driver = factory.getDriver();
        MainPage objMainPage = new MainPage(driver);
        PersonalDataPage objPersonalData = new PersonalDataPage(driver);
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);
        OrderPlacedPopup objOrderPlacedPopup = new OrderPlacedPopup(driver);
        WantPlaceOrderPopup objWantPlaceOrderPopup = new WantPlaceOrderPopup(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        objMainPage.getWebOpen();

        objMainPage.clickButterCookie();

        if(placeButterOrder.equals("Header")){
            objMainPage.clickButterOrderHeader();
        }else if(placeButterOrder.equals("Body")) {
            objMainPage.scrollToButterOrderBody();
            objMainPage.clickButterOrderBody();
        }

        objPersonalData.fillPersonalData(name,UserName, addressOrder, phoneNumber,subway);

        objAboutRentPage.fillAboutRent(dateCalendar, dateNumberOfDays,colorScooter);

        objWantPlaceOrderPopup.clickDesignOrderYes();

        assertTrue("Не получилось оформить заказ", driver.findElement(objOrderPlacedPopup.popupOrder).isDisplayed());


    }

}

