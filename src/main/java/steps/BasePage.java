package steps;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage{
	private static final int ELEMENT_WAIT_TIMEOUT_IN_SECONDS = 5;

	private static final int PAGE_WAIT_TIMEOUT_IN_SECONDS = 60;
	public WebDriver driver;



	public BasePage(WebDriver driver) throws Exception {
		System.setProperty("webdriver.chrome.driver","/Users/sandeepmanugunta/Desktop/woolies/drivers/mac/chromedriver");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver = driver;

	}

	public boolean isElementPresent(final By by) {
		return this.driver.findElements(by).size() > 0;
	}

	public boolean isElementPresent(final WebElement element) {
		try {
			element.getTagName();
		} catch (final NoSuchElementException ignored) {
			return false;
		} catch (final StaleElementReferenceException ignored) {
			return false;
		}
		return true;
	}

	public boolean isElementVisible(final By by) {
		return this.driver.findElement(by).isDisplayed();
	}

	public boolean isElementEnabled(final By by) {
		return this.driver.findElement(by).isEnabled();
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean isElementVisible(final WebElement element) {
		return element.isDisplayed();
	}


	public void waitForElement(final WebElement element) {
		this.waitForElement(element, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
	}

	public void waitForElement(final WebElement element, final int timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElement(final By by) {
		waitForElement(by, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
	}

	public void waitForElement(final By by, final int timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementIsInvisible(final By by) {
		final WebDriverWait wait = new WebDriverWait(this.driver, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForTextToAppear(final String textToAppear, final WebElement element) {
		final WebDriverWait wait = new WebDriverWait(this.driver, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
		wait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));
	}

	public void waitForUrlPart(final String urlPart) {
		final WebDriverWait wait = new WebDriverWait(this.driver, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
		wait.until(ExpectedConditions.urlContains(urlPart));
	}

	public void waitForPageLoad() {
		waitForPageLoad(PAGE_WAIT_TIMEOUT_IN_SECONDS);
	}

	public void waitForPageLoad(final int timeoutInSeconds) {
		waitForElement(By.tagName("html"), timeoutInSeconds);
	}

	public String xpathFinder(final String... xpathList) {
		for (final String xpath : xpathList) {
			if (isElementPresent(By.xpath(xpath))) {
				return xpath;
			}
		}
		return null;
	}

	public void mouseover(final By by) {
		final WebElement element = this.driver.findElement(by);
		final Actions builder = new Actions(this.driver);
		final Action mouseover = builder.moveToElement(element).build();
		mouseover.perform();
	}

	public void doubleClick(WebElement element) {
		final Actions builder = new Actions(this.driver);
		final Action doubleClick = builder.doubleClick(element).build();
		doubleClick.perform();
	}

	public void mouseover(final WebElement element) {
		final Actions builder = new Actions(this.driver);
		final Action mouseover = builder.moveToElement(element).build();
		mouseover.perform();
	}

	public void moveToElement(final By by) {
		mouseover(by);
	}

	public void moveToElement(final WebElement element) {
		mouseover(element);
	}

	public void waitAndMoveToElement(final WebElement element) {
		waitForElement(element);
		moveToElement(element);
	}

	public void waitAndMoveToElement(final By by) {
		waitForElement(by);
		moveToElement(by);
	}

	public void dragAndDrop(final By by, final int xOffset, final int yOffset) {
		final WebElement ele = this.driver.findElement(by);
		final Actions builder = new Actions(this.driver);
		final Action dragAndDrop = builder.clickAndHold(ele).moveByOffset(xOffset, yOffset).release().build();
		dragAndDrop.perform();
	}

	public void dragAndDrop(final WebElement element, final int xOffset, final int yOffset) {
		final Actions builder = new Actions(this.driver);
		final Action dragAndDrop = builder.clickAndHold(element).moveByOffset(xOffset, yOffset).release().build();
		dragAndDrop.perform();
	}

	public void switchWindow(final String url) {

		String currentHandle = null;
		final Set<String> handles = this.driver.getWindowHandles();
		if (handles.size() > 1) {
			currentHandle = this.driver.getWindowHandle();
		}
		if (currentHandle != null) {
			for (final String handle : handles) {
				this.driver.switchTo().window(handle);
				if (this.driver.getCurrentUrl().contains(url) && !currentHandle.equals(handle)) {
					break;
				}
			}
		} else {
			for (final String handle : handles) {
				this.driver.switchTo().window(handle);
				if (this.driver.getCurrentUrl().contains(url)) {
					break;
				}
			}
		}
	}


    public void switchToFrame( String frame) {
        this.driver.switchTo().frame(frame);
    }

	public String getCurrentWindow(){
		return this.driver.getWindowHandle();
	}

	public boolean isReadonly(final By by) {
		return Boolean.parseBoolean(this.driver.findElement(by).getAttribute("readonly"));
	}

	public boolean isReadonly(final WebElement element) {
		return Boolean.parseBoolean(element.getAttribute("readonly"));
	}

	public Point getElementPosition(final WebElement element) {
		return element.getLocation();
	}

	public int getElementPositionX(final WebElement element) {
		final Point pos = getElementPosition(element);
		return pos.getX();
	}

	public int getElementPositionY(final WebElement element) {
		final Point pos = getElementPosition(element);
		return pos.getY();
	}

	public void backSpaceInputClear(final WebElement element) {
		final int numberOfCharacters = element.getAttribute("value").length();
		for (int i = 0; i <= numberOfCharacters; i++) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	public void backSpaceInputClear(final WebElement element, final int numberOfCharacters) {
		for (int i = 0; i <= numberOfCharacters; i++) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	public void scroll(final int x, final int y) {
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		for (int i = 0; i <= x; i = i + 50) {
			js.executeScript("scroll(" + i + ",0)");
		}
		for (int j = 0; j <= y; j = j + 50) {
			js.executeScript("scroll(0," + j + ")");
		}
	}

	public JavascriptExecutor highlightElementPermanently(final WebElement element) {
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		return js;
	}

	public void highlightElement(final WebElement element) {
		final String originalStyle = element.getAttribute("style");
		final JavascriptExecutor js = highlightElementPermanently(element);
		// TestUtils.sleep(3000);
		js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
	}

	public void zoomPlus() {
		Actions actions = new Actions(this.driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.ADD).perform();
		actions = new Actions(this.driver);
		actions.keyUp(Keys.CONTROL).perform();
	}

	public void zoomMinus() {
		Actions actions = new Actions(this.driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).perform();
		actions = new Actions(this.driver);
		actions.keyUp(Keys.CONTROL).perform();
	}


	public boolean isAlertPresent() {
		try {
			final Alert alert = this.driver.switchTo().alert();
			alert.getText();
		} catch (final NoAlertPresentException nape) {
			return false;
		}
		return true;
	}

	public String getAlertText() {
		final Alert alert = this.driver.switchTo().alert();
		return alert.getText();
	}

	public void acceptAlert() {
		final Alert alert = this.driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		final Alert alert = this.driver.switchTo().alert();
		alert.dismiss();
	}

	public WebElement getElement(By by){
		try{
		return this.driver.findElement(by);}catch ( Exception e){
			return null;
		}
	}


	public List<WebElement> getElements(By by){
		return this.driver.findElements(by);
	}

	public String getTextOfElement ( WebElement element){
		return element.getText();
	}
}
