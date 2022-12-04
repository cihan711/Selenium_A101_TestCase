package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.w3c.dom.UserDataHandler;

import io.github.bonigarcia.wdm.WebDriverManager;


public class base {
	
	public static WebDriver driver;
	public Properties prop;
	public JavascriptExecutor js;

	public WebDriver initializeDriver(String testBrowser) throws IOException {
	
	ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--ignore-certifcate-errors");   // ssl sertifika hatası yok sayma
    chromeOptions.addArguments("--disable-popup-blocking");  //pop-up bloklaması
    chromeOptions.addArguments("--disable-gpu");  //
    chromeOptions.addArguments("--start-maximized"); // full screen browser
    chromeOptions.addArguments("--disable-plugins"); //chrome pluginler , driver bazlı pluginler durdurulur
    chromeOptions.addArguments("--disable-plugins-discovery");   //flash dahil tüm pluginler durdurulur
    chromeOptions.addArguments("--disable-preconnect");   //google ın dns çözümlemesi nedeniyle oluşabilecek performans düşüklüğünü engeller
    chromeOptions.addArguments("--disable-notifications");   // bildirimleri engeller
    chromeOptions.addArguments("'--dns-prefetch-disable'");   //search bara girilen anahtar kelimenin doğuracağı sonuçları chromeun arka planda yüklemesini engellemek için
    
    chromeOptions.setAcceptInsecureCerts(true);
    chromeOptions.addArguments("test-type");
	

	prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//data.properties");
	prop.load(fis);
	
	
	
	String urlAdress = prop.getProperty("url");
	System.out.println(urlAdress);
	
	
	try {
		driver.findElement(By.className("closePopupPersona")).click();
		
	} catch (Exception e) {
		
	}
	
	

	
	switch (testBrowser) {
		
	 case "grid-firefox": {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
        driver.get(urlAdress);
        System.out.println("***** Selenium Grid Firefox *****");
        break;
    }
    case "grid-chrome": {
        
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        driver.get(urlAdress);
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        System.out.println("***** Selenium Grid Chrome *****");
        break;
    }
   
   case "firefox": {
       FirefoxOptions firefoxOptions = new FirefoxOptions();
       firefoxOptions.addArguments("start-maximized");
       driver = new FirefoxDriver(firefoxOptions);
       driver.get(urlAdress);
       System.out.println("***** Browser is firefox *****");
       break;
   }
   case "firefox-headless": {
       FirefoxOptions firefoxOptions = new FirefoxOptions();
       firefoxOptions.addArguments("start-maximized");
       firefoxOptions.addArguments("--headless");
       driver = new FirefoxDriver(firefoxOptions);
       driver.get(urlAdress);
       System.out.println("***** Browser is firefox *****");
       break;
   }
   case "chrome": {
       
   	
    driver= new ChromeDriver(chromeOptions);
   //	driver.manage().window().maximize();
   //	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
   	driver.get(urlAdress);
   //	driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
       System.out.println("***** Browser is chrome *****");
       break;
   }
   case "chrome-headless": {
   	//System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");  
       chromeOptions.addArguments("--headless");
       driver = new ChromeDriver(chromeOptions);
       driver.get(urlAdress);
       System.out.println("***** Browser is chrome-headless *****");
       break;
   }
   
   default: {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver(chromeOptions);
      // driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
       driver.get(urlAdress);
   //	driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
       System.out.println("***** Browser is chrome-bonigarcia *****");
       break;
	
}
	
	}
  	driver.manage().window().maximize();
   	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
   	driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
	js = (JavascriptExecutor) driver;
	
	return driver;
	}
	
	public  static  void teardown()
    {
        driver.quit();
    }
	
}

	
	 

