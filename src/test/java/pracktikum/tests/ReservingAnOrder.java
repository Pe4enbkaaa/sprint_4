package pracktikum.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pracktikum.objectPage.*;
import pracktikum.objectPage.Popups.PopupWantPlaceOrder;
import pracktikum.objectPage.Popups.PopupOrderPlaced;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
    public class ReservingAnOrder {
        public DriverFactor factory = new DriverFactor();
        private WebDriver driver;
        private final String name;
        private final String UserName;
        private final String addressOrder;
        private final String phoneNumber;
        private final String subway;
        private final String dateCalendar;
        private final String dateNumberOfDays;
        private final String colorScooter;
        public ReservingAnOrder(String name, String UserName, String addressOrder, String phoneNumber, String subway,
                                String dateCalendar, String dateNumberOfDays,String colorScooter){
           this.name = name;
           this.UserName = UserName;
           this.addressOrder = addressOrder;
           this.phoneNumber = phoneNumber;
           this.subway = subway;
           this.dateCalendar = dateCalendar;
           this.dateNumberOfDays = dateNumberOfDays;
           this.colorScooter = colorScooter;
       }

       @Parameterized.Parameters
       public static Object[][] getPersonalData(){
           return new Object[][]{
                   {"Петя", "Пупкин", "Зверева 12", "89112739646", "3",
                   "15", "трое суток", "black"},
                   {"Вася", "Сидоров", "Зверева 16", "89118329646", "6",
                           "15", "трое суток", "grey"},
           };
       }



        @Before
        public void initDrive() throws Exception {

            factory.initDriver();

        }

        @Test
        public void openMainPage() throws Exception {

            WebDriver driver = factory.getDriver();
            PageMain objMainPage = new PageMain(driver);
            PagePersonalData objPersonalData = new PagePersonalData(driver);
            PageAboutRent objPageAboutRent = new PageAboutRent(driver);
            PopupOrderPlaced objPopupOrderPlaced = new PopupOrderPlaced(driver);
            PopupWantPlaceOrder objPopupWantPlaceOrder = new PopupWantPlaceOrder(driver);

            objMainPage.getWebOpen();
            Thread.sleep(1_000);

            objMainPage.closeButterCookie();
            Thread.sleep(1_000);

            objMainPage.ClickButterOrder();
            Thread.sleep(1_000);

            objPersonalData.enteringName(name);

            objPersonalData.enteringSurname(UserName);
            objPersonalData.enteringAddress(addressOrder);
            objPersonalData.enteringPhoneNumber(phoneNumber);
            objPersonalData.clickFieldSubway();
            objPersonalData.clickSubway(subway);
            new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.elementToBeClickable(objPersonalData.buttonNext));

            objPersonalData.clickButtonName();
            Thread.sleep(1_000);

            objPageAboutRent.clickWhenToBring();
            objPageAboutRent.clickCalendar(dateCalendar);
            objPageAboutRent.clickRentalPeriod();
            objPageAboutRent.clickNumberOfDays(dateNumberOfDays);

            if(colorScooter.equals("black")){
                objPageAboutRent.clickColorScooterBlack();
            }else if(colorScooter.equals("gray")){
                objPageAboutRent.clickColorScooterGray();
            }

            objPageAboutRent.clickButtonOrder();

          new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(objPopupWantPlaceOrder.ButtonDesignOrderYes));


            objPopupWantPlaceOrder.clickDesignOrderYes();



            assertTrue("Не получилось оформить заказ",driver.findElement(objPopupOrderPlaced.popupOrder).isDisplayed());




        }

        @After
        public void tearDown() {
            factory.getDriver().quit();
        }
    }

