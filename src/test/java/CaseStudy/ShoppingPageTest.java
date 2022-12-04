package CaseStudy;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.http.params.AbstractHttpParams;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.ShoppingPage;
import resources.base;

public class ShoppingPageTest  extends base{

public WebDriver driver;
	
@Parameters("browser")
@BeforeTest
public void initialize(@Optional("browser") String browser) throws IOException {
		
		driver =initializeDriver(browser);
		Reporter.log("We used Google Chrome Ver 80 for this test");
		}
	
	
	
@Test()
	public void endtoend() throws InterruptedException {


	ShoppingPage  shp = new ShoppingPage(driver);
	
	
	shp.GiyimAksesuarUrunBul();
	shp.SiyahUrun();
	Thread.sleep(3000);
	shp.sepetekleIlerle("test140@gmail.com");
	Thread.sleep(3000);
	shp.AdresOlustur();
	Thread.sleep(3000);
   shp.KaydetveDevamEt();
   Thread.sleep(3000);
   shp.OdemeEkranKontrol();
	
	
	}





@AfterTest
public void closeDriver() throws IOException {
	

		teardown();
	
	

}


}
