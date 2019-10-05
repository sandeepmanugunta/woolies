package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class TestSteps extends BasePage {

    public TestSteps(WebDriver driver) throws Exception {
        super(driver);
      }


    public WebElement getSearch()  {

        By Search = By.cssSelector("input[id='search_query_top']");
        waitForElement(Search, 10);
        return getElement(Search);
    }

    public void enterSearchItem(String Product) {
        if (getSearch() != null) {
            getSearch().clear();
            getSearch().sendKeys(Product);
            getSearch().submit();
        }

        else
            Assert.fail("Search element is not available on Page");
    }

    public List<WebElement> getProduct()  {



        By Product = By.cssSelector("div[class='product-container']");
        waitForElement(Product, 10);
        return getElements(Product);
    }


    public void selectFirstProduct(){

        if (getProduct() != null)
            getProduct().get(0).click();

        else
            Assert.fail("Product element is not available on Page");

    }

    public void selectSecondProduct(){

        if (getProduct() != null)
            getProduct().get(0).click();

        else
            Assert.fail("Product element is not available on Page");

    }

    public WebElement getAddToCart()  {

        By AddToCart = By.cssSelector("p[id='add_to_cart']");
        waitForElement(AddToCart, 20);
        return getElement(AddToCart);
    }

    public void clickAddToCart(){

        if (getAddToCart() != null)
            getAddToCart().click();

        else
            Assert.fail("AddToCard element is not available on Page");

    }

    public List<WebElement> getCheckout()  {

        By Checkout = By.cssSelector("a[title='Proceed to checkout']");
        waitForElement(Checkout, 10);
        return getElements(Checkout);
    }

    public void clickCheckout(){

        if (getCheckout() != null)
            getCheckout().get(0).click();

        else
            Assert.fail("Checkout element is not available on Page");

    }

    public void ebayHomePage() throws Exception {
        driver.get("https://www.ebay.com.au");
    }

    public void phpTravelPage() throws Exception {
        driver.get("http://www.phptravels.net");
    }

    public WebElement getFrontend()  {

        By Frontend = By.cssSelector("a[href='//www.phptravels.net']");
        waitForElement(Frontend, 10);
        return getElement(Frontend);
    }

    public void clickFrontend(){

        if (getFrontend() != null)
            getFrontend().click();

        else
            Assert.fail("Frontend element is not available on Page");

    }

    public WebElement getLocation()  {

        By Location = By.xpath("//span[contains(text(),'Search by Hotel or City Name')]//ancestor::a[@class='select2-choice']");
        waitForElement(Location, 10);
        return getElement(Location);
    }

    public void enterLocation() throws InterruptedException {
        if (getLocation() != null) {
            Thread.sleep(1000);
            getLocation().sendKeys("Singapore");
            getLocation().submit();
        }

        else
            Assert.fail("Search element is not available on Page");
    }

    public WebElement getHotelCheckIn()  {

        By HotelCheckIn = By.name("checkin");
        waitForElement(HotelCheckIn, 10);
        return getElement(HotelCheckIn);
    }

    public void setHotelCheckIn() {
        if (getHotelCheckIn() != null) {
            getHotelCheckIn().clear();
            getHotelCheckIn().sendKeys("17/04/2019");
        }

        else
            Assert.fail("HotelCheckIn element is not available on Page");
    }


    public WebElement getTourCheckIn()  {

        By TourCheckIn = By.name("date");
        waitForElement(TourCheckIn, 10);
        return getElement(TourCheckIn);
    }

    public void setTourCheckIn() {
        if (getTourCheckIn() != null) {
            getTourCheckIn().clear();
            getTourCheckIn().sendKeys("17/04/2019");
        }

        else
            Assert.fail("TourCheckIn element is not available on Page");
    }

    public WebElement getCheckOut()  {

        By CheckOut = By.name("checkout");
        waitForElement(CheckOut, 10);
        return getElement(CheckOut);
    }

    public void setCheckOut() {
        if (getCheckOut() != null) {
            getCheckOut().clear();
            getCheckOut().sendKeys("18/04/2019");
        }

        else
            Assert.fail("CheckOut element is not available on Page");
    }

    public WebElement getPAX()  {

        By CheckOut = By.id("travellersInput");
        waitForElement(CheckOut, 10);
        return getElement(CheckOut);
    }


    public void enterPAX() {
        if (getPAX() != null) {
            getPAX().clear();
            getPAX().sendKeys("1 Adult 0 Child");
        }

        else
            Assert.fail("PAX element is not available on Page");
    }


    public List<WebElement> getSearchButton()  {

        By SearchButton = By.xpath("//button[contains(text(),'Search')]");
        waitForElement(SearchButton, 10);
        return getElements(SearchButton);
    }

    public void clickHotelSearch() {
        if (getSearchButton() != null)
            getSearchButton().get(0).click();

        else
            Assert.fail("Search element is not available on Page");
    }


    public WebElement getTourSearchButton()  {

        By TourSearchButton = By.xpath("(//button[contains(text(),'Search')])[2]");
        waitForElement(TourSearchButton, 10);
        return getElement(TourSearchButton);
    }

    public void clickTourSearch() {
        if (getTourSearchButton() != null)
            getTourSearchButton().click();

        else
            Assert.fail("TourSearchButton element is not available on Page");
    }


    public WebElement getFlightSearchButton()  {

        By FlightSearchButton = By.xpath("//button[contains(text(),' Search  ')]");
        waitForElement(FlightSearchButton, 10);
        return getElement(FlightSearchButton);
    }
    public void clickFlightSearch() {

        if (getFlightSearchButton() != null)
            getFlightSearchButton().click();

        else
            Assert.fail("FlightSearch element is not available on Page");
    }

    public WebElement getDetails()  {

        By Details = By.xpath("(//button[contains(text(),'Details')])[2]");
        waitForElement(Details, 10);
        return getElement(Details);
    }

    public void clickDetails() throws InterruptedException {
        if (getDetails() != null) {
            getDetails().click();
        }

        else
            Assert.fail("Details element is not available on Page");
    }

    public WebElement getAdults()  {

        By Adults = By.id("adults");
        waitForElement(Adults, 10);
        return getElement(Adults);
    }


    public void enterAdults() {
        if (getAdults() != null) {
            Select Adults = new Select(getAdults());
            Adults.selectByValue("1");
        }

        else
            Assert.fail("Adults element is not available on Page");
    }

    public WebElement getchild()  {

        By child = By.id("child");
        waitForElement(child, 10);
        return getElement(child);
    }

    public void enterchild() {
        if (getchild() != null) {
            Select child = new Select(getAdults());
            child.selectByValue("1");
        }

        else
            Assert.fail("child element is not available on Page");
    }

    public List<WebElement> getRoom()  {

        By Room = By.cssSelector("div[class='control__indicator']");
        waitForElement(Room, 10);
        return getElements(Room);
    }

    public void selectRoom() {
        if (getRoom() != null)
            getRoom().get(0).click();

        else
            Assert.fail("room element is not available on Page");
    }

    public WebElement getBookNow()  {

        By BookNow = By.xpath("//button[contains(text(),'Book Now')]");
        waitForElement(BookNow, 10);
        return getElement(BookNow);
    }

    public void selectBookNow() {
        if (getBookNow() != null)
            getBookNow().click();

        else
            Assert.fail("BookNow element is not available on Page");
    }

    public List<WebElement> getFlightBookNow()  {

        By FlightBookNow = By.xpath("//button[contains(text(),'Book Now')]");
        waitForElement(FlightBookNow, 10);
        return getElements(FlightBookNow);
    }

    public void selectFlightBookNow() {
        if (getFlightBookNow() != null)
            getFlightBookNow().get(0).click();

        else
            Assert.fail("FlightBookNow element is not available on Page");
    }



    public WebElement getTours()  {

        By Tours = By.xpath("//span[contains(text(),'Tours')]");
        waitForElement(Tours, 10);
        return getElement(Tours);
    }

    public void clickTours() {
        if (getTours() != null)
            getTours().click();


        else
            Assert.fail("Tour element is not available on Page");
    }

    public WebElement getFlights()  {

        By Flights = By.xpath("//span[contains(text(),'Flights')]");
        waitForElement(Flights, 10);
        return getElement(Flights);
    }

    public void clickFlights() {
        if (getFlights() != null)
            getFlights().click();

        else
            Assert.fail("Flights element is not available on Page");
    }

    public List<WebElement> getFrom()  {

        By From = By.xpath("//span[contains(text(),'Enter City Or Airport')]");
        waitForElement(From, 10);
        return getElements(From);
    }

    public void setFrom() {
        if (getFrom() != null) {
            getFrom().get(0).click();
            getFrom().get(0).sendKeys("sydney");
            getFrom().get(0).submit();
        }

        else
            Assert.fail("From element is not available on Page");
    }

    public void setTo() {
        if (getFrom() != null){
            getFrom().get(1).click();
            getFrom().get(1).sendKeys("melbourne");
            getFrom().get(1).submit();
        }


        else
            Assert.fail("To element is not available on Page");
    }

    public WebElement getDepartureDate()  {

        By DepartureDate = By.xpath("/html/body/div[15]/div[1]/table/tbody/tr[3]/td[4]");
        waitForElement(DepartureDate, 10);
        return getElement(DepartureDate);
    }

    public void setDepartureDate() {
        driver.findElement(By.name("departure")).click();
        if (getDepartureDate() != null)
            getDepartureDate().click();

        else
            Assert.fail("DepartureDate element is not available on Page");
    }

    public WebElement getArrivalDate()  {

        By ArrivalDate = By.id("departure");
        waitForElement(ArrivalDate, 10);
        return getElement(ArrivalDate);
    }

    public void setArrivalDate() {
        if (getArrivalDate() != null)
            getArrivalDate().sendKeys("18/04/2019");

        else
            Assert.fail("ArrivalDate element is not available on Page");
    }





    public WebElement getGuests()  {

        By Guests = By.id("adults");
        waitForElement(Guests, 10);
        return getElement(Guests);
    }

    public void enterGuests() {
        if (getGuests() != null) {
            Select Guests = new Select(getGuests());
            Guests.selectByValue("1");
        }

        else
            Assert.fail("Guests element is not available on Page");
    }

    public WebElement getTourtype()  {

        By Tourtype = By.id("tourtype");
        waitForElement(Tourtype, 10);
        return getElement(Tourtype);
    }

    public void enterTourtype() {
        if (getTourtype() != null) {
            Select Tourtype = new Select(getTourtype());
            Tourtype.selectByValue("187");
        }

        else
            Assert.fail("Tourtype element is not available on Page");
    }

    public WebElement getFirstName()  {

        By FirstName = By.name("firstname");
        waitForElement(FirstName, 10);
        return getElement(FirstName);
    }

    public void enterFirstName() {
        if (getFirstName() != null) {
            getFirstName().sendKeys("abc");
        }

        else
            Assert.fail("FirstName element is not available on Page");
    }

    public WebElement getLastName()  {

        By LastName = By.name("lastname");
        waitForElement(LastName, 10);
        return getElement(LastName);
    }

    public void enterLastName() {
        if (getLastName() != null) {
            getLastName().sendKeys("xyz");
        }

        else
            Assert.fail("LastName element is not available on Page");
    }

    public WebElement getEmail()  {

        By Email = By.name("email");
        waitForElement(Email, 10);
        return getElement(Email);
    }

    public void enterEmail() {
        if (getEmail() != null) {
            getEmail().sendKeys("abc@xyz.com");
        }

        else
            Assert.fail("Email element is not available on Page");
    }

    public WebElement getConfirmEmail()  {

        By ConfirmEmail = By.name("confirmemail");
        waitForElement(ConfirmEmail, 10);
        return getElement(ConfirmEmail);
    }

    public void enterConfirmEmail() {
        if (getConfirmEmail() != null) {
            getConfirmEmail().sendKeys("abc@xyz.com");
        }

        else
            Assert.fail("ConfirmEmail element is not available on Page");
    }

    public WebElement getConfirmThisBooking()  {

        By ConfirmThisBooking = By.name("confirmemail");
        waitForElement(ConfirmThisBooking, 10);
        return getElement(ConfirmThisBooking);
    }

    public void enterConfirmThisBooking() {
        if (getConfirmThisBooking() != null) {
            getConfirmThisBooking().click();
        }

        else
            Assert.fail("ConfirmThisBooking element is not available on Page");
    }


    public void testHomePage() throws Exception {
        driver.get("http://automationpractice.com/index.php");
    }
}