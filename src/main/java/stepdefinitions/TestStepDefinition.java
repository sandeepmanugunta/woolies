package stepdefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import steps.TestSteps;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TestStepDefinition extends BaseSteps {
    WebDriver driver;
    int statusCode;
    int celsius_temp;
    String bodyAsString;
    int temp;

    TestSteps worklistPage = new TestSteps(driver);

    public TestStepDefinition() throws Exception {
    }

    @Given("^I am on test page$")
    public void iAmOnTestPage() throws Exception {
        worklistPage.testHomePage();
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
    public void iSearchForRequired(String Product) throws Throwable {
        worklistPage.enterSearchItem(Product);
        waitForSeconds(3);
    }

    @Given("^I like to holiday in Sydney$")
    public void iLikeToHolidayInSydney() {

        // Sydney city code is 2147714 as per open weather doc
        int Sydney = 2147714;
        String appid = "0160bd5db93edab14469f8bc86a74207";
    }

    @And("^I only like to holiday on Thursdays$")
    public void iOnlyLikeToHolidayOnThursdays() {
        // identify thursday weather and convert kelvin to celsius
        int thursday_weather = temp - 273;
    }

    @When("^I look up the weather forecast$")
    public void iLookUpTheWeatherForecast() throws JSONException {

        //Looks like issue with appid, So I have used sample url and written the logic.
        Response response = get("https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1");
        ResponseBody body = response.getBody();
        bodyAsString = body.asString();
        System.out.println("response of the url is " + bodyAsString + "\n");
        statusCode = response.getStatusCode();

    }

    @Then("^I receive the weather forecast$")
    public void iReceiveTheWeatherForecast() throws Exception {
        System.out.println("Status code is " + statusCode + "\n" );
        Assert.assertEquals((statusCode), 200 );

        //traverse through json file to find out the values.
        JSONObject json = new JSONObject(bodyAsString);
        String city = json.getJSONObject("city").getString("name");
        System.out.println("city: " + city + "\n");
        JSONArray array = json.getJSONArray("list");
        for (int i = 0; i < 1; i++) {
            int date = array.getJSONObject(i).getInt("dt");
            System.out.println("date: "+date + "\n");
            temp = array.getJSONObject(i).getJSONObject("temp").getInt("day");
            System.out.println("temp " +temp + "\n");
            //temperature is in kelvin, so converted to celsius
            celsius_temp = temp - 273;
            System.out.println("celsius_temp= " +celsius_temp + "\n");

        }

    }

    @And("^the temperature is warmer than required degrees$")
    public void theTemperatureIsWarmerThanRequiredDegrees() {
        if (celsius_temp >= 10) {
            System.out.println("Its a good day for holiday");
        } else
            System.out.println("Not a ideal situation for holiday");
    }
}

