package stepdefinitions;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseSteps {


	public void waitForSeconds(int waitSeconds){
		try {
			Thread.sleep(waitSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

}
