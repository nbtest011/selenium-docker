package com.newtours.tests;

import Test.BaseTest;
import com.newtours.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTests extends BaseTest {

    //private WebDriver driver;
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setupParameters(String noOfPasengers,String expectedPrice){
        this.noOfPassengers = noOfPasengers;
        this.expectedPrice = expectedPrice;

    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium","docker");
        registrationPage.enterUserCredentials("selenium","docker");
        registrationPage.submit();
    }
    @Test (dependsOnMethods = "registrationPage")
    public void RegistrationConfirmationPage(){
        RegistrationConfirmationPage registraionConfirmationPage = new RegistrationConfirmationPage(driver);
        registraionConfirmationPage.goToFlightDetailsPage();
    }
    @Test (dependsOnMethods = "RegistrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFlngFlightPage();
    }
    @Test (dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlight();
        findFlightPage.goToFlightConfirmationPage();
    }
    @Test (dependsOnMethods = "findFlightPage")
    public void flightConfirmationPAge(){
        FlightConfirmationPage flightConfirmationPAge = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPAge.getPrice();
        Assert.assertEquals(actualPrice,expectedPrice);
    }

   /* @AfterTest
    public void tearDown(){
        this.driver.quit();
    }*/

}
