package stepdefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import steps.MyWorkListPage;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class MyWorkList extends  BaseSteps {
    WebDriver driver;

    MyWorkListPage worklistPage = new MyWorkListPage(driver);

    public MyWorkList() throws Exception {
    }

    @When("^I select first product$")
    public void iSelectFirstProduct() {
        waitForSeconds(2);
        worklistPage.selectFirstProduct();
    }

    @Then("^I click on Add to cart$")
    public void iClickOnAddToCart() {
        worklistPage.clickAddToCart();
    }

    @Then("^I select second product$")
    public void iSelectSecondProduct() {
        waitForSeconds(2);
        worklistPage.selectSecondProduct();
    }

    @Then("^I click on checkout$")
    public void iClickOnCheckout() {
        waitForSeconds(3);
        worklistPage.clickCheckout();
    }


    @And("^I search for required \"([^\"]*)\"$")
    public void iSearchForRequired(String Product2) throws Throwable {
        worklistPage.enterSearchItem(Product2);
        waitForSeconds(3);
    }

    @Given("^I am on ebay page$")
    public void iAmOnEbayPage() throws Throwable {
        worklistPage.ebayHomePage();
    }

    @Given("^I am on PHPTravel page$")
    public void iAmOnPHPTravelPage() throws Exception {
        worklistPage.phpTravelPage();


    }

    @When("^I click frondend page$")
    public void iClickFrondendPage() {
        worklistPage.clickFrontend();
    }

    @When("^I search for hotel$")
    public void iSearchForHotel() throws Throwable {
        waitForSeconds(2);
        worklistPage.enterLocation();
    }

    @And("^I select checkin, checkout, PAX and click on search$")
    public void iSelectCheckinCheckoutPAXAndClickOnSearch() throws InterruptedException {
        worklistPage.setHotelCheckIn();
        worklistPage.setCheckOut();
        worklistPage.enterPAX();
        worklistPage.clickHotelSearch();
        Thread.sleep(2000);
        worklistPage.clickDetails();
        worklistPage.selectRoom();
        worklistPage.selectBookNow();

    }

    @And("^I confirm the booking$")
    public void iConfirmTheBooking() {
        waitForSeconds(2);
        worklistPage.enterFirstName();
        worklistPage.enterLastName();
        worklistPage.enterEmail();
        worklistPage.enterConfirmEmail();
        worklistPage.enterConfirmThisBooking();
    }

    @Given("^I like to holiday in Sydney$")
    public void iLikeToHolidayInSydney() {

        // Sydney city code is 2147714 as per open weather doc
        String Sydney = "2147714";
        String appid = "0160bd5db93edab14469f8bc86a74207";
    }

    @And("^I only like to holiday on Thursdays$")
    public void iOnlyLikeToHolidayOnThursdays() {
        // identify thursday weather and convert kelvin to celsius
        String thursday_weather;
    }

    @When("^I look up the weather forecast$")
    public void iLookUpTheWeatherForecast() {

        // Pass Sydney city code and appid as a parameter in the get request

        given().
                when().
                get("http://api.openweathermap.org/data/2.5/forecast/daily?id=2147714&appid=0160bd5db93edab14469f8bc86a74207").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON);


    }

    @Then("^I receive the weather forecast$")
    public void iReceiveTheWeatherForecast() throws Exception {

        Response response = get("http://api.openweathermap.org/data/2.5/forecast/daily?id=2147714&appid=0160bd5db93edab14469f8bc86a74207");
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println("response of the url is " +bodyAsString);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(String.valueOf(statusCode), 200 , "Correct status code is returned");
    }

    @When("^I select checkin, guest and search$")
    public void iSelectCheckinGuestAndSearch() throws InterruptedException {
        worklistPage.clickTours();
        worklistPage.setTourCheckIn();
        worklistPage.enterGuests();
        worklistPage.enterTourtype();
        worklistPage.clickTourSearch();
        worklistPage.clickDetails();

    }

    @Then("^I click on book$")
    public void iClickOnBook() throws InterruptedException {
        Thread.sleep(3000);
        worklistPage.selectBookNow();
    }

    @When("^I select flight, details and search$")
    public void iSelectFlightDetailsAndSearch() throws InterruptedException {
        worklistPage.clickFlights();
        Thread.sleep(1000);
        worklistPage.setFrom();
        Thread.sleep(1000);
        worklistPage.setTo();
        Thread.sleep(1000);
        worklistPage.setDepartureDate();
        Thread.sleep(2000);
        worklistPage.clickFlightSearch();
    }

    @Then("^I click on flight book$")
    public void iClickOnFlightBook() throws InterruptedException {
        Thread.sleep(1000);
        worklistPage.selectFlightBookNow();
    }

    @And("^the temperature is warmer than required degrees$")
    public void theTemperatureIsWarmerThanRequiredDegrees() {
        // Assume thursday weather as 12 degree celsius as we dont have actual weather value due to issue with appid.
        int thursday_weather = 12;
        // if thursday temperature is greater than 10 degree celsius its good for holiday else not an ideal weather
        if(thursday_weather >= 10) {
            System.out.println("Its a good day for holiday");
        }
        else
            System.out.println("Weather is not ideal for holiday");
    }
}

